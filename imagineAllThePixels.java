import java.util.*;
import java.io.*;
import java.lang.Math;

public class imagineAllThePixels{
  public static void main(String[] args){
    try {
      String str = "";
      BufferedWriter writer = new BufferedWriter(new FileWriter("image.ppm"));
      str = "P3\n600 600\n255\n";
      String pie = Double.toString(Math.PI);
      int len = pie.length();
      writer.write(str);
      int count = 0;
      for(int i = 0; i < 600; i++){
        for(int j = 0; j < 600; j++){
          if (count >= len) count = 0;
          String dig = pie.substring(count, count+1);
          if (dig.equals(".")){
            count++;
            dig = pie.substring(count, count+1);
          }
          int digit = Integer.parseInt(dig);
          str = "" + ((digit * 60 * i) % 255) + " " + ((digit * 100 * j) % 255) + " " + ((digit * 56 * i) % 255) + " ";
          writer.write(str);
          count++;
        }
        writer.write("\n");
      }
      writer.close();
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }
}
