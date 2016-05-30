/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pengpolbayes_fix;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class bacaDataset {

    private String inputFile;
    String[][] data = null;
    String[][] tes = null;

    /**
     * Untuk mengambil dataset dari Excel ke array string 2 dimensi.
     *
     * @param inputFile string nama file atau direktori
     * @throws IOException
     * @throws BiffException
     */
    public void setDatasetTraining(String inputFile) throws IOException, BiffException {
//        System.out.println("input file : " + inputFile);
        this.inputFile = inputFile;
        File dataset = new File(inputFile);

        Workbook w = Workbook.getWorkbook(dataset);

        Sheet ssh = w.getSheet(0);
        data = new String[ssh.getColumns()][ssh.getRows()];
        for (int j = 0; j <= 6; j++) {
            for (int i = 1; i <= 70; i++) {
                Cell sel = ssh.getCell(j, i);
                data[j][i] = sel.getContents();
            }
        }

////        buat nyoba
//        Cell testambil = ssh.getCell(0, 0);
//        cell[0][0] = testambil.getContents();
//        System.out.println("kolom 1 data 4 : " + cell[0][0]);
    }

    public void setDatasetTesting(String inputFile) throws IOException, BiffException {
//        System.out.println("input file : " + inputFile);
        this.inputFile = inputFile;
        File dataset = new File(inputFile);

        Workbook w = Workbook.getWorkbook(dataset);

        Sheet ssh = w.getSheet(1);
        tes = new String[ssh.getColumns()][ssh.getRows()];
        for (int j = 0; j <= 6; j++) {
            for (int i = 0; i <= 36; i++) {
                Cell sel = ssh.getCell(j, i);
                tes[j][i] = sel.getContents();
            }
        }
    }

    /**
     * Untuk mengembalikan dataset dalam bentuk array 2 dimensi
     *
     * @return array 2 dimensi
     */
    public String[][] getDataset() {
        return data;
    }

    public String[][] getDatasetTest() {
        return tes;
    }
//    public void setKelas(String inputFile) throws IOException, BiffException {
//        this.inputFile = inputFile;
//        File dataset = new File(inputFile);
//
//        Workbook w = Workbook.getWorkbook(dataset);
//
//        Sheet ssh = w.getSheet(0);
//        String[][] cell = new String[ssh.getColumns()][ssh.getRows()];
//        int j = 1;
//        for (int i = 1; i <= 100; i++) {
//            Cell sel = ssh.getCell(j, i);
//            kelas[j][i] = sel.getContents();
//        }
//    }
//     public String[][] getKelas() {
//        return kelas;
//    }
}
