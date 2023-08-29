package Users;

import Database.DBObj;

import java.security.PublicKey;
import java.sql.CallableStatement;
import java.sql.Connection;

public class Admin {
    private String adminId;
    private String adminName;
    private String mobile;
    private String emailId;

   public Admin()
    {

    }

    public boolean addAdmin(DBObj dbObj, Connection con, String userId, String name, String emailId, String mobile, String address )
    {
        boolean flag = false;

        flag = dbObj.executeSP("pAddAdmin", con, userId, name, emailId, mobile, address);
        
        return  flag;

    }
}
