package sword.offer;

/**
 * 替换空格
 *
 * @author youtiaoguagua
 * @date 2020/9/6 下午 4:42
 */
public class ReplaceSpaces {
    /**
     * 请实现一个函数，把字符串中的每个空格替换成"%20"。
     * 你可以假定输入字符串的长度最大是1000。
     * 注意输出字符串的长度可能大于1000。
     * 样例
     * 输入："We are happy."
     * 输出："We%20are%20happy."
     */
    public static void main(String[] args) {
        ReplaceSpaces replaceSpaces = new ReplaceSpaces();
        StringBuffer append = new StringBuffer().append("We are happy.");
        String s = replaceSpaces.replaceSpaces(append);
        System.out.println(s);
    }

    public String replaceSpaces(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.deleteCharAt(i);
                str.insert(i, "%20");
            }
        }
        return str.toString();
    }
}
