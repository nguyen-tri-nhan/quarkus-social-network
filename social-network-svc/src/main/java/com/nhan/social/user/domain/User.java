package com.nhan.social.user.domain;

import com.nhan.social.core.domain.BaseInfo;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User extends BaseInfo {
    private UUID id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}
