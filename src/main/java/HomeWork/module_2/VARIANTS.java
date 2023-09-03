package HomeWork.module_2;

import java.util.Random;

public enum VARIANTS {
    STONE, SCISSORS, PAPER;

    private static final Random RANDOM = new Random();

    public static VARIANTS randomVariants() {
        VARIANTS[] variants = values();
        return
                variants[RANDOM.nextInt(variants.length)];
    }
}
