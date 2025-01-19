package jsu.edu.mcis.cs408.lab1a;

import androidx.annotation.NonNull;

import java.util.Random;

public enum Weapon {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private final String message;

    Weapon(String msg) {
       message = msg;
    }

    public static Weapon getRandomWeapon() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }

    @NonNull
    @Override
    public String toString() {
        return message;
    }
}
