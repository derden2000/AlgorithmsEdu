package ru.antonshu.Alg3;

import java.util.Scanner;

public class StringReverse {

    private static String inputString;

    StringReverse(String input) {
        inputString = input;
    }

    String printReverseText() {
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        MyStack<Character> incomData = new MyStack<>();
        char[] textIn = inputString.toCharArray();
        for (char c : textIn) {
            incomData.addElement(c);
        }
        int dataSize = incomData.getSize();
        for (int i = 0; i < dataSize; i++) {
            builder.append(incomData.getLastElement());
            incomData.delElement();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringReverse reader = new StringReverse(input.nextLine());

        System.out.println(reader.printReverseText());
    }

}
