package ru.antonshu.Alg3;

public class MyDeque<Item> {
    private int maxIndex;
    private int minIndex;
    private Item[] array;
    private int front;
    private int rear;
    private int items;


    public MyDeque(int s){
        maxIndex = s;
        minIndex = 0;
        array = (Item[]) new Object[maxIndex];
        front = maxIndex;
        rear = -1;
        items = 0;
    }

    private MyDeque() {
        maxIndex = 0;
        minIndex = 0;
        array = (Item[]) new Object[maxIndex];
        front = maxIndex;
        rear = -1;
        items = 0;
    }

    private void insertLeft(Item element){
        reCapasityLeft(1);
        if(rear == maxIndex)
            rear = minIndex;
        array[++rear] = element;
        items++;
    }

    private void insertRight(Item element){
        reCapasityRight(1);
        if(front == minIndex)
            front = maxIndex;
        array[--front] = element;
        items++;
    }

    private void removeRight(){
        if (array.length > 1 ) {
            Item temp = array[front++];
            array[maxIndex - 1] = null;
            if (front == maxIndex)
                front = 0;
            items--;
            reCapasityRight(-1);
        } else {
            System.out.println("Удаление запрещено. Нельзя удалять единственный элемент");
        }
    }
    private void removeLeft(){
        if (array.length > 1) {
            Item temp = array[rear--];
            array[minIndex] = null;
            if (rear == minIndex)
                rear = 0;
            items--;
            reCapasityLeft(-1);
        } else {
            System.out.println("Удаление запрещено. Нельзя удалять единственный элемент");
        }
    }

    private void reCapasityRight(int changeCapacityAt) {
        if (changeCapacityAt >0 ) {
            Item[] buf = this.array;
            this.array = (Item[]) new Object[maxIndex + changeCapacityAt];
            System.arraycopy(buf, 0, this.array, 1, buf.length);
            this.maxIndex++;
            this.front++;
        } else if (changeCapacityAt < 0) {
            Item[] buf = this.array;
            this.array = (Item[]) new Object[maxIndex + changeCapacityAt];
            System.arraycopy(buf, 0, this.array, 0, buf.length-1);
            this.maxIndex--;
            this.front--;
        }
    }

    private void reCapasityLeft(int changeCapacityAt) {
        if (changeCapacityAt > 0) {
            Item[] buf = this.array;
            this.array = (Item[]) new Object[maxIndex + changeCapacityAt];
            System.arraycopy(buf, 0, this.array, 1, buf.length);
            this.maxIndex++;
            this.rear=-1;
            this.front++;
        } else if (changeCapacityAt < 0) {
            Item[] buf = this.array;
            this.array = (Item[]) new Object[maxIndex + changeCapacityAt];
            System.arraycopy(buf, 1, this.array, 0, buf.length-1);
            this.maxIndex--;
            this.rear++;
            this.front--;
        }
    }

    public Item peek(){
        return array[front];
    }
    public boolean isEmpty(){
        return (items==0);
    }

    public boolean isFull(){
        return (items==maxIndex);
    }

    public int size(){
        return items;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append("[");
        if (this.maxIndex>0) {
            for (int i = 0; i < this.array.length; i++) {
                builder.append(this.array[i]).append(", ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
//        MyDeque<Integer> array = new MyDeque<>(5);
        MyDeque<Integer> deque = new MyDeque<>();
        System.out.println(deque);
        deque.insertRight(789);
        System.out.println(deque);
        deque.insertRight(789);
        System.out.println(deque);
        deque.insertLeft(123);
        System.out.println(deque);
        deque.insertLeft(123);
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        System.out.println(deque);
    }
}
