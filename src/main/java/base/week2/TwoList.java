package base.week2;

/**
 * 双链表
 * @author youtiaoguagua
 * @date 2020/9/19 23:48
 *实现一个双链表，双链表初始为空，支持5种操作：
 * (1) 在最左侧插入一个数；
 * (2) 在最右侧插入一个数；
 * (3) 将第k个插入的数删除；
 * (4) 在第k个插入的数左侧插入一个数；
 * (5) 在第k个插入的数右侧插入一个数
 * 现在要对该链表进行M次操作，进行完所有操作后，从左到右输出整个链表。
 * 注意:题目中第k个插入的数并不是指当前链表的第k个数。例如操作过程中一共插入了n个数，则按照插入的时间顺序，这n个数依次为：第1个插入的数，第2个插入的数，…第n个插入的数。
 * 输入格式
 * 第一行包含整数M，表示操作次数。
 * 接下来M行，每行包含一个操作命令，操作命令可能为以下几种：
 * (1) “L x”，表示在链表的最左端插入数x。
 * (2) “R x”，表示在链表的最右端插入数x。
 * (3) “D k”，表示将第k个插入的数删除。
 * (4) “IL k x”，表示在第k个插入的数左侧插入一个数。
 * (5) “IR k x”，表示在第k个插入的数右侧插入一个数。
 * 输出格式
 * 共一行，将整个链表从左到右输出。
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 * 输入样例：
 * 10
 * R 7
 * D 1
 * L 3
 * IL 2 10
 * D 3
 * IL 2 7
 * L 8
 * R 9
 * IL 4 7
 * IR 2 2
 * 输出样例：
 * 8 7 7 3 2 9
 */
public class TwoList {
    public static void main(String[] args) {

    }
}
