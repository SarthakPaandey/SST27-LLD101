package com.example.game;

public class DamageBoost extends CharacterDecorator {
    private final int bonus;

    public DamageBoost(Character next, int bonus) {
        super(next);
        this.bonus = bonus;
    }

    @Override
    public int getDamage() { return next.getDamage() + bonus; }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}


