package com.hejianfeng.javaRetest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @aouthor HJF
 * @create 2021-04-29-10:11
 */
public class TreeTest {
    public int[] arr = {7,3,10,12,5,1,9,2};
    int temp;
    public int right;
    public int left;
    public SortNode sortNode;

    @Test
    //二叉树的三种遍历
    public void BinaryTrees(){
//        BinaryTree btree = new BinaryTree();
//
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
//        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);
//
//        n1.left = n2;
//        n1.right = n3;
//        n3.left = n4;
//        n3.right = n5;
//        btree.root = n1;
////        btree.searchNode(3);
//        btree.preOrder();
//        System.out.println("=======================");
//        btree.postDelNode(3);
//        btree.preOrder();
//        System.out.println("=======================");
//        preArray(arr, 0);
//        System.out.println();
//        System.out.println("=======================");

//        ThreadedNode t1 = new ThreadedNode(1);
//        ThreadedNode t2 = new ThreadedNode(3);
//        ThreadedNode t3 = new ThreadedNode(6);
//        ThreadedNode t4 = new ThreadedNode(8);
//        ThreadedNode t5 = new ThreadedNode(10);
//        ThreadedNode t6 = new ThreadedNode(14);
//
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
//        t3.left = t6;
//
//        ThreadedBinaryTree tbt = new ThreadedBinaryTree();
//        tbt.root = t1;
//        tbt.threadedNodes(tbt.root);
//        tbt.postThreadedTree();
//        System.out.println();
//        System.out.println("=======================");
//        heapSort();
        System.out.println("=======================");
        List<Node> nodes = creatNodes();
        while(nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node node = new Node(leftNode.no + rightNode.no);
            node.left = leftNode;
            node.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(node);
        }
        nodes.get(0).prePrint();



    }

    //二叉树
    class BinaryTree{
        public Node root;

        public void preOrder(){
            if(this.root != null){
                this.root.prePrint();
            }else{
                System.out.println("树为空！");
            }
        }

        public void infixOrder(){
            if(this.root != null){
                this.root.infixPrint();
            }else{
                System.out.println("树为空！");
            }
        }

        public void postOrder(){
            if(this.root != null){
                this.root.postPrint();
            }else{
                System.out.println("树为空！");
            }
        }
        public void searchNode(int value){
            this.root.preSearchNode(value);
        }

        public void postDelNode(int value){
            this.root.postDelNode(value);
        }

    }
    //树节点
    class Node implements Comparable<Node>{
        public int no;
        public Node left;
        public Node right;

        public Node(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    '}';
        }

        public void prePrint(){//先序遍历
            System.out.println(this);
            if(this.left != null){
                this.left.prePrint();
            }
            if(this.right != null){
                this.right.prePrint();
            }
        }

        public void infixPrint(){//中序遍历
            if(this.left != null){
                this.left.infixPrint();
            }
            System.out.println(this);
            if(this.right != null){
                this.right.infixPrint();
            }
        }

        public void postPrint(){//后序遍历
            if(this.left != null){
                this.left.postPrint();
            }
            if(this.right != null){
                this.right.postPrint();
            }
            System.out.println(this);
        }

        public void preSearchNode(int value){//前序查找
            if(this.no == value){
                System.out.println("找到了！");
                return;
            }
            if(this.left != null){
                this.left.preSearchNode(value);
            }
            if(this.right != null){
                this.right.preSearchNode(value);
            }
        }

        public void postDelNode(int value){
            if(this.left != null && this.left.no == value){
                this.left = null;
                return;
            }
            if(this.right != null && this.right.no == value){
                this.right = null;
                return;
            }
            if(this.left != null){
                this.left.postDelNode(value);
            }
            if(this.right != null){
                this.right.postDelNode(value);
            }
        }

        @Override
        public int compareTo(Node o) {
            return this.no - o.no;
        }
    }
    //遍历顺序存储二叉树
    public void preArray(int[] arr, int n){
        System.out.print(arr[n] + "\t");
        if((2*n + 1) < arr.length){
            preArray(arr, 2*n + 1);
        }
        if((2*n + 2) < arr.length){
            preArray(arr, 2*n + 2);
        }
    }
    //线索化二叉树结点
    class ThreadedNode{
        public int no;
        public ThreadedNode left;
        public ThreadedNode right;
        public int leftType;
        public int rightType;

        public ThreadedNode(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    '}';
        }

        public void prePrint(){//先序遍历
            System.out.println(this);
            if(this.left != null){
                this.left.prePrint();
            }
            if(this.right != null){
                this.right.prePrint();
            }
        }

        public void infixPrint(){//中序遍历
            if(this.left != null){
                this.left.infixPrint();
            }
            System.out.println(this);
            if(this.right != null){
                this.right.infixPrint();
            }
        }

        public void postPrint(){//后序遍历
            if(this.left != null){
                this.left.postPrint();
            }
            if(this.right != null){
                this.right.postPrint();
            }
            System.out.println(this);
        }

        public void preSearchNode(int value){//前序查找
            if(this.no == value){
                System.out.println("找到了！");
                return;
            }
            if(this.left != null){
                this.left.preSearchNode(value);
            }
            if(this.right != null){
                this.right.preSearchNode(value);
            }
        }

        public void postDelNode(int value){
            if(this.left != null && this.left.no == value){
                this.left = null;
                return;
            }
            if(this.right != null && this.right.no == value){
                this.right = null;
                return;
            }
            if(this.left != null){
                this.left.postDelNode(value);
            }
            if(this.right != null){
                this.right.postDelNode(value);
            }
        }
    }
    //线索化二叉树
    class ThreadedBinaryTree{
        public ThreadedNode root;
        public ThreadedNode pre;

        //中序遍历线索化二叉树
        public void postThreadedTree(){
            ThreadedNode node = root;
            while(node != null){
                while(node.leftType == 0){
                    node = node.left;
                }
                System.out.print(node + "\t");
                while(node.rightType == 1){
                    node = node.right;
                    System.out.print(node + "\t");
                }
                node = node.right;

            }
        }
        //中序线索化二叉树
        public void threadedNodes(ThreadedNode node){
            if(node == null){
                return;
            }
            threadedNodes(node.left);
            if(node.left == null){
                node.left = pre;
                node.leftType = 1;
            }
            if(pre != null && pre.right == null){
                pre.right = node;
                pre.rightType = 1;
            }
            pre = node;
            threadedNodes(node.right);
        }

        public void preOrder(){
            if(this.root != null){
                this.root.prePrint();
            }else{
                System.out.println("树为空！");
            }
        }

        public void infixOrder(){
            if(this.root != null){
                this.root.infixPrint();
            }else{
                System.out.println("树为空！");
            }
        }

        public void postOrder(){
            if(this.root != null){
                this.root.postPrint();
            }else{
                System.out.println("树为空！");
            }
        }
        public void searchNode(int value){
            this.root.preSearchNode(value);
        }

        public void postDelNode(int value){
            this.root.postDelNode(value);
        }

    }
    //堆排序
    public void heapSort(){
        for(int i = arr.length/2 - 1; i >=0; i--){
            buildHeap(arr,i,arr.length);
        }
        for(int i = arr.length - 1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            buildHeap(arr,0, i);
        }
        System.out.println(Arrays.toString(arr));
    }
    //构建大根堆
    public void buildHeap(int[] arr, int n, int length){
        int temp = arr[n];
        for(int i = 2*n + 1; i < length; i = i*2 + 1){
            if(i + 1 < length && arr[i] < arr[i + 1]){
                i++;
            }
            if(arr[i] > temp){
                arr[n] = arr[i];
                n = i;
            }else{
                break;
            }
        }
        arr[n] = temp;
    }
    //构建哈夫曼树
    public List<Node> creatNodes(){
        List<Node> nodes = new ArrayList<>();
        for(int value : arr){
            nodes.add(new Node(value));
        }
        return nodes;
    }





    @Test
    //中序遍历二叉排序树
    public void BinarySortTrees(){
        BinarySortTree bst = new BinarySortTree();
        for(int i = 0; i < arr.length; i++){
            bst.add(new SortNode(arr[i]));
        }
        bst.infixOrder();
        bst.delNode(3);//当要删除的结点是根节点是要另行分析，暂且不考虑，后续再接着写
        System.out.println("======================");
        bst.infixOrder();
    }
    //二叉排序树
    class BinarySortTree{
        public SortNode root;

        public void add(SortNode node){
            if(root == null){
                root = node;
                return;
            }else{
                root.add(node);
            }
        }
        //中序遍历
        public void infixOrder(){
            if(root != null){
                root.infixPrint();
            }else{
                System.out.println("二叉排序树为空！");
            }
        }
        //删除结点
        public void delNode(int value){
            root.delNode(root,value);
        }
    }
    //二叉排序树结点
    class SortNode{
        public int no;
        public SortNode right;
        public SortNode left;

        public SortNode(int no) {
            this.no = no;
        }
        //添加结点
        public void add(SortNode node){
            if(node == null){
                return;
            }
            if(node.no < this.no){
                if(this.left == null){
                    this.left = node;
                }else{
                    this.left.add(node);
                }
            }else{
                if(this.right == null){
                    this.right = node;
                }else{
                    this.right.add(node);
                }
            }
        }
        //中序遍历
        public void infixPrint(){
            if(this.left != null){
                this.left.infixPrint();
            }
            System.out.println(this);
            if(this.right != null){
                this.right.infixPrint();
            }
        }
        //删除结点
        public void delNode(SortNode root, int value){
            List<SortNode> list = new ArrayList<>();
            SortNode node = null;
            infixSearch(value);
            if(sortNode.left.no == value){
                node = sortNode.left;
                sortNode.left = null;
            }
            if(sortNode.right.no == value){
                node = sortNode.right;
                sortNode.right = null;
            }
            node.infixGetList(list);
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).no != value)
                    root.add(list.get(i));
            }
        }
        public void infixSearch(int value){
            if(this.left != null ){
                if(this.left.no == value){
                    sortNode = this;
                }
                this.left.infixSearch(value);
            }
            if(this.right != null){
                if(this.right.no == value){
                    sortNode = this;
                }
                this.right.infixSearch(value);
            }
        }
        public void infixGetList(List<SortNode> list){
            if(this.left != null){
                this.left.infixGetList(list);
            }
            list.add(new SortNode(this.no));
            if(this.right != null){
                this.right.infixGetList(list);
            }
        }

        @Override
        public String toString() {
            return "SortNode{" +
                    "no=" + no +
                    '}';
        }
    }


    @Test//平衡二叉树
    public void BalanceBinaryTrees(){
        BalanceBinaryTree bbt = new BalanceBinaryTree();

    }
    class BalanceBinaryTree{
        public BalanceNode root;

        public void add(BalanceNode node){
            if(root == null){
                root = node;
                return;
            }else{
                root.add(node);
            }
        }
        //中序遍历
        public void infixOrder(){
            if(root != null){
                root.infixPrint();
            }else{
                System.out.println("二叉排序树为空！");
            }
        }
    }
    class BalanceNode{
        public int no;
        public BalanceNode right;
        public BalanceNode left;

        public BalanceNode(int no) {
            this.no = no;
        }

        public int leftHeight(){
            if(left == null)
                return 0;
            return left.height();
        }

        public int rightHeight(){
            if(right == null)
                return 0;
            return right.height();
        }

        public int height(){//判断两种返回值的高度则直接使用max函数进行判断
            return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
        }

        public void leftRotate(){
            BalanceNode node = new BalanceNode(this.no);
            node.left = this.left;
            node.right = this.right.left;
            this.no = this.right.no;//当前节点的值被替换成右子节点的值，这样就不通过移形换影达到替换结点的效果
            this.right = this.right.right;
            this.left = node;
        }

        public void rightRotate(){
            BalanceNode node = new BalanceNode(this.no);
            node.right = this.right;
            node.left = this.left.right;
            this.no = this.left.no;
            this.left = this.left.left;
            this.right = node;
        }

        public void add(BalanceNode node){
            if(node == null){
                return;
            }
            if(node.no < this.no){
                if(this.left == null){
                    this.left = node;
                }else{
                    this.left.add(node);
                }
            }else{
                if(this.right == null){
                    this.right = node;
                }else{
                    this.right.add(node);
                }
            }
        }
        //中序遍历
        public void infixPrint(){
            if(this.left != null){
                this.left.infixPrint();
            }
            System.out.println(this);
            if(this.right != null){
                this.right.infixPrint();
            }
        }
        
        @Override
        public String toString() {
            return "BalanceNode{" +
                    "no=" + no +
                    '}';
        }
    }
}

