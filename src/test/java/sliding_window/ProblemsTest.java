package sliding_window;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ProblemsTest {
    @Test
    public void problem1(){
        assertEquals(9, Problems.problem1(new int[]{2, 1, 5, 1, 3, 2}, 3));
        assertEquals(7, Problems.problem1(new int[]{2, 3, 4, 1, 5}, 2));
    }

    @Test
    public void problem2(){
        assertEquals(2, Problems.problem2(new int[]{2, 1, 5, 2, 3, 2}, 7));
        assertEquals(1, Problems.problem2(new int[]{2, 3, 5, 2, 8}, 7));
        assertEquals( 3, Problems.problem2(new int[]{3, 4, 1, 1, 6}, 8));
    }

    @Test
    public void problem3(){
        assertEquals(4, Problems.problem3("araaci", 2));
        assertEquals(2, Problems.problem3("araaci", 1));
        assertEquals(5, Problems.problem3("cbbebi", 3));
    }

    @Test
    public void problem4(){
        assertEquals(3, Problems.problem4(new char[]{'A', 'B', 'C', 'A', 'C'}));
        assertEquals(5, Problems.problem4(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }

    @Test
    public void problem5(){
        assertEquals(3, Problems.problem5("aabccbb"));
        assertEquals(2, Problems.problem5("abbbb"));
        assertEquals(3, Problems.problem5("abccde"));
    }

    @Test
    public void problem6(){
        assertEquals(5, Problems.problem6("aabccbb", 2));
        assertEquals(4, Problems.problem6("abbcb", 1));
        assertEquals(3, Problems.problem6("abccde", 1));
    }

    @Test
    public void problem7(){
        assertEquals(6, Problems.problem7(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        assertEquals(9, Problems.problem7(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }

    @Test
    public void problem8(){
        assertTrue(Problems.problem8("oidbcaf", "abc"));
        assertFalse(Problems.problem8("odicf", "dc"));
        assertTrue(Problems.problem8("bcdxabcdy", "bcdyabcdx"));
        assertTrue(Problems.problem8("aaacb", "abc"));
    }

    @Test
    public void problem9(){
        assertEquals(Arrays.asList(1, 2), Problems.problem9("ppqp", "pq"));
        assertEquals(Arrays.asList(2, 3, 4), Problems.problem9("abbcabc", "abc"));
    }

    @Test
    public void problem10(){
        assertEquals("abdec", Problems.problem10("aabdec", "abc"));
        assertEquals("abc", Problems.problem10("abdabca", "abc"));
        assertEquals("", Problems.problem10("adcad", "abc"));
    }
}