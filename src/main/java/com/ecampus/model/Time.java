package com.ecampus.model;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
@MappedSuperclass

public class Time {
    private LocalDateTime createDate = LocalDateTime.now();
}
