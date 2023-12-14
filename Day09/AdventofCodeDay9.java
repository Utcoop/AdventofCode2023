
import java.io.*;
import java.util.*;

public class AdventofCodeDay9{
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day09\\input.txt";
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new File(path));
        ArrayList<Integer> history1 = new ArrayList<>();
        ArrayList<Integer> history2 = new ArrayList<>();
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            history1.add(findHistory1(line));
            history2.add(findHistory2(line));
            
        }
        int sum1 =0;
        for (int a:history1){
            sum1 = sum1 + a;
        }
        System.out.println(sum1);
        int sum2 =0;
        for (int a:history2){
            sum2 = sum2 + a;
        }
        System.out.println(sum2);
    }
    
    private static Integer findHistory1(String line) {
        String[] temp = line.split(" ");
        ArrayList<Integer> currentLine = new ArrayList<>(); 
        ArrayList<Integer> nextLine = new ArrayList<>(); 
        ArrayList<ArrayList<Integer>> seq = new ArrayList<>();
        for (String a: temp){
            currentLine.add(Integer.parseInt(a));
        }
        //System.out.println(currentLine);
        Boolean allZero= false;
        seq.add(currentLine);
        while (!allZero){
            nextLine = findNextSeq(currentLine);
            seq.add(nextLine);
            allZero = isAllZeros(nextLine);
            //System.out.println(currentLine);
            currentLine=nextLine;
            //System.out.println(currentLine);
        }
        //System.out.println(seq);
        return compileHistory1(seq);
    }

    private static Integer compileHistory1(ArrayList<ArrayList<Integer>> seq) {
        int currLast;
        int nextLast;
        System.err.println("compile history" + seq);
        for (int i=seq.size()-1; i > 0; i--){
            //System.out.println(i);
            currLast = seq.get(i).get(seq.get(i).size()-1);
            nextLast = seq.get(i-1).get(seq.get(i).size()-1);
            seq.get(i-1).add(currLast+nextLast);
        }
        System.out.println(seq);
        return seq.get(0).get(seq.get(0).size()-1);
    }
    private static Integer findHistory2(String line) {
        String[] temp = line.split(" ");
        ArrayList<Integer> currentLine = new ArrayList<>(); 
        ArrayList<Integer> nextLine = new ArrayList<>(); 
        ArrayList<ArrayList<Integer>> seq = new ArrayList<>();
        for (String a: temp){
            currentLine.add(Integer.parseInt(a));
        }
        //System.out.println(currentLine);
        Boolean allZero= false;
        seq.add(currentLine);
        while (!allZero){
            nextLine = findNextSeq(currentLine);
            seq.add(nextLine);
            allZero = isAllZeros(nextLine);
            //System.out.println(currentLine);
            currentLine=nextLine;
            //System.out.println(currentLine);
        }
        //System.out.println(seq);
        return compileHistory2(seq);
    }

    private static Integer compileHistory2(ArrayList<ArrayList<Integer>> seq) {
        int currFirst;
        int nextFirst;
        //System.err.println("compile history" + seq);
        for (int i=seq.size()-1; i > 0; i--){
            //System.out.println(i);
            currFirst = seq.get(i).get(seq.get(i).size()-1);
            nextFirst = seq.get(i-1).get(0);
            seq.get(i-1).add(nextFirst - currFirst);
        }
        //System.out.println(seq);
        return seq.get(0).get(seq.get(0).size()-1);
    }

    private static Boolean isAllZeros(ArrayList<Integer> nextLine) {
        //System.out.println(nextLine);
        for (Integer a: nextLine){
            if (a!=0){
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> findNextSeq(ArrayList<Integer> currentLine) {
        ArrayList<Integer> nextSeq = new ArrayList<>(); 
        if (currentLine.size() == 1){
            Integer[] temp = new Integer[currentLine.size() -1];
            Arrays.fill(temp, 0);
            ArrayList<Integer> arr = new ArrayList<>();
            for (Integer i : temp){
                arr.add(i);
            }
            return arr;
        }
        for (int i=0 ; i<currentLine.size()-1; i++){
            nextSeq.add(currentLine.get(i+1) - currentLine.get(i));
        }
        return nextSeq;
    }
}