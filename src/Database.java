import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class Database
{
    private static Database databaseInstance = null;
    private static String databaseIp;
    private static String databaseUserName;
    private static String databasePassword;
    private Connection con;

    // singleton pattern for easy database access
    public static Database getInstance() {
        if(databaseInstance == null) {
            databaseInstance = new Database();
        }

        return databaseInstance;
    }

    public static void setCredentials(String ip, String username, String password)
    {
        databaseIp = ip;
        databaseUserName = username;
        databasePassword = password;
    }

    private Database()
    {
        try {
            // initialize connection
            con=DriverManager.getConnection(databaseIp,databaseUserName,databasePassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer(int customerId)
    {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from customer where id=" + customerId);
            rs.next();
            return new Customer(customerId, rs.getString(2),
                    rs.getFloat(3), rs.getString(4));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void close()
    {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean buyProduct(Customer customer, String productName)
    {
        try {
            float productCost = getProductCost(productName);
            if (productCost <= customer.getMoney() && isInStock(productName))
            {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE customer SET money = money - " + productCost +
                        " WHERE id = " + customer.getId());
                stmt.executeUpdate("UPDATE product SET stock_count = stock_count - 1 WHERE product.name = \""
                        + productName + "\"");
                customer.setMoney(customer.getMoney() - productCost);
                return true;
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean isInStock(String productName)
    {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select stock_count from product where name=\"" + productName + "\"");
            rs.next();
            return rs.getInt(1) > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }


    public float getProductCost(String productName)
    {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select cost from product where name=\"" + productName + "\"");
            rs.next();
            return rs.getFloat(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }


}
