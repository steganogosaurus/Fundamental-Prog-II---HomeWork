import java.util.Scanner;
public class AccountTest {
    public static void main(String[] args) {
        String choose;
        int i = 1,j = 1;
        Scanner scn = new Scanner(System.in);
        BankAccount  a1 = new  BankAccount();
        BankAccount a2 = new  BankAccount();
        CheckingAccount c1 = new CheckingAccount();
        CheckingAccount c2 = new CheckingAccount();
        BankAccount [] account = {a1,a2};
        CheckingAccount [] checking = {c1,c2};

        for(BankAccount acc : account){
            System.out.printf("\n#%d BankAccount%d\n",i,i);
            System.out.print("NAMR: ");
            acc.setCustomerName(scn.next());
            System.out.print("ADDR: ");
            acc.setAccountNumber(scn.next());
            System.out.print("BALANCE: ");
            acc.setBalance(scn.nextDouble());
            i++;
            }
        for(CheckingAccount check : checking){
            System.out.printf("\n#%d CheckingAccount%d\n",i,i-2);
            System.out.print("NAMR: ");
            check.setCustomerName(scn.next());
            System.out.print("ADDR: ");
            check.setAccountNumber(scn.next());
            System.out.print("BALANCE: ");
            check.setBalance(scn.nextDouble());
            System.out.print("FEE: ");
            check.setOverdraftFee(scn.nextDouble());
            i++;
        }
        while (j <= 4){
            System.out.print("Choose Account: ");
            choose = scn.next();
            for(BankAccount acc : account){
                if(choose.equals(acc.getAccountNumber())) {
                    System.out.print("Choose Action (1. Withdraw 2. Deposit): ");
                    int chooseAct = scn.nextInt();
                    if(chooseAct == 1){
                        System.out.print("Value:");
                        double val = scn.nextDouble();
                        acc.withdraw(val);
                    }else if(chooseAct == 2){
                        System.out.print("Value:");
                        double val = scn.nextDouble();
                        acc.deposit(val);
                    }
                }
            }
            for(CheckingAccount check : checking){
                if(choose.equals(check.getAccountNumber())){
                    System.out.print("Choose Action (1. Withdraw 2. Deposit): ");
                    int chooseAct = scn.nextInt();
                    if(chooseAct == 1){
                        System.out.print("Value:");
                        double val = scn.nextDouble();
                        check.withdraw(val);
                    }else if(chooseAct == 2){
                        System.out.print("Value:");
                        double val = scn.nextDouble();
                        check.deposit(val);
                    }
                }
            }
            j++;
        }
    }
}