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

        List<String> output = new ArrayList<>();
        output.add(s);

        int letters = 0;
        for(char c : s.toCharArray())
            if(Character.isLetter(c)) letters++;

        problem4_helper(new StringBuilder(s), output, new HashSet<>(), new StringBuilder());
        System.out.println(output);
        return output;
    }

    public static void problem4_helper(StringBuilder s, List<String> output, Set<Integer> used, StringBuilder curr){
        if(s.length() == curr.length()){
            output.add(curr.toString());
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(!used.contains(i)){
                char c = s.charAt(i);
                StringBuilder sb = new StringBuilder(curr);
                if(Character.isLetter(c))
                    sb.append(Character.toUpperCase(c));
                else
                    sb.append(c);
                used.add(i);
                problem4_helper(s, output, used, sb);
                used.remove(i);
            }
        }
    }
}
