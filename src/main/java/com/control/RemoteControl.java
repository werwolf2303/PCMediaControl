package com.control;

import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class RemoteControl {
    public static void controlRoot(HttpExchange exchange) throws IOException {
        File file = new File("html", "Remote.html");
        exchange.sendResponseHeaders(200, file.length());
        try (OutputStream os = exchange.getResponseBody()) {
            Files.copy(file.toPath(), os);
        }
    }
    public static void controlVDown(HttpExchange exchange) throws IOException {
        Runtime.getRuntime().exec("python pythonExec/Control.py vdown");
        String out = "Succeed";
        exchange.sendResponseHeaders(404, out.length());
        exchange.getResponseBody().write(out.getBytes());
        exchange.close();
    }
    public static void controlVUp(HttpExchange exchange) throws IOException {
        Runtime.getRuntime().exec("python pythonExec/Control.py vup");
        String out = "Succeed";
        exchange.sendResponseHeaders(404, out.length());
        exchange.getResponseBody().write(out.getBytes());
        exchange.close();
    }
    public static void controlVMute(HttpExchange exchange) throws IOException {
        Runtime.getRuntime().exec("python pythonExec/Control.py vmute");
        String out = "Succeed";
        exchange.sendResponseHeaders(404, out.length());
        exchange.getResponseBody().write(out.getBytes());
        exchange.close();
    }
    public static void controlPlayPause(HttpExchange exchange) throws IOException {
        Runtime.getRuntime().exec("python pythonExec/Control.py play");
        String out = "Succeed";
        exchange.sendResponseHeaders(404, out.length());
        exchange.getResponseBody().write(out.getBytes());
        exchange.close();
    }
    public static void controlNext(HttpExchange exchange) throws IOException {
        Runtime.getRuntime().exec("python pythonExec/Control.py next");
        String out = "Succeed";
        exchange.sendResponseHeaders(404, out.length());
        exchange.getResponseBody().write(out.getBytes());
        exchange.close();
    }
    public static void controlBack(HttpExchange exchange) throws IOException {
        Runtime.getRuntime().exec("python pythonExec/Control.py back");
        String out = "Succeed";
        exchange.sendResponseHeaders(404, out.length());
        exchange.getResponseBody().write(out.getBytes());
        exchange.close();
    }
}
