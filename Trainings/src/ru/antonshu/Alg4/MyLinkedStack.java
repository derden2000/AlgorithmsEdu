package ru.antonshu.Alg4;

public class MyLinkedStack<Item> {
    private MyDoubleSideLinkedList<Item> stack = new MyDoubleSideLinkedList<>();

    public void push(Item value){
        stack.insertFirstPlace(value);
    }

    public Item pop(){
        return stack.removeFirstElement();
    }

    public Item peek(){
        return stack.getFirstElement();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
