package models;

import java.util.Objects;

public class ActionHouse {
    private Integer id;
    private String name;

    private String address;

    public ActionHouse(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public ActionHouse() {

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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionHouse house = (ActionHouse) o;
        return Objects.equals(name, house.name)  && Objects.equals(address, house.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "ActionHouse- " + name + ",address: "+ address;

    }

}
