package themPark;

import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor a, Visitor b) {
        int result = a.getLastName().compareToIgnoreCase(b.getLastName());
        if (result != 0) return result;
        return Integer.compare(a.getAge(), b.getAge());
    }
}
