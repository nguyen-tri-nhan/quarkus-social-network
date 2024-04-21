package com.nhan.social.core.repository;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.Instant;

/**
 * Base Entity.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity extends PanacheEntityBase implements Serializable {

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;
}
