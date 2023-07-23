package 二工大PTA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class _7_10简单计算器 {

    public static Map<Character, Integer> map = new HashMap<>();
    // 自定义运算符的优先级 此题不用按优先级算 要把‘*’ ‘/’ 设成0
    static {
        map.put('*', 1);
        map.put('/', 1);
        map.put('+', 0);
        map.put('-', 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infixExp = sc.nextLine(); //中缀表达式
        Stack<Integer> numStack = new Stack<>(); // 操作数栈
        Stack<Character> operatorStack = new Stack<>(); // 运算符栈
        StringBuilder num = new StringBuilder(); //留着拼数字

        //扫描表达式
        for (int i = 0; i < infixExp.length(); i++) {
            char c = infixExp.charAt(i);
            if (c >= '0' && c <= '9') {
                // 可能是操作数的某一部分，还要继续扫描
                num.append(c);
            } else if ( c == '=') {
                // 压入最后一个操作数
                numStack.push(Integer.parseInt(String.valueOf(num)));
            } else if (map.get(c) != null) {
                //读取数字完成，放入操作数栈
                numStack.push(Integer.parseInt(String.valueOf(num)));
                num = new StringBuilder();
                // 遇到运算符：依次弹出栈中优先级 ‘大于’ 或 ‘等于’ 当前运算符优先级的
                while (!operatorStack.isEmpty()
                        && map.get(operatorStack.peek()) >= map.get(c)) {
                    // 弹出一个运算符则要从操作数栈弹出两个操作数，计算后压栈
                    Character op = operatorStack.pop();
                    Integer right = numStack.pop();
                    Integer left = numStack.pop();
                    if (op.equals('+')) {
                        numStack.push(left + right);
                    } else if (op.equals('-')) {
                        numStack.push(left - right);
                    } else if (op.equals('*')) {
                        numStack.push(left * right);
                    } else if (op.equals('/')) {
                        if (right == 0) {
                            System.out.println("ERROR");
                            return;
                        }
                        numStack.push(left / right);
                    }
                }
                operatorStack.push(c);
            } else {
                //非法字符
                System.out.println("ERROR");
                return;
            }
        }
        while (!operatorStack.isEmpty()) {
            Character op = operatorStack.pop();
            Integer right = numStack.pop();
            Integer left = numStack.pop();
            if (op.equals('+')) {
                numStack.push(left + right);
            } else if (op.equals('-')) {
                numStack.push(left - right);
            } else if (op.equals('*')) {
                numStack.push(left * right);
            } else if (op.equals('/')) {
                if (right == 0) {
                    System.out.println("ERROR");
                    return;
                }
                numStack.push(left / right);
            }
        }
        System.out.println(numStack.pop());

    }
}
