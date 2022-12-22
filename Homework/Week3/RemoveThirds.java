import java.util.ArrayList;
import java.util.List;
public class RemoveThirds {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>(List.of(1, 2, 3, 2, 5, 3, 1, 3, 9));
        int i = 0;
        while (i < lst.size()) {
            if (lst.get(i) % 3 == 0) {
                lst.remove(i);
            } else {
                i++;
            }
        }
        System.out.println(lst);
    }
}
