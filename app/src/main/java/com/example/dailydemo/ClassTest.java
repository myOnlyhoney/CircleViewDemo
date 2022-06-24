package com.example.dailydemo;

public class ClassTest {
        public static int get1(){
            return 1;
        }
        public static int return1(int value){
            return value;
        }

    public static void main(String[]args){
        int value = return1(get1());
    }
}
