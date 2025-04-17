import java.util.Scanner;

public class MahasiswaArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tentukan jumlah data yang akan dimasukkan
        int jumlahData = 3;

        // Buat array untuk menyimpan data
        String[] nim = new String[jumlahData];
        String[] nama = new String[jumlahData];
        double[] nilai = new double[jumlahData];

        // Input data
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("Data ke-" + (i + 1));
            System.out.print("Masukkan NIM   : ");
            nim[i] = scanner.nextLine();
            System.out.print("Masukkan Nama  : ");
            nama[i] = scanner.nextLine();
            System.out.print("Masukkan Nilai : ");
            nilai[i] = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.println();
        }

        // Tampilkan dataa
        System.out.println("=== Data Mahasiswa ===");
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.println("NIM   : " + nim[i]);
            System.out.println("Nama  : " + nama[i]);
            System.out.println("Nilai : " + nilai[i]);
            System.out.println();
        }

        scanner.close();
    }
}
