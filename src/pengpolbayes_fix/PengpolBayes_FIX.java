package pengpolbayes_fix;

import java.io.IOException;
import java.util.Scanner;
import jxl.read.biff.BiffException;

public class PengpolBayes_FIX {

    public static void main(String[] args) throws IOException, BiffException {
        Bayesian bayes = new Bayesian();
        bacaDataset baca = new bacaDataset();
        System.out.println("TRAINING PHASE");
        baca.setDatasetTraining("Dataset.xls");
        String[][] kebaca = baca.getDataset();
        baca.setDatasetTesting("Dataset.xls");
        String[][] tes = baca.getDatasetTest();
        bayes.hitungBayes(kebaca);
        Scanner in = new Scanner(System.in);
        String laporan = null, matkul = null, lsoukm = null, panitia = null, tugas = null, pa = null;
        System.out.println();
        System.out.println("TEST INPUT MANUAL");
        laporan = "2";
        matkul = "5";
        lsoukm = "tidak";
        panitia = "ya";
        tugas = "3";
        pa = "5";
        bayes.hitungLikelihood(laporan, matkul, lsoukm, panitia, tugas, pa, kebaca);
        System.out.println();
        System.out.println("TEST PHASE");
        System.out.println("Pilih test berdasarkan cara input test : ");
        System.out.println("1. Dataset Testing");
        System.out.println("2. Input sendiri");
        System.out.print("Pilih angka : ");
        int tesPilih = in.nextInt();
        switch (tesPilih) {
            case 1:

                for (int i = 0; i < tes[0].length; i++) {
                    System.out.println("==============DATASET TESTTING=================");
                    System.out.println("INDEX : " + i);
                    laporan = tes[0][i];
                    matkul = tes[1][i];
                    lsoukm = tes[2][i];
                    panitia = tes[3][i];
                    tugas = tes[4][i];
                    pa = tes[5][i];
                    System.out.println("Laporan : " + laporan);
                    System.out.println("Jumlah Matkul : " + matkul);
                    System.out.println("Mengikuti LSO/UKM : " + lsoukm);
                    System.out.println("Mengikuti Panitia :  " + panitia);
                    System.out.println("Rata-rata tugas per minggu : " + tugas);
                    System.out.println("Projek Akhir : " + pa);
                    System.out.println();
                    bayes.hitungLikelihood(laporan, matkul, lsoukm, panitia, tugas, pa, kebaca);
                }
                break;
            case 2:
                //FITUR 1
                System.out.println("==============INPUT SENDIRI===============");
                System.out.println("Pilih jumlah laporan perminggu Anda : ");
                System.out.println("1. 1");
                System.out.println("2. 2");
                System.out.println("3. 3");
                System.out.println("4. >3");
                System.out.print("Input Angka : ");
                int pilih = in.nextInt();
                switch (pilih) {
                    case 1:
                        laporan = "1";
                        break;
                    case 2:
                        laporan = "2";
                        break;
                    case 3:
                        laporan = "3";
                        break;
                    case 4:
                        laporan = ">3";
                        break;
                    default:
                        System.out.println("Maaf nilai masukkan Anda salah");
                        break;
                }
                System.out.println("");

                //FITUR 2
                System.out.println("Pilih jumlah matakuliah yang diambil: ");
                System.out.println("1. 2");
                System.out.println("2. 3");
                System.out.println("3. 4");
                System.out.println("4. 5");
                System.out.println("5. 6");
                System.out.println("6. 7");
                System.out.println("7. 8");
                System.out.println("8. 9");
                System.out.println("9. 10");
                System.out.println("10. 11");
                System.out.print("Input Angka : ");
                pilih = in.nextInt();
                switch (pilih) {
                    case 1:
                        matkul = "2";
                        break;
                    case 2:
                        matkul = "3";
                        break;
                    case 3:
                        matkul = "4";
                        break;
                    case 4:
                        matkul = "5";
                        break;
                    case 5:
                        matkul = "6";
                        break;
                    case 6:
                        matkul = "7";
                        break;
                    case 7:
                        matkul = "8";
                        break;
                    case 8:
                        matkul = "9";
                        break;
                    case 9:
                        matkul = "10";
                        break;
                    case 10:
                        matkul = "11";
                        break;
                    default:
                        System.out.println("Maaf nilai masukkan Anda salah");
                        break;
                }
                System.out.println("");

                //FITUR 3
                System.out.println("Apakah Anda mengikuti LSO atau UKM? : ");
                System.out.println("1. YA");
                System.out.println("2. TIDAK");
                System.out.print("Input Angka : ");
                pilih = in.nextInt();
                switch (pilih) {
                    case 1:
                        lsoukm = "Ya";
                        break;
                    case 2:
                        lsoukm = "Tidak";
                        break;
                    default:
                        System.out.println("Maaf nilai masukkan Anda salah");
                        break;
                }
                System.out.println("");

                //FITUR 4
                System.out.println("Apakah Anda mengikuti kepanitiaan? : ");
                System.out.println("1. YA");
                System.out.println("2. TIDAK");
                System.out.print("Input Angka : ");
                pilih = in.nextInt();
                switch (pilih) {
                    case 1:
                        panitia = "Ya";
                        break;
                    case 2:
                        panitia = "Tidak";
                        break;
                    default:
                        System.out.println("Maaf nilai masukkan Anda salah");
                        break;
                }
                System.out.println("");

                //FITUR 5
                System.out.println("Pilih jumlah rata-rata tugas yang diberikan dosen setiap minggu: ");
                System.out.println("1. 1");
                System.out.println("2. 2");
                System.out.println("3. 3");
                System.out.println("4. 4");
                System.out.println("5. 5");
                System.out.println("6. >5");
                System.out.print("Input Angka : ");
                pilih = in.nextInt();
                switch (pilih) {
                    case 1:
                        tugas = "1";
                        break;
                    case 2:
                        tugas = "2";
                        break;
                    case 3:
                        tugas = "3";
                        break;
                    case 4:
                        tugas = "4";
                        break;
                    case 5:
                        tugas = "5";
                        break;
                    case 6:
                        tugas = ">5";
                        break;
                    default:
                        System.out.println("Maaf nilai masukkan Anda salah");
                        break;
                }
                System.out.println("");

                //FITUR 6
                System.out.println("Pilih jumlah proyek akhir yang Anda dapatkan pada semester ini : ");
                System.out.println("1. 1");
                System.out.println("2. 2");
                System.out.println("3. 3");
                System.out.println("4. 4");
                System.out.println("5. 5");
                System.out.println("6. >5");
                System.out.print("Input Angka : ");
                pilih = in.nextInt();
                switch (pilih) {
                    case 1:
                        pa = "1";
                        break;
                    case 2:
                        pa = "2";
                        break;
                    case 3:
                        pa = "3";
                        break;
                    case 4:
                        pa = "4";
                        break;
                    case 5:
                        pa = "5";
                        break;
                    case 6:
                        pa = ">5";
                        break;
                    default:
                        System.out.println("Maaf nilai masukkan Anda salah");
                        break;
                }
                System.out.println();
                System.out.println("Laporan : " + laporan);
                System.out.println("Jumlah Matkul : " + matkul);
                System.out.println("Mengikuti LSO/UKM : " + lsoukm);
                System.out.println("Mengikuti Panitia :  " + panitia);
                System.out.println("Rata-rata tugas per minggu : " + tugas);
                System.out.println("Projek Akhir : " + pa);
                System.out.println();
                bayes.hitungLikelihood(laporan, matkul, lsoukm, panitia, tugas, pa, kebaca);

                break;
        }
        //DEBUG BACA DATASET
//        System.out.println("KOLOM 1");
//        for (int i = 0; i < 1; i++) {
//            for (int j = 1; j <= 100; j++) {
//                System.out.println("baris ke-"+(j)+" "+kebaca[i][j]);
//            }
//        }
//        System.out.println("KOLOM 2");
//         for (int i = 1; i < 2; i++) {
//            for (int j = 1; j <= 100; j++) {
//                System.out.println("baris ke-"+(j)+" "+kebaca[i][j]);
//            }
//        }
//         System.out.println("KOLOM 3");
//          for (int i = 2; i < 3; i++) {
//            for (int j = 1; j <= 100; j++) {
//                System.out.println("baris ke-"+(j)+" "+kebaca[i][j]);
//            }
//        }
//          System.out.println("KOLOM 4");
//           for (int i = 3; i < 4; i++) {
//            for (int j = 1; j <= 100; j++) {
//                System.out.println("baris ke-"+(j)+" "+kebaca[i][j]);
//            }
//        }
//           System.out.println("KOLOM 5");
//            for (int i = 4; i < 5; i++) {
//            for (int j = 1; j <= 100; j++) {
//                System.out.println("baris ke-"+(j)+" "+kebaca[i][j]);
//            }
//        }
//            System.out.println("KOLOM 6");
//             for (int i = 5; i < 6; i++) {
//            for (int j = 1; j <= 100; j++) {
//                System.out.println("baris ke-"+(j)+" "+kebaca[i][j]);
//            }
    }
}
