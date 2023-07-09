package services;

import models.ActionMaster;
import repository.ActionMasterRepository;

import javax.swing.*;
import java.util.Map;
import java.util.Scanner;

public class ActionMasterService {
    private ActionMasterRepository actionMasterRepository;

    public ActionMasterService() {
        this.actionMasterRepository = new ActionMasterRepository();
    }

    public void addActionMaster(ActionMaster actionMaster) {
        actionMasterRepository.addActionMaster(actionMaster);
        System.out.println("The action_master was added successfully.");
    }

    public void deleteActionMaster(Map<Integer, ActionMaster> actionMasters, Scanner scanner) {
        System.out.println("Existing action_masters:");
        for (Map.Entry<Integer, ActionMaster> me : actionMasters.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getName());
        }
        System.out.println("Please enter the id of the action_master.");
        String actionMasterid = scanner.nextLine();
        ActionMaster actionMaster = actionMasters.get(Integer.parseInt(actionMasterid));
        actionMasterRepository.deleteActionMaster(actionMaster);
        System.out.println("The action_master was deleted successfully.");
    }

    public void updateActionMaster(Map<Integer, ActionMaster> actionMasters, Scanner scanner) {
        System.out.println("Existing action_masters:");
        for (Map.Entry<Integer, ActionMaster> me : actionMasters.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getName());
        }
        System.out.println("Please enter the id of the action_master.");
        String actionMasterid = scanner.nextLine();
        System.out.println("Please enter the new e-mail.");
        String email = scanner.nextLine();
        ActionMaster actionMaster = actionMasters.get(Integer.parseInt(actionMasterid));
        actionMasterRepository.updateEmail(actionMaster, email);
        System.out.println("The e-mail was updated successfully.");
    }

    public ActionMaster buildActionMaster(Scanner scanner) {
        System.out.println("Register a new action_master");
        System.out.println("Please type the following: name/age/e-mail/phone number/yearsofActivity/numberofActionsAttended");
        String line = scanner.nextLine();
        String[] details = line.split("/");
        return new ActionMaster(details[0], Integer.parseInt(details[1]), details[2], details[3], Integer.parseInt(details[4]),Integer.parseInt(details[5])) {
        };
    }

    public Map<Integer, ActionMaster> getAllActionMasters() {
        return actionMasterRepository.getAllAcitonMasters();
    }
}
