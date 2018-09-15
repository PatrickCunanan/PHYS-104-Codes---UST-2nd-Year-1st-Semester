package calorimetry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author harji
 */
public class FileReaderCalorimetry{
    private String Material,SpecificHeat,Melting,LatentHeatF,Boiling,LatentHeatV;
    public boolean Read(String Text)throws IOException,FileNotFoundException{
        BufferedReader Br;
        Scanner WordScan;
        String Filename = "CalorimetryTable.txt",Line,MaterialTest;
        boolean logic = false;
        
        try{
           Br = new BufferedReader(new FileReader(Filename));
           while((Line = Br.readLine())!= null){
               WordScan = new Scanner(Line);
               while(WordScan.hasNext()){
                   if((MaterialTest = WordScan.next()).toUpperCase().equals(Text.toUpperCase())){
                       Material = MaterialTest;
                       SpecificHeat = WordScan.next();
                       Melting = WordScan.next();
                       LatentHeatF = WordScan.next();
                       Boiling = WordScan.next();
                       LatentHeatV = WordScan.next();
                       logic = true;
                   }
               }
           }
        }
        catch(FileNotFoundException e){
            logic = false;
            JOptionPane.showMessageDialog(null, "The file can't be found. The file has been deleted or renamed, and please check it before running the program. The filename should be CalorimetryTable.txt.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException e){
            
        }
    return logic;
    }
    public String getMaterial(){
        if("ethyl_alcohol".equals(Material)){
            Material = "ethyl alcohol";
        }
        return Material;
    }
    public String getSpecificHeat(){
        return SpecificHeat;
    }
    public String getMelting(){
        return Melting;
    }
    public String getLatentHeatF(){
        return LatentHeatF;
    }
    public String getBoiling(){
        return Boiling;
    }
    public String getLatentHeatV(){
        return LatentHeatV;
    }
}
