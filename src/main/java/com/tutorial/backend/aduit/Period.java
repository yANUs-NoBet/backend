package com.tutorial.backend.aduit;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass @Getter
public class Period {
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    public void create(){
        this.createdDate = LocalDateTime.now();

    }

    @PreUpdate
    public void update(){
        this.updatedDate = LocalDateTime.now();

    }

}