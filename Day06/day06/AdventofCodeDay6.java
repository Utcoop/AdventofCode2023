package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class AdventofCodeDay6{
    public static String path = "C:\\Users\\jacks\\Projects\\Advent of Code\\Day06\\input.txt";
    public static String[] time;
    public static String[] distance;
    static ArrayList<Race> races = new ArrayList<Race>();

    public static int solve(List<Race> races){
        int time = 0;
        int tt = 0;
        int dt = 0;
        int distance = 0;
        int count = 0;
        int total = 1;
        for (int c = 0; c< races.size(); c++){
            time = races.get(c).getTime();
            distance = races.get(c).getDist();
            count = 0;
            //System.out.println(time);
            for (int i =0; i < time; i++){
                tt = time - i;
                dt = tt * i;
                System.out.println("time: " +  time +", tt: " + tt + ", speed: " + i +", dt: " + dt );
                if (dt > distance){
                    count++;
                }
            }
            total = total * count;
        }
        return total;
    }

    public static Long solve(Long time, Long distance){
        Long tt = 0l;
        Long dt = 0l;
        int count = 0;
        Long total = 1l;
        //System.out.println(time);
        for (long i =0; i < time; i++){
            tt = time - i;
            dt = tt * i;
            //System.out.println("time: " +  time +", tt: " + tt + ", speed: " + i +", dt: " + dt );
            if (dt > distance){
                count++;
            }
        }
        total = total * count;
        return total;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        String line ="";
        boolean bool = true;
        String concatT ="";
        String concatD ="";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            line = line.substring(line.indexOf(":")+1).trim();
            line = line.replaceAll(" +", ",");
            if (bool){
                time = line.split(",");
            }else { 
                distance = line.split(",");
            }
            bool = false;
        }
        for (int i = 0; i<time.length; i++){
            races.add(new Race(Integer.parseInt(time[i]), Integer.parseInt(distance[i])));
            //System.out.println(races.get(i).getTime()+ " " + races.get(i).getDist());
            concatT += time[i];
            concatD += distance[i]; 
        }
        Long time = Long.parseLong(concatT);
        Long distance = Long.parseLong(concatD);

        System.out.println(solve(time, distance));
        //System.out.println(solve(races));
    }
}