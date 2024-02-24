package fr.epita.assistants.myset;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    public ArrayList<Integer> base_ = new ArrayList<>();

    public IntegerSet() {
        this.base_ = new ArrayList<>();
    }

    public void insert(Integer i)
    {
        base_.add(i);
        Collections.sort(base_);
    }
    public void remove(Integer i)
    {
        base_.remove(i);
    }
    public boolean has(Integer i)
    {
        return base_.contains(i);
    }
    public boolean isEmpty()
    {
        return base_.isEmpty();
    }
    public Integer min()
    {
        int minimum = base_.get(0);
        for (int i = 1; i < base_.size(); i++) {
            if (minimum > base_.get(i))
                minimum = base_.get(i);
        }
        return minimum;
    }
    public Integer max()
    {
        int max = base_.get(0);
        for (int i = 1; i < base_.size(); i++) {
            if (max < base_.get(i))
                max = base_.get(i);
        }
        return max;
    }
    public int size()
    {
        return base_.size();
    }
    public static IntegerSet intersection(IntegerSet a, IntegerSet b)
    {
        IntegerSet res = new IntegerSet();
        for(int i = 0; i < a.size(); i++)
            if (b.has(a.base_.get(i)))
                res.insert(a.base_.get(i));
        return res;
    }
    public static IntegerSet union(IntegerSet a, IntegerSet b)
    {
        IntegerSet res = new IntegerSet();
        for(int i = 0; i < a.size(); i++)
            res.insert(a.base_.get(i));
        for(int i = 0; i < b.size(); i++)
            if (!res.has(b.base_.get(i)))
                res.insert(b.base_.get(i));
        return res;
    }
}
