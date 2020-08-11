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

    public static List<String> alternate_problem4(String s){
        if(s == null || s.length() == 0)
            return new ArrayList<>();
        List<String> output = new ArrayList<>();
        output.add(s);
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                int length = output.size();
                for(int j = 0; j < length; j++){
                    char c = output.get(j).charAt(i);
                    if(Character.isLowerCase(c)){
                        StringBuilder sb = new StringBuilder(output.get(j));
                        sb.setCharAt(i, Character.toUpperCase(c));
                        output.add(sb.toString());
                    }
                }
            }
        }
        System.out.println(output);
        return output;
    }

    /**
     * Given an integer, return a list of all strings of balanced parantheses
     */
    public static List<String> problem5(int n){
        if(n <= 0)
            return new ArrayList<>();
        List<String> output = new ArrayList<>();
        problem5_helper(output, new StringBuilder(), n, n);
        return output;
    }

    public static void problem5_helper(List<String> output, StringBuilder curr, int open, int close){
        if(open == 0 && close == 0){
            output.add(curr.toString());
            return;
        }
        if(open > 0){
            StringBuilder sb = new StringBuilder(curr);
            sb.append("(");
            problem5_helper(output, sb, open - 1, close);
        }
        if(close > open){
            StringBuilder sb = new StringBuilder(curr);
            sb.append(")");
            problem5_helper(output, sb, open, close - 1);
        }
    }

    public static List<String> alternative_problem5(int n){
        if(n <= 0)
          return new ArrayList<>();
        List<String> output = new ArrayList<>();
        output.add("(");
        List<int[]> dp = new ArrayList<>();
        dp.add(new int[]{n - 1, n});

        for(int i = 1; i < n * 2; i++){
            List<String> nOutput = new ArrayList<>();
            List<int[]> nDp = new ArrayList<>();
            for(int j = 0; j < output.size(); j++){
                int[] arr = dp.get(j);
                if(arr[0] > 0){
                    nOutput.add(output.get(j) + "(");
                    nDp.add(new int[]{arr[0] - 1, arr[1]});
                }
                if(arr[1] > arr[0]){
                    nOutput.add(output.get(j) + ")");
                    nDp.add(new int[]{arr[0], arr[1] - 1});
                }
            }
            dp = nDp; output = nOutput;
        }
        return output;
    }
}
