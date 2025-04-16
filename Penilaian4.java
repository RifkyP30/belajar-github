public class Penilaian4 {
  Mahasiswa4 mahasiswa;
  MataKuliah4 mataKuliah;
  double nilaiTugas;
  double nilaiUTS;
  double nilaiUAS;
  double nilaiAkhir;

  Penilaian4(Mahasiswa4 mahasiswa, MataKuliah4 mataKuliah, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
    this.mahasiswa = mahasiswa;
    this.mataKuliah = mataKuliah;
    this.nilaiTugas = nilaiTugas;
    this.nilaiUTS = nilaiUTS;
    this.nilaiUAS = nilaiUAS;
  }

  void hitungNilaiAkhir() {
    nilaiAkhir = nilaiTugas * 0.3 + nilaiUTS * 0.3 + nilaiUAS * 0.4;
    System.out.printf("%-30s %-30s %.1f\n", this.mahasiswa.nama, this.mataKuliah.namaMK, this.nilaiAkhir);
  }
}