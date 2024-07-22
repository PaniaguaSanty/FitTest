package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exercises")
public class ExerciseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "muscle_group")
    private String muscleGroup;

    @Column(name = "equipment")
    private String equipment;

    @ManyToOne
    @JoinColumn(name = "routine_exercise_id", referencedColumnName = "routine_exercise_id")
    private RoutineExercise routineExercise;
}
