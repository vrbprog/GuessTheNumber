package GueesWord;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args) {
        String guessWord;
        String mask = "###############";
        StringBuilder sMask = new StringBuilder(mask);
        Scanner sc = new Scanner(System.in);
        boolean endGame = true;

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        guessWord = words[generateNumber(words)];
        System.out.println("\n\rУгадай загаданное слово.");

        while (endGame) {
            endGame = !compareWord(sMask,attempt(sc),guessWord);
            if(endGame) {
                System.out.println(sMask.toString());
            }else{
                System.out.println("Вы угадали :)");
            }
        }
        System.out.println("Всего наилучшего!");
    }

    public static int generateNumber(String[] array){
        Random random = new Random();
        return random.nextInt(array.length);
    }

    public static String attempt(Scanner s){
        System.out.println("Введи слово : ");
        return s.nextLine();
    }

    public static boolean compareWord(StringBuilder sb, String s, String word){
        if(s.equals(word)){
            return true;
        }else {
            int number = minWordLength(s, word);
            for (int i = 0; i < number; i++) {
                if (s.charAt(i) == word.charAt(i)) {
                    sb.setCharAt(i, word.charAt(i));
                }else{
                    sb.setCharAt(i, '#');
                }
            }
            return false;
        }
    }
    public static int minWordLength(String s1, String s2){
        if(s1.length() < s2.length()){
            return s1.length();
        }else{
            return s2.length();
        }
    }
}
