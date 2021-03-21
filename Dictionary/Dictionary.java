package Sample;

import java.util.ArrayList;

public class Dictionary {

    public static ArrayList<String> words = new ArrayList<>();
    public static ArrayList<String> meaning = new ArrayList<>();

     public static Node head;

    public Dictionary(){
        head=null;
    }

    public  Node search(String search, Node parent){
        if (parent == null){
            return parent;
        }

        int d = search.compareTo(parent.word);

        if (d == 0){
            return parent;
        }

        else if (d > 0){
            if (parent.right != null){
                return search(search,parent.right);
            }
            return parent;
        }

        else if (d < 0){
            if (parent.left != null){
                return search(search, parent.left);
            }
            return parent;
        }

        else{
            return null;
        }
    }

    public  String search2(String search,Node parent){

        if (parent == null){
            String temp = "Word Not found";
            return temp;
        }

        int d = search.compareTo(parent.word);

        if (d == 0){
            String meaning = String.valueOf(parent.meaning);
            return meaning;
        }

        else if (d > 0){
            return search2(search, parent.right);
        }

        else if (d < 0)
        {
            return search2(search, parent.left);
        }

        else
        {
            return null;
        }
    }

    public String insert(String word,String meaning){
         Node temp=search(word,head);

        if(head==null){
            head=new Node(word,meaning);
            return null;
        }

        Node temp2=new Node(word,meaning);

        if(temp.word.equals(word)){
            String found = "The word Already exist";
            return found;
        }
        else{
            int d=word.compareTo(temp.word);

            if(d>0){
                temp.right=temp2;
                String inserted = "The word is successfully inserted";
                return inserted;
            }
            else{
                temp.left=temp2;
                String inserted = "The word is successfully inserted";
                return inserted;
            }
        }
    }

    public  boolean flag=false;
    public Node delete(Node parent,String word){
        Node temp;

        if(parent==null){
            return null;
        }

        if(parent!=null){
            int temp9 = Dictionary.words.size();
            for(int i=0;i<temp9;i++){
                if(words.get(i).equals(word)){
                    words.remove(i);
                    meaning.remove(i);
                    break;
                }
            }
            parent.left=delete(parent.left,word);
            flag=true;

            return parent;
        }

        int d=word.compareTo(parent.word);

        if(d>0){
            int temp9 = Dictionary.words.size();
            for(int i=0;i<temp9;i++){
                if(words.get(i).equals(word)){
                    words.remove(i);
                    meaning.remove(i);
                    break;
                }
            }
            parent.right=delete(parent.right,word);
            flag=true;
            return parent;
        }

        if(d<0){
            int temp9 = Dictionary.words.size();
            for(int i=0;i<temp9;i++){
                if(words.get(i).equals(word)){
                    words.remove(i);
                    meaning.remove(i);
                    break;
                }
            }
            parent.left=delete(parent.left,word);
            flag=true;
            return parent;
        }

        if(parent.left==null && parent.right==null){
            return null;
        }

        if(parent.right==null){
            parent=parent.left;
            return parent;
        }

        if(parent.left==null){
            parent=parent.right;
            return parent;
        }

        int temp9 = Dictionary.words.size();
        for(int i=0;i<temp9;i++){
            if(words.get(i).equals(word)){
                words.remove(i);
                meaning.remove(i);
                break;
            }
        }

        temp=findmin(parent.right);
        parent.word=temp.word;
        parent.meaning=temp.meaning;
        flag=true;
        return parent;
    }

    public Node findmin(Node parent){
        while(parent.left!=null){
            parent=parent.left;
        }
        return parent;
    }

    public String update(String word,String meaning){
        Node temp;
        temp=search(word,head);
        System.out.println(Dictionary.meaning);

        if(temp.word.equals(word)){
            int temp9 = Dictionary.words.size();
            for(int i=0;i<temp9;i++){
                if(Dictionary.words.get(i).equals(word)){
                    Dictionary.meaning.set(i,meaning);
                    break;
                }
            }
            temp.meaning=meaning;
            String temp1 = "The meaning has been updated in the dictionary";
            System.out.println(Dictionary.meaning);
            return temp1;

        }
        else{
            String temp2 = "The given word doesn't exists";
            return temp2;
        }
    }

    public void display(Node p){
        if(p!=null){
            display(p.left);
            System.out.print(p.word);
            System.out.print("\t");
            System.out.println(p.meaning);
            display(p.right);

        }
    }
}

