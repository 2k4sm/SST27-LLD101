package com.example.game;

public class SpeedBoost extends CharacterDecorator {
    private final int speedBonus;

    public SpeedBoost(Character wrappedCharacter, int speedBonus) {
        super(wrappedCharacter);
        this.speedBonus = speedBonus;
    }

    @Override
    public int getSpeed() {
        return wrappedCharacter.getSpeed() + speedBonus;
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() +
                " with sprite " + getSprite() + " (Speed Boosted +"+speedBonus+")");
    }
}
    