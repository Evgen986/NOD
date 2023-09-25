import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NOD nodNumbers = new NOD(new ArrayList<>(Arrays.asList(15,20,25)));
        System.out.printf("НОК чисел %s = %d", nodNumbers, nodNumbers.findNOK());
    }
}