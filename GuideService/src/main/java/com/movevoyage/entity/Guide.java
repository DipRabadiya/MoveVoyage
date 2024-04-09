package com.movevoyage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Guide {
    @Id
    private String id;
    private String name;
    private String address;
    private int age;
    private String gender;
    private String contact_number;
    private String experience;
    private double man_day_value;
    @Column(length = 4096)
    private List<byte[]> images_list = new ArrayList<>();
    private String remark;

}
