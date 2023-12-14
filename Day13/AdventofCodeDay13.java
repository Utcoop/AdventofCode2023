import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class AdventofCodeDay13{
  public List<String> rows = new ArrayList<>();
  public List<String> columns = new ArrayList<>();

    public static void main(String[] args) throws IOException {
      List<String> lines = Files.readAllLines(Path.of("temp.txt"));
      List<String> pattern = new ArrayList<>();
      for (String line: lines){
        if (line.isBlank()){
          findReflectionH(pattern);
          //findReflectionV(pattern);
          //System.out.println(pattern);
          pattern = new ArrayList<>();
        }else{
          pattern.add(line);
        }
      }
    }

    private static int findReflectionH(List<String> pattern) {
      int indexOfReflection = 0;
      String rString = "";
      String fString = "";
      for (int i =0; i < pattern.size(); i++){
        fString = "";
        for (int j = 1 ; j < pattern.get(i).length()/2; j++){ // j = 1 in the final version. j = 0 to see full strings
          rString = "";
          fString += pattern.get(i).charAt(j);
          for (int k = j+1 ; k < j*2+1; k++){
            rString += pattern.get(i).charAt(k);
            if (fString.equals(rString)){
              indexOfReflection=j-1;
              System.out.println(indexOfReflection);
              break;
            }
          }
        }
        System.out.println(rString);
        System.out.println(fString);
        System.out.println(fString+rString+"\n");
      }
      return indexOfReflection;
    }

    private static void findReflectionV(List<String> pattern) {

    }
}