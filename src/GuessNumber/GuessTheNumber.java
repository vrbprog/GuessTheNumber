package GuessNumber;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    static int num;
    static int attemptNumber;
    static Scanner sc;
    static int userNum;
    public static void main(String[] args) {
        boolean endGame = true;
        while (endGame) {
            init();
            while (attemptNumber < 3 && userNum != num) {
                userNum = attempt();
                if(userNum > num) {
                    System.out.println("Загаданное число меньше");
                }else if (userNum < num){
                    System.out.println("Загаданное число больше");
                }
            }
            if(userNum == num){
                System.out.println("Ты угадал :)");
                endGame = false;
            }else{
                System.out.printf("Ты проиграл :( (Загаданное число %d). Желаеш попробывать еще раз? ( 1 - Да / 0 - Нет ) : ", num);
                if(sc.nextInt() != 1) endGame = false;
            }
        }
        System.out.println("Всего наилучшего!");
    }

    public static void printGuess(){
        System.out.println("\n\rУгадай число от 0 до 9.\n\rУ тебя будет 3 попытки.");
    }
    public static int generateNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }
    public static void init(){
        attemptNumber = 0;
        userNum = -1;
        num = generateNumber();
        sc= new Scanner(System.in);
        printGuess();
    }
    public static int attempt(){
        System.out.printf("%d попытка : ", ++attemptNumber);
        return sc.nextInt();
    }
}
