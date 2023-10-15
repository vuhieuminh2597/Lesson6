package model;

public class Director extends Manager {
    public Director(String idString, String name, String phoneNumber, int dayWork) {
        super(idString, name, phoneNumber, dayWork);
    }

    @Override
    public String getDuty() {
        return "Director";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Director) {
            Director dir = (Director) obj;
            if (this.getIdString().equals(dir.getIdString())
                    && this.getName().equals(dir.getName())
                    && this.getPhoneNumber().equals(dir.getPhoneNumber())
                    && this.getDayWork() == dir.getDayWork()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id='" + super.getIdString() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", dayWork=" + super.getDayWork() +
                ", duty=" + this.getDuty() +
                '}';
    }
}
