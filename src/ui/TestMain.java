package ui;
import util.Ability;
import util.Char;
import util.ProcessTxt;

import java.util.ArrayList;

public class TestMain {

    public TestMain() {
        System.out.println("Test started.");
    }

    public void gameInit(){
        System.out.println("gameInit called.");
        ProcessTxt.initDictionary(ProcessTxt.ABILITIES_DICT_LOCATION,ProcessTxt.ABILITIES_DICTIONARY,"\\w+(\\s+\\w+)*((,\\w+(-\\d+)?,\\d+){2}){2}");
        ProcessTxt.initDictionary(ProcessTxt.CHAR_INFO_DICT_LOCATION,ProcessTxt.CHAR_INFO_DICTIONARY,"\\w+(\\s\\w+)*,\\w+,\\w+(,\\w+(\\s\\w+)*){7}(,\\d+){4}");
        Char.initChar("Ezelith");
    }

    public static void main(String[] args) {
        TestMain t = new TestMain();
        t.gameInit();
    }
}
