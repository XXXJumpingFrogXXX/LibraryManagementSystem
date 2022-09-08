package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LogOnFrm extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogOnFrm.class.getResource("/img/\u56FE\u4E66\u9986.png")));
		setTitle("\u6EE8\u6D77\u65B0\u533A\u56FE\u4E66\u9986\uFF08\u5927\u6E2F\u9986\u533A\uFF09\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(500, 150, 646, 646);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane table = new JDesktopPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u767B\u5F55\u754C\u9762\u80CC\u666F.jpg")));
		lblNewLabel.setBounds(0, 0, 640, 592);
		table.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u767B\u5F55");
		mnNewMenu.setFont(new Font("свт╡", Font.BOLD, 17));
		mnNewMenu.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u767B\u5F552.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7528\u6237\u767B\u5F55");
		mntmNewMenuItem_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u7528\u6237.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogOnInterFrm userLogOnInterFrm=new UserLogOnInterFrm();
				userLogOnInterFrm.setVisible(true);
				table.add(userLogOnInterFrm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u7BA1\u7406\u5458\u767B\u5F55");
		mntmNewMenuItem_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u7BA1\u7406\u5458.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogOnInterFrm adminLogOnInterFrm=new AdminLogOnInterFrm();
				adminLogOnInterFrm.setVisible(true);
				table.add(adminLogOnInterFrm);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u7528\u6237");
		mnNewMenu_1.setFont(new Font("свт╡", Font.BOLD, 17));
		mnNewMenu_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u7528\u6237\u5F69\u56FE.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u7528\u6237\u6CE8\u518C");
		mntmNewMenuItem_3.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/userName.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAddInterFrm userAddInterFrm=new UserAddInterFrm();
				userAddInterFrm.setVisible(true);
				table.add(userAddInterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u5173\u4E8E");
		mnNewMenu_2.setFont(new Font("свт╡", Font.BOLD, 17));
		mnNewMenu_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/about.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7CFB\u7EDF\u76F8\u5173\u4FE1\u606F");
		mntmNewMenuItem.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u5173\u4E8E.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntroductionInterFrm introductionInterFrm=new IntroductionInterFrm();
				introductionInterFrm.setVisible(true);
				table.add(introductionInterFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u56FE\u4E66\u9986\u501F\u4E66\u89C4\u5219");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RuleInterFrm ruleInterFrm=new RuleInterFrm();
				ruleInterFrm.setVisible(true);
				table.add(ruleInterFrm);
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/me.png")));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("\u9986\u5185\u7981\u6B62");
		mnNewMenu_3.setFont(new Font("свт╡", Font.BOLD, 17));
		mnNewMenu_3.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/exit.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u7981\u6B62\u643A\u5E26\u996E\u6599");
		mntmNewMenuItem_5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		mntmNewMenuItem_5.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u7981\u6B62\u559D\u996E\u6599.png")));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u7981\u6B62\u5438\u70DF");
		mntmNewMenuItem_6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		mntmNewMenuItem_6.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u7981\u6B62\u5438\u70DF1.png")));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u7981\u6B62\u55A7\u54D7");
		mntmNewMenuItem_7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		mntmNewMenuItem_7.setIcon(new ImageIcon(LogOnFrm.class.getResource("/img/\u7981\u6B62\u55A7\u54D7.png")));
		mnNewMenu_3.add(mntmNewMenuItem_7);

	}
}
