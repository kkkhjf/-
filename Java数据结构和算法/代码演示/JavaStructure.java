package com.hejianfeng.javaRetest;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @aouthor HJF
 * @create 2021-04-13-14:27
 */
public class JavaStructure {
    private static Scanner scanner = new Scanner(System.in);
    private static int NUM = 520;
    private static int count = 0;
    private static int[] array = new int[8];

    //压缩矩阵的代码练习
    @Test
    public void test1() {
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 5, 0},
                {0, 3, 0, 6, 0, 0, 0}};
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }

        int[][] zip = new int[count + 1][3];
        zip[0][0] = arr.length;
        zip[0][1] = arr[0].length;
        zip[0][2] = count;
        count = 1;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++) {
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

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < zip.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(zip[i][j] + "\t");
            }
            System.out.println();
        }

        count = 1;
        int[][] arr1 = new int[zip[0][0]][zip[0][1]];
        while (count <= zip[0][2]) {
            arr1[zip[count][0]][zip[count][1]] = zip[count][2];
            count++;
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(arr1[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //队列的代码练习
    @Test
    public void QueenTest() {
        QueenHJF queen = new QueenHJF(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop) {
            System.out.println("s(show) 显示队列信息: ");
            System.out.println("a(addNum) 添加数据: ");
            System.out.println("d(deNum) 取出数据: ");
            System.out.println("e(exit) 退出队列: ");

            key = scanner.next().charAt(0);
            switch (key) {
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
    public void linkTest() {
//        Scanner scanner = new Scanner(System.in);
//        HeroLink link = new HeroLink();
        HeroNode hero1 = new HeroNode(1, "刘备", "大耳贼");
        HeroNode hero2 = new HeroNode(2, "关羽", "汉寿亭侯");
        HeroNode hero3 = new HeroNode(3, "张飞", "琢郡屠夫");
        HeroNode hero4 = new HeroNode(5, "曹操", "曹阿满");
        HeroNode hero5 = new HeroNode(4, "赵云", "常山赵子龙");
//        HeroNode hero6 = new HeroNode(5, "asd", "asd");
//        HeroNode hero7 = new HeroNode(6, "黄忠", "百步穿杨");
//        link.addNode(hero1);
//        link.addNode(hero2);
//        link.addNode(hero3);
//        link.addNode(hero4);
//        link.addByOrder(hero5);
//        link.updateList(hero6);
//        link.addByOrder(hero7);
//        link.showList();
////        System.out.println("链表中的结点个数为：" + link.countNode());
//        System.out.println("------------------------------");
////        int n = scanner.nextInt();
////        System.out.println("链表的倒数第"+ n + "个结点是" + link.getNode(link.countNode() - n + 1));
////        HeroLink newlink = new HeroLink();
////        newlink = link.reverseLink(newlink);
////        newlink.showList();
////        System.out.println("------------------------------");
////        link.showList();
////        link.reverseSelf(link.getHead());
////        link.showList();
//        link.reversePrintLink();
//        System.out.println("------------------------------");
//        link.showList();

        HeroNode h1 = new HeroNode(1,"","");
        HeroNode h3 = new HeroNode(3,"","");
        HeroNode h4 = new HeroNode(4,"","");
        HeroLink l1 = new HeroLink();
        HeroLink l2 = new HeroLink();
        l1.addNode(hero1);
        l1.addNode(hero2);
        l1.addNode(hero5);
        l2.addNode(h1);
        l2.addNode(h3);
        l2.addNode(h4);
        l1.showList();
        System.out.println("--------------------------------");
        l2.showList();
        System.out.println("--------------------------------");
        HeroNode node1 = merge(l1.getHead().next,l2.getHead().next);
        while(node1.next != null){
            System.out.println(node1);
            node1 = node1.next;
        }
    }
    public HeroNode merge(HeroNode l1, HeroNode l2){//递归调用合并两个有序链表
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        HeroNode node;
        if(l1.no < l2.no){
            node = l1;
            node.next = merge(l1.next,l2);
        }else{
            node = l2;
            node.next = merge(l1,l2.next);
        }
        return node;
    }

    @Test
    public void DoubleLinkTest() {
        DoubleLink dlink = new DoubleLink();
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "刘备", "大耳贼");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "关羽", "汉寿亭侯");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "张飞", "琢郡屠夫");
        DoubleHeroNode hero4 = new DoubleHeroNode(5, "曹操", "曹阿满");
        DoubleHeroNode hero5 = new DoubleHeroNode(4, "赵云", "常山赵子龙");
        DoubleHeroNode hero6 = new DoubleHeroNode(5, "asd", "asd");
        DoubleHeroNode hero7 = new DoubleHeroNode(6, "黄忠", "百步穿杨");

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
    public void JosephuTest() {
        CircleLink circleLink = new CircleLink();
        circleLink.addBoy(5);
        circleLink.printCL();
        System.out.println("--------------------------------------");
        circleLink.josephe(2);
    }

    @Test
    public void ArrayStackTest() {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("asb");
        arrayStack.push(3);
        arrayStack.pop();
        arrayStack.push("hjf");
        arrayStack.printStack();
    }

    @Test
    public void CalculatorByStackTest() {
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        String exp;
        float num1;
        float num2;
        char oper;
        char oper1;
        exp = scanner.nextLine();
        for (int i = 0; i < exp.length(); i++) {
            oper = exp.charAt(i);
            if (operStack.isOperator(oper)) {
                if (operStack.isEmpty()) {
                    operStack.push(oper);
                } else {
                    if (operStack.priority(oper) < operStack.priority((char) operStack.getStack()[operStack.getTop()])) {
                        operStack.push(oper);
                    } else {
                        num1 = (float) numStack.pop();
                        num2 = (float) numStack.pop();
                        oper1 = (char) operStack.pop();
                        numStack.push(operStack.calculator(num1, num2, oper1));
                        operStack.push(oper);
                    }
                }
            } else {
                numStack.push((float) exp.charAt(i) - (float) '0');
            }
        }
        while (operStack.getTop() != -1) {
            num1 = (float) numStack.pop();
            num2 = (float) numStack.pop();
            oper = (char) operStack.pop();
            numStack.push(operStack.calculator(num1, num2, oper));
        }
        System.out.println(numStack.pop());

    }

    @Test
    //中缀表达式转后缀表达式
    public void SuffixExpr() {
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack operStack = new ArrayStack(20);
        String[] expr = scanner.nextLine().split(" ");
        char tempoper;
        int count = expr.length;
        for (int i = 0; i < expr.length; i++) {
            char oper = expr[i].charAt(0);
            if (operStack.isOperator(oper)) {//如果是运算符则进行运算符比较操作
                if (operStack.isEmpty() || oper == '(') {
                    operStack.push(oper);
                } else if (oper == ')') {
                    do {
                        tempoper = (char) operStack.pop();
                        numStack.push(tempoper);
                    } while (operStack.getStack()[operStack.getTop()].toString().charAt(0) != '(');
                    operStack.pop();
                    count -= 2;
                } else {
                    if (operStack.priority(oper) < operStack.priority(operStack.getStack()[operStack.getTop()].toString().charAt(0)) ||
                            operStack.getStack()[operStack.getTop()].toString().charAt(0) == '(') {//当前优先级比栈中优先级高，则直接入栈
                        operStack.push(oper);
                    } else {
                        do {//当前优先级小于或等于栈中优先级，则弹出栈顶元素进入s2中，再次与s1栈顶元素比较
                            tempoper = (char) operStack.pop();
                            numStack.push(tempoper);
                            if (operStack.isEmpty() || operStack.getStack()[operStack.getTop()].toString().charAt(0) == '(' || operStack.priority(oper) < operStack.priority(operStack.getStack()[operStack.getTop()].toString().charAt(0))) {
                                operStack.push(oper);
                                break;
                            }
                        } while (operStack.priority(oper) >= operStack.priority(operStack.getStack()[operStack.getTop()].toString().charAt(0)));
                    }
                }
            } else {//数字直接入中间结果栈
                numStack.push(expr[i]);
            }
        }
        while (!operStack.isEmpty()) {
            numStack.push(operStack.getStack()[operStack.getTop()]);
            operStack.pop();
        }
        for (int i = count - 1; i >= 0; i--) {
            expr[i] = numStack.pop().toString();
        }
        for (int i = 0; i < count; i++) {
            System.out.print(expr[i]);
        }
        System.out.println();
    }

    @Test
    public void CalculatorBySuffix() {
        ArrayStack sumStack = new ArrayStack(10);
        String str = scanner.nextLine();
        char oper;
        float num1;
        float num2;
        for (int i = 0; i < str.length(); i++) {
            oper = str.charAt(i);
            if (sumStack.isOperator(oper)) {
                num1 = sumStack.pop().toString().charAt(0) - '0';
                num2 = sumStack.pop().toString().charAt(0) - '0';
                sumStack.push(sumStack.calculator(num1, num2, oper));
            } else {
                sumStack.push(oper);
            }
        }
        System.out.println((float) sumStack.pop());
    }

    @Test
    public void LBJ() {
        while (true) {

            int num = scanner.nextInt();
            int temp = num;
            while (num != NUM) {
                num += 1;
                num *= 2;
                num += 4;
                num /= 2;
                num += 517;
                num -= temp;
            }
            System.out.println(num);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //迷宫问题（回溯法）
    public void RecursionMiGong() {
        int[][] mg = new int[8][8];//创建迷宫，墙为1，出口为2
        for (int i = 0; i < mg[0].length; i++) {
            mg[0][i] = 1;
            mg[7][i] = 1;
        }
        for (int i = 0; i < mg.length; i++) {
            mg[i][0] = 1;
            mg[i][7] = 1;
        }
        mg[3][1] = 1;
        mg[3][2] = 1;
        mg[2][2] = 1;
        mg[5][7] = 0;
        mg[0][1] = 0;
        for (int i = 0; i < mg.length; i++) {
            for (int j = 0; j < mg[0].length; j++)
                System.out.print(mg[i][j] + "\t");
            System.out.println();
        }
        System.out.println("------------------------------------");
        MiGong(0, 1, mg);
        for (int i = 0; i < mg.length; i++) {
            for (int j = 0; j < mg[0].length; j++)
                System.out.print(mg[i][j] + "\t");
            System.out.println();
        }


    }
    public boolean MiGong(int i, int j, int[][] mg) {
        if (mg[5][7] == 2) {
            return true;
        } else {
            if (mg[i][j] == 0) {
                mg[i][j] = 2;
                if (MiGong(i + 1, j, mg)) {
                    return true;
                } else if (MiGong(i, j + 1, mg)) {
                    return true;
                } else if (MiGong(i - 1, j, mg)) {
                    return true;
                } else if (MiGong(i, j - 1, mg)) {
                    return true;
                } else {
                    mg[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    @Test
    //八皇后问题（回溯法）
    public void EightQueen() {
        Check(0);
        System.out.println(count);
    }
    public void Check(int n) {//递归调用Check(int n)方法实现回溯
        if (n == 8) {
            print();
            count++;
        } else {
            for (int i = 0; i < 8; i++) {
                array[n] = i;
                if (judge(n)) {
                    Check(n + 1);
                }
            }
        }

    }
    public boolean judge(int n) {//判断第n个皇后于前面的皇后是否冲突
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }
    public void print() {//输出皇后的解
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Test
    //汉诺塔问题（回溯法）
    public void HannoTest() {
        Hanno("A", "B", "C", 12);
        System.out.println("计算次数为：" + count);
    }
    public void Hanno(String A, String B, String C, int n) {
        if (n == 1) {//只有一个盘的情况
            count++;
            System.out.println("将" + n + "盘从" + A + "柱移动到" + C + "柱");
        } else {
            count++;
            Hanno(A, C, B, n - 1);//将n-1个盘借助C柱从A柱移动到B柱
            System.out.println("将" + n + "盘从" + A + "柱移动到" + C + "柱");//n-1个盘都在B柱的情况，直接把盘片从A柱移动到C柱
            Hanno(B, A, C, n - 1);//把BA柱互换位置，重复操作
        }
    }

    @Test
    public void frogTest(){
        up(10);
        System.out.println(count);
        long result = jumpStep(10);
        System.out.println("----------------------------");
        System.out.println(result);


    }
    public void up(int n){
        if(n == 0){
            count++;
            return;
        }else{
            if(n > 0){
                up(n - 1);
                up(n - 2);
            }
        }
    }
    public long jumpStep(int n){
        if(n < 1){ //没有台阶返回0
            return 0;
        }
        if(n == 1){ //一个台阶一种跳法
            return 1;
        }
        if(n == 2){ //两个台阶两种跳法
            return 2;
        }
        return jumpStep(n-1) + jumpStep(n-2); //n个台阶f(n-1)+f(n-2)种跳法
    }

}

//队列的定义和操作
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
class Boy{
    public int no;
    public Boy next;

    public Boy(int no){
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
//创建环形单向链表
class CircleLink{
    public Boy first = null;
    //按照输入的结点个数创建环形链表
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("至少需要1个小孩！");
            return;
        }
        Boy curboy = null;
        for(int i = 1; i <= nums; i++){
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.next = first; //确定第一个结点
                curboy = first;
            }else {
                curboy.next = boy;
                boy.next = first;
                curboy = boy;
            }
        }
    }
    //遍历环形链表
    public void printCL(){
        if(first == null){
            System.out.println("环形链表为空！");
            return;
        }
        Boy boy = first;
        while(true){
            System.out.println(boy);
            if(boy.next != first){
                boy = boy.next;
            }else {
                break;
            }
        }
    }
    //解决约瑟夫问题
    public void josephe(int num){
        Boy curboy = null;
        if(first == null){
            System.out.println("环形链表为空！");
            return;
        }else {
            curboy = getLast();
        }
        while(curboy != first){
            for(int i = 0; i < num - 1; i++){
                first = first.next;
                curboy = curboy.next;
            }
            System.out.println(first);
            first = first.next;
            curboy.next = first;
        }
        System.out.println(curboy);
    }
    //获取环形链表的最后一个结点
    public Boy getLast(){
        if(first == null){
            System.out.println("环形链表为空！");
            return null;
        }
        Boy curboy = first;
        while(curboy.next != first){
            curboy = curboy.next;
        }
        return curboy;
    }
}
//栈的操作
class ArrayStack{
    private int maxSize;
    private int top = -1;
    private Object[] stack = null;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new Object[maxSize];
    }
    //判断栈满
    public boolean isFull(){
        return top == (maxSize - 1);
    }
    //判断栈空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(Object value){
        if(!this.isFull()){
            this.stack[++top] = value;
        }else{
            System.out.println("栈满！");
            return;
        }
    }
    //出栈
    public Object pop(){
        if(this.isEmpty()){
            throw new RuntimeException("栈空");
        }else {
            return this.stack[top--];
        }
    }
    //遍历栈
    public void printStack(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        for(int i = this.top; i >= 0; i--){
            System.out.println("栈元素[" + i + "]：" + this.stack[i]);
        }
    }
    //返回操作符的优先级
    public int priority(char ch){
        switch (ch){
            case '*':
            case '/':
                return 0;
            case '+':
            case '-':
                return 1;
            default:
                break;
        }
        return -1;
    }
    //判断是不是运算符
    public boolean isOperator(char oper){
        return oper == '*' || oper == '/' || oper == '+' || oper == '-' || oper == '(' || oper == ')';
    }
    //计算
    public float calculator(float num1 ,float num2, char oper){

        switch (oper){
            case '*':
                return num1 * num2;
            case '/':
                return (float)num2 / (float) num2;
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            default:
                break;
        }
        return -1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public Object[] getStack() {
        return stack;
    }

    public void setStack(Object[] stack) {
        this.stack = stack;
    }
}
