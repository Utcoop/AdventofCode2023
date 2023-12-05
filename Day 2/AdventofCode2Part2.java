import java.io.*;
import java.util.Scanner;

public class AdventofCode2Part2 {
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
            int[] grb = new int[]{0,0,0};
            int tempNum;
            for (int i = 0; i < arrOfStr.length; i++){
                if (arrOfStr[i].contains("green")) {
                    tempArr = arrOfStr[i].split("[ green]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > grb[0]){
                        grb[0] = tempNum;
                    }
                } else if (arrOfStr[i].contains("red")) {
                    tempArr = arrOfStr[i].split("[ red]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > grb[1]){
                        grb[1] = tempNum;
                    }
                } else if (arrOfStr[i].contains("blue")) {
                    tempArr = arrOfStr[i].split("[ blue]");
                    tempNum = Integer.parseInt(tempArr[1]);
                    if (tempNum > grb[2]){
                        grb[2] = tempNum;
                    }
                }
                if (i==(arrOfStr.length-1)){
                    System.out.println("Made it thorugh!");
                    games += grb[0] * grb[1] * grb[2];
                }
            }
        }
        System.out.println(games);
    }
}

// if (a.contains("game")){
// }