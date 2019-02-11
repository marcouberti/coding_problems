package dailycodingproblem;

/*
This problem was asked by Amazon.

Implement a stack that has the following methods:

push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time.
 */

import java.util.Stack;

public class Problem_43 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(5);
        System.out.println(myStack.pop());
        System.out.println("------------------------");

        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        //System.out.println(myStack.pop());
        System.out.println("------------------------");

        myStack.push(5);
        myStack.push(6);
        myStack.push(5);
        myStack.push(68);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.max());
        myStack.pop();
        System.out.println(myStack.max());
        myStack.pop();
        System.out.println(myStack.max());
        myStack.pop();
        System.out.println(myStack.max());
        myStack.pop();
        System.out.println(myStack.max());
        myStack.pop();
        System.out.println(myStack.max());
        myStack.pop();
        System.out.println("------------------------");
    }


    static class MyStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> max = new Stack<>();

        int pop() {
            max.pop();
            return stack.pop();
        }

        void push(int val) {
            stack.push(val);
            if(max.isEmpty()) max.push(val);
            else max.push(Math.max(val, max.peek()));
        }

        int max() {
            return max.peek();
        }
    }

}