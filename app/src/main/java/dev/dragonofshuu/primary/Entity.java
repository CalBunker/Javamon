package dev.dragonofshuu.primary;

import java.io.Serializable;

import dev.dragonofshuu.elements.Element;

public class Entity implements Serializable {
    private static final long serialVersionUID = 32L;
    
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
