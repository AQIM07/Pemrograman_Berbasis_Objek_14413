import java.util.Scanner;
import java.util.ArrayList;

public class MenuUtama {
    private Scanner input;
    private SPPManager sppManager;

    public MenuUtama() {
        this.input = new Scanner(System.in);
        this.sppManager = new SPPManager();
    }

    public void jalankan() {
        int pilihan;
        
        do {
            tampilkanMenu();
            System.out.print("PILIH [1..4] : ");
            pilihan = input.nextInt();
            input.nextLine(); 
            
            switch(pilihan) {
                case 1:
                    inputDataSiswa();
                    break;
                case 2:
                    bayarSPP();
                    break;
                case 3:
                    tampilkanLaporan();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while(pilihan != 4);
        
        input.close();
    }
    
    private void tampilkanMenu() {
        System.out.println("\n---------------------");
        System.out.println("1. INPUT DATA SISWA");
        System.out.println("2. BAYAR SPP");
        System.out.println("3. LAPORAN");
        System.out.println("4. KELUAR");
        System.out.println("---------------------");
    }
    
    private void inputDataSiswa() {
        System.out.println("\n=== INPUT DATA SISWA ===");
        System.out.print("NIS: ");
        String nis = input.nextLine();
        
        System.out.print("Nama Siswa: ");
        String nama = input.nextLine();
        
        System.out.print("Kelas (1-6): ");
        int kelas = input.nextInt();
        while(kelas < 1 || kelas > 6) {
            System.out.println("Kelas harus antara 1-6!");
            System.out.print("Kelas (1-6): ");
            kelas = input.nextInt();
        }
        input.nextLine(); // Membersihkan newline
        
        sppManager.tambahSiswa(nis, nama, kelas);
        System.out.println("Data siswa berhasil ditambahkan!");
    }
    
    private void bayarSPP() {
        if(sppManager.getDaftarSiswa().isEmpty()) {
            System.out.println("\nBelum ada data siswa! Silakan input data siswa terlebih dahulu.");
            return;
        }
        
        System.out.println("\n=== BAYAR SPP ===");
        
        // Tampilkan daftar siswa
        System.out.println("Daftar Siswa:");
        ArrayList<Siswa> daftar = sppManager.getDaftarSiswa();
        for(int i = 0; i < daftar.size(); i++) {
            System.out.println((i+1) + ". " + daftar.get(i).getNama() + " (Kelas " + daftar.get(i).getKelas() + ")");
        }
        
        System.out.print("Pilih siswa (1-" + daftar.size() + "): ");
        int pilihSiswa = input.nextInt() - 1;
        input.nextLine(); // Membersihkan newline
        
        if(pilihSiswa < 0 || pilihSiswa >= daftar.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }
        
        System.out.print("Bulan Pembayaran (contoh: Januari): ");
        String bulanPembayaran = input.nextLine();
        
        System.out.print("Terlambat (bulan): ");
        int bulanTerlambat = input.nextInt();
        input.nextLine(); // Membersihkan newline
        
        String[] detailPembayaran = sppManager.bayarSPP(pilihSiswa, bulanPembayaran, bulanTerlambat);
        
        System.out.println("\n=== PEMBAYARAN SPP BERHASIL ===");
        System.out.println("Sekolah Dasar \"DAMEL MENALAR\"");
        System.out.println("----------------------------------------");
        System.out.println("Nama Siswa    : " + detailPembayaran[0]);
        System.out.println("Kelas         : " + detailPembayaran[1]);
        System.out.println("Bulan         : " + detailPembayaran[2]);
        System.out.println("----------------------------------------");
        System.out.println("Nominal SPP   : " + detailPembayaran[3]);
        System.out.println("Terlambat     : " + detailPembayaran[4] + " bulan");
        System.out.println("Denda (10%)   : " + detailPembayaran[5]);
        System.out.println("----------------------------------------");
        System.out.println("TOTAL BAYAR   : " + detailPembayaran[6]);
        System.out.println("----------------------------------------");
        System.out.println("Terima kasih telah melakukan pembayaran");
        System.out.println("Pembayaran tercatat pada: " + detailPembayaran[7]);
    }
    
    private void tampilkanLaporan() {
        sppManager.tampilkanLaporan();
    }
}