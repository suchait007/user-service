package com.user.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserInfo {

    private String id;
    private String userId;
    private String name;
    private int age;
    private String gender;
    private List<String> invoiceNumbers;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
