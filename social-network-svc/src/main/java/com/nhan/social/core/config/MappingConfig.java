package com.nhan.social.core.config;

import org.mapstruct.*;

/**
 * MapperConfig.
 */
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ACCESSOR_ONLY,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MappingConfig {
}
