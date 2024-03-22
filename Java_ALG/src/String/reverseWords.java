package String;

public class reverseWords {
    public String method(String s) {
        if (s == null || s.isEmpty()) return s;
        String[] s1 = s.trim().split(" ");
        StringBuffer buffer = new StringBuffer();
        // 倒序遍历!
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("")) continue;
            buffer.append(s1[i]).append(" ");
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        reverseWords test = new reverseWords();
        test.method(s);
    }
}
