package com.example.game;

public abstract class CharacterDecorator implements Character {
    protected final Character next;

    protected CharacterDecorator(Character next) {
        this.next = next;
    }

    @Override
    public void move() { next.move(); }

    @Override
    public void attack() { next.attack(); }

    @Override
    public int getSpeed() { return next.getSpeed(); }

    @Override
    public int getDamage() { return next.getDamage(); }

    @Override
    public String getSprite() { return next.getSprite(); }
}


