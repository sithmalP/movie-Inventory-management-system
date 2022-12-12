package org.example;

import java.sql.*;
import java.util.Scanner;

public class Sale {
    String url = "jdbc:mysql://localhost:3306/javaproject";
    String usr = "root";
    String pass = "Root";
    public void newSale(){
        try {
            //get data
            int item;
            int movieId;
            int clientId;
            System.out.println("Enter movie Id  : ");
            Scanner input = new Scanner(System.in);
            movieId = input.nextInt();
            System.out.println("Enter client Id : ");
            clientId = input.nextInt();
            System.out.println("Enter number of items : ");
            item = input.nextInt();


            if(!(movieId == 0 && clientId == 0 && item == 0)){
                String sql = "insert into sale(client_id, movie_id, item) values('"+clientId+"', '"+movieId+"', '"+item+"');";

                Connection connection = DriverManager.getConnection(url, usr, pass);

                Statement statement = connection.createStatement();

                statement.executeUpdate(sql);
                connection.close();
                System.out.println("successfully added\n");
                Dashboard dashboard = new Dashboard();
                dashboard.sayHello();
            }else {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Please Fill all the blanks !");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                newSale();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public void showSale(){

        try {
            String sql ="SELECT * from sale";
            Connection connection = DriverManager.getConnection(url, usr, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            int saleId;
            String movieId;
            String clientId;
            String item;
            System.out.println("-----------------------------------------------------------------");
            System.out.println("SALE ID  |      MOVIE ID   |       CLIENT ID |             ITEM");
            System.out.println("-----------------------------------------------------------------");
            while(resultSet.next()){
                saleId = resultSet.getInt(1);
                movieId = resultSet.getString(2);
                clientId = resultSet.getString(3);
                item = resultSet.getString(4);


                System.out.printf("%03d      | %15s | %15s | %15s    %n",saleId,movieId,clientId,item);
            }
            Dashboard dashboard = new Dashboard();
            dashboard.sayHello();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
