import java.util.Scanner;
public class GraderTest {
    public static void main(String[] args) {
        int round = 0;
        while (round < 2) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter course name: ");
        Grader grader = new Grader(scn.next());
        System.out.print("Enter number of student: ");
        int n = scn.nextInt();
        System.out.println("\nInput scores");
        for (int i = 0; i < n; i++) {
            grader.addScores(scn.nextDouble());     //ForLoop รับค่าเเล้วส่งเข้าไปใน Method ของ Class Grader
        }
        System.out.printf("\nMean for %s = %.2f\n",grader.getCourseName(),grader.mean());
        System.out.println("Below mean = " + grader.belowMean());
        System.out.println("Above mean = " + grader.aboveMean());
        grader.showGrade();
        System.out.println("\n####################");
        round++;
        }
    }
}
