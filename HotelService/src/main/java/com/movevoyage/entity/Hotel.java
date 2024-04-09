package com.movevoyage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "hotel_id"))
            @Column(columnDefinition = "LONGBLOB")
    List<byte[]> image_list = new ArrayList<>();


    @Id
    private String id;
    private String name;
    private int star_rate;

    @Column(columnDefinition = "TEXT")
    private String geo_location;
    private String location;
    private String email;
    private String contact;
    private String is_pet_allowed;
    private String description;
    private String cancellation_criteria;
    private double tax;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Discount> discount_list = new ArrayList<>();

    @OneToMany(cascade ={ CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Options> options_list = new ArrayList<>();

}
