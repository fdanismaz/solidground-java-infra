package com.solidground.infra.jpa.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author fdanismaz
 * date: 9/18/18 1:04 PM
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityModel implements Serializable {

    private static final long serialVersionUID = 806660224761410822L;

    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false)
    protected String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    protected long createdDate;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE", nullable =  false)
    protected long lastModifiedDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    protected String lastModifiedBy;
}
