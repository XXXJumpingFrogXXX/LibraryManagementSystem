package com.view;

import java.awt.Container;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.dao.BookDao;
import com.dao.UserDao;
import com.model.Book;
import com.model.BookBorrow;
import com.model.User;
import com.util.DbUtil;
import com.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookBorrowInterFrm extends JInternalFrame {
	private JTextField bookTitleTxt;
	private JTable bookTable;
	
	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao();
	private UserDao userDao=new UserDao();
	private JTextField bookIDTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookBorrowInterFrm frame = new BookBorrowInterFrm();
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
	public BookBorrowInterFrm() {
		setFrameIcon(new ImageIcon(BookBorrowInterFrm.class.getResource("/img/\u501F\u4E66.png")));
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		setTitle("\u8BFB\u8005\u501F\u4E66\u754C\u9762");
		setBounds(12, 100, 689, 514);
		
		JLabel lblNewLabel = new JLabel("\u60A8\u6240\u8981\u501F\u9605\u7684\u56FE\u4E66\u540D\u79F0\u662F\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		bookTitleTxt = new JTextField();
		bookTitleTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookBorrowInterFrm.class.getResource("/img/search.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u501F\u9605");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookBorrowActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_1.setIcon(new ImageIcon(BookBorrowInterFrm.class.getResource("/img/\u501F\u4E66.png")));
		
		bookIDTxt = new JTextField();
		bookIDTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTitleTxt, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
									.addGap(32)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(bookIDTxt, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(175)
									.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(225)))))
					.addGap(57))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(bookTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton))
						.addComponent(lblNewLabel))
					.addGap(33)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bookIDTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66ID", "\u56FE\u4E66\u540D\u79F0", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u56FE\u4E66\u73B0\u6709\u6570\u91CF", "\u653E\u7F6E\u697C\u5C42", "\u653E\u7F6E\u623F\u95F4", "\u653E\u7F6E\u4E66\u67B6"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(53);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(74);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(48);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(87);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Book());
	}
	
	private void bookBorrowActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		int bookID=Integer.parseInt(bookIDTxt.getText());
		if(StringUtil.isEmpty(title)) {
			JOptionPane.showMessageDialog(null, "请选择要查找的图书");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要借走该图书吗？");

		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int borrowNum=bookDao.borrow(con,bookID,UserLogOnInterFrm.logInUser);
				int fine=userDao.findFine(con,UserLogOnInterFrm.logInUser);
				if(borrowNum==1&&fine==0) {
					JOptionPane.showMessageDialog(null, "借阅成功");
				}else if(fine>0) {
					JOptionPane.showMessageDialog(null, "借阅失败,请找到图书馆管理员缴纳罚款后再借书");
				}else {
					JOptionPane.showMessageDialog(null, "借阅失败");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "借阅失败");
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
		else if(UserLogOnInterFrm.logInUser.getFine()>0) {
			JOptionPane.showMessageDialog(null, "缴纳罚款后方可借书");
		}
	}

	private void bookSearchActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Book book=new Book(this.bookTitleTxt.getText());
		this.fillTable(book);
	}

	private void bookTableMousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int row=bookTable.getSelectedRow();
		this.bookIDTxt.setText(String.valueOf(bookTable.getValueAt(row,0)));
		this.bookTitleTxt.setText(String.valueOf(bookTable.getValueAt(row,1)));
	}

	private void fillTable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); //设置成0行 先将表格清空
		Connection con=null;

		try {
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list1(con, book);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getInt("bookID"));
				v.add(rs.getString("title"));
				v.add(rs.getString("writer"));
				v.add(rs.getString("publisher"));
				v.add(rs.getInt("bookNum"));
				v.add(rs.getString("BookLib_floor"));
				v.add(rs.getString("BookLib_room"));
				v.add(rs.getString("BookLib_shelf"));
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
