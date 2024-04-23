package com.nhan.social.user.domain;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserPayload extends User {
    private String password;
}
