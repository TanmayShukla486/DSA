package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class Justification {

    private void createRow(List<String> row, int currWidth,  List<String> answer, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (currWidth == -1) {
            for (String word: row) {
                sb.append(word); sb.append(" ");
            }
            answer.add(sb.toString().trim());
        } else if (row.size() == 1) {
            answer.add(row.get(0) + " ".repeat(maxWidth - currWidth));
        }
        else {
            int spaces = currWidth;
            int gap = spaces / (row.size() - 1);
            for (String word: row) {
                sb.append(word);
                sb.append(" ".repeat((gap == 0) ? 1: gap));
            }
            answer.add(sb.toString().trim());

        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        List<String> row = new ArrayList<>();
        int currWidth = maxWidth;
        for (int i = 0; i < words.length || !row.isEmpty(); i++) {
            if (i < words.length && currWidth - words[i].length() > 0) {
                row.add(words[i]);
                currWidth -= words[i].length() + 1;
            }
            else  {
                createRow(row, currWidth, answer, maxWidth);
                row = new ArrayList<>();
                currWidth = maxWidth;
                i--;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        new Justification().fullJustify(words, 16);
    }
}
