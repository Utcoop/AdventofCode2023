import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Integer;


public class AdventofCodeDay4 { 
    public static ArrayList<String> winNumAL = new ArrayList<String>();
    public static ArrayList<String> compareNumAL = new ArrayList<String>();
    public static ArrayList<Integer> copies = new ArrayList<Integer>();
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day 4\\input.txt";

    public static ArrayList<Integer> updateCopies(int cardNum, int matches, ArrayList<Integer> copies){
        if (matches>0){
            for (int c = 0 ; c < matches; c++ ){
                cardNum++;
                if (cardNum < 198)
                    copies.set(cardNum, copies.get(cardNum)+1);
                    //System.out.println(copies);
            }
        }
        return copies;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int total = 0;
        int cardNum = 0;
        int score = 0;
        int matches = 0;
        int numCards = 0;
        for (int i = 0; i < 198; i++){
            copies.add(1);
        }
        Scanner scanner = new Scanner(new File(path));
        String line = "";
        while (scanner.hasNextLine()) {
           line = scanner.nextLine();
           line = line.trim().replaceAll(" +", " ");
           winNumAL.clear();
           compareNumAL.clear();
            String[] tempArr = line.split("[|]");
            tempArr[0] = tempArr[0].substring(tempArr[0].indexOf(":") + 2);
            tempArr[1] = tempArr[1].substring(tempArr[1].indexOf(":") + 2);
            String[] winNum = tempArr[0].split(" ");
            String[] compareNum = tempArr[1].split(" ");
            for (int c = 0; c < compareNum.length ; c++){
                if (!compareNum[c].equals(" ") || !compareNum[c].equals("")){
                    compareNumAL.add(compareNum[c]);
                }
            }
            for (int c = 0 ; c < copies.get(cardNum); c++){
                score = 0;
                matches = 0;
                for (int i = 0; i < winNum.length ; i++){
                    if (!winNum[i].equals(" ") || !winNum[i].equals("")){
                        winNumAL.add(winNum[i]);
                    }
                    if (compareNumAL.contains(winNumAL.get(i))){
                        matches++;
                        if (score==0)
                            score++;
                        else
                            score = score * 2;
                    }
                }
                //System.out.println("Matches: " + matches);
                copies = updateCopies(cardNum,matches,copies);
            }
            total = total+score;
            cardNum++;
            //System.out.println(cardNum);
        }
        for (int i=0; i < copies.size(); i++){
            numCards = copies.get(i) + numCards;
        }
        System.out.println("Number of cards: " + numCards);
        System.out.println("Total score of all unique cards: " + total);
    }
}