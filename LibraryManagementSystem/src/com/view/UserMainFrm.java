package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.model.User;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;

public class UserMainFrm extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainFrm frame = new UserMainFrm();
					frame.setVisible(true);
					System.out.println(UserLogOnInterFrm.logInUser.getUserID());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserMainFrm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserMainFrm.class.getResource("/img/\u56FE\u4E66\u9986.png")));
		setTitle("\u7528\u6237\u754C\u9762");
		setBounds(500, 150, 683, 697);// 708, 709
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JDesktopPane UserTable = new JDesktopPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(UserTable, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(UserTable, GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UserMainFrm.class.getResource("/img/logOnBg1.jpg")));
		lblNewLabel.setBounds(0, 0, 667, 636);
		UserTable.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu.setFont(new Font("ËÎÌו", Font.BOLD, 16));
		mnNewMenu.setIcon(new ImageIcon(UserMainFrm.class.getResource("/img/\u7528\u6237.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7ED1\u5B9A\u8BFB\u8005\u7BA1\u7406");
		mntmNewMenuItem.setIcon(new ImageIcon(UserMainFrm.class.getResource("/img/\u767B\u5F551.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderManageInterFrm readerManageInterFrm=new ReaderManageInterFrm();
				readerManageInterFrm.setVisible(true);
				UserTable.add(readerManageInterFrm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_1.setFont(new Font("ËÎÌו", Font.BOLD, 16));
		mnNewMenu_1.setIcon(new ImageIcon(UserMainFrm.class.getResource("/img/bookManager.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u501F\u4E66");
		mntmNewMenuItem_2.setIcon(new ImageIcon(UserMainFrm.class.getResource("/img/\u501F\u4E66.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookBorrowInterFrm bookBorrowInterFrm=new BookBorrowInterFrm();
				bookBorrowInterFrm.setVisible(true);
				UserTable.add(bookBorrowInterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u8FD8\u4E66");
		mntmNewMenuItem_3.setIcon(new ImageIcon(UserMainFrm.class.getResource("/img/\u8FD8\u4E66.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookReturnInterFrm bookReturnInterFrm=new BookReturnInterFrm();
				bookReturnInterFrm.setVisible(true);
				UserTable.add(bookReturnInterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

	}
}