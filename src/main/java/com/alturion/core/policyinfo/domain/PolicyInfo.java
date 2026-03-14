package com.alturion.core.policyinfo.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.alturion.core.policyinfo.enums.PolicyCategory;
import com.alturion.core.policyinfo.enums.PolicyStatus;
import com.alturion.core.policyinfo.enums.PolicyTier;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "core_policy_info", uniqueConstraints = @UniqueConstraint(
        columnNames = {"policy_owner_id","policy_category","policy_tier"}
    ))
public class PolicyInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyID;
	private String policyNumber;
	private BigDecimal premiumAmount;
	private BigDecimal coverageAmount;
	@Enumerated(EnumType.STRING)
	private PolicyStatus policyStatus;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="plan_id",nullable=false)
	private PolicyPlan policyPlan;
	@Enumerated(EnumType.STRING)
	private PolicyCategory policyCategory;
	@Enumerated(EnumType.STRING)
	private PolicyTier policyTier;
	private LocalDate startDate;
	private LocalDate endDate;
	private Long policyOwnerId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	public PolicyInfo() {
		super();
	}
	
	public PolicyInfo(Long policyID, String policyNumber, BigDecimal premiumAmount, BigDecimal coverageAmount,
			PolicyStatus policyStatus, PolicyPlan policyPlan, PolicyCategory policyCategory, PolicyTier policyTier, LocalDate startDate, LocalDate endDate,
			Long policyOwnerId, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.policyID = policyID;
		this.policyNumber = policyNumber;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.policyStatus = policyStatus;
		this.policyPlan = policyPlan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.policyOwnerId = policyOwnerId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	@PostPersist
	private void initPolicyNumber() {
		this.policyNumber = String.format("ALT-PL-%04d", this.policyID);
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

	public PolicyPlan getPolicyPlan() {
		return policyPlan;
	}

	public void setPolicyPlan(PolicyPlan policyPlan) {
		this.policyPlan = policyPlan;
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
