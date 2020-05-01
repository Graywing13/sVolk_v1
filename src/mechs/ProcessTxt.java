package mechs;

import test.Effect;

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
    private void initDictionary() {
        File file = new File(ABILITIES_DICT_LOCATION);
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
                if (!string.matches("\\w+,\\w+-?\\d+?,\\d+,\\w+-?\\d+?,\\d+,\\w+-?\\d?,\\d+,\\w+-?\\d+?,\\d+")) {
                    throw new RuntimeException("Invalid string: " + string);
                }
                String name, e1, e1R, e2, e2R;
                int e1P,e1RC,e2P,e2RC;
                Scanner parseLine = new Scanner(string).useDelimiter(",");
                try {
                    name = parseLine.next();
                    ////////////////////// iGNORE THE REST OF THIS
                    /*
                    r = parseLine.nextInt();
                    g = parseLine.nextInt();
                    b = parseLine.nextInt();
                    x = parseLine.nextInt();
                    y = parseLine.nextInt();
                    r2 = parseLine.nextInt();
                    g2 = parseLine.nextInt();
                    b2 = parseLine.nextInt();
                    x2 = parseLine.nextInt();
                    y2 = parseLine.nextInt();
                    else if (DICTIONARY.containsValue(n))
                        throw new RuntimeException("Cannot have pokemon of duplicate names: " + string);
                    DICTIONARY.put(new ColorPixelPair(color1, color2, pos1, pos2), n);
                    */
                    parseLine.close();
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Invalid number(s) in string: " + string);
                }
            }
            scanner.close();
            System.out.println("Successfully added " + numEntries + " dictionary entries!");
        } catch (FileNotFoundException e) {
            // do nothing
        }
    }
}
