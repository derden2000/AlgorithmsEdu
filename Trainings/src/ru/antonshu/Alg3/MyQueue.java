package ru.antonshu.Alg3;

public class MyQueue<Item> {

    private int size;
    private Item[] queue;
    private int firstElementIndex;

    public MyQueue(int s){
        size = s;
        queue = (Item[]) new Object[size];
        firstElementIndex = 0;
    }

    private MyQueue() {
        size = 0;
        queue = (Item[]) new Object[size];
        firstElementIndex = 0;
    }

    private void insert(Item element){
        reCapacity(true);
        queue[size-1] = element;
    }

    private void remove(){
        if (queue.length > 0) {
            Item temp = queue[firstElementIndex];
            queue[firstElementIndex] = null;
            reCapacity(false);
        } else {
            System.out.println("Удаление запрещено. Элементов не осталось, Очередь - пуста");
        }
    }

    private Item getFirstElementIndex() {
        if (!isEmpty()) {
            return queue[firstElementIndex];
        } else {
            return null;
        }
    }
    private boolean isEmpty(){
        return (size==0);
    }

    private void reCapacity(boolean isIncrease) {
        if (isIncrease) {
            Item[] buf = this.queue;
            this.queue = (Item[]) new Object[size + 1];
            System.arraycopy(buf, 0 , this.queue, 0 , buf.length);
            this.size++;
        } else if (!isIncrease) {
            Item[] buf = this.queue;
            this.queue = (Item[]) new Object[size - 1];
            System.arraycopy(buf, 1, this.queue, 0, buf.length-1);
            this.size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append("[");
        if (this.size >0) {
            for (Item item : this.queue) {
                builder.append(item).append(", ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
//        MyQueue<Integer> queue = new MyQueue<>(3);
        MyQueue<Integer> queue = new MyQueue<>();
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());

        queue.insert(1);
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());

        queue.insert(2);
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());

        queue.insert(3);
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());

        queue.remove();
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());

        queue.remove();
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());

        queue.remove();
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());

        queue.remove();
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());

        queue.remove();
        System.out.println(queue);
        System.out.println("queue.getFirstElementIndex(): " + queue.getFirstElementIndex());
    }
}
