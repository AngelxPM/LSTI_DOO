/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio9.utils;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author LSTI-20
 */
public class Log {
    
    private final String fileName;
    static private Log instance;
    
    private Log(String fileName){
        
        this.fileName = fileName;        
    }
    
    static public Log getInstance(String fileName){
        
        if(instance == null){
            
            instance = new Log(fileName);
            
            return instance;        
        }
        
        return instance;    
    }
    
    public void  write(String message) {
        
        try{
            
            try (BufferedWriter br = new BufferedWriter(new FileWriter(fileName, true))) { 
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();

            //Create the name of the file from the path and current time
            String data = "\n\n\n" + dateFormat.format(cal.getTime()) + ": " + message + " \n\n";
            br.write(data);
            }
            
        }catch(Exception e)
        {
            
        }
        
    }
}
