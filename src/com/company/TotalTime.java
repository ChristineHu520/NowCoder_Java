package com.company;

/**
 * @author ChristineHu
 * @date 2021-03-24 9:36
 */

/***
 * 问题描述：用户输入密码，同一按钮有3个字母，第一个字母1秒，不同字母在同一按钮需等待2秒
 */
import java.util.Scanner;

public class TotalTime {

    public static void main(String[] args) {
        System.out.println("请输入密码：");

        Scanner sc = new Scanner(System.in);
        String secret = sc.next();
        int sum = totalTimes(secret);
        System.out.println("总共时间：" + sum);
    }

    public static int totalTimes(String str) {

        int sum = 0;
        char[][] array = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r'}, {'s', 't', 'u'}, {'v', 'w', 'x'}, {'y', 'z'}};

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array[j].length; k++) {

                    if (chars[i] == array[j][k]) {
                        sum += (k + 1);
                        int k1 = k;
                        if (chars[i + 1] == array[j][k]) {
                            int k2 = k;
                            if (k2 == k1) {
                                sum += 2;
                            }
                        }
                    }
                }
            }
        }

        return sum;
    }
}

