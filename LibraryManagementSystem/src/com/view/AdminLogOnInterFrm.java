package com.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;


import com.dao.AdminDao;
import com.model.Admin;
import com.util.DbUtil;
import com.util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AdminLogOnInterFrm extends JInternalFrame {
	private JTextField adminIDTxt;
	private JPasswordField adminPsdTxt;
	private DbUtil dbUtil=new DbUtil();
	private AdminDao adminDao=new AdminDao();
	private JTextField captchaTxt;
	private JTextField adminCaptchaTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogOnInterFrm frame = new AdminLogOnInterFrm();
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
	public AdminLogOnInterFrm() {
		setFrameIcon(new ImageIcon(AdminLogOnInterFrm.class.getResource("/img/\u7BA1\u7406\u5458.png")));
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 467, 315);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458ID\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel.setIcon(new ImageIcon(AdminLogOnInterFrm.class.getResource("/img/userName.png")));
		
		adminIDTxt = new JTextField();
		adminIDTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_1.setIcon(new ImageIcon(AdminLogOnInterFrm.class.getResource("/img/password.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5927\u6E2F\u56FE\u4E66\u9986\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 20));
		lblNewLabel_2.setIcon(new ImageIcon(AdminLogOnInterFrm.class.getResource("/img/bookManager.png")));
		
		adminPsdTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon(AdminLogOnInterFrm.class.getResource("/img/\u767B\u5F55.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 13));
		btnNewButton_1.setIcon(new ImageIcon(AdminLogOnInterFrm.class.getResource("/img/\u91CD\u7F6E.png")));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u8BF7\u8F93\u5165\u9A8C\u8BC1\u7801\uFF1A");
		lblNewLabel_1_1.setIcon(null);
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		JButton btnNewButton_2 = new JButton("\u83B7\u53D6\u9A8C\u8BC1\u7801");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String captcha=StringUtil.getRandomCode();
				captchaTxt.setText(captcha);
			}
		});
		btnNewButton_2.setFont(new Font("幼圆", Font.BOLD, 14));
		
		captchaTxt = new JTextField();
		captchaTxt.setEditable(false);
		captchaTxt.setColumns(10);
		
		adminCaptchaTxt = new JTextField();
		adminCaptchaTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(adminCaptchaTxt, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
								.addComponent(captchaTxt, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addGap(36))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(adminPsdTxt, Alignment.LEADING)
									.addComponent(adminIDTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
								.addContainerGap()))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel_2)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(adminPsdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2)
						.addComponent(captchaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(adminCaptchaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void loginActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String adminID=this.adminIDTxt.getText();
		String adminPsd=new String(this.adminPsdTxt.getPassword());
		String captchaInput=this.adminCaptchaTxt.getText();
		
		if(StringUtil.isEmpty(adminID)) {
			JOptionPane.showMessageDialog(null, "用户ID不能为空");
			return;
		}
		if(StringUtil.isEmpty(adminPsd)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(captchaInput)||StringUtil.isEmpty(captchaTxt.getText())) {
			JOptionPane.showMessageDialog(null, "验证码不能为空");
			return;
		}
		
		Admin admin=new Admin(adminID,adminPsd);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			Admin currentAdmin=adminDao.login(con,admin);
			if(currentAdmin!=null&&captchaInput.equals(captchaTxt.getText())) {
				JOptionPane.showMessageDialog(null, "登录成功");
				dispose();//销毁当前窗体
				new AdminMainFrm().setVisible(true);
			}else if(!captchaInput.equals(captchaTxt.getText())) {
				JOptionPane.showMessageDialog(null, "验证码错误");
			}else {
				JOptionPane.showMessageDialog(null, "用户名或者密码错误");
			}
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}

	private void resetValueActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.adminIDTxt.setText("");
		this.adminPsdTxt.setText("");
	}
}