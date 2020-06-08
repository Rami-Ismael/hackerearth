  static MyScanner in = new MyScanner();
    static   PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) {
       int t = in.nextInt();
       while(t-->0){
           String action = in.next();
           if(action.equals("add")){
               insert(in.next());
           }else{
               String n = in.next();
               int val = search(n);
               out.println(val);
           }
       }
       out.flush();
    }

        //alphabet size
        static final int alphabet_size = 26;
    static class TrieNode{
        int cnt =0;
        TrieNode[] children =new TrieNode[alphabet_size];
        int [] node = new int[alphabet_size];
        //isEndOfworld true if the node end of the word
        boolean isEndOfworld = false;
        TrieNode(){
            isEndOfworld = false;
            for(int i=0;i<alphabet_size;i++){
                children[i] = null;
            }
        }
    }
    static TrieNode root = new TrieNode();
    //if not present, insert eky inot trie
    //if the key is prefix of trie node,
    //just make laf node
    static void insert(String key){
        int level ;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for(level = 0;level<length;level++){
            index = key.charAt(level)-'a';
            if(pCrawl.children[index]==null)
            pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
           pCrawl.cnt++;
        }
        pCrawl.isEndOfworld = true;
    }
    //return true if key present in trie, else false
    static int search(String key){
        int level ;
        int length = key.length();
        int index ;
        TrieNode pCrawl = root;
        for(level = 0;level<length;level++){
            index = key.charAt(level)-'a';
             if(pCrawl.children[index]==null)
             return 0;
             pCrawl = pCrawl.children[index];
        }
        return pCrawl.cnt;
    }
