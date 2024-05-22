package LeetcodeProblems;

public class IntToRoman {
    public void helper(StringBuilder sb, int num, int count) {
        if (num == 0) return;
        if (count == 1) {
            if (num <= 3) {
                switch(num) {
                    case 1 -> sb.append('I');
                    case 2 -> sb.append("II");
                    case 3 -> sb.append("III");
                }
            } else if (num == 4) sb.append("IV");
            else if (num == 9) sb.append("IX");
            else {
                sb.append("V");
                helper(sb, num - 5, count);
            }
        }
        else if (count == 2) {
            if (num <= 3) {
                switch(num) {
                    case 1 -> sb.append("X");
                    case 2 -> sb.append("XX");
                    case 3 -> sb.append("XXX");
                }
            } else if (num == 4) sb.append("XL");
            else if (num == 9) sb.append("XC");
            else {
                sb.append("L");
                helper(sb, num - 5, count);
            }
        }
        else if (count == 3) {
            if (num <= 3) {
                switch(num) {
                    case 1 -> sb.append("C");
                    case 2 -> sb.append("CC");
                    case 3 -> sb.append("CCC");
                }
            } else if (num == 4) sb.append("CD");
            else if (num == 9) sb.append("CM");
            else {
                sb.append("D");
                helper(sb, num - 5, count);
            }
        }
        else if (count == 4) {
            while(num > 0){
                sb.append("M");
                num--;
            }
        }
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (num > 0) {
            helper(sb, num % 10, count++);
            num /= 10;
        }
        return sb.toString();
    }
}
