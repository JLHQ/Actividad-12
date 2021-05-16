package Actividad12;

import java.util.*;
import java.io.*;
/**
 *
 * @author Luis_
 */
public class AddressBook {
    final static String ioFilePath = "src/Actividad12/archive.txt";
    HashMap<String, String> contactName = new HashMap<String, String>();
    File ioFile = new File(ioFilePath);
    BufferedWriter buffWriter = null;
    BufferedReader buffReader = null;
    
    public void load(){
        try {
            buffReader = new BufferedReader(new FileReader(ioFile));
            String line;
            while ((line = buffReader.readLine()) != null) {
                String[] parts = line.split(",");
                contactName.put(parts[0], parts[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (buffReader != null) {
                    buffReader.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void save(String name, String phone){
        if (name != "") {
           FileWriter fileWriter = null;
           try {
               fileWriter = new FileWriter(ioFile, true);
               buffWriter = new BufferedWriter(fileWriter);
               buffWriter.write(phone + "," + name + "\n");
           } catch (Exception e) {
               System.out.println(e.getMessage());
           } finally {
               try {
                   if (buffWriter != null) {
                       buffWriter.close();
                   }
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
           }
       }else{}
    }
    
    public void list(){
        System.out.println("Cotact List:");
        for (String i : contactName.keySet()) {
            System.out.println("{" + i + "} {" + contactName.get(i) + "}");
        }
    }
    
    public void delete(String name){
        if (contactName.containsKey(name)) {
            contactName.remove(name);
            System.out.println("Contact has been deleted");

            try {
                buffWriter = new BufferedWriter(new FileWriter(ioFile));
                int c = 0;
                for (Map.Entry<String, String> entry : contactName.entrySet()) {
                    if (c == 0) {
                        buffWriter.write(entry.getKey() + "," + entry.getValue());
                        c++;
                    } else {
                        buffWriter.write("\n" + entry.getKey() + "," + entry.getValue());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (buffWriter != null) {
                        buffWriter.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("Unknown Contact");
        }
    }
    
    public void create(String name, String phone){
        contactName.put(name, phone);
        try{
            buffWriter = new BufferedWriter(new FileWriter(ioFile));
            for (Map.Entry<String,String> entry : contactName.entrySet()){
                buffWriter.write(entry.getKey() + "," + entry.getValue());
                buffWriter.newLine();
            }
            buffWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                buffWriter.close();
            }catch (Exception e){}
        }
    }
}

