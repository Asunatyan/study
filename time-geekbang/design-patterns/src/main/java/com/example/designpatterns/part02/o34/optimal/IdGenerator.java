package com.example.designpatterns.part02.o34.optimal;

public interface IdGenerator {
    String generate() throws RandomIdGenerator.IdGenerationFailureException;
}

