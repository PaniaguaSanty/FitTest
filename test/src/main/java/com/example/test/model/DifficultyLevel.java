package com.example.test.model;


public enum DifficultyLevel {
    BEGINNER("begginner"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced");

    private final String name;

    DifficultyLevel(String name) {
        this.name = name;
    }
}
