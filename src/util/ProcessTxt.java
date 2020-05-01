package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ProcessTxt {

    public final static String ABILITIES_DICT_LOCATION = "./data/abilities.txt";
    private static final HashMap<String, Effect> DICTIONARY = new HashMap<>();

    public static String stringSplit(String toSplit, String delimiter, int location) {
        // NOTE: location of 0 means "take string BEFORE the delimiter", 1 means AFTER. All other positive ints are etc.
        return toSplit.split(delimiter)[location];
    }

    // MODIFIES: this
    // EFFECTS: initializes the dictionary.
    public static void initDictionary() {
        File file = new File(ABILITIES_DICT_LOCATION);
        assert (file.exists());
        try {
            Scanner scanner = new Scanner(file).useDelimiter("\n");
            int numEntries = 0;
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine().trim();
                if (string.startsWith("//")) continue;
                numEntries++;
                System.out.print("Processing entry number " + numEntries + "\r \n String: " + string);
                System.out.flush();
                if (!string.matches("\\w+(\\s+\\w+)*((,\\w+(-\\d+)?,\\d+){2}){2}")) {
                    throw new RuntimeException("Invalid string: " + string);
                }
                String name, e1, e1R, e2, e2R;
                int e1P,e1RC,e2P,e2RC;
                Scanner parseLine = new Scanner(string).useDelimiter(",");
                try {
                    name = parseLine.next();
                    e1 = parseLine.next();
                    e1P = parseLine.nextInt();
                    e1R = parseLine.next();
                    e1RC = parseLine.nextInt();
                    e2 = parseLine.next();
                    e2P = parseLine.nextInt();
                    e2R = parseLine.next();
                    e2RC = parseLine.nextInt();
                    if (DICTIONARY.containsValue(name))
                        throw new RuntimeException("This entry has a duplication: " + string);
                    DICTIONARY.put(name, new Effect(name,e1,e1P,e1R,e1RC,e2,e2P,e2R,e2RC));
                    parseLine.close();
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid string: " + string);
                }
            }
            scanner.close();
            System.out.println("Successfully added " + numEntries + " dictionary entries!");
        } catch (FileNotFoundException e) {
            // do nothing
        }
    }
}
