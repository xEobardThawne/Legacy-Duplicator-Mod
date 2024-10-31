package xreversef1ash.legacyduplicatormod.util;

public class ItemDuplicatorLevel {

    public static int getDuplicationSizeFromLevel(int level) {
        return switch (level) {
            case 1 -> 4;
            case 2 -> 16;
            case 3 -> 32;
            case 4 -> 64;
            default -> 1;
        };
    }
}
