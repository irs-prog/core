package com.irs.functional.stream;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalExample {
    public static void main(String[] args) {

        List<Animal> animals = getAnimals();

        // Старый подход (Императивный)

        List<Animal> predators = new ArrayList<>();

        for (Animal animal: animals) {
            if (animal.getClassification().equals(Classification.PREDATOR)) {
                predators.add(animal);
            }
        }

        predators.forEach(System.out::println);

        // Новый подход (Декларативный)

        List<Animal> omnivorous = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.OMNIVOROUS))
                .sorted(Comparator.comparing(Animal::getAge).reversed())
                .collect(Collectors.toList());
        omnivorous.forEach(System.out::println);

        // Any match
        boolean anyMatch = animals.stream()
                .anyMatch(animal -> animal.getAge() > 200);
        System.out.println(anyMatch);


        // max
        animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);

        // min
        animals.stream()
                .min(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);

        // Group
        Map<Classification, List<Animal>> classificationListMap = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClassification));
        classificationListMap.forEach((classification, animals1) -> {
            System.out.println(classification);
            animals1.forEach(System.out::println);
            System.out.println();
        });

        Optional<String> oldestPredatorAge = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .max(Comparator.comparing(Animal::getAge))
                .map(Animal::getName);
        oldestPredatorAge.ifPresent(System.out::println);

    }

    public static List<Animal> getAnimals() {
        return List.of(
                new Animal("Giraffe", 20, Classification.HERBIVORE),
                new Animal("Coyote", 5, Classification.PREDATOR),
                new Animal("Elephant", 50, Classification.HERBIVORE),
                new Animal("Pig", 8, Classification.OMNIVOROUS),
                new Animal("Tiger", 15, Classification.PREDATOR),
                new Animal("Chimpanzee", 3, Classification.OMNIVOROUS),
                new Animal("Kangaroo", 35, Classification.HERBIVORE),
                new Animal("Loin", 10, Classification.PREDATOR),
                new Animal("Bear", 1, Classification.OMNIVOROUS),
                new Animal("Horse", 99, Classification.HERBIVORE),
                new Animal("Cheetah", 9, Classification.PREDATOR),
                new Animal("Hedgehog", 2, Classification.OMNIVOROUS)
        );
    }
}
