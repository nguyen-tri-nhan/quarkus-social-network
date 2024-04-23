package com.nhan.social.user.repository;

import com.nhan.social.core.repository.BaseRepository;
import com.nhan.social.user.repository.entity.UserDb;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class UserRepository extends BaseRepository<UserDb, UUID> {
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";

    public UserDb findByUsernameOrEmail(String input) {
        return find("username = :username or email = :email",
                Parameters.with(USERNAME, input)
                        .and(EMAIL, input))
                .firstResult();
    }
}
