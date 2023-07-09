package services;

import models.ActionHouse;
import models.ActionMaster;
import repository.ActionHouseRepository;

import java.util.Map;
import java.util.Scanner;

public class ActionHouseService {
    private ActionHouseRepository actionHouseRepository;

    public ActionHouseService() {
        this.actionHouseRepository = new ActionHouseRepository();
    }

    public void addActionHouse(ActionHouse actionHouse) {
        actionHouseRepository.addActionHouse(actionHouse);
        System.out.println("The action house was added successfully.");
    }

    public void updateActionHouse(Map<Integer, ActionHouse> actionHouses, Scanner scanner) {
        System.out.println("Existing action houses:");
        for (Map.Entry<Integer, ActionHouse> me : actionHouses.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getName());
        }
        System.out.println("Please enter the id of the action house.");
        String actionHouseid = scanner.nextLine();
        System.out.println("Please enter the new address.");
        String address = scanner.nextLine();
        ActionHouse actionHouse = actionHouses.get(Integer.parseInt(actionHouseid));
        actionHouseRepository.updateAddress(actionHouse, address);
        System.out.println("The address was updated successfully.");
    }

    public void deleteActionHouse(Map<Integer, ActionHouse> actionHouses, Scanner scanner) {
        System.out.println("Existing action houses:");
        for (Map.Entry<Integer, ActionHouse> me : actionHouses.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getName());
        }
        System.out.println("Please enter the id of the action house.");
        String actionHouseid = scanner.nextLine();
        ActionHouse actionHouse = actionHouses.get(Integer.parseInt(actionHouseid));
        actionHouseRepository.deleteActionHouse(actionHouse);
        System.out.println("The action house was deleted successfully.");
    }

    public ActionHouse  buildActionHouse(Scanner scanner) {
        System.out.println("Register a new action house");
        System.out.println("Please type the following: name/address");
        String line = scanner.nextLine();
        String[] details = line.split("/");
        ActionHouse actionHouse = new ActionHouse(details[0], details[1]);
        return actionHouse;
    }

    public Map<Integer, ActionHouse> getAllActionHouses() {
        return actionHouseRepository.getAllActionHouses();
    }
}