package Builders;

import Medicine.Medicine;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class with Factory pattern that creates set of some objects from XML file.
 */
public abstract class AbstractMedicinesBuilder {
    protected Set<Medicine> medicines;
    public AbstractMedicinesBuilder() {
        medicines = new HashSet<Medicine>();
    }
    public AbstractMedicinesBuilder(Set<Medicine> medicines) {
        this.medicines = medicines;
    }
    public Set<Medicine> getMedicines() {
        return medicines;
    }
    public abstract void buildSetMedicines(String filename);
}
