package main;

import models.*;
import services.*;

import java.io.IOException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        UserService userService = new UserService();
        ActionMasterService actionMasterService = new ActionMasterService();
        PaintingService paintingService = new PaintingService();
        SculptureService sculptureService = new SculptureService();
        ActionHouseService actionHouseService = new ActionHouseService();
        BidService bidService = new BidService();
        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Painting> paintings = paintingService.getAllPainting();
        Map<Integer, Sculpture> sculptures = sculptureService.getAllSculpture();
        Map<Integer, User> users = userService.getAllUsers();
        Map<Integer, ActionMaster> actionMasters = actionMasterService.getAllActionMasters();
        Map<Integer, ActionHouse> actionHouses = actionHouseService.getAllActionHouses();
        ArrayList<Bid> bids = bidService.getAllBids(users, actionMasters, actionHouses, paintings, sculptures);
        Collections.sort(bids);

        System.out.println( "Welcome!");
        System.out.println( "Please choose one of the following options:" );

        while(true) {
            System.out.println();
            System.out.println();
            System.out.println("Menu");
            System.out.println("1. Display menu");
            System.out.println("2. Add menu");
            System.out.println("3. Update menu");
            System.out.println("4. Delete menu");
            System.out.println("0. Exit");
            System.out.print("Your option is: ");
            String option = scanner.nextLine();
            switch(option) {
                case "0" : {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                case "1" : {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Display all users");
                        System.out.println("2. Display all action_masters");
                        System.out.println("3. Display all action houses");
                        System.out.println("4. Display all items");
                        System.out.println("5. Display all bids");
                        System.out.println("6. Display bids organized by a action house");
                        System.out.println("0. Go back to menu");
                        System.out.print("Your option is: ");
                        String displayOption = scanner.nextLine();
                        switch (displayOption) {
                            case "0": {
                                ok = 0;
                                break;
                            }
                            case "1": {
                                for (Map.Entry<Integer, User> me : users.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Print all users");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "2": {
                                for (Map.Entry<Integer, ActionMaster> me : actionMasters.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Print all action masters");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "3": {
                                for (Map.Entry<Integer, ActionHouse> me : actionHouses.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Print all action houses");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "4": {
                                for (Map.Entry<Integer, Painting> me : paintings.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                for (Map.Entry<Integer, Sculpture> me : sculptures.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Print all items");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "5": {
                                for (Bid b : bids) {
                                    System.out.println(b);
                                }
                                auditService.addAction("Print all bids");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }

                            case "6" : {
                                bidService.getAllBidsByActionHouse(scanner, users, actionMasters, actionHouses, paintings, sculptures);
                                auditService.addAction("Print all bids organized by an action house");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            default: {
                                System.out.println("Your option is invalid. Please try again.");
                            }
                        }
                    }
                    break;
                }
                case "2" : {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println( "1. Register a new user");
                        System.out.println("2. Register a new action master");
                        System.out.println("3. Enter a new action house");
                        System.out.println("4. Enter a new item");
                        System.out.println("5. Place a new bid");
                        System.out.println("0. Go back to menu");
                        System.out.print("Your option is: ");
                        String addOption = scanner.nextLine();
                        switch (addOption) {
                            case "0" : {
                                ok = 0;
                                break;
                            }
                            case "1" : {
                                userService.addUser(userService.buildUser(scanner));
                                auditService.addAction("Add a new user");
                                users = userService.getAllUsers();
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "2" : {
                                actionMasterService.addActionMaster(actionMasterService.buildActionMaster(scanner));
                                auditService.addAction("Add a new action master");
                                actionMasters = actionMasterService.getAllActionMasters();
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "3" : {
                                actionHouseService.addActionHouse(actionHouseService.buildActionHouse(scanner));
                                auditService.addAction("Add a new action house");
                                actionHouses = actionHouseService.getAllActionHouses();
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "4" : {
                                System.out.println("Please enter the type of item: painting/sculpture");
                                String itemoption = scanner.nextLine();
                                switch (itemoption) {
                                    case "painting" : {
                                        paintingService.addPainting(paintingService.buildPainting(scanner));
                                        paintings = paintingService.getAllPainting();
                                        break;
                                    }
                                    case "sculpture" : {
                                        sculptureService.addSculpture(sculptureService.buildSculpture(scanner));
                                        sculptures = sculptureService.getAllSculpture();
                                        break;
                                    }
                                    default:
                                        System.out.println("You have entered a wrong type of item.");
                                }
                                auditService.addAction("Add a new item");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "5" : {
                                bidService.addBid(bidService.buildBid(scanner, users, actionMasters, actionHouses, paintings, sculptures));
                                auditService.addAction("Add a new bid");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            default: {
                                System.out.println("Your option is invalid. Please try again.");
                            }
                        }
                    }
                    break;
                }
                case "3" : {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Update e-mail of an user");
                        System.out.println("2. Update e-mail of an action master");
                        System.out.println("3. Update price of a item");
                        System.out.println("4. Update address of an action house");
                        System.out.println("0. Go back to menu");
                        System.out.print("Your option is: ");
                        String updateOption = scanner.nextLine();
                        switch (updateOption) {
                            case "0" : {
                                ok = 0;
                                break;
                            }
                            case "1" : {
                                userService.updateUser(users, scanner);
                                auditService.addAction("Update email of an user");
                                System.out.println("Press enter to continue...");
                                users = userService.getAllUsers();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "2" : {
                                actionMasterService.updateActionMaster(actionMasters, scanner);
                                auditService.addAction("Update phone number of an action master");
                                System.out.println("Press enter to continue...");
                                actionMasters = actionMasterService.getAllActionMasters();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "3" : {
                                System.out.println("Please enter the type of product: painting/sculpture");
                                String itemoption = scanner.nextLine();
                                switch (itemoption) {
                                    case "painting" : {
                                        paintingService.updatePainting(paintings, scanner);
                                        paintings = paintingService.getAllPainting();
                                        break;
                                    }
                                    case "sculpture" : {
                                        sculptureService.updateSculpture(sculptures, scanner);
                                        sculptures = sculptureService.getAllSculpture();
                                        break;
                                    }
                                    default:
                                        System.out.println("You have entered a wrong type of item.");
                                }
                                auditService.addAction("Update price of an item");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "4" : {
                                actionHouseService.updateActionHouse(actionHouses, scanner);
                                auditService.addAction("Update address of an action house");
                                System.out.println("Press enter to continue...");
                                actionHouses = actionHouseService.getAllActionHouses();
                                String aux = scanner.nextLine();
                                break;
                            }
                            default : {
                                System.out.println("Your option is invalid. Please try again.");
                            }
                        }
                    }
                    break;
                }
                case "4" : {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Delete an user");
                        System.out.println("2. Delete an action master");
                        System.out.println("3. Delete an item");
                        System.out.println("4. Delete an action house");
                        System.out.println("0. Go back to menu");
                        System.out.print("Your option is: ");
                        String updateOption = scanner.nextLine();
                        switch (updateOption) {
                            case "0" : {
                                ok = 0;
                                break;
                            }
                            case "1" : {
                                userService.deleteUser(users, scanner);
                                auditService.addAction("Delete an user");
                                System.out.println("Press enter to continue...");
                                users = userService.getAllUsers();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "2" : {
                                actionMasterService.deleteActionMaster(actionMasters, scanner);
                                auditService.addAction("Delete an action master");
                                System.out.println("Press enter to continue...");
                                actionMasters = actionMasterService.getAllActionMasters();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "3" : {
                                System.out.println("Please enter the type of product: painting/sculpture");
                                String itemoption = scanner.nextLine();
                                switch (itemoption) {
                                    case "painting" : {
                                        paintingService.deletePainting(paintings, scanner);
                                        paintings = paintingService.getAllPainting();
                                        break;
                                    }
                                    case "sculpture" : {
                                        sculptureService.deleteSculpture(sculptures, scanner);
                                        sculptures = sculptureService.getAllSculpture();
                                        break;
                                    }
                                    default:
                                        System.out.println("You have entered a wrong type of item.");
                                }
                                auditService.addAction("Delete an item");
                                System.out.println("Press enter to continue...");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "4" : {
                                actionHouseService.deleteActionHouse(actionHouses, scanner);
                                auditService.addAction("Delete an action house");
                                System.out.println("Press enter to continue...");
                                actionHouses = actionHouseService.getAllActionHouses();
                                String aux = scanner.nextLine();
                                break;
                            }
                            default : {
                                System.out.println("Your option is invalid. Please try again.");
                            }
                        }
                    }
                    break;
                }
                default : {
                    System.out.println("Your option is invalid. Please try again.");
                }
            }

        }
    }
}
