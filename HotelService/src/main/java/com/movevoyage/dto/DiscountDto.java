package com.movevoyage.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDto {
    private String code;
    private boolean is_available;
    private double discount_percentage;
    private String description;
    @ToString.Exclude
    private HotelDto hotel;
}
