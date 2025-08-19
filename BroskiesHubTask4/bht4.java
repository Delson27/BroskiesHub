package BroskiesHubTask4;
import java.io.*;
public class bht4 {
    public static void main(String[] args) {
        String inputFile="BroskiesHubTask4/products.csv";
        String outputFile="BroskiesHubTask4/filtered_products.csv";

        try(BufferedReader br=new BufferedReader(new FileReader(inputFile));
            FileWriter fw=new FileWriter(outputFile);){
                String line;
                boolean isFirstLine=true;
                while((line=br.readLine())!=null){
                    
                    if(isFirstLine){
                        fw.write(line + "\n");
                        isFirstLine=false;
                        continue;
                    }
                    String[] parts=line.split(",");
                    if(parts.length!=2)
                      continue;
                    String name=parts[0];
                    double price=Double.parseDouble(parts[1]);
                    if(price>1000){
                        fw.write(name + "," + price + "\n");
                    }
                }
                System.out.println("Filtering complete! Check the file "+outputFile);
            }
            catch(IOException e){
                e.printStackTrace();
            }

}
}
