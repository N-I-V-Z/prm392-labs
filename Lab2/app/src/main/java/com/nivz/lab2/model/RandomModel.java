package com.nivz.lab2.model;

import java.util.Random;

public class RandomModel {
    public int generateRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
