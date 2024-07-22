package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "routineExercises")
public class RoutineExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_exercise_id")
    private Long routineExerciseCode;

    @Column(name = "sets", nullable = false)
    private int sets;

    @Column(name = "reps", nullable = false)
    private int reps;

    @Column(name = "weight", nullable = false)
    private float weight;

    @Column(name = "rest_time", nullable = false)
    private LocalDateTime restTime;

    @Column(name = "duration", nullable = false)
    private LocalDateTime duration;

    @ManyToOne
    @JoinColumn(name = "routine_id", referencedColumnName = "routine_id")
    private WorkoutRoutine workoutRoutine;

    @OneToMany(mappedBy = "routineExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseDetail> exerciseDetails;
}
