import java.util.Scanner;
import java.text.DecimalFormat;

// Kelas parent
class Pegawai {
    String nama;
    String nip;

    public Pegawai(String nama, String nip) {
        this.nama = nama;
        this.nip = nip;
    }

    public void tampilkanData() {
        System.out.println("Nama : " + nama);
        System.out.println("NIP  : " + nip);
    }

    public double hitungGaji() {
        return 0;
    }
}

// Kelas turunan pegawai tetap
class PegawaiTetap extends Pegawai {
    double gajiPokok;

    public PegawaiTetap(String nama, String nip, double gajiPokok) {
        super(nama, nip);
        this.gajiPokok = gajiPokok;
    }

    @Override
    public double hitungGaji() {
        return gajiPokok;
    }
}

// Kelas Turunan Pegawai Honorer
class PegawaiHonorer extends Pegawai {
    int jamKerja;
    double upahPerJam;

    public PegawaiHonorer(String nama, String nip, int jamKerja, double upahPerJam) {
        super(nama, nip);
        this.jamKerja = jamKerja;
        this.upahPerJam = upahPerJam;
    }

    @Override
    public double hitungGaji() {
        return jamKerja * upahPerJam;
    }
}

// Kelas Main
public class Gaji {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###.##");

        // input data pegawai tetap
        System.out.println("=== Input Data Pegawai Tetap ===");
        System.out.print("Nama: ");
        String namaTetap = scanner.nextLine();
        System.out.print("NIP : ");
        String nipTetap = scanner.nextLine();
        System.out.print("Gaji Pokok: ");
        double gajiPokok = scanner.nextDouble();
        scanner.nextLine(); 

        Pegawai pegawaiTetap = new PegawaiTetap(namaTetap, nipTetap, gajiPokok);

        // input pegawai honorer
        System.out.println("\n=== Input Data Pegawai Honorer ===");
        System.out.print("Nama: ");
        String namaHonorer = scanner.nextLine();
        System.out.print("NIP : ");
        String nipHonorer = scanner.nextLine();
        System.out.print("Jam Kerja: ");
        int jamKerja = scanner.nextInt();
        System.out.print("Upah per Jam: ");
        double upahPerJam = scanner.nextDouble();

        Pegawai pegawaiHonorer = new PegawaiHonorer(namaHonorer, nipHonorer, jamKerja, upahPerJam);

        // Output
        System.out.println("\n=== Gaji Pegawai Tetap ===");
        pegawaiTetap.tampilkanData();
        System.out.println("Gaji: Rp " + df.format(pegawaiTetap.hitungGaji()));

        System.out.println("\n=== Gaji Pegawai Honorer ===");
        pegawaiHonorer.tampilkanData();
        System.out.println("Gaji: Rp " + df.format(pegawaiHonorer.hitungGaji()));

        scanner.close();
    }
}
