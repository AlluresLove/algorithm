package cn.idestiny.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Lv Fan
 * @description: 电话号码的字母组合
 * @date: Create in 2020/7/27 19:36
 *
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationOfPhoneNumber {

    List<String> result = new LinkedList<>();

    String[] numberToLetter = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return result;
        }
        //获取结果集
        recursion(digits,"",0);
        return result;
    }

    public void recursion(String str,String letter,int index){
        // 循环结束条件，如果index等于str说明到达最后一个字符
        if (index == str.length()){
            // 把结果添加到结果接
            result.add(letter);
            return;
        }
        // 获取第index位置的字符
        char c = str.charAt(index);
        // mapString的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        // 比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
        int pos = c - '0';
        // 获取到index位置的字符
        String mapString = numberToLetter[pos];
        // 遍历字符串，比如第一次得到的是2，也就是遍历"abc"
        for (int i = 0; i < mapString.length(); i++) {
            //调用下一层递归，比如说输入为23（abc，def），第一遍遍历a到def
            recursion(str,letter+mapString.charAt(i),i + 1);
        }
    }
}
