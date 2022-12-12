package org.example;

import java.util.Scanner;
import java.sql.*;

public class Register {
    String url = "jdbc:mysql://localhost:3306/javaproject";
    String user = "root";
    String pass = "Root";
    String firstName;
    String lastName;
    String userName ;
    String passWord;
    String passWordNew;

    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    public void userNameValidate(){

        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter your username : ");


        try {
            String usernameValidate = "SELECT * FROM user WHERE user_name=?";
            Connection connection = DriverManager.getConnection(url,user,pass);
            preparedStatement = connection.prepareStatement(usernameValidate);
            userName = scanner.nextLine();
            preparedStatement.setString(1,userName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("Username Already Exists!");
                System.out.println("Please enter different username : ");
                userName = scanner.nextLine();
                preparedStatement.setString(1,userName);
                resultSet=preparedStatement.executeQuery();
            }





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getReg(){


        try {

            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            System.out.println("Register\n");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your first name : ");
            firstName = input.nextLine();
            System.out.println("Enter your last name : ");
            lastName = input.nextLine();

            userNameValidate();

            System.out.println("Enter your password : ");
            passWord = input.nextLine();
            do {
                System.out.println("Reenter your password : ");
                passWordNew = input.nextLine();
            }while (!(passWord.equals(passWordNew)));


            String query = "INSERT INTO user(first_name, last_name, user_name, password) VALUES('" +firstName+"', '"+lastName+"', '"+ userName +"', '"+ passWord+"');";
            statement.executeUpdate(query);
            connection.close();
            System.out.println("successfully registered...\n");
            System.out.println("Do you want to log now(y/n) : ");
            char option = input.next().charAt(0);

            switch (option){
                case 'y':
                    Main login = new Main();
                    login.getDashboard();
                    break;
                case 'n':
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("invalid");
                    break;
            }


        }catch (Exception e){
            System.out.println(e);
        }

    }
}
