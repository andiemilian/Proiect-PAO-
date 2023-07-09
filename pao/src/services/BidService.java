package services;

import models.*;
import repository.BidRepository;

import java.util.*;

public class BidService {
    private BidRepository bidRepository;

    public BidService() {
        this.bidRepository = new BidRepository();
    }

    public void addBid(Bid bid) {
        bidRepository.addBid(bid);
        System.out.println("The bid was placed successfully.");
    }

    public ArrayList<Bid> getAllBids(Map<Integer, User> users, Map<Integer, ActionMaster> actionMasters, Map<Integer, ActionHouse> actionHouses, Map<Integer, Painting> paintings, Map<Integer, Sculpture> sculptures) {
        return bidRepository.getAllBids(users, actionMasters,actionHouses, paintings, sculptures);
    }
    public void getAllBidsByActionHouse(Scanner scanner, Map<Integer, User> users, Map<Integer, ActionMaster> actionMasters, Map<Integer, ActionHouse> actionHouses, Map<Integer, Painting> paintings, Map<Integer, Sculpture> sculptures) {
        System.out.println("Existing action houses:");
        for (Map.Entry<Integer, ActionHouse> me : actionHouses.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getName());
        }
        System.out.println("Please enter the id of the action house.");
        String actionHouseid = scanner.nextLine();
        bidRepository.getAllBidsbyActionHouse(Integer.parseInt(actionHouseid), users, actionMasters, actionHouses, paintings, sculptures);
    }
    public Bid buildBid(Scanner scanner, Map<Integer, User> users, Map<Integer, ActionMaster> actionMasters, Map<Integer, ActionHouse> actionHouses, Map<Integer, Painting> paintings, Map<Integer, Sculpture> sculptures) {
        System.out.println("Place a new bid");
        Bid bid = null;
        try {
            System.out.println("Existing users:");
            for (Map.Entry<Integer, User> me : users.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName());
            }
            System.out.println("Please enter the id of the user.");
            String userid = scanner.nextLine();
            User user = users.get(Integer.parseInt(userid));
            if (user == null) {
                throw new RuntimeException("The user with the id you just entered does not exist.");
            }
            System.out.println("Existing action houses:");
            for (Map.Entry<Integer, ActionHouse> me : actionHouses.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getName());
            }
            System.out.println("Please enter the id of the action house.");
            String actionHouseid = scanner.nextLine();
            ActionHouse actionHouse = actionHouses.get(Integer.parseInt(actionHouseid));
            if (actionHouse == null) {
                throw new RuntimeException("The action house with the id you just entered does not exist.");
            }
            System.out.println("Do you want to bid for a painting? (yes/no)");
            Painting painting = null;
            String painting2 = scanner.nextLine();
            if (Objects.equals(painting2, "yes")) {
                System.out.println("Painting available:");
                for (Map.Entry<Integer, Painting> me : paintings.entrySet()) {
                    System.out.println(me.getKey() + ". " + me.getValue());
                }
                System.out.println("Please enter the id of the painting.");
                String paintingid = scanner.nextLine();
                Painting painting3 = paintings.get(Integer.parseInt(paintingid));
                if (painting3 == null) {
                    throw new RuntimeException("The painting with the id you just entered does not exist.");
                } else {
                    painting = painting3;
                }
            }
            System.out.println("Do you want to bid for a sculpture? (yes/no)");
            Sculpture sculpture = null;
            String sculpture2 = scanner.nextLine();
            if (Objects.equals(sculpture2, "yes")) {
                System.out.println("Sculpture available:");
                for (Map.Entry<Integer, Sculpture> me : sculptures.entrySet()) {
                    System.out.println(me.getKey() + ". " + me.getValue());
                }
                System.out.println("Please enter the id of the sculpture.");
                String sculptureid = scanner.nextLine();
                Sculpture sculpture3 = sculptures.get(Integer.parseInt(sculptureid));
                if (sculpture3 == null) {
                    throw new RuntimeException("The sculpture with the id you just entered does not exist.");
                } else {
                    sculpture =sculpture3;
                }
            }
            Random rand = new Random();
            Integer actionMasterId = rand.nextInt(actionMasters.size()) + 1;
            ActionMaster actionMaster = actionMasters.get(actionMasterId);
            if (painting != null || sculpture != null) {
                bid = new Bid(user, actionHouse, actionMaster, painting, sculpture);
                System.out.println("The bid was placed successfully.");
            }
            else {
                throw new RuntimeException("The bid could not be placed.");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return bid;
    }

}

