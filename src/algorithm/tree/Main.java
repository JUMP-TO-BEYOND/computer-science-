package algorithm.tree;

import java.util.*;

class Node{
    private String data;
    private Node left;
    private Node right;

    public Node() {}

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class Tree{
    Node root;

    public void setRoot(Node node){
        this.root = node;
    }

    public Node getRoot(){
        return root;
    }

    // 나 자신 파라미터 Node, 들어가야 하는 데이터, isLeft, isRight)

    public void makeNode(String datas) { // 1. 탈출조건 : 같을 때, null일 때 2. 분기조건 : 왼오
        String[] array = datas.split(" ");
        String searhData = array[0];
        Node leftNode = null;
        Node rightNode = null;

        if(!".".equals(array[1])){
            leftNode = new Node(array[1]);
        }
        if(!".".equals(array[2])){
            rightNode = new Node(array[2]);
        }


        if (root == null) {
            root = new Node(searhData);
        }

        setNode(root, searhData, leftNode, rightNode);
    }

    void setNode(Node current, String searhData, Node leftNode, Node rightNode){ // 1. 탈출조건 : 같을 때, null일 때 2. 분기조건 : 왼오
        if (current == null) {
            return;
        }

        // 여기서 current == data 위치 찾았다.
        // 자식노드 왼쪽, 오른쪽 값 세팅
        // 리턴

        if (searhData.equals(current.getData())) {
            current.setLeft(leftNode);
            current.setRight(rightNode);
            return;
        } else {
            setNode(current.getLeft(), searhData, leftNode, rightNode);
        }

        if (searhData.equals(current.getData())) {
            current.setLeft(leftNode);
            current.setRight(rightNode);
            return;
        } else {
            setNode(current.getRight(), searhData,leftNode, rightNode);
        }

    }

    public void inorder(Node node){ //left, root, right
        if(node != null){
            inorder(node.getLeft());
            System.out.print(node.getData());
            inorder(node.getRight());
        }
    }

    public void preorder(Node node){ //root, left, right
        if(node != null){
            System.out.print(node.getData());
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    public void postorder(Node node){ //left, right, root
        if(node != null){
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getData());
        }
    }

}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Tree tree = new Tree();

        for(int i=0; i< N; i++){
            String datas = sc.nextLine();
            tree.makeNode(datas);
        }

        System.out.println("전위순회 부모 -> 왼 -> 오");
        tree.preorder(tree.getRoot());
        System.out.println();
        System.out.println("중위순회 왼 -> 부모 -> 오");
        tree.inorder(tree.getRoot());
        System.out.println();
        System.out.println("후위순회 왼 -> 오 -> 부모");
        tree.postorder(tree.getRoot());

        sc.close();
    }
}

