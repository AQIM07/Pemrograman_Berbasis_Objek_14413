class Mobil2 {
    String warna;
    String merek;
    int tahunProduksi;
    boolean mesinHidup;
    int gigi;

    void hidupkanMobil() {
        mesinHidup = true;
        System.out.println("Mobil dihidupkan.");
    }

    void matikanMobil() {
        mesinHidup = false;
        System.out.println("Mobil dimatikan.");
    }

    void ubahGigi(int gigiBaru) {
        if (mesinHidup) {
            gigi = gigiBaru;
            System.out.println("Gigi diubah ke: " + gigi);
        } else {
            System.out.println("Tidak bisa mengubah gigi. Mobil dalam keadaan mati.");
        }
    }
}

 class MobilDemo2 {
    public static void main(String[] args) {
        Mobil2 mobilku = new Mobil2();
        
        // Set atribut
        mobilku.warna = "Hitam";
        mobilku.tahunProduksi = 2019;
        mobilku.merek = "Vios V2.5";

        // Tampilkan informasi awal
        System.out.println("Merek: " + mobilku.merek);
        System.out.println("Warna: " + mobilku.warna);
        System.out.println("Tahun: " + mobilku.tahunProduksi);
        
        // Panggil method
        mobilku.hidupkanMobil();
        mobilku.ubahGigi(6);
        mobilku.matikanMobil();
    }
}
