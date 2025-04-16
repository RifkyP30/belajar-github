public class Mahasiswa4 {
  String NIM;
  String nama;
  String prodi;

  Mahasiswa4(String NIM, String nama, String prodi) {
    this.NIM = NIM;
    this.nama = nama;
    this.prodi = prodi;
  }

  void tampilMahasiswa() {
    System.out.printf("%-15s %-30s %-30s\n", this.NIM, this.nama, this.prodi);
  }
}