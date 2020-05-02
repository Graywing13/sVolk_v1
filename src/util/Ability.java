// This file applies the character abilities to the characters/enemies.
// See abilities.txt for clarifications.

package util;

public class Ability {
    String name;
    String abil1;
    int abil1Perc;
    String abil1Req;
    int abil1ReqCount;
    String abil2;
    int abil2Perc;
    String abil2Req;
    int abil2ReqCount;

    public Ability(String n, String a1, int a1P, String a1R, int a1RC,  String a2, int a2P, String a2R, int a2RC) {
        this.name = n;
        this.abil1 = a1;
        this.abil1Perc = a1P;
        this.abil1Req = a1R;
        this.abil1ReqCount = a1RC;
        this.abil2 = a2;
        this.abil2Perc = a2P;
        this.abil2Req = a2R;
        this.abil2ReqCount = a2RC;
    }

    public String toString() {
        String returnString = name + ", which makes ";

        // write string for Ability 1
        if (abil1.contains("-")) {
            returnString += ProcessTxt.stringSplit(abil1, "-", 0) + " happen for " + ProcessTxt.stringSplit(abil1, "-", 1) + " seconds at " + abil1Perc + "% when " + abil1Req + " happens " + abil1ReqCount + " time(s).";
        } else {
            returnString += abil1 + " happen at " + abil1Perc + "%" + " when " + abil1Req + " occurs " + abil1ReqCount + " times.";
        }

        // see if there's a second Ability
        if (abil2.equals("none")) {
            return returnString;
        } else {
            returnString += " It also makes ";

            // if there is a second Ability, write string for Ability 2
            if (abil2.contains("-")) {
                returnString += ProcessTxt.stringSplit(abil2, "-", 0) + " happen for " + ProcessTxt.stringSplit(abil2, "-", 1) + " seconds at " + abil2Perc + "% when " + abil2Req + " happens " + abil2ReqCount + " time(s).";
            } else {
                returnString += abil2 + " happen at " + abil2Perc + "%" + " when " + abil2Req + " occurs " + abil2ReqCount + " times.";
            }
        }

        return returnString;
    }
}
