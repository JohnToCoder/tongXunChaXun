import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class peizi extends JFrame{
	private final Color colorValues[] ={Color.black,Color.blue,Color.red,Color.green};
	private JRadioButtonMenuItem colorltems[],fonts[];
	private JCheckBoxMenuItem styleltems[];
	private JLabel displayLabel;
	private ButtonGroup fontGroup,colorGroup;
	private int style;
	private String ways[] = {"Voice","Message","Gprs"};
	private JComboBox persionComboBoxA;
	private JComboBox persionComboBoxB;
	private JTextField textField3,textField4;
	private JCheckBox name,telNum,date,time,longth;
	public peizi(){
		super("通讯记录分析系统");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
			JMenu fileMenu = new JMenu("文件");
			fileMenu.setMnemonic('F');
			JMenuItem openltem = new JMenuItem("打开");
			openltem.setMnemonic('O');
			fileMenu.add(openltem);
			openltem.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent event) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(peizi.this, "这是菜单栏文件菜单打开项的动作");
						}
					});
			JMenuItem outltem = new JMenuItem("导入");
			outltem.setMnemonic('A');
			fileMenu.add(outltem);
			outltem.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent event) {
							// TODO Auto-generated method stub
							new daoru();
							setVisible(false);
						}
					});
			JMenuItem confltem = new JMenuItem("配置");
			confltem.setMnemonic('P');
			fileMenu.add(confltem);
			confltem.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent event) {
							// TODO Auto-generated method stub
							new peizi();
							setVisible(false);
						}
					});
			JMenuItem exitltem = new JMenuItem("退出");
			exitltem.setMnemonic('X');
			fileMenu.add(exitltem);
			exitltem.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent event) {
							// TODO Auto-generated method stub
							System.exit(0);
						}
					});
			bar.add(fileMenu);
			JMenu analyMenu = new JMenu("分析");
			analyMenu.setMnemonic('F');
			JMenuItem commonltem = new JMenuItem("共同通讯人");
			commonltem.setMnemonic('C');
			analyMenu.add(commonltem);
			commonltem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
				}
			});
			bar.add(analyMenu);
			JMenu helpMenu = new JMenu("帮助");
			helpMenu.setMnemonic('H');
			JMenuItem helpltem = new JMenuItem("帮助中心");
			helpMenu.add(helpltem);
			helpltem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(peizi.this, "这里是帮助项");
				}
			});
			bar.add(helpMenu);
			JLabel label9 = new JLabel("选择关键字段");
			container.add(label9);
			name = new JCheckBox("姓名",true);
			container.add(name);
			date = new JCheckBox("日期",true);
			container.add(date);
			time = new JCheckBox("时间",true);
			container.add(time);
			telNum = new JCheckBox("电话号码",true);
			container.add(telNum);
			longth = new JCheckBox("通话时长",false);
			container.add(longth);
	    //    CheckBoxHandler hander = new CheckBoxHandler();
			JButton trueButton = new JButton("确定");
	    	trueButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					setVisible(false);
				}
			});
			container.add(trueButton);
			 int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	         int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	         this.setLocation(width / 2 - 150, height / 2 - 100);
			setSize(450 ,350);
			getContentPane().setBackground(Color.lightGray);
			setVisible(true);
			setResizable(false);
	}
}