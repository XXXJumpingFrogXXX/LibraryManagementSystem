package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainFrm extends JFrame {
	JDesktopPane AdminTable=null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainFrm frame = new AdminMainFrm();
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
	public AdminMainFrm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMainFrm.class.getResource("/img/\u56FE\u4E66\u9986.png")));
		setTitle("\u7BA1\u7406\u5458\u754C\u9762");
		setBounds(500, 150, 709, 702);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/bookManager.png")));
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				AdminTable.add(bookAddInterFrm);
			}
		});
		
		mntmNewMenuItem.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/add.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookModifyInterFrm bookModifyInterFrm=new BookModifyInterFrm();
				bookModifyInterFrm.setVisible(true);
				AdminTable.add(bookModifyInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/modify.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/\u7528\u6237\u5F69\u56FE.png")));
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u7528\u6237\u7EF4\u62A4");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserModifyInterFrm adminAddInterFrm=new UserModifyInterFrm();
				adminAddInterFrm.setVisible(true);
				AdminTable.add(adminAddInterFrm);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/base.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u7BA1\u7406\u5458\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/modify.png")));
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u7BA1\u7406\u5458\u6DFB\u52A0");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminAddInterFrm adminAddInterFrm=new AdminAddInterFrm();
				adminAddInterFrm.setVisible(true);
				AdminTable.add(adminAddInterFrm);
			}
		});
		
		mntmNewMenuItem_4.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/add.png")));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("\u7535\u8BDD\u67E5\u8BE2");
		mnNewMenu_3.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/\u67E5\u627E.png")));
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5404\u85CF\u4E66\u5BA4\u7535\u8BDD");
		mntmNewMenuItem_2.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/bookTypeManager.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibTelnumSearchInterFrm libTelnumSearchInterFrm=new LibTelnumSearchInterFrm();
				libTelnumSearchInterFrm.setVisible(true);
				AdminTable.add(libTelnumSearchInterFrm);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		AdminTable = new JDesktopPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(AdminTable, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(AdminTable, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(290, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AdminMainFrm.class.getResource("/img/logOnBg1.jpg")));
		lblNewLabel.setBounds(0, -17, 701, 667);
		AdminTable.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);

	}
}
