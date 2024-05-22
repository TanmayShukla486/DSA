package LeetcodeProblems;

import java.util.*;

class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int i = map.get(val);
        list.set(i, list.get(list.size() - 1));
        map.compute(list.get(list.size() - 1), (key, value) -> i);
        map.remove(val);
        list.remove(list.size() - 1);
        return true; 
    }

    public int getRandom() {
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }
}