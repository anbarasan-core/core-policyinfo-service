package com.alturion.core.policyinfo.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.alturion.core.policyinfo.enums.PolicyCategory;
import com.alturion.core.policyinfo.enums.PolicyTier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "policy_plan")
public class PolicyPlan {
	
	@Id
	@Column(name = "plan_id")
	private Long planID;
	@Enumerated(EnumType.STRING)
	private PolicyCategory policyCategory;
	@Enumerated(EnumType.STRING)
	private PolicyTier policyTier;
	private BigDecimal premiumAmount;
	private BigDecimal coverageAmount;
	private boolean isActive;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	public PolicyPlan() {
		super();
	}
	public PolicyPlan(Long planID, PolicyCategory policyCategory, PolicyTier policyTier, BigDecimal premiumAmount,
			BigDecimal coverageAmount, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.planID = planID;
		this.policyCategory = policyCategory;
		this.policyTier = policyTier;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getPlanID() {
		return planID;
	}
	public void setPlanID(Long planID) {
		this.planID = planID;
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
	public void setPolicyTier(PolicyTier policyTier) {
		this.policyTier = policyTier;
	}
	public BigDecimal getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(BigDecimal premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public BigDecimal getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(BigDecimal coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
