package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DualTrigger {
    private static int checkOnesCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }

    public String getSmallestString(String s, int k) {
        char[] sb = s.toCharArray();
        int i = 0;
        while (k > 0 && i < sb.length) {
            if (sb[i] == 'a') i++;
            else if (sb[i] - 'a' < 13) {
                if (sb[i] - 'a' < k) {
                    k -= sb[i] - 'a';
                    sb[i++] = 'a';
                } else {
                    sb[i] = (char) (sb[i] - k); i++;
                    k = 0;
                }
            } else {
                char character = sb[i];
                if (26 - (character - 'a') <= k) {
                    sb[i++] = 'a';
                    k -= 26 - (character - 'a');
                } else {
                    char newCharacter = (char)(character - k);
                    sb[i++] = newCharacter;
                    k = 0;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char c : sb) answer.append(c);
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int onesCount = checkOnesCount(s);
            if (onesCount % 2 == 1) System.out.println("NO");
            else if (onesCount == 0) System.out.println("YES");
            else if (onesCount == n) System.out.println("YES");
            else {
                int i = 0, j = n - 1;
                StringBuilder sb = new StringBuilder("0".repeat(n));
                while (i < j) {
                    while (i < j && s.charAt(i) != '1') i++;
                    while (j >= i && s.charAt(j) != '1') j--;
                    if (i < j) {
                        sb.setCharAt(i++, '1'); sb.setCharAt(j++, '1');
                    }
                }
                System.out.println(sb.toString().equals(s) ? "YES" : "NO");
            }
        }
    }
}
