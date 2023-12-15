import java.io.*;
import java.util.Scanner;

public class AdventofCode2Part2 {
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day 2\\Advent_2.txt";
    public static int result;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] arrOfStr = line.split("[,:;]"); //Split the line into sections based on these characters
            String[] tempArr; //To store one index of arr of star split by the color and value of the number 
            String[] arr; //To store the game number and word game if we find the game is possible
            int[] grb = new int[]{0,0,0}; //Stores the largest number of each color cube found
            int tempNum;
            for (int i = 0; i < arrOfStr.length; i++){
                if (arrOfStr[i].contains("green")) { //If index contains "green" split that index of the string up by green and space
                    tempArr = arrOfStr[i].split("[ green]");
                    tempNum = Integer.parseInt(tempArr[1]);// The 1st index of tempArr always contains the number of cubes
                    if (tempNum > grb[0]){ //if number of green cubes is greater than the stored value we have. Store the larger value
                        grb[0] = tempNum;
                    }
                } else if (arrOfStr[i].contains("red")) { //If index contains "red" split that index of the string up by red and space
                    tempArr = arrOfStr[i].split("[ red]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > grb[1]){//if number of red cubes is greater than the stored value we have. Store the larger value
                        grb[1] = tempNum;
                    }
                } else if (arrOfStr[i].contains("blue")) { //If index contains "blue" split that index of the string up by blue and space
                    tempArr = arrOfStr[i].split("[ blue]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > grb[2]){//if number of blue cubes is greater than the stored value we have. Store the larger value
                        grb[2] = tempNum;
                    }
                }
            }
            result += grb[0] * grb[1] * grb[2]; //When we finish going through the array multiply the max number of each color we need by eachother and add it to result
        }
        System.out.println(result);
    }
}