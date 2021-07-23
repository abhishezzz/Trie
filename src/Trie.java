public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(); // root is empty and initialized on object creation
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {     // constructor for node initialization
            this.children = new TrieNode[26]; // storing english words - a -> z    	    this.isWord = false;(default)
        }
    }

    public void insert(String word) {
        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        word = word.toLowerCase();

        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            } else {
                current = current.children[index];
            }
        }
        current.isWord = true;

    }

    public boolean search(String word) {
        word=word.toLowerCase();
        TrieNode current =root;
        for(int i = 0;i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.children[index]==null)
                return false;
            else
                current= current.children[index];
        }
        return current.isWord;
    }
    public boolean startsWith(String prefix) {
        prefix=prefix.toLowerCase();
        TrieNode current =root;
        for(int i = 0;i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(current.children[index]==null)
                return false;
            else
                current= current.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cab");
        trie.insert("son");
        trie.insert("so");
        System.out.println("Values inserted successfully !!!");
        System.out.println(trie.search("cat"));
        System.out.println(trie.search("can"));
        System.out.println(trie.search("cab"));
        System.out.println(trie.startsWith("ca"));
        System.out.println(trie.startsWith("a"));
    }
}
