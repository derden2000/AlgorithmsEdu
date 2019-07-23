package ru.antonshu.Alg3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyStackStringTest {


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        int arrayCapacity = 20;
        String[] str1 = new String[arrayCapacity],
                 str2 = new String[arrayCapacity],
                 str3 = new String[arrayCapacity],
                 str4 = new String[arrayCapacity],
                 str5 = new String[arrayCapacity],
                 str6 = new String[arrayCapacity];


        for (int i = 0; i < arrayCapacity; i++) {
            str1[i] = "/" + i;
        }
        for (int i = 0; i < str2.length; i++) {
            str2[i] = str1[str1.length - 1  - i];
        }

        for (int i = 0; i < arrayCapacity; i++) {
            str3[i] = "/" + i*2;
        }
        for (int i = 0; i < str4.length; i++) {
            str4[i] = str3[str3.length - 1-  i];
        }

        for (int i = 0; i < arrayCapacity; i++) {
            str5[i] = "/" + i*3;
        }
        for (int i = 0; i < str6.length; i++) {
            str6[i] = str5[str5.length - 1 - i];
        }


        return Arrays.asList(new Object[][] {
                {str1, str2},
                {str3, str4},
                {str5, str6}
        });
    }

    private MyStack<String> stack;

    private String[] in, out;

    public MyStackStringTest(String[] in, String[] out) {
        this.in = in;
        this.out = out;
    }

    @Before
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void StackIntegerTest() {
        for (int i = 0; i < in.length; i++) {
            stack.addElement(in[i]);
        }

        String[] res = new String[stack.getSize()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.getLastElement();
            stack.delElement();
        }
        Assert.assertArrayEquals(out, res);

    }
}
