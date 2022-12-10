import java.util.Scanner;

public class PersonalTax {
    public static int taxRate(int netMoney){
        int rate;
        if(netMoney >=0 && netMoney <= 150000){
            rate = 0;
        }
        else if(netMoney >=150001 && netMoney <= 300000){
            rate = 5;
        }
        else if(netMoney >=300001 && netMoney <= 500000){
            rate = 10;
        }
        else if(netMoney >=500001 && netMoney <= 750000){
            rate = 15;
        }
        else if(netMoney >=750001 && netMoney <= 1000000){
            rate = 20;
        }
        else if(netMoney >=1000001 && netMoney <= 2000000){
            rate = 25;
        }
        else if(netMoney >=2000001 && netMoney <= 5000000){
            rate = 30;
        }
        else{
            rate = 35;
        }
        return rate;
    }
    public static void display(int rate,int netMoney){
        int nM = netMoney;
        float sumTax = 0;
        int[] taxMoney = {150000,150000,200000,200000,250000,250000,1000000,3000000};
        int[] taxStep = {7500,20000,37500,50000,250000,900000};
        System.out.println("Tax is "+rate+"%");
        if(rate != 0){
            int round = (rate/5);
            if(round > 1){
                System.out.println("Step "+round);
            }
            System.out.print("Cal Tax ");
            for(int i = 1;i<=(rate/5);i++){
                System.out.printf("%d - %d = ",nM,taxMoney[i-1]);
                nM-=taxMoney[i-1];
            }
            sumTax += (nM*(rate/100f));
            System.out.println(nM + " * " +rate + "%" + " = " + ((int)sumTax));
            for(int x = (rate/5)-2;x>=0;x--){
                System.out.println("Step " + --round);
                sumTax+=(float)taxStep[x];
                System.out.println("Cal Tax " + taxMoney[x] + " * " + (x+1)*5 + " = " + taxStep[x]);
            }
            System.out.println("Your Tax = " + (int)sumTax + " BTH");
        }
        else{
            System.out.println("Your Tax = Free Tax ");
        }
    }
    public static void main(String[] args) {
        int result;
        Scanner sc_salay = new Scanner(System.in);
        Scanner sc_cyear = new Scanner(System.in);
        Scanner sc_taxd = new Scanner(System.in);
        Scanner sc_incost = new Scanner(System.in);
        Scanner sc_str = new Scanner(System.in);
        System.out.print("Enter Salary : ");
        int salay = sc_salay.nextInt();
        System.out.print("Enter Year cost : ");
        int costYear = sc_cyear.nextInt();
        System.out.print("Enter Tax : ");
        int taxDeuction = sc_taxd.nextInt();
        System.out.print("You have other income? ");
        String check = sc_str.next();
        char income = check.charAt(0);
        int salayYear = salay*12;
        
        if(income == 'Y' || income == 'y'){
            System.out.print("Input other income : ");
            int incomeCost = sc_incost.nextInt();
            result = salayYear-costYear-taxDeuction+incomeCost;
            System.out.printf("Income : (%d x 12) - %d - %d - %d = %d\n",salay,costYear,taxDeuction,incomeCost,result);    
            display(taxRate(result),result);
        }
        else if(income == 'N' || income == 'n'){
            result = (salayYear-costYear)-taxDeuction;
            System.out.printf("Income : (%d x 12) - %d - %d = %d\n",salay,costYear,taxDeuction,result);    
            display(taxRate(result),result);
        }
    }
    
}
