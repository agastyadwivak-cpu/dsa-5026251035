package lw01.unguided;

public class LaptopRental extends Rental {
    public LaptopRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        return ((this.getDays() * 40000) + 10000) * this.getUnits(); // Biaya sewa laptop per hari
    }

    @Override
    public String label() {
        return "Laptop";
    }
}
