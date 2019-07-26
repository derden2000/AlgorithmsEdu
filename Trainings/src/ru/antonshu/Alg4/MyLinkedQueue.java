package ru.antonshu.Alg4;

public class MyLinkedQueue<Item> {
    private MyDoubleSideLinkedList<Item> queue = new MyDoubleSideLinkedList<>();

    public void enqueue(Item value){
        queue.insertLastPlace(value);
    }

    public Item dequeue(){
        return queue.removeLastElement();
    }

    public Item peek(){
        return queue.getLastElement();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
