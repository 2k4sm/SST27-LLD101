package com.example.game;

public class DamageBoost extends CharacterDecorator {
    private final int damageBonus;

    public DamageBoost(Character wrappedCharacter, int damageBonus) {
        super(wrappedCharacter);
        this.damageBonus = damageBonus;
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage() + damageBonus;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() +
                " using sprite " + getSprite() + " (Damage Boosted +" + damageBonus + ")");
    }
}
