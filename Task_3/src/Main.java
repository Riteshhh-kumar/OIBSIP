import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("Welcome to bank.");
        System.out.println("Please provide your id.");
        int id=sc.nextInt();
        int choice =0;
        boolean authenticated=bank.authenticate(id);
        while(Main.quit(bank,choice)){
            if(authenticated){
                System.out.println("Select the desired transaction.");
                System.out.println("1. For Transaction History");
                System.out.println("2. For Withdraw");
                System.out.println("3. For Deposit");
                System.out.println("4. For Transfer");
                System.out.println("5. To Quit");
                boolean validOption=true;
                while (validOption){
                    choice = sc.nextByte();
                    System.out.println("----------------------------------------");
                    switch (choice){
                        case 1:{
                            bank.transactionHistory();
                            validOption=false;
                            break;
                        }
                        case 2:{
                            System.out.println("Enter the amount.");
                            int amount = sc.nextInt();
                            bank.withdraw(amount);
                            validOption=false;
                            break;
                        }
                        case 3:{
                            System.out.println("Enter the amount.");
                            int amount = sc.nextInt();
                            bank.deposit(amount);
                            validOption=false;
                            break;
                        }
                        case 4:{
                            System.out.println("Enter the id in which you want to transfer the amount.");
                            int transferid = sc.nextInt();
                            System.out.println("Enter the amount.");
                            int amount = sc.nextInt();
                            bank.transfer(amount,transferid);
                            validOption=false;
                            break;
                        }
                        case 5:{
                            Main.quit(bank,choice);
                            validOption=false;
                            break;
                        }
                        default:
                            System.out.println("Select Valid Option");
                    }
                }
            }
            else{
                System.out.println("----------------------------------------");
                Main.main(new String[]{});
            }
        }
    }
    private static boolean quit(Bank bank,int choice) {
        if(choice==5){
            return false;
        }

        return true;
    }
}