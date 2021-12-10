package Builders;

/**
 * Class that is a factory for builders.
 */
public class MedicineBuilderFactory {
    /**
     * Our possible types of parsers.
     */
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private MedicineBuilderFactory() {
    }

    public static AbstractMedicinesBuilder createMedicineBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new MedicinesDomBuilder();
            }
            case STAX -> {
                return new MedicinesStaxBuilder();
            }
            case SAX -> {
                return new MedicinesSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
