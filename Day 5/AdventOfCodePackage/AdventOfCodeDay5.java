package AdventOfCodePackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCodeDay5 {
    public static int lineNum;
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day 5\\AdventOfCodePackage\\input.txt";
    public static int games;
    public static List<Long> seeds = new ArrayList<Long>();
    public static List<Long> s2s = new ArrayList<Long>();
    public static List<Long> s2f = new ArrayList<Long>();
    public static List<Long> f2w = new ArrayList<Long>();
    public static List<Long> w2l = new ArrayList<Long>();
    public static List<Long> l2t = new ArrayList<Long>();
    public static List<Long> t2h = new ArrayList<Long>();
    public static List<Long> h2l = new ArrayList<Long>();
    public static Long min = 999999999999999999L;
    public static Long tempMin = 999999999999999999L; 
    public static LongBool data = new LongBool();
    
    
    public static LongBool findDest(List<Long> list, Long source, int dest, int src, int len){
        long delta;
        long newSource;
        //System.out.println(list);
        for (int i =0; i < (list.size()/3);i++){
            if (list.get(src) <= source && source < (list.get(src)+list.get(len)-1)){
                if (list.get(src) < list.get(dest)){
                    //System.out.println("data.getBool()" +  data.getBool());
                    data.setBool(false);
                }
                delta = (source - list.get(src));
                newSource = list.get(dest)+delta;
                data.setNum(newSource);
                //System.out.println(list.get(dest)+ ", " + list.get(src)+ ", "+ list.get(len)+ "\nSource: " + source);
                return data;
            }
            dest=dest+3;
            src=src+3;
            len=len+3;
        }
        data.setNum(source);
        return data;
    }
    
    public static long findDest(List<Long> seeds){
        int destIDX =0;
        int srcIDX = 1; 
        int lenIDX = 2;
        for (int s=0; s < seeds.size(); s++){
            //System.out.println(s);
            data = findDest(s2s,seeds.get(s), destIDX, srcIDX, lenIDX);
            //System.out.println(tempSRC);
            data = findDest(s2f,data.getNum(), destIDX, srcIDX, lenIDX);
            //System.out.println(tempSRC);
            data = findDest(f2w,data.getNum(), destIDX, srcIDX, lenIDX);
            //System.out.println(tempSRC);
            data = findDest(w2l,data.getNum(), destIDX, srcIDX, lenIDX);
            //System.out.println(tempSRC);
            data = findDest(l2t,data.getNum(), destIDX, srcIDX, lenIDX);
           //System.out.println(tempSRC);
            data = findDest(t2h,data.getNum(), destIDX, srcIDX, lenIDX);
            //System.out.println(tempSRC);
            data = findDest(h2l,data.getNum(), destIDX, srcIDX, lenIDX);
            if (min>data.getNum())
                min = data.getNum();
        }  
        return min;
    }

    public static long findDestwithRange(List<Long> seeds){
        int destIDX =0;
        int srcIDX = 1; 
        int lenIDX = 2;
        Long seedRange;
        Long currentSeed;
        for (int c =0 ; c < seeds.size(); c = c +2){
            seedRange = seeds.get(c+1);
            currentSeed = seeds.get(c);
            seedRange = seedRange+currentSeed;
            data.setBool(true);
            for (long s=currentSeed; s < seedRange; s++){
                //System.out.println(data.getBool());
                //if (!data.getBool()){
                //    break;
                ///}
                data = findDest(s2s,s, destIDX, srcIDX, lenIDX);
                //System.out.println(tempSRC);
                data = findDest(s2f,data.getNum(), destIDX, srcIDX, lenIDX);
                //System.out.println(tempSRC);
                data = findDest(f2w,data.getNum(), destIDX, srcIDX, lenIDX);
                //System.out.println(tempSRC);
                data = findDest(w2l,data.getNum(), destIDX, srcIDX, lenIDX);
                //System.out.println(tempSRC);
                data = findDest(l2t,data.getNum(), destIDX, srcIDX, lenIDX);
                //System.out.println(tempSRC);
                data = findDest(t2h,data.getNum(), destIDX, srcIDX, lenIDX);
                //System.out.println(tempSRC);
                data = findDest(h2l,data.getNum(), destIDX, srcIDX, lenIDX);
                if (min>data.getNum())
                    min = data.getNum();
            }
        }  
        return min;
    }
    
    
    
    
    public static void main(String[] args) throws FileNotFoundException {
        lineNum = 1;
        String where = ""; 
        String tempString;
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("seed-to-soil map:")){
                where = "s2s";
            } else if (line.equals("soil-to-fertilizer map:")){
                where = "s2f";
            } else if (line.equals("fertilizer-to-water map:")){
                where = "f2w";
            } else if (line.equals("water-to-light map:")){
                where = "w2l";
            } else if (line.equals("light-to-temperature map:")){
                where = "l2t";
            }  else if (line.equals("temperature-to-humidity map:")){
                where = "t2h";
            } else if (line.equals("humidity-to-location map:")){
                where = "h2l";
            }
            //System.out.println(where);
            tempString = line.substring(line.indexOf(":") + 1);
            tempString = tempString.trim();
            if (!tempString.isEmpty()){    
                String[] tempArr = tempString.split(" ");
                for (int i =0 ; i < tempArr.length; i++){
                    if (lineNum==1){
                        seeds.add(Long.parseLong(tempArr[i]));                        
                    } else if (where.equals("s2s")){
                        s2s.add(Long.parseLong(tempArr[i]));
                    } else if (where.equals("s2f")){
                        s2f.add(Long.parseLong(tempArr[i]));
                    } else if (where.equals("f2w")){
                        f2w.add(Long.parseLong(tempArr[i]));
                    } else if (where.equals("w2l")){
                        w2l.add(Long.parseLong(tempArr[i]));
                    } else if (where.equals("l2t")){
                        l2t.add(Long.parseLong(tempArr[i]));
                    } else if (where.equals("t2h")){
                        t2h.add(Long.parseLong(tempArr[i]));
                    } else if (where.equals("h2l")){
                        h2l.add(Long.parseLong(tempArr[i]));
                    }
                }
            lineNum++;
            }
        }
        //System.out.println(findDest(seeds));
        System.out.println(findDestwithRange(seeds));
    }
}