package fun.hoyouly;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 使用队列实现栈的下列操作：
 */
public class Leetcode_225 {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println("obj.top()   " + obj.top());
        System.out.println("obj.pop  " + obj.pop());
        System.out.println("obj.empty  " + obj.empty());

    }

    static class MyStack {
        //使用两个队列处理
        Queue<Integer> fristQueue;
        Queue<Integer> secondeQueue;
        int top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            fristQueue = new ArrayDeque();
            secondeQueue = new ArrayDeque();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            fristQueue.add(x);
            top = x;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (fristQueue.size() > 1) {
                top = fristQueue.remove();
                secondeQueue.add(top);
            }

            int result = fristQueue.remove();

            Queue tem = fristQueue;
            fristQueue = secondeQueue;
            secondeQueue = tem;

            return result;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return fristQueue.isEmpty() && secondeQueue.isEmpty();
        }
    }
}
