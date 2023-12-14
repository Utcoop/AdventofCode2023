package Day08;

import java.io.*;
import java.util.*;

public class AdventofCodeDay08{
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day08\\Day08\\input.txt";
    //public static ArrayList<Map> maps = new ArrayList<Map>();
    //public static ArrayList<ArrayList<String>> mapsArr = new ArrayList<ArrayList<String>>(); 
    public static HashMap<String,String> mapR = new HashMap<String,String>();
    public static HashMap<String,String> mapL = new HashMap<String,String>();
    public static String currentLoc;
    
    public static int solve1(String[] insArr){
        int i = 0;
        int count = 0;
        String inst;
        String currentLoc = "AAA";
        boolean bool = true;
        //System.out.println(insArr.length);
        while (bool){
            //System.out.println(i);
            inst = insArr[i];
            //myWriter.write("Current Location: " + currentLoc + ", Insruction: " +inst+ ", L: "+ mapL.get(currentLoc) +" R: " +mapR.get(currentLoc) +  " Count: " + Integer.toString(count) + ", i: "+Integer.toString(i) + "\n");
            if (inst.equals("1")){
                currentLoc = mapR.get(currentLoc);
            }else{
                currentLoc = mapL.get(currentLoc);
            }
            count++;
            if (currentLoc.equals("ZZZ")){
                //System.out.println("Found it");
                bool=false;
            }
            if (i < insArr.length-1){
                i++;
            }else{
                i=0;
            }
        }
        return count;
    }
    public static int solve2(List<String> keys, String[] insArr){
        int i = 0;
        int count = 0;
        String inst;
        boolean bool = true;
        while (bool){
            ///System.out.println(keys);
            //System.out.println(i);
            inst = insArr[i];
            //myWriter.write("Current Location: " + currentLoc + ", Insruction: " +inst+ ", L: "+ mapL.get(currentLoc) +" R: " +mapR.get(currentLoc) +  " Count: " + Integer.toString(count) + ", i: "+Integer.toString(i) + "\n");
            if (inst.equals("1")){
                keys.set(0, mapR.get(keys.get(0)));
                keys.set(1, mapR.get(keys.get(1)));
                keys.set(2, mapR.get(keys.get(2)));
                keys.set(3, mapR.get(keys.get(3)));
                keys.set(4, mapR.get(keys.get(4)));
                keys.set(5, mapR.get(keys.get(5)));
            }else{
                keys.set(0, mapL.get(keys.get(0)));
                keys.set(1, mapL.get(keys.get(1)));
                keys.set(2, mapL.get(keys.get(2)));
                keys.set(3, mapL.get(keys.get(3)));
                keys.set(4, mapL.get(keys.get(4)));            
                keys.set(5, mapL.get(keys.get(5)));            
            }
            count++;
            if (
                keys.get(0).charAt(2) == 'Z'&&
                keys.get(1).charAt(2) == 'Z'&&
                keys.get(2).charAt(2) == 'Z'&&
                keys.get(3).charAt(2) == 'Z'&&
                keys.get(4).charAt(2) == 'Z'&&
                keys.get(5).charAt(2) == 'Z'
            ){
                //System.out.println("Found it");
                bool=false;
            }
            if (i < insArr.length-1){
                i++;
            }else{
                i=0;
            }
            if (count > 17972669116327L){
                break;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException{
        //FileWriter myWriter = new FileWriter("Output.txt");
        Scanner scanner = new Scanner(new File(path));
        String inString = scanner.nextLine();
        inString =  inString.replace("L","0");
        inString =  inString.replace("R","1");
        String[] insArr = inString.split("");
        //System.out.println(inString);
        String line = scanner.nextLine();
        String[] temp;
        int l = 0;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            line = line.replaceAll("[^a-zA-Z0-9]", " ");
            //System.out.println(line);
            temp = line.split(" +");
            //System.out.println(temp[0]+ ", " + temp[1] + " , "+ temp[2]);
            //mapsArr.add(new ArrayList<String>());
            //mapsArr.get(c).add(temp[0]);
            //mapsArr.get(c).add(temp[1]);
            //mapsArr.get(c).add(temp[2]);
            //c++;
            //maps.add(new Map(temp[0], temp[1], temp[2]));
            mapL.put(temp[0],temp[1]);
            mapR.put(temp[0],temp[2]);
            if (l==0){
                currentLoc = temp[0];
            }
            l++;
        }
        ArrayList<String> keys = new ArrayList<String>();
        for (String key : mapL.keySet()){
            if ( 'A' == key.charAt(2)){
                keys.add(key);
            }
        }
        //System.out.println(keys);
        //System.out.println(solve1(insArr));
        System.out.println(solve2(keys, insArr));
    }
}
        /*
         * 
         //System.out.println(mapsArr);
         ArrayList<String> currentLoc = mapsArr.get(0);
         //System.out.println(currentLoc);
         int i = 0;
         int count = 0;
         String nextLoc;
         char inst;
         boolean bool = true;
         while (bool){
             inst = inString.charAt(i);
             if (i < inString.length()-1){
                 i++;
                }else{
                    i=0;
                }
                if (inst == 'L'){
                    nextLoc = currentLoc.get(1);
                }else {
                    nextLoc = currentLoc.get(2);
                }
                //System.out.println("Current Location: " + currentLoc + ", Insruction: " +inst+ " Next Location: " +nextLoc);
                for (ArrayList<String> a : mapsArr){
                    if (a.get(0).equals(nextLoc)){
                        currentLoc = a;
                        break;
                    }
                } 
                if (count == 19000){
                    bool= false;
                    break;
                }
                count++;
                if (currentLoc.get(0).equals("ZZZ")){
                    System.out.println("Found it");
                    bool=false;
                }
            }
            System.out.println(count);
        }
    }        
    */
    /* 
    Map currentLoc = maps.get(0);
    String nextLoc;
    //System.out.println(currentLoc);
    int i = 0;
    int count = 0;
        while (!currentLoc.getLoc().equals("ZZZ")){
            inst = inString.charAt(i);
            nextLoc = currentLoc.findNextLoc(inst);
            //System.out.println("Current Location: " + currentLoc.getLoc() + ", Insruction: " +inst+ " Next Location: " +nextLoc);
            for (Map m : maps){
                if (m.getLoc().equals(nextLoc)){
                    currentLoc = m;
                    break;
                }
            } 
            if (i < inString.length()-1){
                i++;
            }else{
                i=0;
            }
            count++;
            if (currentLoc.getLoc().equals("ZZZ"))
            break;
        }
        System.out.println(count);
        */