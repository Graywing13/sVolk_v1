package test;
import util.Effect;
import util.ProcessTxt;

import java.util.ArrayList;

public class TestMain {

    public TestMain() {
        System.out.println("Test started.");
    }

    public void gameRun(){
        System.out.println("gameRun called.");
        ProcessTxt.initDictionary();


        Char eze = new Char("Ezelith");
        ArrayList<Effect> ezeEffs = new ArrayList<Effect>();
        Effect e1 = new Effect("Flash of Genius","debuff",20,"combo",15,"crit-7",20,"s1-connects",2);
        Effect e2 = new Effect("Potent Sleep Res","sleepRes",100,"sleepHit",1,"strength-10",15,"sleepHit-15",1);
        Effect e3 = new Effect("Broken Punisher","damage",35,"eBreak",0,"none",0,"none",0);
        ezeEffs.add(e1);
        ezeEffs.add(e2);
        ezeEffs.add(e3);
        for (Effect effect : ezeEffs) {
            eze.getEffects(effect);
        }
        eze.s1();

    }

    public static void main(String[] args) {
        TestMain t = new TestMain();
        t.gameRun();
    }
}
