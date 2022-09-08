package com.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.ReaderDao;
import com.model.Book;
import com.model.Reader;
import com.model.User;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ReaderManageInterFrm extends JInternalFrame {
	private JTextField userIDtxt;
	private JTextField idNumTxt;
	private JTextField nameTxt;
	private JTextField telnumTxt;
	private JTextField birthdayTxt;
	private JTable readerTable;
	
	private DbUtil dbUtil=new DbUtil();
	private ReaderDao readerDao=new ReaderDao();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JRadioButton male = new JRadioButton("\u7537");
	JRadioButton female = new JRadioButton("\u5973");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderManageInterFrm frame = new ReaderManageInterFrm();
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
	public ReaderManageInterFrm() {
		setFrameIcon(new ImageIcon(ReaderManageInterFrm.class.getResource("/img/\u767B\u5F551.png")));
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
		setTitle("\u7ED1\u5B9A\u8BFB\u8005\u7BA1\u7406\u754C\u9762");
		setBounds(12, 100, 680, 519);
		
		JLabel lblNewLabel = new JLabel("\u60A8\u7684\u7528\u6237ID\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		
		userIDtxt = new JTextField();
		userIDtxt.setColumns(10);
		userIDtxt.setText(UserLogOnInterFrm.logInUser.getUserID());
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8BFB\u8005\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userIDtxt, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(scrollPane, Alignment.TRAILING)
							.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userIDtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		readerTable = new JTable();
		readerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				readerTableMousePressed(e);
			}
		});
		readerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8EAB\u4EFD\u8BC1\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u624B\u673A\u53F7", "\u51FA\u751F\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		readerTable.getColumnModel().getColumn(1).setPreferredWidth(40);
		readerTable.getColumnModel().getColumn(2).setPreferredWidth(39);
		readerTable.getColumnModel().getColumn(3).setPreferredWidth(68);
		scrollPane.setViewportView(readerTable);
		
		JLabel lblNewLabel_1 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		idNumTxt = new JTextField();
		idNumTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		
		telnumTxt = new JTextField();
		telnumTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		
		birthdayTxt = new JTextField();
		birthdayTxt.setFont(new Font("宋体", Font.BOLD, 12));
		birthdayTxt.setText("\u8BF7\u6309\u7167\u201C1900-01-01\u201D\u7684\u683C\u5F0F\u586B\u5199");
		birthdayTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerAddActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ReaderManageInterFrm.class.getResource("/img/\u6DFB\u52A0.png")));
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerUpdateActionEvent(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ReaderManageInterFrm.class.getResource("/img/\u4FEE\u6539.png")));
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerDeleteActionEvent(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(ReaderManageInterFrm.class.getResource("/img/\u5220\u9664.png")));
		
		JButton btnNewButton_4 = new JButton("\u91CD\u7F6E");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(ReaderManageInterFrm.class.getResource("/img/\u91CD\u7F6E.png")));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 12));
		

		buttonGroup_1.add(male);
		buttonGroup_1.add(female);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addGap(18)
									.addComponent(telnumTxt))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idNumTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addGap(30)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(17))
								.addComponent(lblNewLabel_5))
							.addGap(17))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(male)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(female)
									.addGap(24))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(birthdayTxt, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(lblNewLabel_6)
							.addContainerGap(67, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addComponent(btnNewButton_4)
							.addGap(34)
							.addComponent(btnNewButton_3)
							.addGap(99))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(male)
						.addComponent(female))
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(telnumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(birthdayTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_3))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		male.setFont(new Font("宋体", Font.BOLD, 12));
		female.setFont(new Font("宋体", Font.BOLD, 12));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(UserLogOnInterFrm.logInUser);
	}
	
	
	
	private void readerDeleteActionEvent(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String IDNum=idNumTxt.getText();
		if(StringUtil.isEmpty(IDNum)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=readerDao.delete(con, IDNum);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(UserLogOnInterFrm.logInUser);
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

	private void readerUpdateActionEvent(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String idNum=idNumTxt.getText();
		String name=nameTxt.getText();
		String gender="";
		String telnum=telnumTxt.getText();
		String birthday=birthdayTxt.getText();
		
		if(male.isSelected()) {
			gender="男";
		}else if(female.isSelected()) {
			gender="女";
		}
		
		if(StringUtil.isEmpty(idNum)) {
			JOptionPane.showMessageDialog(null, "身份证号不能为空");
			return;
		}
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}
		if(StringUtil.isEmpty(gender)) {
			JOptionPane.showMessageDialog(null, "性别不能为空");
			return;
		}
		if(StringUtil.isEmpty(telnum)) {
			JOptionPane.showMessageDialog(null, "手机号不能为空");
			return;
		}
		if(StringUtil.isEmpty(birthday)) {
			JOptionPane.showMessageDialog(null, "生日不能为空");
			return;
		}
		
		Reader reader=new Reader(idNum,name,gender,telnum,birthday,UserLogOnInterFrm.logInUser.getUserID());
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=readerDao.update(con, reader);
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

	private void readerTableMousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int row=readerTable.getSelectedRow();

		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) readerTable.getValueAt(row,4);
		String birthday = ft.format(date);
		
		this.idNumTxt.setText(String.valueOf(readerTable.getValueAt(row,0)));
		this.nameTxt.setText(String.valueOf(readerTable.getValueAt(row,1)));
		if(String.valueOf(readerTable.getValueAt(row,2))=="男") {
			male.setSelected(true);
		}else if((String.valueOf(readerTable.getValueAt(row,2))=="女")) {
			female.setSelected(true);
		}
		this.telnumTxt.setText(String.valueOf(readerTable.getValueAt(row,3)));
		this.birthdayTxt.setText(birthday);
		
	}

	private void readerAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String idNum=this.idNumTxt.getText();
		String name=this.nameTxt.getText();
		String gender="";
		String telnum=this.telnumTxt.getText();
		String birthday=this.birthdayTxt.getText();
		if(male.isSelected()) {
			gender="男";
		}else if(female.isSelected()) {
			gender="女";
		}
		if(StringUtil.isEmpty(idNum)) {
			JOptionPane.showMessageDialog(null, "身份证号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(gender)) {
			JOptionPane.showMessageDialog(null, "性别不能为空！");
			return;
		}
		if(StringUtil.isEmpty(telnum)) {
			JOptionPane.showMessageDialog(null, "手机号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(birthday)) {
			JOptionPane.showMessageDialog(null, "出生日期不能为空！");
			return;
		}
		
		if(idNum.length()!=18) {
			JOptionPane.showMessageDialog(null, "身份证号输入不合法");
			return;
		}
		
		if(telnum.length()!=11) {
			JOptionPane.showMessageDialog(null, "手机号输入不合法");
			return;
		}
		
		if(birthday.length()!=10) {
			JOptionPane.showMessageDialog(null, "出生日期输入不合法");
			return;
		}
		
		Reader reader=new Reader(idNum,name,gender,telnum,birthday,UserLogOnInterFrm.logInUser.getUserID());
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=readerDao.add(con, reader);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "读者绑定成功！");
				resetValue();
				this.fillTable(UserLogOnInterFrm.logInUser);
			}else {
				JOptionPane.showMessageDialog(null, "读者绑定失败！");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "读者绑定失败！");
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
		this.resetValue();
	}

	private void resetValue() {
		// TODO 自动生成的方法存根
		this.idNumTxt.setText("");
		this.nameTxt.setText("");
		male.setSelected(false);
		female.setSelected(false);
		this.telnumTxt.setText("");
		this.birthdayTxt.setText("");
	}

	private void fillTable(User user) {
		DefaultTableModel dtm=(DefaultTableModel) readerTable.getModel();
		dtm.setRowCount(0); //设置成0行 先将表格清空
		Connection con=null;

		try {
			con=dbUtil.getCon();
			ResultSet rs=readerDao.list(con, user);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("IDnum"));
				v.add(rs.getString("name"));
				v.add(rs.getString("gender"));
				v.add(rs.getString("telnum"));
				v.add(rs.getDate("birthday"));
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