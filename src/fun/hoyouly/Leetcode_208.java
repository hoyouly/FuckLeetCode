package fun.hoyouly;

/**
 *
 */
public class Leetcode_208 {
    public class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public char val;

        public TrieNode() {
        }

        public TrieNode(char val) {
            TrieNode node = new TrieNode();
            this.val = val;
        }
    }

    class Trie {
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
            root.val = ' ';
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ws.children[ch - 'a'] == null) {
                    ws.children[ch - 'a'] = new TrieNode(ch);
                }
                ws = ws.children[ch - 'a'];
            }
            ws.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ws.children[ch - 'a'] == null) {
                    return false;
                }
                ws = ws.children[ch - 'a'];
            }
            return ws.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode ws = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (ws.children[ch - 'a'] == null) {
                    return false;
                }
                ws = ws.children[ch - 'a'];
            }
            return true;
        }
    }
}
