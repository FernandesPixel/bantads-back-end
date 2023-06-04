package com.tads.bantads.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String cep;
    @Column
    private String street;
    @Column
    private String number;
    @Column
    private String neighborhood;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String complement;
}
