package util;
import util.Ability;

public class Char {

    String name;
    String elem;
    String wT;
    String s1N;
    String s2N;
    String a1;
    String a2;
    String a3;
    String ct;
    String cc;

    public Char(String name, String elem, String wT, String s1N, String s2N, String a1, String a2, String a3, String cc, String ct) {
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

        System.out.println("This is " + name + ", a " + elem + " attuned " + wT + " adventurer with the abilities " + a1 + ", " + a2 + ", and " + a3 + ", as well as the coab " + cc + " and the chain coab " + ct + ".");
    }

    public void printAbilities(Ability ability) {
        System.out.println(name + "'s skill(s) is " + ability.toString());
    }
}
