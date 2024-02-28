package com.movevoyage.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class User {
    @Id
    private String user_id;
    private String username;
    private String nic_no;
    private Integer age;
    private String gender;
    private String email;
    private String contact_number;
    private String remark;
    private String password;
    private String role;
    private byte[] nic_front;
    private byte[] nic_back;

    @CreatedDate
    private LocalDateTime createdTime;
    @LastModifiedDate
    private LocalDateTime lastModifiedTime;


}
