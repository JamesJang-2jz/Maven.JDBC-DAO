package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import models.CarDTO;

public class CarDAO implements InterfaceCarDAO {

    @Override
    public CarDTO findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Cars WHERE id  = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractCarFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CarDTO> findAll() {
        // TODO Auto-generated method stub
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Cars");
            ResultSet rs = ps.executeQuery();
            List<CarDTO> list = new ArrayList<>();

            while (rs.next()) {
                CarDTO car = extractCarFromResultSet(rs);
                list.add(car);
            }
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public CarDTO update(CarDTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection
                    .prepareStatement("UPDATE Cars SET make=?, model=?, color=?, year=?, vin=? WHERE id=?");
            ps.setInt(6, dto.getId());
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setString(3, dto.getColor());
            ps.setInt(4, dto.getYear());
            ps.setString(5, dto.getVin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dto;
    }

    @Override
    public CarDTO create(CarDTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO Cars values (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setInt(4, dto.getYear());
            ps.setString(5, dto.getColor());
            ps.setString(6, dto.getVin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dto;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection
                    .prepareStatement("DELETE FROM Cars WHERE id=?");
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private CarDTO extractCarFromResultSet(ResultSet rs) throws SQLException {
        CarDTO car = new CarDTO();

        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setColor(rs.getString("color"));
        car.setVin(rs.getString("vin"));
        car.setYear(rs.getInt("year"));
        return car;
    }

}