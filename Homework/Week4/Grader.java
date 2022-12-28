import java.util.ArrayList;
public class Grader {
    private final String course;
    ArrayList<Double> arrayList = new ArrayList<Double>();  //สร้าง Object ของ ArrayList
    public Grader(String name){
        this.course = name;        //เป็น Constructor รับชื่อวิชาเป็น Argument
    }
    public void addScores(double score){
        arrayList.add(score);      //ใช้ add ค่าเข้าไปใน ArrayList
    }
    public int countStudent(){
        return arrayList.size();   //ใช้ return size ทั้งหมดที่อยู่ในArrayList
    }
    public double mean(){
        double sum = 0;
        for(double numberArray : arrayList){
            sum += numberArray;     //ใช ForLoop บวกค่าที่อยู่ใน ArrayList เพื่อหาค่า Mean
        }
        return sum/countStudent();
    }
    public int belowMean(){
        int countbelow=0;
        for(double below : arrayList){
            if(below < mean()){
                countbelow++;      //ใช้ ForLoop เเละ check ว่ามีคนที่ต่ำกว่า Mean กี่คน
            }
        }
        return countbelow;
    }
    public int aboveMean(){
        int countabove=0;
        for(double above : arrayList){
            if(above >= mean()){
                countabove++;    //ใช้ ForLoop เเละ check ว่ามีคนที่สูงกว่า Mean กี่คน
            }
        }
        return countabove;
    }
    public void showGrade(){
        /*  เป็น Method ที่ใช้หาว่าใครมีเกรดเท่าไหร่กี่คนบ้าง */

        int A = 0,BPlus = 0,B = 0,CPlus = 0,C = 0,DPlus = 0 ,D=0,F=0;
        for(double countGrade : arrayList) {
            if(countGrade >= 80){
                A++;
            }else if(countGrade >= 75){
                BPlus++;
            }else if(countGrade >= 70){
                B++;
            }else if(countGrade >= 65){
                CPlus++;
            }else if(countGrade >= 60){
                C++;
            }else if(countGrade >= 55){
                DPlus++;
            }else if(countGrade >= 50){
                D++;
            }else{
                F++;
            }
        }
        System.out.printf("Grade : A %d, B+ %d, B %d, C+ %d, C %d, D+ %d, D %d, F %d ",A,BPlus,B,CPlus,C,DPlus,D,F);
    }
    public String getCourseName(){
        return course;
    }
}
