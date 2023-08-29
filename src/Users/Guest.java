package Users;

import Database.DBObj;

import java.sql.Connection;

public class Guest {

    public  Guest()
    {

    }

    public void addUser(DBObj dbObj, Connection con, String userId, String name, String emailId, String mobile, String address) {
        try {
            boolean flag = false;

            flag = dbObj.executeSP("pAddUser", con, userId, name, emailId, mobile, address);

            if (flag) {
                System.out.println("Record added successfully !.....");
            } else {
                System.out.println("Unable to add Record !.....");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

