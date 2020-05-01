package characters;
import test.Effect;

public class Char {

    String name;

    public Char(String cName) {
        name = cName;
        System.out.println("This is " + name);
    }

    public void s1() {
        System.out.println("s1 used by " + name);
    }

    public void getEffects(Effect effect) {
        System.out.println(name + "'s skill(s) is " + effect.toString());
    }
}
