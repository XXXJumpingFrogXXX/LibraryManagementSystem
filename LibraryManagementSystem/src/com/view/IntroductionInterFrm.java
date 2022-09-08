package com.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntroductionInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroductionInterFrm frame = new IntroductionInterFrm();
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
	public IntroductionInterFrm() {
		setFrameIcon(new ImageIcon(IntroductionInterFrm.class.getResource("/img/\u5173\u4E8E.png")));
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		setClosable(true);
		setIconifiable(true);
		setResizable(true);
		setTitle("\u5173\u4E8E");
		setBounds(12, 100, 648, 393);
		
		JLabel lblNewLabel = new JLabel("\u672C\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u76F8\u5173\u4FE1\u606F");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Cris from NKU");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(IntroductionInterFrm.class.getResource("/img/\u56FE\u4E66\u9986.png")));
		
		JLabel lblNewLabel_4 = new JLabel("\u300A\u6EE8\u6D77\u65B0\u533A\u56FE\u4E66\u9986\uFF08\u5927\u6E2F\u9986\u533A\uFF09\u8BFB\u8005\u501F\u9605\u89C4\u5219\u300B");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.BLUE);
		
		JLabel lblNewLabel_5 = new JLabel("\u6EE8\u6D77\u65B0\u533A\u56FE\u4E66\u9986\uFF08\u5927\u6E2F\u9986\u533A\uFF09\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF2.2.0");
		lblNewLabel_5.setFont(new Font("幼圆", Font.BOLD, 16));
		
		JLabel lblNewLabel_6 = new JLabel("\u300A\u9690\u79C1\u4FDD\u62A4\u6307\u5F15\u6458\u8981\u300B");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel lblNewLabel_7 = new JLabel("\u300A\u9690\u79C1\u4FDD\u62A4\u6307\u5F15\u300B");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel lblNewLabel_8 = new JLabel("Copyright 2021-2022 NKCS.All Rights Reserved.");
		lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(263)
							.addComponent(lblNewLabel_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_8)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addGap(18)
									.addComponent(lblNewLabel_7))
								.addComponent(lblNewLabel_4)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(228)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(189)
							.addComponent(lblNewLabel)))
					.addContainerGap(145, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(27)
					.addComponent(lblNewLabel_2)
					.addGap(48)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7))
					.addGap(18)
					.addComponent(lblNewLabel_8)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}