package ru.antonshu.Alg8;

import java.util.Iterator;
import java.util.LinkedList;

public class ChainingHashMap<Key, Value> {

    private int capacity = 5;
    private int size = 0;

    private LinkedList<Node>[] lists;

    public ChainingHashMap() {
        lists = new LinkedList[capacity];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть пустым(Null)");
        }
        return true;
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        int index = hash(key);
        for (Node node : lists[index]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        lists[index].addLast(new Node(key, value));
        size++;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        int i = hash(key);
        for (Node node : lists[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        for (int i = 0; i < lists.length; i++) {
            Iterator<Node> iterator = lists[i].iterator();
            while(iterator.hasNext()) {
                if(iterator.next().key.equals(key)) {
                    iterator.remove();
                    size--;
                }
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < capacity; i++) {
            for (Node node : lists[i]) {
                s += node.key.toString() + " ";
            }
            s += "\n";
        }
        return s;
    }
}
