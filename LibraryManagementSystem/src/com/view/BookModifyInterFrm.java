package com.view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.BookDao;
import com.model.Book;
import com.util.DbUtil;
import com.util.StringUtil;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;

public class BookModifyInterFrm extends JInternalFrame {
	private JTextField s_bookIDTxt;
	private JTable bookTable;
	private JTextField bookIDTxt;
	private JTextField titleTxt;
	private JTextField ISBNTxt;
	private JTextField publisherTxt;
	private JTextField writerTxt;
	private JTextField pubDateTxt;
	private JTextField priceTxt;
	private JTextField bookNumTxt;
	private JTextField floorTxt;
	private JTextField roomTxt;
	private JTextField shelfTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookModifyInterFrm frame = new BookModifyInterFrm();
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
	public BookModifyInterFrm() {
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setFrameIcon(new ImageIcon(BookModifyInterFrm.class.getResource("/img/base.png")));
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7EF4\u62A4\u754C\u9762");
		setBounds(100, 100, 681, 603);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66ID\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		s_bookIDTxt = new JTextField();
		s_bookIDTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setIcon(new ImageIcon(BookModifyInterFrm.class.getResource("/img/search.png")));
		
		JScrollPane scrollPane = new JScrollPane();

		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u56FE\u4E66\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(s_bookIDTxt, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(170))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 632, Short.MAX_VALUE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(s_bookIDTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
		btnNewButton_1.setIcon(new ImageIcon(BookModifyInterFrm.class.getResource("/img/\u4FEE\u6539.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionEvent(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 14));
		btnNewButton_2.setIcon(new ImageIcon(BookModifyInterFrm.class.getResource("/img/\u5220\u9664.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66ID\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("\u4E66\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 12));
		
		bookIDTxt = new JTextField();
		bookIDTxt.setEnabled(false);
		bookIDTxt.setColumns(10);
		
		titleTxt = new JTextField();
		titleTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ISBN\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 12));
		
		ISBNTxt = new JTextField();
		ISBNTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u4F5C\u5BB6\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 12));
		
		JLabel lblNewLabel_5 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 12));
		
		publisherTxt = new JTextField();
		publisherTxt.setText("");
		publisherTxt.setColumns(10);
		
		writerTxt = new JTextField();
		writerTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 12));
		
		pubDateTxt = new JTextField();
		pubDateTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u5B9A\u4EF7\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 12));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u73B0\u6709\u4E66\u6570\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 12));
		
		bookNumTxt = new JTextField();
		bookNumTxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u653E\u7F6E\u697C\u5C42\uFF1A");
		lblNewLabel_9.setFont(new Font("宋体", Font.BOLD, 12));
		
		floorTxt = new JTextField();
		floorTxt.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u653E\u7F6E\u623F\u95F4\uFF1A");
		lblNewLabel_10.setFont(new Font("宋体", Font.BOLD, 12));
		
		roomTxt = new JTextField();
		roomTxt.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("\u653E\u7F6E\u4E66\u67B6\uFF1A");
		lblNewLabel_11.setFont(new Font("宋体", Font.BOLD, 12));
		
		shelfTxt = new JTextField();
		shelfTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(117)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(166)
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(191))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookIDTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(titleTxt, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ISBNTxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(writerTxt, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(23))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(floorTxt, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_10))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pubDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(48)
									.addComponent(lblNewLabel_7)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(roomTxt)
								.addComponent(priceTxt))
							.addGap(54)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_11)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(shelfTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addGap(0))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(bookIDTxt, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(ISBNTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(writerTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(pubDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8)
						.addComponent(bookNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_9)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(floorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_10)
							.addComponent(roomTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(shelfTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_11)))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66ID", "\u4E66\u540D", "ISBN", "\u4F5C\u5BB6", "\u51FA\u7248\u793E", "\u51FA\u7248\u65E5\u671F", "\u5B9A\u4EF7", "\u73B0\u6709\u4E66\u6570", "\u697C\u5C42", "\u623F\u95F4", "\u4E66\u67B6"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, false, true, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(47);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(60);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(54);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(45);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(68);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(77);
		bookTable.getColumnModel().getColumn(6).setPreferredWidth(39);
		bookTable.getColumnModel().getColumn(7).setPreferredWidth(61);
		bookTable.getColumnModel().getColumn(8).setPreferredWidth(37);
		bookTable.getColumnModel().getColumn(9).setPreferredWidth(36);
		bookTable.getColumnModel().getColumn(10).setPreferredWidth(38);
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		
		
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Book());

	}
	
	private void bookDeleteActionEvent(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=bookIDTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=bookDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Book());
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

	private void bookUpdateActionEvent(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String id=bookIDTxt.getText();
		String title=titleTxt.getText();
		String ISBN=ISBNTxt.getText();
		String writer=writerTxt.getText();
		String publisher=publisherTxt.getText();
		String pubDate=pubDateTxt.getText();
		String price=priceTxt.getText();
		String bookNum=bookNumTxt.getText();
		String floor=floorTxt.getText();
		String room=roomTxt.getText();
		String shelf=shelfTxt.getText();
		
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(title)) {
			JOptionPane.showMessageDialog(null, "书名不能为空");
			return;
		}
		if(StringUtil.isEmpty(ISBN)) {
			JOptionPane.showMessageDialog(null, "ISBN不能为空");
			return;
		}
		if(StringUtil.isEmpty(writer)) {
			JOptionPane.showMessageDialog(null, "作家不能为空");
			return;
		}
		if(StringUtil.isEmpty(publisher)) {
			JOptionPane.showMessageDialog(null, "出版社不能为空");
			return;
		}
		if(StringUtil.isEmpty(pubDate)) {
			JOptionPane.showMessageDialog(null, "出版日期不能为空");
			return;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空");
			return;
		}
		if(StringUtil.isEmpty(bookNum)) {
			JOptionPane.showMessageDialog(null, "书的数目不能为空");
			return;
		}
		if(StringUtil.isEmpty(floor)) {
			JOptionPane.showMessageDialog(null, "放置楼层不能为空");
			return;
		}
		if(StringUtil.isEmpty(room)) {
			JOptionPane.showMessageDialog(null, "放置房间不能为空");
			return;
		}
		if(StringUtil.isEmpty(shelf)) {
			JOptionPane.showMessageDialog(null, "书架不能为空");
			return;
		}
		
		if(ISBN.length()!=17) {
			JOptionPane.showMessageDialog(null, "ISBN输入不合法");
			return;
		}
		
		if(pubDate.length()!=10) {
			JOptionPane.showMessageDialog(null, "出版日期输入不合法");
			return;
		}
		
		Book book=new Book(Integer.parseInt(id),title,ISBN,writer,publisher,pubDate,Integer.parseInt(price),Integer.parseInt(bookNum),floor,room,shelf);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=bookDao.update(con, book);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new Book());
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
		bookIDTxt.setText("");
		titleTxt.setText("");
		ISBNTxt.setText("");
		writerTxt.setText("");
		publisherTxt.setText("");
		pubDateTxt.setText("");
		priceTxt.setText("");
		bookNumTxt.setText("");
		floorTxt.setText("");
		roomTxt.setText("");
		shelfTxt.setText("");
	}

	/**
	 * 表格行点击事件
	 * @param e
	 */
	private void bookTableMousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		int row=bookTable.getSelectedRow();
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) bookTable.getValueAt(row,5);
		String pubDate = ft.format(date);
		
		bookIDTxt.setText(String.valueOf(bookTable.getValueAt(row,0)));
		titleTxt.setText((String)bookTable.getValueAt(row,1));
		ISBNTxt.setText((String)bookTable.getValueAt(row,2));
		writerTxt.setText((String)bookTable.getValueAt(row,3));
		publisherTxt.setText((String)bookTable.getValueAt(row,4));
		pubDateTxt.setText(pubDate);
		priceTxt.setText(String.valueOf(bookTable.getValueAt(row,6)));
		bookNumTxt.setText(String.valueOf(bookTable.getValueAt(row,7)));
		floorTxt.setText((String)bookTable.getValueAt(row,8));
		roomTxt.setText((String)bookTable.getValueAt(row,9));
		shelfTxt.setText((String)bookTable.getValueAt(row,10));
	}
	
	private void bookSearchActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String s_bookID=this.s_bookIDTxt.getText();
		Book book=new Book();
		book.setBookID(Integer.parseInt(s_bookID));
		this.fillTable(book);
	}

	private void fillTable(Book book) {
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); //设置成0行 先将表格清空
		Connection con=null;

		try {
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list(con, book);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getInt("bookID"));
				v.add(rs.getString("title"));
				v.add(rs.getString("ISBN"));
				v.add(rs.getString("writer"));
				v.add(rs.getString("publisher"));
				v.add(rs.getDate("pubDate"));
				v.add(rs.getInt("price"));
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
