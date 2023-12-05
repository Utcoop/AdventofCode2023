import java.io.*;
import java.util.*;

public class AdventofCodeDay3part2 {
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day 3\\input.txt";
    public static List<Character> speChar = new ArrayList<Character>(); 
    public static List<Integer> result = new ArrayList<Integer>();
    
    public static int findNum(ArrayList<Character> input, int ind){
        String digit = input.get(ind).toString(); 
        input.set(ind, '.');
        if (Character.isDigit(input.get(ind+1))){
            digit = digit + input.get(ind+1).toString();
            input.set(ind + 1, '.');
            digit = digit + findNumForward(input, ind+1);
        } 
        if (Character.isDigit(input.get(ind-1))) {
            digit = input.get(ind-1).toString() + digit;
            input.set(ind - 1, '.');
            digit = findNumBack(input, ind-1) + digit;
        }
        return Integer.parseInt(digit);
    }

    public static String findNumForward(ArrayList<Character> input, int ind){
        String digit = "";
        if (Character.isDigit(input.get(ind+1))) {
                digit = digit + input.get(ind+1).toString();
                input.set(ind + 1, '.');
                digit = digit + findNumForward(input, ind+1);
        }
        return digit;
    }
    public static String findNumBack(ArrayList<Character> input, int ind){
        String digit = "";
        if (Character.isDigit(input.get(ind-1))) {
                digit = input.get(ind-1).toString() + digit;
                input.set(ind - 1, '.');
                digit = findNumBack(input, ind-1) + digit;
        }
        return digit;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        speChar.add('*');
        ArrayList<Character> input = new ArrayList<Character>();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] arr = line.toCharArray();
            for (char c : arr){
                input.add(c);
            }    
        }
        List<Integer> speInd = new ArrayList<Integer>();
        for (int i =0 ; i < speChar.size();i++){
            while (input.contains(speChar.get(i))){
                int ind = input.indexOf(speChar.get(i));
                speInd.add(ind);
                input.set(ind, '.');
            }
        }
        int answer = 0;
        for (int i = 0; i<speInd.size(); i++){
            //System.out.println((speInd.get(i)));
            result.clear();
            int counter = 0;
            int ind = speInd.get(i);
            if (Character.isDigit(input.get(ind+1))){
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind+1));            
            }
            if (Character.isDigit(input.get(ind-1))) {
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind-1));    
            }
            if (Character.isDigit(input.get(ind+141))) {
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind+141));
            }
            if (Character.isDigit(input.get(ind-141))){
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind-141));
            }
            if (Character.isDigit(input.get(ind-139))){
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind-139));            
            }
            if (Character.isDigit(input.get(ind+139))){
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind+139));            
            }
            if (Character.isDigit(input.get(ind-140))){
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind-140));
            }
            if (Character.isDigit(input.get(ind+140))){
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind+140));
            }
            if (counter==2){
                answer = answer + (result.get(0) * result.get(1));
            }
        }
        System.out.println(answer);
    }
}

