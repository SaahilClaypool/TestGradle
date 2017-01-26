package hello;
import java.sql.*;
import Util.*;

public class EmbedSQL {
    // data
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    //    String dbName = "C:\\Users\\saahil claypool\\DB";
    String dbName = "DataBase";
    String connectionURL = "jdbc:derby:" + dbName + ";create=true";
   String createString = "CREATE TABLE WISH_LIST  "
  +  "(WISH_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
  +  " WISH_ITEM VARCHAR(32) NOT NULL) " ;


    Connection conn  = null;



    public EmbedSQL (){
        System.out.println("hello world");
    }


    public static void main ( String[] args){
        System.out.println("hello world");
    }

    public int setupDatabase () {
        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.toString());
        }
        // boot database
        try {
            conn = DriverManager.getConnection(connectionURL);
        } catch (Throwable e){
            e.printStackTrace();
            System.out.println("error with database connection");

        }
        return 1;
    }

    // initial sql
    public void interactWithDatabase() {
        try{
            System.out.println("started database");
            Statement s = conn.createStatement();
            if(!WwdUtils.wwdChk4Table(conn)){
                System.out.println(" . . . . . creating table WISH_LIST");
                s.execute(createString);
            }
            System.out.println("PREPARING");
            PreparedStatement psInsert = conn.prepareStatement
                    ("insert into WISH_LIST(WISH_ITEM) values (?)");

            psInsert.setString(1, "answer");
            psInsert.execute();

            System.out.println("inserted into database");

            ResultSet res = s.executeQuery("select  WISH_ITEM\n" +
                    "from WISH_LIST");


            while (res.next()){
                System.out.println(" I wished for "
                        + res.getString(1));
            }

            res.close();

        } catch(Throwable e){
            e.printStackTrace();
        }

    }

    public void shutDown() {
        if (driver.equals("org.apache.derby.jdbc.EmbeddedDriver")) {
            boolean gotSQLExc = false;
            try {
                DriverManager.getConnection("jdbc:derby:;shutdown=true");
            } catch (SQLException se)  {
                if ( se.getSQLState().equals("XJ015") ) {
                    gotSQLExc = true;
                }
            }
            if (!gotSQLExc) {
                System.out.println("Database did not shut down normally");
            }  else  {
                System.out.println("Database shut down normally");
            }
        }
    }

}
