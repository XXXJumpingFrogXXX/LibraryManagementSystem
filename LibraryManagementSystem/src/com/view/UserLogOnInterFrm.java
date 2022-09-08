package com.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.dao.AdminDao;
import com.dao.UserDao;
import com.model.Admin;
import com.model.User;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class UserLogOnInterFrm extends JInternalFrame {
	private JTextField userIDTxt;
	private JPasswordField userPsdTxt;
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	public static User logInUser;
	private JTextField userCaptchaTxt;
	private JTextField captchaTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogOnInterFrm frame = new UserLogOnInterFrm();
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
	public UserLogOnInterFrm() {
		setFrameIcon(new ImageIcon(UserLogOnInterFrm.class.getResource("/img/\u7528\u6237.png")));
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setTitle("\u7528\u6237\u767B\u5F55");
		setBounds(100, 100, 461, 312);
		
		JLabel lblNewLabel = new JLabel("\u5927\u6E2F\u56FE\u4E66\u9986\u7528\u6237\u501F\u9605\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(UserLogOnInterFrm.class.getResource("/img/bookManager.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_1.setIcon(new ImageIcon(UserLogOnInterFrm.class.getResource("/img/userName.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_2.setIcon(new ImageIcon(UserLogOnInterFrm.class.getResource("/img/password.png")));
		
		userIDTxt = new JTextField();
		userIDTxt.setColumns(10);
		
		userPsdTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UserLogOnInterFrm.class.getResource("/img/\u767B\u5F55.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 13));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 13));
		btnNewButton_1.setIcon(new ImageIcon(UserLogOnInterFrm.class.getResource("/img/\u91CD\u7F6E.png")));
		
		userCaptchaTxt = new JTextField();
		userCaptchaTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u9A8C\u8BC1\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(47, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, Alignment.TRAILING)
								.addComponent(lblNewLabel_1, Alignment.TRAILING)
								.addComponent(lblNewLabel_3, Alignment.TRAILING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(userCaptchaTxt, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(captchaTxt, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_2))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(userPsdTxt, Alignment.LEADING)
									.addComponent(userIDTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addComponent(lblNewLabel)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(userPsdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(userCaptchaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(captchaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(304))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	private void loginActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String userID=this.userIDTxt.getText();
		String userPsd=new String(this.userPsdTxt.getPassword());
		String captchaInput=this.userCaptchaTxt.getText();
		
		if(StringUtil.isEmpty(userID)) {
			JOptionPane.showMessageDialog(null, "用户ID不能为空");
			return;
		}
		if(StringUtil.isEmpty(userPsd)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(captchaInput)||StringUtil.isEmpty(captchaTxt.getText())) {
			JOptionPane.showMessageDialog(null, "验证码不能为空");
			return;
		}
		
		User user=new User(userID,userPsd);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con,user);		
			if(currentUser!=null&&captchaInput.equals(captchaTxt.getText())) {
				JOptionPane.showMessageDialog(null, "登录成功");
				dispose();//销毁当前窗体
				UserMainFrm userMainFrm=new UserMainFrm();
				logInUser=user;
				//userDao.confirmFine(con,logInUser);
				userMainFrm.setVisible(true);
			}else if(!captchaInput.equals(captchaTxt.getText())){
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
		this.userIDTxt.setText("");
		this.userPsdTxt.setText("");
		this.userCaptchaTxt.setText("");
	}
}
