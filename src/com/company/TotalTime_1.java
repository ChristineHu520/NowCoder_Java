package com.company;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @author ChristineHu
 * @date 2021-03-24 10:33
 */
public class TotalTime_1 {
    public static void main(String[] args) {
        System.out.println("请输入密码：");

        Scanner sc = new Scanner(System.in);
        String secret = sc.next();
        int sum = totalTimes(secret);
        System.out.println("总共时间：" + sum);
    }

    public static int key_index(char password1){
        char[][] array = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r'}, {'s', 't', 'u'}, {'v', 'w', 'x'}, {'y', 'z'}};
        int index = 0;
        for (int i = 0;i< array.length;i++) {
                for(int j = 0;j<array[i].length;j++){
                    if (array[i][j] == password1) {
                        index = i;
                        break;
                    }
            }
        }
        return index;
    }
    public static int totalTimes(String str) {
        int sum = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num1 = key_index(chars[i]);
            if (num1 != -1){
                if(i == 0)
                    sum += 1;
                else {
                    int num2 = key_index(chars[i-1]);
                    if(num1 == num2 && chars[i] != chars[i-1]){
                        sum += 2;
                    }
                    else if(num1 != num2 && chars[i] != chars[i-1])
                        sum += 1;
                    else
                        continue;
                }
            }
        }
        return sum;
    }
}
