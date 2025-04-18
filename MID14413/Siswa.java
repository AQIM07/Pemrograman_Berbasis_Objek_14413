public class Siswa {
    private String nis;
    private String nama;
    private int kelas;
    private int bulanTerlambat;
    private String bulanPembayaran;
    private int totalBayar;

    // Constructor
    public Siswa(String nis, String nama, int kelas) {
        this.nis = nis;
        this.nama = nama;
        this.kelas = kelas;
        this.bulanTerlambat = 0;
        this.bulanPembayaran = "";
        this.totalBayar = 0;
    }

    // Getter dan Setter
    public String getNis() {
        return nis;
    }

    public String getNama() {
        return nama;
    }

    public int getKelas() {
        return kelas;
    }

    public int getBulanTerlambat() {
        return bulanTerlambat;
    }

    public void setBulanTerlambat(int bulanTerlambat) {
        this.bulanTerlambat = bulanTerlambat;
    }

    public String getBulanPembayaran() {
        return bulanPembayaran;
    }

    public void setBulanPembayaran(String bulanPembayaran) {
        this.bulanPembayaran = bulanPembayaran;
    }

    public int getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(int totalBayar) {
        this.totalBayar = totalBayar;
    }
}