package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inscriptions")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inscription_id")
    private Long inscriptionCode;

    @Column(name = "inscription_date")
    private LocalDate inscriptionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gym_manager_id")
    private GymManager gymManager;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gym_id", referencedColumnName = "gym_id")
    private Gym gym;

}
