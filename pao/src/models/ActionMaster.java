package models;

public class ActionMaster extends UserDetails{

    private Integer yearsofActivity;
    private Integer numberofActionsAttended;

    public ActionMaster(String name, Integer age, String email, String phoneNumber, Integer yearsofActivity,Integer numberofActionsAttended) {
        super(name, age, email, phoneNumber);
        this.yearsofActivity= yearsofActivity;
        this.numberofActionsAttended = numberofActionsAttended;
    }
    public ActionMaster() {
    }
    public Integer getYearsofActivity() {
        return yearsofActivity;
    }

    public void setYearsofActivity(Integer yearsofActivity) {
        this.yearsofActivity = yearsofActivity;
    }

    public Integer getNumberofActionsAttended() {
        return numberofActionsAttended;
    }

    public void setNumberofActionsAttended(Integer numberofActionsAttended) {
        this.numberofActionsAttended = numberofActionsAttended;
    }
    @Override
    public String toString() {
        return "ActionMaster - " + super.toString() +
                ", YearsofActiviy: " + yearsofActivity+
                ",NumberOfActionsAttended:" +numberofActionsAttended;
    }
}
