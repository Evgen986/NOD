import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NOD {
    private final List<Integer> listNumbers;

    public NOD(List<Integer> listNumbers) {
        this.listNumbers = listNumbers;
    }

    public int findNOK(){
        listNumbers.sort(Integer::compareTo);
        Collections.reverse(listNumbers);
        List<List<Integer>> multipliers = new ArrayList<>();
        for(Integer el : listNumbers){
            if (el > 0) multipliers.add(multipliers(el));
        }
        int result = 1;
        for (int i = 0; i < multipliers.size()-1; i++){
            for (int j = 0; j < multipliers.get(i).size(); j++){
                for (int k = multipliers.size()-1; k > i; k--){
                    multipliers.get(k).remove(multipliers.get(i).get(j));
                }
            }
        }
        for (List<Integer> multiplier : multipliers) {
            result *= multiplier.stream().reduce((acc, num) -> acc * num).orElse(1);
        }
        return result;
    }

    private List<Integer> multipliers(int numOriginal){
        int num = numOriginal;
        List <Integer> multi = new ArrayList<>();
        while (num != 1){
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    multi.add(i);
                    num /= i;
                    break;
                }
            }
        }
        multi.sort(Integer::compareTo);
        System.out.println("Простые множители числа " + numOriginal + " = " + multi);
        return multi;
    }

    @Override
    public String toString() {
        return listNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" : ", "(", ")"));
    }
}
