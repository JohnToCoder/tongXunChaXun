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
		super("ͨѶ��¼����ϵͳ");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
			JMenu fileMenu = new JMenu("�ļ�");
			fileMenu.setMnemonic('F');
			JMenuItem openltem = new JMenuItem("��");
			openltem.setMnemonic('O');
			fileMenu.add(openltem);
			openltem.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent event) {
							// TODO Auto-generated method stub
							JOptionPane.showMessageDialog(peizi.this, "���ǲ˵����ļ��˵�����Ķ���");
						}
					});
			JMenuItem outltem = new JMenuItem("����");
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
			JMenuItem confltem = new JMenuItem("����");
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
			JMenuItem exitltem = new JMenuItem("�˳�");
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
			JMenu analyMenu = new JMenu("����");
			analyMenu.setMnemonic('F');
			JMenuItem commonltem = new JMenuItem("��ͬͨѶ��");
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
			JMenu helpMenu = new JMenu("����");
			helpMenu.setMnemonic('H');
			JMenuItem helpltem = new JMenuItem("��������");
			helpMenu.add(helpltem);
			helpltem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(peizi.this, "�����ǰ�����");
				}
			});
			bar.add(helpMenu);
			JLabel label9 = new JLabel("ѡ��ؼ��ֶ�");
			container.add(label9);
			name = new JCheckBox("����",true);
			container.add(name);
			date = new JCheckBox("����",true);
			container.add(date);
			time = new JCheckBox("ʱ��",true);
			container.add(time);
			telNum = new JCheckBox("�绰����",true);
			container.add(telNum);
			longth = new JCheckBox("ͨ��ʱ��",false);
			container.add(longth);
	    //    CheckBoxHandler hander = new CheckBoxHandler();
			JButton trueButton = new JButton("ȷ��");
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