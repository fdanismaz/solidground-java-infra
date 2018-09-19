package com.solidground.infra.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author fdanismaz
 * date: 9/18/18 1:07 PM
 */
public interface SoftDeleteRepository<T, I> extends GenericRepository<T, I> {

    @Modifying
    @Transactional
    @Query("update #{#entityName} e set e.deleted=true where e.dbId = ?1")
    void softDelete(I id);

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = false")
    Iterable<T> findAllActive();

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = false")
    Iterable<T> findAllActive(Sort sort);

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = false")
    Page<T> findAllActive(Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select count(e) from #{#entityName} e where e.deleted = false")
    long countActive();

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id = ?1 and e.deleted = false")
    T findOneActive(I id);

    @Transactional(readOnly = true)
    default boolean existsActive(I id) {
        return findOneActive(id) != null;
    }

}
