
// HashTable.java
// James Feng
// Utility data structure that uses hashcodes to store values with constant lookup time without indexes.

import java.util.*;
 
class HashTable<T> {
    private ArrayList<LinkedList<T>> table;
    private int size;
    private double max_load = 0.7;
 
    public HashTable() {
        fill(10);
    }
 
    public void add(T val) { // add value
        int pos = getInd(val);
 
        // if the spot it should be at is null, make a new LinkedList at that spot
        if (table.get(pos) == null) table.set(pos, new LinkedList<T>());

        LinkedList<T> lst = table.get(pos);

        lst.add(val);
        ++size;
 
        // keep the load below max load
        if (getLoad() > max_load) resize();
    }

    public void remove(T val) { // remove value
        LinkedList<T> lst = table.get(getInd(val));
        if (lst == null) return;

        // we use an iterator here to avoid concurrent modification exception, or any issues with removing
        Iterator<T> iterator = lst.iterator();
        while (iterator.hasNext()) {
            T cur = iterator.next();
            if (cur.equals(val)) { // use .equals so that the user can use their own compare method
                iterator.remove();
                --size;
                return;
            }
        }
    }

    public LinkedList<T> get(T val) { // get all matches of value stored in table
        LinkedList<T> matches = new LinkedList<T>(); // there may be multiple matches, so return all of them in a LinkedList

        LinkedList<T> lst = table.get(getInd(val));
        if (lst == null) return matches;

        int id = val.hashCode();

        for (T cur : lst) {
            if (cur.equals(val)) { // use .equals so that the user can use their own compare method
                matches.add(cur);
            }
        }

        return matches;
    }
 
    public boolean contains(T val) { // check if at least one match of value is stored in table
        LinkedList<T> lst = table.get(getInd(val));
        if (lst == null) return false;
        for (T cur : lst) {
            if (cur.equals(val)) {
                return true;
            }
        }
        return false;
    }
 
    public void resize() { resize(table.size() * 10); }
    public void resize(int new_size) { // make the internal arraylist this class uses a new size to change the load
        ArrayList<LinkedList<T>> old = table;
        fill(new_size);
 
        // transfer all the items over
        for (LinkedList<T> lst : old) {
            if (lst != null) {
                for (T val : lst) {
                    // adding the value, this is the same code as in add but without the resize
                    int pos = getInd(val);
                    if (table.get(pos) == null) table.set(pos, new LinkedList<T>());
                    LinkedList<T> spot = table.get(pos);
                    spot.add(val);
                    ++size;
                }
            }
        }
    }
    private void fill(int n) { // fill with null of size n
        table = new ArrayList<LinkedList<T>>();
        size = 0;
        for (int i = 0; i < n; ++i) {
            table.add(null);
        }
    }
 
    public void setMaxLoad(double percent) { // set new max load
        max_load = percent;
        // if load is now too big, resize it
        if (getLoad() > max_load) resize();
    }

    public double getLoad() { return (double)size / table.size(); }

    public void setLoad(double percent) {
        if (percent > max_load) return;
        int new_size = (int)((double)size / percent + 0.5);
        resize(new_size);
    }
 
    private int getInd(T val) { return Math.abs(val.hashCode() % table.size()); }
 
    // add all items into an array by iterating over the entire table
    public ArrayList<T> toArray() {
        ArrayList<T> ret = new ArrayList<T>();
        for (LinkedList<T> lst : table) {
            if (lst == null) continue;
            for (T val : lst) {
                ret.add(val);
            }
        }
        return ret;
    }

    // convert to string
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
 
        for (LinkedList<T> lst : table) {
            if (lst != null) {
                ret.append("*");
                for (T val : lst) {
                    ret.append(val + ", ");
                }
            }
        }
 
        if (size > 0) {
            ret.delete(ret.length()-2, ret.length());
        }
 
        return "[ " + ret + " ]";
    }
}