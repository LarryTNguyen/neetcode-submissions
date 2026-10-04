class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            curr.children.putIfAbsent(c,new TrieNode());
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            curr = curr.children.get(word.charAt(i));
            if(curr==null) return false;
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            curr = curr.children.get(prefix.charAt(i));
            if(curr==null) return false;
        }
        return true;
    }
}

class TrieNode{
    HashMap<Character, TrieNode> children;
    boolean word;

    public TrieNode(){
        children = new HashMap<>();
        word = false;
    }
}
