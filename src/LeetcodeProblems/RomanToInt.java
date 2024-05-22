package LeetcodeProblems;

public class RomanToInt {
    public int romanToInt(String s) {
        int answer = 0; int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') answer += 1000;
            else if (i + 1 < n && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                answer += 900; i++;
            }
            else if (i + 1 < n && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                answer += 400; i++;
            }
            else if (i + 1 < n && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                answer += 40; i++;
            }
            else if (i + 1 < n && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                answer += 90; i++;
            }
            else if (i + 1 < n && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                answer += 4; i++;
            }
            else if (i + 1 < n && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                answer += 9; i++;
            }
            else if (s.charAt(i) == 'D') answer += 500;
            else if (s.charAt(i) == 'C') answer += 100;
            else if (s.charAt(i) == 'X') answer += 10;
            else if (s.charAt(i) == 'V') answer += 5;
            else if (s.charAt(i) == 'I') answer += 1;
        }
        return answer;
    }
}
