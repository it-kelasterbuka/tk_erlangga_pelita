/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import chatme.ChatMe;
import com.mbutgae.jf.chat.GUIClient;
import com.mbutgae.jf.chat.GUIServer;
import database.koneksi;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login_page.login;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Randi
 */
public class admin_page extends javax.swing.JFrame {
    
    /**
     * Creates new form admin_page
     */
    String localhost = null;
    GUIClient guiclient = new GUIClient(localhost, 1000);
    GUIServer guiserver = new GUIServer();
    
    public admin_page() {
        initComponents();
        table_data_siswa_tk();
        table_data_petugas();
        table_pendaftaran();
        tabel_pembayaran();
        table_data_pembayaran();
        koneksi.getConnection();
    }
    
    void cari(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nis");
        tbl.addColumn("Nama");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Tempat, Tgl Lahir");
        tbl.addColumn("Agama");
        tbl.addColumn("Alamat");
        tbl.addColumn("Berat Badan");
        tbl.addColumn("Tinggi Badan");
        tbl.addColumn("Nama Ayah");
        tbl.addColumn("Nama Ibu");
        tbl.addColumn("Pekerjaan Ayah");
        tbl.addColumn("Pekerjaan Ibu");
        tbl.addColumn("Jalan");
        tbl.addColumn("Kelurahan/Desa");
        tbl.addColumn("Kecamatan");
        tbl.addColumn("Kab/Kota");
        tbl.addColumn("Provinsi");
        
        try{
            String sql = "SELECT * FROM tb_datasiswa WHERE nis like '%" + tCari.getText()+ "%'";
            Connection con = (Connection) koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("nis"),
                    rs.getString("nama_peserta_didik"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("tempat_tgl_lahir"),
                    rs.getString("agama"),
                    rs.getString("alamat_peserta_didik"),
                    rs.getString("berat_badan"),
                    rs.getString("tinggi_badan"),
                    rs.getString("nama_ayah"),
                    rs.getString("nama_ibu"),
                    rs.getString("pekerjaan_ayah"),
                    rs.getString("pekerjaan_ibu"),
                    rs.getString("jalan"),
                    rs.getString("kelurahan_desa"),
                    rs.getString("kecamatan"),
                    rs.getString("kab_kota"),
                    rs.getString("provinsi")
                });
                jTable3.setModel(tbl);
            }
            
        }catch(Exception e){
        
        }
    }
    
    void cari_p(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nis");
        tbl.addColumn("Nama");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Tempat, Tgl Lahir");
        tbl.addColumn("Agama");
        tbl.addColumn("Alamat");
        tbl.addColumn("Berat Badan");
        tbl.addColumn("Tinggi Badan");
        tbl.addColumn("Nama Ayah");
        tbl.addColumn("Nama Ibu");
        tbl.addColumn("Pekerjaan Ayah");
        tbl.addColumn("Pekerjaan Ibu");
        tbl.addColumn("Jalan");
        tbl.addColumn("Kelurahan/Desa");
        tbl.addColumn("Kecamatan");
        tbl.addColumn("Kab/Kota");
        tbl.addColumn("Provinsi");
        
        try{
            String sql = "SELECT * FROM tb_datasiswa WHERE nis like '%" + tCari_p.getText()+ "%'";
            Connection con = (Connection) koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("nis"),
                    rs.getString("nama_peserta_didik"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("tempat_tgl_lahir"),
                    rs.getString("agama"),
                    rs.getString("alamat_peserta_didik"),
                    rs.getString("berat_badan"),
                    rs.getString("tinggi_badan"),
                    rs.getString("nama_ayah"),
                    rs.getString("nama_ibu"),
                    rs.getString("pekerjaan_ayah"),
                    rs.getString("pekerjaan_ibu"),
                    rs.getString("jalan"),
                    rs.getString("kelurahan_desa"),
                    rs.getString("kecamatan"),
                    rs.getString("kab_kota"),
                    rs.getString("provinsi")
                });
                jTable1.setModel(tbl);
            }
            
        }catch(Exception e){
        
        }
    }
    
    void cari_pmbyr(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("id");
        tbl.addColumn("Nis Siswa");
        tbl.addColumn("Nama Siswa");
        tbl.addColumn("Pembayaran");
        tbl.addColumn("Total Bayar");
        
        try{
            String sql = "SELECT * FROM tb_pembayaran WHERE nis like '%" + t_Cari_pm.getText()+ "%'";
            Connection con = (Connection) koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nis"),
                    rs.getString("nama_peserta_didik"),
                    rs.getString("pembayaran"),
                    rs.getString("total_bayar")
                });
                jTable5.setModel(tbl);
            }
            
        }catch(Exception e){
        
        }
    }
    
    void cari_data_pmbyr(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("id");
        tbl.addColumn("Nis Siswa");
        tbl.addColumn("Nama Siswa");
        tbl.addColumn("Pembayaran");
        tbl.addColumn("Total Bayar");
        
        try{
            String sql = "SELECT * FROM tb_pembayaran WHERE nis like '%" + t_Cari_dp.getText()+ "%'";
            Connection con = (Connection) koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nis"),
                    rs.getString("nama_peserta_didik"),
                    rs.getString("pembayaran"),
                    rs.getString("total_bayar")
                });
                jTable6.setModel(tbl);
            }
            
        }catch(Exception e){
        
        }
    }
    
    void hapus(){
        tNis.setText("");
        tNama.setText("");
        tTmpTglL.setText("");
        tAgama.setText("");
        tAlamat.setText("");
        tBB.setText("");
        tTB.setText("");
        tNA.setText("");
        tNB.setText("");
        tPA.setText("");
        tPB.setText("");
        tJalan.setText("");
        tKD.setText("");
        tK.setText("");
        tKK.setText("");
        tP.setText("");
    }
    
    void hapus_dp(){
        tUsername.setText("");
        tPass.setText("");
        tNL.setText("");
    }
    
    void hapus_pmbyr(){
        tNis_pm.setText("");
        tNS_pm.setText("");
        t_bayar.setText("");
    }
    
    void hapus_data_pembayaran(){
        t_NS_dp.setText("");
        t_NS_dp.setText("");
        t_bayar_dp.setText("");
    }
    
    void hapus_Pendaftaran(){
        tNis_p.setText("");
        tNama_p.setText("");
        tTmpTglL_p.setText("");
        tAgama_p.setText("");
        tAlamat_p.setText("");
        tBB_p.setText("");
        tTB_p.setText("");
        tNA_p.setText("");
        tNB_p.setText("");
        tPA_p.setText("");
        tPB_p.setText("");
        tJalan_p.setText("");
        tKD_p.setText("");
        tK_p.setText("");
        tKK_p.setText("");
        tP_p.setText("");
    }
    
    public void table_data_siswa_tk(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nis");
        tbl.addColumn("Nama");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Tempat, Tgl Lahir");
        tbl.addColumn("Agama");
        tbl.addColumn("Alamat");
        tbl.addColumn("Berat Badan");
        tbl.addColumn("Tinggi Badan");
        tbl.addColumn("Nama Ayah");
        tbl.addColumn("Nama Ibu");
        tbl.addColumn("Pekerjaan Ayah");
        tbl.addColumn("Pekerjaan Ibu");
        tbl.addColumn("Jalan");
        tbl.addColumn("Kelurahan/Desa");
        tbl.addColumn("Kecamatan");
        tbl.addColumn("Kab/Kota");
        tbl.addColumn("Provinsi");
        
        try{
            Statement st = (Statement) koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_datasiswa");
            
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("nis"),
                    rs.getString("nama_peserta_didik"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("tempat_tgl_lahir"),
                    rs.getString("agama"),
                    rs.getString("alamat_peserta_didik"),
                    rs.getString("berat_badan"),
                    rs.getString("tinggi_badan"),
                    rs.getString("nama_ayah"),
                    rs.getString("nama_ibu"),
                    rs.getString("pekerjaan_ayah"),
                    rs.getString("pekerjaan_ibu"),
                    rs.getString("jalan"),
                    rs.getString("kelurahan_desa"),
                    rs.getString("kecamatan"),
                    rs.getString("kab_kota"),
                    rs.getString("provinsi")
                });
                jTable1.setModel(tbl);
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi database gagal"+e.getMessage());
        }
    }
    
    public void table_data_petugas(){
        DefaultTableModel tb2 = new DefaultTableModel();
        tb2.addColumn("Username");
        tb2.addColumn("Password");
        tb2.addColumn("Nama Lengkap");
        tb2.addColumn("Level");
        
        try{
            Statement st = (Statement) koneksi.getConnection().createStatement();
            ResultSet rs2 = st.executeQuery("SELECT * FROM login_multiuser");
            
            while(rs2.next()){
                tb2.addRow(new Object[]{
                    rs2.getString("username"),
                    rs2.getString("password"),
                    rs2.getString("nama_lengkap"),
                    rs2.getString("level")
                });
                jTable2.setModel(tb2);
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi database gagal"+e.getMessage());
        }
    }
    
    public void table_pendaftaran(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Nis");
        tbl.addColumn("Nama");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Tempat, Tgl Lahir");
        tbl.addColumn("Agama");
        tbl.addColumn("Alamat");
        tbl.addColumn("Berat Badan");
        tbl.addColumn("Tinggi Badan");
        tbl.addColumn("Nama Ayah");
        tbl.addColumn("Nama Ibu");
        tbl.addColumn("Pekerjaan Ayah");
        tbl.addColumn("Pekerjaan Ibu");
        tbl.addColumn("Jalan");
        tbl.addColumn("Kelurahan/Desa");
        tbl.addColumn("Kecamatan");
        tbl.addColumn("Kab/Kota");
        tbl.addColumn("Provinsi");
        
        try{
            Statement st = (Statement) koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_datasiswa");
            
            while(rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("nis"),
                    rs.getString("nama_peserta_didik"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("tempat_tgl_lahir"),
                    rs.getString("agama"),
                    rs.getString("alamat_peserta_didik"),
                    rs.getString("berat_badan"),
                    rs.getString("tinggi_badan"),
                    rs.getString("nama_ayah"),
                    rs.getString("nama_ibu"),
                    rs.getString("pekerjaan_ayah"),
                    rs.getString("pekerjaan_ibu"),
                    rs.getString("jalan"),
                    rs.getString("kelurahan_desa"),
                    rs.getString("kecamatan"),
                    rs.getString("kab_kota"),
                    rs.getString("provinsi")
                });
                jTable3.setModel(tbl);
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi database gagal"+e.getMessage());
        }
    }
    
//    public void table_pesan(){
//        DefaultTableModel tb2 = new DefaultTableModel();
//        tb2.addColumn("Nis");
//        tb2.addColumn("Nama Siswa");
//        tb2.addColumn("Pesan");
//        
//        try{
//            Statement st = (Statement) koneksi.getConnection().createStatement();
//            ResultSet rs2 = st.executeQuery("SELECT * FROM tb_hubungi");
//            
//            while(rs2.next()){
//                tb2.addRow(new Object[]{
//                    rs2.getString("nis"),
//                    rs2.getString("name"),
//                    rs2.getString("message")
//                });
//                jTable4.setModel(tb2);
//            }
//        
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null, "Koneksi database gagal"+e.getMessage());
//        }
//    }
    
    public void tabel_pembayaran(){
        DefaultTableModel tb2 = new DefaultTableModel();
        tb2.addColumn("id");
        tb2.addColumn("Nis");
        tb2.addColumn("Nama Siswa");
        tb2.addColumn("Pembayaran");
        tb2.addColumn("Total Bayar");
        
        try{
            Statement st = (Statement) koneksi.getConnection().createStatement();
            ResultSet rs2 = st.executeQuery("SELECT * FROM tb_pembayaran");
            
            while(rs2.next()){
                tb2.addRow(new Object[]{
                    rs2.getString("id"),
                    rs2.getString("nis"),
                    rs2.getString("nama_peserta_didik"),
                    rs2.getString("pembayaran"),
                    rs2.getString("total_bayar")
                });
                jTable5.setModel(tb2);
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi database gagal"+e.getMessage());
        }
    }
    
    public void table_data_pembayaran(){
        DefaultTableModel tb2 = new DefaultTableModel();
        tb2.addColumn("id");
        tb2.addColumn("Nis");
        tb2.addColumn("Nama Siswa");
        tb2.addColumn("Pembayaran");
        tb2.addColumn("Total Bayar");
        
        try{
            Statement st = (Statement) koneksi.getConnection().createStatement();
            ResultSet rs2 = st.executeQuery("SELECT * FROM tb_pembayaran");
            
            while(rs2.next()){
                tb2.addRow(new Object[]{
                    rs2.getString("id"),
                    rs2.getString("nis"),
                    rs2.getString("nama_peserta_didik"),
                    rs2.getString("pembayaran"),
                    rs2.getString("total_bayar")
                });
                jTable6.setModel(tb2);
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi database gagal"+e.getMessage());
        }
    }
    

    public admin_page(String un) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        dshbr = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        dashbord_utama = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        pendaftaran_tk = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        tNis_p = new javax.swing.JTextField();
        tNama_p = new javax.swing.JTextField();
        rLaki_p = new javax.swing.JRadioButton();
        rPerempuan_p = new javax.swing.JRadioButton();
        tTmpTglL_p = new javax.swing.JTextField();
        tAgama_p = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tAlamat_p = new javax.swing.JTextArea();
        tBB_p = new javax.swing.JTextField();
        tTB_p = new javax.swing.JTextField();
        tNA_p = new javax.swing.JTextField();
        tNB_p = new javax.swing.JTextField();
        tPA_p = new javax.swing.JTextField();
        tPB_p = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tJalan_p = new javax.swing.JTextArea();
        tKD_p = new javax.swing.JTextField();
        tK_p = new javax.swing.JTextField();
        tKK_p = new javax.swing.JTextField();
        tP_p = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        tCari = new javax.swing.JTextField();
        data_siswa_tk = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tNis = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        rLaki = new javax.swing.JRadioButton();
        rPerempuan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlamat = new javax.swing.JTextArea();
        tAgama = new javax.swing.JTextField();
        tTmpTglL = new javax.swing.JTextField();
        tBB = new javax.swing.JTextField();
        tTB = new javax.swing.JTextField();
        tNA = new javax.swing.JTextField();
        tNB = new javax.swing.JTextField();
        tPA = new javax.swing.JTextField();
        tPB = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tJalan = new javax.swing.JTextArea();
        tKD = new javax.swing.JTextField();
        tK = new javax.swing.JTextField();
        tKK = new javax.swing.JTextField();
        tP = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tCari_p = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        data_petugass = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tUsername = new javax.swing.JTextField();
        tPass = new javax.swing.JPasswordField();
        tNL = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jButton9 = new javax.swing.JButton();
        jTextField16 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cbuser_dp = new javax.swing.JComboBox<>();
        hubungii = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tNis_h = new javax.swing.JTextField();
        tNama_h = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tPesan_h = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        pembayaran = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        tNis_pm = new javax.swing.JTextField();
        tNS_pm = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        t_bayar = new javax.swing.JTextField();
        btn_Cari = new javax.swing.JButton();
        t_Cari_pm = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        rSPP = new javax.swing.JRadioButton();
        rSeragam = new javax.swing.JRadioButton();
        rGedung = new javax.swing.JRadioButton();
        jButton14 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        t_id = new javax.swing.JTextField();
        data_pembayaran = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        t_Cari_dp = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        t_id_dp = new javax.swing.JTextField();
        t_NS_dp = new javax.swing.JTextField();
        t_NM_dp = new javax.swing.JTextField();
        t_bayar_dp = new javax.swing.JTextField();
        rSPP_dp = new javax.swing.JRadioButton();
        rSeragam_sp = new javax.swing.JRadioButton();
        r_Gedung_dp = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        jLabel8.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel8.setText("TK ERLANGGA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin.png"))); // NOI18N

        data_petugas.setBackground(new java.awt.Color(51, 51, 255));
        data_petugas.setText("Data Petugas");
        data_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_petugasMouseClicked(evt);
            }
        });
        data_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_petugasActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 0, 51));
        jButton5.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("EXIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        data_siswa.setBackground(new java.awt.Color(51, 51, 255));
        data_siswa.setText("Data Siswa");
        data_siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_siswaMouseClicked(evt);
            }
        });
        data_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_siswaActionPerformed(evt);
            }
        });

        pendaftaran.setBackground(new java.awt.Color(51, 51, 255));
        pendaftaran.setText("Pendaftaran");
        pendaftaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendaftaranMouseClicked(evt);
            }
        });
        pendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendaftaranActionPerformed(evt);
            }
        });

        hubungi.setBackground(new java.awt.Color(51, 51, 255));
        hubungi.setText("Hubungi");
        hubungi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hubungiMouseClicked(evt);
            }
        });
        hubungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hubungiActionPerformed(evt);
            }
        });

        pmbyr.setBackground(new java.awt.Color(51, 51, 255));
        pmbyr.setText("Pembayaran");
        pmbyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmbyrActionPerformed(evt);
            }
        });

        data_pmbyr.setBackground(new java.awt.Color(51, 51, 255));
        data_pmbyr.setText("Data Pembayaran");
        data_pmbyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_pmbyrActionPerformed(evt);
            }
        });

        dshbr.setBackground(new java.awt.Color(51, 51, 255));
        dshbr.setText("Halaman Utama");
        dshbr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dshbrActionPerformed(evt);
            }
        });

        server_chat.setBackground(new java.awt.Color(51, 51, 255));
        server_chat.setText("Server Chatt");
        server_chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                server_chatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hubungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_petugas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_siswa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pendaftaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pmbyr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(data_pmbyr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dshbr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(server_chat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(dshbr)
                .addGap(18, 18, 18)
                .addComponent(pendaftaran)
                .addGap(18, 18, 18)
                .addComponent(pmbyr)
                .addGap(18, 18, 18)
                .addComponent(data_pmbyr)
                .addGap(18, 18, 18)
                .addComponent(data_siswa)
                .addGap(18, 18, 18)
                .addComponent(data_petugas)
                .addGap(18, 18, 18)
                .addComponent(hubungi)
                .addGap(18, 18, 18)
                .addComponent(server_chat)
                .addGap(21, 21, 21)
                .addComponent(jButton5)
                .addGap(26, 26, 26))
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        dashbord_utama.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Visi-misi.png"))); // NOI18N
        jLabel36.setText(".");

        javax.swing.GroupLayout dashbord_utamaLayout = new javax.swing.GroupLayout(dashbord_utama);
        dashbord_utama.setLayout(dashbord_utamaLayout);
        dashbord_utamaLayout.setHorizontalGroup(
            dashbord_utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashbord_utamaLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addContainerGap())
        );
        dashbord_utamaLayout.setVerticalGroup(
            dashbord_utamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashbord_utamaLayout.createSequentialGroup()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        mainPanel.add(dashbord_utama, "card9");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Pekerjaan Ayah");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Nama Ayah");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Jenis Kelamin");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Nama");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Agama");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Alamat Siswa");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Nis");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Tinggi Badan");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Tempat, Tgl Lahir");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Nama IBu");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("Pekerjaan Ibu");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Berat Badan");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setText("Jalan");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("Kelurahan/Desa");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Kecamatan");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("Kab/Kota");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setText("Provinsi");

        tNis_p.setBackground(new java.awt.Color(204, 204, 204));

        tNama_p.setBackground(new java.awt.Color(204, 204, 204));

        rLaki_p.setText("Laki-Laki");

        rPerempuan_p.setText("Perempuan");

        tTmpTglL_p.setBackground(new java.awt.Color(204, 204, 204));

        tAgama_p.setBackground(new java.awt.Color(204, 204, 204));

        tAlamat_p.setBackground(new java.awt.Color(204, 204, 204));
        tAlamat_p.setColumns(20);
        tAlamat_p.setRows(5);
        jScrollPane7.setViewportView(tAlamat_p);

        tBB_p.setBackground(new java.awt.Color(204, 204, 204));

        tTB_p.setBackground(new java.awt.Color(204, 204, 204));

        tNA_p.setBackground(new java.awt.Color(204, 204, 204));

        tNB_p.setBackground(new java.awt.Color(204, 204, 204));

        tPA_p.setBackground(new java.awt.Color(204, 204, 204));

        tPB_p.setBackground(new java.awt.Color(204, 204, 204));

        tJalan_p.setBackground(new java.awt.Color(204, 204, 204));
        tJalan_p.setColumns(20);
        tJalan_p.setRows(5);
        jScrollPane8.setViewportView(tJalan_p);

        tKD_p.setBackground(new java.awt.Color(204, 204, 204));

        tK_p.setBackground(new java.awt.Color(204, 204, 204));

        tKK_p.setBackground(new java.awt.Color(204, 204, 204));

        tP_p.setBackground(new java.awt.Color(204, 204, 204));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nim", "Nama", "Jenis Kelamin", "Tempat, Tgl Lahir", "Agama", "Alamat", "Berat Badan", "Tinggi Badan", "Nama Ayah", "Nama Ibu", "Pekerjaan Ayah", "Pekerjaan Ibu", "Jalan", "Kelurahan/Desa", "Kecamatan", "Kab/Kota", "Provinsi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTable3);

        simpan_p.setText("Smpan");
        simpan_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan_pActionPerformed(evt);
            }
        });

        edit_p.setText("Edit");
        edit_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_pActionPerformed(evt);
            }
        });

        tampil_p.setText("Tampil");
        tampil_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampil_pActionPerformed(evt);
            }
        });

        hapus_p.setText("Hapus");
        hapus_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_pActionPerformed(evt);
            }
        });

        print_p.setText("Print Data");
        print_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_pActionPerformed(evt);
            }
        });

        jButton10.setText("Cari");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });

        tCari.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pendaftaran_tkLayout = new javax.swing.GroupLayout(pendaftaran_tk);
        pendaftaran_tk.setLayout(pendaftaran_tkLayout);
        pendaftaran_tkLayout.setHorizontalGroup(
            pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel43)
                            .addComponent(jLabel42)
                            .addComponent(jLabel44)
                            .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel51)
                                .addComponent(jLabel45))
                            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel47)))
                        .addGap(60, 60, 60)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                .addComponent(rLaki_p)
                                .addGap(36, 36, 36)
                                .addComponent(rPerempuan_p))
                            .addComponent(tNis_p)
                            .addComponent(tNama_p)
                            .addComponent(tTmpTglL_p, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tAgama_p)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(tBB_p)
                            .addComponent(tTB_p))))
                .addGap(34, 34, 34)
                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel49))
                        .addGap(43, 43, 43)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                .addComponent(tNA_p, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                .addComponent(tNB_p, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                                .addComponent(simpan_p, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel53)
                            .addComponent(jLabel52)
                            .addComponent(jLabel50)
                            .addComponent(jLabel40)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56))
                        .addGap(18, 18, 18)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tPA_p)
                            .addComponent(tPB_p)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(tKD_p)
                            .addComponent(tK_p)
                            .addComponent(tKK_p)
                            .addComponent(tP_p))
                        .addGap(18, 18, 18)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hapus_p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tampil_p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edit_p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(print_p, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tCari)))))
                .addContainerGap())
            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9))
        );
        pendaftaran_tkLayout.setVerticalGroup(
            pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel46)
                                            .addComponent(jLabel41)
                                            .addComponent(tNA_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendaftaran_tkLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(tNis_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel43)
                                        .addComponent(jLabel49))
                                    .addComponent(tNB_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(simpan_p)))
                            .addComponent(tNama_p, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel40)
                                    .addComponent(tPA_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendaftaran_tkLayout.createSequentialGroup()
                                .addComponent(edit_p)
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pendaftaran_tkLayout.createSequentialGroup()
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rLaki_p)
                            .addComponent(rPerempuan_p))
                        .addGap(18, 18, 18)))
                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel48)
                        .addComponent(jLabel50)
                        .addComponent(tTmpTglL_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tPB_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tampil_p)))
                .addGap(18, 18, 18)
                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel52)
                            .addComponent(tAgama_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45)))
                    .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hapus_p))
                        .addGap(18, 18, 18)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tKD_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(print_p))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54)
                        .addComponent(tBB_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel51))
                    .addComponent(tK_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pendaftaran_tkLayout.createSequentialGroup()
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tKK_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55)
                            .addComponent(tTB_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pendaftaran_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tP_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56)
                            .addComponent(jButton10)
                            .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel47))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );

        mainPanel.add(pendaftaran_tk, "card6");

        data_siswa_tk.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nis");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tempat, Tgl Lahir");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Agama");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Alamat Siswa");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Berat Badan");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Tinggi Badan");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Nama Ayah");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Nama Ibu");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Pekerjaan Ayah");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Pekerjaan Ibu");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Jalan");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Kelurahan/Desa");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Kecamatan");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Kab/Kota");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Provinsi");

        tNis.setBackground(new java.awt.Color(204, 204, 204));

        tNama.setBackground(new java.awt.Color(204, 204, 204));

        rLaki.setText("Laki-Laki");

        rPerempuan.setText("Perempuan");

        tAlamat.setBackground(new java.awt.Color(204, 204, 204));
        tAlamat.setColumns(20);
        tAlamat.setRows(5);
        jScrollPane1.setViewportView(tAlamat);

        tAgama.setBackground(new java.awt.Color(204, 204, 204));

        tTmpTglL.setBackground(new java.awt.Color(204, 204, 204));

        tBB.setBackground(new java.awt.Color(204, 204, 204));

        tTB.setBackground(new java.awt.Color(204, 204, 204));

        tNA.setBackground(new java.awt.Color(204, 204, 204));

        tNB.setBackground(new java.awt.Color(204, 204, 204));

        tPA.setBackground(new java.awt.Color(204, 204, 204));

        tPB.setBackground(new java.awt.Color(204, 204, 204));

        tJalan.setBackground(new java.awt.Color(204, 204, 204));
        tJalan.setColumns(20);
        tJalan.setRows(5);
        jScrollPane2.setViewportView(tJalan);

        tKD.setBackground(new java.awt.Color(204, 204, 204));

        tK.setBackground(new java.awt.Color(204, 204, 204));

        tKK.setBackground(new java.awt.Color(204, 204, 204));

        tP.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nim", "Nama", "Jenis Kelamin", "Tempat, Tgl Lahir", "Agama", "Alamat", "Berat Badan", "Tinggi Badan", "Nama Ayah", "Nama Ibu", "Pekerjaan Ayah", "Pekerjaan Ibu", "Jalan", "Kelurahan/Desa", "Kecamatan", "Kab/Kota", "Provinsi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        simpan.setText("Simpan");
        simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanMouseClicked(evt);
            }
        });
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        tampil.setText("Tampil");
        tampil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tampilMouseClicked(evt);
            }
        });
        tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusMouseClicked(evt);
            }
        });
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        tCari_p.setBackground(new java.awt.Color(204, 204, 204));

        jButton7.setText("Cari");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        print.setText("Print Data");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout data_siswa_tkLayout = new javax.swing.GroupLayout(data_siswa_tk);
        data_siswa_tk.setLayout(data_siswa_tkLayout);
        data_siswa_tkLayout.setHorizontalGroup(
            data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_siswa_tkLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7))
                    .addGroup(data_siswa_tkLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)))
                .addGap(40, 40, 40)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(data_siswa_tkLayout.createSequentialGroup()
                        .addComponent(rLaki)
                        .addGap(18, 18, 18)
                        .addComponent(rPerempuan))
                    .addComponent(tNama)
                    .addComponent(tAgama)
                    .addComponent(tTmpTglL)
                    .addComponent(tBB)
                    .addComponent(tNis)
                    .addComponent(jScrollPane1)
                    .addComponent(tTB))
                .addGap(48, 48, 48)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)))
                    .addComponent(jLabel19))
                .addGap(54, 54, 54)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_siswa_tkLayout.createSequentialGroup()
                        .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tNA)
                            .addComponent(tNB)
                            .addComponent(tPA)
                            .addComponent(tPB)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(tKD)
                            .addComponent(tK)
                            .addComponent(tKK))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(simpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tampil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(print, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(data_siswa_tkLayout.createSequentialGroup()
                        .addComponent(tP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tCari_p)))
                .addContainerGap())
            .addGroup(data_siswa_tkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        data_siswa_tkLayout.setVerticalGroup(
            data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_siswa_tkLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(tNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpan))
                .addGap(18, 18, 18)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tNB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(edit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rLaki)
                    .addComponent(rPerempuan)
                    .addComponent(jLabel13)
                    .addComponent(tPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tampil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hapus)
                    .addComponent(tPB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tTmpTglL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_siswa_tkLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(print))
                    .addGroup(data_siswa_tkLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(data_siswa_tkLayout.createSequentialGroup()
                                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(tAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(data_siswa_tkLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tKD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(tK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(data_siswa_tkLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tKK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(tBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(data_siswa_tkLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel9)))))
                .addGap(18, 18, 18)
                .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(data_siswa_tkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(tP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tCari_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        mainPanel.add(data_siswa_tk, "card2");

        data_petugass.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Username");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Password");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Nama Lengkap");

        jButton8.setText("Simpan");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Edit");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Tampil");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Hapus");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jButton9.setText("Cari");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Nama Lengkap", "Level"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        cbuser_dp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User Select", "Admin", "Petugas" }));

        javax.swing.GroupLayout data_petugassLayout = new javax.swing.GroupLayout(data_petugass);
        data_petugass.setLayout(data_petugassLayout);
        data_petugassLayout.setHorizontalGroup(
            data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_petugassLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel20)
                        .addComponent(jLabel23))
                    .addGroup(data_petugassLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel21)))
                .addGap(30, 30, 30)
                .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbuser_dp, 0, 200, Short.MAX_VALUE)
                    .addComponent(tUsername)
                    .addComponent(tPass, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(tNL))
                .addGap(231, 231, 231)
                .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_petugassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4))
        );
        data_petugassLayout.setVerticalGroup(
            data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_petugassLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(tUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(24, 24, 24)
                .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1))
                .addGap(21, 21, 21)
                .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(tNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2))
                .addGap(18, 18, 18)
                .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton3)
                    .addComponent(cbuser_dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(data_petugassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(data_petugass, "card5");

        hubungii.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Nis");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Nama Siswa");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Pesan Laporan");

        tNis_h.setBackground(new java.awt.Color(204, 204, 204));

        tNama_h.setBackground(new java.awt.Color(204, 204, 204));

        tPesan_h.setBackground(new java.awt.Color(204, 204, 204));
        tPesan_h.setColumns(20);
        tPesan_h.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        tPesan_h.setRows(5);
        jScrollPane5.setViewportView(tPesan_h);

        jButton1.setText("Kirim");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hubungiiLayout = new javax.swing.GroupLayout(hubungii);
        hubungii.setLayout(hubungiiLayout);
        hubungiiLayout.setHorizontalGroup(
            hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hubungiiLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(hubungiiLayout.createSequentialGroup()
                        .addGroup(hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(53, 53, 53)
                        .addGroup(hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tNis_h)
                                .addComponent(tNama_h, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hubungiiLayout.setVerticalGroup(
            hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hubungiiLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(hubungiiLayout.createSequentialGroup()
                        .addGroup(hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(tNis_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24))
                    .addComponent(tNama_h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(hubungiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hubungiiLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel25))
                    .addGroup(hubungiiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        mainPanel.add(hubungii, "card7");

        pembayaran.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Nis Siswa");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Nama Siswa");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Pilih pembayaran");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Total Bayar");

        tNis_pm.setBackground(new java.awt.Color(204, 204, 204));

        tNS_pm.setBackground(new java.awt.Color(204, 204, 204));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nis Siswa", "Nama Siswa", "Pembayaran", "Total Bayar"
            }
        ));
        jScrollPane10.setViewportView(jTable5);

        t_bayar.setBackground(new java.awt.Color(204, 204, 204));

        btn_Cari.setText("Cari");
        btn_Cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CariMouseClicked(evt);
            }
        });

        jButton3.setText("Bayar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        rSPP.setText("SPP");
        rSPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSPPActionPerformed(evt);
            }
        });

        rSeragam.setText("Seragam");
        rSeragam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSeragamActionPerformed(evt);
            }
        });

        rGedung.setText("Gedung");
        rGedung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rGedungActionPerformed(evt);
            }
        });

        jButton14.setText("Tampil");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Id");

        t_id.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pembayaranLayout = new javax.swing.GroupLayout(pembayaran);
        pembayaran.setLayout(pembayaranLayout);
        pembayaranLayout.setHorizontalGroup(
            pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pembayaranLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(33, 33, 33)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tNis_pm, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(tNS_pm)
                    .addComponent(t_bayar)
                    .addGroup(pembayaranLayout.createSequentialGroup()
                        .addComponent(rSPP)
                        .addGap(18, 18, 18)
                        .addComponent(rSeragam)
                        .addGap(18, 18, 18)
                        .addComponent(rGedung))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pembayaranLayout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(t_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(btn_Cari)
                .addGap(18, 18, 18)
                .addComponent(t_Cari_pm, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pembayaranLayout.setVerticalGroup(
            pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pembayaranLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(t_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(tNis_pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(tNS_pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(rSPP)
                    .addComponent(rSeragam)
                    .addComponent(rGedung))
                .addGap(42, 42, 42)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(t_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton14))
                .addGap(3, 3, 3)
                .addGroup(pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cari)
                    .addComponent(t_Cari_pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        mainPanel.add(pembayaran, "card7");

        data_pembayaran.setBackground(new java.awt.Color(255, 255, 255));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nis Siswa", "Nama Siswa", "Pembayaran", "Total  Bayar"
            }
        ));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTable6);

        jButton6.setText("Tampil");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton11.setText("Edit");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Hapus");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Cari");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });

        t_Cari_dp.setBackground(new java.awt.Color(204, 204, 204));

        print_pmbyr.setText("Cetak Pembayaran");
        print_pmbyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_pmbyrActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("ID");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Nis Siswa");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Nama Siswa");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Pembayaran");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Total Bayar");

        t_id_dp.setBackground(new java.awt.Color(204, 204, 204));

        t_NS_dp.setBackground(new java.awt.Color(204, 204, 204));

        t_NM_dp.setBackground(new java.awt.Color(204, 204, 204));
        t_NM_dp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_NM_dpActionPerformed(evt);
            }
        });

        t_bayar_dp.setBackground(new java.awt.Color(204, 204, 204));

        rSPP_dp.setText("SPP");
        rSPP_dp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSPP_dpActionPerformed(evt);
            }
        });

        rSeragam_sp.setText("Seragam");
        rSeragam_sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSeragam_spActionPerformed(evt);
            }
        });

        r_Gedung_dp.setText("Gedung");
        r_Gedung_dp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_Gedung_dpActionPerformed(evt);
            }
        });

        jButton4.setText("Simpan");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout data_pembayaranLayout = new javax.swing.GroupLayout(data_pembayaran);
        data_pembayaran.setLayout(data_pembayaranLayout);
        data_pembayaranLayout.setHorizontalGroup(
            data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(data_pembayaranLayout.createSequentialGroup()
                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_pembayaranLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE))
                    .addGroup(data_pembayaranLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(data_pembayaranLayout.createSequentialGroup()
                                .addComponent(jButton13)
                                .addGap(26, 26, 26)
                                .addComponent(t_Cari_dp, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(data_pembayaranLayout.createSequentialGroup()
                                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel33)
                                    .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(37, 37, 37)
                                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(t_id_dp)
                                        .addComponent(t_NS_dp)
                                        .addComponent(t_NM_dp)
                                        .addComponent(t_bayar_dp, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                                    .addGroup(data_pembayaranLayout.createSequentialGroup()
                                        .addComponent(rSPP_dp)
                                        .addGap(18, 18, 18)
                                        .addComponent(rSeragam_sp)
                                        .addGap(18, 18, 18)
                                        .addComponent(r_Gedung_dp)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(data_pembayaranLayout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(print_pmbyr, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        data_pembayaranLayout.setVerticalGroup(
            data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_pembayaranLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(t_id_dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel31))
                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(data_pembayaranLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, data_pembayaranLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(t_NS_dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton12)
                    .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(t_NM_dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(print_pmbyr)
                    .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(rSPP_dp)
                        .addComponent(rSeragam_sp)
                        .addComponent(r_Gedung_dp)))
                .addGap(18, 18, 18)
                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_bayar_dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(data_pembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_Cari_dp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(data_pembayaran, "card8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void data_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_petugasActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //Add Panel
        mainPanel.add(data_petugass);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_data_petugasActionPerformed

    private void hubungiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hubungiActionPerformed

        // TODO add your handling code here:
        guiclient.setVisible(true);
        guiclient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
//        String localhost = null;
//        GUIClient start = new GUIClient(localhost, 1000);
//        start.setVisible(true);
//        this.dispose();
//        mainPanel.removeAll();
//        mainPanel.repaint();
//        mainPanel.revalidate();
//        
//        //Add Panel
//        mainPanel.add(ChatMe);
//        mainPanel.repaint();
//        mainPanel.revalidate();
        
    }//GEN-LAST:event_hubungiActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int selectedOption=JOptionPane.showConfirmDialog(null,"Apakah anda ingin keluar ?","Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
        if(selectedOption == JOptionPane.YES_OPTION){
            login start = new login();
            start.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void data_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_siswaActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //Add Panel
        mainPanel.add(data_siswa_tk);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_data_siswaActionPerformed

    private void pendaftaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendaftaranMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pendaftaranMouseClicked

    private void data_siswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_siswaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_data_siswaMouseClicked

    private void data_petugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_petugasMouseClicked
        // TODO add your handling code here:
//        mainPanel.removeAll();
//        mainPanel.repaint();
//        mainPanel.revalidate();
//        
//        //Add Panel
//        mainPanel.add(data_petugass);
//        mainPanel.repaint();
//        mainPanel.revalidate();
    }//GEN-LAST:event_data_petugasMouseClicked

    private void hubungiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hubungiMouseClicked
        
    }//GEN-LAST:event_hubungiMouseClicked

    private void simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanMouseClicked

    private void tampilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tampilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tampilMouseClicked

    private void hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_editMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String nis = jTable1.getValueAt(baris, 0).toString();
        tNis.setText(nis);
        String nama = jTable1.getValueAt(baris, 1).toString();
        tNama.setText(nama);
        String tempattgll = jTable1.getValueAt(baris, 3).toString();
        tTmpTglL.setText(tempattgll);
        String agama = jTable1.getValueAt(baris, 4).toString();
        tAgama.setText(agama);
        String alamat = jTable1.getValueAt(baris, 5).toString();
        tAlamat.setText(alamat);
        String bb = jTable1.getValueAt(baris, 6).toString();
        tBB.setText(bb);
        String tb = jTable1.getValueAt(baris, 7).toString();
        tTB.setText(tb);
        String ayah = jTable1.getValueAt(baris, 8).toString();
        tNA.setText(ayah);
        String ibu = jTable1.getValueAt(baris, 9).toString();
        tNB.setText(ibu);
        String payah = jTable1.getValueAt(baris, 10).toString();
        tPA.setText(payah);
        String pibu = jTable1.getValueAt(baris, 11).toString();
        tPB.setText(pibu);
        String jalan = jTable1.getValueAt(baris, 12).toString();
        tJalan.setText(jalan);
        String kelurahan = jTable1.getValueAt(baris, 13).toString();
        tKD.setText(kelurahan);
        String kecamatan = jTable1.getValueAt(baris, 14).toString();
        tK.setText(kecamatan);
        String kabkota = jTable1.getValueAt(baris, 15).toString();
        tKK.setText(kabkota);
        String provinsi = jTable1.getValueAt(baris, 16).toString();
        tP.setText(provinsi);
    }//GEN-LAST:event_jTable1MouseClicked

    private void pendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendaftaranActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //Add Panel
        mainPanel.add(pendaftaran_tk);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_pendaftaranActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        String jk=null;

        if(rLaki.isSelected()){
            jk="Laki-laki";
        }else if(rPerempuan.isSelected()){
            jk="Perempuan";
        }

        try{

            String sql =  "INSERT INTO tb_datasiswa VALUES ('" + tNis.getText() +"','"
            + tNama.getText() + "','" + jk + "','" + tTmpTglL.getText() + "','" 
            + tAgama.getText() + "','" + tAlamat.getText() + "','"
            + tBB.getText() + "','" + tTB.getText() + "','" + tNA.getText() + "','"
            + tNB.getText() + "','" + tPA.getText() + "','" + tPB.getText() + "','"
            + tJalan.getText() + "','" + tKD.getText() + "','" + tK.getText() + "','"
            + tKK.getText() + "','" + tP.getText() + "')";

            Connection con=(Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Berhasil menyimpan");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Gagal menyimpan"+e.getMessage());
            }
    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        String jk=null;

        if(rLaki.isSelected()){
            jk="Laki-laki";
        }else if(rPerempuan.isSelected()){
            jk="Perempuan";
        }

        try{
            String sql = "UPDATE tb_datasiswa SET nis ='"+ tNis.getText()
                    + "',nama_peserta_didik ='" + tNama.getText()
                    + "',jenis_kelamin ='" + jk
                    + "',tempat_tgl_lahir ='"+ tTmpTglL.getText()
                    + "',agama ='"+ tAgama.getText()
                    + "',alamat_peserta_didik ='"+ tAlamat.getText()
                    + "',berat_badan ='"+ tBB.getText()
                    + "',tinggi_badan ='"+ tTB.getText()
                    + "',nama_ayah ='"+ tNA.getText()
                    + "',nama_ibu ='"+ tNB.getText()
                    + "',pekerjaan_ayah ='"+ tPA.getText()
                    + "',pekerjaan_ibu ='"+ tPB.getText()
                    + "',jalan ='"+ tJalan.getText()
                    + "',kelurahan_desa ='"+ tKD.getText()
                    + "',kecamatan ='"+ tK.getText()
                    + "',kab_kota ='"+ tKK.getText()
                    + "',provinsi ='"+ tP.getText()
                    +"'WHERE nis ='" + tNis.getText() + "'";

            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Edit Data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Edit Data" +e);
        }
    }//GEN-LAST:event_editActionPerformed

    private void tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "SELECT * FROM tb_datasiswa WHERE nis ='" + tNis.getText() + "'";
            Connection con = (Connection)koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data ditampilkan");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        table_data_siswa_tk();
        hapus();
    }//GEN-LAST:event_tampilActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM tb_datasiswa WHERE nis ='" + tNis.getText() + "'";
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Success menghapus data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
        try{

            String sql =  "INSERT INTO login_multiuser VALUES ('" + tUsername.getText() +"','"
            + tPass.getText() + "','" + tNL.getText() + "','" 
            + cbuser_dp.getSelectedItem() + "')";

            Connection con=(Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Berhasil menyimpan");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Gagal menyimpan"+e.getMessage());
            }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "SELECT * FROM login_multiuser WHERE username ='" + tUsername.getText() + "'";
            Connection con = (Connection)koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data ditampilkan");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        table_data_petugas();
        hapus_dp();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM login_multiuser WHERE username ='" + tUsername.getText() + "'";
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Success menghapus data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.rowAtPoint(evt.getPoint());
        String username = jTable2.getValueAt(baris, 0).toString();
        tUsername.setText(username);
        String pas = jTable2.getValueAt(baris, 1).toString();
        tPass.setText(pas);
        String namalengkap = jTable2.getValueAt(baris, 2).toString();
        tNL.setText(namalengkap);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:

        try{
            String sql = "UPDATE  login_multiuser SET username='"+ tUsername.getText() + "',password='" + tPass.getText()
            + "',nama_lengkap ='"+ tNL.getText() + "',level ='"+ cbuser_dp.getSelectedItem()+ "'WHERE username='" + tUsername.getText() + "'";
                    
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Edit Data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Edit Data" + e);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void simpan_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan_pActionPerformed
        // TODO add your handling code here:
        String jk=null;

        if(rLaki_p.isSelected()){
            jk="Laki-laki";
        }else if(rPerempuan_p.isSelected()){
            jk="Perempuan";
        }

        try{

            String sql =  "INSERT INTO tb_datasiswa VALUES ('" + tNis_p.getText() +"','"
            + tNama_p.getText() + "','" + jk + "','" + tTmpTglL_p.getText() + "','" 
            + tAgama_p.getText() + "','" + tAlamat_p.getText() + "','"
            + tBB_p.getText() + "','" + tTB_p.getText() + "','" + tNA_p.getText() + "','"
            + tNB_p.getText() + "','" + tPA_p.getText() + "','" + tPB_p.getText() + "','"
            + tJalan_p.getText() + "','" + tKD_p.getText() + "','" + tK_p.getText() + "','"
            + tKK_p.getText() + "','" + tP_p.getText() + "')";

            Connection con=(Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Berhasil menyimpan");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Gagal menyimpan"+e.getMessage());
        }
    }//GEN-LAST:event_simpan_pActionPerformed

    private void edit_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_pActionPerformed
        // TODO add your handling code here:
        String jk=null;

        if(rLaki_p.isSelected()){
            jk="Laki-laki";
        }else if(rPerempuan_p.isSelected()){
            jk="Perempuan";
        }

        try{
            String sql = "UPDATE tb_datasiswa SET nis ='"+ tNis_p.getText()
                    + "',nama_peserta_didik ='" + tNama_p.getText()
                    + "',jenis_kelamin ='" + jk
                    + "',tempat_tgl_lahir ='"+ tTmpTglL_p.getText()
                    + "',agama ='"+ tAgama_p.getText()
                    + "',alamat_peserta_didik ='"+ tAlamat_p.getText()
                    + "',berat_badan ='"+ tBB_p.getText()
                    + "',tinggi_badan ='"+ tTB_p.getText()
                    + "',nama_ayah ='"+ tNA_p.getText()
                    + "',nama_ibu ='"+ tNB_p.getText()
                    + "',pekerjaan_ayah ='"+ tPA_p.getText()
                    + "',pekerjaan_ibu ='"+ tPB_p.getText()
                    + "',jalan ='"+ tJalan_p.getText()
                    + "',kelurahan_desa ='"+ tKD_p.getText()
                    + "',kecamatan ='"+ tK_p.getText()
                    + "',kab_kota ='"+ tKK_p.getText()
                    + "',provinsi ='"+ tP_p.getText()
                    +"'WHERE nis ='" + tNis_p.getText() + "'";

            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Edit Data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Edit Data" +e);
        }
    }//GEN-LAST:event_edit_pActionPerformed

    private void tampil_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampil_pActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "SELECT * FROM tb_datasiswa WHERE nis ='" + tNis_p.getText() + "'";
            Connection con = (Connection)koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data ditampilkan");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        table_pendaftaran();
        hapus_Pendaftaran();
    }//GEN-LAST:event_tampil_pActionPerformed

    private void hapus_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_pActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM tb_datasiswa WHERE nis ='" + tNis_p.getText() + "'";
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Success menghapus data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
        }
    }//GEN-LAST:event_hapus_pActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String nis = jTable1.getValueAt(baris, 0).toString();
        tNis_p.setText(nis);
        String nama = jTable1.getValueAt(baris, 1).toString();
        tNama_p.setText(nama);
        String tempattgll = jTable1.getValueAt(baris, 3).toString();
        tTmpTglL_p.setText(tempattgll);
        String agama = jTable1.getValueAt(baris, 4).toString();
        tAgama_p.setText(agama);
        String alamat = jTable1.getValueAt(baris, 5).toString();
        tAlamat_p.setText(alamat);
        String bb = jTable1.getValueAt(baris, 6).toString();
        tBB_p.setText(bb);
        String tb = jTable1.getValueAt(baris, 7).toString();
        tTB_p.setText(tb);
        String ayah = jTable1.getValueAt(baris, 8).toString();
        tNA_p.setText(ayah);
        String ibu = jTable1.getValueAt(baris, 9).toString();
        tNB_p.setText(ibu);
        String payah = jTable1.getValueAt(baris, 10).toString();
        tPA_p.setText(payah);
        String pibu = jTable1.getValueAt(baris, 11).toString();
        tPB_p.setText(pibu);
        String jalan = jTable1.getValueAt(baris, 12).toString();
        tJalan_p.setText(jalan);
        String kelurahan = jTable1.getValueAt(baris, 13).toString();
        tKD_p.setText(kelurahan);
        String kecamatan = jTable1.getValueAt(baris, 14).toString();
        tK_p.setText(kecamatan);
        String kabkota = jTable1.getValueAt(baris, 15).toString();
        tKK_p.setText(kabkota);
        String provinsi = jTable1.getValueAt(baris, 16).toString();
        tP_p.setText(provinsi);
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        cari_p();
    }//GEN-LAST:event_jButton7MouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try {
            File fl;
            fl = new File("src/laporan/laporan_data.jasper");
            JasperPrint jp = JasperFillManager.fillReport(fl.getPath(), null, koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Gagal Print Data");
        }
    }//GEN-LAST:event_printActionPerformed

    private void print_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_pActionPerformed
        // TODO add your handling code here:
        try {
            File f2;
            f2 = new File("src/laporan/laporan_data.jasper");
            JasperPrint jp = JasperFillManager.fillReport(f2.getPath(), null, koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Gagal Print Data");
        }
    }//GEN-LAST:event_print_pActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{

            String sql =  "INSERT INTO tb_hubungi VALUES ('" + tNis_h.getText() +"','"
            + tNama_h.getText() + "','" + tPesan_h.getText()+ "')";

            Connection con=(Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Pesan anda diterima");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Gagal mengirim pesan"+e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            
            String jkk = null;

            if(rSPP.isSelected()){
                jkk="SPP";
            }else if(rSeragam.isSelected()){
                jkk="Seragam";
            }else if(rGedung.isSelected()){
                jkk="Gedung";
            }     

            String sql =  "INSERT INTO tb_pembayaran VALUES ('" + t_id.getText() +"','" + tNis_pm.getText() +"','"
            + tNS_pm.getText() + "','" + jkk + "','" + t_bayar.getText() + "')";

            Connection con=(Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Pembayaran Sucess");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Pembayaran Gagal"+e.getMessage());
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pmbyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmbyrActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //Add Panel
        mainPanel.add(pembayaran);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_pmbyrActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM tb_pembayaran WHERE id ='" + t_id_dp.getText() + "'";
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Success menghapus data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void data_pmbyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_pmbyrActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //Add Panel
        mainPanel.add(data_pembayaran);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_data_pmbyrActionPerformed

    private void rSPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSPPActionPerformed
        // TODO add your handling code here:
        t_bayar.setText("150000");
    }//GEN-LAST:event_rSPPActionPerformed

    private void rSeragamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSeragamActionPerformed
        // TODO add your handling code here:
        t_bayar.setText("100000");
    }//GEN-LAST:event_rSeragamActionPerformed

    private void rGedungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rGedungActionPerformed
        // TODO add your handling code here:
        t_bayar.setText("300000");
    }//GEN-LAST:event_rGedungActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "SELECT * FROM tb_pembayaran WHERE nis ='" + tNis_pm.getText() + "'";
            Connection con = (Connection)koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data ditampilkan");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        tabel_pembayaran();
        hapus_pmbyr();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btn_CariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CariMouseClicked
        // TODO add your handling code here:
        cari_pmbyr();
    }//GEN-LAST:event_btn_CariMouseClicked

    private void print_pmbyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_pmbyrActionPerformed
        // TODO add your handling code here:
        try {
            File fl;
            fl = new File("src/laporan/data_pembayaran.jasper");
            HashMap parameter;
            parameter = new HashMap();
            
            parameter.put("nnid", t_id_dp.getText());
            JasperPrint jp = JasperFillManager.fillReport(fl.getPath(), parameter, koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Gagal Print Data");
        }
    }//GEN-LAST:event_print_pmbyrActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        int baris = jTable6.rowAtPoint(evt.getPoint());
        String id = jTable6.getValueAt(baris, 0).toString();
        t_id_dp.setText(id);
        String nis = jTable6.getValueAt(baris, 1).toString();
        t_NS_dp.setText(nis);
        String namalengkap = jTable6.getValueAt(baris, 2).toString();
        t_NM_dp.setText(namalengkap);
        String totalbayar = jTable6.getValueAt(baris, 4).toString();
        t_bayar_dp.setText(totalbayar);
    }//GEN-LAST:event_jTable6MouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:
        cari_data_pmbyr();
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            
            String jkk = null;

            if(rSPP_dp.isSelected()){
                jkk="SPP";
            }else if(rSeragam_sp.isSelected()){
                jkk="Seragam";
            }else if(r_Gedung_dp.isSelected()){
                jkk="Gedung";
            }     

            String sql =  "INSERT INTO tb_pembayaran VALUES ('" + t_id_dp.getText() +"','" + t_NS_dp.getText() +"','"
            + t_NM_dp.getText() + "','" + jkk + "','" + t_bayar_dp.getText() + "')";

            Connection con=(Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Pembayaran Sucess");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Pembayaran Gagal"+e.getMessage());
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void rSPP_dpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSPP_dpActionPerformed
        // TODO add your handling code here:
        t_bayar_dp.setText("150000");
    }//GEN-LAST:event_rSPP_dpActionPerformed

    private void rSeragam_spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSeragam_spActionPerformed
        // TODO add your handling code here:
        t_bayar_dp.setText("100000");
    }//GEN-LAST:event_rSeragam_spActionPerformed

    private void r_Gedung_dpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_Gedung_dpActionPerformed
        // TODO add your handling code here:
        t_bayar_dp.setText("300000");
    }//GEN-LAST:event_r_Gedung_dpActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "SELECT * FROM tb_pembayaran WHERE nis ='" + tNis_pm.getText() + "'";
            Connection con = (Connection)koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data ditampilkan");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        table_data_pembayaran();
        hapus_data_pembayaran();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try{
            String jkkk = null;

            if(rSPP_dp.isSelected()){
                jkkk="SPP";
            }else if(rSeragam_sp.isSelected()){
                jkkk="Seragam";
            }else if(r_Gedung_dp.isSelected()){
                jkkk="Gedung";
            }
            
            String sql = "UPDATE tb_pembayaran SET id='"+ t_id_dp.getText() + "',nis='" + t_NS_dp.getText()
            + "',nama_peserta_didik ='"+ t_NM_dp.getText() + "',pembayaran ='"+ jkkk + "',total_bayar ='"+ t_bayar_dp.getText() + "'WHERE id='" + t_id_dp.getText() + "'";
                    
            Connection con = (Connection) koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Edit Data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Edit Data" + e);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void t_NM_dpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_NM_dpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_NM_dpActionPerformed

    private void dshbrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dshbrActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //Add Panel
        mainPanel.add(dashbord_utama);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_dshbrActionPerformed

    private void server_chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_server_chatActionPerformed
        // TODO add your handling code here:
        guiserver.setVisible(true);
        guiserver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_server_chatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cari;
    private javax.swing.JComboBox<String> cbuser_dp;
    private javax.swing.JPanel dashbord_utama;
    private javax.swing.JPanel data_pembayaran;
    public static final javax.swing.JButton data_petugas = new javax.swing.JButton();
    private javax.swing.JPanel data_petugass;
    public static final javax.swing.JButton data_pmbyr = new javax.swing.JButton();
    public static final javax.swing.JToggleButton data_siswa = new javax.swing.JToggleButton();
    private javax.swing.JPanel data_siswa_tk;
    private javax.swing.JButton dshbr;
    public static final javax.swing.JButton edit = new javax.swing.JButton();
    public static final javax.swing.JButton edit_p = new javax.swing.JButton();
    public static final javax.swing.JButton hapus = new javax.swing.JButton();
    public static final javax.swing.JButton hapus_p = new javax.swing.JButton();
    public static final javax.swing.JButton hubungi = new javax.swing.JButton();
    private javax.swing.JPanel hubungii;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField16;
    public static final javax.swing.JToggleButton jToggleButton1 = new javax.swing.JToggleButton();
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pembayaran;
    public static final javax.swing.JButton pendaftaran = new javax.swing.JButton();
    private javax.swing.JPanel pendaftaran_tk;
    public static final javax.swing.JButton pmbyr = new javax.swing.JButton();
    public static final javax.swing.JButton print = new javax.swing.JButton();
    public static final javax.swing.JButton print_p = new javax.swing.JButton();
    public static final javax.swing.JButton print_pmbyr = new javax.swing.JButton();
    private javax.swing.JRadioButton rGedung;
    private javax.swing.JRadioButton rLaki;
    private javax.swing.JRadioButton rLaki_p;
    private javax.swing.JRadioButton rPerempuan;
    private javax.swing.JRadioButton rPerempuan_p;
    private javax.swing.JRadioButton rSPP;
    private javax.swing.JRadioButton rSPP_dp;
    private javax.swing.JRadioButton rSeragam;
    private javax.swing.JRadioButton rSeragam_sp;
    private javax.swing.JRadioButton r_Gedung_dp;
    public static final javax.swing.JButton server_chat = new javax.swing.JButton();
    public static final javax.swing.JButton simpan = new javax.swing.JButton();
    public static final javax.swing.JButton simpan_p = new javax.swing.JButton();
    private javax.swing.JTextField tAgama;
    private javax.swing.JTextField tAgama_p;
    private javax.swing.JTextArea tAlamat;
    private javax.swing.JTextArea tAlamat_p;
    private javax.swing.JTextField tBB;
    private javax.swing.JTextField tBB_p;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tCari_p;
    private javax.swing.JTextArea tJalan;
    private javax.swing.JTextArea tJalan_p;
    private javax.swing.JTextField tK;
    private javax.swing.JTextField tKD;
    private javax.swing.JTextField tKD_p;
    private javax.swing.JTextField tKK;
    private javax.swing.JTextField tKK_p;
    private javax.swing.JTextField tK_p;
    private javax.swing.JTextField tNA;
    private javax.swing.JTextField tNA_p;
    private javax.swing.JTextField tNB;
    private javax.swing.JTextField tNB_p;
    private javax.swing.JTextField tNL;
    private javax.swing.JTextField tNS_pm;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNama_h;
    private javax.swing.JTextField tNama_p;
    private javax.swing.JTextField tNis;
    private javax.swing.JTextField tNis_h;
    private javax.swing.JTextField tNis_p;
    private javax.swing.JTextField tNis_pm;
    private javax.swing.JTextField tP;
    private javax.swing.JTextField tPA;
    private javax.swing.JTextField tPA_p;
    private javax.swing.JTextField tPB;
    private javax.swing.JTextField tPB_p;
    private javax.swing.JTextField tP_p;
    private javax.swing.JPasswordField tPass;
    private javax.swing.JTextArea tPesan_h;
    private javax.swing.JTextField tTB;
    private javax.swing.JTextField tTB_p;
    private javax.swing.JTextField tTmpTglL;
    private javax.swing.JTextField tTmpTglL_p;
    private javax.swing.JTextField tUsername;
    private javax.swing.JTextField t_Cari_dp;
    private javax.swing.JTextField t_Cari_pm;
    private javax.swing.JTextField t_NM_dp;
    private javax.swing.JTextField t_NS_dp;
    private javax.swing.JTextField t_bayar;
    private javax.swing.JTextField t_bayar_dp;
    private javax.swing.JTextField t_id;
    private javax.swing.JTextField t_id_dp;
    public static final javax.swing.JButton tampil = new javax.swing.JButton();
    public static final javax.swing.JButton tampil_p = new javax.swing.JButton();
    // End of variables declaration//GEN-END:variables
}
