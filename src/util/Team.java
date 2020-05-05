package util;

import java.util.ArrayList;

public class Team {
    
    Char c1, c2, c3, c4;
    
    public Team(String c1Name, String c2Name, String c3Name, String c4Name) {
        initTeamMembers(c1Name, c2Name, c3Name, c4Name);

        Char[] players = {c1, c2, c3, c4};
        
        initCoabs(players);
    }

    private void initCoabs(Char[] players) {
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

        System.out.println("\n♦ ♦ ♦ This team's coabs:");
        for (Coab coab : coabs) {
            System.out.println(coab);
        }
    }

    private void initTeamMembers(String c1Name, String c2Name, String c3Name, String c4Name) {
        System.out.println("\n♦ ♦ ♦ Initializing P1 as " + c1Name);
        this.c1 = ProcessTxt.CHAR_INFO_DICTIONARY.get(c1Name);
        c1.initChar(c1);
        System.out.println("\n♦ ♦ ♦ Initializing P2 as " + c2Name);
        this.c2 = ProcessTxt.CHAR_INFO_DICTIONARY.get(c2Name);
        c2.initChar(c2);
        System.out.println("\n♦ ♦ ♦ Initializing P3 as " + c3Name);
        this.c3 = ProcessTxt.CHAR_INFO_DICTIONARY.get(c3Name);
        c3.initChar(c3);
        System.out.println("\n♦ ♦ ♦ Initializing P4 as " + c4Name);
        this.c4 = ProcessTxt.CHAR_INFO_DICTIONARY.get(c4Name);
        c4.initChar(c4);
    }

}
