package fr.sdv.entites;

public class Fish extends Animal {

    private FishLivEnv livingEnv;

    public enum FishLivEnv {
        FRESH_WATER, SEA_WATER
    }
}
