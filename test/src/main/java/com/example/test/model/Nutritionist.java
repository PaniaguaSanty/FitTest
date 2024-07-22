package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nutritionists")
public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nutritionist_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dni")
    private String dni;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "hire_date")
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;


}
