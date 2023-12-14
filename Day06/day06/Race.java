package day06;

public class Race {
    public int time;
    public int distance;

    public Race(int t, int d){
        time = t;
        distance = d;
    }
    
    public int getDist(){
        return distance;
    }
        
    public int getTime(){
        return time;
    }
        
    public int setDist(int x){
        distance = x;
        return distance;
    }
        
    public int setTime(int x){
        time = x;
        return time;
    }
}
