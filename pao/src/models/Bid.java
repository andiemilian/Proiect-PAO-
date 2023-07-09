package models;

import java.util.Objects;

public class Bid implements Comparable<Bid>{
    private Integer id;
    private User user;
    private ActionHouse actionHouse;
    private ActionMaster actionMaster;
    private Painting painting;
    private Sculpture sculpture;

    public Bid(User user, ActionHouse actionHouse, ActionMaster actionMaster, Painting painting, Sculpture sculpture) {

        this.user = user;
        this.actionHouse = actionHouse;
        this.actionMaster = actionMaster;
        this.painting = painting;
        this.sculpture = sculpture;
    }

    public Bid() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ActionHouse getActionHouse() {
        return actionHouse;
    }

    public void setActionHouse(ActionHouse actionHouse) {
        this.actionHouse = actionHouse;
    }

    public ActionMaster getActionMaster() {
        return actionMaster;
    }

    public void setActionMaster(ActionMaster actionMaster) {
        this.actionMaster = actionMaster;
    }

    public Painting getPainting() {
        return painting;
    }

    public void setPainting(Painting painting) {
        this.painting = painting;
    }

    public Sculpture getSculpture() {
        return sculpture;
    }

    public void setSculpture(Sculpture sculpture) {
        this.sculpture = sculpture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return Objects.equals(user, bid.user) && Objects.equals(actionHouse, bid.actionHouse) && Objects.equals(actionMaster, bid.actionMaster) && Objects.equals(painting, bid.painting) && Objects.equals(sculpture, bid.sculpture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, actionHouse, actionMaster, painting, sculpture);
    }

    @Override
    public String toString() {
        String paintingstring = "";
        if (painting != null) {
            paintingstring = "     painting: " + painting;
        }

        String sculpturestring = "";
        if (sculpture != null) {
            sculpturestring = "     sculpture: " + sculpture;
        }

        return "Bid placed by " + user.getName() +
                ", from " + actionHouse.getName() +
                ", with the authorization of " + actionMaster.getName() +
                "\n" + paintingstring + sculpturestring;
    }
    @Override
    public int compareTo(Bid b) {
        return this.actionHouse.getName().compareTo(b.actionHouse.getName());
    }

}
