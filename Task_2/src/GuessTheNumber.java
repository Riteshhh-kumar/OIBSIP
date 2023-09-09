import java.util.Random;
import java.util.Scanner;

class Game{
    static int numberOfGuess=0,score=100,attempts=5;

    public static void addAttempts(){
        attempts=5;
    }
    static Scanner sc=new Scanner(System.in);
    Game(int num){
        System.out.println("Select the game mode:");
        System.out.println("1 For Limited attempts(5 attempts).");
        System.out.println("2 For unlimited attempts.");
        int mode= sc.nextInt();


        System.out.println("Please take a guess!");
        Game.gameMode(mode,num);
    }

    public static void gameMode(int mode,int num){
        switch(mode){
            case 1:
            {
                boolean answer=false;
                while(attempts>0)
                {
                    attempts--;
                    answer = Game.takeUserInput(num,attempts);
                }
                if(answer){
                    System.out.println("Sorry you were not able to guess the number in 5 attempts.");
                    System.out.println("want another 5 attempts?If yes enter y");
                    char choose = sc.next().charAt(0);

                    switch (choose){
                        case 'y', 'Y':{
                            Game.addAttempts();
                            System.out.println("Please take a guess!");
                            Game.gameMode(1,num);
                            break;
                        }
                        default:{
                            System.out.println("Thank you for playing number guessing Game.");
                        }
                    }
                }

                break;

            }

            case 2:
            {
                while(Game.takeUserInput(num,attempts))
                    Game.takeUserInput(num,attempts);
                System.out.println("Thank you for playing number guessing Game.");


                break;

            }
        }
    }

    public static int generateNum()
    {
        Random r1=new Random();
        return r1.nextInt(100);
    }

    static boolean takeUserInput(int num,int attempts){
            boolean answer = Game.isCorrectNumber(sc.nextInt(),num,attempts);
            if(!answer)
                return false;

            if(attempts!=0)
                System.out.println("Please take another guess!");
            return true;


    }
    static boolean isCorrectNumber(int input,int num,int attempts){
        if(input==num && attempts>0)
        {
            numberOfGuess++;
            System.out.println("You guessed the correct number in " +numberOfGuess+" number of guesses and got a score of "+score+"/100");
            return false;
        }
        else if(input<num && attempts>0){
            System.out.println("Guessed number is small ! Please guess a bigger number");
            numberOfGuess++;
            score-=5;
        }
        else if(input>num && attempts>0){
            System.out.println("Guessed number is big ! Please guess a smaller number");
            numberOfGuess++;
            score-=5;
        }
        return true;

    }


}


public class GuessTheNumber{

    public static void main(String[] args) {

        int num = Game.generateNum();
        Game g1=new Game(num);



    }
}