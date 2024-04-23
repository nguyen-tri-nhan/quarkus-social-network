package com.nhan.social.user.mapper;

import com.nhan.social.core.config.MappingConfig;
import com.nhan.social.user.domain.CreateUserPayload;
import com.nhan.social.user.domain.User;
import com.nhan.social.user.repository.entity.UserDb;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = MappingConfig.class)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDb user);

    UserDb toDbUser(CreateUserPayload user);
}
