package cn.idestiny.tree;

import java.util.Stack;

/**
 * @author: Lv Fan
 * @description: 前缀树
 * @date: Create in 2020/7/25 18:06
 *
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie {

    /**
     * 树最多分支为26个字字母
     */
    Trie[] next = new Trie[26];

    /**
     * 表达word是否结束
     */
    boolean isEnd = false;

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            if (trie.next[c - 'a'] == null){
                trie.next[c - 'a'] = new Trie();
            }
            trie = trie.next[c - 'a'];
        }
        trie.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            if (trie.next[c - 'a'] == null){
                return false;
            }
            trie = trie.next[c - 'a'];
        }
        return trie.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (char c : prefix.toCharArray()) {
            if (trie.next[c - 'a'] == null){
                return false;
            }
            trie = trie.next[c - 'a'];
        }
        return true;
    }
}
