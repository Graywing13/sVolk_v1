package util;

import java.util.ArrayList;

public class Char {

    String name, elem, wT, s1N, s2N, a1, a2, a3, ct, cc;
    int mt, hp, str, def;

    // The Defaults ====================================================================================================
    public Char(String name, String elem, String wT, String s1N, String s2N, String a1, String a2, String a3, String cc, String ct, int mt, int hp, int str, int def) {
        this.name = name;
        this.elem = elem;
        this.wT = wT;
        this.s1N = s1N;
        this.s2N = s2N;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.cc = cc;
        this.ct = ct;
        this.mt = mt;
        this.hp = hp;
        this.str = str;
        this.def = def;

    }

    public String toString() {
        return "This is " + name + ", a " + elem + " attuned " + wT + " adventurer \n\twith the abilities " + a1 + ", " + a2 + ", and " + a3 + ", \n\tas well as the coab " + cc + " and the chain coab " + ct + ". \n\tThey currently have [might " + mt + "], [hp " + hp + "], [str " + str + "], and [def " + def +"].";
    }

    // Initialization functions ========================================================================================
    public static Char initChar(String charName) {
        Char c = ProcessTxt.CHAR_INFO_DICTIONARY.get(charName);
        ArrayList<Ability> cAbils = new ArrayList<>();
        Ability a1 = ProcessTxt.ABILITIES_DICTIONARY.get(c.getA1());
        Ability a2 = ProcessTxt.ABILITIES_DICTIONARY.get(c.getA2());
        Ability a3 = ProcessTxt.ABILITIES_DICTIONARY.get(c.getA3());
        cAbils.add(a1);
        cAbils.add(a2);
        cAbils.add(a3);
        for (Ability ability : cAbils) {
            c.printAbilities(ability);
        }

        return c;
    }

    // Get variable values =============================================================================================
    public String getA1() {
        return this.a1;
    }
    public String getA2() {
        return this.a2;
    }
    public String getA3() {
        return this.a3;
    }
    public String getCC() {
        return this.cc;
    }
    public String getCT() {
        return this.ct;
    }

    // Other helper functions ==========================================================================================
    public void printAbilities(Ability ability) {
        System.out.println(name + "'s ability is " + ability.toString());
    }

}
