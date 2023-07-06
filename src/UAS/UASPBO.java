/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

// NAMA  : MOGOODIYAI PRAYER SAMUEL TEKEGE
// KELAS : INFORMATIKA A 1
// NPM   : 41155050220042
// MATKUL: PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK (P-PBO)

public class UASPBO {
    int id; String todo, kategori, tanggal, status;
    Scanner cin = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/uas_prakpbo";
    String user = "root"; String pass = "";
    
    void addData(){
        System.out.print("Masukan ID            : ");
        this.id = Integer.valueOf(cin.nextLine());
        System.out.print("Masukan ToDo          : ");
        this.todo = cin.nextLine();
        System.out.print("Masukan Kategori    : ");
        this.kategori = cin.nextLine();
        System.out.print("Masukan Tgl Selesai : ");
        this.tanggal = cin.nextLine();
        System.out.print("Masukan Status      : ");
        this.status = cin.nextLine();
        
        try {
            String query = "INSERT INTO uas VALUES (" + this.id + ", '" + this.todo + "', '" + this.kategori + "', '" + this.tanggal + "', '" + this.status + "');";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.execute(query);
            System.out.println("Selamat, Data telah berhasil ditambahkan..!!!");
        } catch (Exception e) {
            System.err.println("Terjadi Kegagalan Saat menyimpan data karena : " + e);
        }
    }
    
    void showData(){
        try {
            String query = "SELECT * FROM uas;";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                System.out.println("");
                System.out.println("ID              : " + rs.getString("id"));
                System.out.println("Todo            : " + rs.getString("todo"));
                System.out.println("Kategori        : " + rs.getString("kategori"));
                System.out.println("Tanggal Selesai : " + rs.getString("tanggal_selesai"));
                System.out.println("Status          : " + rs.getString("status"));
            }
            System.out.println("");
            rs.close(); pst.close(); conn.close();
        } catch (Exception e) {
            System.err.println("Terjadi kegagalan saat menampilkan data karena : " + e);
        }
    }
    
    void deleteData(){
        System.out.print("Masukan ID yg akan dihapus : ");
        this.id = Integer.valueOf(cin.nextLine());
        
        try {
            String query = "DELETE FROM uas WHERE id=" + this.id + ";";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            System.out.println("Data Berhasil Di Hapus..!!");
        } catch (Exception e) {
            System.err.println("Terjadi kegagalan saat menghapus data karena : " + e);
        }
    }
    
    void updateData(){
        System.out.print("Masukan ID            [UPD]: ");
        this.id = Integer.valueOf(cin.nextLine());
        System.out.print("Masukan ToDo          [UPD]: ");
        this.todo = cin.nextLine();
        System.out.print("Masukan Kategori    [UPD]: ");
        this.kategori = cin.nextLine();
        System.out.print("Masukan Tgl Selesai [UPD]: ");
        this.tanggal = cin.nextLine();
        System.out.print("Masukan Status      [UPD]: ");
        this.status = cin.nextLine();
        
        try {
            String query = "UPDATE uas SET todo='" + this.todo + "', kategori='" + this.kategori + "', tanggal_selesai='" + this.tanggal + "', status = '" + this.status + "' WHERE id=" + this.id + ";";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            System.out.println("Data telah berhasil di Update..!!!");
        } catch (Exception e) {
            System.err.println("Terjadi kegagalan saat mengupdate data karena : " + e);
        }
    }
}
