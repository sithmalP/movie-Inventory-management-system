package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Already have an account(y/n) : ");
        char option = input.next().charAt(0);
        switch (option){
            case 'n':
                Register reg = new Register();
                reg.getReg();
                break;
            case 'y':
                getDashboard();
                break;
            default:
                System.out.println("invalid input");

                break;
        }

    }
    public static void getDashboard(){
        Login validateLogin =new Login();
        while (validateLogin.runLogin()){
            Dashboard dashboard = new Dashboard();
            dashboard.sayHello();
            break;

       }


    }

}
