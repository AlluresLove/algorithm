package cn.idestiny.str;

import java.util.Stack;

/**
 * @Author: FAN
 * @Date: 2020/7/26 12:57
 * @Description: 索引处的解码字符串
 * <p>
 * 880. 索引处的解码字符串
 * <p>
 * 给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
 * <p>
 * 如果所读的字符是字母，则将该字母写在磁带上。
 * 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "leet2code3", K = 10
 * 输出："o"
 * 解释：
 * 解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
 * 字符串中的第 10 个字母是 "o"。
 * 示例 2：
 * <p>
 * 输入：S = "ha22", K = 5
 * 输出："h"
 * 解释：
 * 解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
 * 示例 3：
 * <p>
 * 输入：S = "a2345678999999999999999", K = 1
 * 输出："a"
 * 解释：
 * 解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= S.length <= 100
 * S 只包含小写字母与数字 2 到 9 。
 * S 以字母开头。
 * 1 <= K <= 10^9
 * 题目保证 K 小于或等于解码字符串的长度。
 * 解码后的字符串保证少于 2^63 个字母。
 **/
public class DecodeStr880 {

    public String decodeAtIndex(String S, int K) {

        char[] chs = S.toCharArray();
        // 用来计算展开后长度 Character.isDigit 判断是否为数字
        long size = 0;
        for (char ch : chs) {
            if (Character.isDigit(ch)) {
                size *= (ch - '0');
            } else {
                size++;
            }
        }
        // 若K 大于字符串长度，则不存在解
        if (K > size) {
            return null;
        }
        // sNo: 用来指向展开后字符串的第几个字节（由1开始）
        long sNo = size;
        // 利用解码前字符串，由后向前计算K的字节或做等价交换
        for (int ix = chs.length - 1; ix >= 0; ix--) {
            char ch = chs[ix];
            // 等价交换K == 0 表示 1~sNo 内最后一个字节为解 Character.isLetter 判断是否为字符串
            if (K == 0 && Character.isLetter(ch)) {
                return String.valueOf(ch);
            }
            // 若由后向前查找数字，表示sNo和K可以做等价交换
            if (Character.isDigit(ch)) {
                // 表示 0~sNo 内有重复
                int dgt = (int) (ch - '0');
                // 因为重复dgt次，要对sNo做等价交换
                sNo = sNo / dgt; //
                // 同理 K 也要做等价交换
                K %= sNo;
            } else if (K == sNo) {
                // 若 K == sNo 标识当前字符就是解
                return String.valueOf(ch);
            } else {
                // 没有找到解，继续向前搜索
                sNo--;
            }
        }
        return null;
    }


}
