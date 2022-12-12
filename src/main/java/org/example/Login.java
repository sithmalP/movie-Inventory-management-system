package org.example;
import java.sql.*;
import java.util.Scanner;



public class Login {

    String url = "jdbc:mysql://localhost:3306/javaproject";
    String usr = "root";
    String pass = "Root";


    public boolean runLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your user name : ");
        String username = input.nextLine();
        System.out.println("Enter your password : ");
        String password = input.nextLine();

        try {
            String sql="SELECT  * FROM user WHERE user_name=? && password=?";
            Connection connection=DriverManager.getConnection(url,usr,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();


            if (username.isEmpty() && password.isEmpty()){
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Please Fill all the blanks !");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                runLogin();
            } else if (resultSet.next()) {
                String usrName = resultSet.getString(2);
                String passWrd = resultSet.getString(4);
                if(username.equals(usrName) && password.equals(passWrd)){

                }else{
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Please Enter Correct Username and Password !");
                    System.out.println("---------------------------------------------------------------------------");
                    runLogin();
                }

            }else {
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Please Enter Correct Username and Password !");
                System.out.println("---------------------------------------------------------------------------");

                runLogin();

            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return true;
    }








}