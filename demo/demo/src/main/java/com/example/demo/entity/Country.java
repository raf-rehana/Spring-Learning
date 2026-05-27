package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String countryName;
    private String countryCode;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "country-division")
    private List<Division> divisions;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "country-user")
    private List<User> users;

}
