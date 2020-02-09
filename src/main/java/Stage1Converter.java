import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Stage 1 digit-letter converter, support digits from 0-9
 */
public class Stage1Converter extends DigitLetterConverter {
    @Override
    public List<List<String>> getLetterList(List<Integer> digitList) {
       return digitList.stream()
                .filter(x -> x >= 0 && x <= 9)
                .map(x->asList(digitCharArray[x]))
                .collect(Collectors.toList());
    }
}
