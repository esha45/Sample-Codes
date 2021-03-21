package Sample;

public class Node {

    public Node left;
    public Node right;
    public String word;
    public String meaning;

    public Node(String word,String meaning){
        left=null;
        right=null;
        this.word=word;
        this.meaning=meaning;
    }
}

