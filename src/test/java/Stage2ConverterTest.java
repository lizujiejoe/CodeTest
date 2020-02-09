import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Stage2ConverterTest {
    @Test
    public void getStringList() {
        DigitLetterConverter converter = new Stage2Converter();

        // stage 2 should be compatible with stage 1, so this is not duplicate testing
        List<List<String>> result = converter.getLetterList(Arrays.asList(1, 2, 3));
        // size
        assertEquals(3, result.size());
        assertEquals(0, result.get(0).size());
        assertEquals(3, result.get(1).size());
        assertEquals(3, result.get(2).size());
        // value
        assertArrayEquals(new String[]{"A", "B", "C"}, result.get(1).toArray());
        assertArrayEquals(new String[]{"D", "E", "F"}, result.get(2).toArray());

        List<List<String>> result2 = converter.getLetterList(Arrays.asList(23, 45));
        // size
        assertEquals(2, result2.size());
        assertEquals(6, result2.get(0).size());
        assertEquals(6, result2.get(1).size());
        // value
        assertArrayEquals(new String[]{"A", "B", "C", "D", "E", "F"}, result2.get(0).toArray());
        assertArrayEquals(new String[]{"G", "H", "I", "J", "K", "L"}, result2.get(1).toArray());
    }

    @Test
    public void getLetterCombinations() {
        DigitLetterConverter converter = new Stage2Converter();

        List<String> result = converter.getLetterCombinations(Arrays.asList(1, 2, 3));
        // size
        assertEquals(9, result.size());
        // value
        assertArrayEquals(new String[]{"AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"}, result.toArray());

        List<String> result2 = converter.getLetterCombinations(Arrays.asList(23, 45));
        // size
        assertEquals(36, result2.size());
        // value
        assertArrayEquals(new String[]{
                        "AG", "AH", "AI", "AJ", "AK", "AL", "BG", "BH", "BI", "BJ", "BK", "BL",
                        "CG", "CH", "CI", "CJ", "CK", "CL", "DG", "DH", "DI", "DJ", "DK", "DL",
                        "EG", "EH", "EI", "EJ", "EK", "EL", "FG", "FH", "FI", "FJ", "FK", "FL"},
                result2.toArray());
    }
}
