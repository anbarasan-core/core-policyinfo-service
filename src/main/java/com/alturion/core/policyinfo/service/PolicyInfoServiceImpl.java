package com.alturion.core.policyinfo.service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.alturion.core.policyinfo.client.PolicyOwnerClient;
import com.alturion.core.policyinfo.domain.PolicyInfo;
import com.alturion.core.policyinfo.domain.PolicyPlan;
import com.alturion.core.policyinfo.dto.PolicyInfoRequestDto;
import com.alturion.core.policyinfo.dto.PolicyInfoResponseDto;
import com.alturion.core.policyinfo.enums.PolicyStatus;
import com.alturion.core.policyinfo.exception.InvalidPremiumAmountException;
import com.alturion.core.policyinfo.exception.PlanNotFoundException;
import com.alturion.core.policyinfo.exception.ResourceNotFoundException;
import com.alturion.core.policyinfo.mapper.PolicyInfoMapper;
import com.alturion.core.policyinfo.repository.PolicyInfoRepository;
import com.alturion.core.policyinfo.repository.PolicyPlanRepository;

@Service
public class PolicyInfoServiceImpl implements PolicyInfoService{
	
	private static final Logger logger = Logger.getLogger(PolicyInfoServiceImpl.class.getName());
	
	private final PolicyOwnerClient policyOwnerClient;
	private final PolicyPlanRepository policyPlanRepository;
	private final PolicyInfoRepository policyInfoRepository;
	private final PolicyInfoMapper policyInfoMapper;
	
	public PolicyInfoServiceImpl(PolicyOwnerClient policyOwnerClient,PolicyPlanRepository policyPlanRepository,PolicyInfoRepository policyInfoRepository,PolicyInfoMapper policyInfoMapper){
		this.policyOwnerClient = policyOwnerClient;
		this.policyPlanRepository = policyPlanRepository;
		this.policyInfoRepository = policyInfoRepository;
		this.policyInfoMapper = policyInfoMapper;
	}

	@Override
	public PolicyInfoResponseDto createPolicy(PolicyInfoRequestDto policyInfoRequestDto) {
		
		logger.info("PolicyInfoServiceImpl::createPolicy");
		policyOwnerClient.validatePolicyOwnerExists(policyInfoRequestDto.getPolicyOwnerId());
		
		PolicyPlan currentPlan = policyPlanRepository.findByPolicyCategoryAndPolicyTier(policyInfoRequestDto.getPolicyCategory(),policyInfoRequestDto.getPolicyTier())
															   .orElseThrow(()-> new PlanNotFoundException("Requested Plan Does Not Match Our Records"));
		BigDecimal currentPremium = policyInfoRequestDto.getPremiumAmount();
		BigDecimal minimumPremium = currentPlan.getPremiumAmount();

		if(currentPremium.compareTo(minimumPremium) < 0) {
		    throw new InvalidPremiumAmountException(
		        "Premium Amount does not meet the minimum required for this plan");
		}
		PolicyInfo policyInfo = new PolicyInfo();
		policyInfo.setPremiumAmount(policyInfoRequestDto.getPremiumAmount());
		policyInfo.setPolicyOwnerId(policyInfoRequestDto.getPolicyOwnerId());
		policyInfo.setStartDate(LocalDate.now());
		policyInfo.setEndDate(LocalDate.now().plusYears(currentPlan.getTenureYears()));
		policyInfo.setCoverageAmount(currentPlan.getCoverageAmount());
		policyInfo.setPolicyCategory(currentPlan.getPolicyCategory());
		policyInfo.setPolicyTier(currentPlan.getPolicyTier());
		policyInfo.setPolicyPlan(currentPlan);
		policyInfo.setCreatedAt(LocalDateTime.now());
		policyInfo.setUpdatedAt(LocalDateTime.now());
		policyInfo.setPolicyStatus(PolicyStatus.ACTIVE);
		
		PolicyInfo savedPolicy = policyInfoRepository.save(policyInfo);
		
		PolicyInfoResponseDto policyInfoResponseDto = policyInfoMapper.toResponseDto(savedPolicy);
		return policyInfoResponseDto;
	}

	@Override
	public PolicyInfoResponseDto getPolicy(String policyNumber) {
		
		logger.info("PolicyInfoServiceImpl::getPolicy");
		policyNumber = policyNumber.trim().toUpperCase();
		PolicyInfo policyInfo = policyInfoRepository.findByPolicyNumber(policyNumber)
													.orElseThrow(()-> new ResourceNotFoundException("No Details found for this policyNumber"));
		PolicyInfoResponseDto policyInfoResponse = policyInfoMapper.toResponseDto(policyInfo);
		
		return policyInfoResponse;
	}

	@Override
	public List<PolicyInfoResponseDto> getAllPolicyDetails(Long policyOwnerId) {
		
		logger.info("PolicyInfoServiceImpl::getAllPolicyDetails");
		policyOwnerClient.validatePolicyOwnerExists(policyOwnerId);
		List<PolicyInfo> listOfPolicies = new ArrayList<>();
		listOfPolicies = policyInfoRepository.findByPolicyOwnerId(policyOwnerId)
											 .orElseThrow(()-> new ResourceNotFoundException("No Policies found for this owner"));
		
		return listOfPolicies.stream()
				.map(policyInfoMapper::toResponseDto)
				.collect(Collectors.toList());
	}

	@Override
	public void cancelPolicy(String policyNumber) {
		
		logger.info("PolicyInfoServiceImpl::cancelPolicy");
		policyNumber = policyNumber.trim().toUpperCase();
		PolicyInfo policyInfo = policyInfoRepository.findByPolicyNumber(policyNumber)
												    .orElseThrow(()-> new ResourceNotFoundException("No Details found for this policyNumber"));
		if(policyInfo.getPolicyStatus() != PolicyStatus.ACTIVE) {
			throw new IllegalStateException ("Policy is Not active. Unable to cancel");
		}
		else {
			policyInfo.setPolicyStatus(PolicyStatus.CANCELLED);
			policyInfo.setUpdatedAt(LocalDateTime.now());
			policyInfoRepository.save(policyInfo);
		}
		
	}

}
