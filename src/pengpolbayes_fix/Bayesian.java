package pengpolbayes_fix;

import java.util.Scanner;

public class Bayesian {

    String[][] dataset;
    String jmlLaporan, jmlMataKuliah, jmlLSOUKM, jmlPanitia, jmlTugas, jmlTugasAkhir;
    double priorProbS, priorProbL, priorProbSL, priorProbSS, priorProbB;
    double peluangS, peluangL;
    double poinMataKuliah, poinLaporan, poinTugasAkhir, poinTugas;
    int jmlBiasa = 0;
    int jmlSangatLonggar = 0;
    int jmlSangatSibuk = 0;
    int jmlLonggar = 0;
    int jmlSibuk = 0;
    double pBiasa, pLonggar, pSangatLonggar, pSangatSibuk, pSibuk;

    /**
     *
     */
    public void hitungBayes(String[][] data) {

        dataset = data;
//        System.out.println("row : " + dataset[0].length);
//        System.out.println("tes 1: " + dataset[0][1]);
//        System.out.println("tes 2: " + dataset[1][1]);
//        System.out.println("tes 3: " + dataset[2][1]);
//        System.out.println("tes 4: " + dataset[3][1]);
//        System.out.println("tes 5: " + dataset[4][1]);
//        System.out.println("tes 6: " + dataset[5][1]);
//        System.out.println("tes 7: " + dataset[6][1]);
//           //        int Pilih;
        //Menghitung jumlah kelas
        //Kelas ada di 6
        for (int i = 1; i <= 70; i++) {
            if (dataset[6][i] == null) {
                continue;
            } else if (dataset[6][i].equalsIgnoreCase("Biasa Saja")) {
                jmlBiasa++;
            } else if (dataset[6][i].equalsIgnoreCase("Longgar")) {
                jmlLonggar++;
            } else if (dataset[6][i].equalsIgnoreCase("Sangat Longgar")) {
                jmlSangatLonggar++;
            } else if (dataset[6][i].equalsIgnoreCase("Sangat Sibuk")) {
                jmlSangatSibuk++;
            } else if (dataset[6][i].equalsIgnoreCase("Sibuk")) {
                jmlSibuk++;

            }

        }
        //menghitung prior probability
        priorProbS = jmlSibuk / 70d;
        priorProbL = jmlLonggar / 70d;
        priorProbSL = jmlSangatLonggar / 70d;
        priorProbSS = jmlSangatSibuk / 70d;
        priorProbB = jmlBiasa / 70d;

        System.out.println("===PRIOR===");
        System.out.println("Sibuk : " + priorProbS);
        System.out.println("Biasa : " + priorProbB);
        System.out.println("Longgar : " + priorProbL);
        System.out.println("Sangat Longgar : " + priorProbSL);
        System.out.println("Sangat SIbuk : " + priorProbSS);

    }

    public void hitungLikelihood(String jmlLaporan1, String jmlMataKuliah1, String jmlLSOUKM1, String jmlPanitia1, String jmlTugas1, String jmlTugasAkhir1, String[][] data) {

        dataset = data;
        jmlLaporan = jmlLaporan1;
        jmlMataKuliah = jmlMataKuliah1;
        jmlLSOUKM = jmlLSOUKM1;
        jmlPanitia = jmlPanitia1;
        jmlTugas = jmlTugas1;
        jmlTugasAkhir = jmlTugasAkhir1;
//        System.out.println("laporan masuk : "+jmlLaporan);

//        System.out.println("biasa " + jmlBiasa);
        //menghitung likelihood
        //Biasa Saja
//         p(laporan|biasa saja)
        int jmlLaporanBiasa = 0;
        for (int i = 1; i <= 70; i++) {
//            System.out.println("data " + dataset[1][i]);
//            System.out.println("sibuk " + jmlSibuk);
            if (dataset[0][i].equalsIgnoreCase(jmlLaporan) && dataset[6][i].equalsIgnoreCase("Biasa Saja")) {
                jmlLaporanBiasa++;
//                System.out.println("laporan biasa : " + jmlLaporanBiasa);
            }
        }
        double likelihoodLaporanB = (double) jmlLaporanBiasa / jmlBiasa;
//        System.out.println("llk laporan biasa : " + likelihoodLaporanB);

//         p(matkul|biasa saja)
        int jmlMatkulBiasa = 0;
        for (int i = 1; i <= 70; i++) {
//            System.out.println("matkul "+dataset[1][i]);
            if (dataset[1][i].equalsIgnoreCase(jmlMataKuliah) && dataset[6][i].equalsIgnoreCase("Biasa Saja")) {
                jmlMatkulBiasa++;
            }
        }
        double likelihoodMatkulB = (double) jmlMatkulBiasa / jmlBiasa;
//        System.out.println("llk matkul biasa: " + likelihoodMatkulB);

//         p(LsoUkm|biasa saja)
        int jmlLSOUKMBiasa = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[2][i].equalsIgnoreCase(jmlLSOUKM) && dataset[6][i].equalsIgnoreCase("Biasa Saja")) {
                jmlLSOUKMBiasa++;
            }
        }
        double likelihoodLSOUKMB = (double) jmlLSOUKMBiasa / jmlBiasa;
//        System.out.println("llk lsoukm biasa : " + likelihoodLSOUKMB);

//         p(laporan|biasa saja)
        int jmlPanitiaBiasa = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[3][i].equalsIgnoreCase(jmlPanitia) && dataset[6][i].equalsIgnoreCase("Biasa Saja")) {
                jmlPanitiaBiasa++;
            }
        }
        double likelihoodPanitiaB = (double) jmlPanitiaBiasa / jmlBiasa;
//        System.out.println("llk panitia biasa : " + likelihoodPanitiaB);

//         p(tugas|biasa saja)
        int jmlTugasBiasa = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[4][i].equalsIgnoreCase(jmlTugas) && dataset[6][i].equalsIgnoreCase("Biasa Saja")) {
//                System.out.println("masuk");
                jmlTugasBiasa++;
            }
        }
//        System.out.println("jumlah tugas biasa : " + jmlTugasBiasa);
        double likelihoodTugasB = (double) jmlTugasBiasa / jmlBiasa;
//        System.out.println("likelihood tugas : " + likelihoodTugasB);

//         p(tugasAkhir|biasa saja)
        int jmlTugasAkhirBiasa = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[5][i].equalsIgnoreCase(jmlTugasAkhir) && dataset[6][i].equalsIgnoreCase("Biasa Saja")) {
                jmlTugasAkhirBiasa++;
            }
        }
        double likelihoodTugasAkhirB = (double) jmlTugasAkhirBiasa / jmlBiasa;
//        System.out.println("likelihood biasa : " + likelihoodTugasAkhirB);
        pBiasa = priorProbB * likelihoodMatkulB * likelihoodLaporanB * likelihoodTugasAkhirB * likelihoodTugasB * likelihoodLSOUKMB * likelihoodPanitiaB;
//        System.out.println("proster biasa : " + pBiasa);

        //Longgar
//         p(laporan|Longgar)
        int jmlLaporanLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[0][i].equalsIgnoreCase(jmlLaporan) && dataset[6][i].equalsIgnoreCase("Longgar")) {
                jmlLaporanLonggar++;
            }
        }
        double likelihoodLaporanL = (double) jmlLaporanLonggar / jmlLonggar;
//         p(matkul|Longgar)
        int jmlMatkulLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[1][i].equalsIgnoreCase(jmlMataKuliah) && dataset[6][i].equalsIgnoreCase("Longgar")) {
                jmlMatkulLonggar++;
            }
        }
        double likelihoodMatkulL = (double) jmlMatkulLonggar / jmlLonggar;
//         p(LsoUkm|Longgar)
        int jmlLSOUKMLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[2][i].equalsIgnoreCase(jmlLSOUKM) && dataset[6][i].equalsIgnoreCase("Longgar")) {
                jmlLSOUKMLonggar++;
            }
        }
        double likelihoodLSOUKML = (double) jmlLSOUKMLonggar / jmlLonggar;
//         p(laporan|Longgar)
        int jmlPanitiaLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[3][i].equalsIgnoreCase(jmlPanitia) && dataset[6][i].equalsIgnoreCase("Longgar")) {
                jmlPanitiaLonggar++;
            }
        }
        double likelihoodPanitiaL = (double) jmlPanitiaLonggar / jmlLonggar;
//         p(tugas|Longgar)
        int jmlTugasLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[4][i].equalsIgnoreCase(jmlTugas) && dataset[6][i].equalsIgnoreCase("Longgar")) {
                jmlTugasLonggar++;
            }
        }
        double likelihoodTugasL = (double) jmlTugasLonggar / jmlLonggar;
//         p(tugasAkhir|Longgar)
        int jmlTugasAkhirLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[5][i].equalsIgnoreCase(jmlTugasAkhir) && dataset[6][i].equalsIgnoreCase("Longgar")) {
                jmlTugasAkhirLonggar++;
            }
        }
        double likelihoodTugasAkhirL = (double) jmlTugasAkhirLonggar / jmlLonggar;
        pLonggar = priorProbL * likelihoodMatkulL * likelihoodLaporanL * likelihoodTugasAkhirL * likelihoodTugasL * likelihoodLSOUKML * likelihoodPanitiaL;

        //SangatLonggar
//         p(laporan|SangatLonggar)
        int jmlLaporanSangatLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[0][i].equalsIgnoreCase(jmlLaporan) && dataset[6][i].equalsIgnoreCase("Sangat Longgar")) {
                jmlLaporanSangatLonggar++;
            }
        }
        double likelihoodLaporanSL = (double) jmlLaporanSangatLonggar / jmlSangatLonggar;
//         p(matkul|SangatLonggar)
        int jmlMatkulSangatLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[1][i].equalsIgnoreCase(jmlMataKuliah) && dataset[6][i].equalsIgnoreCase("Sangat Longgar")) {
                jmlMatkulSangatLonggar++;
            }
        }
        double likelihoodMatkulSL = (double) jmlMatkulSangatLonggar / jmlSangatLonggar;
//         p(LsoUkm|SangatLonggar)
        int jmlLSOUKMSangatLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[2][i].equalsIgnoreCase(jmlLSOUKM) && dataset[6][i].equalsIgnoreCase("Sangat Longgar")) {
                jmlLSOUKMSangatLonggar++;
            }
        }
        double likelihoodLSOUKMSL = (double) jmlLSOUKMSangatLonggar / jmlSangatLonggar;
//         p(panitia|SangatLonggar)
        int jmlPanitiaSangatLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[3][i].equalsIgnoreCase(jmlPanitia) && dataset[6][i].equalsIgnoreCase("Sangat Longgar")) {
                jmlPanitiaSangatLonggar++;
            }
        }
        double likelihoodPanitiaSL = (double) jmlPanitiaSangatLonggar / jmlSangatLonggar;
//         p(tugas|SangatLonggar)
        int jmlTugasSangatLonggar = 0;
//        System.out.println("tugas : "+jmlTugas);
        for (int i = 1; i <= 70; i++) {
            if (dataset[4][i].equalsIgnoreCase(jmlTugas) && dataset[6][i].equalsIgnoreCase("Sangat Longgar")) {
                jmlTugasSangatLonggar++;
            }
        }
        double likelihoodTugasSL = (double) jmlTugasSangatLonggar / jmlSangatLonggar;
//        System.out.println("llk tugas SL : " + likelihoodTugasSL);
//        System.out.println("jml tugas : " + jmlTugasSangatLonggar);
//        System.out.println("jml tugas sl : " + jmlSangatLonggar);

//         p(tugasAkhir|SangatLonggar)
        int jmlTugasAkhirSangatLonggar = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[5][i].equalsIgnoreCase(jmlTugasAkhir) && dataset[6][i].equalsIgnoreCase("Sangat Longgar")) {
                jmlTugasAkhirSangatLonggar++;
            }
        }
        double likelihoodTugasAkhirSL = (double) jmlTugasAkhirSangatLonggar / jmlSangatLonggar;
//        System.out.println("likelihood matkul SangatLonggar :" + likelihoodMatkulSL);
//        System.out.println("likelihood laporanSangatLonggar :" + likelihoodLaporanSL);
//        System.out.println("likelihood tugas SangatLonggar :" + likelihoodTugasSL);
//        System.out.println("likelihood ta SangatLonggar :" + likelihoodTugasAkhirSL);
//        System.out.println("likelihood lsoSangatLonggar :" + likelihoodLSOUKMSL);
//        System.out.println("likelihood panitia SangatLonggar :" + likelihoodPanitiaSL);
        pSangatLonggar = priorProbSL * likelihoodMatkulSL * likelihoodLaporanSL * likelihoodTugasAkhirSL * likelihoodTugasSL * likelihoodLSOUKMSL * likelihoodPanitiaSL;

        //SangatSibuk
//         p(laporan|SangatSibuk)
        int jmlLaporanSangatSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[0][i].equalsIgnoreCase(jmlLaporan) && dataset[6][i].equalsIgnoreCase("Sangat Sibuk")) {
                jmlLaporanSangatSibuk++;
            }
        }
        double likelihoodLaporanSS = (double) jmlLaporanSangatSibuk / jmlSangatSibuk;
//         p(matkul|biasa SangatSibuk)
        int jmlMatkulSangatSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[1][i].equalsIgnoreCase(jmlMataKuliah) && dataset[6][i].equalsIgnoreCase("Sangat Sibuk")) {
                jmlMatkulSangatSibuk++;
            }
        }
        double likelihoodMatkulSS = (double) jmlMatkulSangatSibuk / jmlSangatSibuk;
//         p(LsoUkm|SangatSibuk)
        int jmlLSOUKMSangatSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[2][i].equalsIgnoreCase(jmlLSOUKM) && dataset[6][i].equalsIgnoreCase("Sangat Sibuk")) {
                jmlLSOUKMSangatSibuk++;
            }
        }
        double likelihoodLSOUKMSS = (double) jmlLSOUKMSangatSibuk / jmlSangatSibuk;
//         p(Panitia|SangatSibuk)
        int jmlPanitiaSangatSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[3][i].equalsIgnoreCase(jmlPanitia) && dataset[6][i].equalsIgnoreCase("Sangat Sibuk")) {
                jmlPanitiaSangatSibuk++;
            }
        }
        double likelihoodPanitiaSS = (double) jmlPanitiaSangatSibuk / jmlSangatSibuk;
//         p(tugas|SangatSibuk)
        int jmlTugasSangatSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[4][i].equalsIgnoreCase(jmlTugas) && dataset[6][i].equalsIgnoreCase("Sangat Sibuk")) {
                jmlTugasSangatSibuk++;
            }
        }
        double likelihoodTugasSS = (double) jmlTugasSangatSibuk / jmlSangatSibuk;
//         p(tugasAkhir|SangatSibuk)
        int jmlTugasAkhirSangatSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[5][i].equalsIgnoreCase(jmlTugasAkhir) && dataset[6][i].equalsIgnoreCase("Sangat Sibuk")) {
                jmlTugasAkhirSangatSibuk++;
            }
        }
        double likelihoodTugasAkhirSS = (double) jmlTugasAkhirSangatSibuk / jmlSangatSibuk;
        pSangatSibuk = priorProbSS * likelihoodMatkulSS * likelihoodLaporanSS * likelihoodTugasAkhirSS * likelihoodTugasSS * likelihoodLSOUKMSS * likelihoodPanitiaSS;

        //Sibuk
//         p(laporan|Sibuk)
        int jmlLaporanSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[0][i].equalsIgnoreCase(jmlLaporan) && dataset[6][i].equalsIgnoreCase("Sibuk")) {
                jmlLaporanSibuk++;
            }
        }
        double likelihoodLaporanS = (double) jmlLaporanSibuk / jmlSibuk;
//         p(matkul|Sibuk)
        int jmlMatkulSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[1][i].equalsIgnoreCase(jmlMataKuliah) && dataset[6][i].equalsIgnoreCase("Sibuk")) {
                jmlMatkulSibuk++;
            }
        }
        double likelihoodMatkulS = (double) jmlMatkulSibuk / jmlSibuk;
//         p(LsoUkm|Sibuk)
        int jmlLSOUKMSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[2][i].equalsIgnoreCase(jmlLSOUKM) && dataset[6][i].equalsIgnoreCase("Sibuk")) {
                jmlLSOUKMSibuk++;
            }
        }
        double likelihoodLSOUKMS = (double) jmlLSOUKMSibuk / jmlSibuk;
//         p(panitia|Sibuk)
        int jmlPanitiaSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[3][i].equalsIgnoreCase(jmlPanitia) && dataset[6][i].equalsIgnoreCase("Sibuk")) {
                jmlPanitiaSibuk++;
            }
        }
        double likelihoodPanitiaS = (double) jmlPanitiaSibuk / jmlSibuk;
//         p(tugas|Sibuk)
        int jmlTugasSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[4][i].equalsIgnoreCase(jmlTugas) && dataset[6][i].equalsIgnoreCase("Sibuk")) {
                jmlTugasSibuk++;
            }
        }
        double likelihoodTugasS = (double) jmlTugasSibuk / jmlSibuk;
//         p(tugasAkhir|Sibuk)
        int jmlTugasAkhirSibuk = 0;
        for (int i = 1; i <= 70; i++) {
            if (dataset[5][i].equalsIgnoreCase(jmlTugasAkhir) && dataset[6][i].equalsIgnoreCase("Sibuk")) {
                jmlTugasAkhirSibuk++;
            }
        }
        double likelihoodTugasAkhirS = (double) jmlTugasAkhirSibuk / jmlSibuk;
//        System.out.println("likelihood matkul sibuk :"+likelihoodMatkulS);
//        System.out.println("likelihood laporan sibuk :"+likelihoodLaporanS);
//        System.out.println("likelihood tugas sibuk :"+likelihoodTugasAkhirS);
//        System.out.println("likelihood ta sibuk :"+likelihoodTugasS);
//        System.out.println("likelihood lso sibuk :"+likelihoodLSOUKMS );
//        System.out.println("likelihood panitia sibuk :"+likelihoodPanitiaS);

        pSibuk = priorProbS * likelihoodMatkulS * likelihoodLaporanS * likelihoodTugasAkhirS * likelihoodTugasS * likelihoodLSOUKMS * likelihoodPanitiaS;
//        System.out.println("=================HASIL========================");
        System.out.print("HASIL ");
        String kelasYangDicari = menentukanKelas(pBiasa, pLonggar, pSangatLonggar, pSangatSibuk, pSibuk);
//        System.out.println("TINGKAT KESIBUKAN ANDA : " + kelasYangDicari);
        System.out.println("TINGKAT KESIBUKAN : " + kelasYangDicari);
    }

    public String menentukanKelas(double pBiasa, double pLonggar, double pSangatLonggar, double pSangatSibuk, double pSibuk) {
// public String menentukanKelas(){
        String arrayKelas[] = {"Biasa", "Longgar", "Sangat Longgar", "Sangat Sibuk", "Sibuk"};
        double arrayPrior[] = {pBiasa, pLonggar, pSangatLonggar, pSangatSibuk, pSibuk};
//        System.out.println();
        System.out.println("POSTERIOR : ");
        System.out.println("LONGGAR : " + pLonggar);
        System.out.println("SANGAT LONGGAR: " + pSangatLonggar);
        System.out.println("BIASA SAJA : " + pBiasa);
        System.out.println("SIBUK : " + pSibuk);
        System.out.println("SANGAT SIBUK : " + pSangatSibuk);
        System.out.println();
        int index = 0;
        double max = arrayPrior[0];
        for (int i = 0; i < arrayPrior.length; i++) {
//            System.out.println("prior : " + arrayPrior[i]);
            if (max < arrayPrior[i]) {
                max = arrayPrior[i];
                index = i;

            }
//            System.out.println("MAX : "+Math.max(pBiasa,pLonggar));
        }
        return arrayKelas[index];
    }

}
