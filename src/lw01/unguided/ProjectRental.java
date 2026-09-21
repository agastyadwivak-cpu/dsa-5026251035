package lw01.unguided;

public class ProjectRental extends Rental {
    public ProjectRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        if (this.getDays() <= 3) {
            return ((this.getDays() * 60000) + 20000) * this.getUnits(); // Biaya sewa proyek per hari
        } else {
            return ((3 * 60000) + (this.getDays() - 3) * 45000 + 20000) * this.getUnits(); // Biaya sewa proyek per hari
        }
        
    }

    @Override
    public String label() {
        return "Projector";
    }
}
