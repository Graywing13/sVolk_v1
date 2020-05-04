package util;

import java.util.ArrayList;

public class Team {
    
    Char c1, c2, c3, c4;
    
    public Team(String c1Name, String c2Name, String c3Name, String c4Name) {
        System.out.println("Initializing P1 as " + c1Name);
        this.c1 = Char.initChar(c1Name);
        System.out.println("Initializing P2 as " + c2Name);
        this.c2 = Char.initChar(c2Name);
        System.out.println("Initializing P3 as " + c3Name);
        this.c3 = Char.initChar(c3Name);
        System.out.println("Initializing P4 as " + c4Name);
        this.c4 = Char.initChar(c4Name);
        Char[] players = {c1, c2, c3, c4};
        
        ArrayList<Coab> coabs = new ArrayList<>();
        for (Char c : players) {
            Coab cc = ProcessTxt.COABS_DICTIONARY.get(c.getCC());
            Coab ct = ProcessTxt.COABS_DICTIONARY.get(c.getCT());
            if (!coabs.contains(cc)) {
                coabs.add(cc);
            }
            if (!coabs.contains(ct)) {
                coabs.add(ct);
            }
        }

        System.out.println("This team's coabs:");
        for (Coab coab : coabs) {
            System.out.println(coab);
        }
    }
    
}
