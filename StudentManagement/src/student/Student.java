/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import db.MyConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hiten
 */
public class Student {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id) FROM student;");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return id + 1;
    }
//insert the student

    public void insert(int id, String sname, String date, String gender, String email, String phone, String father, String mother, String address1, String address2, String imagePath) {
        String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, sname);
            ps.setString(3, date);
            ps.setString(4, gender);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setString(7, father);
            ps.setString(8, mother);
            ps.setString(9, address1);
            ps.setString(10, address2);
            ps.setString(11, imagePath);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New student added successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //email already exist
    public boolean isEmailExist(String email) {
        try {
            ps = con.prepareStatement("select * from student where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // phone number is already exist
    public boolean isPhoneExist(String phone) {
        try {
            ps = con.prepareStatement("select * from student where phone=?");
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("select * from student where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    //fetch the all students form database
    public void getStudentValue(JTable table, String searchValue) {
        String sql = "select * from student where concat(id,name,email,phone)like ? order by id asc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[11];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                row[8] = rs.getString(9);
                row[9] = rs.getString(10);
                row[10] = rs.getString(11);
                model.addRow(row);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    //upadate student values
    public void update(int id, String sname, String date, String gender, String email, String phone, String father, String mother, String address1, String address2, String imagePath)
    {
        String sql="update student set name=?,date_of_birth=?,gender=?,email=?,phone=?,father_name=?,mother_name=?,address1=?,address2=?,image_path=? where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sname);
            ps.setString(2, date);
            ps.setString(3, gender);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, father);
            ps.setString(7, mother);
            ps.setString(8, address1);
            ps.setString(9, address2);
            ps.setString(10, imagePath);
            ps.setInt(11, id);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New student updated successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //student data delete
    public void delete(int id)
    {
        int yesOrNo=JOptionPane.showConfirmDialog(null, "Course and score will also be deleted","Student Delete",JOptionPane.OK_CANCEL_OPTION,0);
        if(yesOrNo == JOptionPane.OK_OPTION)
        {
            try
            {
                ps=con.prepareStatement("delete from student where id=?");
                ps.setInt(1, id);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null, "student deleted successfully");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
