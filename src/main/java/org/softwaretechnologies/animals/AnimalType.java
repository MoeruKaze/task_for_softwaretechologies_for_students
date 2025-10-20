package org.softwaretechnologies.animals;

public enum AnimalType {
    CAT {
        public Animal createAnimal(String name) {
            return new Cat(name);
        }
    },
    DOG {
        public Animal createAnimal(String name) {
            return new Dog(name);
        }
    },
    COW {
        public Animal createAnimal(String name) {
            return new Cow(name);
        }
    };

    // Добавить абстрактный метод
    public abstract Animal createAnimal(String name);
}