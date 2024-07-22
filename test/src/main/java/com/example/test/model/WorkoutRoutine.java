package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workout_routines")
public class WorkoutRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id")
    private Long id;

    @Column(name = "routine_code", nullable = false)
    private String routineCode;

    @Column(name = "routine_type", nullable = false)
    private String routineType;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    //muchas rutinas pueden estar asociadas con un solo cliente
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id")
    private Trainer trainer;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", nullable = false)
    private DifficultyLevel difficultyLevel;

    //una rutina puede tener muchas routineExercises
    @OneToMany(mappedBy = "workoutRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RoutineExercise> routineExercises;

    @OneToMany(mappedBy = "workoutRoutine", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RoutineObjective> objectives;
}
