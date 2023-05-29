package com.sadad.co.ir.api.shopcenter.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DELETED")
    private Boolean deleted;

    @Column(name = "DELETED_BY")
    private String deletedBy;

    @Column(name = "CREATION_TIMESTAMP")
    @CreationTimestamp
    private Timestamp creationTimestamp;

    @Version
    @Column(name = "VERSION",nullable = false ,columnDefinition = "int default 1")
    private Integer version;
}
