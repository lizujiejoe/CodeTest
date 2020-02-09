import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Stage 2 digit-letter converter, support digits from 0-99
 */
public class Stage2Converter extends DigitLetterConverter {
    @Override
    public List<List<String>> getLetterList(List<Integer> digitList) {
        return digitList.stream()
                .filter(x -> x >= 0 && x <= 99)
                .map(x -> {
                    List<String> tempList = new ArrayList<String>();
                    tempList.addAll(asList(digitCharArray[x / 10]));
                    tempList.addAll(asList(digitCharArray[x % 10]));
                    return tempList;
                    // if not allow duplicate letter mapped by 1 digit(number?) like 22,33,44
//                    return tempList.stream().distinct().collect(Collectors.toList());
                })
                .collect(Collectors.toList());
    }
}
