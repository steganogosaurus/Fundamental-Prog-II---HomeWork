public class CheckingAccount extends BankAccount{
    private double overdraftFee;
    public CheckingAccount(){
    }
    public CheckingAccount(String customerName, String accountNumber, double balance, double overdraftFee){
        super(customerName,accountNumber,balance);
        this.overdraftFee = overdraftFee;
    }
    public double getOverdraftFee(){
        return this.overdraftFee;
    }
    public void setOverdraftFee(double fee){
        this.overdraftFee = fee;
    }
    public void withdraw(double amount){
        if(getBalance() - (amount + this.overdraftFee) >= 0){
            System.out.println("Withdraw Complete!!");
            setBalance(getBalance() - (amount + getOverdraftFee()));
            System.out.printf("%s %s Withdraw %f Fee %.4f Balance %.6f\n",getAccountNumber(),getCustomerName(),amount,getOverdraftFee(),getBalance());
            System.out.println("########");
        }else {
            System.out.println("Withdraw Fail!!");
        }
    }
}