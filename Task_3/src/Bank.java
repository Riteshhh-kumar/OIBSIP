import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Bank{
    Scanner sc = new Scanner(System.in);
    private int  currentAccount=0;
    private HashMap<Integer,Integer> authenticationList = new HashMap<>();
    private HashMap<Integer,Account> banking = new HashMap<>();
    Bank(){
        Account acc1 = new Account();
        acc1.setBalance(10000);
        acc1.setHistory(100);
        acc1.setHistory(-1890);
        acc1.setHistory(1030);

        Account acc2 = new Account();
        acc2.setBalance(5000);
        acc2.setHistory(1000);
        acc2.setHistory(-180);
        acc2.setHistory(100);

        Account acc3 = new Account();
        acc3.setBalance(50000);
        acc3.setHistory(1330);
        acc3.setHistory(-1200);

        authenticationList.put(123456789,1234);
        banking.put(123456789,acc1);

        authenticationList.put(987654321,4567);
        banking.put(123456789,acc1);

        authenticationList.put(123789456,9510);
        banking.put(123456789,acc1);
    }

    public boolean authenticate(int id){
        if(this.authenticationList.containsKey(id)){
            System.out.println("Enter the pin");
            int pin = sc.nextInt();
            if(this.authenticationList.get(id)==pin){
                this.currentAccount=id;
                System.out.println("You are logged in.");
                return true;
            }
            else{
                System.out.println("Wrong pin start over.");
                System.out.println("----------------------------------------");
            }
        }
        else{
            System.out.println("Entered user does not exist.Try again");
            System.out.println("----------------------------------------");
        }
        return false;
    }
    class Account{
        private int balance;
        private ArrayList<Integer> history = new ArrayList<>();


        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public ArrayList<Integer> getHistory() {
            return history;
        }

        public void setHistory(int amount) {
            this.history.add(amount);

        }

    }
    public void withdraw(int amount){
        int balanceAmount=this.banking.get(currentAccount).getBalance()-amount;
        this.banking.get(currentAccount).setBalance(balanceAmount);
        this.banking.get(currentAccount).setHistory(-amount);
        System.out.println("Transaction Completed");
        System.out.println("----------------------------------------");
    }
    
    public void transactionHistory(){
        for(int amount:this.banking.get(currentAccount).getHistory()){
            if(amount<0){
                System.out.println("Withdraw |   "+Math.abs(amount));
            }
            else{
                System.out.println("Deposit  |   "+Math.abs(amount));
            }
        }
        System.out.println("Transaction Completed");
        System.out.println("----------------------------------------");
    }
    
    public void deposit(int amount){
        int balanceAmount=this.banking.get(currentAccount).getBalance()+amount;
        this.banking.get(currentAccount).setBalance(balanceAmount);
        this.banking.get(currentAccount).setHistory(amount);
        System.out.println("Transaction Completed");
        System.out.println("----------------------------------------");
    }
    
    
    public void transfer(int amount,int account){
        int balanceAmountSender=this.banking.get(currentAccount).getBalance()-amount;
        this.banking.get(currentAccount).setBalance(balanceAmountSender);
        this.banking.get(currentAccount).setHistory(-amount);


        int balanceAmountReceiver=this.banking.get(account).getBalance()+amount;
        this.banking.get(account).setBalance(balanceAmountReceiver);
        this.banking.get(account).setHistory(amount);

        System.out.println("----------------------------------------");
    }

    public boolean quit(){
        this.currentAccount=0;
        System.out.println("You are logged out.");
        return false;
    }
}