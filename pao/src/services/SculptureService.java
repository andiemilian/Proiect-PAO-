package services;


import models.Sculpture;
import repository.SculptureRepository;


import java.awt.*;
import java.util.Map;
import java.util.Scanner;

public class SculptureService {
    private SculptureRepository sculptureRepository;

    public SculptureService() {
        this.sculptureRepository = new SculptureRepository();
    }

    public void addSculpture(Sculpture sculpture) {
        sculptureRepository.addSculpture(sculpture);
        System.out.println("The sculpture was added successfully.");
    }

    public Sculpture buildSculpture(Scanner scanner) {
        System.out.println("Please type the following: name/price/numberofOwners/yearofCreation/weight/material");
        String str = scanner.nextLine();
        String[] details = str.split("/");
        return new Sculpture(details[0],Float.parseFloat(details[1]),Integer.parseInt(details[2]),Integer.parseInt(details[3]),Integer.parseInt(details[4]),details[5]);
    }

    public void updateSculpture(Map<Integer, Sculpture> sculpure, Scanner scanner) {
        System.out.println("Sculpture available:");
        for (Map.Entry<Integer, Sculpture> me : sculpure.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Please enter the id of the sculpture.");
        String paintingid = scanner.nextLine();
        System.out.println("Please enter the new price.");
        Float price = Float.parseFloat(scanner.nextLine());
        Sculpture painting2 = sculpure.get(Integer.parseInt(paintingid));
        sculptureRepository.updatePrice(painting2, price);
        System.out.println("The price was updated successfully.");
    }

    public void deleteSculpture(Map<Integer, Sculpture> sculpture, Scanner scanner) {
        System.out.println("Sculpture available:");
        for (Map.Entry<Integer, Sculpture> me : sculpture.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Please enter the id of the sculpture.");
        String sculptureid = scanner.nextLine();
        Sculpture sculpture2 = sculpture.get(Integer.parseInt(sculptureid));
        sculptureRepository.deleteSculpture(sculpture2);
        System.out.println("The sculpture was deleted successfully.");
    }

    public Map<Integer, Sculpture> getAllSculpture() {
        return sculptureRepository.getAllSculpture();
    }
}
