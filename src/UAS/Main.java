/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;
import java.util.Scanner;

// NAMA  : MOGOODIYAI PRAYER SAMUEL TEKEGE
// KELAS : INFORMATIKA A 1
// NPM   : 41155050220042
// MATKUL: PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK (P-PBO)

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        boolean loop = true;
        UASPBO uas = new UASPBO();
        
        // Deskripsi
        do{
            System.out.println("MENU");
            System.out.println("0. Exit");
            System.out.println("1. Tampil Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.print("Masukan [0-4]: ");

            // agar saya tidak perlu melakukan cin,nextInt() lalu nextLine lagi maka saya satukan langsung di dlm kondisi switch
            switch(Integer.valueOf(cin.nextLine())){
                case 0 : {
                    loop = false; 
                    System.out.println("\nTerimakasih..!!");
                    break;
                }
                case 1 : {
                    // show data
                    uas.showData();
                    break;
                }
                case 2 : {
                    // Add data
                    uas.addData();
                    break;
                }
                case 3 : {
                    // Update data
                    uas.updateData();
                    break;
                }
                case 4 : {
                    // Delete data
                    uas.deleteData();
                    break;
                }
                default : break;
            }

        } while(loop);
    }
}
