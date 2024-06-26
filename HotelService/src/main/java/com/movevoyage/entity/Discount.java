package com.movevoyage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    private String code;
    private String is_available;
    private double discount_percentage;
    private String description;

    @ManyToOne
    @ToString.Exclude
    private Hotel hotel;
}
