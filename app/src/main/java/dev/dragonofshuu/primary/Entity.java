package dev.dragonofshuu.primary;

import dev.dragonofshuu.elements.Element;

public class Entity {
    protected float health;
    protected Element element;

    public Entity(float startingHealth) {
        health = startingHealth;
    }

    protected boolean dealDamage(Element.ElementType element, float damage) {
        this.element.inflictElement(element);
        return true;
    }

    public float getHealth() {
        return health;
    }
}
