import Database.DBObj;
import Users.Admin;
import Users.Guest;
import Users.UserObj;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
     static String userName;
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");
        Scanner sc = new Scanner(System.in);
        String wusername = System.getProperty("user.name");
        System.out.println(wusername);
        System.out.println("Please enter user name!");
        userName = sc.next();

        DBObj db= new DBObj("localhost", userName, "sys123","Test2023");
        Connection con =db.requestConnection();

        String choice= "";
        System.out.println("Enter processName...");

        choice = sc.next();

        switch (choice)
        {
            case "AddAdmin":
                System.out.println("Calling addAdmin() function to add details...");
                new Admin().addAdmin(db,con,"admin123","Rajat Tripathi","rajat@gmail.com","12345678", "Delhi India");
                break;
            case "UserDetails":
                System.out.println("Calling getUserDetails() function to get details...");
                new UserObj().getUserDetails(db,con,"rahul12","","","");
                break;
            case "AddGuest":
                System.out.println("Calling the function to get details...");
                new Guest().addUser(db,con,"rajat123","Rajat Tripathi","rajat@gmail.com","12345678", "Delhi India");
                break;
            case "DelUser":
                System.out.println("Calling the function deleteUserDetails() of UserObj to delete details...");
                new UserObj().deleteUserDetails(db,con,"rahul12");
                break;
            default:
                System.out.println("No option found !....");


        }
        }
    }
