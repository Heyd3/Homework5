package DictionaryGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = null;

        while (!"end".equals(input)) {
            input = scanner.nextLine();
            list.add(input);
            list.stream()
                    .flatMap(value -> Arrays.stream(value.split(" ")))
                    .distinct()
                    .sorted(Comparator.naturalOrder())
                    .forEach(System.out::println);
        }
    }
}

