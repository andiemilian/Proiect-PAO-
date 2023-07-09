package repository;

import config.DbConnection;
import models.ActionHouse;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ActionHouseRepository {

    public void addActionHouse(ActionHouse actionHouse) {
        String query = "insert into actionhouse values (null, ?, ?, ?);";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, actionHouse.getName());
            statement.setString(3, actionHouse.getAddress());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteActionHouse(ActionHouse actionHouse) {
        String query = "delete from `actionHouse` where `id` = ?;";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, actionHouse.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateAddress(ActionHouse actionHouse, String address) {
        String query = "update `actionHouse` set `address` = ? where `id` = ?;";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, address);
            statement.setInt(2, actionHouse.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, ActionHouse> getAllActionHouses() {
        Map<Integer, ActionHouse> map = new HashMap<Integer, ActionHouse>();
        String query = "select * from actionhouse;";
        try{
            PreparedStatement preparedStatement = DbConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ActionHouse actionHouse = new ActionHouse();
                Integer id = resultSet.getInt(1);
                actionHouse.setId(id);
                actionHouse.setName(resultSet.getString(2));
                actionHouse.setAddress(resultSet.getString(4));
                map.put(id, actionHouse);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

}
