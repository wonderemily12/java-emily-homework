package codewings.emily.hw5;

import java.util.*;

import java.util.Iterator;

public class IntArrayList implements Iterable<Integer> {
    private int[] array;

    public IntArrayList() {

    }

    public int size() {
        return 0;
    }

    public int get(int i) {
        return 0;
    }

    public void add(int x) {

    }

    public void remove(int x) {

    }

    public void clear() {

    }

    public boolean contains(int x) {
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof List) {
            List otherList = (List) other;
            if (this.size() != otherList.size()) return false;
            for (int i = 0; i < this.size(); i++) {
                if (!Objects.equals(this.get(i), otherList.get(i))) return false;
            }
            return true;
        } else if (other instanceof IntArrayList) {
            IntArrayList otherList = (IntArrayList) other;
            if (this.size() != otherList.size()) return false;
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i) != otherList.get(i)) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(array);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i <= size() - 1;
            }

            @Override
            public Integer next() {
                return get(i++);
            }
        };
    }
}

