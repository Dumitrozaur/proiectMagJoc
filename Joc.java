//Un class care este incapsulat in MagazinJocuri, aceasta clasa pastreaza numele si pretul jocului anume
public class Joc {
    private String nume;
    private double pret;

    public Joc(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public String getNume() {
        return nume;
    }

    public double getPret() {
        return pret;
    }
}