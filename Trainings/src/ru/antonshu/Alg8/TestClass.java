package ru.antonshu.Alg8;

public class TestClass {
    public static void main(String[] args) {
        ChainingHashMap<Integer, String> myHashMap = new ChainingHashMap<>();

        myHashMap.put(1, "One");
        myHashMap.put(2, "Two");
        myHashMap.put(3, "Three");
        myHashMap.put(4, "Four");
        myHashMap.put(4, "Five");

//
//
//
        System.out.println("myHashMap: \n" + myHashMap);

        myHashMap.delete(2);
        System.out.println("myHashMap: \n" + myHashMap);

    }
}
