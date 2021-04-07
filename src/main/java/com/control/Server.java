package com.control;

import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Server extends Thread {
    Boolean isRunning = false;
    HttpServer server = null;
    int port = Integer.parseInt(new Config().readString("port"));
    public static void main(String[] args) throws IOException {
        File fconfig = new File("config");
        File config = new File("config", "config.yml");
        File startup = new File("startup");
        File html = new File("html");
        File remote = new File("html", "Remote.html");
        if(!fconfig.exists()) {
            fconfig.mkdir();
        }
        if(!config.exists()) {
            config.createNewFile();
            new Config().createConfig();
        }
        String[] files;
        if(!startup.exists()) {
            startup.mkdir();
        }
        files = startup.list();
        if(!html.exists()) {
            html.mkdir();
        if(!remote.exists()) {
                try {
                    remote.createNewFile();
                    FileWriter myWriter = new FileWriter(remote);
                    myWriter.write("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>RemoteControl</title>\n" +
                            "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
                            "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf\" crossorigin=\"anonymous\"></script>\n" +
                            "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">\n" +
                            "    <link\n" +
                            "            rel=\"stylesheet\"\n" +
                            "            href=\"https://use.fontawesome.com/releases/v5.13.0/css/all.css\"\n" +
                            "            integrity=\"sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V\"\n" +
                            "            crossorigin=\"anonymous\"\n" +
                            "    />\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('playpause')\"><i class=\"fa fa-pause\"></i><i class=\"fa fa-play\"></i></button>\n" +
                            "Play or pause the content\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('vdown')\"><i class=\"fa fa-volume-down\"></i></button>\n" +
                            "Turns down the volume\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('vup')\"><i class=\"fa fa-volume-up\"></i></button>\n" +
                            "Turns ip the volume\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('vmute')\"><i class=\"fa fa-volume-mute\"></i></button>\n" +
                            "Mutes the volume\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('next')\"><i class=\"fas fa-forward\"></i></button>\n" +
                            "Next\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('back')\"><i class=\"fa fa-backward\"></i></button>\n" +
                            "Previous\n" +
                            "<script>\n" +
                            "    function control(key) {\n" +
                            "    var xhttp = new XMLHttpRequest();\n" +
                            "    xhttp.open(\"GET\", \"/\" + key, true);\n" +
                            "    xhttp.send();\n" +
                            "    }\n" +
                            "</script>\n" +
                            "</body>\n" +
                            "</html>");
                    myWriter.close();
                } catch (IOException e) {
                    System.exit(1);
                    e.printStackTrace();
                }
            }
        }else{
            html.mkdir();
            if(!remote.exists()) {
                try {
                    remote.createNewFile();
                    FileWriter myWriter = new FileWriter(remote);
                    myWriter.write("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <title>RemoteControl</title>\n" +
                            "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
                            "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf\" crossorigin=\"anonymous\"></script>\n" +
                            "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\">\n" +
                            "    <link\n" +
                            "            rel=\"stylesheet\"\n" +
                            "            href=\"https://use.fontawesome.com/releases/v5.13.0/css/all.css\"\n" +
                            "            integrity=\"sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V\"\n" +
                            "            crossorigin=\"anonymous\"\n" +
                            "    />\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('playpause')\"><i class=\"fa fa-pause\"></i><i class=\"fa fa-play\"></i></button>\n" +
                            "Play or pause the content\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('vdown')\"><i class=\"fa fa-volume-down\"></i></button>\n" +
                            "Turns down the volume\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('vup')\"><i class=\"fa fa-volume-up\"></i></button>\n" +
                            "Turns ip the volume\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('vmute')\"><i class=\"fa fa-volume-mute\"></i></button>\n" +
                            "Mutes the volume\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('next')\"><i class=\"fas fa-forward\"></i></button>\n" +
                            "Next\n" +
                            "<br>\n" +
                            "<br>\n" +
                            "<button class=\"btn btn-outline-primary\" onclick=\"control('back')\"><i class=\"fa fa-backward\"></i></button>\n" +
                            "Previous\n" +
                            "<script>\n" +
                            "    function control(key) {\n" +
                            "    var xhttp = new XMLHttpRequest();\n" +
                            "    xhttp.open(\"GET\", \"/\" + key, true);\n" +
                            "    xhttp.send();\n" +
                            "    }\n" +
                            "</script>\n" +
                            "</body>\n" +
                            "</html>");
                    myWriter.close();
                } catch (IOException e) {
                    System.exit(1);
                    e.printStackTrace();
                }
            }
        }
        for (String pathname : files) {
            if(pathname.contains(".py")) {
                Runtime.getRuntime().exec("python3 startup/" + pathname);
            }
            if(pathname.contains(".jar")) {
                Runtime.getRuntime().exec("java -jar startup/" + pathname);
            }
        }
        new Server().pythonExec();
        new CommandLine().create();
    }
    public void pythonExec() {
        File pythonExec = new File("pythonExec");
        File Audio = new File("pythonExec", "Audio.py");
        File Control = new File("pythonExec", "Control.py");
        if(!pythonExec.exists()) {
            pythonExec.mkdir();
        }
        if(!Audio.exists()) {
            try {
                Audio.createNewFile();
                FileWriter myWriter = new FileWriter(Audio);
                myWriter.write("# --- Setup ---#\n" +
                        "from ctypes import *\n" +
                        "from time import sleep\n" +
                        "\n" +
                        "user32 = windll.user32\n" +
                        "kernel32 = windll.kernel32\n" +
                        "delay = 0.01\n" +
                        "\n" +
                        "\n" +
                        "####################################\n" +
                        "###---KEYBOARD CONTROL SECTION---###\n" +
                        "####################################\n" +
                        "\n" +
                        "# --- Key Code Variables ---#\n" +
                        "class key:\n" +
                        "    cancel = 0x03\n" +
                        "    backspace = 0x08\n" +
                        "    tab = 0x09\n" +
                        "    enter = 0x0D\n" +
                        "    shift = 0x10\n" +
                        "    ctrl = 0x11\n" +
                        "    alt = 0x12\n" +
                        "    capslock = 0x14\n" +
                        "    esc = 0x1B\n" +
                        "    space = 0x20\n" +
                        "    pgup = 0x21\n" +
                        "    pgdown = 0x22\n" +
                        "    end = 0x23\n" +
                        "    home = 0x24\n" +
                        "    leftarrow = 0x26\n" +
                        "    uparrow = 0x26\n" +
                        "    rightarrow = 0x27\n" +
                        "    downarrow = 0x28\n" +
                        "    select = 0x29\n" +
                        "    print = 0x2A\n" +
                        "    execute = 0x2B\n" +
                        "    printscreen = 0x2C\n" +
                        "    insert = 0x2D\n" +
                        "    delete = 0x2E\n" +
                        "    help = 0x2F\n" +
                        "    num0 = 0x30\n" +
                        "    num1 = 0x31\n" +
                        "    num2 = 0x32\n" +
                        "    num3 = 0x33\n" +
                        "    num4 = 0x34\n" +
                        "    num5 = 0x35\n" +
                        "    num6 = 0x36\n" +
                        "    num7 = 0x37\n" +
                        "    num8 = 0x38\n" +
                        "    num9 = 0x39\n" +
                        "    a = 0x41\n" +
                        "    b = 0x42\n" +
                        "    c = 0x43\n" +
                        "    d = 0x44\n" +
                        "    e = 0x45\n" +
                        "    f = 0x46\n" +
                        "    g = 0x47\n" +
                        "    h = 0x48\n" +
                        "    i = 0x49\n" +
                        "    j = 0x4A\n" +
                        "    k = 0x4B\n" +
                        "    l = 0x4C\n" +
                        "    m = 0x4D\n" +
                        "    n = 0x4E\n" +
                        "    o = 0x4F\n" +
                        "    p = 0x50\n" +
                        "    q = 0x51\n" +
                        "    r = 0x52\n" +
                        "    s = 0x53\n" +
                        "    t = 0x54\n" +
                        "    u = 0x55\n" +
                        "    v = 0x56\n" +
                        "    w = 0x57\n" +
                        "    x = 0x58\n" +
                        "    y = 0x59\n" +
                        "    z = 0x5A\n" +
                        "    leftwin = 0x5B\n" +
                        "    rightwin = 0x5C\n" +
                        "    apps = 0x5D\n" +
                        "    sleep = 0x5F\n" +
                        "    numpad0 = 0x60\n" +
                        "    numpad1 = 0x61\n" +
                        "    numpad3 = 0x63\n" +
                        "    numpad4 = 0x64\n" +
                        "    numpad5 = 0x65\n" +
                        "    numpad6 = 0x66\n" +
                        "    numpad7 = 0x67\n" +
                        "    numpad8 = 0x68\n" +
                        "    numpad9 = 0x69\n" +
                        "    multiply = 0x6A\n" +
                        "    add = 0x6B\n" +
                        "    seperator = 0x6C\n" +
                        "    subtract = 0x6D\n" +
                        "    decimal = 0x6E\n" +
                        "    divide = 0x6F\n" +
                        "    F1 = 0x70\n" +
                        "    F2 = 0x71\n" +
                        "    F3 = 0x72\n" +
                        "    F4 = 0x73\n" +
                        "    F5 = 0x74\n" +
                        "    F6 = 0x75\n" +
                        "    F7 = 0x76\n" +
                        "    F8 = 0x77\n" +
                        "    F9 = 0x78\n" +
                        "    F10 = 0x79\n" +
                        "    F11 = 0x7A\n" +
                        "    F12 = 0x7B\n" +
                        "    F13 = 0x7C\n" +
                        "    F14 = 0x7D\n" +
                        "    F15 = 0x7E\n" +
                        "    F16 = 0x7F\n" +
                        "    F17 = 0x80\n" +
                        "    F19 = 0x82\n" +
                        "    F20 = 0x83\n" +
                        "    F21 = 0x84\n" +
                        "    F22 = 0x85\n" +
                        "    F23 = 0x86\n" +
                        "    F24 = 0x87\n" +
                        "    numlock = 0x90\n" +
                        "    scrolllock = 0x91\n" +
                        "    leftshift = 0xA0\n" +
                        "    rightshift = 0xA1\n" +
                        "    leftctrl = 0xA2\n" +
                        "    rightctrl = 0xA3\n" +
                        "    leftmenu = 0xA4\n" +
                        "    rightmenu = 0xA5\n" +
                        "    browserback = 0xA6\n" +
                        "    browserforward = 0xA7\n" +
                        "    browserrefresh = 0xA8\n" +
                        "    browserstop = 0xA9\n" +
                        "    browserfavories = 0xAB\n" +
                        "    browserhome = 0xAC\n" +
                        "    volumemute = 0xAD\n" +
                        "    volumedown = 0xAE\n" +
                        "    volumeup = 0xAF\n" +
                        "    nexttrack = 0xB0\n" +
                        "    prevoustrack = 0xB1\n" +
                        "    stopmedia = 0xB2\n" +
                        "    playpause = 0xB3\n" +
                        "    launchmail = 0xB4\n" +
                        "    selectmedia = 0xB5\n" +
                        "    launchapp1 = 0xB6\n" +
                        "    launchapp2 = 0xB7\n" +
                        "    semicolon = 0xBA\n" +
                        "    equals = 0xBB\n" +
                        "    comma = 0xBC\n" +
                        "    dash = 0xBD\n" +
                        "    period = 0xBE\n" +
                        "    slash = 0xBF\n" +
                        "    accent = 0xC0\n" +
                        "    openingsquarebracket = 0xDB\n" +
                        "    backslash = 0xDC\n" +
                        "    closingsquarebracket = 0xDD\n" +
                        "    quote = 0xDE\n" +
                        "    play = 0xFA\n" +
                        "    zoom = 0xFB\n" +
                        "    PA1 = 0xFD\n" +
                        "    clear = 0xFE\n" +
                        "\n" +
                        "\n" +
                        "# --- Keyboard Control Functions ---#\n" +
                        "\n" +
                        "# Category variables\n" +
                        "letters = \"qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM\"\n" +
                        "shiftsymbols = \"~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\\\"ZXCVBNM<>?\"\n" +
                        "\n" +
                        "\n" +
                        "# Presses and releases the key\n" +
                        "def press(key):\n" +
                        "    user32.keybd_event(key, 0, 0, 0)\n" +
                        "    sleep(delay)\n" +
                        "    user32.keybd_event(key, 0, 2, 0)\n" +
                        "    sleep(delay)\n" +
                        "\n" +
                        "\n" +
                        "# Holds a key\n" +
                        "def hold(key):\n" +
                        "    user32.keybd_event(key, 0, 0, 0)\n" +
                        "    sleep(delay)\n" +
                        "\n" +
                        "\n" +
                        "# Releases a key\n" +
                        "def release(key):\n" +
                        "    user32.keybd_event(key, 0, 2, 0)\n" +
                        "    sleep(delay)\n" +
                        "\n" +
                        "\n" +
                        "# Types out a string\n" +
                        "def typestr(sentence):\n" +
                        "    for letter in sentence:\n" +
                        "        shift = letter in shiftsymbols\n" +
                        "        fixedletter = \"space\"\n" +
                        "        if letter == \"`\" or letter == \"~\":\n" +
                        "            fixedletter = \"accent\"\n" +
                        "        elif letter == \"1\" or letter == \"!\":\n" +
                        "            fixedletter = \"num1\"\n" +
                        "        elif letter == \"2\" or letter == \"@\":\n" +
                        "            fixedletter = \"num2\"\n" +
                        "        elif letter == \"3\" or letter == \"#\":\n" +
                        "            fixedletter = \"num3\"\n" +
                        "        elif letter == \"4\" or letter == \"$\":\n" +
                        "            fixedletter = \"num4\"\n" +
                        "        elif letter == \"5\" or letter == \"%\":\n" +
                        "            fixedletter = \"num5\"\n" +
                        "        elif letter == \"6\" or letter == \"^\":\n" +
                        "            fixedletter = \"num6\"\n" +
                        "        elif letter == \"7\" or letter == \"&\":\n" +
                        "            fixedletter = \"num7\"\n" +
                        "        elif letter == \"8\" or letter == \"*\":\n" +
                        "            fixedletter = \"num8\"\n" +
                        "        elif letter == \"9\" or letter == \"(\":\n" +
                        "            fixedletter = \"num9\"\n" +
                        "        elif letter == \"0\" or letter == \")\":\n" +
                        "            fixedletter = \"num0\"\n" +
                        "        elif letter == \"-\" or letter == \"_\":\n" +
                        "            fixedletter = \"dash\"\n" +
                        "        elif letter == \"=\" or letter == \"+\":\n" +
                        "            fixedletter = \"equals\"\n" +
                        "        elif letter in letters:\n" +
                        "            fixedletter = letter.lower()\n" +
                        "        elif letter == \"[\" or letter == \"{\":\n" +
                        "            fixedletter = \"openingsquarebracket\"\n" +
                        "        elif letter == \"]\" or letter == \"}\":\n" +
                        "            fixedletter = \"closingsquarebracket\"\n" +
                        "        elif letter == \"\\\\\" or letter == \"|\":\n" +
                        "            fixedletter == \"backslash\"\n" +
                        "        elif letter == \";\" or letter == \":\":\n" +
                        "            fixedletter = \"semicolon\"\n" +
                        "        elif letter == \"'\" or letter == \"\\\"\":\n" +
                        "            fixedletter = \"quote\"\n" +
                        "        elif letter == \",\" or letter == \"<\":\n" +
                        "            fixedletter = \"comma\"\n" +
                        "        elif letter == \".\" or letter == \">\":\n" +
                        "            fixedletter = \"period\"\n" +
                        "        elif letter == \"/\" or letter == \"?\":\n" +
                        "            fixedletter = \"slash\"\n" +
                        "        elif letter == \"\\n\":\n" +
                        "            fixedletter = \"enter\"\n" +
                        "        keytopress = eval(\"key.\" + str(fixedletter))\n" +
                        "        if shift:\n" +
                        "            hold(key.shift)\n" +
                        "            press(keytopress)\n" +
                        "            release(key.shift)\n" +
                        "        else:\n" +
                        "            press(keytopress)\n" +
                        "\n" +
                        "\n" +
                        "# --- Mouse Variables ---#\n" +
                        "\n" +
                        "class mouse:\n" +
                        "    left = [0x0002, 0x0004]\n" +
                        "    right = [0x0008, 0x00010]\n" +
                        "    middle = [0x00020, 0x00040]\n" +
                        "\n" +
                        "\n" +
                        "# --- Mouse Control Functions ---#\n" +
                        "\n" +
                        "# Moves mouse to a position\n" +
                        "def move(x, y):\n" +
                        "    user32.SetCursorPos(x, y)\n" +
                        "\n" +
                        "\n" +
                        "# Presses and releases mouse\n" +
                        "def click(button):\n" +
                        "    user32.mouse_event(button[0], 0, 0, 0, 0)\n" +
                        "    sleep(delay)\n" +
                        "    user32.mouse_event(button[1], 0, 0, 0, 0)\n" +
                        "    sleep(delay)\n" +
                        "\n" +
                        "\n" +
                        "# Holds a mouse button\n" +
                        "def holdclick(button):\n" +
                        "    user32.mouse_event(button[0], 0, 0, 0, 0)\n" +
                        "    sleep(delay)\n" +
                        "\n" +
                        "\n" +
                        "# Releases a mouse button\n" +
                        "def releaseclick(button):\n" +
                        "    user32.mouse_event(button[1])\n" +
                        "    sleep(delay)");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!Control.exists()) {
            try {
                Control.createNewFile();
                FileWriter myWriter = new FileWriter(Control);
                myWriter.write("from Audio import *\n" +
                        "import sys\n" +
                        "\n" +
                        "toControl = sys.argv[1]\n" +
                        "if(toControl == \"play\"):\n" +
                        "    press(key.playpause)\n" +
                        "else:\n" +
                        "    if(toControl == \"pause\"):\n" +
                        "        press(key.playpause)\n" +
                        "    else:\n" +
                        "        if(toControl == \"vup\"):\n" +
                        "            press(key.volumeup)\n" +
                        "        else:\n" +
                        "            if(toControl == \"vdown\"):\n" +
                        "                press(key.volumedown)\n" +
                        "            else:\n" +
                        "                if(toControl == \"vmute\"):\n" +
                        "                    press(key.volumemute)\n" +
                        "                else:\n" +
                        "                    if(toControl == \"next\"):\n" +
                        "                        press(key.nexttrack)\n" +
                        "                    else:\n" +
                        "                        if(toControl == \"back\"):\n" +
                        "                            press(key.prevoustrack)\n" +
                        "\n" +
                        "\n");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void runThread() {
        run();
    }
    public void stopThread() {
        interrupt();
    }
    public void runServer() {
        isRunning = true;
        runThread();
    }
    public void stopServer() {
        server.stop(0);
        stopThread();
        isRunning = false;
    }
    public void run() {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);
            server.setExecutor(null);
            server.createContext("/", RemoteControl::controlRoot);
            server.createContext("/playpause", RemoteControl::controlPlayPause);
            server.createContext("/vup", RemoteControl::controlVUp);
            server.createContext("/vdown", RemoteControl::controlVDown);
            server.createContext("/vmute", RemoteControl::controlVMute);
            server.createContext("/next", RemoteControl::controlNext);
            server.createContext("/back", RemoteControl::controlBack);
            server.start();
        } catch (IOException e) {
            isRunning = false;
            e.printStackTrace();
        }
    }
}
