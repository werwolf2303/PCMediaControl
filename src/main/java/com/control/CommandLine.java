package com.control;

import java.util.Scanner;

public class CommandLine {
    Server s;
    public void create() {
        s = new Server();
        s.runServer();
        System.out.println("Start server on port " + s.port);
        if(s.isRunning) {
            System.out.println("Server started");
        }else{
            System.out.println("Error failed, the server might not work correctly");
        }
        System.out.println("Type help to show all commands");
        cc();
    }
    public void cc() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("CommandLine > ");
        String line = myObj.nextLine();
        if(!line.replace(" ", "").equals("")) {
            if(line.toLowerCase().equals("help")) {
                System.out.println("start (Starts the server)");
                System.out.println("stop (Stops the server)");
                System.out.println("exit (Exits the commandline and stops the server)");
            }else{
                if(line.toLowerCase().equals("start")) {
                    if(!s.isRunning) {
                        s.runServer();
                    }else{
                        System.out.println("Already running");
                    }
                }else{
                    if(line.toLowerCase().equals("stop")) {
                        if(s.isRunning) {
                            s.stopServer();
                        }else{
                            System.out.println("Server not running");
                        }
                    }else{
                        if(line.toLowerCase().equals("exit")) {
                            s.stopServer();
                            System.exit(0);
                        }else{
                            System.out.println("Unknown command: " + line);
                        }
                    }
                }
            }
            cc();
        }
        cc();
    }
}
