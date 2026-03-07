package com.alturion.core.policyinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.alturion.core.policyinfo.domain.PolicyInfo;
import com.alturion.core.policyinfo.dto.PolicyInfoRequestDto;
import com.alturion.core.policyinfo.dto.PolicyInfoResponseDto;

@Mapper(componentModel = "spring")
public interface PolicyInfoMapper {
	
	@Mapping(target = "policyID", ignore = true)
	@Mapping(target = "coverageAmount", ignore=true)
	@Mapping(target = "policyCategory", ignore=true)
	@Mapping(target = "policyTier", ignore=true)
	@Mapping(target = "policyPlan", ignore=true)
	@Mapping(target = "createdAt", ignore=true)
	@Mapping(target = "updatedAt", ignore=true)
	@Mapping(target = "policyStatus", ignore=true)
	public PolicyInfo toEntity(PolicyInfoRequestDto policyInfoRequestDto);
	
	public PolicyInfoResponseDto toResponseDto(PolicyInfo policyInfo);
}
