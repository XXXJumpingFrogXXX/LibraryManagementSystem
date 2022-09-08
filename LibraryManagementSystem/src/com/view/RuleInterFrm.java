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

public class RuleInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RuleInterFrm frame = new RuleInterFrm();
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
	public RuleInterFrm() {
		setFrameIcon(new ImageIcon(RuleInterFrm.class.getResource("/img/me.png")));
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		setTitle("\u501F\u9605\u89C4\u5219");
		setIconifiable(true);
		setClosable(true);
		setBounds(12, 100, 480, 343);
		
		JLabel lblNewLabel = new JLabel("\u6EE8\u6D77\u65B0\u533A\u56FE\u4E66\u9986\uFF08\u5927\u6E2F\u9986\u533A\uFF09\u8BFB\u8005\u501F\u9605\u89C4\u5219");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("1.\u6BCF\u4F4D\u8BFB\u8005\u4E0E\u4E00\u56FE\u4E66\u9986\u7528\u6237\u8D26\u53F7\u7ED1\u5B9A\u3002");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_2 = new JLabel("2.\u8BFB\u8005\u5E94\u9996\u5148\u6CE8\u518C\u7528\u6237\uFF0C\u4E4B\u540E\u8FDB\u5165\u7528\u6237\u754C\u9762\u501F\u4E66\u3002");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_2_1 = new JLabel("3.12\u5C81\u53CA\u5176\u4EE5\u4E0B\u7684\u8BFB\u8005\u4E0D\u5141\u8BB8\u6CE8\u518C\u72EC\u7ACB\u8D26\u53F7\u3002");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("4.12\u5C81\u53CA\u5176\u4EE5\u4E0B\u7684\u8BFB\u8005\u53EF\u4EE5\u4E0E\u81EA\u5DF1\u7684\u76D1\u62A4\u4EBA\u8D26\u53F7\u7ED1\u5B9A\u3002");
		lblNewLabel_2_1_1.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("5.\u8BFB\u8005\u7684\u521D\u59CB\u53EF\u501F\u9605\u5929\u6570\u4E3A30\u5929\u3002");
		lblNewLabel_2_1_1_1.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("6.\u82E5\u903E\u671F\u672A\u8FD8\uFF0C\u9986\u65B9\u5C06\u4E88\u4EE5\u7528\u6237100\u5143\u7684\u7F5A\u6B3E\u3002");
		lblNewLabel_2_1_1_1_1.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("7.\u6709\u7F5A\u6B3E\u7684\u7528\u6237\u5C06\u6CA1\u6709\u501F\u4E66\u7684\u6743\u9650\u3002");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("9.\u4E00\u4E66\u4E00\u4EBA\u751F\uFF0C\u4E00\u9986\u4E00\u4E16\u754C\u3002\u8BF7\u7231\u62A4\u6240\u501F\u56FE\u4E66\u4E0E\u56FE\u4E66\u9986\u73AF\u5883\u3002");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("宋体", Font.BOLD, 13));
		
		JLabel lblNewLabel_3 = new JLabel("\u4EE5\u4E0A\u89C4\u5219\u89E3\u91CA\u6743\u5F52\u4E8E\u9986\u65B9\u3002");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_1_1_1_1_1_2 = new JLabel("8.\u8BFB\u8005\u5728\u501F\u9605\u67D0\u4E00\u672C\u4E66\u540E\uFF0C\u5728\u8FD8\u4E66\u524D\u4E0D\u53EF\u4EE5\u518D\u501F\u540C\u6837\u7684\u4E66\u3002");
		lblNewLabel_2_1_1_1_1_1_2.setFont(new Font("宋体", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(10)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblNewLabel_3)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
