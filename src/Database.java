import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<Path> getPaths()
    {
        ArrayList<Path> result = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from path");
            while(rs.next())
            {
                result.add(new Path(rs.getString(1), rs.getString(2)));
            }
            ArrayList<Path> ordered = new ArrayList<>();
            Path path = result.stream().filter(p -> p.getFromCity().equals("Istanbul")).findFirst().get();
            ordered.add(path);
            String next_city = "";
            while (true)
            {
                for (Path p2 : result)
                {
                    if (p2.getFromCity().equals(path.getToCity()))
                    {
                        path = p2;
                        next_city = p2.getToCity();
                        ordered.add(p2);
                        break;
                    }
                }
                if (next_city.equals("Ankara"))
                    break;
            }
            return ordered;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }


    public Location getLocation(int locationId)
    {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from location where id=" + locationId);
            rs.next();

            return new Location(rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getInt(6));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
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
                    rs.getFloat(3),     getLocation(rs.getInt(4)));

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
