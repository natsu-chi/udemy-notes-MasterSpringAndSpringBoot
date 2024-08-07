package com.chi.demo10.accounts.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {
    
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createTime;
    
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updateTime;

    @CreatedBy
    @Column(updatable = false)
    private String createUser;

    @LastModifiedBy
    @Column(insertable = false)
    private String updateUser;
    
}
