package org.example;

import java.sql.*;
import java.util.Scanner;

public class Product {
    String url = "jdbc:mysql://localhost:3306/javaproject";
    String usr = "root";
    String pass = "Root";
    public void newProduct(){
        try {
            //get data
            String movieName;
            String category;
            String language;
            System.out.println("Enter movie name : ");
            Scanner input = new Scanner(System.in);
            movieName = input.nextLine();
            System.out.println("Enter category : ");
            category = input.nextLine();
            System.out.println("Enter language : ");
            language = input.nextLine();


            if(!(movieName.isEmpty() && category.isEmpty() && language.isEmpty())){
                String sql = "insert into movie(movie_name, category, language) values('"+movieName+"', '"+category+"', '"+language+"');";

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
                newProduct();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    public void removeProduct(){
        try {
            //get data
            String movieName;
            int movieId;

            System.out.println("Enter movie name : ");
            Scanner input = new Scanner(System.in);
            movieName = input.nextLine();
            System.out.println("Enter movie id : ");
            movieId = input.nextInt();



            if(!(movieName.isEmpty() && movieId == 0 )){
                String sql = "delete from movie where movie_id = "+movieId+" and movie_name = '"+movieName+"';";

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
                removeProduct();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    public void showProduct(){

        try {
            String sql ="SELECT * from movie";
            Connection connection = DriverManager.getConnection(url, usr, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            String movieName;
            int movieId;
            String category;
            String language;
            System.out.println("----------------------------------------------------------------");
            System.out.println("MOVIE ID |      MOVIE NAME |        CATEGORY |        LANGUAGE");
            System.out.println("----------------------------------------------------------------");
            while(resultSet.next()){
                movieId = resultSet.getInt(1);
                movieName = resultSet.getString(2);
                category = resultSet.getString(3);
                language = resultSet.getString(4);


                System.out.printf("%03d      | %15s | %15s | %15s    %n",movieId,movieName,category,language);
            }
            Dashboard dashboard = new Dashboard();
            dashboard.sayHello();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
