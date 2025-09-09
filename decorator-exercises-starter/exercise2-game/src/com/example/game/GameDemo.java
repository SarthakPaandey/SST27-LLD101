package com.example.game;

public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        System.out.println("--- Buffed (speed+damage) ---");
        buffed.move();
        buffed.attack();

        Character shiny = new GoldenAura(buffed);
        System.out.println("--- Shiny (golden aura) ---");
        shiny.move();
        shiny.attack();

        Character withoutAura = buffed;
        System.out.println("--- Back to Buffed (no aura) ---");
        withoutAura.move();
        withoutAura.attack();
    }
}
