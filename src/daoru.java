import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.db.*;
import com.model.namelist;

public class daoru extends JFrame{
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
	private JTextArea textArea1,textArea2,textArea3;
	private JButton daoRuButton;
	private FlowLayout layout;
	public daoru(){
		super("ͨѶ��¼����ϵͳ");
		Container container = getContentPane();
		layout = new FlowLayout();
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
							JOptionPane.showMessageDialog(daoru.this, "���ǲ˵����ļ��˵�����Ķ���");
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
							JOptionPane.showMessageDialog(daoru.this, "���ǲ˵����ļ��˵�������Ķ���");
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
					JOptionPane.showMessageDialog(daoru.this, "�����ǰ�����");
				}
			});
			bar.add(helpMenu);
			//��Ͽ�
			String s;
			JLabel label1 = new JLabel("ͨ������");
			label1.setBounds(20, 20, 65, 20);
			container.add(label1);
			persionComboBoxA = new JComboBox(ways);
			persionComboBoxA.setMaximumRowCount(3);
			persionComboBoxA.setBounds(90, 20, 100, 20);
			persionComboBoxA.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent event) {
					// TODO Auto-generated method stub
					if(event.getStateChange() == ItemEvent.SELECTED){
						String s = persionComboBoxA.getSelectedItem().toString();
						System.out.println(s);
					}
				}
			});
			container.add(persionComboBoxA);
			JLabel label8 = new JLabel("����");
			label8.setBounds(275, 20, 40, 20);
			container.add(label8);
			textField3 = new JTextField(10);
			textField3.setBounds(320, 20,100, 20);
			container.add(textField3);
			textField4 = new JTextField(25);
			textField4.setBounds(20, 55,300, 22);
			container.add(textField4);
			JButton selectButton = new JButton("Execl�ļ�");
			selectButton.setBounds(335, 53,100, 25);
			selectButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					JFileChooser jfc = new JFileChooser();
					if(jfc.showOpenDialog(daoru.this) == JFileChooser.APPROVE_OPTION)
					{textField4.setText(jfc.getSelectedFile().getAbsolutePath());}
				}
			});
			container.add(selectButton);
			daoRuButton = new JButton("����");
			daoRuButton.setBounds(190, 95,80, 30);
			daoRuButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					// TODO Auto-generated method stub
					System.out.println(textField3.getText());
					DB db = new DB();
					 if(db.checkName(textField3.getText())){
						 namelist name = new namelist();
						 name.setName(textField3.getText());
					     db.addName(name);
					 }
					add t = new add();
					if(t.inputExecl(persionComboBoxA.getSelectedItem().toString(),textField3.getText(),textField4.getText()))
					{JOptionPane.showMessageDialog(daoru.this, "�����ļ��ɹ���");
					setVisible(false);}
					else
				    {JOptionPane.showMessageDialog(daoru.this, "����ʧ�ܣ������µ��룡");
				      new daoru();
				    }
				}
			});
			container.add(daoRuButton);
			 int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	         int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	         this.setLocation(width / 2 - 150, height / 2 - 100);
			setSize(450,350);
			getContentPane().setBackground(Color.lightGray);
			setVisible(true);
			setResizable(false);
	}
	private void FlowLayout(int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}
}