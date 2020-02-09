import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract digit-letter converter
 */
public abstract class DigitLetterConverter {
    /**
     * digit-char mapping array, use digit as the index
     */
    protected String[][] digitCharArray = {
            {},
            {},
            {"A", "B", "C"},
            {"D", "E", "F"},
            {"G", "H", "I"},
            {"J", "K", "L"},
            {"M", "N", "O"},
            {"P", "Q", "R", "S"},
            {"T", "U", "V"},
            {"W", "X", "Y", "Z"}
    };

    /**
     * Get all possible letter combinations
     *
     * @param digitList
     * @return
     */
    public List<String> getLetterCombinations(List<Integer> digitList) {
        List<List<String>> input = getLetterList(digitList);
        List<List<String>> result = new ArrayList<List<String>>();

        cartesianProduct(input, result, 0, new ArrayList<String>());

        return result.stream().map(x -> String.join("", x)).collect(Collectors.toList());
    }

    /**
     * Get 2-d letter list by digits
     *
     * @param digitList
     * @return
     */
    public abstract List<List<String>> getLetterList(List<Integer> digitList);

    /**
     * Get all possible combinations by using Cartesian product
     *
     * @param source      source 2-d list
     * @param result      result 2-d list
     * @param layer       layer of the cartesian product
     * @param currentList current list
     */
    private void cartesianProduct(List<List<String>> source, List<List<String>> result, int layer, List<String> currentList) {
        if (layer < source.size() - 1) {
            if (source.get(layer).size() == 0) {
                cartesianProduct(source, result, layer + 1, currentList);
            } else {
                for (int i = 0; i < source.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(currentList);
                    list.add(source.get(layer).get(i));
                    cartesianProduct(source, result, layer + 1, list);
                }
            }
        } else if (layer == source.size() - 1) {
            if (source.get(layer).size() == 0) {
                result.add(currentList);
            } else {
                for (int i = 0; i < source.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(currentList);
                    list.add(source.get(layer).get(i));
                    result.add(list);
                }
            }
        }
    }
}
