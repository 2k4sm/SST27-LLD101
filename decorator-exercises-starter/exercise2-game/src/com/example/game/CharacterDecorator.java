package com.example.game;

public abstract class CharacterDecorator implements Character {
    protected Character wrappedCharacter;

    public CharacterDecorator(Character wrappedCharacter) {
        this.wrappedCharacter = wrappedCharacter;
    }

    @Override
    public void move() {
        wrappedCharacter.move();
    }

    @Override
    public void attack() {
        wrappedCharacter.attack();
    }

    @Override
    public int getSpeed() {
        return wrappedCharacter.getSpeed();
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage();
    }

    @Override
    public String getSprite() {
        return wrappedCharacter.getSprite();
    }
}
