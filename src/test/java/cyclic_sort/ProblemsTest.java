package cyclic_sort;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void problem3(){
        assertThat(Problems.problem3(new int[]{1, 4, 2, 2, 4}), containsInAnyOrder(3, 5));
        assertThat(Problems.problem3(new int[]{2, 3, 1, 8, 2, 3, 5, 1}), containsInAnyOrder(4, 6, 7));
        assertThat(Problems.problem3(new int[]{2, 4, 1, 2}), containsInAnyOrder(3));
        assertThat(Problems.problem3(new int[]{2, 3, 2, 1}), containsInAnyOrder(4));
    }

    @Test
    public void problem4(){
        assertEquals(4, Problems.problem4(new int[]{1, 4, 4, 3, 2}));
        assertEquals(3, Problems.problem4(new int[]{2, 1, 3, 3, 5, 4}));
        assertEquals(4, Problems.problem4(new int[]{2, 4, 1, 4, 4}));
    }

    @Test
    public void problem5(){
        assertArrayEquals(new int[]{2, 4}, Problems.problem5(new int[]{3, 1, 2, 5, 2}));
        assertArrayEquals(new int[]{3, 5}, Problems.problem5(new int[]{3, 1, 2, 3, 6, 4}));
    }

    @Test
    public void problem6(){
        assertEquals(3, Problems.problem6(new int[]{-3, 1 ,5, 4, 2}));
        assertEquals(4, Problems.problem6(new int[]{3, -2, 0, 1, 2}));
        assertEquals(4, Problems.problem6(new int[]{3, 2, 5, 1}));
    }

    @Test
    public void problem7(){
        assertThat(Problems.problem7(new int[]{3, -1, 4, 5, 5}, 3), hasItems(1, 2, 6));
        assertThat(Problems.problem7(new int[]{2, 3, 4}, 3), hasItems(1, 5, 6));
        assertThat(Problems.problem7(new int[]{-2, -3, 4}, 2), hasItems(1, 2));
    }
}