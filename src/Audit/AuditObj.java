package Audit;

import Database.DBObj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class AuditObj {
    public AuditObj() {

    }

    public boolean add(DBObj dbObj, Connection con, String relatedId, String eventName, String desc, String userName) {
        CallableStatement stmt = null;
        boolean bAdd;
        try {
            bAdd = false;
            stmt = con.prepareCall("{call pAddAudit (?,?,?,?) }");
            stmt.setString(1, relatedId);
            stmt.setString(2, eventName);
            stmt.setString(3, desc);
            stmt.setString(4, userName);
            bAdd = stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bAdd;
    }
}