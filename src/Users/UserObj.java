package Users;

import Audit.AuditObj;
import Database.DBObj;
import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class UserObj {
    public UserObj()
    {

    }

    public void getUserDetails(@NotNull DBObj dbObj, Connection con, String userId, String name, String emailId, String mobile)
    {
        CallableStatement stmt =dbObj.executeSP(con,userId,name,emailId,mobile);

        try
        {
            ResultSet res = stmt.getResultSet();
            while(res.next()) {
                System.out.print("User ID : " + res.getString(1) + ", Name : " + res.getString(2)
                        + " Email Id : " + res.getString(3) + " Mobile : " + res.getString(4)
                        + " Address : " + res.getString(5));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public void updateUserDetails( DBObj dbObj, Connection con, String userId, String name, String emailId, String mobile)
    {
        try
        {
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public void deleteUserDetails( DBObj dbObj, Connection con, String userId) throws RuntimeException {
        CallableStatement stmt = null;
        boolean bDel;
        try
        {
            bDel = false;
            stmt = con.prepareCall("{call pDelUser (?) }");
            stmt.setString(1, userId);
            bDel = stmt.execute();
            bDel = new AuditObj().add( dbObj, con, userId, "deleteUser", "Userid " + userId + " deleted.", "Rahul Tripathi");
            System.out.println("Successfully deleted userId = "+userId);
            //else System.out.println("Unable to delete userId ="+userId);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
