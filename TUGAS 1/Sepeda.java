public class Sepeda {
    // Atribut
    private String merek;
    private String model;
    private String warna;
    private String ukuranRoda;
    private int jumlahGigi;
    private double berat;
    private String kondisi;

    // Konstruktor
    public Sepeda(String merek, String model, String warna, String ukuranRoda, int jumlahGigi, double berat, String kondisi) {
        this.merek = merek;
        this.model = model;
        this.warna = warna;
        this.ukuranRoda = ukuranRoda;
        this.jumlahGigi = jumlahGigi;
        this.berat = berat;
        this.kondisi = kondisi;
    }

    // Metode untuk mengayuh sepeda
    public void mengayuh() {
        System.out.println(merek + " " + model + " sedang dikayuh.");
    }

    // Metode untuk rem sepeda
    public void rem() {
        System.out.println(merek + " " + model + " berhenti.");
    }

    // Metode untuk belok
    public void belok(String arah) {
        System.out.println(merek + " " + model + " belok ke " + arah + ".");
    }

    // Metode untuk mengganti gigi
    public void gantiGigi(int gigi) {
        if (gigi <= jumlahGigi) {
            System.out.println("Gigi diganti ke " + gigi + ".");
        } else {
            System.out.println("Gigi tidak tersedia.");
        }
    }

    // Metode untuk cek kondisi
    public void cekKondisi() {
        System.out.println("Kondisi sepeda: " + kondisi);
    }

    // Metode untuk menampilkan informasi sepeda
    public void tampilkanInfo() {
        System.out.println("Bike : " + merek + " " + model + ", Color: " + warna + ", Tire Size: " + ukuranRoda +
                ", Number of Gears: " + jumlahGigi + ", Weight: " + berat + " kg, Conditions: " + kondisi);
    }

    // Main method untuk contoh penggunaan
    public static void main(String[] args) {
        Sepeda sepeda1 = new Sepeda("Thrill", "Mountain Bike", "Black", "27 inci", 6, 12.5, "New");
        sepeda1.tampilkanInfo();
        sepeda1.mengayuh();
        sepeda1.belok("Left");
        sepeda1.gantiGigi(3);
        sepeda1.cekKondisi();
    }
}