import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import com.db.*;
import com.model.voiceList;
import javax.swing.*;
import javax.swing.border.Border;
public class mainContent extends JFrame{
	private final Color colorValues[] ={Color.black,Color.blue,Color.red,Color.green};
	private JRadioButtonMenuItem colorltems[],fonts[];
	private JCheckBoxMenuItem styleltems[];
	private JLabel displayLabel;
	private ButtonGroup fontGroup,colorGroup;
	private int style;
	private String[] names={""},commonNum,namelist={""},timelist={""},longlist={""};
	private JList namesList1,namesList2,namesList3;
	private JComboBox persionComboBoxA,persionComboBoxB,persionComboBoxC;
	private JTextField textField1,textField2;
	private JTextArea textArea1,textArea2,textArea3;
	private JButton startButton;
	private String[] way= {"Voice","Message","Gprs"};
	/**
	 * 
	 */
	public mainContent(){
		super("ͨѶ��¼����ϵͳ");
		Container container = getContentPane();
		container.setLayout(null);
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
					new mainContent();
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
					JOptionPane.showMessageDialog(mainContent.this, "�����ǰ�����");
				}
			});
			bar.add(helpMenu);
			//����ѡ���һ
			JLabel label1 = new JLabel("ѡ������һ");
			label1.setBounds(20,10,65,20);
			container.add(label1);
			DB db = new DB();
			names = db.nameShow();
			persionComboBoxA = new JComboBox(names);
			persionComboBoxA.setMaximumRowCount(5);
			persionComboBoxA.setBounds(90, 10, 100, 20);
			//����ѡ����
			persionComboBoxB = new JComboBox(names);
			persionComboBoxB.setMaximumRowCount(5);
			persionComboBoxB.setBounds(275, 10, 100, 20);
		/*	persionComboBoxB.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent event) {
					// TODO Auto-generated method stub
					if(event.getStateChange() == ItemEvent.SELECTED);
					String s = persionComboBoxB.getSelectedItem().toString();
					JOptionPane.showMessageDialog(mainContent.this, s);
				}
			});*/
			//����ѡ���
			persionComboBoxC = new JComboBox(way);
			persionComboBoxC.setMaximumRowCount(5);
			persionComboBoxC.setBounds(90, 35, 100, 20);
			getContentPane().add(persionComboBoxA);
			JLabel label2 = new JLabel("ѡ�������");
			label2.setBounds(200,10,65,20);
			container.add(label2);
			getContentPane().add(persionComboBoxB);
			JLabel label3 = new JLabel("��������");
			label3.setBounds(20, 35, 65, 20);
			container.add(label3);
			getContentPane().add(persionComboBoxC);
			JLabel label4 = new JLabel("��ֹʱ��");
			label4.setBounds(200,35,65,20);
			container.add(label4);
			textField2 = new JTextField(10);
			textField2.setBounds(275, 35, 100, 20);
			container.add(textField2);
			//��ʼ������ť
			startButton = new JButton("��ʼ����");
			startButton.setBounds(390, 15, 100, 30);
			startButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					DB mainDB=new DB();
					commonNum=mainDB.listCompare(persionComboBoxA.getSelectedItem().toString(), persionComboBoxB.getSelectedItem().toString());
					if(commonNum!=null){
					ArrayList<voiceList> alInfo=new ArrayList<>();
					alInfo=mainDB.showResult(commonNum);
					if(alInfo!=null){
					Iterator<voiceList> comPer=alInfo.iterator();
					int i=0;
					while(comPer.hasNext()){
						voiceList vslist=comPer.next();
						namelist[i]=vslist.getToNum();
						timelist[i]=vslist.getDatetime();
						longlist[i]=vslist.getLongth();
						i++;
					}
				}
				}
				}
			});
			container.add(startButton);
			JLabel label5 = new JLabel("��ͬͨѶ��");
			label5.setBounds(20, 70, 150, 25);
			label5.setHorizontalAlignment(JTextField.CENTER);
			label5.setBorder(BorderFactory.createBevelBorder(1));
			container.add(label5);
			JLabel label6 = new JLabel("ͨѶʱ��");
			label6.setBounds(170, 70, 150, 25);
			label6.setHorizontalAlignment(JTextField.CENTER);
			label6.setBorder(BorderFactory.createBevelBorder(1));
			container.add(label6);
			JLabel label7 = new JLabel("ͨѶʱ��");
			label7.setBounds(320, 70, 150, 25);
			label7.setHorizontalAlignment(JTextField.CENTER);
			label7.setBorder(BorderFactory.createBevelBorder(1));
			container.add(label7);
			namesList1 =new JList(namelist);
			namesList1.setVisibleRowCount(8);
			namesList1.setBorder(BorderFactory.createBevelBorder(1));
			namesList1.setBounds(20, 95, 150, 200);
			container.add(namesList1);
			namesList2 =new JList(timelist);
			namesList2.setVisibleRowCount(8);
			namesList2.setBorder(BorderFactory.createBevelBorder(1));
			namesList2.setBounds(170, 95, 150, 200);
			container.add(namesList2);
			namesList3 =new JList(longlist);
			namesList3.setVisibleRowCount(8);
			namesList3.setBounds(320, 95, 150, 200);
			namesList3.setBorder(BorderFactory.createBevelBorder(1));
			container.add(namesList3);
			
			 int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	         int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	         this.setLocation(width / 2 - 200, height / 2 - 150);
			setSize(500 ,400);
			getContentPane().setBackground(Color.lightGray);
			setVisible(true);
			setResizable(false);
	}
	
	
	public static void main(String args[])
	{
		mainContent application = new mainContent();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}