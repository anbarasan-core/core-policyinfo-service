package com.alturion.core.policyinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alturion.core.policyinfo.domain.PolicyPlan;
import com.alturion.core.policyinfo.enums.PolicyCategory;
import com.alturion.core.policyinfo.enums.PolicyTier;

@Repository
public interface PolicyPlanRepository extends JpaRepository<PolicyPlan,Long>{
	
	Optional<PolicyPlan> findByPolicyCategoryAndPolicyTier(PolicyCategory policyCategory,PolicyTier policyTier);

}
