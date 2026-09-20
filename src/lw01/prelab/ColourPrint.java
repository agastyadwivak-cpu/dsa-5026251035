public class ColourPrint extends PrintJob {

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int p = getPages();
        int charge;
        if (p <= 10) {
            charge = p * 1500;
        } else {
            charge = (10 * 1500) + ((p - 10) * 1000);
        }
        charge += 2000; // setup cost per complete copy
        return charge;
    }

    @Override
    public String label() {
        return "Colour";
    }
}