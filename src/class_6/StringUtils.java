package class_6;

class StringUtils {
    static String punctuate(String string) {
        if (string.equals("")) {
            return string;
        }
        StringBuilder punctuatedString = new StringBuilder();

        char prevChar = ' ';
        char currentChar;
        int startIdx = getFirstNonEmptyCharIndex(string);
        punctuatedString.append(string.charAt(startIdx));
        for (int i = startIdx + 1; i < string.length(); i++) {
            currentChar = string.charAt(i);
            if (currentChar == ' ' && prevChar == ' ') {
                continue;
            } else if ('A' <= currentChar && currentChar <= 'Я') {
                punctuatedString.setCharAt(punctuatedString.length() - 1, '.');
                punctuatedString.append(' ');

            }
            punctuatedString.append(currentChar);
            prevChar = currentChar;
        }

        return addTrailingDot(punctuatedString);
    }

    static String addTrailingDot(StringBuilder string) {
        int lastCharIdx = string.length() - 1;
        if (string.charAt(lastCharIdx) != ' ') {
            if (string.charAt(lastCharIdx) != '.') {
                string.append('.');
            }
        } else {
            string.setCharAt(lastCharIdx, '.');
        }
        return string.toString();
    }

    static int getFirstNonEmptyCharIndex(String string) {
        int idx = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                idx++;
            } else {
                break;
            }
        }
        return idx;
    }
}
