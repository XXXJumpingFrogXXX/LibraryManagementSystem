package com.view;

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

import com.dao.BookBorrowDao;
import com.model.Book;
import com.model.BookBorrow;
import com.util.DbUtil;
import com.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookReturnInterFrm extends JInternalFrame {
	private JTextField returnBookTxt;
	private JTable bookTable;

	private DbUtil dbUtil=new DbUtil();
	private BookBorrowDao bookBorrowDao=new BookBorrowDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReturnInterFrm frame = new BookReturnInterFrm();
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
	public BookReturnInterFrm() {
		setFrameIcon(new ImageIcon(BookReturnInterFrm.class.getResource("/img/\u8FD8\u4E66.png")));
		setMaximizable(true);
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8BFB\u8005\u8FD8\u4E66\u754C\u9762");
		setBounds(12, 100, 652, 427);
		
		JLabel lblNewLabel = new JLabel("\u60A8\u60F3\u8981\u5F52\u8FD8\u56FE\u4E66\u7684ID\uFF1A");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		
		returnBookTxt = new JTextField();
		returnBookTxt.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u5F52\u8FD8");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookReturnActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setIcon(new ImageIcon(BookReturnInterFrm.class.getResource("/img/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(returnBookTxt, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
							.addGap(122)))
					.addGap(79))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(246)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(261))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(returnBookTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnNewButton_1)
					.addContainerGap(55, Short.MAX_VALUE))
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
				"\u56FE\u4E66ID", "\u5F52\u8FD8\u622A\u6B62\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(97);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new BookBorrow(UserLogOnInterFrm.logInUser.getUserID()));
	}
	
	private void bookReturnActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		int bookID=Integer.parseInt(returnBookTxt.getText());
		if(StringUtil.isEmpty(returnBookTxt.getText())) {
			JOptionPane.showMessageDialog(null, "请选择要归还的图书");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要归还该图书吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int borrowNum=bookBorrowDao.returnB(con,bookID,UserLogOnInterFrm.logInUser);
				if(borrowNum==1) {
					JOptionPane.showMessageDialog(null, "归还成功");
					this.fillTable(new BookBorrow(UserLogOnInterFrm.logInUser.getUserID()));
				}else {
					JOptionPane.showMessageDialog(null, "归还失败");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "归还失败");
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

	private void bookTableMousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int row=bookTable.getSelectedRow();
		this.returnBookTxt.setText(String.valueOf(bookTable.getValueAt(row,0)));
	}

	private void fillTable(BookBorrow bookBorrow) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); //设置成0行 先将表格清空
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookBorrowDao.list(con, bookBorrow);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getInt("Book_bookID"));
				v.add(rs.getDate("b_endDate"));
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