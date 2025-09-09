package com.example.game;

public class SpeedBoost extends CharacterDecorator {
    private final int bonus;

    public SpeedBoost(Character next, int bonus) {
        super(next);
        this.bonus = bonus;
    }

    @Override
    public int getSpeed() { return next.getSpeed() + bonus; }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }
}


