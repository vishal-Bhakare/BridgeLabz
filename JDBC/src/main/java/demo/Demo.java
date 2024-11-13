package demo;

import com.mysql.cj.conf.DatabaseUrlContainer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

public class Demo {

    private static final String URL = "jdbc:mysql://localhost:3307/bridgelab";
    private static final String USER = "root";
    private static final String PASSWARD = "root";

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWARD);
    }

    public static void createTable() {

        String company = "Create table if not exists company(" + "id INT primary key Auto_Increment ," +
                "name Varchar(50) ,"
                + "address varchar(50) ," +
                "mobile Long ," +
                "city varchar(50), " +
                "pincode Int )";

        try (Connection conn = connect();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(company);
            System.out.println("Table Created SuccessFully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void insertCompany(String name, String address, Long mobile, String city, int pincode) {

        String insert = "Insert Into company(name, address , mobile, city, pincode) values (?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement ps =   conn.prepareStatement(insert)) {
            ps.setString(1,name);
            ps.setString(2,address);
            ps.setLong(3,mobile);
            ps.setString(4,city);
            ps.setInt(5,pincode);
            ps.executeUpdate();
            System.out.println("Company Details Added SuccessFully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        Demo.createTable();
        Demo.insertCompany("BRIDGELABZ","MH",9823729409l,"PUNE",441221);

    }


}
