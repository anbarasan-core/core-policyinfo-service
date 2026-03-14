package com.alturion.core.policyinfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alturion.core.policyinfo.domain.PolicyInfo;
import com.alturion.core.policyinfo.enums.PolicyCategory;
import com.alturion.core.policyinfo.enums.PolicyTier;

@Repository
public interface PolicyInfoRepository extends JpaRepository<PolicyInfo,Long> {
	
	public Optional<PolicyInfo> findByPolicyNumber(String policyNumber);
	
	public Optional<List<PolicyInfo>> findByPolicyOwnerId(Long policyOwnerId);
	
	public Optional<List<PolicyInfo>> findByPolicyOwnerIdIn(List<Long> policyOwnerId);
	
	public Page<PolicyInfo> findByPolicyOwnerIdIn(List<Long> policyOwnerId, Pageable pageable);
	
	public boolean existsByPolicyOwnerIdAndPolicyCategoryAndPolicyTier(Long policyOwnerId, PolicyCategory policyCategory, PolicyTier policyTier);

}
