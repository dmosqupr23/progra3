package backtracking;
import java.util.ArrayList;
import java.util.List;

public class SubsetGenerator {

    public static List<List<Integer>> subsets(List<Integer> elements, List<Integer> subsets, List<List<Integer>> result) {
        // If the list of elements is empty, add the current subset to the list of subsets
        if (elements.isEmpty()) {
            result.add(subsets);
            return result;
        }

        // For each element in the list of elements, add it to the current subset and recursively call the function
        // with the remaining elements and the updated subset
        for (Integer element : elements) {
            List<Integer> newSubset = new ArrayList<>(subsets);
            newSubset.add(element);
            subsets(elements.subList(1, elements.size()), newSubset, result);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> elements = List.of(1, 2, 3);
        List<List<Integer>> allSubsets = subsets(elements, new ArrayList<>(), new ArrayList<>());

        // Print the list of all subsets
        for (List<Integer> subset : allSubsets) {
            System.out.println(subset);
        }
    }
}