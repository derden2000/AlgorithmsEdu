package ru.antonshu.Alg2;

public class SortDiffs {
    private static long bubbleSortTime, insertSortTime, selectSortTime;
    private static final int ARRSIZE = 500000;

    public static void main(String[] args) {
        long appStartTime = System.currentTimeMillis();

        CustomArr arr = new CustomArr(ARRSIZE);
        long startTime = System.currentTimeMillis();
        arr.bubbleSort();
        bubbleSortTime = System.currentTimeMillis() - startTime;
        System.out.println("bubbleSortTime в секундах: " + bubbleSortTime/1000);

        arr = new CustomArr(ARRSIZE);
        startTime = System.currentTimeMillis();
        arr.selectSort();
        selectSortTime = System.currentTimeMillis() - startTime;
        System.out.println("selectSortTime в секундах: " + selectSortTime/1000);

        arr = new CustomArr(ARRSIZE);
        startTime = System.currentTimeMillis();
        arr.insertSort();
        insertSortTime = System.currentTimeMillis() - startTime;
        System.out.println("insertSortTime в секундах: " + insertSortTime/1000);
        long appFinishTime = System.currentTimeMillis();
        System.out.println("Время выполнения программы: " + ((int)(appFinishTime - appStartTime)/60000) + " минут, "
                + ((int) (((appFinishTime - appStartTime)/1000)%60)) + " секунд");

    }
}
