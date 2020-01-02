import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class App {
    private static String[][] _arr = {{}, {}, {"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}, {"J", "K", "L"}, {"M", "N", "O"}, {"P", "Q", "R", "S"}, {"T", "U", "V"}, {"W", "X", "Y", "Z"}};

    public static List<List<String>> GetStringList(int[] digitArr) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int digit : digitArr) {
            if (digit >= 0 && digit <= 9) {
                result.add(asList(_arr[digit]));
            }
        }

        return result;
    }

    public static List<List<String>> GetStringListEx(int[] digitArr) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int digit : digitArr) {
            if (digit >= 0 && digit <= 9) {
                result.add(asList(_arr[digit]));
            } else if (digit > 9 && digit <= 99) {
                List<String> tempList = new ArrayList<String>();
                tempList.addAll(asList(_arr[digit / 10]));
                tempList.addAll(asList(_arr[digit % 10]));
                result.add(tempList);
            }
        }

        return result;
    }

    public static void CartesianProduct(List<List<String>> src, List<List<String>> dest, int layer, List<String> curList) {
        if (layer < src.size() - 1) {
            if (src.get(layer).size() == 0) {
                CartesianProduct(src, dest, layer + 1, curList);
            } else {
                for (int i = 0; i < src.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(src.get(layer).get(i));
                    CartesianProduct(src, dest, layer + 1, list);
                }
            }
        } else if (layer == src.size() - 1) {
            if (src.get(layer).size() == 0) {
                dest.add(curList);
            } else {
                for (int i = 0; i < src.get(layer).size(); i++) {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(src.get(layer).get(i));
                    dest.add(list);
                }
            }
        }
    }
}
