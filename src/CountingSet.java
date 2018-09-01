import java.util.Collection;
import java.util.HashSet;

// Here inheritance is not a preferred way to achieve this functionality
 public class CountingSet extends HashSet<Long> {
    private long addedCount;

    @Override
    public boolean add(Long aLong) {
        addedCount++;
        return super.add(aLong);
    }

   /* @Override
    public boolean addAll(Collection<? extends Long> c) {
        // Below will cause issue because if you look at HashSet implementation of addAll() then you will notice
        // that addAll() iterates over all elements and call add() method for each element. Hence count will be twice
        //Work around would be increase the count only in add() method but thats also problematic because you do not own HasSet
        addedCount = addedCount + c.size();
        return super.addAll(c);
    }*/

    @Override
    public boolean addAll(Collection<? extends Long> c) {
       // Issue solved
        return super.addAll(c);
    }

    public long getAddedCount() {
        return addedCount;
    }
}
