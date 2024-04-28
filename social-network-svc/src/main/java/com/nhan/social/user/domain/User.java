package com.nhan.social.user.domain;

import com.nhan.social.core.domain.BaseInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User extends BaseInfo {
    private UUID id;
    private String username;

    @Email
    private String email;

    @Pattern(regexp = "^[^<>*?/:\\\\\"|]*$", message = "Please do NOT include /<>:\"|?* in the name")
    private String firstName;

    @Pattern(regexp = "^[^<>*?/:\\\\\"|]*$", message = "Please do NOT include /<>:\"|?* in the name")
    private String lastName;
}
