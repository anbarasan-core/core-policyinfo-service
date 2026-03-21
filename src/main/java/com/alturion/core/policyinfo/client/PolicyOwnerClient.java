package com.alturion.core.policyinfo.client;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.alturion.core.policyinfo.common.ApiResponse;
import com.alturion.core.policyinfo.dto.PolicyOwnerSummaryDto;
import com.alturion.core.policyinfo.exception.DependencyServiceUnavailableException;
import com.alturion.core.policyinfo.exception.ResourceNotFoundException;

@Component
public class PolicyOwnerClient {
	
	private static final Logger logger = Logger.getLogger(PolicyOwnerClient.class.getName());
	
	private final RestTemplate restTemplate;
	private final String policyOwnerBaseUrl;
	
	public PolicyOwnerClient(RestTemplate restTemplate,@Value("${alturion.policyowner.service.url}") String policyOwnerBaseUrl) {
		
		this.restTemplate = restTemplate;
		this.policyOwnerBaseUrl = policyOwnerBaseUrl;
	}
	
	public PolicyOwnerSummaryDto validatePolicyOwnerExists(Long policyOwnerId) {
		
		logger.info("PolicyOwnerClient::validatePolicyOwnerExists");
		String url = policyOwnerBaseUrl + policyOwnerId;
		logger.info("GET " +url);
		PolicyOwnerSummaryDto summaryDto = new PolicyOwnerSummaryDto();
		try {
			ResponseEntity<ApiResponse<PolicyOwnerSummaryDto>> apiResponse = restTemplate.exchange(url, 
					HttpMethod.GET, 
					null, 
					new ParameterizedTypeReference<ApiResponse<PolicyOwnerSummaryDto>>() {}
			);
			summaryDto = apiResponse.getBody().getData();
		}
		catch(HttpClientErrorException httpException) {
			if(httpException.getStatusCode()==HttpStatus.NOT_FOUND) {
				throw new ResourceNotFoundException("User Not Found for the given ID: "+policyOwnerId);
			}
		}
		catch(ResourceAccessException resourceException) {
			throw new DependencyServiceUnavailableException("Dependency Service is Not Available");
		}
		return summaryDto;
	}

}
