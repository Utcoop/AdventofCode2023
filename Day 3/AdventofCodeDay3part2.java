import java.io.*;
import java.util.*;

public class AdventofCodeDay3part2 {
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day 3\\input.txt";
    public static List<Character> speChar = new ArrayList<Character>(); 
    public static List<Integer> result = new ArrayList<Integer>();
    
    public static int findNum(ArrayList<Character> input, int ind){
        String digit = input.get(ind).toString(); //Add the found digit to our output string 
        input.set(ind, '.');
        if (Character.isDigit(input.get(ind+1))){ //Check to see if next index of input is a digit
            digit = digit + input.get(ind+1).toString();//Add new character to the end of the output string
            input.set(ind + 1, '.'); //Replace found digit with a '.'
            digit = digit + findNumForward(input, ind+1); //Recursively call a this method until all digits in front of the current digit are found and add the return value to the end of the output
        } 
        if (Character.isDigit(input.get(ind-1))) { //Check to see if previous index of input is a digit
            digit = input.get(ind-1).toString() + digit;//Add new character to the front of the output string
            input.set(ind - 1, '.'); //Replace found digit with a '.'
            digit = findNumBack(input, ind-1) + digit;//Recursively call a this method until all digits behind  the current digit are found and add the return value to the front of the output
        }
        return Integer.parseInt(digit); //Convert output to an integer
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
        speChar.add('*'); //Load all encounterable special characters (gears) into array for this problem we only need to look for '*'
        ArrayList<Character> input = new ArrayList<Character>();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] arr = line.toCharArray(); //Split line into a character array
            for (char c : arr){
                input.add(c); //Load character array into a ArrayList line
            }    
        }
        List<Integer> speInd = new ArrayList<Integer>();
        for (int i =0 ; i < speChar.size();i++){ //Iterate through speChar to find and store the location of each special character it contains
            while (input.contains(speChar.get(i))){  //While input still contains each of a special character get the index of each location
                int ind = input.indexOf(speChar.get(i));
                speInd.add(ind); //Store the index of each special char
                input.set(ind, '.'); //replace each found special character with . so we don't double count any characters
            }
        }
        int answer = 0;
        for (int i = 0; i<speInd.size(); i++){
            //System.out.println((speInd.get(i)));
            result.clear();
            int counter = 0; //We are looking for 2 integers adjacent to a gear so we iterate this counter everytime we find a integer next to a gear
            int ind = speInd.get(i);
            if (Character.isDigit(input.get(ind+1))){ //Check one character forward
                counter++;
                if (counter <= 2)//Only add the found number to result if it is the first or second number found
                    result.add(findNum(input, ind+1));            
            }
            if (Character.isDigit(input.get(ind-1))) { //Check one character backwards
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind-1));    
            }
            if (Character.isDigit(input.get(ind+141))) { //Check one character down and forward
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind+141));
            }
            if (Character.isDigit(input.get(ind-141))){ //Check one character up and back
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind-141));
            }
            if (Character.isDigit(input.get(ind-139))){//Check one character up and forward
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind-139));            
            }
            if (Character.isDigit(input.get(ind+139))){//Check one character down and back
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind+139));            
            }
            if (Character.isDigit(input.get(ind-140))){ //Check one character upwards
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind-140));
            }
            if (Character.isDigit(input.get(ind+140))){ //Check one character down
                counter++;
                if (counter <= 2)
                    result.add(findNum(input, ind+140));
            }//A line of input is 140 characters long
            if (counter==2){ //If at the end of each search around an index the counter is equal to 2 we multiply the two found integers together and add the result to answer
                answer = answer + (result.get(0) * result.get(1));
            }//There should only be 2 integers next to any one gear
        }
        System.out.println(answer);
    }
}

