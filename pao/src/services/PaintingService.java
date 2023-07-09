package services;

import models.Painting;
import repository.PaintingRepository;


import java.awt.*;
import java.util.Map;
import java.util.Scanner;

public class PaintingService {
    private PaintingRepository paintingRepository;

    public PaintingService() {
        this.paintingRepository = new PaintingRepository();
    }

    public void addPainting(Painting painting) {
        paintingRepository.addPainting(painting);
        System.out.println("The painting was added successfully.");
    }

    public Painting buildPainting(Scanner scanner) {
        System.out.println("Please type the following: name/price/numberofOwners/yearofCreation/weight/typeOfpaint");
        String str = scanner.nextLine();
        String[] details = str.split("/");
        return new Painting(details[0],Float.parseFloat(details[1]),Integer.parseInt(details[2]),Integer.parseInt(details[3]),Integer.parseInt(details[4]),details[5]);
    }

    public void updatePainting(Map<Integer, Painting> painting, Scanner scanner) {
        System.out.println("Painting available:");
        for (Map.Entry<Integer, Painting> me : painting.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Please enter the id of the painting.");
        String paintingid = scanner.nextLine();
        System.out.println("Please enter the new price.");
        Float price = Float.parseFloat(scanner.nextLine());
        Painting painting2 = painting.get(Integer.parseInt(paintingid));
        paintingRepository.updatePrice(painting2, price);
        System.out.println("The price was updated successfully.");
    }

    public void deletePainting(Map<Integer, Painting> painting, Scanner scanner) {
        System.out.println("Painting available:");
        for (Map.Entry<Integer, Painting> me : painting.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Please enter the id of the painting.");
        String paintingid = scanner.nextLine();
        Painting painting2 = painting.get(Integer.parseInt(paintingid));
        paintingRepository.deletePainting(painting2);
        System.out.println("The painting was deleted successfully.");
    }

    public Map<Integer, Painting> getAllPainting() {
        return paintingRepository.getAllPainting();
    }
}
