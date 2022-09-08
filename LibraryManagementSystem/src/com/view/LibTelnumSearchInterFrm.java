package com.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.model.User;
import com.util.DbUtil;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LibTelnumSearchInterFrm extends JInternalFrame {
	private JTextField telnumTxt;

	private JComboBox libBox = new JComboBox();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibTelnumSearchInterFrm frame = new LibTelnumSearchInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibTelnumSearchInterFrm() {
		setFrameIcon(new ImageIcon(LibTelnumSearchInterFrm.class.getResource("/img/bookTypeManager.png")));
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setIconifiable(true);
		setClosable(true);
		setTitle("\u85CF\u4E66\u5BA4\u7535\u8BDD\u67E5\u8BE2\u754C\u9762");
		setBounds(12, 100, 579, 411);
		
		JLabel lblNewLabel_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		telnumTxt = new JTextField();
		telnumTxt.setColumns(10);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(186)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(telnumTxt, 81, 81, 81))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(telnumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(274, Short.MAX_VALUE))
		);
		

		
		JLabel lblNewLabel = new JLabel("\u85CF\u4E66\u5BA4\uFF1A");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		libBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boxClickedActionPerformed(e);
			}
		});
		
		panel.add(libBox);
		getContentPane().setLayout(groupLayout);
		
		this.fillBox();
	}
	
	private void boxClickedActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String com=(String)libBox.getSelectedItem();
		switch (com){
        case "101":
        	telnumTxt.setText("63350001"); 
        	break;
        case "201":
        	telnumTxt.setText("63350002"); 
        	break;
        case "202":
        	telnumTxt.setText("63350003"); 
        	break;
        case "301":
        	telnumTxt.setText("63350004"); 
        	break;
        case "302":
        	telnumTxt.setText("63350005"); 
        	break;
        default:
        	break;
		}
	}

	private void fillBox() {
		libBox.addItem("-请选择-");
		libBox.addItem("101");
		libBox.addItem("201");
		libBox.addItem("202");
		libBox.addItem("301");
		libBox.addItem("302");
	}
}
