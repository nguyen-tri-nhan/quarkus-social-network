package com.nhan.social.core.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.jbosslog.JBossLog;

import java.util.function.BiConsumer;
import java.util.function.Function;

@JBossLog
public abstract class BaseRepository<E, I> implements PanacheRepositoryBase<E, I> {

    public E save(E entity) {
        if (isPersistent(entity)) {
            return getEntityManager().merge(entity);
        }
        persist(entity);
        return entity;
    }

    /**
     * Save entity with mapper function.
     */
    public <T> T save(E entity, Function<E, T> mapper) {
        return mapper.apply(save(entity));
    }

    /**
     * Update entity with merge and mapper function.
     */
    public <T> T update(I id, T updated, BiConsumer<E, T> merger, Function<E, T> mapper) {
        E entity = findByIdOptional(id).orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
        merger.accept(entity, updated);
        return mapper.apply(save(entity));
    }

    /**
     * Merge entity with merge and mapper function.
     */
    public <T> T merge(E entity, T updated, BiConsumer<E, T> merger, Function<E, T> mapper) {
        merger.accept(entity, updated);
        return mapper.apply(save(entity));
    }

}
