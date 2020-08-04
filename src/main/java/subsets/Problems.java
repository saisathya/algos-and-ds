package subsets;
import java.util.*;

public class Problems {

    /**
     * Given a list of unique integers, return all the subsets
     */
    public static List<List<Integer>> problem1(int[] arr){
        if(arr == null)
            return new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());

        for(int num : arr){
            int n = output.size();
            for(int i = 0; i < n; i++){
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
    public static List<List<Integer>> problem2(int[] arr){
        if(arr == null)
            return new ArrayList<>();
        Set<List<Integer>> output = new HashSet<>();
        output.add(new ArrayList<>());

        for(int num : arr){
            Set<List<Integer>> temp = new HashSet<>();
            for(List<Integer> list : output){
                List<Integer> l = new ArrayList<>(list);
                l.add(num);
                temp.add(l);
            }
            output.addAll(temp);
        }


        return new ArrayList<>(output);
    }
}
