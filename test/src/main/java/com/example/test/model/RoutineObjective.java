package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "routine_objectives")
public class RoutineObjective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objective_id")
    private Long id;

    @Column(name = "expected_purpose", nullable = false)
    private String expectedPurpose;

    @Column(name = "expected_time", nullable = false)
    private LocalDateTime expectedTime;

    @ManyToOne
    @JoinColumn(name = "routine_id", referencedColumnName = "routine_id")
    private WorkoutRoutine workoutRoutine;
}
