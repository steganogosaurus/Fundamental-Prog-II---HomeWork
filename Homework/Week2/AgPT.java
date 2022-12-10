import java.util.Scanner;

public class AgPT {
    /**
     * 
     * @param netMoney
     * @return rate tax
     */
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
    /**
    * @param rateTax netMoney
    * @return 
    */
    public static int[] stepOne(int rateTax , int netMoney){
        int i;
        int[] taxMoney = {150000,150000,200000,200000,250000,250000,1000000,3000000};
        int[] resultTax = new int[10];
        for(i = 0;i<=(rateTax/5)-1;i++){
            netMoney -= taxMoney[i];
            resultTax[i] = taxMoney[i];
        }
        resultTax[8] = i;
        resultTax[9] = (int)(netMoney*(rateTax/100f));
        //return taxMoney 0-7 index 8 sumTax 9
        return resultTax;
    }
    public static void stepN(int rate,int netMoney){
        int nM = netMoney;
        int[] taxStep = {7500,20000,37500,50000,250000,900000};
        int[] step1 = stepOne(rate, netMoney);
        int index = step1[8];
        int sumTax = step1[9];
        String[] calTax = {"Cal Tax 150000 * 5% = 7500","Cal Tax 200000 * 10% = 20000"
                        ,"Cal Tax 200000 * 15% = 37500","Cal Tax 250000 * 20% = 50000 "
                        ,"Cal Tax 1000000 * 25% = 250000 ","Cal Tax 3000000 * 30% = 900000 "};
        System.out.println("Tax is " + rate + "%");
        int indexx = index;
        if(taxRate(netMoney) > 0){
            if(indexx > 1){
                System.out.println("step "+indexx);
            }
            System.out.print("Cal Tax ");
            for(int j = 0;j<index;j++){
                System.out.printf("%d - %d = ",nM,step1[j]);
                nM -= step1[j]; 
            }
            System.out.println(nM+" * "+rate+"% = "+sumTax);
            for(int i = index-2;i >= 0;i--){
                sumTax+=taxStep[i];
                System.out.println("step "+--indexx);
                System.out.println(calTax[i]);
            }
            System.out.println("Your Tax = " + sumTax + " BTH");
        }
        else{
            System.out.println("Tax is 0%");
            System.out.println("Your Tax = Free Tax");
        }
    }
    public static void main(String[] args) {
        int salary , yearCost , deductionTax , netMoney , incomeCost;
        String income;
        Scanner sc_salary = new Scanner(System.in);
        Scanner sc_yearCost = new Scanner(System.in);
        Scanner sc_deductionTax = new Scanner(System.in);
        Scanner sc_income = new Scanner(System.in);
        Scanner sc_incomeCost = new Scanner(System.in);
        System.out.print("Enter Salary : ");
        salary = sc_salary.nextInt();
        System.out.print("Enter Year cost : ");
        yearCost = sc_yearCost.nextInt(); 
        System.out.print("Enter Tax Deduction : "); 
        deductionTax = sc_deductionTax.nextInt();
        System.out.print("Your have other income? ");
        income = sc_income.next();
        income = income.toUpperCase();
        char incomeCheck = income.charAt(0);
        switch (incomeCheck){
            case 'Y':
                System.out.print("Input other income : ");
                incomeCost = sc_incomeCost.nextInt();
                netMoney = (salary*12)-yearCost-deductionTax+incomeCost;
                System.out.printf("Income : (%dx12) - %d - %d + %d = %d\n",salary,yearCost,deductionTax,incomeCost,netMoney);
                stepN(taxRate(netMoney),netMoney);
                break;
            case 'N':
                netMoney = (salary*12)-yearCost-deductionTax;
                System.out.printf("Income : (%dx12) - %d - %d = %d\n",salary,yearCost,deductionTax,netMoney);
                stepN(taxRate(netMoney),netMoney);
                break;
        }
    }
}
