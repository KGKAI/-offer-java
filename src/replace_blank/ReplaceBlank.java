package replace_blank;

// 替换空格
// 题目：请实现一个函数，把字符串的每个空格替换成"%20"。例如输入"We are happy."，
// 则输出"We%20are%20happy."
//
// 思路：
// 双指针、从后向前迭代，时间复杂度为O(n)
// 1、首先计算出给定字符串中空格的数量
// 2、创建新的字符数组
// 3、两个指针，其中一个i指向旧数组末尾，另一个j指向新数组末尾
public class ReplaceBlank {
    private static int getBlankCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                count++;
            }
        }

        return count;
    }

    public static String replaceBlank(String str) {
        if (str.length() == 0) {
            return "";
        }

        int blankCount = getBlankCount(str);
        int newLength = str.length() - blankCount + 3 * blankCount;
        char[] temp = new char[newLength];
        int i = str.length() - 1, j = newLength - 1;
        while (i >= 0 && j >= 0) {
            if (str.charAt(i) == ' ') {
                temp[j--] = '0';
                temp[j--] = '2';
                temp[j--] = '%';
                i--;        // 注意需要给i减1，否则会出错

            } else {
                temp[j--] = str.charAt(i--);
            }
        }

        return String.valueOf(temp);
    }

    public static void main(String[] args) {
        String str = "We are happy. now";
        System.out.println(replaceBlank(str));
    }
}
