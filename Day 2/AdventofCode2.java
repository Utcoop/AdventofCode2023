import java.io.*;
import java.util.Scanner;

public class AdventofCode2 {
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day 2\\Advent_2.txt";
    public static int games;
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] arrOfStr = line.split("[,:;]"); //Split the line into sections based on these characters
            String[] tempArr; //To store one index of arr of star split by the color and value of the number 
            String[] arr; //To store the game number and word game if we find the game is possible
            int tempNum;
            for (int i = 0; i < arrOfStr.length; i++){
                if (arrOfStr[i].contains("green")) { //If index contains green split that index of the string up by green and space
                    tempArr = arrOfStr[i].split("[ green]");
                    tempNum = Integer.parseInt(tempArr[1]);  // The 1st index of tempArr always contains the number of cubes
                    if (tempNum > 13) {
                        //System.out.println("Too many green " + i);
                        break;
                    }
                } else if (arrOfStr[i].contains("red")) { //If index contains green split that index of the string up by red and space
                    tempArr = arrOfStr[i].split("[ red]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > 12) {
                        //System.out.println("Too many red " + i);
                        break;
                    }
                } else if (arrOfStr[i].contains("blue")) { //If index contains green split that index of the string up by blue and space
                    tempArr = arrOfStr[i].split("[ blue]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > 14) {
                        //System.out.println("Too many Blue " + i);
                        break;
                        
                    }    
                }
                //System.out.println(i);
                if (i==(arrOfStr.length-1)){ 
                    //System.out.println("Made it thorugh!");
                    arr = arrOfStr[0].split("Game "); // 0th index of arrOfStr always contains the game and game number
                    tempNum = Integer.parseInt(arr[1]); //get game number
                    games = games + tempNum;    //Sum the game nums
                }
            }
        }
        System.out.println(games);
    }
}

// if (a.contains("game")){
// }