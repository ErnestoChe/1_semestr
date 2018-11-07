package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

}
class Turing{

    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        int length = sk.nextInt();//Ввод длины ленты
        Scanner sq = new Scanner(System.in);
        String sq1 = sq.nextLine();
        char[]b = sq1.toCharArray();
        LinkedList<Character> lenta = new LinkedList<Character>();
        for (int i = 0; i < length; i++) {
            lenta.add(b[i]);
        }
        Commands cmd = new Commands(length);
        TuringMachine object=new TuringMachine();
        System.out.println(object.changeInLine(lenta, cmd, length));

    }
}
class TuringMachine{

    public static LinkedList<Character> changeInLine(LinkedList<Character> lenta, Commands com, int length) {
        Scanner sk = new Scanner(System.in);
        System.out.println("Введите символ, который хотите поменять");
        char b = sk.nextLine().charAt(0);       //которое хотим менять
        System.out.println("Введите символ, на который хотите поменять");
        char c = sk.nextLine().charAt(0);       //которое меняем
        for (int i = 0; i < 2; i++) {   //проход слева направо, меняя а на б
            for (int j = 0; j < length; j++) {
                if (com.commands[i][j] == "R,S1") { //читаем команду
                    System.out.println(lenta);
                    polz(j);
                    if (lenta.get(j) == b) {
                        lenta.remove(j);    //вставляем на место старой цифры новую
                        lenta.add(j, c);
                        System.out.println(lenta);  //логирование ленты
                        polz(j);                    //ползунок для обозначения
                    }
                }
            }
        }
        for (int k =2-1; 0<=k; k--) {
            for (int a = length-1; a>=0; a--) {     //проход справа налево, меняя a на 0
                if (com.commands[k][a] == "L,S2") {
                    System.out.println(lenta);      //логирование ленты
                    polz(a);                        //ползунок для обозначения
                    if (lenta.get(a) == 'a') {      //считываем "а"
                        lenta.remove(a);            //вставляем на место а нуль
                        lenta.add(a, '0');
                    }
                    System.out.println(lenta);      //логирование ленты
                    polz(a);                        //ползунок для обозначения
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
