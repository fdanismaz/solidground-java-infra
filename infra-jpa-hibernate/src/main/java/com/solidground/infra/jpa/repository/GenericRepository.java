package com.solidground.infra.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author fdanismaz
 * date: 9/18/18 12:37 PM
 */
public interface GenericRepository<T, I> extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
}
