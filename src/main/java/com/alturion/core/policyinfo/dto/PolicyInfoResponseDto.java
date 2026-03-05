package com.alturion.core.policyinfo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.alturion.core.policyinfo.enums.PolicyCategory;
import com.alturion.core.policyinfo.enums.PolicyStatus;
import com.alturion.core.policyinfo.enums.PolicyTier;

public class PolicyInfoResponseDto {
	
	private Long policyID;
	private String policyNumber;
	private PolicyCategory policyCategory;
	private PolicyTier policyTier;
	private BigDecimal premiumAmount;
	private BigDecimal coverageAmount;
	private PolicyStatus policyStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private Long policyOwnerId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	public PolicyInfoResponseDto() {
		super();
	}
	public PolicyInfoResponseDto(Long policyID, String policyNumber, PolicyCategory policyCategory, PolicyTier policyTier, BigDecimal premiumAmount, BigDecimal coverageAmount,
			PolicyStatus policyStatus, LocalDate startDate, LocalDate endDate, Long policyOwnerId,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.policyID = policyID;
		this.policyNumber = policyNumber;
		this.policyCategory = policyCategory;
		this.policyTier = policyTier;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.policyStatus = policyStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.policyOwnerId = policyOwnerId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	public PolicyCategory getPolicyCategory() {
		return policyCategory;
	}
	public void setPolicyCategory(PolicyCategory policyCategory) {
		this.policyCategory = policyCategory;
	}
	public BigDecimal getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(BigDecimal coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public Long getPolicyID() {
		return policyID;
	}
	public void setPolicyID(Long policyID) {
		this.policyID = policyID;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public PolicyTier getPolicyTier() {
		return policyTier;
	}
	public void setPolicyTier(PolicyTier policyTier) {
		this.policyTier = policyTier;
	}
	public BigDecimal getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(BigDecimal premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public PolicyStatus getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(PolicyStatus policyStatus) {
		this.policyStatus = policyStatus;
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	

}
