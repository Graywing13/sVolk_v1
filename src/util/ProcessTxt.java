package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ProcessTxt {

    // General Constants
    public final static List<String> ELEMENTS = Arrays.asList("Flame", "Light", "None", "Shadow", "Water", "Wind");
    public final static List<String> WEAPON_TYPES = Arrays.asList("Axe", "Blade", "Bow", "Dagger", "Lance", "Staff", "Sword", "Wand");

    // Dictionary Constants
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
    public static final HashMap<String, Weapon> WEAPONS_DICTIONARY = new HashMap<>();

    // Dictionary Creation (Main)
    public static void initDictionary(String fileLocation, HashMap dictionary, String regexMatch) {
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
                addLineToHashMap(fileLocation, dictionary, string);
            }
            scanner.close();
            System.out.println("Successfully added " + numEntries + " dictionary entries to '" + fileLocation + "'!");
        } catch (FileNotFoundException e) {
            // do nothing
        }
    }

    // Dictionary Creation helper functions (major and specific)
    public static void addLineToHashMap(String fileLocation, HashMap dictionary, String entry) {
        if (fileLocation.equals(ABILITIES_DICT_LOCATION)) {
            String name, a1, a1R, a2, a2R;
            int a1P, a1RC, a2P, a2RC;
            Scanner parseLine = new Scanner(entry).useDelimiter(",");
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
                validEntry(dictionary, name, entry, fileLocation);
                dictionary.put(name, new Ability(name, a1, a1P, a1R, a1RC, a2, a2P, a2R, a2RC));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + entry);
            }
        }
        if (fileLocation.equals(CHAR_INFO_DICT_LOCATION)) {
            // String name, elem, wT, s1N, s2N, a1, a2, a3, ct, cc;
            int mt, hp, str, def;
            // Weapon w;
            Scanner parseLine = new Scanner(entry).useDelimiter(",");
            try {
                String[] strings = new String[10];
                for (int i = 0; i < 10; i++) {
                    strings[i] = parseLine.next();
                }
                mt = parseLine.nextInt();
                hp = parseLine.nextInt();
                str = parseLine.nextInt();
                def = parseLine.nextInt();
                validElem(strings[1]);
                validWeaponType(strings[2]);
                validEntry(dictionary, strings[0], entry, fileLocation);
                dictionary.put(strings[0], new Char(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], strings[7], strings[8], strings[9], mt, hp, str, def, null));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + entry);
            }
        }
        if (fileLocation.equals(COABS_DICT_LOCATION)) {
            String skillName, coabAbil;
            double coabPercentage;
            boolean wholeTeam;

            Scanner parseLine = new Scanner(entry).useDelimiter(",");
            try {
                skillName = parseLine.next();
                coabAbil = parseLine.next();
                coabPercentage = parseLine.nextDouble();
                wholeTeam = parseLine.nextBoolean();
                validEntry(dictionary, skillName, entry, fileLocation);
                dictionary.put(skillName, new Coab(skillName, coabAbil, coabPercentage, wholeTeam));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + entry);
            }
        }
        if (fileLocation.equals(WEAPONS_DICT_LOCATION)) {
            String wN, elem, wT;
            int mtE, mtOE, hp, str;
            String aN;

            Scanner parseLine = new Scanner(entry).useDelimiter(",");
            try {
                wN = parseLine.next();
                elem = parseLine.next();
                wT = parseLine.next();
                mtE = parseLine.nextInt();
                mtOE = parseLine.nextInt();
                hp = parseLine.nextInt();
                str = parseLine.nextInt();
                aN = parseLine.next();

                validWeaponType(wT);
                validElem(elem);
                validEntry(dictionary, wN, entry, fileLocation);

                dictionary.put(wN, new Weapon(wN, elem, wT, mtE, mtOE, hp, str, aN));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + entry);
            }
        }
        if (fileLocation.equals(SKILLS_DICT_LOCATION)) {
            String sN, b1N, b2N, b3N;
            int spC, d1P, d1H, d2P, d2H;
            double iFT, b1P, b2P, b3P;
            boolean cM, eA;
            Scanner parseLine = new Scanner(entry).useDelimiter(",");
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

                validEntry(dictionary, sN, entry, fileLocation);
                dictionary.put(sN, new Skill(sN, spC, iFT, cM, eA, d1P, d1H, d2P, d2H, b1N, b1P, b2N, b2P, b3N, b3P));
                parseLine.close();
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid string: " + entry);
            }
        }
    }

    // Small Helper Functions
    public static String stringSplit(String toSplit, String delimiter, int location) {
        // NOTE: location of 0 means "take string BEFORE the delimiter", 1 means AFTER. All other positive ints are etc.
        return toSplit.split(delimiter)[location];
    }

    private static void validElem(String elem) {
        if (!ELEMENTS.contains(elem)) throw new RuntimeException("The element " + elem + " is invalid.");
    }

    private static void validWeaponType(String wT) {
        if (!WEAPON_TYPES.contains(wT)) throw new RuntimeException("The weapon type " + wT + " is invalid.");
    }

    private static void validEntry(HashMap dictionary, String key, String entry, String fileLocation) {
        if (dictionary.containsKey(key))
            throw new RuntimeException("The entry " + entry + " already exists in " + fileLocation);
    }

}
