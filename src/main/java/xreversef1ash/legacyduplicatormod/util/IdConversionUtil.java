package xreversef1ash.legacyduplicatormod.util;

import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class IdConversionUtil {

    public static ArrayList<Identifier> convertStringsToIds(ArrayList<String> strings) {
        ArrayList<Identifier> identifiers = new ArrayList<>();
        for (String string : strings) {
            Identifier id = Identifier.tryParse(string);
            if (id != null) {
                identifiers.add(id);
            }
        }
        return identifiers;
    }
}
