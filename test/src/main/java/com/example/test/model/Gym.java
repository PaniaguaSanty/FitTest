package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gyms")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gym_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Trainer> trainers;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nutritionist> nutritionists;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GymManager> managers;

    @OneToMany(mappedBy = "gym", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Inscription> inscriptions;



}
