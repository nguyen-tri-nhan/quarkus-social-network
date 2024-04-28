package com.nhan.social.user.service;

import com.nhan.social.user.domain.CreateUserPayload;
import com.nhan.social.user.domain.User;
import com.nhan.social.user.mapper.UserMapper;
import com.nhan.social.user.repository.UserRepository;
import com.nhan.social.user.repository.entity.UserDb;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;

@ApplicationScoped
@RequiredArgsConstructor
@JBossLog
public class UserService {

    private final UserRepository userRepository;

    public User create(CreateUserPayload createUserPayload) {
        UserDb userDb = UserMapper.INSTANCE.toDbUser(createUserPayload);
        userDb.setPassword(BcryptUtil.bcryptHash(userDb.getPassword()));
        log.info("User created: " + userDb.getEmail());
        return UserMapper
                .INSTANCE
                .toUser(userRepository.save(userDb));
    }
}
