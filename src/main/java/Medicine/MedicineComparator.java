package Medicine;

import java.util.Comparator;

/**
 * Class that implements Comparator interface for comparing Medicine's objects.
 */
public class MedicineComparator implements Comparator<Medicine> {

    @Override
    public int compare(Medicine a, Medicine b) {
        return a.compareTo(b);
    }
}
