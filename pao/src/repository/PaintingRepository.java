package repository;

import config.DbConnection;
import models.Painting;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PaintingRepository {

    public void addPainting(Painting painting) {
        String query = "insert into painting values (null, ?, ?, ?, ?, ?);";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, painting.getName());
            statement.setDouble(2, painting.getPrice());
            statement.setString(3, String.valueOf(painting.getNumberofOwners()));
            statement.setString(4, String.valueOf(painting.getYearofCreation()));
            statement.setString(5, String.valueOf(painting.getWeight()));
            statement.setString(6, painting.getTypeOfpaint());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePrice(Painting painting, Float price) {
        String query = "update `painting` set `price` = ? where `id` = ?;";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setFloat(1, price);
            statement.setInt(2, painting.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletePainting(Painting painting) {
        String query = "delete from `painting` where `id` = ?;";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, painting.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Painting> getAllPainting() {
        Map<Integer, Painting> map = new HashMap<Integer, Painting>();
        String query = "select * from painting;";
        try{
            PreparedStatement preparedStatement = DbConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Painting painting = new Painting();
                Integer id = resultSet.getInt(1);
                painting.setId(id);
                painting.setName(resultSet.getString(2));
                painting.setPrice(resultSet.getFloat(3));
                painting.setYearofCreation(resultSet.getInt(4));
                painting.setNumberofOwners(resultSet.getInt(5));
                painting.setWeight(resultSet.getInt(6));
                painting.setTypeOfpaint(resultSet.getString(7));
                map.put(id, painting);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

}

