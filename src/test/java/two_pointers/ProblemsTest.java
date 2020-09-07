package two_pointers;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.*;
import static two_pointers.Problems.*;
public class ProblemsTest {

    @Test
    public void problem1(){
        assertArrayEquals(new int[]{1, 3},Problems.problem1(new int[]{1, 2, 3, 4, 6}, 6));
        assertArrayEquals(new int[]{0, 2}, Problems.problem1(new int[]{2,  5, 9, 11}, 11));
        assertArrayEquals(new int[]{-1, -1}, Problems.problem1(new int[]{2}, 5));
    }

    @Test
    public void problem2(){
        int[] one = new int[]{2, 3, 3, 3, 6, 9, 9};
        int res = Problems.problem2(one);
        assertEquals(4, res);
        noDuplicates(one, 4);

        one = new int[]{2, 2, 2, 11};
        res = Problems.problem2(one);
        assertEquals(2, res);
        noDuplicates(one, 2);
    }

    public static void noDuplicates(int[] arr, int k){
        for(int i = 1; i < k; i++)
            assert(arr[i - 1] != arr[i]);
    }

    @Test
    public void problem3(){
        assertArrayEquals(new int[]{0, 1, 4, 4, 9}, Problems.problem3(new int[]{-2, -1, 0, 2, 3}));
        assertArrayEquals(new int[]{0, 1, 1, 4, 9}, Problems.problem3(new int[]{-3, -1, 0, 1, 2}));
    }

    @Test
    public void problem4(){
        assertThat(Problems.problem4(new int[]{-3, 0, 1, 2, -1, 1, -2}), containsInAnyOrder(Arrays.asList(-3, 1, 2), Arrays.asList(-2, 0, 2), Arrays.asList(-2, 1, 1), Arrays.asList(-1, 0, 1)));
        assertThat(Problems.problem4(new int[]{-5, 2, -1, -2, 3}), containsInAnyOrder(Arrays.asList(-5, 2, 3), Arrays.asList(-2, -1, 3)));
    }

    @Test
    public void problem5(){
        assertEquals(1, Problems.problem5(new int[]{-2, 0, 1, 2}, 2));
        assertEquals(0, Problems.problem5(new int[]{-3, -1, 1, 2}, 1));
        assertEquals(3, Problems.problem5(new int[]{1, 0, 1, 1}, 100));
    }

    @Test
    public void problem6(){
        assertThat(Problems.problem6(new int[]{2, 5, 3, 10}, 30), containsInAnyOrder(Arrays.asList(2), Arrays.asList(5), Arrays.asList(3), Arrays.asList(10), Arrays.asList(2, 5),  Arrays.asList(5, 3)));
        assertThat(Problems.problem6(new int[]{8, 2, 6, 5}, 50), containsInAnyOrder(Arrays.asList(8), Arrays.asList(2), Arrays.asList(6), Arrays.asList(5), Arrays.asList(8, 2), Arrays.asList(2, 6), Arrays.asList(6, 5)));
    }

    @Test
    public void problem7(){
        int[] arr = new int[]{1, 0, 2, 1, 0};
        Problems.problem7(arr);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2}, arr);
        arr = new int[]{2, 2, 0, 1, 2, 0};
        Problems.problem7(arr);
        assertArrayEquals(new int[]{0, 0, 1, 2, 2, 2}, arr);
    }

    @Test
    public void problem8(){
        assertTrue(Problems.problem8("xy#z", "xzz#"));
        assertFalse(Problems.problem8("xy#z", "xyz#"));
        assertTrue(Problems.problem8("xp#", "xyz##"));
        assertTrue(Problems.problem8("xywrrmp", "xywrrmu#p"));
    }

    @Test
    public void problem9(){
        assertEquals(5, Problems.problem9(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        assertEquals(0, Problems.problem9(new int[]{1, 2, 3}));
        assertEquals(5, Problems.problem9(new int[]{1, 3, 2, 0, -1, 7, 10}));
        assertEquals(3, Problems.problem9(new int[]{3, 2, 1}));
    }

    @Test
    public void testPorblem10(){
        assertEquals(5, problem10(new int[]{2, 6, 4, 8, 10, 9, 15}));
        assertEquals(0, problem10(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}