package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
