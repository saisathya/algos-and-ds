package subsets_permutations;
import java.util.*;

public class Problems {

    /**
     * Given a list of unique integers, return all the subsets
     */
    public static List<List<Integer>> problem1(int[] arr) {
        if (arr == null)
            return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for (int num : arr) {
            int n = output.size();
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>(output.get(i));
                list.add(num);
                output.add(list);
            }
        }

        return output;
    }

    /**
     * Subsets with duplicates
     */
    public static List<List<Integer>> problem2(int[] arr) {
        if (arr == null)
            return new ArrayList<>();
        Set<List<Integer>> output = new HashSet<>();
        output.add(new ArrayList<>());

        for (int num : arr) {
            Set<List<Integer>> temp = new HashSet<>();
            for (List<Integer> list : output) {
                List<Integer> l = new ArrayList<>(list);
                l.add(num);
                temp.add(l);
            }
            output.addAll(temp);
        }

        return new ArrayList<>(output);
    }

    /**
     * Given a list of unique numbers, find all permutations
     */
    public static List<List<Integer>> problem3(int[] arr) {
        if (arr == null)
            return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        problem3_helper(arr, new HashSet<>(), new ArrayList<>(), output);
        return output;
    }

    private static void problem3_helper(int[] arr, Set<Integer> used, List<Integer> curr, List<List<Integer>> output) {
        if (curr.size() == arr.length) {
            output.add(curr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used.contains(i)) {
                used.add(i);
                List<Integer> list = new ArrayList<>(curr);
                list.add(arr[i]);
                problem3_helper(arr, used, list, output);
                used.remove(i);
            }
        }
    }

    /**
     * Given a word, get all the permutations by changing the case. A word can contain lower case english letters and numbers
     */
    public static List<String> problem4(String s){
        if(s == null || s.length() == 0)
            return new ArrayList<>();

        Set<String> output = new HashSet<>();
        output.add(s);
        problem4_helper(new StringBuilder(s), output, new HashSet<>());
        return new ArrayList<>(output);
    }

    public static void problem4_helper(StringBuilder s, Set<String> output, Set<Integer> used){
        output.add(s.toString());
        for(int i  = 0; i < s.length(); i++){
            if(!used.contains(i)){
                used.add(i);
                StringBuilder sb = new StringBuilder(s);
                char c = sb.charAt(i);
                if(Character.isLetter(c))
                    sb.setCharAt(i, Character.toUpperCase(c));
                problem4_helper(sb, output, used);
                used.remove(i);
            }
        }
    }
}
