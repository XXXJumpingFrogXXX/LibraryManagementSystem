package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.dao.BookDao;
import com.model.Book;
import com.util.DbUtil;
import com.util.StringUtil;

import java.awt.Color;
import java.awt.Container;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField addTitleTxt;
	private JTextField addWriterTxt;
	private JTextField addISBNTxt;
	private JTextField addPublisherTxt;
	private JTextField addPubDateTxt;
	private JTextField addFloorTxt;
	private JTextField addRoomTxt;
	private JTextField addShelfTxt;
	private JTextField addPriceTxt;
	private JTextField addBookNumTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setFrameIcon(new ImageIcon(BookAddInterFrm.class.getResource("/img/add.png")));
		try {
			setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0\u9875\u9762");
		setBounds(100, 100, 692, 415);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		addTitleTxt = new JTextField();
		addTitleTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		addWriterTxt = new JTextField();
		addWriterTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		
		addISBNTxt = new JTextField();
		addISBNTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u51FA\u7248\u5546\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		
		addPublisherTxt = new JTextField();
		addPublisherTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
		
		addPubDateTxt = new JTextField();
		addPubDateTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u56FE\u4E66\u5165\u5E93\u4F4D\u7F6E");
		lblNewLabel_5.setFont(new Font("幼圆", Font.BOLD, 18));
		lblNewLabel_5.setForeground(Color.RED);
		
		JLabel lblNewLabel_6 = new JLabel("\u697C\u5C42\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 14));
		
		addFloorTxt = new JTextField();
		addFloorTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u623F\u95F4\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 14));
		
		addRoomTxt = new JTextField();
		addRoomTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u4E66\u67B6\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_8.setVerticalAlignment(SwingConstants.BOTTOM);
		
		addShelfTxt = new JTextField();
		addShelfTxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u5B9A\u4EF7\uFF1A");
		lblNewLabel_9.setFont(new Font("宋体", Font.BOLD, 15));
		
		addPriceTxt = new JTextField();
		addPriceTxt.setColumns(10);
		
		addBookNumTxt = new JTextField();
		addBookNumTxt.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u8FDB\u4E66\u6570\u91CF\uFF1A");
		lblNewLabel_10.setFont(new Font("宋体", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/img/\u6DFB\u52A0.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/img/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(addPubDateTxt, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
							.addGap(463))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addTitleTxt, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
							.addGap(251)
							.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(92))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(addISBNTxt, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(addPublisherTxt, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
											.addGap(9))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(addWriterTxt, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
											.addGap(32)))
									.addGap(248))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(153)
											.addComponent(lblNewLabel_10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(lblNewLabel_9))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(addBookNumTxt, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
										.addComponent(addPriceTxt, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
									.addGap(120)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(addShelfTxt, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_6)
										.addComponent(lblNewLabel_7))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(addFloorTxt, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
										.addComponent(addRoomTxt, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
							.addGap(108))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(144)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(126)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(176))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(addTitleTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(addISBNTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_9)
								.addComponent(addPriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(addWriterTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(lblNewLabel_5)
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(addFloorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(addRoomTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(addBookNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10))
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(addPublisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(addPubDateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8)
								.addComponent(addShelfTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
	
	
	private void bookAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String title=this.addTitleTxt.getText();
		String ISBN=this.addISBNTxt.getText();
		String writer=this.addWriterTxt.getText();
		String publisher=this.addPublisherTxt.getText();
		String pubDate=this.addPubDateTxt.getText();
		int price=Integer.parseInt(this.addPriceTxt.getText());
		int bookNum=Integer.parseInt(this.addBookNumTxt.getText());
		String floor=this.addFloorTxt.getText();
		String room=this.addRoomTxt.getText();
		String shelf=this.addShelfTxt.getText();

		if(StringUtil.isEmpty(title)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(ISBN)) {
			JOptionPane.showMessageDialog(null, "ISBN不能为空！");
			return;
		}
		if(StringUtil.isEmpty(writer)) {
			JOptionPane.showMessageDialog(null, "作者不能为空！");
			return;
		}
		if(StringUtil.isEmpty(publisher)) {
			JOptionPane.showMessageDialog(null, "出版商不能为空！");
			return;
		}
		if(StringUtil.isEmpty(pubDate)) {
			JOptionPane.showMessageDialog(null, "出版日期不能为空！");
			return;
		}
		if(StringUtil.isEmpty(this.addPriceTxt.getText())) {
			JOptionPane.showMessageDialog(null, "定价不能为空！");
			return;
		}
		if(StringUtil.isEmpty(this.addBookNumTxt.getText())) {
			JOptionPane.showMessageDialog(null, "图书数量不能为空！");
			return;
		}
		if(StringUtil.isEmpty(floor)) {
			JOptionPane.showMessageDialog(null, "楼层不能为空！");
			return;
		}
		if(StringUtil.isEmpty(room)) {
			JOptionPane.showMessageDialog(null, "房间不能为空！");
			return;
		}
		if(StringUtil.isEmpty(shelf)) {
			JOptionPane.showMessageDialog(null, "书架不能为空！");
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
		
		Book book=new Book(title,ISBN,writer,publisher,pubDate,price,bookNum,floor,room,shelf);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=bookDao.add(con, book);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "图书添加失败！");
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
		this.addTitleTxt.setText("");
		this.addISBNTxt.setText("");
		this.addWriterTxt.setText("");
		this.addPublisherTxt.setText("");
		this.addPubDateTxt.setText("");
		this.addPriceTxt.setText("");
		this.addBookNumTxt.setText("");
		this.addFloorTxt.setText("");
		this.addRoomTxt.setText("");
		this.addShelfTxt.setText("");
	}
}