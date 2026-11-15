package lw01.unguided;

public abstract class Rental implements Chargeable {
    protected String id;
    protected int days;
    protected int units;

    public Rental(String id, int days, int units) {
        this.id = id;
        this.days = days;
        this.units = units;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public int getUnits() {
        return units;
    }
    
    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("units must be greater than zero.");
        }
        return units * calculateCharge();
    }
    public String label() {
        return "Rental";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
