package repository;

import config.DbConnection;
import models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class BidRepository {
    public void addBid(Bid bid) {
        String query = "insert into `bid` values (null, "; //, ?, ?, ?, ?, ?);";
        User user = bid.getUser();
        query = query + user.getId() + ", ";
        ActionHouse actionHouse = bid.getActionHouse();
        query = query + actionHouse.getId() + ", ";
        ActionMaster actionMaster = bid.getActionMaster();
        query = query + actionMaster.getId() + ", ";
        Painting painting = bid.getPainting();
        if (painting != null) {
            query = query + painting.getId() + ", ";
        }
        else {
            query = query + "null, ";
        }
        Sculpture sculpture = bid.getSculpture();
        if (sculpture != null) {
            query = query + sculpture.getId() + ");";
        }
        else {
            query = query + "null);";
        }

        try(PreparedStatement statement = DbConnection.getInstance().prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<Bid> getAllBids(Map<Integer, User> users, Map<Integer, ActionMaster> actionMasters, Map<Integer, ActionHouse> actionHouses, Map<Integer, Painting> paintings, Map<Integer, Sculpture> sculptures) {
        ArrayList<Bid> bids = new ArrayList<>();
        String query = "select * from `bid`;";
        try{
            PreparedStatement preparedStatement = DbConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bid bid= new Bid();
                Integer id = resultSet.getInt(1);
                bid.setUser(users.get(resultSet.getInt(2)));
                bid.setActionHouse(actionHouses.get(resultSet.getInt(3)));
                bid.setActionMaster(actionMasters.get(resultSet.getInt(4)));
                if (resultSet.getInt(5) != 0) {
                    bid.setPainting(paintings.get(resultSet.getInt(5)));
                }
                if (resultSet.getInt(6) != 0) {
                    bid.setSculpture(sculptures.get(resultSet.getInt(6)));
                }
                bids.add(bid);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bids;
    }
    public void getAllBidsbyActionHouse(Integer actionHouseId, Map<Integer, User> users, Map<Integer, ActionMaster> actionMasters, Map<Integer, ActionHouse> actionHouses, Map<Integer, Painting> paintings, Map<Integer, Sculpture> sculptures) {
        String query = "select * from `order` where `actionHouseId` = ?;";
        try{
            PreparedStatement preparedStatement = DbConnection.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, actionHouseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bid bid = new Bid();
                Integer id = resultSet.getInt(1);
                bid.setUser(users.get(resultSet.getInt(2)));
                bid.setActionHouse(actionHouses.get(resultSet.getInt(3)));
                bid.setActionMaster(actionMasters.get(resultSet.getInt(4)));
                if (resultSet.getInt(5) != 0) {
                    bid.setPainting(paintings.get(resultSet.getInt(5)));
                }
                if (resultSet.getInt(6) != 0) {
                    bid.setSculpture(sculptures.get(resultSet.getInt(6)));
                }
                System.out.println(bid);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
