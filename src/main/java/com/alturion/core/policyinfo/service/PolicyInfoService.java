package com.alturion.core.policyinfo.service;

import java.util.List;

import com.alturion.core.policyinfo.dto.PolicyInfoRequestDto;
import com.alturion.core.policyinfo.dto.PolicyInfoResponseDto;

public interface PolicyInfoService {
	
	public PolicyInfoResponseDto createPolicy(PolicyInfoRequestDto policyInfoRequestDto);
	
	public PolicyInfoResponseDto getPolicy(String policyNumber);
	
	public List<PolicyInfoResponseDto> getAllPolicyDetails(Long policyOwnerId);

}
