from Audio import *
import sys

toControl = sys.argv[1]
if(toControl == "play"):
    press(key.playpause)
else:
    if(toControl == "pause"):
        press(key.playpause)
    else:
        if(toControl == "vup"):
            press(key.volumeup)
        else:
            if(toControl == "vdown"):
                press(key.volumedown)
            else:
                if(toControl == "vmute"):
                    press(key.volumemute)
                else:
                    if(toControl == "next"):
                        press(key.nexttrack)
                    else:
                        if(toControl == "back"):
                            press(key.prevoustrack)


