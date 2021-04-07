package com.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Config {
    private boolean exists = false;
    public Config() {
        File fconfig = new File("config");
        File config = new File("config", "config.yml");
        if(!fconfig.exists()) {
            System.err.println("Config folder doesnt exist!");
        }else{
            if(!config.exists()) {
                System.err.println("Configuration file doesnt exist!");
            }else{
                exists = true;
            }
        }
    }
    public void createConfig() {
        if(exists) {
            try {
                FileWriter myWriter = new FileWriter(new File("config", "config.yml"));
                myWriter.write("port = 4500");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.err.println("Config doesnt exist!");
        }
    }
    public String readString(String toRead) {
        if(exists) {
            String toReturn = null;
            try {
                File myObj = new File("config", "config.yml");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if(data.contains(toRead)) {
                        String pre = data.replace(" ", "").replace(toRead, ""). replace("=", "");
                        toReturn = pre;
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return toReturn;
        }else{
            System.err.println("Config doesnt exist!");
        }
        return null;
    }
}
