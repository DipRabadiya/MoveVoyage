package com.movevoyage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "option_detail")
public class OptionDetail {
    @Id
//    @Column(name = "hotel_id", columnDefinition = "VARCHAR(255)")
    private String hotel_id;
//    @Column(name = "option_id")
    private int option_id;
//    @Column(name = "no_of_days")
    private int no_of_days;
//    @Column(name = "price")
    private double price;
}
