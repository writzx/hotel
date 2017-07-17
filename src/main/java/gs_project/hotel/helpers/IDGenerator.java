package gs_project.hotel.helpers;

import java.util.Random;

public final class IDGenerator {
    private static Random random = new Random();

    private IDGenerator() {
    }

    public static String generate() {
        char[] chars = "43VRHQZLYTK17WU2506GOFECDIJ8MXBNAPS9".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}