package ru.antonshu.Alg2;

import java.util.Comparator;

public class CustomArr {
    private int[] arr;

    public CustomArr(int size){
        this.arr = new int[size];
        for (int i = 0; i < size; i++) {
            this.arr[i] = (int) (Math.random() * size);
        }
    }

    public void swap(int firstIndex, int secondIndex) {
        int num = this.arr[firstIndex];
        this.arr[firstIndex] = this.arr[secondIndex];
        this.arr[secondIndex] = num;
    }

    public void bubbleSort() {
        for (int external = this.arr.length-1; external >= 1 ; external--) {
            for (int internal = 0; internal < external; internal++) {
                if (arr[internal] > arr[internal+1]) {
                    swap(internal, internal+1);
                }
            }
        }
    }

    public void bubbleSort(Comparator comparator) {
        for (int external = this.arr.length-1; external >= 1 ; external--) {
            for (int internal = 0; internal < external; internal++) {
                if (comparator.compare(arr[internal], arr[internal+1]) > 0) {
                    swap(internal, internal+1);
                }
            }
        }
    }

    public void selectSort() {
        int internal, external, marker;
        for(external = 0; external < this.arr.length; external++){
            marker = external;
            for(internal = external+1; internal < this.arr.length; internal++){
                if (this.arr[internal] < this.arr[marker]){
                    marker = internal;
                }
            }
            swap(external, marker);
        }
    }

    public void selectSort(Comparator comparator) {
        int internal, external, marker;
        for(external = 0; external < this.arr.length; external++){
            marker = external;
            for(internal = external+1; internal < this.arr.length; internal++){
                if (comparator.compare(this.arr[internal], this.arr[marker]) < 0){
                    marker = internal;
                }
            }
            swap(external, marker);
        }
    }

    public void insertSort() {
        int internal, external;
        for(external = 1; external < this.arr.length; external++){
            int num = this.arr[external];
            internal = external;
            while(internal > 0 && this.arr[internal-1] >= num){
                this.arr[internal] = this.arr[internal-1];
                --internal;
            }
            this.arr[internal] = num;
        }
    }

    public void insertSort(Comparator comparator) {
        int internal, external;
        for(external = 1; external < this.arr.length; external++){
            int num = this.arr[external];
            internal = external;
            while(internal > 0 && comparator.compare(this.arr[internal-1], num) >= 0){
                this.arr[internal] = this.arr[internal-1];
                --internal;
            }
            this.arr[internal] = num;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append("[");
        if (arr.length>0) {
            for (Integer item : this.arr) {
                builder.append(item).append(", ");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        CustomArr arr = new CustomArr(10);
        System.out.println(arr);
        arr.bubbleSort(Comparator.reverseOrder());
        System.out.println(arr);
        System.out.println();

        arr = new CustomArr(10);
        System.out.println(arr);
        arr.selectSort(Comparator.reverseOrder());
        System.out.println(arr);
        System.out.println();

        arr = new CustomArr(10);
        System.out.println(arr);
        arr.insertSort(Comparator.reverseOrder());
        System.out.println(arr);
    }
}