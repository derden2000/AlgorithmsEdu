package ru.antonshu.Alg5;

import java.util.Comparator;

public class Box {
    
    private int volume, cost;
    private String name;

    public Box(String name, int volume, int cost) {
        this.volume = volume;
        this.cost = cost;
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public int getCost() {
        return cost;
    }

    public static void sortByCost(Box[] boxes, Comparator comparator) {
        for (int external = boxes.length-1; external >= 1 ; external--) {
            for (int internal = 0; internal < external; internal++) {
                if (comparator.compare(boxes[internal].cost, boxes[internal+1].cost) > 0) {
                    Box buf = boxes[internal];
                    boxes[internal] = boxes[internal +1];
                    boxes[internal + 1] = buf;
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
