/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author anusha
 */
public class AddDriver extends JFrame implements ActionListener{
    
    JButton addButton, cancel;
    JTextField tfage, tfcompany, tfmodel,tfname, tflocation;
    JComboBox agecombo, availablecombo, typecombo, gendercombo;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        JLabel lblroomno = new JLabel("Name");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblroomno.setBounds(60,70,120,30);
        add(lblroomno);
        
        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblage.setBounds(60,110,120,30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        JLabel lblclean = new JLabel("Gender");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblclean.setBounds(60,150,120,30);
        add(lblclean);
        
        String cleanOptions[] = {"Male", "Female"};
        gendercombo = new JComboBox(cleanOptions);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lblprice = new JLabel("Car Company");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblprice.setBounds(60,190,120,30);
        add(lblprice);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);
        
        JLabel lbltype = new JLabel("Car Model");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbltype.setBounds(60,230,120,30);
        add(lbltype);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("Availabe");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblavailable.setBounds(60,270,120,30);
        add(lblavailable);
        
        String driverOptions[] = {"Available", "Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        addButton = new JButton("Add Driver");
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.BLACK);
        addButton.setBounds(60,370,130,30);
        addButton.addActionListener(this);
        add(addButton);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(300,200,980,470);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addButton)
        {
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location= tflocation.getText();
            
            try{
                Conn c= new Conn();
                String str = "insert into driver values ('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+brand+"', '"+available+"', '"+location+"')";
                
                c.s.execute(str);
                
                JOptionPane.showMessageDialog(null, "New driver added successfully!");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new AddDriver();
    }
}
