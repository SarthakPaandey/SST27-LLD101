package com.example.game;

public class GoldenAura extends CharacterDecorator {
    public GoldenAura(Character next) {
        super(next);
    }

    @Override
    public String getSprite() { return "golden.png"; }

    @Override
    public int getSpeed() { return next.getSpeed() + 1; }

    @Override
    public int getDamage() { return next.getDamage() + 2; }

    @Override
    public void move() {
        System.out.println("[aura] shimmering...");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[aura] blazing...");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}


