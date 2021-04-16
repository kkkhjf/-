package com.hejianfeng.javaRetest;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @aouthor HJF
 * @create 2021-04-13-14:27
 */
public class JavaRetest {

    //压缩矩阵的代码练习
    @Test
    public void test1(){
        int[][] arr = {{0,0,0,0,0,0,0},
                        {0,1,0,0,0,0,0},
                        {0,0,0,0,0,5,0},
                        {0,3,0,6,0,0,0}};
        int count = 0;
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] != 0){
                    count++;
                }
            }

        int[][] zip = new int[count + 1][3];
        zip[0][0] = arr.length;
        zip[0][1] = arr[0].length;
        zip[0][2] = count;
        count = 1;
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    zip[count][0] = i;
                    zip[count][1] = j;
                    zip[count][2] = arr[i][j];
                    count++;
                }
            }


        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < zip.length; i ++){
            for(int j = 0; j < 3; j++){
                System.out.print(zip[i][j] + "\t");
            }
            System.out.println();
        }

        count = 1;
        int[][] arr1 = new int[zip[0][0]][zip[0][1]];
        while(count <= zip[0][2]){
            arr1[zip[count][0]][zip[count][1]] = zip[count][2];
            count++;
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < arr1.length; i ++){
            for(int j = 0; j < arr1[0].length; j++){
                System.out.print(arr1[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //队列的代码练习
    @Test
    public void QueenTest(){
        QueenHJF queen = new QueenHJF(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while(loop){
            System.out.println("s(show) 显示队列信息: ");
            System.out.println("a(addNum) 添加数据: ");
            System.out.println("d(deNum) 取出数据: ");
            System.out.println("e(exit) 退出队列: ");

            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queen.pushQueen();
                    break;
                case 'a':
                    int num = scanner.nextInt();
                    queen.addQueen(num);
                    break;
                case 'd':
                    System.out.println("取出的数据是: " + queen.deQueen());
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出。。。");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    public void linkTest(){
        Scanner scanner = new Scanner(System.in);
        HeroLink link = new HeroLink();
        HeroNode hero1 = new HeroNode(1,"刘备","大耳贼");
        HeroNode hero2 = new HeroNode(2,"关羽","汉寿亭侯");
        HeroNode hero3 = new HeroNode(3,"张飞","琢郡屠夫");
        HeroNode hero4 = new HeroNode(5,"曹操","曹阿满");
        HeroNode hero5 = new HeroNode(4,"赵云","常山赵子龙");
        HeroNode hero6 = new HeroNode(5,"asd","asd");
        HeroNode hero7 = new HeroNode(6,"黄忠","百步穿杨");
        link.addNode(hero1);
        link.addNode(hero2);
        link.addNode(hero3);
        link.addNode(hero4);
        link.addByOrder(hero5);
        link.updateList(hero6);
        link.addByOrder(hero7);
        link.showList();
//        System.out.println("链表中的结点个数为：" + link.countNode());
        System.out.println("------------------------------");
//        int n = scanner.nextInt();
//        System.out.println("链表的倒数第"+ n + "个结点是" + link.getNode(link.countNode() - n + 1));
//        HeroLink newlink = new HeroLink();
//        newlink = link.reverseLink(newlink);
//        newlink.showList();
//        System.out.println("------------------------------");
//        link.showList();
//        link.reverseSelf(link.getHead());
//        link.showList();
        link.reversePrintLink();
        System.out.println("------------------------------");
        link.showList();
    }

    @Test
    public void DoubleLinkTest(){
        DoubleLink dlink = new DoubleLink();
        DoubleHeroNode hero1 = new DoubleHeroNode(1,"刘备","大耳贼");
        DoubleHeroNode hero2 = new DoubleHeroNode(2,"关羽","汉寿亭侯");
        DoubleHeroNode hero3 = new DoubleHeroNode(3,"张飞","琢郡屠夫");
        DoubleHeroNode hero4 = new DoubleHeroNode(5,"曹操","曹阿满");
        DoubleHeroNode hero5 = new DoubleHeroNode(4,"赵云","常山赵子龙");
        DoubleHeroNode hero6 = new DoubleHeroNode(5,"asd","asd");
        DoubleHeroNode hero7 = new DoubleHeroNode(6,"黄忠","百步穿杨");

        dlink.addDoubleNode(hero1);
        dlink.addDoubleNode(hero2);
        dlink.addDoubleNode(hero3);
        dlink.addDoubleNode(hero4);
        dlink.addDoubleNode(hero5);
        dlink.addDoubleNode(hero7);

        dlink.showDoubelLink();
        dlink.deleteDnode(6);
        System.out.println("------------------------------");
        dlink.showDoubelLink();
        System.out.println("------------------------------");
        dlink.updateNode(hero6);
        dlink.showDoubelLink();
    }

    @Test
    public void JosephuTest(){

    }

}


class QueenHJF{
    private int MaxSize;
    private int rear;
    private int front ;
    private int[] arr = null;

    public QueenHJF(int maxSize) {
        MaxSize = maxSize;
        arr = new int[maxSize];
        for(int i = 0; i < MaxSize; i++){
            arr[i] = -1;
        }
        this.rear = -1;
        this.front = -1;
    }

    public void addQueen(int num){
        if((rear + 1) % MaxSize != front){
            rear = (rear + 1) % MaxSize;
            arr[rear] = num;
            System.out.println(rear + "===" + front);
        }else {
            throw new RuntimeException("队列已满！");
        }
    }

    public int deQueen(){
        if(rear != front){
            front = (front + 1) % MaxSize;
            int num = arr[front];
            System.out.println(rear + "===" + front);
            return num;
        }else{
            throw new RuntimeException("队列为空！");
        }
    }

    public void pushQueen(){
        if(rear != front){
            while(rear != front){
                front = (front + 1) % MaxSize;
                System.out.print(arr[front] + "\t");
                System.out.println(rear + "===" + front);
            }
            System.out.println();
        }else{
            throw new RuntimeException("队列为空！");
        }

    }
    public int getMaxSize() {
        return MaxSize;
    }
}
//单链表结构
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; //指向下一个结点

    //结点构造器
    public HeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString(){
        return "HeroNode[ no = " + this.no + ", name = " +  this.name +
                ", nickName = " + this.nickName + " ]";
    }
}
//单链表的操作
class HeroLink{
    private HeroNode head = new HeroNode(0,"","");

    public void addNode(HeroNode node){
        HeroNode temp = head;
        while(true){
            if(temp.next == null){
                temp.next = node;
                break;
            }else {
                temp = temp.next;
            }
        }
    }

    //按照序号的顺序进行查找
    public void addByOrder(HeroNode node){
        HeroNode temp = head;
        boolean flag = true;
        while (true){//先找到要插入的位置再进行插入操作
            if(temp.next == null){
                break;
            }else if(temp.next.no > node.no){
                break;
            }else if(temp.next.no == node.no){
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            node.next = temp.next;
            temp.next = node;
        }else{
            System.out.println(node + "结点编号已存在！");
        }

    }

    //按照结点的序号更新结点
    public void updateList(HeroNode node){
        HeroNode temp = head;
        if(temp.next == null){
            System.out.println("链表为空！");
        }
        while(true){//寻找需要修改的结点位置
            if(temp.next == null){
                break;
            }else if(temp.next.no != node.no){
                temp = temp.next;
            }else {
                break;
            }
        }
        if(temp.next == null){
            temp.next = node;
        }else{
            temp.next.name = node.name;
            temp.next.nickName = node.nickName;
        }
    }

    //删除结点
    public void deleteNode(int no){
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                System.out.println("链表中没有编号为" + no + "的结点！");
                break;
            }else if(temp.next.no != no){
                temp = temp.next;
            }else{
                break;
            }
        }
        if(temp.next != null){
            temp.next = temp.next.next;
            System.out.println("删除成功！");
        }
    }

    //统计结点个数
    public int countNode(){
        if(head.next == null)
            return 0;
        HeroNode temp = head;
        int count = 0;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //显示第N个结点信息
    public  HeroNode getNode(int num){
        if(head.next == null){
            System.out.println("链表为空！");
            return null;
        }
        HeroNode temp = head.next;
        for(int i = 1; i < num; i++){
            if(temp != null){
                temp = temp.next;
            }else{
                break;
            }
        }
        if(temp != null){
            return temp;
        }else{
            return null;
        }
    }

    //链表逆置，返回新链表（旧链表结构被破坏）
    public HeroLink reverseLink(HeroLink newlink){
        if(head.next == null){
            System.out.println("链表为空！");
            return null;
        }
        HeroNode temp = head.next;
        HeroNode pretemp = head;
        while(temp != null){
            pretemp.next = temp.next;    //将被操作的结点从链表中独立出来避免原始链表受到干扰
            HeroNode node = temp;        //取出被操作的结点
            temp = temp.next;
            node.next = newlink.head.next;
            newlink.head.next = node;
        }
        return newlink;
    }

    //链表自身反转
    public void reverseSelf(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseLink = new HeroNode(0,"","");
        while(cur != null){
            next = cur.next;
            cur.next = reverseLink.next;
            reverseLink.next = cur;
            cur = next;
        }
        head.next = reverseLink.next;
    }

    //获取头结点
    public HeroNode getHead(){
        return head;
    }

    //逆序打印链表
    public void reversePrintLink(){
        HeroNode[] stack = new HeroNode[this.countNode()];
        HeroNode temp = head.next;
        for(int i = 0; i < stack.length; i++){
            stack[i] = temp;
            temp = temp.next;
        }
        for(int i = stack.length - 1; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }


    public void showList(){
        if(head == null){
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp != null){
                System.out.println(temp);
                temp = temp.next;
            }else {
                break;
            }
        }
    }

}
//双链表结构
class DoubleHeroNode{
    public int no;
    public String name;
    public String nickName;
    public DoubleHeroNode next; //指向下一个结点
    public DoubleHeroNode pre; //指向前一个结点

    public DoubleHeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString(){
        return "DoubleHeroNode[ no = " + this.no + ", name = " +  this.name +
                ", nickName = " + this.nickName + " ]";
    }
}
//双链表操作
class DoubleLink {
    DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    //添加结点
    public void addDoubleNode(DoubleHeroNode dnode) {
        if (head.next == null) {
            head.next = dnode;
            dnode.pre = head;
            return;
        }
        DoubleHeroNode temp = this.getLastNode();
        temp.next = dnode;
        dnode.pre = temp;

    }

    //修改结点信息
    public void updateNode(DoubleHeroNode dnode) {
        DoubleHeroNode temp = head;
        if (temp.next == null) {
            System.out.println("链表为空！");
            return;
        }
        while (true) {//寻找需要修改的结点位置
            if (temp.next == null) {
                break;
            } else if (temp.next.no != dnode.no) {
                temp = temp.next;
            } else {
                break;
            }
        }
        if (temp.next == null) {
            temp.next = dnode;
        } else {
            temp.next.name = dnode.name;
            temp.next.nickName = dnode.nickName;
        }
    }

    //删除结点
    public void deleteDnode(int num) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        DoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null)
                break;
            else if (temp.no != num)
                temp = temp.next;
            else
                break;
        }
        if(temp != null){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("链表重没有编号为"+ num + "的结点！");
        }
    }


    //获取头结点
    public DoubleHeroNode getHead(){
        return head;
    }

    //获得尾结点
    public DoubleHeroNode getLastNode(){
        DoubleHeroNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    //获取链表的数量
    public int countNode(){
        if(head.next == null){
            return 0;
        }
        int count = 0;
        DoubleHeroNode temp = head.next;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //输出链表结点
    public void showDoubelLink(){
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        DoubleHeroNode temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
//循环链表