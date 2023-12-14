
import java.util.*;
import java.io.*;

public class AdventofCodeDay11{
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day11\\input.txt";
    public static ArrayList<ArrayList<Integer>> coords = new ArrayList<ArrayList<Integer>>();
    
    public static Integer findSumDistances1(ArrayList<Integer> xs, ArrayList<Integer> ys, ArrayList<ArrayList<Integer>> coords){
        Integer sum=0;
        Integer distY = 0;
        Integer distX = 0;
        //System.out.println(ys);
        for (int i = 0 ; i < coords.size()-1 ; i++){
            for (int j = i +1; j < coords.size() ; j++){
                //System.out.println(coords.get(i));
                //System.out.println(coords.get(j));
                distX = Math.abs(coords.get(i).get(0) - coords.get(j).get(0));
                distY = Math.abs(coords.get(i).get(1) - coords.get(j).get(1));
                for (int row: xs){
                    if (( coords.get(i).get(0) < row && row < coords.get(j).get(0) ) || (coords.get(j).get(0) < row && row < coords.get(i).get(0))){
                        sum++;
                    }
                }
                for (int column: ys){
                    if (( coords.get(i).get(1) < column && column < coords.get(j).get(1) ) || (coords.get(j).get(1) < column && column < coords.get(i).get(1))){
                        sum++;
                    }
                }
                sum += distY+distX;
            }
        }
        
        return sum; 
    }
    public static Long findSumDistances2(ArrayList<Integer> xs, ArrayList<Integer> ys, ArrayList<ArrayList<Integer>> coords){
        Long sum=0L;
        Integer distY = 0;
        Integer distX = 0;
        //System.out.println(ys);
        for (int i = 0 ; i < coords.size()-1 ; i++){
            for (int j = i +1; j < coords.size() ; j++){
                //System.out.println(coords.get(i));
                //System.out.println(coords.get(j));
                distX = Math.abs(coords.get(i).get(0) - coords.get(j).get(0));
                distY = Math.abs(coords.get(i).get(1) - coords.get(j).get(1));
                for (int row: xs){
                    if (( coords.get(i).get(0) < row && row < coords.get(j).get(0) ) || (coords.get(j).get(0) < row && row < coords.get(i).get(0))){
                        sum+= (1000000-1);
                    }
                }
                for (int column: ys){
                    if (( coords.get(i).get(1) < column && column < coords.get(j).get(1) ) || (coords.get(j).get(1) < column && column < coords.get(i).get(1))){
                        sum+= (1000000-1);
                    }
                }
                sum += distY+distX;
            }
        }
        
        return sum; 
    }


    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new File(path));
        String line;
        int y = 0;
        ArrayList<Integer> emptyX = new ArrayList<Integer>();
        for (int i =0; i< 140; i++){
            emptyX.add(i);
        }
        ArrayList<Integer> emptyY = new ArrayList<Integer>();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.contains("#")){
                for (int x=0; x<line.length(); x++){
                //System.out.println(line.charAt(x));
                    if (line.charAt(x) == '#'){
                        //System.out.println("Found galaxy coords");
                        ArrayList<Integer> pair = new ArrayList<Integer>();
                        if (emptyX.contains(x)){
                            emptyX.remove(emptyX.indexOf(x));
                        }
                        pair.add(x);
                        pair.add(y);
                        coords.add(pair);
                    }   
                }
            }else{
                emptyY.add(y);
            }
            y++;
        }
        System.out.println(emptyY);
        System.out.println(emptyX);
        //System.out.println(coords);
        //System.out.println(findSumDistances1(emptyX, emptyY, coords));
        System.out.println(findSumDistances2(emptyX, emptyY, coords));
    }
}