package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ProcessTxt {

    public final static String ABILITIES_DICT_LOCATION = "./data/abilities.txt";
    public static final HashMap<String, Ability> ABILITIES_DICTIONARY = new HashMap<>();
    public final static String CHAR_INFO_DICT_LOCATION = "./data/char_info.txt";
    public static final HashMap<String, Char> CHAR_INFO_DICTIONARY = new HashMap<>();
    public final static String COABS_DICT_LOCATION = "./data/coabs.txt";
    public static final HashMap<String, Coab> COABS_DICTIONARY = new HashMap<>();
    public final static String PRINTS_DICT_LOCATION = "./data/prints.txt";
    //public static final HashMap<String, Print> PRINTS_DICTIONARY = new HashMap<>();
    public final static String SKILLS_DICT_LOCATION = "./data/skills.txt";
    public static final HashMap<String, Skill> SKILLS_DICTIONARY = new HashMap<>();
    public final static String WEAPONS_DICT_LOCATION = "./data/weapons.txt";
    //public static final HashMap<String, Weapon> WEAPONS_DICTIONARY = new HashMap<>();

    public static String stringSplit(String toSplit, String delimiter, int location) {
        // NOTE: location of 0 means "take string BEFORE the delimiter", 1 means AFTER. All other positive ints are etc.
        return toSplit.split(delimiter)[location];
    }

    public static void addLineToHashMap(String fileLocation, HashMap dictionary, String string) {
        if (fileLocation.equals(ABILITIES_DICT_LOCATION)) {
            String name, a1, a1R, a2, a2R;
            int a1P,a1RC,a2P,a2RC;
            Scanner parseLine = new Scanner(string).useDelimiter(",");
            try {
                name = parseLine.next();
                a1 = parseLine.next();
                a1P = parseLine.nextInt();
                a1R = parseLine.next();
                a1RC = parseLine.nextInt();
                a2 = parseLine.next();
                a2P = parseLine.nextInt();
                a2R = parseLine.next();
                a2RC = parseLine.nextInt();
                if (dictionary.containsValue(name))
                    throw new RuntimeException("The entry " + string + "already exists in " + fileLocation);
                dictionary.put(name, new Ability(name,a1,a1P,a1R,a1RC,a2,a2P,a2R,a2RC));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + string);
            }
        }
        if (fileLocation.equals(CHAR_INFO_DICT_LOCATION)) {
            String name, elem, wT, s1N, s2N, a1, a2, a3, ct, cc;
            int mt, hp, str, def;
            Scanner parseLine = new Scanner(string).useDelimiter(",");
            try {
                name = parseLine.next();
                elem = parseLine.next();
                wT = parseLine.next();
                s1N = parseLine.next();
                s2N = parseLine.next();
                a1 = parseLine.next();
                a2 = parseLine.next();
                a3 = parseLine.next();
                ct = parseLine.next();
                cc = parseLine.next();
                mt = parseLine.nextInt();
                hp = parseLine.nextInt();
                str = parseLine.nextInt();
                def = parseLine.nextInt();
                if (dictionary.containsValue(name))
                    throw new RuntimeException("The entry " + string + "already exists in " + fileLocation);
                dictionary.put(name, new Char(name,elem,wT,s1N,s2N,a1,a2,a3,ct,cc,mt,hp,str,def));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + string);
            }
        }
        if (fileLocation.equals(COABS_DICT_LOCATION)) {
            String skillName, coabAbil;
            double coabPercentage;
            boolean wholeTeam;

            Scanner parseLine = new Scanner(string).useDelimiter(",");
            try {
                skillName = parseLine.next();
                coabAbil = parseLine.next();
                coabPercentage = parseLine.nextDouble();
                wholeTeam = parseLine.nextBoolean();
                if (dictionary.containsValue(skillName))
                    throw new RuntimeException("The entry " + string + "already exists in " + fileLocation);
                dictionary.put(skillName, new Coab(skillName, coabAbil, coabPercentage, wholeTeam));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + string);
            }
        }
        if (fileLocation.equals(SKILLS_DICT_LOCATION)) {
            String sN, b1N, b2N, b3N;
            int spC, d1P, d1H, d2P, d2H;
            double iFT, b1P, b2P, b3P;
            boolean cM, eA;
            Scanner parseLine = new Scanner(string).useDelimiter(",");
            try {
                sN = parseLine.next();
                spC = parseLine.nextInt();
                iFT = parseLine.nextDouble();
                cM = parseLine.nextBoolean();
                eA = parseLine.nextBoolean();
                d1P = parseLine.nextInt();
                d1H = parseLine.nextInt();
                d2P = parseLine.nextInt();
                d2H = parseLine.nextInt();
                b1N = parseLine.next();
                b1P = parseLine.nextDouble();
                b2N = parseLine.next();
                b2P = parseLine.nextDouble();
                b3N = parseLine.next();
                b3P = parseLine.nextDouble();
                if (dictionary.containsValue(sN))
                    throw new RuntimeException("The entry " + string + "already exists in " + fileLocation);
                dictionary.put(sN, new Skill(sN,spC,iFT,cM,eA,d1P,d1H,d2P,d2H,b1N,b1P,b2N,b2P,b3N,b3P));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + string);
            }
        }
    }

    public static void initDictionary(String fileLocation, HashMap dictionary, String regexMatch) {
        // e.g. fileLocation is ABILITIES_DICT_LOCATION
        //      dictionary is ABILITIES_DICTIONARY
        //      regexMatch is "\\w+(\\s+\\w+)*((,\\w+(-\\d+)?,\\d+){2}){2}"

        File file = new File(fileLocation);
        assert (file.exists());

        try {
            Scanner scanner = new Scanner(file).useDelimiter("\n");
            int numEntries = 0;
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine().trim();
                if (string.startsWith("//")) continue;
                numEntries++;
                System.out.print("Processing entry number " + numEntries + "\r");
                System.out.flush();
                if (!string.matches(regexMatch)) {
                    throw new RuntimeException("Invalid string: " + string);
                }
                addLineToHashMap(fileLocation,dictionary,string);
            }
            scanner.close();
            System.out.println("Successfully added " + numEntries + " dictionary entries to '" + fileLocation + "'!");
        } catch (FileNotFoundException e) {
            // do nothing
        }
    }
}
