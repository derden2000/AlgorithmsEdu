package ru.antonshu.Alg3;

import java.util.Comparator;

public class MyPriorityQueue<Item extends Comparable> {
    private Item[] priorityQueue;
    private int size = 0;

    private Comparator comparator = Comparator.naturalOrder();

    public MyPriorityQueue(int size, Comparator comparator) {
        if (size <= 0) {
            throw new IllegalArgumentException("Некорректный размер: " + size);
        } else {
            priorityQueue = (Item[]) new Comparable[size];
            this.comparator = comparator;
        }
    }

    public MyPriorityQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Некорректный размер: " + size);
        } else {
            priorityQueue = (Item[]) new Comparable[size];
        }
    }

    public MyPriorityQueue() {
        priorityQueue = (Item[]) new Comparable[1];

    }

    public void insert(Item item) {
        reCapacity(true);
        priorityQueue[size] = item;
        size++;
        int index = size - 1;
        while (index > 0 && comparator.compare(priorityQueue[index], priorityQueue[index - 1]) < 0) {
            swap(index, index - 1);
            index--;
        }
    }

    public Item remove() {
        if (priorityQueue.length > 0) {
            Item temp = getFirstElement();
            priorityQueue[size] = null;
            size--;
            reCapacity(false);
            return temp;
        } else {
            System.out.println("Удаление запрещено. Элементов не осталось, Очередь - пуста");
            return null;
        }
    }


    public Item getFirstElement() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return priorityQueue[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == priorityQueue.length;
    }

    private void reCapacity(int newCapacity) {
        Item[] tempArr = (Item[]) new Object[newCapacity];
        System.arraycopy(priorityQueue, 0, tempArr, 0, size);
        priorityQueue = tempArr;
    }

    private void reCapacity(boolean isIncrease) {
        if (isIncrease) {
            Item[] buf = this.priorityQueue;
            this.priorityQueue = (Item[]) new Comparable[priorityQueue.length + 1];
            System.arraycopy(buf, 0 , this.priorityQueue, 0 , buf.length);
        } else if (!isIncrease) {
            Item[] buf = this.priorityQueue;
            this.priorityQueue = (Item[]) new Comparable[priorityQueue.length - 1];
            System.arraycopy(buf, 1, this.priorityQueue, 0, buf.length-1);
        }
    }

    private void swap(int index1, int index2) {
        Item temp = priorityQueue[index1];
        priorityQueue[index1] = priorityQueue[index2];
        priorityQueue[index2] = temp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append("[");
        if (this.priorityQueue.length > 0) {
            for (int i = 0; i < this.priorityQueue.length; i++) {
                builder.append(this.priorityQueue[i]).append(", ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }


    public static void main(String[] args) {
        MyPriorityQueue<String> myPriorityQueue = new MyPriorityQueue<>(1);
        System.out.println(myPriorityQueue);
        myPriorityQueue.insert("e");
        myPriorityQueue.insert("d");
        myPriorityQueue.insert("c");
        myPriorityQueue.insert("b");
        myPriorityQueue.insert("a");
        System.out.println(myPriorityQueue);
        myPriorityQueue.remove();
        System.out.println(myPriorityQueue);
        myPriorityQueue.remove();
        System.out.println(myPriorityQueue);
        myPriorityQueue.remove();
        System.out.println(myPriorityQueue);
        myPriorityQueue.remove();
        System.out.println(myPriorityQueue);
        myPriorityQueue.remove();
        System.out.println(myPriorityQueue);
        myPriorityQueue.remove();
        System.out.println(myPriorityQueue);
        myPriorityQueue.remove();
        System.out.println(myPriorityQueue);
    }
}
