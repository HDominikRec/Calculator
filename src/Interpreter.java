import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Interpreter {

    public String[] readFileIntoArray(String pathname) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(pathname));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine().toUpperCase());
        }
        return lines.toArray(new String[0]);
    }

    public List<Pair> splitStringsInArray(@NotNull String[] input) {
        List<Pair> pairs = new LinkedList<>();
        for (String s : input) {
            String[] splits = s.split("\\s" +
                    "+");
            pairs.add(new Pair(splits[0], Double.parseDouble(splits[1])));
        }
        return pairs;
    }

    public double calculateOperationsChain(List<Pair> input) {

        double applyValue = getInitialValue(input);

        for (Pair pair : input) {
            applyValue = Operation.valueOf(pair.getKey())
                    .calculate(applyValue, pair.getValue());
        }
        return applyValue;
    }

    public double getInitialValue(List<Pair> input) {
        Optional<Pair> found = Optional.empty();
        for (Pair pair : input) {
            if (pair.getKey().equals(Operation.APPLY.name())) {
                found = Optional.of(pair);
                break;
            }
        }
        removeApplyPair(input);
        return found.get().getValue();
    }

    public void removeApplyPair(List<Pair> input) {
        input.removeIf(pair -> pair.getKey().equals(Operation.APPLY.name()));
    }
}
