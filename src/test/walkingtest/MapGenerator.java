package test.walkingtest;
import java.util.*;
import java.io.*;
/**
 *
 * @author Nathan Dias {@literal <nathanxyzdias@gmail.com>}
 */
public class MapGenerator {
    
    public static void main(String[] args) throws Exception{
        
        List<String> l = new ArrayList<>();
        
        Random r = new Random();
        
        
        
        for(int x=0;x<100;x++){
            
            for(int y=0;y<100;y++){
                
                String s ="";// x+" "+y+" ";
                
                int i = r.nextInt(100);
                
                if(i<10){
                    s+="TREE";
                }else if(i<30){
                    s+="FENCE";
                } else if(i<70){
                    s+="GRASS";
                } else{
                    s+="PAVEMENT";
                }
                
                s+=" "+x+" "+y+" ";
                l.add(s);
            }
            
        }
        FileWriter fw = new FileWriter(new File("map1.map"));
        PrintWriter pw = new PrintWriter(fw);
        
        for(String s:l){
            pw.println(s);
        }
        pw.flush();
        fw.flush();
        pw.close();
        fw.close();
    }
}
