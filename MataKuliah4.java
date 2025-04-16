public class MataKuliah4 {
  String kodeMK;
  String namaMK;
  int sks;

  MataKuliah4(String kodeMK, String namaMK, int sks) {
    this.kodeMK = kodeMK;
    this.namaMK = namaMK;
    this.sks = sks;
  }

  void tampilMataKuliah() {
    System.out.printf("%-10s %-30s %-5s\n", this.kodeMK, this.namaMK, this.sks);
  }
}