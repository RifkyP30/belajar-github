import java.util.Scanner;

public class Main4 {
  public static void main(String[] args) {
    // judul program
    System.out.println("===== SISTEM PENGELOLAAN NILAI MAHASISWA =====");
    // membuat array of object
    Mahasiswa4[] dataMahasiswa = new Mahasiswa4[3];
    MataKuliah4[] dataMataKuliah = new MataKuliah4[5];
    Penilaian4[] dataPenilaian = new Penilaian4[6];
    CariUrut4 dataCariUrut = new CariUrut4();
    // data mahasiswa
    dataMahasiswa[0] = new Mahasiswa4("244107020061", "Muhammad Daniel Assaqovi", "Informatika");
    dataMahasiswa[1] = new Mahasiswa4("244107020096", "Muhammad Rifky Praditya", "Informatika");
    dataMahasiswa[2] = new Mahasiswa4("244107020095", "Rachmad Febriananda", "Informatika");
    // data mata kuliah
    dataMataKuliah[0] = new MataKuliah4("MK001", "Algoritma & Struktur Data", 2);
    dataMataKuliah[1] = new MataKuliah4("MK002", "Aljabar Linier", 2);
    dataMataKuliah[2] = new MataKuliah4("MK003", "Bahasa Inggris", 3);
    dataMataKuliah[3] = new MataKuliah4("MK004", "Desain Antarmuka", 3);
    dataMataKuliah[4] = new MataKuliah4("MK005", "Basis Data", 2);
    // data penilaian
    /*
      1. Muhammad Daniel Assaqovi = Algoritma & Struktur Data, Basis Data
      2. Muhammad Rifky Praditya = Aljabar Liner, Bahasa Inggris
      3. Rachmad Febriananda = Aljabar Liner, Desain Antarmuka
    */
    dataPenilaian[0] = new Penilaian4(dataMahasiswa[0], dataMataKuliah[0], 80, 83, 87);
    dataPenilaian[1] = new Penilaian4(dataMahasiswa[0], dataMataKuliah[4], 78, 82, 85);
    dataPenilaian[2] = new Penilaian4(dataMahasiswa[1], dataMataKuliah[1], 82, 85, 87);
    dataPenilaian[3] = new Penilaian4(dataMahasiswa[1], dataMataKuliah[2], 84, 88, 90);
    dataPenilaian[4] = new Penilaian4(dataMahasiswa[2], dataMataKuliah[1], 85, 87, 93);
    dataPenilaian[5] = new Penilaian4(dataMahasiswa[2], dataMataKuliah[3], 77, 84, 86);

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