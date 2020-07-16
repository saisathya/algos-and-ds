package cyclic_sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProblemsTest {
    @Test
    public void problem1(){
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Problems.problem1(new int[] { 3, 1, 5, 4, 2 }));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, Problems.problem1(new int[] { 2, 6, 4, 3, 1, 5 }));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, Problems.problem1(new int[]{1, 5, 6, 4, 3, 2}));
    }

    @Test
    public void problem2(){
        assertEquals(2, Problems.problem2(new int[]{4, 0, 3, 1}));
        assertEquals(7, Problems.problem2(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }
}