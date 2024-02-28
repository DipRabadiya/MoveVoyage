package com.movevoyage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    private String id;
    private String booking_id;
    private double amount;
    private byte [] receipt;
    private Date payment_date;
}
