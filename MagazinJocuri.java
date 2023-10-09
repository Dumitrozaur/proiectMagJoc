import java.util.ArrayList;
import java.util.Scanner;

public class MagazinJocuri {
    private static Scanner scan = new Scanner(System.in);
    private static double suma = 0;
    private static ArrayList<Joc> listaJocuri = new ArrayList<>();

    public static void main(String[] args) {
        //Am initializat lista de jocuri cu nume si pret
        listaJocuri.add(new Joc("Minecraft", 29.99));
        listaJocuri.add(new Joc("DOOM", 39.99));
        listaJocuri.add(new Joc("Terraria", 9.99));
        listaJocuri.add(new Joc("God of War", 49.99));
        listaJocuri.add(new Joc("Lord of the Rings", 59.99));
        //Afisare meniu principal
        afiseazaMeniu();

        int optiune;
        do {
            System.out.print("Selecteaza o optiune: ");
            //Am initializat meniul de optiuni cu cele 6 obtiuni
            optiune = Integer.parseInt(scan.nextLine());

            switch (optiune) {
                case 1:
                    adaugaSuma();
                    break;
                case 2:
                    afiseazaListaJocuri();
                    break;
                case 3:
                    cumparaJoc();
                    break;
                case 4:
                    JocuriViitoare();
                    break;
                case 5:
                    verificaSuma();
                    break;       
                case 0:
                    System.out.println("Aplicatia s-a inchis.");
                    break;
                default:
                    System.out.println("Optiune invalida. Alege din nou!");
            }
        } while (optiune != 0);
    }
    //Metoda de afisat Meniul
    private static void afiseazaMeniu() {

        System.out.println("===== MENIU =================");
        System.out.println("1. Adauga suma");
        System.out.println("2. Afiseaza lista de jocuri");
        System.out.println("3. Cumpara joc");
        System.out.println("4. Exploreaza jocuri viitoare");
        System.out.println("5. Afiseaza sold");
        System.out.println("0. Inchide aplicatia");
        System.out.println("=============================");
    }
    //Metoda de verificat suma
    private static void verificaSuma() {
        System.out.println("Suma disponibila este: " + suma);
    }
    //Metoda de adaugat suma
    private static void adaugaSuma() {
        System.out.print("Introdu suma: ");
        double sumaAdaugata = Double.parseDouble(scan.nextLine());
        suma += sumaAdaugata;
        System.out.println("Suma totala disponibila: " + suma);
    }
    //Metoda de afisare a listei de jocuri
    private static void afiseazaListaJocuri() {
        System.out.println("===== Lista de Jocuri =====");
        for (int i = 0; i < listaJocuri.size(); i++) {
            Joc joc = listaJocuri.get(i);
            System.out.println((i + 1) + ". " + joc.getNume() + " - Pret: " + joc.getPret());
        }
        System.out.println("===========================");
    }
    //Metoda de cumparare a jocului
    private static void cumparaJoc() {
        //Reapelare a functiei de afisare a listei jocurilor
        afiseazaListaJocuri();
        System.out.print("Alege jocul pe care vrei sa-l cumperi (introdu numarul): ");
        int numarJoc = Integer.parseInt(scan.nextLine()) - 1;
        if (numarJoc >= 0 && numarJoc < listaJocuri.size()) {
            Joc jocCumparat = listaJocuri.get(numarJoc);
            if (jocCumparat.getPret() <= suma) {
                suma -= jocCumparat.getPret();
                System.out.println("Ai cumparat jocul " + jocCumparat.getNume() + ".");
                System.out.println("Suma ramasa: " + suma);
            } else {
                System.out.println("Nu ai suficienta suma pentru a cumpara acest joc.");
            }
        } else {
            System.out.println("Selectie invalida.");
        }
    }
    //Functia de afisare a jocurilor ce urmeaza sa apara
    private static void JocuriViitoare() {
        System.out.println("===== Jocuri Viitoare =====");
        System.out.println("1. Minecraft 2 (2024)");
        System.out.println("2. Doom 2 (2025)");
        System.out.println("===========================");
    }
}