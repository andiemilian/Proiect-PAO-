package models;
import java.util.Objects;
public abstract class Item {
    private Integer id;
    private String name;
    private Float price;
    private Integer numberofOwners;
    private Integer yearofCreation;


    public Item() {
    }

    public Item(String name, Float price,Integer numberofOwners,Integer yearofCreation) {
        this.name = name;
        this.price = price;
        this.numberofOwners = numberofOwners;
        this.yearofCreation = yearofCreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getNumberofOwners() {
        return numberofOwners;
    }

    public void setNumberofOwners(Integer numberofOwners) {
        this.numberofOwners = numberofOwners;
    }

    public Integer getYearofCreation() {
        return yearofCreation;
    }

    public void setYearofCreation(Integer yearofCreation) {
        this.yearofCreation = yearofCreation;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(numberofOwners, item.numberofOwners)&& Objects.equals(yearofCreation, item.yearofCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price,numberofOwners,yearofCreation);
    }

    @Override
    public String toString() {
        return "name"+ name +
                " (" + price + " euros)" +
                "numberofOwners" +numberofOwners+
                "yearofCreation"+ yearofCreation;
    }

}
