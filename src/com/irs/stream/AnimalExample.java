package com.irs.stream;

import java.util.List;

public class AnimalExample {
    public static void main(String[] args) {

        List<Animal> animals = List.of(
                new Animal("Giraffe", 20, Classification.HERBIVORE),
                new Animal("Coyote", 5, Classification.PREDATOR),
                new Animal("Elephant", 50, Classification.HERBIVORE),
                new Animal("Pig", 8, Classification.OMNIVOROUS),
                new Animal("Tiger", 15, Classification.PREDATOR),
                new Animal("Chimpanzee", 3, Classification.OMNIVOROUS)
        );

        animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.OMNIVOROUS))
                .forEach(System.out::println);
    }
}
