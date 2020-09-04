import java.io.FileNotFoundException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        Interpreter interpreter = new Interpreter();
        String[] table = interpreter.readFileIntoArray("input.txt");
        List<Pair> list = interpreter.splitStringsInArray(table);
        System.out.println(interpreter.calculateOperationsChain(list));

    }
}
