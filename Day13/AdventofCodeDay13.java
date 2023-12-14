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

    private static void findReflectionH(List<String> pattern) {
      for (int i =0; i < pattern.size(); i++){
        String rString = "";
        for (int j = 1 ; j < pattern.get(i).length(); j++){
          rString = pattern.get(i).charAt(j) + pattern.get(i).charAt(j+1) + rString;
        }
        System.out.println(rString+ "\n");
      }
    }

    private static void findReflectionV(List<String> pattern) {

    }
}