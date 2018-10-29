package com.solidground.infra.jpa.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @author fdanismaz
 * date: 9/18/18 1:05 PM
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class SoftDeletableEntity extends EntityModel {

    private static final long serialVersionUID = 1166505952598964484L;

    @Column(name = "DELETED", nullable = false)
    protected boolean deleted;
}
