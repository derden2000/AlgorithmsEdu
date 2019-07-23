package ru.antonshu.Alg3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class StringReverseTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        int stringLength = 20;
        String str1 = new String(),
                str2 = new String(),
                str3 = new String(),
                str4 = new String(),
                str5 = new String(),
                str6 = new String();


        for (int i = 0; i < stringLength; i++) {
            str1 += (char) (Math.random() * 128);
        }
        for (int i = 0; i < str1.length(); i++) {
            str2 += str1.charAt(str1.length() - 1 - i);
        }

        for (int i = 0; i < stringLength; i++) {
            str3 += (char) (Math.random() * 128);
        }
        for (int i = 0; i < str1.length(); i++) {
            str4 += str3.charAt(str3.length() - 1 - i);
        }

        for (int i = 0; i < stringLength; i++) {
            str5 += (char) (Math.random() * 128);
        }
        for (int i = 0; i < str1.length(); i++) {
            str6 += str5.charAt(str5.length() - 1 - i);
        }

        return Arrays.asList(new Object[][] {
                {str1, str2},
                {str3, str4},
                {str5, str6}
        });
    }

    private String in, out;

    private StringReverse string;

    public StringReverseTest(String in, String out) {
        this.in = in;
        this.out = out;
    }

    @Before
    public void setUp() {
        string = new StringReverse(in);
    }

    @Test
    public void StringTest() {
        string.printReverseText();
        String res = string.printReverseText();

        Assert.assertEquals(res, out);
    }

}