package ru.antonshu.Alg3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyStackIntegerTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,2,3,4,5,6,7,8,3,2,1}, new int[] {1,2,3,8,7,6,5,4,3,2,1}},
                {new int[]{4,5,6,7,4,5,6,3,4,5,6,7,8}, new int[]{8,7,6,5,4,3,6,5,4,7,6,5,4}},
                {new int[]{1,2,3,-4,5,4}, new int[] {4,5,-4,3,2,1}}
        });
    }

    private MyStack<Integer> stack;

    private int[] in, out;

    public MyStackIntegerTest(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    @Before
    public void setUp() throws Exception {
        stack = new MyStack<>();
    }

    @Test
    public void StackIntegerTest() {
        for (int i = 0; i < in.length; i++) {
            stack.addElement(in[i]);
        }

        int[] res = new int[stack.getSize()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.getLastElement();
            stack.delElement();
        }
        Assert.assertArrayEquals(out, res);

    }
}