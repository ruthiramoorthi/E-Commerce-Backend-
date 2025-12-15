package com.example.E_Commerce.Backend.Project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    //“The CartItem table has the foreign key for this relationship.
    //Look at the field named cart inside the CartItem class.”
    /* “I am NOT the owner of this relationship
    The CartItem class owns the relationship
    Look at the field named cart inside Cart_Item”
    So foreign key is NOT in Cart table.*/
    private List<Cart_Item> items;

    private double total_amount = 0.0;
}
