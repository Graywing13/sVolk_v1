// This file applies the character abilities to the characters/enemies.
// See abilities.txt for clarifications.
// NOTE: By effect I mean ability.

package test;

import mechs.ProcessTxt;

public class Effect {
    String name;
    String eff1;
    int eff1Perc;
    String eff1Req;
    int eff1ReqCount;
    String eff2;
    int eff2Perc;
    String eff2Req;
    int eff2ReqCount;

    public Effect(String n, String e1, int e1P, String e1R, int e1RC,  String e2, int e2P, String e2R, int e2RC) {
        this.name = n;
        this.eff1 = e1;
        this.eff1Perc = e1P;
        this.eff1Req = e1R;
        this.eff1ReqCount = e1RC;
        this.eff2 = e2;
        this.eff2Perc = e2P;
        this.eff2Req = e2R;
        this.eff2ReqCount = e2RC;
    }

    public String toString() {
        String returnString = name + ", which makes ";

        // write string for effect 1
        if (eff1.contains("-")) {
            returnString += ProcessTxt.stringSplit(eff1, "-", 0) + " happen for " + ProcessTxt.stringSplit(eff1, "-", 1) + " seconds at " + eff1Perc + "% when " + eff1Req + " happens " + eff1ReqCount + " time(s).";
        } else {
            returnString += eff1 + " happen at " + eff1Perc + "%" + " when " + eff1Req + " occurs " + eff1ReqCount + " times.";
        }

        // see if there's a second effect
        if (eff2.equals("none")) {
            return returnString;
        } else {
            returnString += " It also makes ";

            // if there is a second effect, write string for effect 2
            if (eff2.contains("-")) {
                returnString += ProcessTxt.stringSplit(eff2, "-", 0) + " happen for " + ProcessTxt.stringSplit(eff2, "-", 1) + " seconds at " + eff2Perc + "% when " + eff2Req + " happens " + eff2ReqCount + " time(s).";
            } else {
                returnString += eff2 + " happen at " + eff2Perc + "%" + " when " + eff2Req + " occurs " + eff2ReqCount + " times.";
            }
        }

        return returnString;
    }
}
