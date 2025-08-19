package BroskiesHubTask5;
import java.io.*;

class InvalidProductDataException extends Exception{
    public InvalidProductDataException(String message) {
        super(message);
    }
}
public class bht5 {
    public static void main(String[] args) {
        String inputFile = "BroskiesHubTask4/products.csv";
        String outputFile = "BroskiesHubTask5/filtered_products1.csv";

        BufferedReader br=null;
        FileWriter fw=null;
        try{
            br=new BufferedReader(new FileReader(inputFile));
            fw=new FileWriter(outputFile);

            String line;
            boolean isFirstLine = true;

            while((line = br.readLine()) != null) {
                try{
                    if(isFirstLine) {
                        fw.write(line+"\n");
                        isFirstLine=false;
                        continue;
                    }
                    String[] parts=line.split(",");
                    if(parts.length != 2) {
                        throw new InvalidProductDataException("Invalid row format: "+line);
                    }
                    String name=parts[0];
                    double price;
                    try{
                        price=Double.parseDouble(parts[1]);
                    }catch(NumberFormatException e){
                        throw new InvalidProductDataException("Invalid price format: "+parts[1]);
                    }
                    if(price>1000){
                        fw.write(name+","+price+"\n");
                    }
                }catch(InvalidProductDataException e) {
                    System.out.println("Skipping invalid row: " + e.getMessage());
                }
            }
            System.out.println("Filtering complete! Check the file "+outputFile);
        }
        catch(FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(br != null) {
                    br.close();
                }
                if(fw != null) {
                    fw.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }


    }
}
