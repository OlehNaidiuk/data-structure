package com.naidiuk;

import com.naidiuk.stack.ArrayStack;
import com.naidiuk.stack.Stack;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Stack<String> strings = new ArrayStack<>(20);
        strings.push("sadfg");
        Object str = strings.pop();

    }
}
