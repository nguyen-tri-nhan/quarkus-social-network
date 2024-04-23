package com.nhan.social.user.repository.entity;

import com.nhan.social.core.repository.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(
        name = "user_account",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_user_account_username",
                        columnNames = {"username"}
                )
        }
)
public class UserDb extends BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @UuidGenerator
    @Column(name = "user_id")
    private UUID id;

    @NotNull
    @Column(nullable = false, name = "username")
    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;
}
