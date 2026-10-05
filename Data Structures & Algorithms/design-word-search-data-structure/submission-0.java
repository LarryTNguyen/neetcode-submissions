class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dotSearch(root, word, 0);
        
    }

    public boolean dotSearch(TrieNode sepRoot, String word, int index){
        if(index == word.length()) return sepRoot.word;
        if(word.charAt(index) != '.'){
            if(sepRoot.children.get(word.charAt(index)) == null) return false;
            else return dotSearch(sepRoot.children.get(word.charAt(index)), word, index+1);
        }
        if(word.charAt(index) == '.'){
            for(Character c:sepRoot.children.keySet()){
                if(dotSearch(sepRoot.children.get(c), word, index+1)){
                    return true;
                }
            }
        }
        return false;
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
