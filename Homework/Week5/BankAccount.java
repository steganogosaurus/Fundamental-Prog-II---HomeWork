public class BankAccount {
    private String customerName;
    private String accountNumber;
    private double balance;
    public BankAccount(){
    }
    public BankAccount(String customerName,String accountNumber,double balance){
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getCustomerName(){return this.customerName;}
    public void setCustomerName(String name){this.customerName = name;}
    public String getAccountNumber(){return this.accountNumber;}
    public void setAccountNumber(String number){
        this.accountNumber = number;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double b){
        this.balance = b;
    }
    public void withdraw(double amount){
        if(balance - amount   >= 0){
            System.out.println("Withdraw Complete!!");
            setBalance(getBalance() - amount);
            System.out.printf("%s %s Withdraw %f Balance %.6f\n",getAccountNumber(),getCustomerName(),amount,getBalance());
            System.out.println("########");
        }else {
            System.out.println("Withdraw Fail!!");
        }
    }
    public void deposit(double amount){
        System.out.println("Deposit Complete!!");
        setBalance(getBalance() + amount);
        System.out.printf("%s %s Withdraw %f Balance %.6f\n",getAccountNumber(),getCustomerName(),amount,getBalance());
        System.out.println("########");
    }

}