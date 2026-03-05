package com.alturion.core.policyinfo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.alturion.core.policyinfo.enums.PolicyCategory;
import com.alturion.core.policyinfo.enums.PolicyTier;

import jakarta.validation.constraints.NotNull;

public class PolicyInfoRequestDto {
	
	@NotNull(message = "Policy Category cannot be null")
	private PolicyCategory policyCategory;
	@NotNull(message = "Policy Tier cannot be null")
	private PolicyTier policyTier;
	private BigDecimal premiumAmount;
	private LocalDate startDate;
	private LocalDate endDate;
	private Long policyOwnerId;
	
	
	public PolicyInfoRequestDto() {
		super();
	}
	public PolicyInfoRequestDto(PolicyCategory policyCategory, PolicyTier policyTier, BigDecimal premiumAmount,
			LocalDate startDate, LocalDate endDate, Long policyOwnerId) {
		super();
		this.policyCategory = policyCategory;
		this.policyTier = policyTier;
		this.premiumAmount = premiumAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.policyOwnerId = policyOwnerId;
	}
	public PolicyCategory getPolicyCategory() {
		return policyCategory;
	}
	public void setPolicyCategory(PolicyCategory policyCategory) {
		this.policyCategory = policyCategory;
	}
	public PolicyTier getPolicyTier() {
		return policyTier;
	}
	public void setPolicyType(PolicyTier policyTier) {
		this.policyTier = policyTier;
	}
	public BigDecimal getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(BigDecimal premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Long getPolicyOwnerId() {
		return policyOwnerId;
	}
	public void setPolicyOwnerId(Long policyOwnerId) {
		this.policyOwnerId = policyOwnerId;
	}
}
