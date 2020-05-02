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
        ProcessTxt.initDictionary(ProcessTxt.CHAR_INFO_DICT_LOCATION,ProcessTxt.CHAR_INFO_DICTIONARY,"\\w+(\\s\\w+)*,\\w+,\\w+(,\\w+(\\s\\w+)*){7}");
        Char eze = ProcessTxt.CHAR_INFO_DICTIONARY.get("Ezelith");
        ArrayList<Ability> ezeAbils = new ArrayList<>();
        Ability e1 = ProcessTxt.ABILITIES_DICTIONARY.get("Flash of Genius");
        Ability e2 = ProcessTxt.ABILITIES_DICTIONARY.get("Potent Sleep Res 100");
        Ability e3 = ProcessTxt.ABILITIES_DICTIONARY.get("Broken Punisher 35");
        ezeAbils.add(e1);
        ezeAbils.add(e2);
        ezeAbils.add(e3);
        for (Ability Ability : ezeAbils) {
            eze.printAbilities(Ability);
        }

    }

    public static void main(String[] args) {
        TestMain t = new TestMain();
        t.gameInit();
    }
}
