import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void getStringList() {
        List<List<String>> result = App.GetStringList(new int[]{0, 1});
        assertEquals(result.size(), 2);
        assertEquals(result.get(0).size(), 0);

        List<List<String>> result2 = App.GetStringList(new int[]{});
        assertEquals("result2 list count incorrect.", 0, result2.size());

        List<List<String>> result3 = App.GetStringList(new int[]{3, 4});
        for (List<String> item : result3) {
            System.out.println(item);
        }
        // throws expected exception.
        ex.expect(IndexOutOfBoundsException.class);
        System.out.println(result3.get(2));
    }

    @Test
    public void cartesianProduct() {
        List<List<String>> input = App.GetStringList(new int[]{6, 7, 8});
        List<List<String>> result = new ArrayList<List<String>>();
        App.CartesianProduct(input, result, 0, new ArrayList<String>());

        for (List<String> item : result) {
            System.out.println(item);
        }
    }

    @Test
    public void getStringListEx() {
        List<List<String>> result = App.GetStringListEx(new int[]{9, 22});
        for (List<String> item : result) {
            System.out.println(item);
        }
    }
}