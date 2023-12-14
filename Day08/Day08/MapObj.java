package Day08;

public class MapObj {
    String right;
    String left;
    MapObj rMap;
    MapObj lMap;
    String location;

    public MapObj(String x, String y, String z){
        location = x;
        left = y;
        right = z;

    }
    
    public String getRight(){
        return right;
    } 
    public String getLeft(){
        return left;
    }
    public String getLoc(){
        return location;
    }
    public String setLeft(String x){
        left = x;
        return left;
    }
    public String setRight(String x){
        right= x;
        return right;
    }
    public String setLoc(String x){
        location= x;
        return location;
    }
    public String findNextLoc(char inst){
        if (inst == 'R'){
            return right;
        }else{
            return left;
        }
    }


}
