package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Dashboard {
    public void sayHello(){

        System.out.println("\nINVENTORY MANAGEMENT SYSTEM\n");
        System.out.println("         =========          \n\n");
        System.out.println("menu:");
        System.out.println("[1] Add new product");
        System.out.println("[2] Remove product");
        System.out.println("[3] Show all product");
        System.out.println("[4] Add client");
        System.out.println("[5] Remove client");
        System.out.println("[6] Show all clients");
        System.out.println("[7] Update sales");
        System.out.println("[8] Show all sales");
        System.out.println("[9] Exit");

        try {
            System.out.println("\nEnter your choise : ");
            Scanner input = new Scanner(System.in);
            int choise = input.nextInt();

            Product product = new Product();
            Client client = new Client();
            Sale sale = new Sale();
            switch (choise) {
                case 1:
                    product.newProduct();
                    break;
                case 2:
                    product.removeProduct();
                    break;
                case 3:
                    product.showProduct();
                    break;
                case 4:
                    client.newClient();
                    break;
                case 5:
                    client.removeClient();
                    break;
                case 6:
                    client.showClient();
                    break;
                case 7:
                    sale.newSale();
                    break;
                case 8:
                    sale.showSale();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid input");
                    sayHello();


            }
        }catch (Exception e){
            System.out.println("invalid input");
            sayHello();
        }
    }

}
