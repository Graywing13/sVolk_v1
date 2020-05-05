package ui;
import util.ProcessTxt;
import util.Team;

import java.util.ArrayList;

public class Main {

    public Main() {
        System.out.println("sVolk_v1 started.");
    }

    public void gameInit(){
        System.out.println("♥ ♥ ♥ gameInit ♥ ♥ ♥");
        ProcessTxt.initDictionary(ProcessTxt.ABILITIES_DICT_LOCATION,ProcessTxt.ABILITIES_DICTIONARY,"\\w+(\\s+\\w+)*((,\\w+(-\\d+)?,\\d+){2}){2}");
        ProcessTxt.initDictionary(ProcessTxt.CHAR_INFO_DICT_LOCATION,ProcessTxt.CHAR_INFO_DICTIONARY,"\\w+(\\s\\w+)*,\\w+,\\w+(,\\w+(\\s-)?(\\s\\w+)*){7}(,\\d+){4}");
        ProcessTxt.initDictionary(ProcessTxt.COABS_DICT_LOCATION,ProcessTxt.COABS_DICTIONARY,"\\w+(\\s-)?(\\s\\w+)*,\\w+(-\\d+(\\.\\d+)?)*,\\d+(\\.\\d+)?,(true|false)");
        ProcessTxt.initDictionary(ProcessTxt.SKILLS_DICT_LOCATION,ProcessTxt.SKILLS_DICTIONARY,"\\w+(\\s\\w+)*,\\d+,\\d+(\\.\\d+)?(,(true|false)){2}(,\\d+){4}(,\\w+(-\\d+(\\.\\d+)?)*,\\d+(\\.\\d+)?){3}");
        System.out.println("♥ ♥ ♥ Team Initiating ♥ ♥ ♥");
        Team t = new Team("Xania", "Ezelith","Xania","Ezelith");

    }

    public static void main(String[] args) {
        Main t = new Main();
        t.gameInit();
    }
}
