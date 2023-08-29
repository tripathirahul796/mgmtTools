package Database;

import java.sql.*;

public class DBObj {
    private  Connection con;
    private  String dbInstance;
    private  String userName;
    private  String pwd;
    private  String dbName;
    public CallableStatement stmt;
    private String pAddUser;
    private String userId;
    private String name;
    private String emailId;
    private String mobile;
    private String address;

    public DBObj(String dbInstance,String userName,String pwd,String dbName)
    {
        this.dbInstance = dbInstance;
        this.dbName = dbName;
        this.userName = userName;
        this.pwd = pwd;

    }

    public DBObj() {

    }

    public  Connection requestConnection()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String url = "jdbc:sqlserver://"+dbInstance+":1433;databaseName="+dbName+";user="+userName+";password="+pwd;
             con = DriverManager.getConnection(url);
            System.out.println("successfully connected");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }

    public boolean executeSP(String spName, Connection con)
    {
        boolean flag = false;
        try
        {
            stmt = con.prepareCall("{ call"+spName+" }");
            stmt.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return flag;


    }

    /**
     * @param spName
     * @param userId
     * @param name
     * @param emailId
     * @param mobile
     * @param address
     * @return
     */
    public boolean executeSP(String spName,Connection con, String userId, String name, String emailId, String mobile, String address) {
        boolean flag = false;
        try
        {
            stmt = con.prepareCall("{ call"+spName+" (?,?,?,?,?) }");
            stmt.setString(1, userId);
            stmt.setString(2, name);
            stmt.setString(3, emailId);
            stmt.setString(4, mobile);
            stmt.setString(5, address);
            flag = stmt.execute();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return flag;
    }

    public CallableStatement executeSP(Connection con, String userId, String name, String emailId, String mobile)
    {
        boolean flag;
        try
        {
            System.out.println("Connecting to DB...");

            if (userId =="" && name == "" && emailId =="" && mobile == "")
            {
                stmt = con.prepareCall("{ call pGetAllUserRecord }");
            }
            else {
                stmt = con.prepareCall("{ call pGetUserRecord (?,?,?,?) }");
                stmt.setString(1, userId);
                stmt.setString(2, name);
                stmt.setString(3, emailId);
                stmt.setString(4, mobile);
            }
            stmt.execute();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return stmt;
    }
}
