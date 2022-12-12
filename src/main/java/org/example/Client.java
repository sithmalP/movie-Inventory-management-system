package org.example;

import java.sql.*;
import java.util.Scanner;

public class Client {
    String url = "jdbc:mysql://localhost:3306/javaproject";
    String usr = "root";
    String pass = "Root";
    public void newClient(){
        try {
            //get data
            String clientName;
            String mobileNum;

            System.out.println("Enter client name : ");
            Scanner input = new Scanner(System.in);
            clientName = input.nextLine();
            System.out.println("Enter mobile number : ");
            mobileNum = input.nextLine();



            if(!(clientName.isEmpty())){
                String sql = "insert into client(client_name, mobile_no) values('"+clientName+"', '"+mobileNum+"');";

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
                newClient();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    public void removeClient(){
        try {
            //get data
            String clientName;
            int clientId;

            System.out.println("Enter client name : ");
            Scanner input = new Scanner(System.in);
            clientName = input.nextLine();
            System.out.println("Enter client id : ");
            clientId = input.nextInt();



            if(!(clientName.isEmpty() && clientId == 0 )){
                String sql = "delete from client where client_id = "+clientId+" and client_name = '"+clientName+"';";

                Connection connection = DriverManager.getConnection(url, usr, pass);

                Statement statement = connection.createStatement();

                statement.executeUpdate(sql);
                connection.close();
                System.out.println("successfully removed\n");
                Dashboard dashboard = new Dashboard();
                dashboard.sayHello();
            }else {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Please Fill all the blanks !");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                removeClient();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    public void showClient(){

        try {
            String sql ="SELECT * from client";
            Connection connection = DriverManager.getConnection(url, usr, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            String clientName;
            int clientId;
            String mobileNum;

            System.out.println("-----------------------------------------------");
            System.out.println("MOVIE ID |     client NAME |   mobile number");
            System.out.println("-----------------------------------------------");
            while(resultSet.next()){
                clientId = resultSet.getInt(1);
                clientName = resultSet.getString(2);
                mobileNum = resultSet.getString(3);



                System.out.printf("%03d      | %15s | %15s    %n",clientId,clientName,mobileNum);
            }

            Dashboard dashboard = new Dashboard();
            dashboard.sayHello();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
