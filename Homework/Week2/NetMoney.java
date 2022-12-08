import java.util.Scanner;
public class NetMoney {
    public static int taxIs(double total){
        if(total >= 0 && total <= 150000){
            return 0;
        }else if(total >= 150001 && total <= 300000){
            return 5;
        }else if(total >= 300001 && total <= 500000){
            return 10;
        }else if(total >= 500001 && total <= 750000){
            return 15;
        }else if(total >= 750001 && total <= 1000000){
            return 20;
        }else if(total >= 1000001 && total <= 2000000){
            return 25;
        }else if(total >= 2000001 && total <= 5000000) {
            return 30;
        }else{
            return 35;
        }
    }
    public static double yourTax(int taxIsTotal,double total){
        //150000 150000 200000 250000 250000 1000000 3000000 5000000
        String calTax[] = {
                "150000 * 5% = 7500",
                "200000 * 10% = 20000",
                "250000 * 15% = 37500",
                "250000 * 20% = 50000",
                "1000000 * 25% = 250000",
                "3000000 * 30% = 900000"
        };
        double numberCalTaxDouble[] = {
                0.05,
                0.1,
                0.15,
                0.2,
                0.25,
                0.3,
        };
        int numberCalTax[] = {
                150000,
                150000,
                200000,
                250000,
                250000,
                1000000,
                3000000,
                5000000
        };
        int rounds=0;
        double answer=0;
        switch(taxIsTotal){
            case 5:
                rounds=1;
                break;
            case 10:
                rounds=2;
                break;
            case 15:
                rounds=3;
                break;
            case 20:
                rounds=4;
                break;
            case 25:
                rounds=5;
                break;
            case 30:
                rounds=6;
                break;
            case 35:
                rounds=7;
                break;
        }
        if(rounds==1){
            answer=(total-150000)*0.05;
            System.out.printf("%nCal Tax %.0f - 150000 = %.0f * 5%s = %.0f",total,total-150000,"%",answer);
        }else{
            for(int index=rounds;index>0;index--){
                System.out.printf("%nStep %d%n",index);
                if(index==rounds){
                    System.out.printf("Cal Tax ");
                    for(int i=0;i<rounds;i++){
                        System.out.printf("%.0f - %d = ",total,numberCalTax[i]);
                        total-=numberCalTax[i];
                    }
                    answer+=total*((float)taxIsTotal/100);
                    System.out.printf("%.0f * %d%s = %.0f",total,taxIsTotal,"%",answer);

                }else {
                    System.out.printf("Cal Tax %s",calTax[index-1]);
                    answer+=(numberCalTax[index]*numberCalTaxDouble[index-1]);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        double salary,yearCost,taxDeduction,inputOtherIncome=0,total;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Salary: ");
        salary = scanner.nextDouble();
        System.out.print("Enter Year cost: ");
        yearCost = scanner.nextDouble();
        System.out.print("Enter Tax deduction: ");
        taxDeduction = scanner.nextDouble();
        System.out.printf("%nYou have other income?: ");
        char otherIncome = scanner.next().charAt(0);
        int compareOtherIncome = Character.compare(otherIncome,'Y');
        if(compareOtherIncome==0) {
            System.out.print("Input other income: ");
            inputOtherIncome = scanner.nextDouble();
            total=(salary*12)-yearCost-taxDeduction+inputOtherIncome;
            System.out.printf("Income : (%.0fx12) - %.0f - %.0f + %.0f = %.0f",salary,yearCost,taxDeduction,inputOtherIncome,total);
        }else{
            total=(salary*12)-yearCost-taxDeduction;
            System.out.printf("Income : (%.0fx12) - %.0f - %.0f = %.0f",salary,yearCost,taxDeduction,total);
        }
        System.out.printf("%nTax is %d%s%n",taxIs(total),"%");
        if(taxIs(total)==0) {
            System.out.printf("%nYour Tax = %s","Free Tax");
        }else{
            System.out.printf("%nYour Tax = %.0f BTH",yourTax(taxIs(total),total));
        }
    }
}
