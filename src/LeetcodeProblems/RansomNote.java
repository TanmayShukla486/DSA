package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransom = new HashMap<>();
        Map<Character, Integer> mag = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++)
            ransom.compute(ransomNote.charAt(i), (key, val) -> (val == null) ? 1: ++val);
        for (int i = 0; i < ransomNote.length(); i++)
            mag.compute(magazine.charAt(i), (key, val) -> (val == null) ? 1: ++val);
        for (char key: ransom.keySet()) {
            if (ransom.get(key) > mag.getOrDefault(key, 0)) return false;
        }
        return true;
    }
}
