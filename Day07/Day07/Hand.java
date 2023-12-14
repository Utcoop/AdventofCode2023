package Day07;

import java.util.*;

public class Hand{
    public String hand;
    public int bid;
    public int tier;
    public int weight;
    public int[] handArr = new int[5];

    public Hand(String x, int y){ 
        hand = x;
        bid = y;
        //weight = setWeight(x);
        setTier(x);
        setHandArr(x);
    }

    private void setTier(String x){
        String letter;
        ArrayList<Integer> count = new ArrayList<Integer>();
        int numJ = (x.length() - x.replaceAll("J","").length());
        for (int c = 0; c < x.length(); c++){
            letter = String.valueOf(x.charAt(c));
            count.add(x.length() - x.replaceAll(letter,"").length());
            if (count.contains(5)){ // 5 of a kind tier 7
                this.setTier(7);
            }else if (count.contains(4)){ // 4 of a kind tier 6
                if (x.contains("J")){
                    this.setTier(7);
                }else{
                    this.setTier(6);
                }
            } else if (count.contains(3)&&count.contains(2)){ // full house tier 5
                if (x.contains("J")){
                    this.setTier(7);
                }else{
                    this.setTier(5);
                }
            } else if (count.contains(3)){  // 3 of a kind tier 4
                if (x.contains("J")){
                    this.setTier(6);
                }else{
                    this.setTier(4);
                }
            } else if (count.contains(2) && 4==Collections.frequency(count, 2)){ // 2 pair tier 3
                if (x.contains("J") && numJ ==2){
                    this.setTier(6);
                }else if (x.contains("J") && numJ ==1){
                    this.setTier(5);
                }else{
                    this.setTier(3);
                }
            } else if (count.contains(2)){ // 1 pair tier 2
                if (x.contains("J") && numJ == 1){
                    this.setTier(4);
                }else if (x.contains("J") && numJ==2){
                    this.setTier(4);
                }else{
                    this.setTier(2);
                }
            }else{
                if (x.contains("J")){
                    this.setTier(2);
                }else{
                    this.setTier(1); // high card tier 1
                }
            }
        }
        //System.out.println(count);
        //System.out.println(this.getTier());
    }
    public int[] getHandArr(){
        return handArr;
    } 
    private int[] setHandArr(String x){
        for (int i =0; i<x.length(); i++){
            if (x.charAt(i)=='A'){
                handArr[i] = 14;
            }else if (x.charAt(i)=='K'){
                handArr[i] = 13;
            }else if (x.charAt(i)=='Q'){
                handArr[i] = 12;
            }else if (x.charAt(i)=='J'){
                handArr[i] = 1;
            }else if (x.charAt(i)=='T'){
                handArr[i] = 10;
            }else {
                handArr[i] = Character.getNumericValue(x.charAt(i));
            }
        }
        return handArr;
    }

    private int setWeight(String x){
        for (int i =0; i<x.length(); i++){
            if (x.charAt(i)=='A'){
                weight = weight + 14;
            }else if (x.charAt(i)=='k'){
                weight = weight + 13;
            }else if (x.charAt(i)=='Q'){
                weight = weight + 12;
            }else if (x.charAt(i)=='J'){
                weight = weight + 11;
            }else if (x.charAt(i)=='T'){
                weight = weight + 10;
            }else {
                weight = weight + Character.getNumericValue(x.charAt(i));
            }
        }
        return weight;
    }

    public String getHand(){
        return hand;
    }
    public String setHand(String x){
        hand = x;
        setHandArr(x);
        return hand;
    }
    public int getBid(){
        return bid;
    }
    public int setBid(int x){
        bid = x;
        return bid;
    }
    public void setTier(int x){
        tier=x;
    }

    public int getTier(){
        return tier;
    }
}