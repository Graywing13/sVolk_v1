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
        Team t = new Team("Ezelith", "Xania","Ezelith","Ezelith");

    }

    public static void main(String[] args) {
        Main t = new Main();
        t.gameInit();
    }
}
