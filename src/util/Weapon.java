package util;

public class Weapon {
    String wN, elem, wT;
    int mtE, mtOE, hp, str;
    String aN;

    public Weapon(String wN, String elem, String wT, int mtE, int mtOE, int hp, int str, String aN) {
        this.wN = wN;
        this.elem = elem;
        this.wT = wT;
        this.mtE = mtE;
        this.mtOE = mtOE;
        this.hp = hp;
        this.str = str;
        this.aN = aN;
    }
}
