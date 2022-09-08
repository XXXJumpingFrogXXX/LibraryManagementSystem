package com.view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.ReaderDao;
import com.dao.UserDao;
import com.model.Book;
import com.model.User;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

public class UserModifyInterFrm extends JInternalFrame {
	private JTextField s_userIDTxt;
	private JTable userTable;
	private JTextField userIDTxt;
	private JTextField userFineTxt;
	private JTextField userDayNumTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserModifyInterFrm frame = new UserModifyInterFrm();
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
	public UserModifyInterFrm() {
		setFrameIcon(new ImageIcon(UserModifyInterFrm.class.getResource("/img/base.png")));
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setIconifiable(true);
		setClosable(true);
		setTitle("\u7528\u6237\u4FEE\u6539\u754C\u9762");
		setBounds(100, 100, 696, 672);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 16));
		
		s_userIDTxt = new JTextField();
		s_userIDTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(UserModifyInterFrm.class.getResource("/img/search.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7528\u6237\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(126)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_userIDTxt, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
							.addGap(35)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
							.addGap(97))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
									.addGap(4))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))))
					.addGap(143))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(s_userIDTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		userIDTxt = new JTextField();
		userIDTxt.setEditable(false);
		userIDTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u7F5A\u6B3E\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		
		userFineTxt = new JTextField();
		userFineTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u53EF\u501F\u9605\u5929\u6570\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		
		userDayNumTxt = new JTextField();
		userDayNumTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
		btnNewButton_1.setIcon(new ImageIcon(UserModifyInterFrm.class.getResource("/img/\u4FEE\u6539.png")));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(UserModifyInterFrm.class.getResource("/img/\u5220\u9664.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(userDayNumTxt)
									.addGap(158))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userIDTxt, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
									.addGap(28)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userFineTxt, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(61)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
							.addGap(80)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE)
							.addGap(58)))
					.addGap(60))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(userIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(userFineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(userDayNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		userTable = new JTable();
		userTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				userTableMousePressed(e);
			}
		});
		userTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237ID", "\u7528\u6237\u7F5A\u6B3E", "\u53EF\u501F\u9605\u5929\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(userTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new User());
	}
	
	
	
	private void userDeleteActionEvent(ActionEvent evt) {
		String id=userIDTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=userDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new User());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "删除失败");
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
	}
	
	private void userUpdateActionEvent(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=userIDTxt.getText();
		String fine=userFineTxt.getText();
		String dayNum=userDayNumTxt.getText();
		
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(fine)) {
			JOptionPane.showMessageDialog(null, "罚款不能为空");
			return;
		}
		if(StringUtil.isEmpty(dayNum)) {
			JOptionPane.showMessageDialog(null, "天数不能为空");
			return;
		}
		
		User user=new User(id,Integer.parseInt(fine),Integer.parseInt(dayNum));
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=userDao.update(con, user);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new User());
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "修改失败");
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

	private void resetValue() {
		// TODO 自动生成的方法存根
		userIDTxt.setText("");
		userFineTxt.setText("");
		userDayNumTxt.setText("");
	}
	
	private void userTableMousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int row=userTable.getSelectedRow();
		userIDTxt.setText((String)userTable.getValueAt(row,0));
		userFineTxt.setText(String.valueOf(userTable.getValueAt(row,1)));
		userDayNumTxt.setText(String.valueOf(userTable.getValueAt(row,2)));

	}

	private void userSearchActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String s_userID=this.s_userIDTxt.getText();
		User user=new User();
		user.setUserID(s_userID);
		this.fillTable(user);
	}
	
	private void fillTable(User user) {
		DefaultTableModel dtm=(DefaultTableModel) userTable.getModel();
		dtm.setRowCount(0); //设置成0行 先将表格清空
		Connection con=null;


		try {
			con=dbUtil.getCon();
			ResultSet rs=userDao.list(con, user);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("userID"));
				v.add(rs.getInt("fine"));
				v.add(rs.getInt("dayNum"));
				dtm.addRow(v);
			}
			
		}catch(Exception e) {
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
}