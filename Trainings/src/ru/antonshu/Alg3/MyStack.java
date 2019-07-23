package ru.antonshu.Alg3;

public class MyStack<Item> {

    private int size;
    private Item[] stack;
    private int lastElementIndex;

    private MyStack(int size) {
        this.size = size;
        this.stack = (Item[]) new Object[size];
        this.lastElementIndex = size-1;
    }

    MyStack() {
        this.size = 0;
        this.stack = (Item[]) new Object[size];
        this.lastElementIndex = size - 1;
    }

    private boolean isEmpty(){
        return (size == 0);
    }

    private boolean isFull(){
        return (lastElementIndex == size);
    }

    int getSize() {
        return stack.length/*size*/;
    }

    void addElement(Item element){
            reCapasity(true);
            this.stack[lastElementIndex] = element;
//            lastElementIndex++;
    }

    void delElement(){
        if (size > 0) {
            Item buf = getLastElement();
            this.stack[lastElementIndex] = null;
            reCapasity(false);
        } else {
            System.out.println("Удаление запрещено. Элементов не осталось, Стек - пустой");
        }
    }

    Item getLastElement() {
        if (!isEmpty()) {
            return this.stack[lastElementIndex];
        } else {
            return null;
        }
    }

    private void reCapasity(boolean isIncrease) {
        if (isIncrease) {
            Item[] buf = this.stack;
            this.stack =  (Item[]) new Object[size + 1];
            System.arraycopy(buf, 0, this.stack, 0, buf.length);
            this.size++;
            lastElementIndex++;
        } else if (!isIncrease) {
            Item[] buf = this.stack;
            this.stack =  (Item[]) new Object[size - 1];
            System.arraycopy(buf, 0, this.stack, 0, buf.length-1);
            this.size--;
            lastElementIndex--;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append("[");
        if (this.size>0) {
            for (Item item : this.stack) {
                builder.append(item).append(", ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println((char) (Math.random() * 128));
        }
        System.out.println((char) (Math.random() * 128));

//        MyStack<Integer> stack = new MyStack<>(3);
        MyStack<Integer> stack = new MyStack<>();
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
        stack.addElement(1);
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
        stack.addElement(2);
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
        stack.addElement(3);
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
        stack.delElement();
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
        stack.delElement();
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
        stack.delElement();
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
        stack.delElement();
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
        stack.delElement();
        System.out.println(stack);
        System.out.println("stack.getLastElement(): " + stack.getLastElement());
    }
}
