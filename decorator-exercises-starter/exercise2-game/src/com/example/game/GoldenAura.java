package com.example.game;

public class GoldenAura extends CharacterDecorator {
    private static final int SMALL_SPEED_BONUS = 2;
    private static final int SMALL_DAMAGE_BONUS = 5;
    private static final String GOLDEN_SPRITE_SUFFIX = "_golden";

    public GoldenAura(Character wrappedCharacter) {
        super(wrappedCharacter);
    }

    @Override
    public int getSpeed() {
        return wrappedCharacter.getSpeed() + SMALL_SPEED_BONUS;
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage() + SMALL_DAMAGE_BONUS;
    }

    @Override
    public String getSprite() {
        return wrappedCharacter.getSprite().replace(".png", GOLDEN_SPRITE_SUFFIX + ".png");
    }

    @Override
    public void move() {
        System.out.println("Moving with golden aura at speed " + getSpeed() +
                " with sprite " + getSprite() + " (Aura Speed +" + SMALL_SPEED_BONUS + ")");
    }

    @Override
    public void attack() {
        System.out.println("Attacking with golden aura for damage " + getDamage() +
                " using sprite " + getSprite() + " (Aura Damage +" + SMALL_DAMAGE_BONUS + ")");
    }
}
