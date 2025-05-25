import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/subdivision_security?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean registerCarOwner(CarOwner owner) {
        String sql = "INSERT INTO car_owners (plate_number, name, address) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, owner.getPlateNumber());
            stmt.setString(2, owner.getName());
            stmt.setString(3, owner.getAddress());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CarOwner findCarByPlate(String plateNumber) {
        String sql = "SELECT * FROM car_owners WHERE plate_number = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plateNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CarOwner(
                    rs.getString("plate_number"),
                    rs.getString("name"),
                    rs.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CarOwner> getAllCarOwners() {
        List<CarOwner> owners = new ArrayList<>();
        String sql = "SELECT * FROM car_owners";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                owners.add(new CarOwner(
                    rs.getString("plate_number"),
                    rs.getString("name"),
                    rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owners;
    }
}