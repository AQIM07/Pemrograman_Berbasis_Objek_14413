import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SPPManager {
    private ArrayList<Siswa> daftarSiswa;
    private NumberFormat formatRupiah;

    public SPPManager() {
        this.daftarSiswa = new ArrayList<>();
        this.formatRupiah = NumberFormat.getCurrencyInstance(
            new Locale.Builder().setLanguage("id").setRegion("ID").build()
        );
        this.formatRupiah.setMaximumFractionDigits(0);
    }

    public void tambahSiswa(String nis, String nama, int kelas) {
        Siswa siswaBaru = new Siswa(nis, nama, kelas);
        daftarSiswa.add(siswaBaru);
    }

    public String[] bayarSPP(int indexSiswa, String bulanPembayaran, int bulanTerlambat) {
        Siswa siswa = daftarSiswa.get(indexSiswa);
        siswa.setBulanPembayaran(bulanPembayaran);
        siswa.setBulanTerlambat(bulanTerlambat);
        
        int nominalSPP = getNominalSPP(siswa.getKelas());
        int denda = (int)(nominalSPP * 0.1 * bulanTerlambat);
        int totalBayar = nominalSPP + denda;
        siswa.setTotalBayar(totalBayar);
        
        String tanggalPembayaran = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        
        return new String[] {
            siswa.getNama(),
            String.valueOf(siswa.getKelas()),
            siswa.getBulanPembayaran(),
            formatRupiah.format(nominalSPP),
            String.valueOf(bulanTerlambat),
            formatRupiah.format(denda),
            formatRupiah.format(totalBayar),
            tanggalPembayaran
        };
    }

    public void tampilkanLaporan() {
        if(daftarSiswa.isEmpty()) {
            System.out.println("\nBelum ada data siswa!");
            return;
        }
        
        System.out.println("\nSekolah Dasar \"DAMEL MENALAR\"");
        System.out.println("Laporan data SPP Siswa");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-10s %-15s %-12s %-12s %-12s %-12s\n", 
                "NO", "NAMA SISWA", "KELAS", "SPP", "BULAN", "TERLAMBAT", "DENDA", "TOTAL");
        System.out.println("------------------------------------------------------------------------------------------------");
        
        for(int i = 0; i < daftarSiswa.size(); i++) {
            Siswa siswa = daftarSiswa.get(i);
            int nominalSPP = getNominalSPP(siswa.getKelas());
            int denda = (int)(nominalSPP * 0.1 * siswa.getBulanTerlambat());
            
            System.out.printf("%-5d %-15s %-10d %-15s %-12s %-12d %-12s %-12s\n", 
                    (i+1), 
                    siswa.getNama(), 
                    siswa.getKelas(), 
                    formatRupiah.format(nominalSPP), 
                    siswa.getBulanPembayaran().isEmpty() ? "-" : siswa.getBulanPembayaran(), 
                    siswa.getBulanTerlambat(), 
                    siswa.getBulanTerlambat() > 0 ? formatRupiah.format(denda) : "-", 
                    siswa.getTotalBayar() > 0 ? formatRupiah.format(siswa.getTotalBayar()) : "-");
        }
        
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public ArrayList<Siswa> getDaftarSiswa() {
        return daftarSiswa;
    }

    private int getNominalSPP(int kelasSiswa) {
        switch(kelasSiswa) {
            case 1: return 200000;
            case 2: return 250000;
            case 3: return 300000;
            case 4: return 350000;
            case 5: return 400000;
            case 6: return 600000;
            default: return 0;
        }
    }
}