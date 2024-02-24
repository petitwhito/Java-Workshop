package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;

public class GenericSet<T extends Comparable<T>> {
    public ArrayList<T> base_ = new ArrayList<>();

    public GenericSet() {
        this.base_ = new ArrayList<T>();
    }
    public void insert(T i)
    {
        base_.add(i);
        Collections.sort(base_);
    }
    public void remove(T i)
    {
        base_.remove(i);
    }
    public boolean has(T i)
    {
        return base_.contains(i);
    }
    public boolean isEmpty()
    {
        return base_.isEmpty();
    }
    public T min()
    {
        T minimum = base_.get(0);
        for (int i = 1; i < base_.size(); i++) {
            if (minimum.compareTo(base_.get(i)) > 0)
                minimum = base_.get(i);
        }
        return minimum;
    }
    public T max()
    {
        T max = base_.get(0);
        for (int i = 1; i < base_.size(); i++) {
            if (max.compareTo(base_.get(i)) < 0)
                max = base_.get(i);
        }
        return max;
    }
    public int size()
    {
        return base_.size();
    }
    public static GenericSet intersection(GenericSet a, GenericSet b)
    {
        GenericSet res = new GenericSet();
        for(int i = 0; i < a.size(); i++)
            if (b.has((Comparable) a.base_.get(i)))
                res.insert((Comparable) a.base_.get(i));

        return res;
    }
    public static GenericSet union(GenericSet a, GenericSet b)
    {
        GenericSet res = new GenericSet();
        for(int i = 0; i < a.size(); i++)
            res.insert((Comparable) a.base_.get(i));
        for(int i = 0; i < b.size(); i++)
            if (!res.has((Comparable) b.base_.get(i)))
                    res.insert((Comparable) b.base_.get(i));
        return res;
    }
}
