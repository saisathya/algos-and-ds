package top_k_elements;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static top_k_elements.Problems.*;
import java.util.*;

public class ProblemsTest {
    @Test
    public void testProblem1(){
        assertThat(problem1(new int[]{3, 1, 5, 12, 2, 11}, 3), containsInAnyOrder(5, 12, 11));
        assertThat(problem1(new int[]{5, 12, 11, -1, 12}, 3), containsInAnyOrder(12, 11, 12));
    }

    @Test
    public void testProblem2(){
        assertEquals(5, problem2(new int[]{1, 5, 12, 2, 11, 5}, 3));
        assertEquals(5, problem2(new int[]{1, 5, 2, 11, 5}, 4));
        assertEquals(11, problem2(new int[]{5, 12, 11, -1, 12}, 3));
    }

    @Test
    public void testProblem3(){
        assertThat(problem3(new int[][]{array(0, 1), array(3, 1), array(-1, -1), array(-4, 1), array(0, 0)}, 3),
                containsInAnyOrder(array(0,1), array(-1, -1), array(0, 0 )));
        assertThat(problem3(new int[][]{array(1, 2), array(1, 3)}, 1), containsInAnyOrder(array(1, 2)));
        assertThat(problem3(new int[][]{array(1, 3), array(3, 4), array(2, -1)}, 2), containsInAnyOrder(array(1, 3), array(2, -1)));
    }

    @Test
    public void testProblem4(){
        assertEquals(33, problem4(array(1, 3, 11, 5)));
        assertEquals(36, problem4(array(3, 4, 5, 6)));
        assertEquals(42, problem4(array(1, 3, 11, 5, 2)));
    }

    @Test
    public void testProblem5(){
        assertThat(problem5(array(1, 3, 5, 12, 11, 12, 11), 2), containsInAnyOrder(11, 12));
        assertThat(problem5(array(5, 12, 11, 3, 11), 2), anyOf(containsInAnyOrder(11, 12), containsInAnyOrder(11, 3), containsInAnyOrder(11, 5)));
    }

    @Test
    public void testProblem6(){
        assertEquals("ggmmrrainop", problem6("programming"));
        assertEquals("bbbaac", problem6("abcbab"));
    }

    @Test
    public void testProblem7(){
        Problem7 problem7 = new Problem7(array(12, 2, 1, 7, 3, 6, 5, 10), 5);
        assertEquals(5, problem7.add(3));
        assertEquals(6, problem7.add(7));
        assertEquals(6, problem7.add(6));
        problem7 = new Problem7(array(3, 1, 5, 12, 2, 11), 4);
        assertEquals(5, problem7.add(6));
        assertEquals(6, problem7.add(13));
        assertEquals(6, problem7.add(4));
    }

    @Test
    public void testProblem8(){
        assertArrayEquals(array(6, 7, 8), problem8(array(5, 6, 7, 8, 9), 3, 7));
        assertArrayEquals(array(4, 5, 6), problem8(array(2, 4, 5, 6, 9), 3, 6));
        assertArrayEquals(array(5, 6, 9), problem8(array(2, 4, 5, 6, 9), 3, 10));
    }

    @Test
    public void testProblem9(){
        assertEquals(3, problem9(array(7, 3, 5, 8, 5, 3, 3), 2));
        assertEquals(2, problem9(array(3, 5, 12, 11, 12), 3));
        assertEquals(3, problem9(array(1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5), 2));
    }

    @Test
    public void testProblem10(){
        assertEquals(23, problem10(array(1, 3, 12, 5, 15, 11), 3, 6));
        assertEquals(12, problem10(array(3, 5, 8, 7),1,4));
    }

    @Test
    public void testProblem11(){
        assertTrue(noSameAdjChars(problem11("aapp"), 2));
        assertTrue(noSameAdjChars(problem11("Programming"), 2));
        assertEquals("", problem11("aapa"));
    }

    @Test
    public void testProblem12(){
        assertTrue(noSameAdjChars(problem12("mmpp", 2), 2));
        assertTrue(noSameAdjChars(problem12("Programming", 3), 2));
        assertTrue(noSameAdjChars(problem12("aab", 2), 2));
        assertEquals("", problem12("aappa", 3));
    }

    @Test
    public void testProblem13(){
        assertEquals(7, problem13(array('a', 'a', 'a', 'b', 'c', 'c'), 2));
        assertEquals(5, problem13(array('a', 'b', 'a'), 3));
    }

    @Test
    public void testProblem14(){
        Problem14 problem14 = new Problem14();
        problem14.push(1);
        problem14.push(2);
        problem14.push(3);
        problem14.push(2);
        problem14.push(1);
        problem14.push(2);
        problem14.push(5);
        assertEquals(2, problem14.pop());
        assertEquals(1, problem14.pop());
        assertEquals(2, problem14.pop());
    }

    public static boolean noSameAdjChars(String s, int k){
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        for(; right < s.length(); right++){
            if(right >= k){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            if(right - left + 1 == k && set.size() != k)
                return false;
        }
        return true;
    }

    private static int[] array(int ...nums){
        return nums;
    }

    private static char[] array(char ...chars){
        return chars;
    }

}