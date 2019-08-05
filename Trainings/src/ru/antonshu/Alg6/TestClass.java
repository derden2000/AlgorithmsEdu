package ru.antonshu.Alg6;

public class TestClass {
    public static void main(String[] args) {

        BinarySearchTree<Integer, Integer>[] bstArray = new BinarySearchTree[20];
        for (int i = 0; i < bstArray.length; i++) {
            bstArray[i] = new BinarySearchTree<>();
            while (bstArray[i].getTreeLevel() < 6) {
                int num = (int) ((Math.random() * 200) - 100);
                bstArray[i].put(num, num);
            }
            System.out.println("Дерево: " + bstArray[i]);
            System.out.println("Размер: " + bstArray[i].size());
        }

        System.out.println("Процент сбалансированных деревьев: " + balancedPercent(bstArray));


    }

    private static double balancedPercent(BinarySearchTree[] bstArray) {
        int balancedTrees = 0, notBalancedTrees = 0;
        for (BinarySearchTree bstree : bstArray) {
            if (bstree.isBalancedTree()) {
                balancedTrees++;
            } else {
                notBalancedTrees++;
            }
        }
        System.out.println("Сбалансированных: " + balancedTrees);
        System.out.println("Всего: " + bstArray.length);
        return ((double) balancedTrees / bstArray.length) * 100;
    }
}
