package gameClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class responsible for data analysis from DataBase.
 * Reads all required data, updates, and saves it.
 */
public class DB_Info {

    public static final String jdbcUrl="jdbc:mysql://db-mysql-ams3-67328-do-user-4468260-0.db.ondigitalocean.com:25060/oop?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
    public static final String jdbcUser="student";
    public static final String jdbcUserPassword="OOP2020student";

    public static int id;

    public static int getNumGames() {
        int ind =0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcUserPassword);
            Statement statement = connection.createStatement();
            String allCustomersQuery = "SELECT * FROM Logs where userID="+id;
            ResultSet resultSet = statement.executeQuery(allCustomersQuery);
            while(resultSet.next()) {
                System.out.println(ind+") Id: " + resultSet.getInt("UserID")+", level: "+resultSet.getInt("levelID")+", score: "+resultSet.getInt("score")+", moves: "+resultSet.getInt("moves")+", time: "+resultSet.getDate("time"));
                ind++;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("Vendor Error: " + sqle.getErrorCode());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ind;
    }

    public static int getCurrLevel() {
        int ind =0;
        int level=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcUserPassword);
            Statement statement = connection.createStatement();
            String allCustomersQuery = "SELECT * FROM Logs where userID="+id;
            ResultSet resultSet = statement.executeQuery(allCustomersQuery);
            while(resultSet.next()) {
                System.out.println(ind+") Id: " + resultSet.getInt("UserID")+", level: "+resultSet.getInt("levelID")+", score: "+resultSet.getInt("score")+", moves: "+resultSet.getInt("moves")+", time: "+resultSet.getDate("time"));
                ind++;
                if(resultSet.getInt("levelID")>level) {
                    level=resultSet.getInt("levelID");
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("Vendor Error: " + sqle.getErrorCode());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(ind);
        return level;
    }

    public static int getBestScore(int level) {
        int ind = 0;
        int bestScore = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcUserPassword);
            Statement statement = connection.createStatement();
            String allCustomersQuery = "SELECT * FROM Logs where userID="+id;
            ResultSet resultSet = statement.executeQuery(allCustomersQuery);
            while(resultSet.next()) {
                System.out.println(ind+") Id: " + resultSet.getInt("UserID")+", level: "+resultSet.getInt("levelID")+", score: "+resultSet.getInt("score")+", moves: "+resultSet.getInt("moves")+", time: "+resultSet.getDate("time"));
                ind++;
                if(resultSet.getInt("levelID") == level) {
                    if(resultSet.getInt("score") > bestScore) {
                        bestScore = resultSet.getInt("score");
                    }
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("Vendor Error: " + sqle.getErrorCode());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(ind);
        return bestScore;
    }

    public static int getPos(int level) {
        int ind = 0;
        int score = 0;
        int pos = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcUserPassword);
            Statement statement = connection.createStatement();
            String allCustomersQuery = "SELECT * FROM Logs;";
            ResultSet resultSet = statement.executeQuery(allCustomersQuery);
            while(resultSet.next()) {
                System.out.println(ind+") Id: " + resultSet.getInt("UserID")+", level: "+resultSet.getInt("levelID")+", score: "+resultSet.getInt("score")+", moves: "+resultSet.getInt("moves")+", time: "+resultSet.getDate("time"));
                ind++;
                if(resultSet.getInt("levelID") == level && resultSet.getInt("UserID") == id) {
                    if(resultSet.getInt("score") > score) {
                        score = resultSet.getInt("score");
                        pos = ind;
                    }
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("Vendor Error: " + sqle.getErrorCode());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(ind);
        return pos;
    }
}
