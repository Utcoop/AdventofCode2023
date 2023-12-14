package Day10;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class AdventofCodeDay10 {
    public static HashMap<Character,Integer[][]> instructions = new HashMap<Character,Integer[][]>();
    public static ArrayList<ArrayList<Character>> maps = new ArrayList<ArrayList<Character>>();
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day10\\Day10\\input.txt";
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new File(path));
        Integer[][] temp = new Integer[][]{{0,1},{0,-1}};
        instructions.put('|', temp);
        temp = new Integer[][]{{1,0},{-1,0}};
        instructions.put('-', temp);
        temp = new Integer[][]{{0,-1},{1,0}};
        instructions.put('L', temp);
        temp = new Integer[][]{{1,0},{0,1}};
        instructions.put('F', temp);
        temp = new Integer[][]{{-1,0},{0,-1}};
        instructions.put('J', temp);
        temp = new Integer[][]{{-1,0},{0,1}};
        instructions.put('7', temp);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            
        }
    }
}
