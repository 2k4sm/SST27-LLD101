package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        System.out.println("\nBase + SpeedBoost + DamageBoost");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();

        System.out.println("\nGoldenAura");
        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();

        System.out.println("\nGoldenAura Removed");
        Character withoutAura = buffed;
        withoutAura.move();
        withoutAura.attack();
    }
}
