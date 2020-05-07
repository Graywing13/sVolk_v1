package ui;

import util.ProcessTxt;
import util.Team;

public class Main {

    public Main() {
        System.out.println("sVolk_v1 started.");
    }

    public void gameInit() {
        System.out.println("♥ ♥ ♥ Setting Up Dictionaries ♥ ♥ ♥");
        ProcessTxt.initDictionary(ProcessTxt.ABILITIES_DICT_LOCATION, ProcessTxt.ABILITIES_DICTIONARY, "\\w+(\\s-)?(\\s+\\w+)*((,\\w+(-\\d+)?,\\d+){2}){2}");
        ProcessTxt.initDictionary(ProcessTxt.CHAR_INFO_DICT_LOCATION, ProcessTxt.CHAR_INFO_DICTIONARY, "\\w+(\\s\\w+)*,\\w+,\\w+(,\\w+(\\s-)?(\\s\\w+)*){7}(,\\d+){4},\\w+(\\s\\w+)*");
        ProcessTxt.initDictionary(ProcessTxt.COABS_DICT_LOCATION, ProcessTxt.COABS_DICTIONARY, "\\w+(\\s-)?(\\s\\w+)*,\\w+(-\\d+(\\.\\d+)?)*,\\d+(\\.\\d+)?,(true|false)");
        ProcessTxt.initDictionary(ProcessTxt.SKILLS_DICT_LOCATION, ProcessTxt.SKILLS_DICTIONARY, "\\w+(\\s\\w+)*,\\d+,\\d+(\\.\\d+)?(,(true|false)){2}(,\\d+){4}(,\\w+(-\\d+(\\.\\d+)?)*,\\d+(\\.\\d+)?){3}");
        ProcessTxt.initDictionary(ProcessTxt.WEAPONS_DICT_LOCATION, ProcessTxt.WEAPONS_DICTIONARY, "\\w+(\\s\\w+)*(,\\w+){2}(,\\d+){4},\\w+(\\s-)?(\\s\\w+)*");
        System.out.println("\n♥ ♥ ♥ Team Initiating ♥ ♥ ♥");
        Team t = new Team("Ezelith", "Xania", "Ezelith", "Xania");
    }

    public static void main(String[] args) {
        Main t = new Main();
        t.gameInit();
    }
}
