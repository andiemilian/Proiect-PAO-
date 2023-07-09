package models;

public class Painting extends Item{
    private Integer weight;
    private String typeOfpaint;


    public Painting(String name,Float price,Integer numberofOwners,Integer yearofCreation, Integer weight,String typeOfpaint)
    {
        super(name,price,numberofOwners,yearofCreation);
        this.weight=weight;
        this.typeOfpaint=typeOfpaint;

    }
    public Painting()
    {

    }
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getTypeOfpaint() {
        return typeOfpaint;
    }

    public void setTypeOfpaint(String typeOfpaint) {
        this.typeOfpaint = typeOfpaint;
    }

    @Override
    public String toString() {

        return "Painting- " + super.toString() + " - " + weight + "kg, " + " - " +
                ", is made with: " + typeOfpaint + "paint";
    }


}
