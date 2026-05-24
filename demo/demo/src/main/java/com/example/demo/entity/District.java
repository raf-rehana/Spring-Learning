package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "district")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String districtName;

    @ManyToOne
    @JoinColumn(name= "division_id")
    @JsonBackReference(value = "division-district")
    private Division division;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "district-user")
    private List<User> users;
}
