import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String args[]) throws IOException {
        while (true) {
            System.out.println("\nPlease enter stage(1 or 2), enter Q to exit: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String cmd = reader.readLine();
            DigitLetterConverter converter = null;

            switch (cmd) {
                case "1":
                    converter = new Stage1Converter();
                    break;
                case "2":
                    converter = new Stage2Converter();
                    break;
                case "q":
                case "Q":
                    System.exit(0);
                default:
                    continue;
            }

            System.out.println("Please input digit array, use blank or comma as a delimiter");
            String inputValue = reader.readLine();
            List<Integer> digitList = getDigitList(inputValue);
            List<String> result = converter.getLetterCombinations(digitList);

            System.out.println(String.join(" ",result));
        }
    }

    /**
     * Get digit array from console
     *
     * @param source
     * @return
     */
    private static List<Integer> getDigitList(String source) {
        List<String> stringList = Arrays.asList(source.split("\\s+|,"));
        return stringList.stream()
                .filter(x -> x.matches("\\d{1,2}"))
                .map(y -> Integer.valueOf(y).intValue())
                .collect(Collectors.toList());
    }
}
