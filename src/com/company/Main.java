package com.company;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

    }

}
class Turing{

    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        int length = sk.nextInt();//Ввод длины ленты
        LinkedList<Integer> lenta = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int b = sk.nextInt();
            lenta.add(b);
        }
        System.out.println(lenta);
        Commands cmd = new Commands(length);
        /*for(int i=0;i<2;i++) {
            for(int j=0;j<length;j++) {
                System.out.println(i+" "+j+" "+cmd.commands[i][j]);
            }
        }*/
        TuringMachine object=new TuringMachine();
        System.out.println(object.some_function(lenta, cmd, length));

    }
}
class TuringMachine{

    public static LinkedList<Integer> some_function (LinkedList<Integer> lenta,Commands com,int length){
        for(int i=0;i<2;i++) {
            for(int j=0;j<length;j++) {
                if(com.commands[i][j]=="R,S1") {
                    System.out.println(lenta);
                    polz(j);
                    if(lenta.get(j)==0) {
                        lenta.remove(j);
                        lenta.add(j, 1);
                    }
                    System.out.println(lenta);
                    polz(j);
                }else if(com.commands[i][j]=="L,S2") {
                    System.out.println(lenta);
                    polz(j);
                    if(lenta.get(j)==2) {
                        lenta.remove(j);
                        lenta.add(j, 3);
                    }
                    System.out.println(lenta);
                    polz(j);
                }
            }
        }
        return lenta;
    }
    public static void polz(int count){
        String p = " ^";
        for(int i = 0; i<count; i++){
            p = "   " + p  ;
        }
        System.out.println(p);
    }

}
class Commands{
    String [][] commands;
    public Commands(int lenta) {
        this.commands=new String[2][lenta];
        for(int j = 0; j<lenta;j++) {
            this.commands[0][j] ="R,S1";

        }
        for(int i =0; i<lenta; i++) {
            this.commands[1][i] = "L,S2";
        }

    }

}
