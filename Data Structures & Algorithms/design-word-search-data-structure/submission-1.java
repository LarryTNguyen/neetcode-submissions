class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(char c: word.toCharArray()){
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.word = true;
    }

    public boolean search(String word) {
        return searchFrom(root, word, 0);
    }

    public boolean searchFrom(TrieNode sepRoot, String word, int index){
        if(index == word.length()) return sepRoot.word;
        if(word.charAt(index) != '.'){
            sepRoot = sepRoot.children.get(word.charAt(index));
            if(sepRoot == null) return false;
            else return searchFrom(sepRoot, word, index+1);
        }
        if(word.charAt(index)=='.'){
            for(Character c:sepRoot.children.keySet()){
                if(searchFrom(sepRoot.children.get(c), word, index+1)) return true;
            }
        }
        return false;
    }
}

class TrieNode{
    boolean word;
    HashMap<Character, TrieNode> children;
    public TrieNode(){
        word = false;
        children = new HashMap<>();
    }
}