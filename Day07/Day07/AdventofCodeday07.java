package Day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AdventofCodeday07{
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day07\\Day07\\input.txt";
    public static ArrayList<Hand> hands = new ArrayList<Hand>();

    /*
    static void bubbleSort(ArrayList<Hand> arr, int n)
    {
        int i, j;
        //Hand temp = new Hand("", 0);
        int tempB1, tempT1;
        int tempB2, tempT2;
        String tempH1, tempH2;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr.get(j).getTier() == arr.get(j + 1).getTier()) {
                    for (int k =0 ; k<arr.get(j).getHandArr().length; k++){
                        if (!swapped){
                            if (arr.get(j).getHandArr()[k] > arr.get(j+1).getHandArr()[k]){
                                tempB1 = arr.get(j).getBid();
                                tempH1 = arr.get(j).getHand();
                                tempT1 = arr.get(j).getTier();
                                tempB2 = arr.get(j+1).getBid();
                                tempH2 = arr.get(j+1).getHand();
                                tempT2 = arr.get(j+1).getTier();
                                arr.get(j).setBid(tempB2);
                                arr.get(j).setHand(tempH2);
                                arr.get(j).setTier(tempT2);
                                arr.get(j+1).setBid(tempB1);
                                arr.get(j+1).setHand(tempH1);
                                arr.get(j+1).setTier(tempT1);
                                swapped = true;
                            }
                        }
                    }
                }
            }
            // If no two elements were swapped
            // by inner loop, then break
            if (swapped == false)
                break;
        }
    }*/

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        String line ="";
        String[] tempString;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            tempString = line.split(" ");
            hands.add(new Hand(tempString[0], Integer.parseInt(tempString[1])));
            //System.out.println(line);
        }
        MergeSort merge = new MergeSort();
        merge.sort(hands, 0, hands.size()-1);
        //bubbleSort(hands, hands.size());
        ArrayList<Hand> t1 = new ArrayList<Hand>();
        ArrayList<Hand> t2 = new ArrayList<Hand>();
        ArrayList<Hand> t3 = new ArrayList<Hand>();
        ArrayList<Hand> t4 = new ArrayList<Hand>();
        ArrayList<Hand> t5 = new ArrayList<Hand>();
        ArrayList<Hand> t6 = new ArrayList<Hand>();
        ArrayList<Hand> t7 = new ArrayList<Hand>();
        for (int i =0; i < hands.size(); i++){
            if (hands.get(i).getTier() == 1)
                t1.add(hands.get(i));
            else if (hands.get(i).getTier() == 2)
                t2.add(hands.get(i));
            else if (hands.get(i).getTier() == 3)
                t3.add(hands.get(i));
            else if (hands.get(i).getTier() == 4)
                t4.add(hands.get(i));
            else if (hands.get(i).getTier() == 5)
                t5.add(hands.get(i));
            else if (hands.get(i).getTier() == 6)
                t6.add(hands.get(i));
            else if (hands.get(i).getTier() == 7)
                t7.add(hands.get(i));
        }
        merge.sort2(t1, 0, t1.size()-1);
        merge.sort2(t2, 0, t2.size()-1);
        merge.sort2(t3, 0, t3.size()-1);
        merge.sort2(t4, 0, t4.size()-1);
        merge.sort2(t5, 0, t5.size()-1);
        merge.sort2(t6, 0, t6.size()-1);
        merge.sort2(t7, 0, t7.size()-1);
        hands.clear();
        for (int i =0; i < t1.size(); i++){
            hands.add(t1.get(i));
        }
        for (int i =0; i < t2.size(); i++){
            hands.add(t2.get(i));
        } 
        for (int i =0; i < t3.size(); i++){
            hands.add(t3.get(i));
        }
        for (int i =0; i < t4.size(); i++){
            hands.add(t4.get(i));        
        }
        for (int i =0; i < t5.size(); i++){
            hands.add(t5.get(i));
        }
        for (int i =0; i < t6.size(); i++){
            hands.add(t6.get(i));
        }
        for (int i =0; i < t7.size(); i++){
            hands.add(t7.get(i));
        }
        
        int result = 0;
        for (int i =0 ; i < hands.size() ;i++){
            System.out.println(hands.get(i).getHand() + " " + hands.get(i).getTier() + ' ' + hands.get(i).getBid());
            result = result + (hands.get(i).getBid() * (i+1)); 
        }
        System.out.println(result);
        /*
        System.out.println(hands.get(1).getHand());
        for (int i =0; i < hands.get(1).getHandArr().length; i++){
            System.out.println(hands.get(1).getHandArr()[i]);
        }*/
    }
}