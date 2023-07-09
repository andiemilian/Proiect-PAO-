package repository;

import config.DbConnection;
import models.ActionMaster;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ActionMasterRepository {

    public void addActionMaster(ActionMaster actionMaster) {
        String query = "insert into driver values (null, ?, ?, ?, ?, ?)";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, actionMaster.getName());
            statement.setDouble(2, actionMaster.getAge());
            statement.setString(3, actionMaster.getEmail());
            statement.setString(4, String.valueOf(actionMaster.getYearsofActivity()));
            statement.setString(5, String.valueOf(actionMaster.getNumberofActionsAttended()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateEmail(ActionMaster actionMaster, String email) {
        String query = "update `actionMaster` set `email` = ? where `id` = ?;";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, email);
            statement.setDouble(2, actionMaster.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteActionMaster(ActionMaster actionMaster) {
        String query = "delete from `actionMaster` where `id` = ?;";
        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.setDouble(1, actionMaster.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, ActionMaster> getAllAcitonMasters() {
        Map<Integer, ActionMaster> map = new HashMap<Integer, ActionMaster>();
        String query = "select * from actionMaster";
        try{
            PreparedStatement preparedStatement = DbConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ActionMaster actionMaster = new ActionMaster();
                Integer id = resultSet.getInt(1);
                actionMaster.setId(id);
                actionMaster.setName(resultSet.getString(2));
                actionMaster.setAge(resultSet.getInt(3));
                actionMaster.setEmail(resultSet.getString(4));
                actionMaster.setPhoneNumber(resultSet.getString(5));
                actionMaster.setYearsofActivity(resultSet.getInt(6));
                actionMaster.setNumberofActionsAttended(resultSet.getInt(7));

                map.put(id, actionMaster);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
