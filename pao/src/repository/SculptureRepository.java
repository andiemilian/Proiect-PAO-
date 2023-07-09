package repository;

import config.DbConnection;
import models.Painting;
import models.Sculpture;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SculptureRepository {

    public void addSculpture(Sculpture sculpture) {
        String query = "insert into sculpture values (null, ?, ?, ?, ?, ?);";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, sculpture.getName());
            statement.setDouble(2, sculpture.getPrice());
            statement.setString(3, String.valueOf(sculpture.getNumberofOwners()));
            statement.setString(4, String.valueOf(sculpture.getYearofCreation()));
            statement.setString(5, String.valueOf(sculpture.getWeight()));
            statement.setString(6, sculpture.getMaterial());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePrice(Sculpture sculpture, Float price) {
        String query = "update `sculpture` set `price` = ? where `id` = ?;";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setFloat(1, price);
            statement.setInt(2, sculpture.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteSculpture(Sculpture sculpture) {
        String query = "delete from `sculpture` where `id` = ?;";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, sculpture.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Sculpture> getAllSculpture() {
        Map<Integer, Sculpture> map = new HashMap<Integer, Sculpture>();
        String query = "select * from sculpture;";
        try{
            PreparedStatement preparedStatement = DbConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sculpture sculpture = new Sculpture();
                Integer id = resultSet.getInt(1);
                sculpture.setId(id);
                sculpture.setName(resultSet.getString(2));
                sculpture.setPrice(resultSet.getFloat(3));
                sculpture.setYearofCreation(resultSet.getInt(4));
                sculpture.setNumberofOwners(resultSet.getInt(5));
                sculpture.setWeight(resultSet.getInt(6));
                sculpture.setMaterial(resultSet.getString(7));
                map.put(id, sculpture);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

}

