import java.util.Scanner;

public class MainDinamis {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // judul program
    System.out.println("===== SISTEM PENGELOLAAN NILAI MAHASISWA =====");

    // input jumlah data mahasiswa
    System.out.print("Masukkan jumlah mahasiswa: ");
    int jumlahMahasiswa = input.nextInt();
    input.nextLine(); // konsumsi newline
    Mahasiswa4[] dataMahasiswa = new Mahasiswa4[jumlahMahasiswa];
    for (int i = 0; i < jumlahMahasiswa; i++) {
      System.out.println("\nData Mahasiswa ke-" + (i + 1));
      System.out.print("NIM: ");
      String nim = input.nextLine();
      System.out.print("Nama: ");
      String nama = input.nextLine();
      System.out.print("Prodi: ");
      String prodi = input.nextLine();
      dataMahasiswa[i] = new Mahasiswa4(nim, nama, prodi);
    }

    // input jumlah data mata kuliah
    System.out.print("\nMasukkan jumlah mata kuliah: ");
    int jumlahMataKuliah = input.nextInt();
    input.nextLine(); // konsumsi newline
    MataKuliah4[] dataMataKuliah = new MataKuliah4[jumlahMataKuliah];
    for (int i = 0; i < jumlahMataKuliah; i++) {
      System.out.println("\nData Mata Kuliah ke-" + (i + 1));
      System.out.print("Kode MK: ");
      String kodeMK = input.nextLine();
      System.out.print("Nama MK: ");
      String namaMK = input.nextLine();
      System.out.print("SKS: ");
      int sks = input.nextInt();
      input.nextLine(); // konsumsi newline
      dataMataKuliah[i] = new MataKuliah4(kodeMK, namaMK, sks);
    }

    // input jumlah data penilaian
    System.out.print("\nMasukkan jumlah penilaian: ");
    int jumlahPenilaian = input.nextInt();
    input.nextLine(); // konsumsi newline
    Penilaian4[] dataPenilaian = new Penilaian4[jumlahPenilaian];
    for (int i = 0; i < jumlahPenilaian; i++) {
      System.out.println("\nData Penilaian ke-" + (i + 1));
      System.out.print("Index Mahasiswa (0-" + (jumlahMahasiswa - 1) + "): ");
      int indexMahasiswa = input.nextInt();
      System.out.print("Index Mata Kuliah (0-" + (jumlahMataKuliah - 1) + "): ");
      int indexMataKuliah = input.nextInt();
      System.out.print("Nilai Tugas: ");
      int nilaiTugas = input.nextInt();
      System.out.print("Nilai UTS: ");
      int nilaiUTS = input.nextInt();
      System.out.print("Nilai UAS: ");
      int nilaiUAS = input.nextInt();
      input.nextLine(); // konsumsi newline
      dataPenilaian[i] = new Penilaian4(dataMahasiswa[indexMahasiswa], dataMataKuliah[indexMataKuliah], nilaiTugas, nilaiUTS, nilaiUAS);
    }

    CariUrut4 dataCariUrut = new CariUrut4();

    menu(dataMahasiswa, dataMataKuliah, dataPenilaian, dataCariUrut);
  }

  static void menu(Mahasiswa4[] dataMahasiswa, MataKuliah4[] dataMataKuliah, Penilaian4[] dataPenilaian, CariUrut4 dataCariUrut) {
    Scanner input4 = new Scanner(System.in);
    boolean menu = true;

    while (menu) {
      System.out.println("\n=== MENU SISTEM AKADEMIK ===");
      System.out.println("1. Tampilkan Daftar Mahasiswa");
      System.out.println("2. Tampilkan Daftar Mata Kuliah");
      System.out.println("3. Tampilkan Data Penilaian");
      System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
      System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
      System.out.println("0. Keluar");
      System.out.print("Pilih menu: ");
      byte pilihMenu = input4.nextByte();
      input4.nextLine();

      switch (pilihMenu) {
        case 1:
          System.out.println("\nDaftar Mahasiswa:");
          System.out.printf("%-15s %-30s %-30s\n", "NIM", "Nama", "Prodi");
          System.out.println("------------------------------------------------------------");
          for (int i = 0; i < dataMahasiswa.length; i++) {
            dataMahasiswa[i].tampilMahasiswa();
          }
          break;
        case 2:
          System.out.println("\nDaftar Mata Kuliah:");
          System.out.printf("%-10s %-30s %-5s\n", "Kode MK", "Nama", "SKS");
          System.out.println("------------------------------------------------------------");
          for (int i = 0; i < dataMataKuliah.length; i++) {
            dataMataKuliah[i].tampilMataKuliah();
          }
          break;
        case 3:
          System.out.println("\nData Penilaian:");
          System.out.printf("%-30s %-30s %-5s\n", "Nama", "Mata Kuliah", "Nilai Akhir");
          System.out.println("------------------------------------------------------------");
          for (int i = 0; i < dataPenilaian.length; i++) {
            dataPenilaian[i].hitungNilaiAkhir();
          }
          break;
        case 4:
          System.out.println("\nNilai Akhir:");
          System.out.printf("%-30s %-30s %-5s\n", "Nama", "Mata Kuliah", "Nilai Akhir");
          System.out.println("------------------------------------------------------------");
          dataCariUrut.urutNilaiAkhir(dataPenilaian);
          break;
        case 5:
          System.out.println("\nCari Mahasiswa:");
          System.out.print("Masukkan NIM mahasiswa yang dicari: ");
          String nimDicari = input4.nextLine();
          dataCariUrut.cariNimMahasiswa(dataMahasiswa, nimDicari);
          break;
        case 0:
          menu = false;
          break;
        default:
          System.out.println("\ninput tidak valid!");
      }
    }

    System.out.println("\n=== TERIMA KASIH ===");

    input4.close();
  }
}