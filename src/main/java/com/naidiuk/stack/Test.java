package com.naidiuk.stack;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push("staffed");
        stack.push(312);
        stack.push('A');
        stack.push("sdfasdf");
        stack.push(5253);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
