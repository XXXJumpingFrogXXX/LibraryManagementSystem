package com.view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.dao.AdminDao;
import com.model.Admin;
import com.model.Book;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AdminAddInterFrm extends JInternalFrame {
	private JTextField adminIDTxt;
	private JTextField adminPsdTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private AdminDao adminDao=new AdminDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddInterFrm frame = new AdminAddInterFrm();
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
	public AdminAddInterFrm() {
		setFrameIcon(new ImageIcon(AdminAddInterFrm.class.getResource("/img/\u7BA1\u7406\u5458.png")));
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setTitle("\u7BA1\u7406\u5458\u6DFB\u52A0\u754C\u9762");
		setClosable(true);
		setIconifiable(true);
		setResizable(true);
		setBounds(12, 100, 583, 413);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458ID\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel.setIcon(new ImageIcon(AdminAddInterFrm.class.getResource("/img/userName.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setIcon(new ImageIcon(AdminAddInterFrm.class.getResource("/img/password.png")));
		
		adminIDTxt = new JTextField();
		adminIDTxt.setColumns(10);
		
		adminPsdTxt = new JTextField();
		adminPsdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AdminAddInterFrm.class.getResource("/img/\u6DFB\u52A0.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_1.setIcon(new ImageIcon(AdminAddInterFrm.class.getResource("/img/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(adminPsdTxt)
								.addComponent(adminIDTxt, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
							.addGap(45))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(223))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(114)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(adminIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(adminPsdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void adminAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String adminID=this.adminIDTxt.getText();
		String adminPsd=this.adminPsdTxt.getText();


		if(StringUtil.isEmpty(adminID)) {
			JOptionPane.showMessageDialog(null, "ID不能为空！");
			return;
		}
		if(StringUtil.isEmpty(adminPsd)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		
		Admin admin=new Admin(adminID,adminPsd);
		Connection con=null;

		try {
			con=dbUtil.getCon();
			int n=adminDao.add(con, admin);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "管理员添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "管理员添加失败！");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "管理员添加失败！");
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	private void resetValueActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		resetValue();
	}

	private void resetValue() {
		// TODO 自动生成的方法存根
		this.adminIDTxt.setText("");
		this.adminPsdTxt.setText("");
	}

}
