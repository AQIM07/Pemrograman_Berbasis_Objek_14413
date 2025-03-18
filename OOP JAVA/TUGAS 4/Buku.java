class Buku {
    String judul;
    String pengarang;
    String penerbit;
    int tahun;

    // Konstruktor
    public Buku(String judul, String pengarang, String penerbit, int tahun) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahun = tahun;
    }

    // Method untuk mencetak informasi buku
    public void cetakBuku() {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Penerbit: " + penerbit);
        System.out.println("Tahun: " + tahun);
        System.out.println();
    }
}

 class Demo {
    public static void main(String[] args) {
        // Membuat objek buku
        Buku buku1 = new Buku("Pidi Baiq", "Pidi Baiq", "Pastel Books", 2014);
        Buku buku2 = new Buku("Negeri 5 Menara", "Ahmad Fuadi", "Gramedia Pustaka utama", 2009);
        
        // Menampilkan informasi buku
        buku1.cetakBuku();
        buku2.cetakBuku();
    }
}
