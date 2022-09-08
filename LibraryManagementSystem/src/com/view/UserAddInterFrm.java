package com.view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.dao.UserDao;
import com.model.User;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class UserAddInterFrm extends JInternalFrame {
	private JTextField userIDTxt;
	private JTextField userPsdTxt;
	private JTextField fineTxt;
	private JTextField dayNumTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddInterFrm frame = new UserAddInterFrm();
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
	public UserAddInterFrm() {
		setFrameIcon(new ImageIcon(UserAddInterFrm.class.getResource("/img/\u7528\u6237\u5F69\u56FE.png")));
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setClosable(true);
		setIconifiable(true);
		setResizable(true);
		setTitle("\u7528\u6237\u6DFB\u52A0\u754C\u9762");
		setBounds(0, 100, 612, 340);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/img/userName.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_1.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/img/password.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u539F\u59CB\u6B20\u6B3E\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_2.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/img/exit.png")));
		
		userIDTxt = new JTextField();
		userIDTxt.setColumns(10);
		
		userPsdTxt = new JTextField();
		userPsdTxt.setColumns(10);
		
		fineTxt = new JTextField();
		fineTxt.setEditable(false);
		fineTxt.setText("0");
		fineTxt.setColumns(10);
		
		JLabel Lable = new JLabel("\u53EF\u501F\u9605\u5929\u6570\uFF1A");
		Lable.setFont(new Font("宋体", Font.BOLD, 14));
		Lable.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/img/bookManager.png")));
		
		dayNumTxt = new JTextField();
		dayNumTxt.setEditable(false);
		dayNumTxt.setText("30");
		dayNumTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/img/\u6DFB\u52A0.png")));
		btnNewButton.setFont(new Font("幼圆", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("幼圆", Font.BOLD, 16));
		btnNewButton_1.setIcon(new ImageIcon(UserAddInterFrm.class.getResource("/img/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(fineTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userIDTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(32)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userPsdTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(Lable)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dayNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(14))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(139)
							.addComponent(btnNewButton)
							.addGap(121)
							.addComponent(btnNewButton_1)))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(userPsdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(fineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Lable, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void userAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String userID=this.userIDTxt.getText();
		String userPsd=this.userPsdTxt.getText();
		String fine=this.fineTxt.getText();
		String dayNum=this.dayNumTxt.getText();


		if(StringUtil.isEmpty(userID)) {
			JOptionPane.showMessageDialog(null, "ID不能为空！");
			return;
		}
		if(StringUtil.isEmpty(userPsd)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		if(StringUtil.isEmpty(fine)) {
			JOptionPane.showMessageDialog(null, "罚款不能为空！");
			return;
		}
		if(StringUtil.isEmpty(dayNum)) {
			JOptionPane.showMessageDialog(null, "可借阅天数不能为空！");
			return;
		}
		
		User user=new User(userID,userPsd,Integer.parseInt(fine),Integer.parseInt(dayNum));
		Connection con=null;

		try {
			con=dbUtil.getCon();
			int n=userDao.add(con, user);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "用户注册成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "用户注册失败！");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "用户失败！");
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
		this.userIDTxt.setText("");
		this.userPsdTxt.setText("");
	}

}
