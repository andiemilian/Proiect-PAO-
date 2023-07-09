package models;

public class Sculpture extends Item {
    private Integer weight;
    private String material;

    public Sculpture(String name,Float price,Integer numberofOwners,Integer yearofCreation, Integer weight,String material)
    {
        super(name,price,numberofOwners,yearofCreation);
        this.weight=weight;
        this.material=material;

    }
    public Sculpture()
    {

    }
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {

        return "Sculpture- " + super.toString() + " - " + weight + "kg, " + " - " +
                ", is made of: " + material + "material";
    }
}
