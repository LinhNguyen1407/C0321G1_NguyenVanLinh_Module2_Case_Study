package case_study_FuramaResort.commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void writeToFile(List<Object> listService, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listService);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    public static List<Object> readFromFile(String path){
        List<Object> listService = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listService = (List<Object>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return listService;
    }
}
