package student;

import db.MyConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MarkSheet {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    //check score id is already exist 
    public boolean isIdExist(int sid) {
        try {
            ps = con.prepareStatement("select * from score where student_id=?");
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //fetch the all score form database score table
    public void getScoreValue(JTable table, int sid) {
        String sql = "select * from score where student_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sid);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[14];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getString(4);
                row[4] = rs.getDouble(5);
                row[5] = rs.getString(6);
                row[6] = rs.getDouble(7);
                row[7] = rs.getString(8);
                row[8] = rs.getDouble(9);
                row[9] = rs.getString(10);
                row[10] = rs.getDouble(11);
                row[11] = rs.getString(12);
                row[12] = rs.getDouble(13);
                row[13] = rs.getDouble(14);
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //CGPA counting
    public double getCGPA(int sid) {
    double cgpa = 0.0;

    String sql = "SELECT AVG(average) FROM score WHERE student_id = ?";

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, sid);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cgpa = rs.getDouble(1);
        }

    } catch (SQLException ex) {
        Logger.getLogger(MarkSheet.class.getName()).log(Level.SEVERE, null, ex);
    }

    return cgpa;
}

}
