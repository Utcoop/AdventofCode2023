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
            String[] arrOfStr = line.split("[,:;]");
            String[] tempArr;
            String[] arr;
            int tempNum;
            for (int i = 0; i < arrOfStr.length; i++){
                if (arrOfStr[i].contains("green")) {
                    tempArr = arrOfStr[i].split("[ green]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > 13) {
                        System.out.println("Too many green " + i);
                        break;
                    }
                } else if (arrOfStr[i].contains("red")) {
                    tempArr = arrOfStr[i].split("[ red]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > 12) {
                        System.out.println("Too many red " + i);
                        break;
                    }
                } else if (arrOfStr[i].contains("blue")) {
                    tempArr = arrOfStr[i].split("[ blue]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > 14) {
                        System.out.println("Too many Blue " + i);
                        break;
                        
                    }    
                }
                System.out.println(i);
                if (i==(arrOfStr.length-1)){
                    System.out.println("Made it thorugh!");
                    arr = arrOfStr[0].split("Game ");
                    tempNum = Integer.parseInt(arr[1]);
                    games = games + tempNum;
                }
            }
            System.out.println(games);
        }
    }
}

// if (a.contains("game")){
// }