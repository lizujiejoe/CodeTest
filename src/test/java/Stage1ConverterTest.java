import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Stage1ConverterTest {
    @Test
    public void getStringList() {
        DigitLetterConverter converter = new Stage1Converter();

        List<List<String>> result = converter.getLetterList(Arrays.asList(1, 2, 3));
        // size
        assertEquals(3, result.size());
        assertEquals(0, result.get(0).size());
        assertEquals(3, result.get(1).size());
        assertEquals(3, result.get(2).size());
        // value
        assertArrayEquals(new String[]{"A", "B", "C"}, result.get(1).toArray());
        assertArrayEquals(new String[]{"D", "E", "F"}, result.get(2).toArray());
    }

    @Test
    public void getLetterCombinations() {
        DigitLetterConverter converter = new Stage1Converter();

        List<String> result = converter.getLetterCombinations(Arrays.asList(1, 2, 3));
        // size
        assertEquals(9, result.size());
        // value
        assertArrayEquals(new String[]{"AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"}, result.toArray());
    }
}
