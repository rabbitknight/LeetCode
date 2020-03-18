package net.rabbitknight.leetcode.core;

/**
 * https://leetcode-cn.com/problems/print-in-order/
 * <p>
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 * public void one() { print("one"); }
 * public void two() { print("two"); }
 * public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * <p>
 * 注意:
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * <p>
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 * 解决:
 * 其实这题的意思就是无论我线程咋启动，始终要保持123这样的打印。 强调线程的顺序执行。
 * 不用纠结这个方法咋定义成这个鬼样子。。
 * 本题目使用wait notify机制，每个1线程监听1 2线程监听2 类似处理
 */
public class Sub1114 {


    private int order = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (order != 1) {
                this.wait();
            }
            order = 2;
            this.notifyAll();

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (order != 2) {
                this.wait();
            }
            order = 3;
            this.notifyAll();

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (order != 3) {
                this.wait();

                order = 1;
                notifyAll();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    public static void main(String[] args) {
    }
}
