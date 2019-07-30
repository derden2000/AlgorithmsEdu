package ru.antonshu.Alg5;

import java.util.*;

public class Bag {

    private int capacity;
    private Box[] boxArray;
    private int maxCost;

    public Bag(int capacity) {
        this.capacity = capacity;
    }

    public Bag(Box[] boxes) {
        this.boxArray = boxes;
    }

    public int getMaxCost() {
        return maxCost;
    }

    public void setBoxArray(Box[] boxArray) {
        this.boxArray = boxArray;
    }

    public int computeMaxCost(Box[] boxes) {
//        boxArray = new Box[boxes.length];
//        System.arraycopy(boxes, 0, boxArray, 0, boxes.length);
        sortByCost(boxes, Comparator.reverseOrder());
        int restOfVolume = this.capacity;
        int totalCost = 0;

        Map<Box, Integer> fillList = new HashMap<>();
        for (Box box : boxes) {
            if (restOfVolume > 0) {
                int pcs = (int) (restOfVolume / box.getVolume());
                restOfVolume -= pcs * box.getVolume();
                totalCost += pcs * box.getCost();
                if (pcs > 0) {
                    fillList.put(box, pcs);
                }
            }
        }
        for (Map.Entry<Box, Integer> entry : fillList.entrySet()) {
            System.out.println("Коробок " + entry.getKey() + ", штук " + entry.getValue());
        }
        System.out.println(fillList);
        System.out.println("Общая стоимость: " + totalCost);
        System.out.println("Осталось места: " + restOfVolume);
        return totalCost;
    }

    public int recursiveComputingMaxCost(Box[] boxes) {
        rotate(boxes,1);
        int[] results = new int[boxes.length];
        int totalCost = 0;
        int restOfVolume = this.capacity;
        if (boxes.length == 1) {
            for (Box box : boxes) {
                if (restOfVolume > 0) {
                    int pcs = (int) (restOfVolume / box.getVolume());
                    if (pcs > 0) {
                        restOfVolume -= pcs * box.getVolume();
                        totalCost += pcs * box.getCost();
                    }
                }
            }
            return totalCost;
        }
        return Math.max(recursiveComputingMaxCost(boxes), recursiveComputingMaxCost(rotate(boxes, 1)));
    }

    public int findBestSum(int i, int volume) {
        if (i < 0) {
            return 0;
        }
        if (boxArray[i].getVolume() > volume) {
            return findBestSum(i - 1, volume);
        } else {
            return Math.max(findBestSum(i - 1, volume),
                    findBestSum(i - 1, volume - boxArray[i].getVolume()) + boxArray[i].getCost());
        }
    }

    Box[] rotate(Box[] boxes, int newSize) {
        int pos = boxes.length - newSize;
        Box temp = boxes[pos];
        int index;
        for (index = pos + 1; index < boxes.length; index++) {
            boxes[index-1] = boxes[index];
        }
        boxes[index-1] = temp;
        return boxes;
    }

    Box[] delete(Box[] boxes, int newSize) {
        int pos = 0;//boxes.length - newSize;
        Box temp = boxes[pos];
        int index;
        for (index = pos + 1; index < boxes.length; index++) {
            boxes[index-1] = boxes[index];
        }
        boxes[index-1] = temp;
        return boxes;
    }


    private void sortByCost(Box[] boxes, Comparator comparator) {
        for (int external = boxes.length-1; external >= 1 ; external--) {
            for (int internal = 0; internal < external; internal++) {
                if (comparator.compare(boxes[internal].getCost()/boxes[internal].getVolume(), boxes[internal+1].getCost()/boxes[internal+1].getVolume()) > 0) {
                    Box buf = boxes[internal];
                    boxes[internal] = boxes[internal +1];
                    boxes[internal + 1] = buf;
                }
            }
        }
    }

    public static void main(String[] args) {
        Bag bag = new Bag(100);

        Box[] boxes = new Box[3];
        boxes[0] = new Box("Big", 15, 60);
        boxes[1] = new Box("Middle", 30, 90);
        boxes[2] = new Box("Small", 50, 100);

        Bag refactorBag = new Bag(boxes);

        System.out.println("Максимальная стоимость жадного метода: " + bag.computeMaxCost(boxes));
        System.out.println("Максимальная стоимость рекурсии: " + refactorBag.findBestSum(boxes.length -1, 100));


        System.out.println("Возведение в степень: " + raiseNumberToPower(15,2));
    }

    private static long raiseNumberToPower(int number, int power) {
        if (power == 0) {
            return 1;
        } else if (power == 1) {
            return number;
        }
        return raiseNumberToPower(number, power - 1) * number;
    }



}
