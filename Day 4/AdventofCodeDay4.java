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
                cardNum++; //Looks at the next cards in the list based on how many matches were made in the previous card
                if (cardNum < 198)
                    copies.set(cardNum, copies.get(cardNum)+1); //Adds 1 copy to the next card
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
        for (int i = 0; i < 198; i++){ //Add the initial copy of each card to the array list
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
            for (int c = 0; c < compareNum.length ; c++){ //Load all numbers to compare with into an arrayList
                if (!compareNum[c].equals(" ") || !compareNum[c].equals("")){
                    compareNumAL.add(compareNum[c]);
                }
            }
            for (int c = 0 ; c < copies.get(cardNum); c++){ //Repeat operation based on number of copies to ensure we do each copy of every card 
                score = 0;
                matches = 0;
                for (int i = 0; i < winNum.length ; i++){ //Store the winning numbers in array list
                    if (!winNum[i].equals(" ") || !winNum[i].equals("")){
                        winNumAL.add(winNum[i]);
                    }
                    if (compareNumAL.contains(winNumAL.get(i))){//if compareNumbers contains winning numbers add one match to the counter and increase the score
                        matches++;
                        if (score==0)
                            score++;
                        else
                            score = score * 2;
                    }
                }
                //System.out.println("Matches: " + matches);
                copies = updateCopies(cardNum,matches,copies);//Update how many copies of the next few cards based on number of matches
            }
            total = total+score; //We only add score to the total after all copies have been completed as to not add the score of each copy
            cardNum++;//Look at the next card
            //System.out.println(cardNum);
        }
        for (int i=0; i < copies.size(); i++){
            numCards = copies.get(i) + numCards;//sum up all copies
        }
        System.out.println("Number of cards: " + numCards);
        System.out.println("Total score of all unique cards: " + total);
    }
}