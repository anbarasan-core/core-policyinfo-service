package com.alturion.core.policyinfo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alturion.core.policyinfo.common.ApiResponse;
import com.alturion.core.policyinfo.dto.PolicyInfoRequestDto;
import com.alturion.core.policyinfo.dto.PolicyInfoResponseDto;
import com.alturion.core.policyinfo.service.PolicyInfoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policyinfo")
public class PolicyInfoController {
	
	private final PolicyInfoService policyInfoService;
	
	public PolicyInfoController(PolicyInfoService policyInfoService) {
		this.policyInfoService = policyInfoService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse<PolicyInfoResponseDto>> policyCreation(@Valid @RequestBody PolicyInfoRequestDto policyInfoRequestDto) {
		
		PolicyInfoResponseDto policyInfoResponse =  policyInfoService.createPolicy(policyInfoRequestDto);
		ApiResponse<PolicyInfoResponseDto> apiPolicyResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.CREATED.value(),
				"Policy Created Successfully",
				policyInfoResponse
				);
		return new ResponseEntity<ApiResponse<PolicyInfoResponseDto>>(apiPolicyResponse,HttpStatus.CREATED);
	}
	
	@GetMapping("/policy/{policyNumber}")
	public ResponseEntity<ApiResponse<PolicyInfoResponseDto>> fetchPolicyDetails (@PathVariable String policyNumber){
		
		PolicyInfoResponseDto policyDetails = policyInfoService.getPolicy(policyNumber);
		ApiResponse<PolicyInfoResponseDto> apiPolicyResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.FOUND.value(),
				"Policy Fetched Successfully",
				policyDetails
				);
		return new ResponseEntity<ApiResponse<PolicyInfoResponseDto>> (apiPolicyResponse,HttpStatus.FOUND) ;
	}

}
