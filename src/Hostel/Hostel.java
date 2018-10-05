/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hostel;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author james m
 */
public class Hostel extends javax.swing.JFrame {

    String autocompleteText = "";
    Connection con;
    Statement stmt;
    ResultSet rs;
    String nulltext = "", searchw = "", table = "", tablef = "", tablef1 = "",
            p11 = "", g = "", p11a = "", ga = "", p11sh = "", gsh = "", hostel = "", roomno = "", idno = "";
    int sub = 0, pos = 0, val2 = 0, tt = 0, roww = 0;
    static int tot = 0, numr = 0;
    private static final int IMG_WIDTH = 120;
    private static final int IMG_HEIGHT = 140;
    String val = "";
    FileOutputStream fos = null;

    public Hostel() {
        initComponents();
        DoConnect();
        this.PopulateHostel();
        this.Start();
        this.PopulateHostels();
//       cbo.setRenderer(new MyRenderer());  
////        cbo.addKeyListener(this);  
////        cbo.addFocusListener(this);  
//        getContentPane().add(cbo,BorderLayout.NORTH);  
//        getContentPane().add(new JTextField(10),BorderLayout.SOUTH);  
//        for(int x = 100; x < 1000; x++) 
//            cbo.addItem(new String[]{""+x,"ABC Project  ","  Other Text"});  
//        pack();  


    }

    public void DoConnect() {
        try {
            String host = "jdbc:mysql://localhost:3306/HOSTEL";
            String uname = "root";
            String upass = "";
            con = DriverManager.getConnection(host, uname, upass);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            DefaultComboBoxModel tb = (DefaultComboBoxModel) cbhostelroom.getModel();
            tb.removeAllElements();
            tb.addElement("SELECT");
            cbhostelroom.setSelectedIndex(0);
            try {
                String sql = "SELECT * FROM HOSTELIN";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb.addElement(rs.getString("NAME"));
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this, err.getMessage());
            }
            tb.addElement("All Hostels");
            //cb hostels
            {
                DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbhostel.getModel();
                tb1.removeAllElements();
                tb1.addElement("SELECT");
                cbhostel.setSelectedIndex(0);
                try {
                    String sql = "SELECT * FROM HOSTELIN";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb1.addElement(rs.getString("NAME"));
                    }
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(this, err.getMessage());
                }
            }
            {
                DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbhostelroom1.getModel();
                tb1.removeAllElements();
                tb1.addElement("SELECT");
                cbhostelroom1.setSelectedIndex(0);
                try {
                    String sql = "SELECT * FROM HOSTELIN";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb1.addElement(rs.getString("NAME"));
                    }
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(this, err.getMessage());
                }
                tb1.addElement("All Hostels");
            }
            //cb search by name
            {
                DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbsbyname.getModel();
                tb1.removeAllElements();
                tb1.addElement("SELECT");
                cbhostel.setSelectedIndex(0);
                try {
                    String sql = "SELECT * FROM STAFF";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb1.addElement(rs.getString("FNAME"));
                    }
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(this, err.getMessage());
                }
            }
            //cb search by idno
            {
                DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbsbyid.getModel();
                tb1.removeAllElements();
                tb1.addElement("SELECT");
                cbhostel.setSelectedIndex(0);
                try {
                    String sql = "SELECT * FROM STAFF";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb1.addElement(rs.getString("IDNO"));
                    }
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(this, err.getMessage());
                }
            }
            Calendar cal = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
            datestartt.setDate(startDate);
            dateendd.setDate(startDate);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this.rootPane, "CONNNECT FAIL\n" + err.getMessage());
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        db = new javax.swing.JFileChooser();
        jaddroom = new javax.swing.JDialog();
        jPanel16 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        txtroomname = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        txtrent = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        cbstatus = new javax.swing.JComboBox();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableregister = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbduration = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtelectric = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbcategory = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtincluded = new javax.swing.JTextField();
        txtwater = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbcontition = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        chapply = new javax.swing.JCheckBox();
        payments = new javax.swing.JDialog();
        toto = new javax.swing.JPanel();
        pt = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablesearch = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtwaterbill = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtampayednow = new javax.swing.JTextField();
        txtotherbills = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        dpayableby = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        txtdatefrom = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        txtdateto = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txtrentexpected = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtelectbill = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtprevious = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtbal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbmonth = new com.toedter.calendar.JMonthChooser();
        cbyear = new com.toedter.calendar.JYearChooser();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtsearch1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        occupation = new javax.swing.ButtonGroup();
        Dexpenses = new javax.swing.JDialog();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel25 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        cbcategexpenses = new javax.swing.JComboBox();
        jLabel92 = new javax.swing.JLabel();
        cbstafflist = new javax.swing.JComboBox();
        jLabel93 = new javax.swing.JLabel();
        txtamountexpense = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtdescexpenses = new javax.swing.JTextArea();
        jLabel95 = new javax.swing.JLabel();
        dateexpense = new com.toedter.calendar.JDateChooser();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableexpense = new javax.swing.JTable();
        jLabel96 = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        btnapprove = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableexpense1 = new javax.swing.JTable();
        jLabel98 = new javax.swing.JLabel();
        dstart = new com.toedter.calendar.JDateChooser();
        dend = new com.toedter.calendar.JDateChooser();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        cbcateg = new javax.swing.JComboBox();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        Dsignout = new javax.swing.JDialog();
        jPanel22 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        txtidnoreg = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        cbhostell = new javax.swing.JComboBox();
        jLabel97 = new javax.swing.JLabel();
        cbroomm = new javax.swing.JComboBox();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablesignout = new javax.swing.JTable();
        jLabel102 = new javax.swing.JLabel();
        lnamesignout = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        ldatein = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        dateout = new com.toedter.calendar.JDateChooser();
        jLabel107 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        txtexpectedsignout = new javax.swing.JTextField();
        txtpayedsignout = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        txtbalsignout = new javax.swing.JTextField();
        lerror = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel103 = new javax.swing.JLabel();
        txtsuggested = new javax.swing.JTextField();
        jButton37 = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        DTransfer = new javax.swing.JDialog();
        jPanel28 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        cbhostell1 = new javax.swing.JComboBox();
        jLabel111 = new javax.swing.JLabel();
        cbroomm1 = new javax.swing.JComboBox();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tablesignout1 = new javax.swing.JTable();
        jLabel114 = new javax.swing.JLabel();
        sdatein = new com.toedter.calendar.JDateChooser();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        txtexpectedsignout1 = new javax.swing.JTextField();
        txtpayedsignout1 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        txtbalsignout1 = new javax.swing.JTextField();
        lerror1 = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel118 = new javax.swing.JLabel();
        txtsuggested1 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        txthosteltr = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        txtroomnotr = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        sdateout = new com.toedter.calendar.JDateChooser();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem21 = new javax.swing.JMenuItem();
        time = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtlname = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtjob = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtinst = new javax.swing.JTextField();
        txtfriend = new javax.swing.JTextField();
        txtidno = new javax.swing.JTextField();
        txtphoneno = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        tb1 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lphoto = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        cbsbyname = new javax.swing.JComboBox();
        jLabel72 = new javax.swing.JLabel();
        cbsbyid = new javax.swing.JComboBox();
        jLabel73 = new javax.swing.JLabel();
        lhostel = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        lroomno = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        txtgurdianname = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtgphoneno = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        txthome = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtregno = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txtyear = new javax.swing.JTextField();
        txtdepartment = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        txtremarks = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        cbhostel = new javax.swing.JComboBox();
        txtrate = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtassetp = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtcaret = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtphonenoc = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        cbrumno = new javax.swing.JComboBox();
        txtdatee = new com.toedter.calendar.JDateChooser();
        txtdateex = new com.toedter.calendar.JDateChooser();
        jButton10 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        cbclientlevel = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        txtnoocupants = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbgender = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableone = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txthostel = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtloc = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtowner = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtphonenoca = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtcaretaker = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtroomno = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtphonenoo = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        txtidnoo = new javax.swing.JTextField();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablereg = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableroomreg = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        cbhostelroom = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnaddroom = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        txtcaretidno = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbstatuss = new javax.swing.JComboBox();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableoccupation = new javax.swing.JTable();
        cbhostelroom2 = new javax.swing.JComboBox();
        jLabel54 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txtsearchbyname1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cbroomnooccupation = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JSeparator();
        jButton33 = new javax.swing.JButton();
        cbcategg = new javax.swing.JComboBox();
        jLabel113 = new javax.swing.JLabel();
        datestartt = new com.toedter.calendar.JDateChooser();
        dateendd = new com.toedter.calendar.JDateChooser();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        signin = new javax.swing.JRadioButton();
        signout = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablepay = new javax.swing.JTable();
        jLabel50 = new javax.swing.JLabel();
        cbhostelroom1 = new javax.swing.JComboBox();
        jLabel74 = new javax.swing.JLabel();
        cbyeard = new javax.swing.JComboBox();
        jLabel76 = new javax.swing.JLabel();
        cbmonthd = new javax.swing.JComboBox();
        jLabel77 = new javax.swing.JLabel();
        txtsearchbyname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cbpaymentroomno = new javax.swing.JComboBox();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablerefund = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        cbhostelroom3 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel82 = new javax.swing.JLabel();
        txtsearchbyname2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablestats = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        cbhostelroom4 = new javax.swing.JComboBox();
        jLabel83 = new javax.swing.JLabel();
        cbyeard1 = new javax.swing.JComboBox();
        jLabel85 = new javax.swing.JLabel();
        cbmonthd1 = new javax.swing.JComboBox();
        txtrentp = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtelecp = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtothersp = new javax.swing.JTextField();
        chall = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        chkeep = new javax.swing.JCheckBox();
        jLabel63 = new javax.swing.JLabel();
        datedue = new com.toedter.calendar.JDateChooser();
        txtwaterp = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        cbproomno1 = new javax.swing.JComboBox();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablestatsview = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();

        db.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        db.setPreferredSize(new java.awt.Dimension(480, 320));

        jaddroom.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jaddroom.setTitle("Add Room Dialog");
        jaddroom.setAlwaysOnTop(true);
        jaddroom.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel78.setText("Room No");

        jLabel79.setText("Rent");

        txtrent.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtrent.setText("0.0");

        jLabel80.setText("Status");

        cbstatus.setMaximumRowCount(2);
        cbstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Taken", " " }));

        jButton12.setText("Add Room");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Cancel");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Registered Rooms", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(0, 0, 255)));

        tableregister.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "RoomNo", "Category", "Included", "Rent", "WaterBill", "ElectricityBill", "RentPeriod", "Condition", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableregister.setFillsViewportHeight(true);
        tableregister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableregisterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableregister);
        tableregister.getColumnModel().getColumn(0).setPreferredWidth(3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );

        jLabel4.setText("Period");

        cbduration.setMaximumRowCount(4);
        cbduration.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monthly", "Quartely", "Semester", "Annually", " " }));

        jLabel5.setText("WaterBill");

        jLabel6.setText("Electricity Bill");

        txtelectric.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtelectric.setText("0.0");

        jLabel7.setText("Room Category");

        cbcategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Double Room", "Bedsitter", "1 BedRoom", "2 BedRoom", "Others" }));

        jLabel8.setText("Included");

        txtwater.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtwater.setText("0.0");

        jLabel9.setText("Condition");

        cbcontition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Average", "Good", "Fair", " " }));

        jButton11.setText("Update");

        jButton14.setText("Remove");

        chapply.setText("Keep Values");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel78)
                            .addComponent(jLabel79)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtroomname, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txtrent)
                            .addComponent(txtwater))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbcategory, 0, 159, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbduration, 0, 159, Short.MAX_VALUE)
                                    .addComponent(txtelectric)))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(chapply)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbstatus, 0, 273, Short.MAX_VALUE)
                            .addComponent(cbcontition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtincluded)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtroomname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel7)
                    .addComponent(cbcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtincluded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel4)
                    .addComponent(cbduration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtelectric, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtwater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(cbcontition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton11)
                    .addComponent(jButton13)
                    .addComponent(jButton12)
                    .addComponent(chapply))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jaddroomLayout = new javax.swing.GroupLayout(jaddroom.getContentPane());
        jaddroom.getContentPane().setLayout(jaddroomLayout);
        jaddroomLayout.setHorizontalGroup(
            jaddroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jaddroomLayout.setVerticalGroup(
            jaddroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        payments.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        payments.setTitle("Payments Dialog");
        payments.setAlwaysOnTop(true);
        payments.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        toto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        toto.setForeground(new java.awt.Color(255, 0, 0));

        pt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search Resident by Name or IDNO/Reg No.", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(0, 0, 255)));

        tablesearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Name", "IDNO/RegNo", "Hostel", "RoomNo", "TotalExpected", "TotalPayed", "BalanceToPay"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablesearch.setFillsViewportHeight(true);
        tablesearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablesearchMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablesearch);
        tablesearch.getColumnModel().getColumn(0).setPreferredWidth(5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );

        jLabel14.setText("Water Bill");

        txtwaterbill.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtwaterbill.setText("0.0");

        jLabel16.setText("Other Bills");

        jLabel55.setText("Amount Payed Now");

        txtampayednow.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtampayednow.setText("0.0");

        txtotherbills.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtotherbills.setText("0.0");

        jLabel19.setText("Payable By");

        jLabel23.setText("Date Covered From");

        jLabel25.setText("Date Covered to");

        jLabel12.setText("Rent Expected");

        txtrentexpected.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtrentexpected.setText("0.0");

        jLabel15.setText("Electricity Bill");

        txtelectbill.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtelectbill.setText("0.0");

        jLabel17.setText("Previous Balance");

        txtprevious.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtprevious.setText("0.0");

        jLabel18.setText("Balance");

        txtbal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtbal.setText("0.0");

        jLabel20.setText("Payment Made for");

        jLabel21.setText("Month");

        jButton3.setText("Make Payment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel Payment");

        jLabel2.setText("Search");

        txtsearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearch1KeyReleased(evt);
            }
        });

        jLabel13.setText("Year");

        javax.swing.GroupLayout ptLayout = new javax.swing.GroupLayout(pt);
        pt.setLayout(ptLayout);
        ptLayout.setHorizontalGroup(
            ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ptLayout.createSequentialGroup()
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbyear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ptLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ptLayout.createSequentialGroup()
                        .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtprevious, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addComponent(txtelectbill)
                                .addComponent(txtrentexpected))
                            .addComponent(txtbal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel19)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtampayednow)
                    .addComponent(txtotherbills)
                    .addComponent(dpayableby, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(txtdatefrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtwaterbill)
                    .addComponent(txtdateto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(ptLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        ptLayout.setVerticalGroup(
            ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ptLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtwaterbill, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(txtrentexpected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtotherbills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtelectbill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtampayednow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtprevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpayableby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ptLayout.createSequentialGroup()
                        .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtdatefrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ptLayout.createSequentialGroup()
                        .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbmonth, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbyear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(ptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(txtsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ptLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dpayableby, txtampayednow, txtdatefrom, txtdateto, txtotherbills, txtwaterbill});

        javax.swing.GroupLayout totoLayout = new javax.swing.GroupLayout(toto);
        toto.setLayout(totoLayout);
        totoLayout.setHorizontalGroup(
            totoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totoLayout.createSequentialGroup()
                .addComponent(pt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        totoLayout.setVerticalGroup(
            totoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paymentsLayout = new javax.swing.GroupLayout(payments.getContentPane());
        payments.getContentPane().setLayout(paymentsLayout);
        paymentsLayout.setHorizontalGroup(
            paymentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paymentsLayout.setVerticalGroup(
            paymentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Dexpenses.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Dexpenses.setTitle("Expenses Dialog");
        Dexpenses.setAlwaysOnTop(true);
        Dexpenses.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jTabbedPane6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane6.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel91.setText("Expense Category");

        cbcategexpenses.setMaximumRowCount(6);
        cbcategexpenses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT CATEGORY", "Agent", "Airtime", "KPLC", "Maintenance", "Salaries", " " }));

        jLabel92.setText("Staff");

        cbstafflist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel93.setText("Amount");

        txtamountexpense.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtamountexpenseKeyTyped(evt);
            }
        });

        jLabel94.setText("Description");

        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtdescexpenses.setColumns(20);
        txtdescexpenses.setRows(5);
        txtdescexpenses.setWrapStyleWord(true);
        jScrollPane12.setViewportView(txtdescexpenses);

        jLabel95.setText("Date");

        jButton25.setText("Submit");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("New");

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), " Expenses Waiting Approval", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(0, 0, 204)));

        tableexpense.setAutoCreateRowSorter(true);
        tableexpense.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ExNO.", "Date", "ExpenseCategory", "Staff", "Description", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableexpense.setFillsViewportHeight(true);
        tableexpense.setSelectionBackground(new java.awt.Color(0, 0, 204));
        tableexpense.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(tableexpense);
        tableexpense.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableexpense.getColumnModel().getColumn(1).setPreferredWidth(40);
        tableexpense.getColumnModel().getColumn(4).setPreferredWidth(200);
        tableexpense.getColumnModel().getColumn(5).setPreferredWidth(40);

        jLabel96.setText("Date");

        datechooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datechooserPropertyChange(evt);
            }
        });

        btnapprove.setText("Approve Expense");
        btnapprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapproveActionPerformed(evt);
            }
        });

        jButton31.setText("View All");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("Print Version");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton27.setText("Revoke Expense");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(btnapprove, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datechooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton31)
                        .addComponent(jButton32)
                        .addComponent(jButton27)
                        .addComponent(btnapprove))
                    .addComponent(jLabel96, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
        );

        jButton30.setText("Update");

        jLabel101.setText("Receiver");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel91)
                    .addComponent(jLabel93)
                    .addComponent(jLabel95)
                    .addComponent(jLabel101))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtamountexpense)
                    .addComponent(cbcategexpenses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(dateexpense, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addComponent(cbstafflist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel91)
                    .addComponent(cbcategexpenses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92)
                    .addComponent(cbstafflist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(txtamountexpense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel94))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel101))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateexpense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton25)
                            .addComponent(jButton26)
                            .addComponent(jButton30)))
                    .addComponent(jScrollPane12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        jTabbedPane6.addTab("Expense Tab", jPanel25);

        jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableexpense1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Date", "ExpenseCategory", "Staff", "Description", "ApprovedDate", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableexpense1.setFillsViewportHeight(true);
        tableexpense1.setGridColor(new java.awt.Color(102, 153, 255));
        jScrollPane14.setViewportView(tableexpense1);
        tableexpense1.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableexpense1.getColumnModel().getColumn(1).setPreferredWidth(40);
        tableexpense1.getColumnModel().getColumn(4).setPreferredWidth(200);
        tableexpense1.getColumnModel().getColumn(6).setPreferredWidth(40);

        jLabel98.setText("Start Date");

        dstart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dstartPropertyChange(evt);
            }
        });

        dend.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dendPropertyChange(evt);
            }
        });

        jLabel99.setText("End Date");

        jLabel100.setText("Category");

        cbcateg.setMaximumRowCount(6);
        cbcateg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT CATEGORY", "Agent", "Airtime", "KPLC", "Maintenance", "Salaries", " " }));
        cbcateg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbcategItemStateChanged(evt);
            }
        });

        jButton28.setText("Print Version");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setText("View All");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dstart, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dend, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel100)
                                    .addComponent(cbcateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dstart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton28)
                            .addComponent(jButton29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane6.addTab("Approved Expenses Tab", jPanel26);

        javax.swing.GroupLayout DexpensesLayout = new javax.swing.GroupLayout(Dexpenses.getContentPane());
        Dexpenses.getContentPane().setLayout(DexpensesLayout);
        DexpensesLayout.setHorizontalGroup(
            DexpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DexpensesLayout.setVerticalGroup(
            DexpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Dsignout.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Dsignout.setTitle("Rom Signout Dialog");
        Dsignout.setAlwaysOnTop(true);
        Dsignout.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel89.setText("IDNO/REGNO");

        txtidnoreg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidnoregKeyReleased(evt);
            }
        });

        jLabel90.setText("Hostel");

        cbhostell.setModel(new DefaultComboBoxModel());
        cbhostell.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhostellItemStateChanged(evt);
            }
        });

        jLabel97.setText("Room No.");

        cbroomm.setModel(new DefaultComboBoxModel());
        cbroomm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbroommItemStateChanged(evt);
            }
        });

        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablesignout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Year", "Month", "Expected", "Payed", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablesignout.setFillsViewportHeight(true);
        jScrollPane10.setViewportView(tablesignout);
        tablesignout.getColumnModel().getColumn(0).setPreferredWidth(5);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );

        jLabel102.setText("Name");

        jLabel104.setText("Date In");

        jLabel106.setText("Date Out");

        jLabel107.setText("Total expected");

        jLabel109.setText("Total Payed");

        txtexpectedsignout.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtexpectedsignout.setText("0.0");

        txtpayedsignout.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpayedsignout.setText("0.0");

        jLabel108.setText("Balance");

        txtbalsignout.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtbalsignout.setText("0.0");

        lerror.setForeground(new java.awt.Color(255, 0, 0));

        jButton34.setText("Signout");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton36.setText("Room Transfer");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jLabel103.setText("Suggeseted Refund");

        txtsuggested.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsuggested.setText("0.0");

        jButton37.setText("Suggest Refund");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel89)
                            .addComponent(jLabel102)
                            .addComponent(jLabel107))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtidnoreg)
                                    .addComponent(lnamesignout, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(2, 2, 2)))
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(cbhostell, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(ldatein, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(8, 8, 8)))
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(jLabel106)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateout, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(cbroomm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(txtexpectedsignout, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel109)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpayedsignout, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel108)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbalsignout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel103)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsuggested))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(lerror, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(txtidnoreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90)
                    .addComponent(cbhostell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(cbroomm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ldatein, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lnamesignout, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(txtexpectedsignout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109)
                    .addComponent(txtpayedsignout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108)
                    .addComponent(txtbalsignout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103)
                    .addComponent(txtsuggested, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lerror, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton34)
                        .addComponent(jButton36)
                        .addComponent(jButton37)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu9.setText("Payment");

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem20.setText("Payment");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem20);

        jMenuBar3.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar3.add(jMenu10);

        Dsignout.setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout DsignoutLayout = new javax.swing.GroupLayout(Dsignout.getContentPane());
        Dsignout.getContentPane().setLayout(DsignoutLayout);
        DsignoutLayout.setHorizontalGroup(
            DsignoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DsignoutLayout.setVerticalGroup(
            DsignoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        DTransfer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DTransfer.setTitle("Room Transfer Dialog");
        DTransfer.setAlwaysOnTop(true);
        DTransfer.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jPanel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel110.setText("Hostel");

        cbhostell1.setModel(new DefaultComboBoxModel());
        cbhostell1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhostell1ItemStateChanged(evt);
            }
        });

        jLabel111.setText("Room No.");

        cbroomm1.setModel(new DefaultComboBoxModel());
        cbroomm1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbroomm1ItemStateChanged(evt);
            }
        });

        jPanel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablesignout1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Name", "IDNO", "Year", "Month", "Expected", "Payed", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablesignout1.setFillsViewportHeight(true);
        jScrollPane15.setViewportView(tablesignout1);
        tablesignout1.getColumnModel().getColumn(0).setPreferredWidth(5);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );

        jLabel114.setText("Date IN");

        sdatein.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                sdateinPropertyChange(evt);
            }
        });

        jLabel115.setText("Total expected");

        jLabel116.setText("Total Payed");

        txtexpectedsignout1.setEditable(false);
        txtexpectedsignout1.setBackground(new java.awt.Color(255, 255, 255));
        txtexpectedsignout1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtexpectedsignout1.setText("0.0");

        txtpayedsignout1.setEditable(false);
        txtpayedsignout1.setBackground(new java.awt.Color(255, 255, 255));
        txtpayedsignout1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtpayedsignout1.setText("0.0");

        jLabel117.setText("Balance");

        txtbalsignout1.setEditable(false);
        txtbalsignout1.setBackground(new java.awt.Color(255, 255, 255));
        txtbalsignout1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtbalsignout1.setText("0.0");

        lerror1.setForeground(new java.awt.Color(255, 0, 0));

        jButton38.setText("Cancel");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("Submit Room Transfer");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jLabel118.setText("Suggeseted Refund");

        txtsuggested1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsuggested1.setText("0.0");

        jLabel119.setText("Current Hostel");

        txthosteltr.setEditable(false);
        txthosteltr.setBackground(new java.awt.Color(255, 255, 255));

        jLabel105.setText("Room NO.");

        jLabel112.setText("Date Out");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtpayedsignout1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel115)
                            .addComponent(jLabel119)
                            .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtexpectedsignout1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txthosteltr)
                            .addComponent(txtroomnotr))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbhostell1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addComponent(jLabel112)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sdateout, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lerror1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbroomm1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sdatein, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel118)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsuggested1))))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel116)
                    .addComponent(jLabel117))
                .addGap(28, 28, 28)
                .addComponent(txtbalsignout1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel110)
                        .addComponent(cbhostell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbroomm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel119)
                        .addComponent(txthosteltr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sdatein, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel105)
                        .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtroomnotr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel112))
                    .addComponent(sdateout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(txtexpectedsignout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118)
                    .addComponent(txtsuggested1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel116)
                            .addComponent(txtpayedsignout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lerror1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel117)
                                .addComponent(txtbalsignout1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton39)
                        .addComponent(jButton38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu11.setText("Payment");

        jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem21.setText("Payment");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem21);

        jMenuBar2.add(jMenu11);

        DTransfer.setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout DTransferLayout = new javax.swing.GroupLayout(DTransfer.getContentPane());
        DTransfer.getContentPane().setLayout(DTransferLayout);
        DTransferLayout.setHorizontalGroup(
            DTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DTransferLayout.setVerticalGroup(
            DTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setBackground(new java.awt.Color(243, 65, 21));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 51, 51));
        jLabel34.setText("Primary Contact");

        jLabel35.setText("First Name");

        jLabel36.setText("Last Name");

        jLabel37.setText("Occupation");

        jLabel39.setText("IDNO/REGNO");

        jLabel40.setText("Mobile Phone ");

        jLabel41.setText("Institution");

        jLabel44.setText("Friend Phone No");

        tb1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tb1.setForeground(new java.awt.Color(243, 65, 21));
        tb1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setForeground(new java.awt.Color(204, 0, 0));

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lphoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lphoto.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lphoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lphoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton5.setText("Save and Proceed");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel71.setText("Search by Name");

        cbsbyname.setModel(new DefaultComboBoxModel());
        cbsbyname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbsbynameItemStateChanged(evt);
            }
        });

        jLabel72.setText("Search by ID/REG");

        cbsbyid.setModel(new DefaultComboBoxModel());
        cbsbyid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbsbyidItemStateChanged(evt);
            }
        });

        jLabel73.setText("Hostel");

        jLabel75.setText("Room No");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Search");

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jButton17.setText("Cancel Entry");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsearch))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(0, 83, Short.MAX_VALUE)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lhostel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lroomno, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel73)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbsbyname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbsbyid, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbsbyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbsbyid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lhostel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lroomno, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)))
        );

        tb1.addTab("Personal Profile ", jPanel13);

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel64.setText("Parent/Gurdian ");

        jLabel65.setText("Phone NO.");

        jLabel66.setText("Home Location");

        jLabel69.setText("Reg NO.");

        jLabel70.setText("Year of Study");

        jLabel86.setText("Department");

        jButton24.setText("Cancel ");

        jButton35.setText("Register");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jLabel87.setText("Remarks");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(jLabel66)
                    .addComponent(jLabel69)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txthome)
                    .addComponent(txtdepartment)
                    .addComponent(txtremarks)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(txtregno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(txtgurdianname, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel65)
                        .addGap(18, 18, 18)
                        .addComponent(txtgphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(txtgurdianname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(txtgphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(txtregno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70)
                    .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(txtremarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(jButton35))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb1.addTab("More Information", jPanel20);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setForeground(new java.awt.Color(255, 0, 0));

        jLabel53.setText("Date of Exit");

        cbhostel.setModel(new DefaultComboBoxModel());
        cbhostel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhostelItemStateChanged(evt);
            }
        });
        cbhostel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhostelActionPerformed(evt);
            }
        });

        jLabel42.setText("Room No");

        jLabel45.setText("CareTaker");

        jLabel52.setText("Rent  KShs");

        jLabel43.setText("Hostel");

        jLabel47.setText("Assets Present");

        jLabel46.setText("Date of Entry");

        txtphonenoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphonenocActionPerformed(evt);
            }
        });

        jButton9.setText("Allocate Room");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        cbrumno.setModel(new DefaultComboBoxModel());
        cbrumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbrumnoItemStateChanged(evt);
            }
        });

        jButton10.setText("Finish");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton18.setText("Make Payments");

        jLabel22.setText("Client Status");

        cbclientlevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Primary", "Secondary" }));
        cbclientlevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbclientlevelItemStateChanged(evt);
            }
        });
        cbclientlevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbclientlevelActionPerformed(evt);
            }
        });

        jLabel26.setText("Current Ocupants");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel45)
                        .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(txtcaret, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(txtphonenoc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbrumno, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtrate, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtdatee, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(txtnoocupants)
                                    .addComponent(txtassetp))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(cbhostel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbclientlevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(txtdateex, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(3, 3, 3))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbhostel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42)
                    .addComponent(cbrumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtnoocupants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel46))
                    .addComponent(txtdatee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdateex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtassetp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel22)
                    .addComponent(cbclientlevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcaret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(txtphonenoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton18))
                .addGap(41, 41, 41))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtassetp, txtcaret, txtphonenoc});

        tb1.addTab("Room Allocation Information", jPanel10);

        jLabel1.setText("Gender");

        cbgender.setMaximumRowCount(3);
        cbgender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "Female", "Male" }));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Name", "IDNO/RegNo", "Gender", "PhoneNo", "Hostel", "RoomNo", "DateIn", "DateOut", "IssuedStatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableone.setFillsViewportHeight(true);
        tableone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableoneMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableone);
        tableone.getColumnModel().getColumn(0).setPreferredWidth(5);
        tableone.getColumnModel().getColumn(1).setPreferredWidth(120);
        tableone.getColumnModel().getColumn(3).setPreferredWidth(50);
        tableone.getColumnModel().getColumn(5).setPreferredWidth(120);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtjob, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel34)
                                .addComponent(txtfname)
                                .addComponent(txtlname)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(txtidno, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbgender, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)))
                            .addComponent(txtinst, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfriend, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tb1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtfname, txtfriend, txtinst, txtjob, txtlname, txtphoneno});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(jLabel1)
                            .addComponent(cbgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtinst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfriend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)))
                    .addComponent(tb1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Register Clients Tab", jPanel8);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel38.setBackground(new java.awt.Color(243, 65, 21));
        jLabel38.setText("Name");

        jLabel48.setBackground(new java.awt.Color(243, 65, 21));
        jLabel48.setText("Location");

        jLabel49.setText("Owner");

        jLabel51.setText("Phone No");

        jLabel59.setBackground(new java.awt.Color(243, 65, 21));
        jLabel59.setText("Caretaker");

        txtcaretaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcaretakerActionPerformed(evt);
            }
        });

        jLabel60.setBackground(new java.awt.Color(243, 65, 21));
        jLabel60.setText("No.of Rooms");

        txtroomno.setText("0");

        jLabel62.setText("Phone No");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(243, 65, 21));
        jLabel67.setText("Residence Information");

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel68.setText("IDNO");

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane3.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablereg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "HostelName", "Location", "RoomNo", "CareTakerPhoneNo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablereg.setFillsViewportHeight(true);
        jScrollPane2.setViewportView(tablereg);
        tablereg.getColumnModel().getColumn(0).setPreferredWidth(1);
        tablereg.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablereg.getColumnModel().getColumn(3).setPreferredWidth(20);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Registered Apartments", jPanel14);

        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableroomreg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ApartmentName", "RoomNo", "Rent", "Condition", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableroomreg.setFillsViewportHeight(true);
        jScrollPane5.setViewportView(tableroomreg);
        tableroomreg.getColumnModel().getColumn(0).setPreferredWidth(1);
        tableroomreg.getColumnModel().getColumn(1).setPreferredWidth(100);

        jLabel24.setText("Hostel ");

        cbhostelroom.setModel(new DefaultComboBoxModel());
        cbhostelroom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhostelroomItemStateChanged(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print Version");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnaddroom.setText("Add Room");
        btnaddroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddroomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbhostelroom, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaddroom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbhostelroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnaddroom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Register Rooms", jPanel15);

        jButton7.setText("Register");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("View All");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel81.setText("ID NO.");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 0, 0));
        jLabel88.setText("Ownership Information");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("CareTaker Information");

        jLabel10.setText("Status");

        cbstatuss.setMaximumRowCount(2);
        cbstatuss.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "Suspended", " " }));

        jButton15.setText("Update");

        jButton16.setText("Suspend");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtcaretidno, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtphonenoca, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcaretaker, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                    .addComponent(txtphonenoo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(99, 99, 99)))
                        .addGap(540, 540, 540))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtidnoo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtowner, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtroomno, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbstatuss, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtloc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                        .addComponent(txthostel, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtcaretaker, txtcaretidno, txthostel, txtidnoo, txtloc, txtowner, txtphonenoca, txtphonenoo});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthostel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(txtroomno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(cbstatuss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txtowner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(txtidnoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtphonenoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcaretaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txtphonenoca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcaretidno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton16))
                        .addGap(39, 39, 39)
                        .addComponent(jButton15)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Apartments Tab", jPanel4);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableoccupation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Apartment", "RoomNo", "Name", "IDNO", "DateEntry", "DateOut", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableoccupation.setFillsViewportHeight(true);
        jScrollPane7.setViewportView(tableoccupation);
        tableoccupation.getColumnModel().getColumn(0).setPreferredWidth(3);
        tableoccupation.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableoccupation.getColumnModel().getColumn(3).setPreferredWidth(150);

        cbhostelroom2.setModel(new DefaultComboBoxModel());
        cbhostelroom2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhostelroom2ItemStateChanged(evt);
            }
        });

        jLabel54.setText("Apartments");

        jLabel84.setText("Search ");

        txtsearchbyname1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchbyname1KeyReleased(evt);
            }
        });

        jLabel27.setText("Room No");

        cbroomnooccupation.setModel(new DefaultComboBoxModel());
        cbroomnooccupation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbroomnooccupationItemStateChanged(evt);
            }
        });

        jButton33.setText("Print Version");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        cbcategg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Current", "Signed Out  ", "All Occupants", " " }));
        cbcategg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbcateggItemStateChanged(evt);
            }
        });

        jLabel113.setText("Time of Start");

        jLabel120.setText("End");

        jLabel121.setText("Status");

        time.add(signin);
        signin.setSelected(true);
        signin.setText("Signin");

        time.add(signout);
        signout.setText("Signout");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(signin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signout, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datestartt, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(dateendd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbhostelroom2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbroomnooccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbcategg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsearchbyname1))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtsearchbyname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(signin)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton33)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(signout)
                                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(cbroomnooccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbhostelroom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel84))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbcategg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel121)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(datestartt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateendd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Room Occupation Tab", jPanel5);

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablepay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "Apartments", "RoomNo", "Name", "Year", "Month", "DateofPay", "Expected", "Amount", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablepay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablepay.setFillsViewportHeight(true);
        jScrollPane3.setViewportView(tablepay);
        tablepay.getColumnModel().getColumn(0).setPreferredWidth(1);
        tablepay.getColumnModel().getColumn(3).setHeaderValue("Name");
        tablepay.getColumnModel().getColumn(4).setPreferredWidth(5);
        tablepay.getColumnModel().getColumn(4).setHeaderValue("Year");
        tablepay.getColumnModel().getColumn(5).setPreferredWidth(5);
        tablepay.getColumnModel().getColumn(5).setHeaderValue("Month");

        jLabel50.setText("Hostel");

        cbhostelroom1.setModel(new DefaultComboBoxModel());
        cbhostelroom1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhostelroom1ItemStateChanged(evt);
            }
        });

        jLabel74.setText("Year");

        cbyeard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
        cbyeard.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbyeardItemStateChanged(evt);
            }
        });

        jLabel76.setText("Month");

        cbmonthd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbmonthd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbmonthdItemStateChanged(evt);
            }
        });

        jLabel77.setText("Search by Name");

        txtsearchbyname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchbynameActionPerformed(evt);
            }
        });

        jLabel28.setText("Room No.");

        cbpaymentroomno.setModel(new DefaultComboBoxModel());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel74)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbyeard, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbmonthd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50)
                .addGap(27, 27, 27)
                .addComponent(cbhostelroom1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbpaymentroomno, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearchbyname))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(cbyeard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76)
                    .addComponent(cbmonthd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearchbyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(cbhostelroom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(cbpaymentroomno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Payment Record Tab", jPanel7);

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel17MouseEntered(evt);
            }
        });

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablerefund.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Apartment", "RoomNo", "Name", "IdNo/RegNo", "EntryDate", "ExitDate", "AmountDue", "AmountPayed", "RefundDue"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablerefund.setFillsViewportHeight(true);
        jScrollPane8.setViewportView(tablerefund);
        tablerefund.getColumnModel().getColumn(0).setPreferredWidth(5);
        tablerefund.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablerefund.getColumnModel().getColumn(3).setPreferredWidth(100);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        jLabel56.setText("Hostel");

        cbhostelroom3.setModel(new DefaultComboBoxModel());
        cbhostelroom3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhostelroom3ItemStateChanged(evt);
            }
        });

        jLabel29.setText("Room No.");

        jComboBox3.setModel(new DefaultComboBoxModel());

        jLabel82.setText("Search ");

        txtsearchbyname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchbyname2ActionPerformed(evt);
            }
        });

        jLabel30.setText("Amount Issued");

        jButton19.setText("Post Refund");

        jButton20.setText("Print Report");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbhostelroom3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearchbyname2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearchbyname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(cbhostelroom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel30)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19)
                    .addComponent(jButton20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Refund Tab", jPanel17);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Payment Tab", jPanel12);

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane5.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablestats.setAutoCreateRowSorter(true);
        tablestats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Apartments", "RoomNo", "Rent", "Electricity", "Water", "Others", "ExpectedDate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablestats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablestats.setFillsViewportHeight(true);
        tablestats.getTableHeader().setReorderingAllowed(false);
        tablestats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablestatsMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tablestats);
        tablestats.getColumnModel().getColumn(0).setPreferredWidth(1);

        jLabel57.setText("Hostel");

        cbhostelroom4.setModel(new DefaultComboBoxModel());
        cbhostelroom4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhostelroom4ItemStateChanged(evt);
            }
        });
        cbhostelroom4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhostelroom4ActionPerformed(evt);
            }
        });

        jLabel83.setText("Year");

        cbyeard1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
        cbyeard1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbyeard1ItemStateChanged(evt);
            }
        });

        jLabel85.setText("Month");

        cbmonthd1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        cbmonthd1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbmonthd1ItemStateChanged(evt);
            }
        });

        txtrentp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtrentp.setText("0.0");

        jLabel33.setText("Water");

        jLabel58.setText("Electricity");

        txtelecp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtelecp.setText("0.0");
        txtelecp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelecpActionPerformed(evt);
            }
        });

        jLabel61.setText("Others");

        txtothersp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtothersp.setText("0.0");

        chall.setText("Apply to All Rooms");

        jLabel32.setText("Rent ");

        jButton23.setText("Post Values");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        chkeep.setText("Keep Values");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setText("Date Due");

        txtwaterp.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtwaterp.setText("0.0");

        jLabel31.setText("Room No.");

        cbproomno1.setModel(new DefaultComboBoxModel());
        cbproomno1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbproomno1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbhostelroom4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbproomno1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addComponent(jLabel85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbmonthd1, 0, 111, Short.MAX_VALUE)
                    .addComponent(cbyeard1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtelecp, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txtrentp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtwaterp, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(txtothersp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(chall, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel63))
                    .addComponent(chkeep, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datedue, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel57)
                                    .addComponent(cbhostelroom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel83)
                                    .addComponent(cbyeard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtrentp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(txtwaterp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chall)
                                    .addComponent(jLabel63)))
                            .addComponent(datedue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85)
                            .addComponent(cbmonthd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58)
                            .addComponent(txtelecp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61)
                            .addComponent(txtothersp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkeep)
                            .addComponent(jLabel31)
                            .addComponent(cbproomno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Required Rent Entry", jPanel21);

        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablestatsview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "RoomNO.", "Name", "Rent", "Electricity", "Water", "Others", "Payed", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablestatsview.setFillsViewportHeight(true);
        jScrollPane11.setViewportView(tablestatsview);
        tablestatsview.getColumnModel().getColumn(0).setPreferredWidth(5);
        tablestatsview.getColumnModel().getColumn(2).setPreferredWidth(200);

        jButton21.setText("Post to All Clients");

        jButton22.setText("Print");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel23Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton21, jButton22});

        jTabbedPane5.addTab("View Posting", jPanel23);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Room Stats", jPanel19);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem3.setText("Login");
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Log Out");
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator5);

        jMenuItem5.setText("EXIT");
        jMenu1.add(jMenuItem5);

        jMenuItem19.setText("Sign Out");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem19);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Payment");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Make Payments");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem13.setText("Refund");
        jMenu2.add(jMenuItem13);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Apartment");

        jMenuItem4.setText("New Apartment");
        jMenu3.add(jMenuItem4);

        jMenuItem6.setText("New Rooms");
        jMenu3.add(jMenuItem6);
        jMenu3.add(jSeparator7);

        jMenuItem12.setText("Hostel List");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);
        jMenu3.add(jSeparator8);

        jMenuItem14.setText("Room List");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem14);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Clients");

        jMenuItem7.setText("New Client");
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Allocate Room");
        jMenu4.add(jMenuItem8);

        jMenuItem9.setText("Sign Out");
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Make Payment");
        jMenu4.add(jMenuItem10);
        jMenu4.add(jSeparator6);

        jMenuItem11.setText("Client List");
        jMenu4.add(jMenuItem11);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Reports");

        jMenuItem15.setText("Registered Apartments");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem16.setText("Registered Clients");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuItem17.setText("Room Allocation");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem17);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Expenses");

        jMenuItem18.setText("New Expense");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem18);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcaretakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcaretakerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcaretakerActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        idno = "";
        PreparedStatement psmnt = null;
        FileInputStream fis = null;
        String gender = "";
        try {
            String sql = "SELECT * FROM Staff";
            rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("FNAME", txtfname.getText() + "  " + txtlname.getText());
            rs.updateString("LNAME", txtlname.getText());
            rs.updateString("IDNO", txtidno.getText());
            rs.updateString("JOB", txtjob.getText());
            rs.updateString("GENDER", cbgender.getSelectedItem().toString());
            rs.updateString("INST", txtinst.getText());
            rs.updateString("PHONENO", "0" + Integer.toString(Integer.parseInt(txtphoneno.getText())));
            rs.updateString("FRIENDP", "0" + Integer.toString(Integer.parseInt(txtfriend.getText())));
            if (p11.equals("")) {
            } else {
                File image = new File(p11);
                fis = new FileInputStream(image);
                rs.updateBinaryStream("PHOTO", (InputStream) fis, (int) (image.length()));
                lphoto.setIcon(null);
            }
            rs.insertRow();
            this.Start();
            p11 = "";
            g = "";

            {
                DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbsbyname.getModel();
                tb1.removeAllElements();
                tb1.addElement("SELECT");
                cbhostel.setSelectedIndex(0);
                try {
                    sql = "SELECT * FROM STAFF";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb1.addElement(rs.getString("FNAME") + "  " + rs.getString("LNAME"));
                    }
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(this, "RRR" + err.getMessage());
                }
            }
            //cb search by idno
            {
                DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbsbyid.getModel();
                tb1.removeAllElements();
                tb1.addElement("SELECT");
                cbhostel.setSelectedIndex(0);
                try {
                    sql = "SELECT * FROM STAFF";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb1.addElement(rs.getString("IDNO"));
                    }
                    cbsbyid.setSelectedItem(txtidno.getText());
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(this, "YYY" + err.getMessage());
                }
            }
            hostel = cbhostel.getSelectedItem().toString();
            roomno = cbrumno.getSelectedItem().toString();

            sql = "SELECT * FROM STAFF";
            rs = stmt.executeQuery(sql);
            rs.last();
            idno = rs.getString("idno");
            //System.out.println(idno);
            JOptionPane.showMessageDialog(this.rootPane, "Staff Registered");

        } catch (FileNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this.rootPane, "Registration Error\n" + ex.getMessage());
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(this.rootPane, err.getMessage());
        }

        {
        }    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DefaultTableModel tb = (DefaultTableModel) tablereg.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        txthostel.setText("");
        txtloc.setText("");
        txtowner.setText("");
        txtidnoo.setText("");
        txtphonenoo.setText("");
        txtroomno.setText("");
        txtcaretaker.setText("");
        txtphonenoca.setText("");
        txtcaretidno.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultTableModel tb = (DefaultTableModel) tablereg.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        int i = 1;
        String sql = "";
        try {
            sql = "SELECT * FROM HOSTELIN";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(i, i - 1, 0);
                tb.setValueAt(rs.getString("NAME"), i - 1, 1);
                tb.setValueAt(rs.getString("LOC"), i - 1, 2);
                tb.setValueAt(rs.getString("ROOMNO"), i - 1, 3);
                tb.setValueAt(rs.getString("RATE"), i - 1, 4);
                i++;
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this, "BBB" + err.getMessage());
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        PreparedStatement psmnt = null;
        FileInputStream fis = null;
        String gender = "";
        try {
            String sql = "SELECT * FROM HOSTELIN";
            rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("NAME", txthostel.getText());
            rs.updateString("LOC", txtloc.getText());
            rs.updateString("OWNER", txtowner.getText());
            rs.updateString("IDNO", txtidnoo.getText());
            rs.updateString("PHONENO", "0" + Integer.toString(Integer.parseInt(txtphonenoo.getText())));
            rs.updateString("ROOMNO", txtroomno.getText());
            rs.updateString("CARET", txtcaretaker.getText());
            rs.updateString("CPHONENO", "0" + Integer.toString(Integer.parseInt(txtphonenoca.getText())));
            rs.updateString("CARETID", txtcaretidno.getText());
            rs.updateString("STATUS", cbstatuss.getSelectedItem().toString());
            rs.insertRow();
            JOptionPane.showMessageDialog(this.rootPane, "Apartment Registered");
            {
                DefaultComboBoxModel tb = (DefaultComboBoxModel) cbhostelroom.getModel();
                tb.removeAllElements();
                tb.addElement("SELECT");
                try {
                    sql = "SELECT * FROM HOSTELIN";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb.addElement(rs.getString("NAME"));
                    }
                } catch (SQLException err) {
                    JOptionPane.showMessageDialog(this, "VVV" + err.getMessage());
                }
                tb.addElement("All Hostels");
                cbhostelroom.setSelectedItem(txthostel.getText());
            }
            setUpSportColumn(tableroomreg, tableroomreg.getColumnModel().getColumn(4));
            DefaultTableModel tb = (DefaultTableModel) tableroomreg.getModel();
            while (tb.getRowCount() > 0) {
                tb.removeRow(0);
            }
            int i = 0;
            String row[] = {};
            while (i < Integer.parseInt(txtroomno.getText())) {
                tb.addRow(row);
                tb.setValueAt(txthostel.getText().substring(0, 4) + "-" + (i + 1), i, 0);
                tb.setValueAt(txthostel.getText(), i, 1);
                tb.setValueAt(i + 1, i, 2);
                //tb.setValueAt(txtratepm.getText(), i, 3);
                tb.setValueAt("Available", i, 4);
                i++;
            }
            txthostel.setText("");
            txtloc.setText("");

            txtowner.setText("");
            txtidnoo.setText("");
            txtphonenoo.setText("");
            txtroomno.setText("");

            txtcaretaker.setText("");
            txtcaretidno.setText("");
            txtphonenoca.setText("");
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(this.rootPane, "XXX" + err.getMessage());
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this.rootPane, "Registration Error\n" + err.getMessage());
        }
        DefaultTableModel tb = (DefaultTableModel) tablereg.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        int i = 1;
        String sql = "";
        try {
            sql = "SELECT * FROM HOSTELIN";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(i, i - 1, 0);
                tb.setValueAt(rs.getString("NAME"), i - 1, 1);
                tb.setValueAt(rs.getString("LOC"), i - 1, 2);
                tb.setValueAt(rs.getString("ROOMNO"), i - 1, 3);
                tb.setValueAt(rs.getString("RATE"), i - 1, 4);
                i++;
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this, "111" + err.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultComboBoxModel tb = (DefaultComboBoxModel) cbhostelroom.getModel();
        tb.removeAllElements();
        tb.addElement("SELECT");
        try {
            String sql = "SELECT * FROM HOSTELIN";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addElement(rs.getString("NAME"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this, "2222" + err.getMessage());
        }
         tb.addElement("All Hostels");    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd,MMM yyyy HH:mm:ss");
        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
        
            DecimalFormat f = new DecimalFormat("#,###.##");
            TextColumnBuilder<String> sno = col.column(" ", "sno", type.stringType()).setWidth(30);
            TextColumnBuilder<String> apart = col.column("Apartment", "apart", type.stringType()).setWidth(150);
            TextColumnBuilder<String> roomno = col.column("RoomNo", "roomno", type.stringType());
            TextColumnBuilder<String> cond = col.column("Condition", "cond", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.LEFT);
            TextColumnBuilder<String> status = col.column("Status.", "status", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.LEFT);
            StyleBuilder groupStyle = stl.style().bold();
            {
                try {
                    report()
                            .setTemplate(Templates.reportTemplate)
                            .columns(sno, apart, roomno, cond, status)
                            .title(Templates.createTitleComponent1(
                            dateformat.format(startDate),
                            "SUPPLIER :",
                            "DROP POINT :",
                            "SALE NO. :",
                            "SUPPLIER CREDIT PAYMENT STATEMENT"),
                            cmp.verticalGap(10))
                            .pageFooter(Templates.footerComponent)
                            .setDataSource(RoomDataSource1())
                            .show(false);
                } catch (DRException e) {
                    System.out.println(e.getMessage());
                }
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbhostelroomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhostelroomItemStateChanged
        setUpSportColumn(tableroomreg, tableroomreg.getColumnModel().getColumn(5));
        DefaultTableModel tb = (DefaultTableModel) tableroomreg.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        if (cbhostelroom.getSelectedIndex() == 0 || cbhostelroom.getItemCount() == 0) {
        } else {
            String row[] = {};
            int i = 1;
            String sql = "";
            try {
                if (cbhostelroom.getSelectedIndex() == cbhostelroom.getItemCount() - 1) {
                    sql = "SELECT * FROM ROOM";
                } else {
                    sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom.getSelectedItem().toString() + "'";
                }
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb.addRow(row);
                    tb.setValueAt(i, i - 1, 0);
                    tb.setValueAt(rs.getString("HOSTEL"), i - 1, 1);
                    tb.setValueAt(rs.getString("ROOMNO"), i - 1, 2);
                    tb.setValueAt(rs.getString("RENT"), i - 1, 3);
                    tb.setValueAt(rs.getString("CONDITION"), i - 1, 4);
                    tb.setValueAt(rs.getString("STATUS"), i - 1, 5);
                    i++;
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this, err.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbhostelroomItemStateChanged

    private void txtphonenocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphonenocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphonenocActionPerformed

    private void cbsbyidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbsbyidItemStateChanged
//        this.Clear();
        idno = "";
        if (cbsbyid.getItemCount() > 0) {
            try {
                String sql = "SELECT * FROM STAFF WHERE IDNO="
                        + "'" + cbsbyid.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                String name = (rs.getString("FNAME"));
                String fname[] = name.split("  ");
                txtlname.setText((fname[1]));
                txtfname.setText((fname[0]));
                txtidno.setText(rs.getString("IDNO"));
                txtjob.setText(rs.getString("JOB"));
                txtinst.setText(rs.getString("INST"));
                txtphoneno.setText(rs.getString("PHONENO"));
                txtfriend.setText(rs.getString("FRIENDP"));
                idno = rs.getString("IDNO");
                //System.out.println(idno);

                cbgender.setSelectedItem(rs.getString("GENDER"));
                sql = "SELECT * FROM CLIENTV WHERE IDNO="
                        + "'" + cbsbyid.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                txtrate.setText(rs.getString("RATE"));
                txtdatee.setDate(rs.getDate("DATEE"));
                txtdateex.setDate(rs.getDate("DATEEX"));
                txtassetp.setText(rs.getString("ASSET"));
                txtcaret.setText(rs.getString("CARET"));
                txtphonenoc.setText(rs.getString("CPHONENO"));
                lhostel.setText(rs.getString("HOSTEL"));
                lroomno.setText(rs.getString("ROOM"));
                hostel = rs.getString("HOSTEL");
                roomno = rs.getString("ROOM");
            } catch (ArrayIndexOutOfBoundsException err) {
                txtrate.setText("");
                hostel = "";
                roomno = "";
                //  JOptionPane.showMessageDialog(this, err.getMessage());
            } catch (NullPointerException err) {
                // txtrate.setText("");
                // JOptionPane.showMessageDialog(this, err.getMessage());
                hostel = "";
                roomno = "";
            } catch (SQLException err) {
                // txtrate.setText("");
                // JOptionPane.showMessageDialog(this, err.getMessage());
                hostel = "";
                roomno = "";
            }
            // cbsbyname.setSelectedIndex(0);
            if (cbsbyname.getItemCount() > 0) {
                cbsbyname.setSelectedIndex(0);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbsbyidItemStateChanged

    private void cbsbynameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbsbynameItemStateChanged
        idno = "";
        // this.Clear();
        if (cbsbyname.getItemCount() > 0) {
            try {
                String sql = "SELECT * FROM STAFF WHERE FNAME="
                        + "'" + cbsbyname.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                String name = cbsbyname.getSelectedItem().toString();
                String fname[] = name.split("  ");
                txtlname.setText((fname[1]));
                txtfname.setText((fname[0]));
                txtidno.setText(rs.getString("IDNO"));
                txtjob.setText(rs.getString("JOB"));
                txtinst.setText(rs.getString("INST"));
                txtphoneno.setText(rs.getString("PHONENO"));
                txtfriend.setText(rs.getString("FRIENDP"));
                cbgender.setSelectedItem(rs.getString("GENDER"));
                idno = rs.getString("IDNO");
                //System.out.println(idno);

                sql = "SELECT * FROM CLIENTV WHERE FNAME="
                        + "'" + cbsbyname.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                txtrate.setText(rs.getString("RATE"));
                txtdatee.setDate(rs.getDate("DATEE"));
                txtdateex.setDate(rs.getDate("DATEEX"));
                txtassetp.setText(rs.getString("ASSET"));
                txtcaret.setText(rs.getString("CARET"));
                txtphonenoc.setText(rs.getString("CPHONENO"));
                lhostel.setText(rs.getString("HOSTEL"));
                lroomno.setText(rs.getString("ROOM"));
                hostel = rs.getString("HOSTEL");
                roomno = rs.getString("ROOM");
            } catch (ArrayIndexOutOfBoundsException err) {
                txtrate.setText("");
                //JOptionPane.showMessageDialog(this, err.getMessage());
                hostel = "";
                roomno = "";
            } catch (NullPointerException err) {
                // txtrate.setText("");
                // JOptionPane.showMessageDialog(this, err.getMessage());
                hostel = "";
                roomno = "";
            } catch (SQLException err) {
                // txtrate.setText("");
                // JOptionPane.showMessageDialog(this, err.getMessage());
                hostel = "";
                roomno = "";
            }
            if (cbsbyid.getItemCount() > 0) {
                cbsbyid.setSelectedIndex(0);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbsbynameItemStateChanged

    private void cbrumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbrumnoItemStateChanged
        if (cbhostel.getSelectedIndex() == 0) {
        } else {
            if (cbrumno.getSelectedIndex() == 0) {
            } else {
                try {
                    String sql = "SELECT * FROM ROOM WHERE ROOMNO="
                            + "'" + cbrumno.getSelectedItem().toString() + "' AND "
                            + "HOSTEL='" + cbhostel.getSelectedItem().toString() + "'";
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    txtrate.setText(rs.getString("RENT"));

                } catch (NullPointerException | SQLException err) {
                    txtrate.setText("");
                    //JOptionPane.showMessageDialog(this, err.getMessage());
                }
                int t = 0;
                try {
                    String sql = "SELECT * FROM HOSTEL WHERE ROOMNO="
                            + "'" + cbrumno.getSelectedItem().toString() + "' AND "
                            + "HOSTEL='" + cbhostel.getSelectedItem().toString() + "' AND STATUS='IN'";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        t++;
                    }
                    //txtrate.setText(rs.getString("RENT"));
                } catch (NullPointerException | SQLException err) {
                    //txtrate.setText("");
                    //JOptionPane.showMessageDialog(this, err.getMessage());
                }
                txtnoocupants.setText(Integer.toString(t));
                t = 0;
            }
        }     // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_cbrumnoItemStateChanged

    private void cbhostelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhostelItemStateChanged
        DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbrumno.getModel();
        tb1.removeAllElements();
        tb1.addElement("SELECT ROOM");
        cbrumno.setSelectedIndex(0);
        try {
            String sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostel.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb1.addElement(rs.getString("ROOMNO"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this, "SSS" + err.getMessage());
        }
        try {
            String sql = "SELECT * FROM HOSTELIN WHERE NAME"
                    + "='" + cbhostel.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            txtcaret.setText(rs.getString("CARET"));
            txtphonenoc.setText(rs.getString("CPHONENO"));
        } catch (SQLException err) {
            //JOptionPane.showMessageDialog(this, "FFFF"+err.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbhostelItemStateChanged

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (Integer.parseInt(txtnoocupants.getText()) == 0) {
            cbclientlevel.setSelectedIndex(0);
        } else {
            cbclientlevel.setSelectedIndex(1);
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
        try {
            String sql = "SELECT * FROM HOSTEL";
            rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("HOSTEL", cbhostel.getSelectedItem().toString());
            rs.updateString("IDNO", txtidno.getText());
            rs.updateString("ROOMNO", cbrumno.getSelectedItem().toString());
            rs.updateString("RATE", txtrate.getText());
            rs.updateString("DATEE", dateformat.format(txtdatee.getDate()));
            rs.updateString("DATEEX", dateformat.format(txtdateex.getDate()));
            rs.updateString("ASSET", txtassetp.getText());
            rs.updateString("LEVEL", cbclientlevel.getSelectedItem().toString());
            rs.insertRow();

            sql = "SELECT * FROM STAFF WHERE IDNO='" + tableone.getValueAt(tableone.getSelectedRow(), 2) + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            rs.updateString("ISSUED", "yes");
            rs.updateRow();

            sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostel.getSelectedItem().
                    toString() + "' && ROOMNO='" + cbrumno.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            rs.updateString("STATUS", "TAKEN");
            rs.updateRow();
            JOptionPane.showMessageDialog(this.rootPane, "Room Allocated in \n"
                    + cbhostel.getSelectedItem().toString() + "  " + cbrumno.getSelectedItem().toString());


        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(this.rootPane, "JJJ" + err.getMessage());
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this.rootPane, "Registration Error\n" + err.getMessage());
        }
        this.Start();// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
        try {
            String sql = "SELECT * FROM EXPECTED";
            rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("RENT", txtrentexpected.getText());
            rs.updateString("WATER", txtwaterbill.getText());
            rs.updateString("ELECTRICITY", txtelectbill.getText());
            rs.updateString("OTHERS", txtotherbills.getText());
            rs.updateString("IDNO", tablesearch.getValueAt(tablesearch.getSelectedRow(), 2).toString());
            rs.updateString("DATE", dateformat.format(startDate));
            rs.updateString("MONTH", Integer.toString(cbmonth.getMonth()));
            rs.updateString("YEAR", Integer.toString(cbyear.getYear()));
            rs.updateString("FROM", dateformat.format(txtdatefrom.getDate()));
            rs.updateString("TO", dateformat.format(txtdateto.getDate()));
            rs.updateString("HOSTEL", tablesearch.getValueAt(tablesearch.getSelectedRow(), 3).toString());
            rs.updateString("ROOMNO", tablesearch.getValueAt(tablesearch.getSelectedRow(), 4).toString());
            rs.insertRow();

            sql = "SELECT * FROM PAYMENT";
            rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("AMOUNT", txtampayednow.getText());
            rs.updateString("IDNO", tablesearch.getValueAt(tablesearch.getSelectedRow(), 2).toString());
            rs.updateString("DATE", dateformat.format(startDate));
            rs.updateString("MONTH", Integer.toString(cbmonth.getMonth()));
            rs.updateString("YEAR", Integer.toString(cbyear.getYear()));
            rs.updateString("PFROM", dateformat.format(txtdatefrom.getDate()));
            rs.updateString("PTO", dateformat.format(txtdateto.getDate()));
            rs.updateString("HOSTEL", tablesearch.getValueAt(tablesearch.getSelectedRow(), 3).toString());
            rs.updateString("ROOMNO", tablesearch.getValueAt(tablesearch.getSelectedRow(), 4).toString());
            rs.updateString("EXPECTED", dateformat.format(dpayableby.getDate()));
            rs.insertRow();
            JOptionPane.showMessageDialog(this.rootPane, "Payment Made");

            txtlname.setText("");
            txtfname.setText("");
            txtidno.setText("");
            txtjob.setText("");
            txtinst.setText("");
            txtphoneno.setText("");
            txtfriend.setText("");
            cbgender.setSelectedIndex(0);
            cbhostel.setSelectedIndex(0);
            cbrumno.setSelectedIndex(0);
            txtrate.setText("");
            txtdatee.setDate(null);
            txtdateex.setDate(null);
            txtassetp.setText("");
            txtampayednow.setText("");
            dpayableby.setDate(null);
            txtfriend.setText("");
            cbmonth.setMonth(0);
            cbyear.setYear(0);
            txtdatefrom.setDate(null);
            txtdateto.setDate(null);
            txtcaret.setText("");
            txtphonenoc.setText("");
            // txtnotes.setText("");
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(this.rootPane, "LLL" + err.getMessage());
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this.rootPane, "Registration Error\n" + err.getMessage());
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbmonthdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbmonthdItemStateChanged
        DefaultTableModel tb = (DefaultTableModel) tablepay.getModel();

        while (tb.getRowCount() > 0) {

            tb.removeRow(0);

        }

        if (cbhostelroom1.getSelectedIndex() == 0 || cbhostelroom1.getItemCount() == 0) {
        } else {

            String row[] = {};

            int i = 1;

            String sql = "";

            try {

                if (cbyeard.getSelectedIndex() == 0) {

                    if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {

                        sql = "SELECT * FROM PAYMENTV";

                    } else {

                        sql = "SELECT * FROM PAYMENTV WHERE HOSTEL='"
                                + cbhostelroom1.getSelectedItem().toString() + "'";

                    }

                } else {

                    if (cbmonthd.getSelectedIndex() == 0) {

                        if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {

                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "'";

                        } else {

                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "HOSTEL='" + cbhostelroom1.getSelectedItem().toString() + "' && "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "'";

                        }

                    } else {

                        if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {

                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "' && "
                                    + "MONTH='" + cbmonthd.getSelectedItem().toString() + "'";

                        } else {

                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "HOSTEL='" + cbhostelroom1.getSelectedItem().toString() + "' && "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "' &&  "
                                    + "MONTH='" + cbmonthd.getSelectedItem().toString() + "'";

                        }

                    }

                }

                rs = stmt.executeQuery(sql);

                while (rs.next()) {

                    tb.addRow(row);

                    tb.setValueAt(i, i - 1, 0);

                    tb.setValueAt(rs.getString("HOSTEL"), i - 1, 1);

                    tb.setValueAt(rs.getString("ROOMNO"), i - 1, 2);

                    tb.setValueAt(rs.getString("FNAME"), i - 1, 3);

                    tb.setValueAt(rs.getString("YEAR"), i - 1, 4);

                    tb.setValueAt(rs.getString("MONTH"), i - 1, 5);

                    tb.setValueAt(rs.getString("DATE"), i - 1, 6);

                    tb.setValueAt(rs.getString("EXPECTED"), i - 1, 7);

                    tb.setValueAt(rs.getString("AMOUNT"), i - 1, 8);

                    tb.setValueAt(Integer.parseInt(rs.getString("EXPECTED"))
                            - Integer.parseInt(rs.getString("AMOUNT")), i - 1, 9);

                    i++;

                }



            } catch (SQLException err) {

                JOptionPane.showMessageDialog(this, err.getMessage());

            }





        }          // TODO add your handling code here:
    }//GEN-LAST:event_cbmonthdItemStateChanged

    private void cbyeardItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbyeardItemStateChanged
        if (cbyeard.getSelectedIndex() > 0) {

            cbmonthd.setEnabled(true);

            cbmonthd.setSelectedIndex(0);

        } else {

            cbmonthd.setEnabled(false);

            cbmonthd.setSelectedIndex(0);

        }

        DefaultTableModel tb = (DefaultTableModel) tablepay.getModel();

        while (tb.getRowCount() > 0) {

            tb.removeRow(0);

        }

        if (cbhostelroom1.getSelectedIndex() == 0 || cbhostelroom1.getItemCount() == 0) {
        } else {

            String row[] = {};

            int i = 1;

            String sql = "";

            try {

                if (cbyeard.getSelectedIndex() == 0) {

                    if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {

                        sql = "SELECT * FROM PAYMENTV";

                    } else {

                        sql = "SELECT * FROM PAYMENTV WHERE HOSTEL='"
                                + cbhostelroom1.getSelectedItem().toString() + "'";

                    }

                } else {

                    if (cbmonthd.getSelectedIndex() == 0) {

                        if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {

                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "'";

                        } else {

                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "HOSTEL='" + cbhostelroom1.getSelectedItem().toString() + "' && "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "'";

                        }

                    } else {

                        if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {

                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "' && "
                                    + "MONTH='" + cbmonthd.getSelectedItem().toString() + "'";

                        } else {

                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "HOSTEL='" + cbhostelroom1.getSelectedItem().toString() + "' && "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "' &&  "
                                    + "MONTH='" + cbmonthd.getSelectedItem().toString() + "'";

                        }

                    }

                }

                rs = stmt.executeQuery(sql);

                while (rs.next()) {

                    tb.addRow(row);

                    tb.setValueAt(i, i - 1, 0);

                    tb.setValueAt(rs.getString("HOSTEL"), i - 1, 1);

                    tb.setValueAt(rs.getString("ROOMNO"), i - 1, 2);

                    tb.setValueAt(rs.getString("FNAME"), i - 1, 3);

                    tb.setValueAt(rs.getString("YEAR"), i - 1, 4);

                    tb.setValueAt(rs.getString("MONTH"), i - 1, 5);

                    tb.setValueAt(rs.getString("DATE"), i - 1, 6);

                    tb.setValueAt(rs.getString("EXPECTED"), i - 1, 7);

                    tb.setValueAt(rs.getString("AMOUNT"), i - 1, 8);

                    tb.setValueAt(Integer.parseInt(rs.getString("EXPECTED"))
                            - Integer.parseInt(rs.getString("AMOUNT")), i - 1, 9);

                    i++;

                }



            } catch (SQLException err) {

                JOptionPane.showMessageDialog(this, err.getMessage());

            }





        }         // TODO add your handling code here:
    }//GEN-LAST:event_cbyeardItemStateChanged

    private void cbhostelroom1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhostelroom1ItemStateChanged
        if (cbhostelroom1.getSelectedIndex() > 0) {
            cbyeard.setEnabled(true);
            cbyeard.setSelectedIndex(0);
        } else {
            cbyeard.setEnabled(false);
            cbyeard.setSelectedIndex(0);
        }
        DefaultTableModel tb = (DefaultTableModel) tablepay.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        if (cbhostelroom1.getSelectedIndex() == 0 || cbhostelroom1.getItemCount() == 0) {
        } else {
            String row[] = {};
            int i = 1;
            String sql = "";
            try {
                if (cbyeard.getSelectedIndex() == 0) {
                    if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {
                        sql = "SELECT * FROM PAYMENTV";
                    } else {
                        sql = "SELECT * FROM PAYMENTV WHERE HOSTEL='"
                                + cbhostelroom1.getSelectedItem().toString() + "'";
                    }
                } else {
                    if (cbmonthd.getSelectedIndex() == 0) {
                        if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {
                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "'";
                        } else {
                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "HOSTEL='" + cbhostelroom1.getSelectedItem().toString() + "' && "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "'";
                        }
                    } else {
                        if (cbhostelroom1.getSelectedIndex() == cbhostelroom1.getItemCount() - 1) {
                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "' && "
                                    + "MONTH='" + cbmonthd.getSelectedItem().toString() + "'";
                        } else {
                            sql = "SELECT * FROM PAYMENTV WHERE "
                                    + "HOSTEL='" + cbhostelroom1.getSelectedItem().toString() + "' && "
                                    + "YEAR='" + cbyeard.getSelectedItem().toString() + "' &&  "
                                    + "MONTH='" + cbmonthd.getSelectedItem().toString() + "'";
                        }
                    }
                }
                rs = stmt.executeQuery(sql);
                while (rs.next()) {

                    tb.addRow(row);
                    tb.setValueAt(i, i - 1, 0);
                    tb.setValueAt(rs.getString("HOSTEL"), i - 1, 1);
                    tb.setValueAt(rs.getString("ROOMNO"), i - 1, 2);
                    tb.setValueAt(rs.getString("FNAME"), i - 1, 3);
                    tb.setValueAt(rs.getString("YEAR"), i - 1, 4);
                    tb.setValueAt(rs.getString("MONTH"), i - 1, 5);
                    tb.setValueAt(rs.getString("DATE"), i - 1, 6);
                    tb.setValueAt(rs.getString("EXPECTED"), i - 1, 7);
                    tb.setValueAt(rs.getString("AMOUNT"), i - 1, 8);
                    tb.setValueAt(Integer.parseInt(rs.getString("EXPECTED"))
                            - Integer.parseInt(rs.getString("AMOUNT")), i - 1, 9);
                    i++;
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this, err.getMessage());
            }
        }
        DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbrumno.getModel();
        tb1.removeAllElements();
        tb1.addElement("SELECT ROOM");
        cbrumno.setSelectedIndex(0);
        try {
            String sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostel.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb1.addElement(rs.getString("ROOMNO"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this, "SSS" + err.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_cbhostelroom1ItemStateChanged

    private void btnaddroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddroomActionPerformed
        if (cbhostelroom.getSelectedIndex() == 0 || cbhostelroom.getItemCount() == 0) {
            JOptionPane.showMessageDialog(btnaddroom, "Select Valid Hostel Value");
        } else {
            jaddroom.pack();
            PopulateRooms();
            jaddroom.setAlwaysOnTop(true);
            txtroomname.setText("");
            txtrent.setText("");
            cbstatus.setSelectedIndex(0);
            jaddroom.setVisible(true);
            jaddroom.setLocation(80, 50);
            //jaddroom.setLocationRelativeTo(btnaddroom);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnaddroomActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DefaultTableModel tb = (DefaultTableModel) tableregister.getModel();
        String row[] = {};

        try {
            String sql = "SELECT * FROM ROOM";
            rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("HOSTEL", cbhostelroom.getSelectedItem().toString());
            rs.updateString("ROOMNO", txtroomname.getText());
            rs.updateString("CATEGORY", cbcategory.getSelectedItem().toString());
            rs.updateString("INCLUDED", txtincluded.getText());
            rs.updateString("RENT", txtrent.getText());
            rs.updateString("WATER", txtwater.getText());
            rs.updateString("ELECTRICITY", txtelectric.getText());
            rs.updateString("DURATION", cbduration.getSelectedItem().toString());
            rs.updateString("CONDITION", cbcontition.getSelectedItem().toString());
            rs.updateString("STATUS", cbstatus.getSelectedItem().toString());
            rs.insertRow();

            tb.addRow(row);
            tb.setValueAt(tb.getRowCount(), tb.getRowCount() - 1, 0);
            tb.setValueAt(txtroomname.getText(), tb.getRowCount() - 1, 1);
            tb.setValueAt(cbcategory.getSelectedItem().toString(), tb.getRowCount() - 1, 2);
            tb.setValueAt(txtincluded.getText(), tb.getRowCount() - 1, 3);
            tb.setValueAt(txtrent.getText(), tb.getRowCount() - 1, 4);
            tb.setValueAt(txtwater.getText(), tb.getRowCount() - 1, 5);
            tb.setValueAt(txtelectric.getText(), tb.getRowCount() - 1, 6);
            tb.setValueAt(cbduration.getSelectedItem().toString(), tb.getRowCount() - 1, 7);
            tb.setValueAt(cbcontition.getSelectedItem().toString(), tb.getRowCount() - 1, 8);
            tb.setValueAt(cbstatus.getSelectedItem().toString(), tb.getRowCount() - 1, 9);
            //  JOptionPane.showMessageDialog(this.rootPane, "Payment Made");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this.rootPane, "Registration Error\n" + err.getMessage());
        }
        if (chapply.isSelected()) {
            txtroomname.setText("");
        } else {
            this.RoomClear();
        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        this.RoomClear();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void tableregisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableregisterMouseClicked
        txtroomname.setText(tableregister.getValueAt(tableregister.getSelectedRow(), 1).toString());
        cbcategory.setSelectedItem(tableregister.getValueAt(tableregister.getSelectedRow(), 2).toString());
        txtincluded.setText(tableregister.getValueAt(tableregister.getSelectedRow(), 3).toString());
        txtrent.setText(tableregister.getValueAt(tableregister.getSelectedRow(), 4).toString());
        txtwater.setText(tableregister.getValueAt(tableregister.getSelectedRow(), 5).toString());
        txtelectric.setText(tableregister.getValueAt(tableregister.getSelectedRow(), 6).toString());
        cbduration.setSelectedItem(tableregister.getValueAt(tableregister.getSelectedRow(), 7).toString());
        cbcontition.setSelectedItem(tableregister.getValueAt(tableregister.getSelectedRow(), 8).toString());
        cbstatus.setSelectedItem(tableregister.getValueAt(tableregister.getSelectedRow(), 9).toString());

        // TODO add your handling code here:
    }//GEN-LAST:event_tableregisterMouseClicked

    private void cbhostelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhostelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbhostelActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.Clear();
        this.Start();// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        this.Clear();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        DefaultTableModel tb = (DefaultTableModel) tableone.getModel();
        while (tableone.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        try {
            String sql = "SELECT * FROM CLIENTV WHERE FNAME LIKE '%" + txtsearch.getText() + "%' ||"
                    + " IDNO LIKE '%" + txtsearch.getText() + "%'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(tableone.getRowCount(), tableone.getRowCount() - 1, 0);
                tb.setValueAt(rs.getString("FNAME"), tableone.getRowCount() - 1, 1);
                tb.setValueAt(rs.getString("IDNO"), tableone.getRowCount() - 1, 2);
                tb.setValueAt(rs.getString("GENDER"), tableone.getRowCount() - 1, 3);
                tb.setValueAt(rs.getString("PHONENO"), tableone.getRowCount() - 1, 4);
                tb.setValueAt(rs.getString("HOSTEL"), tableone.getRowCount() - 1, 5);
                tb.setValueAt(rs.getString("ROOMNO"), tableone.getRowCount() - 1, 6);
                tb.setValueAt(rs.getString("DATEE"), tableone.getRowCount() - 1, 7);
                tb.setValueAt(rs.getString("DATEEX"), tableone.getRowCount() - 1, 8);
                tb.setValueAt(rs.getString("ISSUED"), tableone.getRowCount() - 1, 9);
            }
        } catch (Exception err) {
            //System.out.println(err.getMessage());
        }             // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchKeyReleased

    private void tableoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableoneMouseClicked
        idno = "";
        // this.Clear();
        if (cbsbyname.getItemCount() > 0) {
            try {
                String sql = "SELECT * FROM STAFF WHERE IDNO="
                        + "'" + tableone.getValueAt(tableone.getSelectedRow(), 2).toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                String name = tableone.getValueAt(tableone.getSelectedRow(), 1).toString();
                String fname[] = name.split("  ");
                txtlname.setText((fname[1]));
                txtfname.setText((fname[0]));
                txtidno.setText(rs.getString("IDNO"));
                txtjob.setText(rs.getString("JOB"));
                txtinst.setText(rs.getString("INST"));
                txtphoneno.setText(rs.getString("PHONENO"));
                txtfriend.setText(rs.getString("FRIENDP"));
                cbgender.setSelectedItem(rs.getString("GENDER"));
                idno = rs.getString("IDNO");
                // System.out.println(idno);

                sql = "SELECT * FROM CLIENTV WHERE FNAME="
                        + "'" + cbsbyname.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                txtrate.setText(rs.getString("RATE"));
                txtdatee.setDate(rs.getDate("DATEE"));
                txtdateex.setDate(rs.getDate("DATEEX"));
                txtassetp.setText(rs.getString("ASSET"));
                txtcaret.setText(rs.getString("CARET"));
                txtphonenoc.setText(rs.getString("CPHONENO"));
                lhostel.setText(rs.getString("HOSTEL"));
                lroomno.setText(rs.getString("ROOM"));
                hostel = rs.getString("HOSTEL");
                roomno = rs.getString("ROOM");
            } catch (ArrayIndexOutOfBoundsException err) {
                txtrate.setText("");
                //JOptionPane.showMessageDialog(this, err.getMessage());
                hostel = "";
                roomno = "";
            } catch (NullPointerException err) {
                // txtrate.setText("");
                // JOptionPane.showMessageDialog(this, err.getMessage());
                hostel = "";
                roomno = "";
            } catch (SQLException err) {
                // txtrate.setText("");
                // JOptionPane.showMessageDialog(this, err.getMessage());
                hostel = "";
                roomno = "";
            }
            if (cbsbyid.getItemCount() > 0) {
                cbsbyid.setSelectedIndex(0);
            }
        }          // TODO add your handling code here:
    }//GEN-LAST:event_tableoneMouseClicked

    private void txtsearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearch1KeyReleased
        DefaultTableModel tb = (DefaultTableModel) tablesearch.getModel();
        while (tablesearch.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        try {
            String sql = "SELECT * FROM CLIENTV WHERE FNAME LIKE '%" + txtsearch1.getText() + "%' || "
                    + "IDNO LIKE '%" + txtsearch1.getText() + "%'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(tablesearch.getRowCount(), tablesearch.getRowCount() - 1, 0);
                tb.setValueAt(rs.getString("FNAME"), tablesearch.getRowCount() - 1, 1);
                tb.setValueAt(rs.getString("IDNO"), tablesearch.getRowCount() - 1, 2);
                tb.setValueAt(rs.getString("HOSTEL"), tablesearch.getRowCount() - 1, 3);
                tb.setValueAt(rs.getString("ROOMNO"), tablesearch.getRowCount() - 1, 4);
            }
            int i = 0;
            while (i < tablesearch.getRowCount()) {
                double tot = 0.0, tot2 = 0.0;
                try {
                    sql = "SELECT * FROM EXPECTED WHERE IDNO='" + tablesearch.getValueAt(i, 2) + "' AND "
                            + "HOSTEL='" + tablesearch.getValueAt(i, 3) + "' AND ROOMNO='" + tablesearch.getValueAt(i, 4) + "'";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tot = tot + Double.parseDouble(rs.getString("RENT")) + Double.parseDouble(rs.getString("WATER"))
                                + Double.parseDouble(rs.getString("ELECTRICITY")) + Double.parseDouble(rs.getString("OTHERS"));
                    }
                } catch (Exception err) {
                    tot = 0.0;
                    JOptionPane.showMessageDialog(this, err.getMessage());
                }
                tablesearch.setValueAt(tot, i, 5);
                try {
                    sql = "SELECT * FROM PAYMENT WHERE IDNO='" + tablesearch.getValueAt(i, 2) + "' AND "
                            + "HOSTEL='" + tablesearch.getValueAt(i, 3) + "' AND ROOMNO='" + tablesearch.getValueAt(i, 4) + "'";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tot2 = tot2 + Double.parseDouble(rs.getString("AMOUNT"));
                    }
                } catch (Exception err) {
                    tot2 = 0.0;
                    JOptionPane.showMessageDialog(this, err.getMessage());
                }
                tablesearch.setValueAt(tot2, i, 6);
                tablesearch.setValueAt(tot2 - tot, i, 7);
                i++;
            }
        } catch (Exception err) {
            //System.out.println(err.getMessage());
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtsearch1KeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        payments.pack();
        payments.setLocation(80, 50);
        payments.setAlwaysOnTop(true);
        payments.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tablesearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesearchMouseClicked
        try {
            String sql = "SELECT * FROM ROOMSTATS WHERE HOSTEL='" + tablesearch.getValueAt(tablesearch.getSelectedRow(), 3) + "' AND "
                    + "ROOMNO1='" + tablesearch.getValueAt(tablesearch.getSelectedRow(), 4) + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            txtrentexpected.setText(rs.getString("RENT"));
            txtwaterbill.setText(rs.getString("WATER"));
            txtelectbill.setText(rs.getString("ELEC"));
            txtotherbills.setText(rs.getString("OTHERS"));
        } catch (Exception err) {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tablesearchMouseClicked

    private void cbclientlevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbclientlevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbclientlevelActionPerformed

    private void cbhostelroom2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhostelroom2ItemStateChanged
        if (cbhostelroom2.getItemCount() > 0) {
            DefaultComboBoxModel tb11 = (DefaultComboBoxModel) cbroomnooccupation.getModel();
            tb11.removeAllElements();
            tb11.addElement("SELECT ROOM");
            cbroomnooccupation.setSelectedIndex(0);
            try {
                String sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb11.addElement(rs.getString("ROOMNO"));
                }
            } catch (SQLException err) {
                //JOptionPane.showMessageDialog(this, "SSS" + err.getMessage());
            }
            this.OccupationTimes();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbhostelroom2ItemStateChanged

    private void txtsearchbynameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchbynameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchbynameActionPerformed

    private void cbhostelroom3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhostelroom3ItemStateChanged

        DefaultTableModel tb = (DefaultTableModel) tablerefund.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        if (cbhostelroom3.getSelectedIndex() == 0 || cbhostelroom3.getItemCount() == 0) {
        } else {
            String row[] = {};
            int i = 1;
            String sql = "";
            try {
                sql = "SELECT * FROM HOSTELV WHERE HOSTEL='"
                        + cbhostelroom3.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb.addRow(row);
                    tb.setValueAt(tablerefund.getRowCount(), tablerefund.getRowCount() - 1, 0);
                    tb.setValueAt(rs.getString("HOSTEL"), tablerefund.getRowCount() - 1, 1);
                    tb.setValueAt(rs.getString("ROOMNO"), tablerefund.getRowCount() - 1, 2);
                    tb.setValueAt(rs.getString("FNAME"), tablerefund.getRowCount() - 1, 3);
                    tb.setValueAt(rs.getString("IDNO"), tablerefund.getRowCount() - 1, 4);
                    tb.setValueAt(rs.getString("DATEE"), tablerefund.getRowCount() - 1, 5);
                    i++;
                }
            } catch (SQLException err) {
                // JOptionPane.showMessageDialog(this, err.getMessage());
            }
            int n = 0;
            int days = 0;
            while (n < tablerefund.getRowCount()) {
                try {
                    sql = "SELECT * FROM HOSTEL WHERE HOSTEL='"
                            + tablerefund.getValueAt(n, 1).toString() + "' AND "
                            + "ROOMNO='" + tablerefund.getValueAt(n, 2).toString() + "' AND "
                            + "IDNO='" + tablerefund.getValueAt(n, 4).toString() + "'";
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    tb.setValueAt(rs.getString("DATEOUT"), n, 6);
                    days = Days.daysBetween(new LocalDate(rs.getDate("DATEE")), new LocalDate(rs.getDate("DATEOUT"))).getDays();
                    //tb.setValueAt(Days.daysBetween(new LocalDate(rs.getDate("DATEE")), new LocalDate(rs.getDate("DATEOUT"))).getDays(),
                    //n, 7);
                    System.out.println(days);
                    i++;
                } catch (Exception err) {
                    tb.setValueAt("Sign Out First", n, 6);
                    // System.out.println(err.getMessage());
                }
                double tot = 0;
                try {
                    sql = "SELECT * FROM PAYMENT WHERE HOSTEL='"
                            + tablerefund.getValueAt(n, 1).toString() + "' AND "
                            + "ROOMNO='" + tablerefund.getValueAt(n, 2).toString() + "' AND "
                            + "IDNO='" + tablerefund.getValueAt(n, 4).toString() + "'";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tot = tot + Double.parseDouble(rs.getString("AMOUNT"));
                    }
                } catch (SQLException err) {
                }
                tb.setValueAt(tot, n, 8);
                tot = 0;
                try {
                    sql = "SELECT * FROM EXPECTED WHERE HOSTEL='"
                            + tablerefund.getValueAt(n, 1).toString() + "' AND "
                            + "ROOMNO='" + tablerefund.getValueAt(n, 2).toString() + "' AND "
                            + "IDNO='" + tablerefund.getValueAt(n, 4).toString() + "'";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tot = tot + Double.parseDouble(rs.getString("RENT")) + Double.parseDouble(rs.getString("WATER"))
                                + Double.parseDouble(rs.getString("ELECTRICITY")) + Double.parseDouble(rs.getString("OTHERS"));
                    }
                } catch (SQLException err) {
                }
                double amountowed = 0.0;
                if ((tablerefund.getValueAt(n, 6).toString().equals("Sign Out First"))) {
                } else {
                    try {
                        sql = "SELECT * FROM HOSTEL WHERE HOSTEL='" + tablerefund.getValueAt(n, 1).toString() + "' AND"
                                + " ROOMNO='" + tablerefund.getValueAt(n, 2).toString() + "' AND "
                                + "IDNO='" + tablerefund.getValueAt(n, 4).toString() + "'";
                        rs = stmt.executeQuery(sql);
                        rs.next();
                        double rate = Double.parseDouble(rs.getString("RATE"));
                        //double perday=;
                        amountowed = (rate / 30) * days;
                    } catch (Exception err) {
                        System.out.println(err.getMessage());
                    }
                    tb.setValueAt(amountowed, n, 7);
                    tb.setValueAt(Double.parseDouble(tablerefund.getValueAt(n, 8).toString()) - amountowed, n, 9);
                    amountowed = 0.0;
                }
                n++;
            }

        }         // TODO add your handling code here:
    }//GEN-LAST:event_cbhostelroom3ItemStateChanged

    private void txtsearchbyname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchbyname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchbyname2ActionPerformed

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        try {
            FontBuilder boldFont = stl.fontArialBold().setFontSize(7);
            TextColumnBuilder<Integer> itemColumn = col.column(" ", "sno", type.integerType()).setWidth(20);
            TextColumnBuilder<String> name = col.column("Apartment Name", "name", type.stringType()).setWidth(190);
            TextColumnBuilder<String> loc = col.column("Location", "loc", type.stringType()).setWidth(190);
            TextColumnBuilder<String> owner = col.column("Owner", "owner", type.stringType()).setWidth(190);
            TextColumnBuilder<String> pno = col.column("Phone NO.", "pno", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT);
            TextColumnBuilder<String> roomno1 = col.column("Room NO.", "roomno", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT);
            try {
                report()
                        .setTemplate(Templates.reportTemplate)
                        .columns(itemColumn, name, loc, owner, pno, roomno1)
                        .title(Templates.createTitleComponent("Registered Apartment Report"))
                        .pageFooter(Templates.footerComponent)
                        .setDataSource(ApartmentsDatasource())
                        .title(cmp.text("Apartment Manager"
                        + "").setStyle(Templates.bold12CenteredStyle))
                        .show(false);
            } catch (DRException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        } catch (NullPointerException err) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        try {
            FontBuilder boldFont = stl.fontArialBold().setFontSize(7);
            TextColumnBuilder<Integer> itemColumn = col.column(" ", "sno", type.integerType()).setWidth(20);
            TextColumnBuilder<String> name = col.column("Client Name", "name", type.stringType()).setWidth(190);
            TextColumnBuilder<String> reg = col.column("IDNO/RegNO.", "reg", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT);;
            TextColumnBuilder<String> g = col.column("Gender", "g", type.stringType());
            TextColumnBuilder<String> pno = col.column("Phone NO.", "pno", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT);;
            TextColumnBuilder<String> job = col.column("Job", "job", type.stringType()).setWidth(190);
            try {
                report()
                        .setTemplate(Templates.reportTemplate)
                        .columns(itemColumn, name, reg, g, pno, job)
                        .title(Templates.createTitleComponent("Registered Clients Report"))
                        .pageFooter(Templates.footerComponent)
                        .setDataSource(ClientsDatasource())
                        .title(cmp.text("Apartment Manager"
                        + "").setStyle(Templates.bold12CenteredStyle))
                        .show(false);
            } catch (DRException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        } catch (NullPointerException err) {
        }          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        try {
            FontBuilder boldFont = stl.fontArialBold().setFontSize(7);
            TextColumnBuilder<Integer> itemColumn = col.column(" ", "sno", type.integerType()).setWidth(20);
            TextColumnBuilder<String> name = col.column("Hostel", "name", type.stringType()).setWidth(190);
            TextColumnBuilder<String> room = col.column("RoomNo.", "room", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT);
            TextColumnBuilder<String> fname = col.column("Client Name", "fname", type.stringType()).setWidth(190);
            TextColumnBuilder<String> id = col.column("IDNO", "id", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT);
            TextColumnBuilder<String> rent = col.column("RENT", "rent", type.stringType());
            TextColumnBuilder<String> datein = col.column("DateIn", "datein", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.CENTER);
            TextColumnBuilder<String> dateout = col.column("DateOut", "dateout", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.CENTER);
            try {
                report()
                        .setTemplate(Templates.reportTemplate)
                        .columns(itemColumn, name, room, fname, id, rent, datein, dateout)
                        .title(Templates.createTitleComponent("Registered Clients Report"))
                        .pageFooter(Templates.footerComponent)
                        .setDataSource(RooAllocationmDatasource())
                        .title(cmp.text("Apartment Manager"
                        + "").setStyle(Templates.bold12CenteredStyle))
                        .show(false);
            } catch (DRException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        } catch (NullPointerException err) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void cbclientlevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbclientlevelItemStateChanged
//        if (Integer.parseInt(txtnoocupants.getText()) == 0) {
//            cbclientlevel.setSelectedIndex(0);
//        } else {
//            cbclientlevel.setSelectedIndex(1);
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbclientlevelItemStateChanged

    private void cbhostelroom4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhostelroom4ItemStateChanged
        DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbproomno1.getModel();

        String row[] = {};
        if (cbproomno1.getItemCount() > 0) {
            tb1.removeAllElements();
        }
        tb1.addElement("SELECT");
        cbproomno1.setSelectedIndex(0);
        try {
            String sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom4.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb1.addElement(rs.getString("ROOMNO"));
            }
        } catch (SQLException err) {
            // JOptionPane.showMessageDialog(this,err.getMessage());
        }
        this.RoomStats();
        DefaultTableModel tb = (DefaultTableModel) tablestatsview.getModel();
        while (tablestatsview.getRowCount() > 0) {
            tb.removeRow(0);
        }
        int y = 0;
        while (y < tablestats.getRowCount()) {
            try {
                String sql = "SELECT * FROM ROOMSTATSV WHERE HOSTEL='" + cbhostelroom4.getSelectedItem().toString() + "' && "
                        + "ROOMNO='" + tablestats.getValueAt(y, 2) + "' && STATUS='IN'   ";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb.addRow(row);
                    tb.setValueAt(tablestatsview.getRowCount(), tablestatsview.getRowCount() - 1, 0);
                    tb.setValueAt(rs.getString("FNAME"), tablestatsview.getRowCount() - 1, 1);
                    tb.setValueAt(rs.getString("ROOMNO"), tablestatsview.getRowCount() - 1, 2);
                    tb.setValueAt(rs.getString("RENT"), tablestatsview.getRowCount() - 1, 3);
                    tb.setValueAt(rs.getString("ELEC"), tablestatsview.getRowCount() - 1, 4);
                    tb.setValueAt(rs.getString("WATER"), tablestatsview.getRowCount() - 1, 5);
                    tb.setValueAt(rs.getString("OTHERS"), tablestatsview.getRowCount() - 1, 6);


                }
            } catch (SQLException err) {
                // JOptionPane.showMessageDialog(this,err.getMessage());
            }
            y++;
        }
    }//GEN-LAST:event_cbhostelroom4ItemStateChanged

    private void cbyeard1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbyeard1ItemStateChanged
        this.RoomStats();        // TODO add your handling code here:
    }//GEN-LAST:event_cbyeard1ItemStateChanged

    private void cbmonthd1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbmonthd1ItemStateChanged
        this.RoomStats();

        ////        if (cbhostelroom4.getSelectedIndex() > 0) {
////            cbyeard1.setEnabled(true);
////            cbyeard1.setSelectedIndex(0);
////        } else {
////            cbyeard1.setEnabled(false);
////            cbyeard1.setSelectedIndex(0);
////        }
//        DefaultTableModel tb = (DefaultTableModel) tablestats.getModel();
//        while (tb.getRowCount() > 0) {
//            tb.removeRow(0);
//        }
//        if (cbhostelroom4.getSelectedIndex() == 0 || cbhostelroom4.getItemCount() == 0) {
//        } else {
//            String row[] = {};
//            int i = 1;
//            String sql = "";
//            try {
//                sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom4.getSelectedItem().toString() + "'";
//                rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    tb.addRow(row);
//                    tb.setValueAt(i, i - 1, 0);
//                    tb.setValueAt(rs.getString("HOSTEL"), i - 1, 1);
//                    tb.setValueAt(rs.getString("ROOMNO"), i - 1, 2);
//                    tb.setValueAt(0.0, i - 1, 3);
//                    tb.setValueAt(0.0, i - 1, 4);
//                    tb.setValueAt(0.0, i - 1, 5);
//                    tb.setValueAt(0.0, i - 1, 6);
//                    tb.setValueAt("", i - 1, 7);
//                    i++;
//                }
//                if (cbyeard1.getSelectedIndex() == 0) {
//                } else {
//                    if (cbmonthd1.getSelectedIndex() == 0) {
//                    } else {
//                        if (cbhostelroom4.getSelectedIndex() == cbhostelroom4.getItemCount() - 1) {
////                            
//                        } else {
//                            i = 0;
//                            while (i < tablestats.getRowCount()) {
//                                sql = "SELECT * FROM ROOMSTATS WHERE "
//                                        + "HOSTEL='" + cbhostelroom1.getSelectedItem().toString() + "' && "
//                                        + "YEAR='" + cbyeard1.getSelectedItem().toString() + "' &&  "
//                                        + "MONTH='" + cbmonthd1.getSelectedItem().toString() + "'";
//                                rs = stmt.executeQuery(sql);
//                                rs.next();
//                                tb.setValueAt(i, i - 1, 0);
//                                tb.setValueAt(rs.getString("RENT"), i, 3);
//                                tb.setValueAt(rs.getString("WATER"), i, 4);
//                                tb.setValueAt(rs.getString("ELEC"), i, 5);
//                                tb.setValueAt(rs.getString("OTHERS"), i, 6);
//                                i++;
//                            }
//                        }
//                    }
//                }
//                i++;
//            } catch (SQLException err) {
//                JOptionPane.showMessageDialog(this, err.getMessage());
//            }
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbmonthd1ItemStateChanged

    private void cbhostelroom4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhostelroom4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbhostelroom4ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String date = datedue.getDate().toString();
            if (cbhostelroom4.getSelectedIndex() == 0 || cbyeard1.getSelectedIndex() == 0
                    || cbmonthd1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Select Proper Values as Required");
            } else {
                if (chall.isSelected() == false && tablestats.getSelectedRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Select a Row to Apply Values to");
                } else {
                    if (chall.isSelected()) {
                        int t = 0;
                        while (t < tablestats.getRowCount()) {
                            tablestats.setValueAt(txtrentp.getText(), t, 3);
                            tablestats.setValueAt(txtelecp.getText(), t, 4);
                            tablestats.setValueAt(txtwaterp.getText(), t, 5);
                            tablestats.setValueAt(txtothersp.getText(), t, 6);
                            tablestats.setValueAt(dateformat.format(datedue.getDate()), t, 7);
                            t++;
                        }
                    } else {
                        tablestats.setValueAt(txtrentp.getText(), tablestats.getSelectedRow(), 3);
                        tablestats.setValueAt(txtelecp.getText(), tablestats.getSelectedRow(), 4);
                        tablestats.setValueAt(txtwaterp.getText(), tablestats.getSelectedRow(), 5);
                        tablestats.setValueAt(txtothersp.getText(), tablestats.getSelectedRow(), 6);
                        tablestats.setValueAt(dateformat.format(datedue.getDate()), tablestats.getSelectedRow(), 7);
                    }
                    int i = 0;
                    while (i < tablestats.getRowCount()) {
                        try {
                            String sql = "SELECT * FROM ROOMSTATS";
                            rs = stmt.executeQuery(sql);
                            rs.moveToInsertRow();
                            rs.updateString("HOSTEL", tablestats.getValueAt(i, 1).toString());
                            rs.updateString("ROOMNO1", tablestats.getValueAt(i, 2).toString());
                            rs.updateString("YEAR", cbyeard1.getSelectedItem().toString());
                            rs.updateString("MONTH", cbmonthd1.getSelectedItem().toString());
                            rs.updateString("RENT", tablestats.getValueAt(i, 3).toString());
                            rs.updateString("WATER", tablestats.getValueAt(i, 4).toString());
                            rs.updateString("ELEC", tablestats.getValueAt(i, 5).toString());
                            rs.updateString("OTHERS", tablestats.getValueAt(i, 6).toString());
                            rs.updateString("EXPECTED", dateformat.format(datedue.getDate()));
                            rs.insertRow();

                            // sql = "SELECT * FROM HOSTEL"

                            JOptionPane.showMessageDialog(this.rootPane, "Value Registered");
                        } catch (SQLException err) {
                            try {
                                String sql = "SELECT * FROM ROOMSTATS WHERE HOSTEL='" + tablestats.getValueAt(i, 1).toString() + "' AND "
                                        + "ROOMNO='" + tablestats.getValueAt(i, 2).toString() + "' AND "
                                        + "YEAR='" + cbyeard1.getSelectedItem().toString() + "' AND "
                                        + "MONTH='" + cbmonthd1.getSelectedItem().toString() + "'";
                                rs = stmt.executeQuery(sql);
                                rs.next();
                                rs.updateString("HOSTEL", tablestats.getValueAt(i, 1).toString());
                                rs.updateString("ROOMNO1", tablestats.getValueAt(i, 2).toString());
                                rs.updateString("YEAR", cbyeard1.getSelectedItem().toString());
                                rs.updateString("MONTH", cbmonthd1.getSelectedItem().toString());
                                rs.updateString("RENT", tablestats.getValueAt(i, 3).toString());
                                rs.updateString("WATER", tablestats.getValueAt(i, 4).toString());
                                rs.updateString("ELEC", tablestats.getValueAt(i, 5).toString());
                                rs.updateString("OTHERS", tablestats.getValueAt(i, 6).toString());
                                rs.updateString("EXPECTED", dateformat.format(datedue.getDate()));
                                rs.updateRow();
                            } catch (SQLException er) {
                            }
                        }
                        i++;
                    }
                    if (chkeep.isSelected()) {
                    } else {
                        txtrentp.setText("0.0");
                        txtwaterp.setText("0.0");
                        txtelecp.setText("0.0");
                        txtothersp.setText("0.0");
                    }
                }
            }
        } catch (NullPointerException err) {
            JOptionPane.showMessageDialog(this, "Enter the Due Date of Payment");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void txtelecpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelecpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtelecpActionPerformed

    private void cbproomno1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbproomno1ItemStateChanged
        this.RoomStats();

//        DefaultTableModel tb = (DefaultTableModel) tablestats.getModel();
//        while (tb.getRowCount() > 0) {
//            tb.removeRow(0);
//        }
//        if (cbhostelroom4.getSelectedIndex() == 0 || cbhostelroom4.getItemCount() == 0) {
//        } else {
//            String row[] = {};
//            int i = 1;
//            String sql = "";
//            try {
//                if (cbpaymentroomno1.getSelectedIndex() == 0) {
//                    sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom4.getSelectedItem().toString() + "' ";
//                } else {
//                    sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom4.getSelectedItem().toString() + "' "
//                            + "AND ROOMNO='" + cbpaymentroomno1.getSelectedItem().toString() + "'";
//                }
//                rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    tb.addRow(row);
//                    tb.setValueAt(i, i - 1, 0);
//                    tb.setValueAt(rs.getString("HOSTEL"), i - 1, 1);
//                    tb.setValueAt(rs.getString("ROOMNO"), i - 1, 2);
//                    tb.setValueAt(0.0, i - 1, 3);
//                    tb.setValueAt(0.0, i - 1, 4);
//                    tb.setValueAt(0.0, i - 1, 5);
//                    tb.setValueAt(0.0, i - 1, 6);
//                    tb.setValueAt("", i - 1, 7);
//                    i++;
//                }
//                if (cbyeard1.getSelectedIndex() == 0) {
//                } else {
//                    if (cbmonthd1.getSelectedIndex() == 0) {
//                    } else {
//                        if (cbhostelroom4.getSelectedIndex() == cbhostelroom4.getItemCount() - 1) {
////                            
//                        } else {
//                            i = 0;
//                            while (i < tablestats.getRowCount()) {
//                                sql = "SELECT * FROM ROOMSTATS WHERE "
//                                        + "HOSTEL='" + cbhostelroom1.getSelectedItem().toString() + "' && "
//                                        + "ROOMNO='" + cbpaymentroomno1.getSelectedItem().toString() + "'"
//                                        + "YEAR='" + cbyeard1.getSelectedItem().toString() + "' &&  "
//                                        + "MONTH='" + cbmonthd1.getSelectedItem().toString() + "'";
//                                rs = stmt.executeQuery(sql);
//                                rs.next();
//                                tb.setValueAt(i, i - 1, 0);
//                                tb.setValueAt(rs.getString("RENT"), i, 3);
//                                tb.setValueAt(rs.getString("WATER"), i, 4);
//                                tb.setValueAt(rs.getString("ELEC"), i, 5);
//                                tb.setValueAt(rs.getString("OTHERS"), i, 6);
//                                i++;
//                            }
//                        }
//                    }
//                }
//                i++;
//            } catch (Exception err) {
//                //JOptionPane.showMessageDialog(this, err.getMessage());
//            }
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbproomno1ItemStateChanged

    private void tablestatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablestatsMouseClicked
        try {
            String sql = "SELECT * FROM ROOM WHERE "
                    + "HOSTEL='" + tablestats.getValueAt(tablestats.getSelectedRow(), 1).toString() + "' && "
                    + "ROOMNO='" + tablestats.getValueAt(tablestats.getSelectedRow(), 2).toString() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            txtrentp.setText(rs.getString("RENT"));
            txtrentp.setText(rs.getString("WATER"));
            txtrentp.setText(rs.getString("ELECTRICITY"));
            txtrentp.setText("0.0");
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }       // TODO add your handling code here:
    }//GEN-LAST:event_tablestatsMouseClicked

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
        try {
            String sql = "SELECT * FROM EXPENSE";
            rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("EXPENSECATEG", cbcategexpenses.getSelectedItem().toString());
            rs.updateString("AMOUNT", txtamountexpense.getText());
            rs.updateString("STAFF", cbstafflist.getSelectedItem().toString());
            rs.updateString("DATEMADE", dateformat.format(dateexpense.getDate()));
            rs.updateString("DATEREG", dateformat.format(startDate));
            rs.updateString("DESCR", txtdescexpenses.getText());
            rs.updateString("APPROVED", "NO");
            //rs.updateString("DATEAPP", dateformat.format(txtdateex.getDate()));
            rs.insertRow();
            cbcategexpenses.setSelectedIndex(0);
            txtamountexpense.setText("0.0");
            cbstafflist.setSelectedIndex(0);
            dateexpense.setDate(null);
            txtdescexpenses.setText("");

        } catch (NumberFormatException | SQLException err) {
            //  JOptionPane.showMessageDialog(this.rootPane, "JJJ" + err.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        datechooser.setDate(null);
        DefaultTableModel tb = (DefaultTableModel) tableexpense.getModel();
        while (tableexpense.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        try {
            String sql = "SELECT * FROM EXPENSE WHERE APPROVED='NO'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(rs.getString("NUM"), tableexpense.getRowCount() - 1, 0);
                tb.setValueAt(rs.getString("DATEMADE"), tableexpense.getRowCount() - 1, 1);
                tb.setValueAt(rs.getString("EXPENSECATEG"), tableexpense.getRowCount() - 1, 2);
                tb.setValueAt(rs.getString("STAFF"), tableexpense.getRowCount() - 1, 3);
                tb.setValueAt(rs.getString("DESCR"), tableexpense.getRowCount() - 1, 4);
                tb.setValueAt(rs.getString("AMOUNT"), tableexpense.getRowCount() - 1, 5);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_jButton31ActionPerformed

    private void datechooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datechooserPropertyChange
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            DefaultTableModel tb = (DefaultTableModel) tableexpense.getModel();
            while (tableexpense.getRowCount() > 0) {
                tb.removeRow(0);
            }
            String row[] = {};
            try {
                String sql = "SELECT * FROM EXPENSE WHERE APPROVED='NO' && "
                        + "DATEMADE='" + dateformat.format(datechooser.getDate()) + "'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb.addRow(row);
                    tb.setValueAt(rs.getString("NUM"), tableexpense.getRowCount() - 1, 0);
                    tb.setValueAt(rs.getString("DATEMADE"), tableexpense.getRowCount() - 1, 1);
                    tb.setValueAt(rs.getString("EXPENSECATEG"), tableexpense.getRowCount() - 1, 2);
                    tb.setValueAt(rs.getString("STAFF"), tableexpense.getRowCount() - 1, 3);
                    tb.setValueAt(rs.getString("DESCR"), tableexpense.getRowCount() - 1, 4);
                    tb.setValueAt(rs.getString("AMOUNT"), tableexpense.getRowCount() - 1, 5);
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        } catch (Exception err) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_datechooserPropertyChange

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        {
            TextColumnBuilder<String> sno = col.column(" ", "sno", type.stringType()).setWidth(20);
            TextColumnBuilder<String> date = col.column("Date", "date", type.stringType());
            TextColumnBuilder<String> categ = col.column("Expense Category", "categ", type.stringType()).setWidth(150);
            TextColumnBuilder<String> staff = col.column("Staff", "staff", type.stringType()).setWidth(60);;
            TextColumnBuilder<String> descr = col.column("Description", "descr", type.stringType()).setWidth(200);
            TextColumnBuilder<Double> tot = col.column("Amount", "tot", type.doubleType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT);
            //StyleBuilder groupStyle = stl.style().bold();
            {
                try {
                    report()
                            .setTemplate(Templates.reportTemplate)
                            .columns(sno, date, categ, staff, descr, tot)
                            //.groupBy(itemGroup)
                            // .subtotalsAtGroupFooter(itemGroup, sbt.sum(payColumn))
                            .subtotalsAtSummary(sbt.sum(tot))
                            //.title(Templates.createTitleComponent(title))
                            .title(Templates.createTitleComponent(""))
                            .pageFooter(Templates.footerComponent)
                            .setDataSource(createDataSource1())
                            .show(false);
                } catch (DRException e) {
                }
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void btnapproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapproveActionPerformed
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
        DefaultTableModel tb = (DefaultTableModel) tableexpense.getModel();
        try {
            String sql = "SELECT * FROM EXPENSE WHERE NUM='" + tableexpense.getValueAt(tableexpense.getSelectedRow(), 0).toString() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            rs.updateString("APPROVED", "YES");
            rs.updateString("DATEAPP", dateformat.format(startDate));
            rs.updateRow();
            tb.removeRow(tableexpense.getSelectedRow());
            tableexpense.clearSelection();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnapproveActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
        try {
            String sql = "SELECT * FROM EXPENSE WHERE NUM='" + tableexpense.getValueAt(tableexpense.getSelectedRow(), 0).toString() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            rs.updateString("APPROVED", "REV");
            rs.updateString("APPROVED", dateformat.format(startDate));
            rs.updateRow();
        } catch (Exception err) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        dstart.setDate(null);
        dend.setDate(null);
        DefaultTableModel tb = (DefaultTableModel) tableexpense1.getModel();
        while (tableexpense1.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        try {
            String sql = "SELECT * FROM EXPENSE WHERE APPROVED='YES'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(tableexpense1.getRowCount(), tableexpense1.getRowCount() - 1, 0);
                tb.setValueAt(rs.getString("DATEMADE"), tableexpense1.getRowCount() - 1, 1);
                tb.setValueAt(rs.getString("EXPENSECATEG"), tableexpense1.getRowCount() - 1, 2);
                tb.setValueAt(rs.getString("STAFF"), tableexpense1.getRowCount() - 1, 3);
                tb.setValueAt(rs.getString("DESCR"), tableexpense1.getRowCount() - 1, 4);
                tb.setValueAt(rs.getString("DATEAPP"), tableexpense1.getRowCount() - 1, 5);
                tb.setValueAt(rs.getString("AMOUNT"), tableexpense1.getRowCount() - 1, 6);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        {
            TextColumnBuilder<String> sno = col.column(" ", "sno", type.stringType()).setWidth(20);
            TextColumnBuilder<String> date = col.column("Date", "date", type.stringType());
            TextColumnBuilder<String> categ = col.column("Expense Category", "categ", type.stringType()).setWidth(150);
            TextColumnBuilder<String> staff = col.column("Staff", "staff", type.stringType());
            TextColumnBuilder<String> descr = col.column("Description", "descr", type.stringType()).setWidth(200);
            TextColumnBuilder<String> datea = col.column("Date Approved", "datea", type.stringType());
            TextColumnBuilder<Double> tot = col.column("Amount", "tot", type.doubleType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT);
            //StyleBuilder groupStyle = stl.style().bold();
            {
                try {
                    report()
                            .setTemplate(Templates.reportTemplate)
                            .columns(sno, date, categ, staff, descr, datea, tot)
                            //.groupBy(itemGroup)
                            // .subtotalsAtGroupFooter(itemGroup, sbt.sum(payColumn))
                            .subtotalsAtSummary(sbt.sum(tot))
                            //.title(Templates.createTitleComponent(title))
                            .title(Templates.createTitleComponent(""))
                            .pageFooter(Templates.footerComponent)
                            .setDataSource(ExpenseApprovedDataSource())
                            .show(false);
                } catch (DRException e) {
                }
            }
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void cbcategItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbcategItemStateChanged
        dstart.setDate(null);
        dend.setDate(null);
        DefaultTableModel tb = (DefaultTableModel) tableexpense1.getModel();
        while (tableexpense1.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        try {
            String sql = "SELECT * FROM EXPENSE WHERE APPROVED='YES' && "
                    + "EXPENSECATEG='" + cbcateg.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(tableexpense1.getRowCount(), tableexpense1.getRowCount() - 1, 0);
                tb.setValueAt(rs.getString("DATEMADE"), tableexpense1.getRowCount() - 1, 1);
                tb.setValueAt(rs.getString("EXPENSECATEG"), tableexpense1.getRowCount() - 1, 2);
                tb.setValueAt(rs.getString("STAFF"), tableexpense1.getRowCount() - 1, 3);
                tb.setValueAt(rs.getString("DESCR"), tableexpense1.getRowCount() - 1, 4);
                tb.setValueAt(rs.getString("DATEAPP"), tableexpense1.getRowCount() - 1, 5);
                tb.setValueAt(rs.getString("AMOUNT"), tableexpense1.getRowCount() - 1, 6);
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }           // TODO add your handling code here:
    }//GEN-LAST:event_cbcategItemStateChanged

    private void dstartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dstartPropertyChange
        try {
            if (dstart.getDate().after(dend.getDate()) && dend.getDate() != null) {
                JOptionPane.showMessageDialog(this, "Check your Date Value");
            } else {

                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

                DefaultTableModel tb = (DefaultTableModel) tableexpense1.getModel();
                while (tableexpense1.getRowCount() > 0) {
                    tb.removeRow(0);
                }
                String row[] = {};
                String sql = "";
                try {
                    if (dend.getDate() == null) {
                        if (cbcateg.getSelectedIndex() == 0) {
                            sql = "SELECT * FROM EXPENSE WHERE DATEMADE>='" + dateformat.format(dstart.getDate()) + "'";
                        } else {
                            sql = "SELECT * FROM EXPENSE WHERE DATEMADE>='" + dateformat.format(dstart.getDate()) + "' && "
                                    + "EXPENSECATEG='" + cbcateg.getSelectedItem().toString() + "'";
                        }
                    } else {
                        if (cbcateg.getSelectedIndex() == 0) {
                            sql = "SELECT * FROM EXPENSE WHERE DATEMADE>='" + dateformat.format(dstart.getDate()) + "' && "
                                    + "DATEMADE<='" + dateformat.format(dend.getDate()) + "'";
                        } else {
                            sql = "SELECT * FROM EXPENSE WHERE DATEMADE>='" + dateformat.format(dstart.getDate()) + "' && "
                                    + "DATEMADE<='" + dateformat.format(dend.getDate()) + "'&&"
                                    + "EXPENSECATEG='" + cbcateg.getSelectedItem().toString() + "'";
                        }
                    }
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb.addRow(row);
                        tb.setValueAt(tableexpense1.getRowCount(), tableexpense1.getRowCount() - 1, 0);
                        tb.setValueAt(rs.getString("DATEMADE"), tableexpense1.getRowCount() - 1, 1);
                        tb.setValueAt(rs.getString("EXPENSECATEG"), tableexpense1.getRowCount() - 1, 2);
                        tb.setValueAt(rs.getString("STAFF"), tableexpense1.getRowCount() - 1, 3);
                        tb.setValueAt(rs.getString("DESCR"), tableexpense1.getRowCount() - 1, 4);
                        tb.setValueAt(rs.getString("DATEAPP"), tableexpense1.getRowCount() - 1, 5);
                        tb.setValueAt(rs.getString("AMOUNT"), tableexpense1.getRowCount() - 1, 6);
                    }
                } catch (Exception err) {
                    //System.out.println(err.getMessage());
                }
            }
        } catch (Exception err) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_dstartPropertyChange

    private void dendPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dendPropertyChange
        try {
            if (dend.getDate().before(dstart.getDate()) && dstart.getDate() != null) {
                JOptionPane.showMessageDialog(this, "Check your Date Value");
            } else {

                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

                DefaultTableModel tb = (DefaultTableModel) tableexpense1.getModel();
                while (tableexpense1.getRowCount() > 0) {
                    tb.removeRow(0);
                }
                String row[] = {};
                String sql = "";
                try {
                    if (dstart.getDate() == null) {
                        if (cbcateg.getSelectedIndex() == 0) {
                            sql = "SELECT * FROM EXPENSE WHERE DATEMADE<='" + dateformat.format(dend.getDate()) + "'";
                        } else {
                            sql = "SELECT * FROM EXPENSE WHERE DATEMADE<='" + dateformat.format(dend.getDate()) + "' && "
                                    + "EXPENSECATEG='" + cbcateg.getSelectedItem().toString() + "'";
                        }
                    } else {
                        if (cbcateg.getSelectedIndex() == 0) {
                            sql = "SELECT * FROM EXPENSE WHERE DATEMADE>='" + dateformat.format(dstart.getDate()) + "' && "
                                    + "DATEMADE<='" + dateformat.format(dend.getDate()) + "'";
                        } else {
                            sql = "SELECT * FROM EXPENSE WHERE DATEMADE>='" + dateformat.format(dstart.getDate()) + "' && "
                                    + "DATEMADE<='" + dateformat.format(dend.getDate()) + "'&&"
                                    + "EXPENSECATEG='" + cbcateg.getSelectedItem().toString() + "'";
                        }
                    }
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb.addRow(row);
                        tb.setValueAt(tableexpense1.getRowCount(), tableexpense1.getRowCount() - 1, 0);
                        tb.setValueAt(rs.getString("DATEMADE"), tableexpense1.getRowCount() - 1, 1);
                        tb.setValueAt(rs.getString("EXPENSECATEG"), tableexpense1.getRowCount() - 1, 2);
                        tb.setValueAt(rs.getString("STAFF"), tableexpense1.getRowCount() - 1, 3);
                        tb.setValueAt(rs.getString("DESCR"), tableexpense1.getRowCount() - 1, 4);
                        tb.setValueAt(rs.getString("DATEAPP"), tableexpense1.getRowCount() - 1, 5);
                        tb.setValueAt(rs.getString("AMOUNT"), tableexpense1.getRowCount() - 1, 6);
                    }
                } catch (Exception err) {
                    //System.out.println(err.getMessage());
                }
            }
        } catch (Exception err) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_dendPropertyChange

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        Dexpenses.pack();
        Dexpenses.setLocation(80, 50);
        Dexpenses.setAlwaysOnTop(true);
        Dexpenses.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        try {
            String sql = "SELECT * FROM MOREINFO";
            rs = stmt.executeQuery(sql);
            rs.moveToInsertRow();
            rs.updateString("GNAME", txtgurdianname.getText());
            rs.updateString("GPHONENO", txtgphoneno.getText());
            rs.updateString("HOME", txthome.getText());
            rs.updateString("DEPART", txtdepartment.getText());
            rs.updateString("REGNO", txtregno.getText());
            rs.updateString("YEAR", txtinst.getText());
            rs.updateString("REMARKS", txtremarks.getText());
            rs.updateString("IDNO", txtidno.getText());
            rs.insertRow();
            txtgurdianname.setText("");
            txtgphoneno.setText("");
            txthome.setText("");
            txtdepartment.setText("");
            txtinst.setText("");
            txtremarks.setText("");
            txtidno.setText("");

            JOptionPane.showMessageDialog(this.rootPane, "Information Registered");

        } catch (SQLException ex) {
            try {
                String sql = "SELECT * FROM MOREINFO WHERE IDNO='" + txtidno.getText() + "'";
                rs = stmt.executeQuery(sql);
                rs.moveToInsertRow();
                rs.updateString("GNAME", txtgurdianname.getText());
                rs.updateString("GPHONENO", txtgphoneno.getText());
                rs.updateString("HOME", txthome.getText());
                rs.updateString("DEPART", txtdepartment.getText());
                rs.updateString("REGNO", txtregno.getText());
                rs.updateString("YEAR", txtinst.getText());
                rs.updateString("REMARKS", txtremarks.getText());
                rs.updateString("IDNO", txtidno.getText());
                rs.updateRow();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this.rootPane, err.getMessage());
            }
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(this.rootPane, err.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void txtamountexpenseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtamountexpenseKeyTyped
        char c = evt.getKeyChar();
        c = Character.toUpperCase(c);
        if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_DECIMAL) || (c == '.'))) {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountexpenseKeyTyped

    private void txtidnoregKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidnoregKeyReleased
        try {
            String sql = "SELECT * FROM STAFF WHERE IDNO='" + txtidnoreg.getText() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            lnamesignout.setText(rs.getString("FNAME"));
            lerror.setText("");
        } catch (Exception err) {
            lerror.setText("Record not Available");  //JOptionPane.showMessageDialog(Dsignout, err.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtidnoregKeyReleased

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        Dsignout.pack();
        Dsignout.setLocation(80, 50);
        Dsignout.setAlwaysOnTop(true);
        Dsignout.setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void cbhostellItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhostellItemStateChanged
        DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbroomm.getModel();
        tb1.removeAllElements();
        tb1.addElement("SELECT ROOM");
        cbroomm.setSelectedIndex(0);
        try {
            String sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostell.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb1.addElement(rs.getString("ROOMNO"));
            }
        } catch (SQLException err) {
            //JOptionPane.showMessageDialog(this, err.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbhostellItemStateChanged

    private void cbroommItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbroommItemStateChanged
        String row[] = {};
        DefaultTableModel tb = (DefaultTableModel) tablesignout.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        String dateInString = "Jun 7, 2013";
        try {
            String sql = "SELECT * FROM HOSTEL WHERE IDNO='" + txtidnoreg.getText() + "' && "
                    + "HOSTEL='" + cbhostell.getSelectedItem().toString() + "' && "
                    + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            ldatein.setText(formatter.format(rs.getDate("DATEE")));
            if (rs.getString("STATUS").equals("OUT")) {
                dateout.setDate(rs.getDate("DATEOUT"));
            }
            double tot = 0, payed = 0;
            sql = "SELECT * FROM EXPECTED WHERE HOSTEL='" + cbhostell.getSelectedItem().toString() + "' AND "
                    + "ROOMNOA='" + cbroomm.getSelectedItem().toString() + "' AND "
                    + "IDNO='" + txtidnoreg.getText() + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(tablesignout.getRowCount(), tablesignout.getRowCount() - 1, 0);
                tb.setValueAt(rs.getString("YEAR"), tablesignout.getRowCount() - 1, 1);
                tb.setValueAt(rs.getString("MONTH"), tablesignout.getRowCount() - 1, 2);
                tb.setValueAt(Double.parseDouble(rs.getString("RENT"))
                        + Double.parseDouble(rs.getString("WATER"))
                        + Double.parseDouble(rs.getString("ELECTRICITY"))
                        + Double.parseDouble(rs.getString("OTHERS")), tablesignout.getRowCount() - 1, 3);
                tb.setValueAt(rs.getString("PAYEDAMOUNT"), tablesignout.getRowCount() - 1, 4);
                tb.setValueAt(Double.toString(
                        Double.parseDouble(tablesignout.getValueAt(tablesignout.getRowCount() - 1, 4).toString())
                        - Double.parseDouble(tablesignout.getValueAt(tablesignout.getRowCount() - 1, 3).toString())),
                        tablesignout.getRowCount() - 1, 5);
                tot = tot + Double.parseDouble(tablesignout.getValueAt(tablesignout.getRowCount() - 1, 3).toString());
                payed = payed + Double.parseDouble(tablesignout.getValueAt(tablesignout.getRowCount() - 1, 4).toString());
            }
            txtexpectedsignout.setText(Double.toString(tot));
            txtpayedsignout.setText(Double.toString(payed));
            txtbalsignout.setText(Double.toString(payed - tot));
            lerror.setText("");
        } catch (Exception err) {
            txtexpectedsignout.setText("0.0");
            txtpayedsignout.setText("0.0");
            txtbalsignout.setText("0.0");
            lerror.setText("Record not Available\n " + err.getMessage());  //JOptionPane.showMessageDialog(Dsignout, err.getMessage());
        }

        String sql = "";

        int n = 0;
        int days = 0;
        int i = 0;
        //   while (n < tablesignout.getRowCount()) 
//        {
//            try {
//                sql = "SELECT * FROM HOSTEL WHERE HOSTEL='"
//                        + cbhostell.getSelectedItem().toString() + "' AND "
//                        + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "' AND "
//                        + "IDNO='" + txtidnoreg.getText() + "'";
//                rs = stmt.executeQuery(sql);
//                rs.next();
//                tb.setValueAt(rs.getString("DATEOUT"), n, 6);
//                days = Days.daysBetween(new LocalDate(rs.getDate("DATEE")),
//                        new LocalDate(rs.getDate("DATEOUT"))).getDays();
//                //tb.setValueAt(Days.daysBetween(new LocalDate(rs.getDate("DATEE")), new LocalDate(rs.getDate("DATEOUT"))).getDays(),
//                //n, 7);
//                System.out.println(days);
//                i++;
//            } catch (Exception err) {
////                tb.setValueAt("Sign Out First", n, 6);
//                // System.out.println(err.getMessage());
//            }
//            double tot = 0, payed = 0.0;
//            try {
//                sql = "SELECT * FROM PAYMENT WHERE HOSTEL='"
//                        + tablerefund.getValueAt(n, 1).toString() + "' AND "
//                        + "ROOMNO='" + tablerefund.getValueAt(n, 2).toString() + "' AND "
//                        + "IDNO='" + tablerefund.getValueAt(n, 4).toString() + "'";
//                rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    tot = tot + Double.parseDouble(rs.getString("AMOUNT"));
//                }
//            } catch (SQLException err) {
//            }
        //tb.setValueAt(tot, n, 8);
        tot = 0;
//            try {
//                sql = "SELECT * FROM EXPECTED WHERE HOSTEL='"
//                        + cbhostell.getSelectedItem().toString() + "' AND "
//                        + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "' AND "
//                        + "IDNO='" + txtidnoreg.getText() + "'";
//                rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    tot = tot + Double.parseDouble(rs.getString("RENT")) + Double.parseDouble(rs.getString("WATER"))
//                            + Double.parseDouble(rs.getString("ELECTRICITY")) + Double.parseDouble(rs.getString("OTHERS"));
//                    payed = Double.parseDouble(rs.getString("PAYEDAMOUNT"));
//                }
//            } catch (SQLException err) {
//                tot = 0.0;
//                payed = 0.0;
//            }
//
//
//            double amountowed = 0.0;
//            if ((tablerefund.getValueAt(n, 6).toString().equals("Sign Out First"))) {
//            } else {
//                try {
//                    sql = "SELECT * FROM HOSTEL WHERE HOSTEL='" + tablerefund.getValueAt(n, 1).toString() + "' AND"
//                            + " ROOMNO='" + tablerefund.getValueAt(n, 2).toString() + "' AND "
//                            + "IDNO='" + tablerefund.getValueAt(n, 4).toString() + "'";
//                    rs = stmt.executeQuery(sql);
//                    rs.next();
//                    double rate = Double.parseDouble(rs.getString("RATE"));
//                    //double perday=;
//                    amountowed = (rate / 30) * days;
//                } catch (Exception err) {
//                    System.out.println(err.getMessage());
//                }
//                tb.setValueAt(amountowed, n, 7);
//                tb.setValueAt(Double.parseDouble(tablerefund.getValueAt(n, 8).toString()) - amountowed, n, 9);
//                amountowed = 0.0;
//            }
        n++;
        //}
        // TODO add your handling code here:
    }//GEN-LAST:event_cbroommItemStateChanged

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        Calendar cal = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
        txtexpectedsignout1.setText(txtexpectedsignout.getText());
        txtpayedsignout1.setText(txtpayedsignout.getText());
        txtbalsignout1.setText(txtbalsignout.getText());
        txthosteltr.setText(cbhostell.getSelectedItem().toString());
        txtroomnotr.setText(cbroomm.getSelectedItem().toString());
        sdateout.setDate((startDate));

        DTransfer.pack();
        DTransfer.setLocation(80, 50);
        DTransfer.setAlwaysOnTop(true);
        DTransfer.setVisible(true);



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed


        int days = 0;
        double amountowed = 0.0;
        DecimalFormat f = new DecimalFormat("####.##");
        try {
            String d = dateout.getDate().toString();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
            String dateInString = ldatein.getText();
            try {
                String sql = "SELECT * FROM HOSTEL WHERE IDNO='" + txtidnoreg.getText() + "' && "
                        + "HOSTEL='" + cbhostell.getSelectedItem().toString() + "' && "
                        + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                double rate = Double.parseDouble(rs.getString("RATE"));

                days = Days.daysBetween(new LocalDate(rs.getDate("DATEE")),
                        new LocalDate(dateout.getDate())).getDays();
                amountowed = (rate / 30) * days;
                txtexpectedsignout.setText((f.format(amountowed)));
                txtsuggested.setText(f.format((Double.parseDouble(
                        txtpayedsignout.getText()) - Double.parseDouble(txtexpectedsignout.getText()))));
                txtbalsignout.setText(f.format(Double.parseDouble(
                        txtpayedsignout.getText()) - Double.parseDouble(txtexpectedsignout.getText())));
                System.out.println("made it");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (NullPointerException err) {
            JOptionPane.showMessageDialog(Dsignout, "Select Proposed SignOut Date");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        int i = 0;
        try {
            String sql = "SELECT * FROM HOSTEL WHERE IDNO='" + txtidnoreg.getText() + "' && "
                    + "HOSTEL='" + cbhostell.getSelectedItem().toString() + "' && "
                    + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            rs.updateString("STATUS", "OUT");
            rs.updateString("DATEOUT", dateformat.format(dateout.getDate()));
            rs.updateRow();

            sql = "SELECT * FROM HOSTEL WHERE "
                    + "HOSTEL='" + cbhostell.getSelectedItem().toString() + "' && "
                    + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "' && "
                    + "STATUS='IN'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                i++;
            }
            if (i == 0) {
                sql = "SELECT * FROM ROOM WHERE "
                        + "HOSTEL='" + cbhostell.getSelectedItem().toString() + "' && "
                        + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                rs.updateString("STATUS", "AVAILABLE");
            }
        } catch (Exception err) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void cbhostell1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhostell1ItemStateChanged
        DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbroomm1.getModel();
        tb1.removeAllElements();
        tb1.addElement("SELECT ROOM");
        cbroomm1.setSelectedIndex(0);
        try {
            String sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostell1.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb1.addElement(rs.getString("ROOMNO"));
            }
            tb1.removeElement(txtroomnotr.getText());
        } catch (SQLException err) {
            //JOptionPane.showMessageDialog(this, "SSS" + err.getMessage());
        }
    }//GEN-LAST:event_cbhostell1ItemStateChanged

    private void cbroomm1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbroomm1ItemStateChanged
        DefaultTableModel tb = (DefaultTableModel) tablesignout1.getModel();
        while (tablesignout1.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        try {
            String sql = "SELECT * FROM HOSTELV WHERE HOSTEL='" + cbhostell1.getSelectedItem().toString() + "' &&"
                    + " ROOMNO='" + cbroomm1.getSelectedItem().toString() + "' && STATUS='IN'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(tablesignout1.getRowCount(), tablesignout1.getRowCount() - 1, 0);
                tb.setValueAt(rs.getString("FNAME"), tablesignout1.getRowCount() - 1, 1);
                tb.setValueAt(rs.getString("IDNO"), tablesignout1.getRowCount() - 1, 2);
            }
        } catch (Exception err) {
//JOptionPane.showMessageDialog(Dsignout, err.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_cbroomm1ItemStateChanged

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        int i = 0;
        try {
            String sql = "SELECT * FROM HOSTEL WHERE IDNO='" + txtidnoreg.getText() + "' && "
                    + "HOSTEL='" + cbhostell.getSelectedItem().toString() + "' && "
                    + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            rs.updateString("STATUS", "OUT");
            rs.updateString("DATEOUT", dateformat.format(dateout.getDate()));
            rs.updateRow();

            sql = "SELECT * FROM HOSTEL WHERE "
                    + "HOSTEL='" + cbhostell.getSelectedItem().toString() + "' && "
                    + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "' && "
                    + "STATUS='IN'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                i++;
            }
            if (i == 0) {
                sql = "SELECT * FROM ROOM WHERE "
                        + "HOSTEL='" + cbhostell.getSelectedItem().toString() + "' && "
                        + "ROOMNO='" + cbroomm.getSelectedItem().toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                rs.updateString("STATUS", "AVAILABLE");
            }
        } catch (Exception err) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        payments.pack();
        payments.setLocation(80, 50);
        payments.setAlwaysOnTop(true);
        payments.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        payments.pack();
        payments.setLocation(80, 50);
        payments.setAlwaysOnTop(true);
        payments.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void sdateinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sdateinPropertyChange
        String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "Ocober", "November", "December"};
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdatein.getDate());
            int mon = cal.get(Calendar.MONTH);
            int yr = cal.get(Calendar.YEAR);

            int i = 0;
            while (i < tablesignout1.getRowCount()) {
                try {
                    String sql = "SELECT * FROM EXPECTED WHERE "
                            + "HOSTEL='" + cbhostell1.getSelectedItem().toString() + "' && "
                            + "ROOMNOA='" + cbroomm1.getSelectedItem().toString() + "' && "
                            + "MONTH='" + month[mon] + "' && YEAR='" + yr + "'";
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    {

                        tablesignout1.setValueAt(rs.getString("YEAR"), i, 3);
                        tablesignout1.setValueAt(rs.getString("MONTH"), i, 4);
                        tablesignout1.setValueAt(
                                Double.parseDouble(rs.getString("RENT"))
                                + Double.parseDouble(rs.getString("WATER"))
                                + Double.parseDouble(rs.getString("ELECTRICITY"))
                                + Double.parseDouble(rs.getString("OTHERS")), i, 5);
                        tablesignout1.setValueAt(rs.getString("PAYEDAMOUNT"), i, 6);
                        tablesignout1.setValueAt(
                                Double.parseDouble(tablesignout1.getValueAt(i, 6).toString())
                                - Double.parseDouble(tablesignout1.getValueAt(i, 5).toString()), i, 7);
                    }
                } catch (Exception err) {
                    tablesignout1.setValueAt(yr, i, 3);
                    tablesignout1.setValueAt(month[mon], i, 4);
                    tablesignout1.setValueAt(0.0, i, 5);
                    tablesignout1.setValueAt(0.0, i, 6);
                    tablesignout1.setValueAt(0.0, i, 7);
                }
                i++;
            }
        } catch (NullPointerException err) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_sdateinPropertyChange

    private void cbcateggItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbcateggItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcateggItemStateChanged

    private void cbroomnooccupationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbroomnooccupationItemStateChanged
        if (cbroomnooccupation.getItemCount() > 0 && cbhostelroom2.getSelectedIndex() > 0
                && cbroomnooccupation.getSelectedIndex() > 0) {
            this.OccupationTimes();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_cbroomnooccupationItemStateChanged

    private void txtsearchbyname1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchbyname1KeyReleased
        {

            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            DefaultTableModel tb = (DefaultTableModel) tableoccupation.getModel();
            while (tableoccupation.getRowCount() > 0) {
                tb.removeRow(0);
            }
            String row[] = {};
            try {
                String sql = "";

                sql = "SELECT * FROM CLIENTROOMINFO WHERE "
                        + "FNAME like '%" + txtsearchbyname1.getText() + "%' || "
                        + "IDNO like '%" + txtsearchbyname1.getText() + "%'";
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb.addRow(row);
                    tb.setValueAt(tableoccupation.getRowCount(), tableoccupation.getRowCount() - 1, 0);
                    tb.setValueAt(rs.getString("HOSTEL"), tableoccupation.getRowCount() - 1, 1);
                    tb.setValueAt(rs.getString("ROOMNO"), tableoccupation.getRowCount() - 1, 2);
                    tb.setValueAt(rs.getString("FNAME"), tableoccupation.getRowCount() - 1, 3);
                    tb.setValueAt(rs.getString("IDNO"), tableoccupation.getRowCount() - 1, 4);
                    tb.setValueAt(rs.getString("DATEE"), tableoccupation.getRowCount() - 1, 5);
                    tb.setValueAt(rs.getString("DATEEX"), tableoccupation.getRowCount() - 1, 6);
                    tb.setValueAt(rs.getString("STATUS"), tableoccupation.getRowCount() - 1, 7);
                    //tb.setValueAt(rs.getString("ISSUED"), tableoccupation.getRowCount() - 1, 8);
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchbyname1KeyReleased

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd,MMM yyyy HH:mm:ss");
        java.sql.Date startDate = new java.sql.Date(cal.getTime().getTime());
        
            DecimalFormat f = new DecimalFormat("#,###.##");
            TextColumnBuilder<String> sno = col.column(" ", "sno", type.stringType()).setWidth(30);
            TextColumnBuilder<String> apart = col.column("Apartment", "apart", type.stringType());
            TextColumnBuilder<String> roomno = col.column("RoomNo", "roomno", type.stringType()).setWidth(50);;
            TextColumnBuilder<String> name = col.column("Client Name", "name", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.LEFT).setWidth(120);
            TextColumnBuilder<String> idno = col.column("IDNO.", "idno", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT).setWidth(60);;
            TextColumnBuilder<String> dateentry = col.column("DateEntry", "dateentry", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT).setWidth(60);;
            TextColumnBuilder<String> dateout = col.column("DateOut", "dateout", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.RIGHT).setWidth(60);;
            TextColumnBuilder<String> status = col.column("Status", "status", type.stringType()).
                    setHorizontalAlignment(HorizontalAlignment.CENTER).setWidth(40);
            StyleBuilder groupStyle = stl.style().bold();
            {
                try {
                    report()
                            .setTemplate(Templates.reportTemplate)
                            .columns(sno, apart, roomno, name, idno, dateentry, dateout, status)
                            .title(Templates.createTitleComponent1(
                            dateformat.format(startDate),
                            "SUPPLIER :",
                            "DROP POINT :",
                            "SALE NO. :",
                            "SUPPLIER CREDIT PAYMENT STATEMENT"),
                            cmp.verticalGap(10))
                            .pageFooter(Templates.footerComponent)
                            //                                    .summary(
                            //                                    cmp.line(),
                            //                                    cmp.verticalGap(30),
                            //                                    cmp.horizontalList(
                            //                                    cmp.text("TOTAL AMOUNT :" + txttotalamountc1.getText()).setStyle(Templates.bold14LeftStyle),
                            //                                    cmp.text("TOTAL PAYED :" + txtsamountpayed.getText()).setStyle(Templates.bold14CenteredStyle),
                            //                                    cmp.text("BALANCE :" + txtsbalance.getText()).setStyle(Templates.bold14RightStyle).
                            //                                    setHorizontalAlignment(HorizontalAlignment.RIGHT)),
                            //                                    cmp.verticalGap(30),
                            //                                    cmp.text("Thank you for your Business").setStyle(Templates.bold12CenteredStyle),
                            //                                    cmp.line())
                            .setDataSource(RoomOccupationDataSource1())
                            .show(false);
                } catch (DRException e) {
                    System.out.println(e.getMessage());
                }
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

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
            java.util.logging.Logger.getLogger(Hostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hostel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DTransfer;
    private javax.swing.JDialog Dexpenses;
    private javax.swing.JDialog Dsignout;
    private javax.swing.JButton btnaddroom;
    private javax.swing.JButton btnapprove;
    private javax.swing.JComboBox cbcateg;
    private javax.swing.JComboBox cbcategexpenses;
    private javax.swing.JComboBox cbcategg;
    private javax.swing.JComboBox cbcategory;
    private javax.swing.JComboBox cbclientlevel;
    private javax.swing.JComboBox cbcontition;
    private javax.swing.JComboBox cbduration;
    private javax.swing.JComboBox cbgender;
    private javax.swing.JComboBox cbhostel;
    private javax.swing.JComboBox cbhostell;
    private javax.swing.JComboBox cbhostell1;
    private javax.swing.JComboBox cbhostelroom;
    private javax.swing.JComboBox cbhostelroom1;
    private javax.swing.JComboBox cbhostelroom2;
    private javax.swing.JComboBox cbhostelroom3;
    private javax.swing.JComboBox cbhostelroom4;
    private com.toedter.calendar.JMonthChooser cbmonth;
    private javax.swing.JComboBox cbmonthd;
    private javax.swing.JComboBox cbmonthd1;
    private javax.swing.JComboBox cbpaymentroomno;
    private javax.swing.JComboBox cbproomno1;
    private javax.swing.JComboBox cbroomm;
    private javax.swing.JComboBox cbroomm1;
    private javax.swing.JComboBox cbroomnooccupation;
    private javax.swing.JComboBox cbrumno;
    private javax.swing.JComboBox cbsbyid;
    private javax.swing.JComboBox cbsbyname;
    private javax.swing.JComboBox cbstafflist;
    private javax.swing.JComboBox cbstatus;
    private javax.swing.JComboBox cbstatuss;
    private com.toedter.calendar.JYearChooser cbyear;
    private javax.swing.JComboBox cbyeard;
    private javax.swing.JComboBox cbyeard1;
    private javax.swing.JCheckBox chall;
    private javax.swing.JCheckBox chapply;
    private javax.swing.JCheckBox chkeep;
    private com.toedter.calendar.JDateChooser datechooser;
    private com.toedter.calendar.JDateChooser datedue;
    private com.toedter.calendar.JDateChooser dateendd;
    private com.toedter.calendar.JDateChooser dateexpense;
    private com.toedter.calendar.JDateChooser dateout;
    private com.toedter.calendar.JDateChooser datestartt;
    private javax.swing.JFileChooser db;
    private com.toedter.calendar.JDateChooser dend;
    private com.toedter.calendar.JDateChooser dpayableby;
    private com.toedter.calendar.JDateChooser dstart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
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
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JDialog jaddroom;
    private javax.swing.JLabel ldatein;
    private javax.swing.JLabel lerror;
    private javax.swing.JLabel lerror1;
    private javax.swing.JLabel lhostel;
    private javax.swing.JLabel lnamesignout;
    private javax.swing.JLabel lphoto;
    private javax.swing.JLabel lroomno;
    private javax.swing.ButtonGroup occupation;
    private javax.swing.JDialog payments;
    private javax.swing.JPanel pt;
    private com.toedter.calendar.JDateChooser sdatein;
    private com.toedter.calendar.JDateChooser sdateout;
    private javax.swing.JRadioButton signin;
    private javax.swing.JRadioButton signout;
    private javax.swing.JTable tableexpense;
    private javax.swing.JTable tableexpense1;
    private javax.swing.JTable tableoccupation;
    private javax.swing.JTable tableone;
    private javax.swing.JTable tablepay;
    private javax.swing.JTable tablerefund;
    private javax.swing.JTable tablereg;
    private javax.swing.JTable tableregister;
    private javax.swing.JTable tableroomreg;
    private javax.swing.JTable tablesearch;
    private javax.swing.JTable tablesignout;
    private javax.swing.JTable tablesignout1;
    private javax.swing.JTable tablestats;
    private javax.swing.JTable tablestatsview;
    private javax.swing.JTabbedPane tb1;
    private javax.swing.ButtonGroup time;
    private javax.swing.JPanel toto;
    private javax.swing.JTextField txtamountexpense;
    private javax.swing.JTextField txtampayednow;
    private javax.swing.JTextField txtassetp;
    private javax.swing.JTextField txtbal;
    private javax.swing.JTextField txtbalsignout;
    private javax.swing.JTextField txtbalsignout1;
    private javax.swing.JTextField txtcaret;
    private javax.swing.JTextField txtcaretaker;
    private javax.swing.JTextField txtcaretidno;
    private com.toedter.calendar.JDateChooser txtdatee;
    private com.toedter.calendar.JDateChooser txtdateex;
    private com.toedter.calendar.JDateChooser txtdatefrom;
    private com.toedter.calendar.JDateChooser txtdateto;
    private javax.swing.JTextField txtdepartment;
    private javax.swing.JTextArea txtdescexpenses;
    private javax.swing.JTextField txtelecp;
    private javax.swing.JTextField txtelectbill;
    private javax.swing.JTextField txtelectric;
    private javax.swing.JTextField txtexpectedsignout;
    private javax.swing.JTextField txtexpectedsignout1;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtfriend;
    private javax.swing.JTextField txtgphoneno;
    private javax.swing.JTextField txtgurdianname;
    private javax.swing.JTextField txthome;
    private javax.swing.JTextField txthostel;
    private javax.swing.JTextField txthosteltr;
    private javax.swing.JTextField txtidno;
    private javax.swing.JTextField txtidnoo;
    private javax.swing.JTextField txtidnoreg;
    private javax.swing.JTextField txtincluded;
    private javax.swing.JTextField txtinst;
    private javax.swing.JTextField txtjob;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtloc;
    private javax.swing.JTextField txtnoocupants;
    private javax.swing.JTextField txtotherbills;
    private javax.swing.JTextField txtothersp;
    private javax.swing.JTextField txtowner;
    private javax.swing.JTextField txtpayedsignout;
    private javax.swing.JTextField txtpayedsignout1;
    private javax.swing.JTextField txtphoneno;
    private javax.swing.JTextField txtphonenoc;
    private javax.swing.JTextField txtphonenoca;
    private javax.swing.JTextField txtphonenoo;
    private javax.swing.JTextField txtprevious;
    private javax.swing.JTextField txtrate;
    private javax.swing.JTextField txtregno;
    private javax.swing.JTextField txtremarks;
    private javax.swing.JTextField txtrent;
    private javax.swing.JTextField txtrentexpected;
    private javax.swing.JTextField txtrentp;
    private javax.swing.JTextField txtroomname;
    private javax.swing.JTextField txtroomno;
    private javax.swing.JTextField txtroomnotr;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsearch1;
    private javax.swing.JTextField txtsearchbyname;
    private javax.swing.JTextField txtsearchbyname1;
    private javax.swing.JTextField txtsearchbyname2;
    private javax.swing.JTextField txtsuggested;
    private javax.swing.JTextField txtsuggested1;
    private javax.swing.JTextField txtwater;
    private javax.swing.JTextField txtwaterbill;
    private javax.swing.JTextField txtwaterp;
    private javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables

    public void setUpSportColumn(JTable table,
            TableColumn sportColumn) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Available");
        comboBox.addItem("Taken");
        comboBox.addItem("Suspended");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        renderer.setToolTipText("Click to Select Status");
        sportColumn.setCellRenderer(renderer);
    }

    public void Clear() {
        txtlname.setText("");
        txtfname.setText("");
        txtidno.setText("");
        txtjob.setText("");
        txtinst.setText("");
        txtphoneno.setText("");
        txtfriend.setText("");
        cbgender.setSelectedIndex(0);
        cbhostel.setSelectedIndex(0);
        cbrumno.setSelectedIndex(0);
        txtrate.setText("");
        txtdatee.setDate(null);
        txtdateex.setDate(null);
        txtassetp.setText("");
        txtampayednow.setText("");
        //txtdate.setDate(null);
        txtfriend.setText("");
        cbmonth.setMonth(0);
        cbyear.setYear(0);
        txtdatefrom.setDate(null);
        txtdateto.setDate(null);
        txtcaret.setText("");
        txtphonenoc.setText("");
//        txtnotes.setText("");
        lhostel.setText("");
        lroomno.setText("");
        cbsbyid.setSelectedIndex(0);
        cbsbyname.setSelectedIndex(0);
    }

    public void RoomClear() {
        txtroomname.setText("");
        txtincluded.setText("");
        txtrent.setText("");
        txtwater.setText("");
        txtelectric.setText("");
        cbcategory.setSelectedIndex(0);
        cbduration.setSelectedIndex(0);
        cbstatus.setSelectedIndex(0);
        cbcontition.setSelectedIndex(0);
    }

    public void PopulateHostel() {
        //setUpSportColumn(tableregister, tableregister.getColumnModel().getColumn(5));
        DefaultTableModel tb = (DefaultTableModel) tablereg.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        int i = 1;
        try {
            String sql = "SELECT * FROM HOSTELIN";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(i, i - 1, 0);
                tb.setValueAt(rs.getString("NAME"), i - 1, 1);
                tb.setValueAt(rs.getString("LOC"), i - 1, 2);
                tb.setValueAt(rs.getString("ROOMNO"), i - 1, 3);
                tb.setValueAt(rs.getString("CPHONENO"), i - 1, 4);
                //tb.setValueAt(rs.getString("CPHONE"), i - 1, 5);
                i++;
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
    }

    public void PopulateRooms() {
        //setUpSportColumn(tableregister, tableregister.getColumnModel().getColumn(5));
        DefaultTableModel tb = (DefaultTableModel) tableregister.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        if (cbhostelroom.getSelectedIndex() == 0 || cbhostelroom.getItemCount() == 0) {
        } else {
            String row[] = {};
            int i = 1;
            String sql = "";
            try {
                if (cbhostelroom.getSelectedIndex() == cbhostelroom.getItemCount() - 1) {
                } else {
                    sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom.getSelectedItem().toString() + "'";
                }
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb.addRow(row);
                    tb.setValueAt(i, i - 1, 0);
                    tb.setValueAt(rs.getString("ROOMNO"), i - 1, 1);
                    tb.setValueAt(rs.getString("CATEGORY"), i - 1, 2);
                    tb.setValueAt(rs.getString("INCLUDED"), i - 1, 3);
                    tb.setValueAt(rs.getString("RENT"), i - 1, 4);
                    tb.setValueAt(rs.getString("WATER"), i - 1, 5);
                    tb.setValueAt(rs.getString("ELECTRICITY"), i - 1, 6);
                    tb.setValueAt(rs.getString("DURATION"), i - 1, 7);
                    tb.setValueAt(rs.getString("CONDITION"), i - 1, 8);
                    tb.setValueAt(rs.getString("STATUS"), i - 1, 9);
                    i++;
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(this, err.getMessage());
            }
        }
    }

    public void Start() {
        DefaultTableModel tb = (DefaultTableModel) tableone.getModel();
        while (tableone.getRowCount() > 0) {
            tb.removeRow(0);
        }
        String row[] = {};
        try {
            String sql = "SELECT * FROM STAFF WHERE FNAME LIKE '%" + txtsearch.getText() + "%' || IDNO LIKE '%" + txtsearch.getText() + "%'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.addRow(row);
                tb.setValueAt(tableone.getRowCount(), tableone.getRowCount() - 1, 0);
                tb.setValueAt(rs.getString("FNAME"), tableone.getRowCount() - 1, 1);
                tb.setValueAt(rs.getString("IDNO"), tableone.getRowCount() - 1, 2);
                tb.setValueAt(rs.getString("GENDER"), tableone.getRowCount() - 1, 3);
                tb.setValueAt(rs.getString("PHONENO"), tableone.getRowCount() - 1, 4);
//                tb.setValueAt(rs.getString("HOSTEL"), tableone.getRowCount() - 1, 5);
//                tb.setValueAt(rs.getString("ROOMNO"), tableone.getRowCount() - 1, 6);
//                tb.setValueAt(rs.getString("DATEE"), tableone.getRowCount() - 1,7);
//                tb.setValueAt(rs.getString("DATEEX"), tableone.getRowCount() - 1, 8);
                tb.setValueAt(rs.getString("ISSUED"), tableone.getRowCount() - 1, 9);
            }
        } catch (Exception err) {
            //System.out.println(err.getMessage());
        }
        int i = 0;
        while (i < tableone.getRowCount()) {
            try {
                String sql = "SELECT * FROM HOSTEL WHERE IDNO ='" + tableone.getValueAt(i, 2).toString() + "'";
                rs = stmt.executeQuery(sql);
                rs.next();
                tb.setValueAt(rs.getString("HOSTEL"), i, 5);
                tb.setValueAt(rs.getString("ROOMNO"), i, 6);
                tb.setValueAt(rs.getString("DATEE"), i, 7);
                tb.setValueAt(rs.getString("DATEEX"), i, 8);
            } catch (Exception err) {
                tb.setValueAt("", i, 5);
                tb.setValueAt("", i, 6);
                tb.setValueAt("", i, 7);
                tb.setValueAt("", i, 8);
                //tb.setValueAt(rs.getString("ISSUED"), tableone.getRowCount() - 1, 9);
                System.out.println(err.getMessage());
            }
            System.out.println(tableone.getValueAt(i, 2).toString());
            i++;
        }
    }

    public void PopulateHostels() {
        DefaultComboBoxModel cb = (DefaultComboBoxModel) cbhostelroom1.getModel();
        cb.removeAllElements();
        DefaultComboBoxModel cb1 = (DefaultComboBoxModel) cbhostelroom2.getModel();
        cb1.removeAllElements();
        DefaultComboBoxModel cb2 = (DefaultComboBoxModel) cbhostelroom3.getModel();
        cb2.removeAllElements();
        DefaultComboBoxModel cb3 = (DefaultComboBoxModel) cbhostelroom4.getModel();
        cb3.removeAllElements();
        DefaultComboBoxModel cb4 = (DefaultComboBoxModel) cbhostell.getModel();
        cb4.removeAllElements();
        DefaultComboBoxModel cb5 = (DefaultComboBoxModel) cbhostell1.getModel();
        cb5.removeAllElements();
        cb.addElement("SELECT HOSTEL");
        cb1.addElement("SELECT HOSTEL");
        cb2.addElement("SELECT HOSTEL");
        cb3.addElement("SELECT HOSTEL");
        cb4.addElement("SELECT HOSTEL");
        cb5.addElement("SELECT HOSTEL");
        try {
            String sql = "SELECT * FROM HOSTELIN";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cb.addElement(rs.getString("NAME"));
                cb1.addElement(rs.getString("NAME"));
                cb2.addElement(rs.getString("NAME"));
                cb3.addElement(rs.getString("NAME"));
                cb4.addElement(rs.getString("NAME"));
                cb5.addElement(rs.getString("NAME"));
            }
        } catch (Exception err) {
            //tb.setValueAt(rs.getString("ISSUED"), tableone.getRowCount() - 1, 9);
            System.out.println(err.getMessage());
        }
    }

    public JRDataSource ApartmentsDatasource() {
        DRDataSource dataSource = new DRDataSource();
        DefaultTableModel tb = new DefaultTableModel();

        dataSource = new DRDataSource("sno", "name", "loc", "owner", "pno", "roomno");
        int i = 1;
        try {
            String sql = "SELECT * FROM HOSTELIN";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dataSource.add(
                        i,
                        rs.getString("NAME"),
                        rs.getString("LOC"),
                        rs.getString("OWNER"),
                        rs.getString("PHONENO"),
                        rs.getString("ROOMNO"));
            }
        } catch (Exception err) {
        }
        return dataSource;
    }

    public JRDataSource ClientsDatasource() {
        DRDataSource dataSource = new DRDataSource();
        DefaultTableModel tb = new DefaultTableModel();

        dataSource = new DRDataSource("sno", "name", "reg", "g", "pno", "job");
        int i = 1;
        try {
            String sql = "SELECT * FROM STAFF";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dataSource.add(
                        i,
                        rs.getString("FNAME"),
                        rs.getString("IDNO"),
                        rs.getString("GENDER"),
                        rs.getString("PHONENO"),
                        rs.getString("JOB"));
                i++;
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
        return dataSource;
    }

    public JRDataSource RooAllocationmDatasource() {
        DRDataSource dataSource = new DRDataSource();
        DefaultTableModel tb = new DefaultTableModel();

        dataSource = new DRDataSource("sno", "name", "room", "fname", "id", "rent", "datein", "dateout");
        int i = 1;
        try {
            String sql = "SELECT * FROM HOSTELV";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dataSource.add(
                        i,
                        rs.getString("HOSTEL"),
                        rs.getString("ROOMNO"),
                        rs.getString("FNAME"),
                        rs.getString("IDNO"),
                        rs.getString("RATE"),
                        rs.getString("DATEE"),
                        rs.getString("DATEOUT"));
                i++;
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
        }
        return dataSource;
    }

    public void RoomStats() {
        if (chkeep.isSelected()) {
        } else {
            txtrentp.setText("0.0");
            txtwaterp.setText("0.0");
            txtelecp.setText("0.0");
            txtothersp.setText("0.0");
        }
        DefaultTableModel tb = (DefaultTableModel) tablestats.getModel();
        while (tb.getRowCount() > 0) {
            tb.removeRow(0);
        }
        if (cbhostelroom4.getSelectedIndex() == 0) {
        } else {
            String row[] = {};
            int i = 1;
            String sql = "";
            try {
                if (cbhostelroom4.getSelectedIndex() == 0) {
                } else {
                    if (cbproomno1.getSelectedIndex() == 0) {
                        sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom4.getSelectedItem().toString() + "'";
                    } else {
                        sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom4.getSelectedItem().toString() + "' &&"
                                + " ROOMNO='" + cbproomno1.getSelectedItem().toString() + "'";
                    }
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        tb.addRow(row);
                        tb.setValueAt(i, i - 1, 0);
                        tb.setValueAt(rs.getString("HOSTEL"), i - 1, 1);
                        tb.setValueAt(rs.getString("ROOMNO"), i - 1, 2);
                        tb.setValueAt(0.0, i - 1, 3);
                        tb.setValueAt(0.0, i - 1, 4);
                        tb.setValueAt(0.0, i - 1, 5);
                        tb.setValueAt(0.0, i - 1, 6);
                        tb.setValueAt("", i - 1, 7);
                        i++;
                    }
                    i = 0;
                    if (cbyeard1.getSelectedIndex() == 0) {
                    } else {
                        if (cbmonthd1.getSelectedIndex() == 0) {
                        } else {
                            i = 0;
                            while (i < tablestats.getRowCount()) {
                                sql = "SELECT * FROM ROOMSTATS WHERE "
                                        + "HOSTEL='" + tablestats.getValueAt(i, 1).toString() + "' && "
                                        + "ROOMNO='" + tablestats.getValueAt(i, 2).toString() + "' && "
                                        + "YEAR='" + cbyeard1.getSelectedItem().toString() + "' &&  "
                                        + "MONTH='" + cbmonthd1.getSelectedItem().toString() + "'";
                                rs = stmt.executeQuery(sql);
                                rs.next();
                                tb.setValueAt(rs.getString("RENT"), i, 3);
                                tb.setValueAt(rs.getString("WATER"), i, 4);
                                tb.setValueAt(rs.getString("ELEC"), i, 5);
                                tb.setValueAt(rs.getString("OTHERS"), i, 6);
                                tb.setValueAt(rs.getString("EXPECTED"), i, 7);


                                // tb.setValueAt(rs.getString("EXPECTED"), i, 7);

                                i++;
                            }
                        }
                    }
                }
                //i++;
            } catch (Exception err) {
                //  JOptionPane.showMessageDialog(this, err.getMessage());
            }
        }
    }

    private JRDataSource createDataSource1() {

        DRDataSource dataSource = new DRDataSource("");
        {
            dataSource = new DRDataSource("sno", "date", "categ", "staff", "descr", "tot");
            int i = 0;
            while (i < tableexpense.getRowCount()) {
                dataSource.add(
                        tableexpense.getValueAt(i, 0).toString(),
                        tableexpense.getValueAt(i, 1).toString(),
                        tableexpense.getValueAt(i, 2).toString(),
                        tableexpense.getValueAt(i, 3).toString(),
                        tableexpense.getValueAt(i, 4).toString(),
                        //                        tableexpense.getValueAt(i, 5).toString(),
                        //                        tablesales.getValueAt(i, 6).toString(),
                        //                        Double.parseDouble(tablesales.getValueAt(i, 7).toString()),
                        Double.parseDouble(tableexpense.getValueAt(i, 5).toString()));
                i++;
            }
        }
        return dataSource;
    }

    private JRDataSource ExpenseApprovedDataSource() {

        DRDataSource dataSource = new DRDataSource("");
        {
            dataSource = new DRDataSource("sno", "date", "categ", "staff", "descr", "datea", "tot");
            int i = 0;
            while (i < tableexpense1.getRowCount()) {
                dataSource.add(
                        tableexpense1.getValueAt(i, 0).toString(),
                        tableexpense1.getValueAt(i, 1).toString(),
                        tableexpense1.getValueAt(i, 2).toString(),
                        tableexpense1.getValueAt(i, 3).toString(),
                        tableexpense1.getValueAt(i, 4).toString(),
                        tableexpense1.getValueAt(i, 5).toString(),
                        //                        tableexpense.getValueAt(i, 5).toString(),
                        //                        tablesales.getValueAt(i, 6).toString(),
                        //                        Double.parseDouble(tablesales.getValueAt(i, 7).toString()),
                        Double.parseDouble(tableexpense1.getValueAt(i, 6).toString()));
                i++;
            }
        }
        return dataSource;
    }

    public void OccupationTimes() {
        if (cbhostelroom2.getItemCount() > 0 && cbhostelroom2.getSelectedIndex() > 0) {

            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            DefaultTableModel tb = (DefaultTableModel) tableoccupation.getModel();
            while (tableoccupation.getRowCount() > 0) {
                tb.removeRow(0);
            }
            String row[] = {};
            try {
                String sql = "";
                if (cbcategg.getSelectedIndex() == 0) {
                    if (signin.isSelected()) {
                        if (cbroomnooccupation.getSelectedIndex() == 0) {
                            sql = "SELECT * FROM CLIENTROOMINFO WHERE STATUS='IN'  && "
                                    + "HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "' &&"
                                    + " DATEE>='" + dateformat.format(datestartt.getDate()) + "' "
                                    + "&& DATEE<='" + dateformat.format(dateendd.getDate()) + "'";
                        } else {
                            sql = "SELECT * FROM CLIENTROOMINFO WHERE STATUS='IN'  && "
                                    + "HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "' && "
                                    + " DATEE>='" + dateformat.format(datestartt.getDate()) + "' "
                                    + "&& DATEE<='" + dateformat.format(dateendd.getDate()) + "' && "
                                    + "ROOMNO='" + cbroomnooccupation.getSelectedItem().toString() + "'";
                        }
                    }
                } else if (cbcategg.getSelectedIndex() == 1) {
                    if (signout.isSelected()) {
                        if (cbroomnooccupation.getSelectedIndex() == 0) {
                            sql = "SELECT * FROM CLIENTROOMINFO WHERE STATUS='OUT' AND "
                                    + "HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "'&&"
                                    + " DATEE>='" + dateformat.format(datestartt.getDate()) + "' && "
                                    + "DATEE<='" + dateformat.format(dateendd.getDate()) + "'";
                        } else {
                            sql = "SELECT * FROM CLIENTROOMINFO WHERE STATUS='OUT' AND "
                                    + "HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "'&&"
                                    + " DATEE>='" + dateformat.format(datestartt.getDate()) + "' && "
                                    + "DATEE<='" + dateformat.format(dateendd.getDate()) + "'";
                        }
                    }
                } else if (cbcategg.getSelectedIndex() == 2) {
                    if (signin.isSelected()) {
                        if (cbroomnooccupation.getSelectedIndex() == 0) {
                            sql = "SELECT * FROM CLIENTROOMINFO WHERE "
                                    + "HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "' &&"
                                    + " DATEE>='" + dateformat.format(datestartt.getDate()) + "' && "
                                    + "DATEE<='" + dateformat.format(dateendd.getDate()) + "'";
                        } else {
                            sql = "SELECT * FROM CLIENTROOMINFO WHERE "
                                    + "HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "' &&"
                                    + " DATEE>='" + dateformat.format(datestartt.getDate()) + "' && "
                                    + "DATEE<='" + dateformat.format(dateendd.getDate()) + "'";
                        }
                    } else if (signout.isSelected()) {
                        if (cbroomnooccupation.getSelectedIndex() == 0) {
                            sql = "SELECT * FROM CLIENTROOMINFO WHERE  "
                                    + "HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "'&&"
                                    + " DATEE>='" + dateformat.format(datestartt.getDate()) + "' && "
                                    + "DATEE<='" + dateformat.format(dateendd.getDate()) + "'";
                        } else {
                            sql = "SELECT * FROM CLIENTROOMINFO WHERE  "
                                    + "HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "'&&"
                                    + " DATEE>='" + dateformat.format(datestartt.getDate()) + "' && "
                                    + "DATEE<='" + dateformat.format(dateendd.getDate()) + "'";
                        }
                    }
                } else {
                    sql = "SELECT * FROM CLIENTROOMINFO ";
                }
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    tb.addRow(row);
                    tb.setValueAt(tableoccupation.getRowCount(), tableoccupation.getRowCount() - 1, 0);
                    tb.setValueAt(rs.getString("HOSTEL"), tableoccupation.getRowCount() - 1, 1);
                    tb.setValueAt(rs.getString("ROOMNO"), tableoccupation.getRowCount() - 1, 2);
                    tb.setValueAt(rs.getString("FNAME"), tableoccupation.getRowCount() - 1, 3);
                    tb.setValueAt(rs.getString("IDNO"), tableoccupation.getRowCount() - 1, 4);
                    tb.setValueAt(rs.getString("DATEE"), tableoccupation.getRowCount() - 1, 5);
                    tb.setValueAt(rs.getString("DATEEX"), tableoccupation.getRowCount() - 1, 6);
                    tb.setValueAt(rs.getString("STATUS"), tableoccupation.getRowCount() - 1, 7);
                    //tb.setValueAt(rs.getString("ISSUED"), tableoccupation.getRowCount() - 1, 8);
                }
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
//            DefaultComboBoxModel tb1 = (DefaultComboBoxModel) cbroomnooccupation.getModel();
//            tb1.removeAllElements();
//            tb1.addElement("SELECT ROOM");
//            cbroomnooccupation.setSelectedIndex(0);
//            try {
//                String sql = "SELECT * FROM ROOM WHERE HOSTEL='" + cbhostelroom2.getSelectedItem().toString() + "'";
//                rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    tb1.addElement(rs.getString("ROOMNO"));
//                }
//            } catch (SQLException err) {
//                JOptionPane.showMessageDialog(this, err.getMessage());
//            }
        }
    }
     private JRDataSource RoomOccupationDataSource1() {

        DRDataSource dataSource = new DRDataSource("");
        dataSource = new DRDataSource("sno", "apart", "roomno", "name", "idno", "dateentry","dateout","status");
        int i = 0;
        while (i < tableoccupation.getRowCount()) {
            dataSource.add(
                    tableoccupation.getValueAt(i, 0).toString(),
                    tableoccupation.getValueAt(i, 1).toString(),
                    tableoccupation.getValueAt(i, 2).toString(),
                    tableoccupation.getValueAt(i, 3).toString(),
                    tableoccupation.getValueAt(i, 4).toString(),
                    tableoccupation.getValueAt(i, 5).toString(),
                    tableoccupation.getValueAt(i, 6).toString(),
                    tableoccupation.getValueAt(i, 7).toString());
            i++;
        }

        return dataSource;
    }
        private JRDataSource RoomDataSource1() {

        DRDataSource dataSource = new DRDataSource("");
        dataSource = new DRDataSource("sno", "apart", "roomno", "cond", "status");
        int i = 0;
        while (i < tableroomreg.getRowCount()) {
            dataSource.add(
                    tableroomreg.getValueAt(i, 0).toString(),
                    tableroomreg.getValueAt(i, 1).toString(),
                    tableroomreg.getValueAt(i, 2).toString(),
                    tableroomreg.getValueAt(i, 3).toString(),
                    tableroomreg.getValueAt(i, 4).toString()
                    //,
//                    tableoccupation.getValueAt(i, 5).toString(),
//                    tableoccupation.getValueAt(i, 6).toString(),
//                    tableoccupation.getValueAt(i, 7).toString()
                    );
            i++;
        }
        return dataSource;
    }
}
