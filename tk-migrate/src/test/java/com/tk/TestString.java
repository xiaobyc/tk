package com.tk;

/**
 * @Classname TestString
 * @Description TODO
 * @Date 2019/9/12 2:17 PM
 * @Created by alex
 */
public class TestString {
    public static void main(String[] args) {
        String str ="0、1、6、9、32、23、84、97";
        String [] ans =str.split("、");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<ans.length;i++){
            stringBuilder.append("@@");
            stringBuilder.append(ans[i]);
        }
        System.out.println(ans.length);
        System.out.println(stringBuilder.toString());
    }
}
