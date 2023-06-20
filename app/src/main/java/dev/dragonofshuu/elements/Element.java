package dev.dragonofshuu.elements;

import java.util.ArrayList;

public class Element {
    public enum ElementType {
        PYRO,
        HYDRO,
        CRYO,
        
        DENDRO,
        GEO,

        ANEMO,
        ELECTRO,

        // Composite
        SWIRL,          // Anemo + (Cryo, Hydro, Electro, or Pyro)
        CRYSTALLISE,    // Geo + (Cryo, Electro, Hydro, or Pyro)
        OVERLOAD,       // Electro + Pyro
        SUPERCONDUCT,   // Electro + Cryo
        ELECTROCHARGE,  // Electro + Hydro
        MELT,           // Pyro + Cryo
        VAPORISE,       // Pyro + Hydro
        FREEZE,         // Cryo + Hydro
        BURNING         // Dendro + Pyro
    }

    private int frameTime;
    private ArrayList<ElementType> inflictedElements;

    public Element(int frameTime, ElementType type) {
        this.frameTime = frameTime;
        this.inflictedElements.add(type);
    }

    public int getFrameTime() {
        return frameTime;
    }

    public int addFrametime(int amount) {
        frameTime += amount;
        return frameTime;
    }

    public boolean inflictElement(Element.ElementType element) {
        inflictedElements.add(element);

        // Determine effect logic

        return true;
    }

    public ArrayList<ElementType> getInflictedElements() {
        return inflictedElements;
    }
}
