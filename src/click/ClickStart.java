package click;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

public class ClickStart extends JFrame {
	volatile  int LeftRight = 0;
	public static void main(String[] args) {
		new ClickStart();
	}
	public ClickStart() {
		setTitle("001");
		setVisible(true);
		setLocationRelativeTo(null); // ���ô������
		setSize(180, 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		JTextField text = new JTextField("���㻹û��ʼ,����R����ʼ");
		JButton start = new JButton("��ʼ����");
		JButton stop = new JButton("ֹͣ����");
		JButton delete = new JButton("ɾ���ȼ�");
		text.setEditable(false);
		stop.setEnabled(false);

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("���㿪ʼ,����T������");
				start.setEnabled(false);
				stop.setEnabled(true);
				LeftRight = 1;
			}
		});
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("������ֹͣ,����R�����¿�ʼ");
				start.setEnabled(true);
				stop.setEnabled(false);
				LeftRight = 0;
			}
		});
		c.add(text, BorderLayout.NORTH);
		c.add(start, BorderLayout.WEST);
		c.add(stop, BorderLayout.EAST);
		setAlwaysOnTop(true);
		c.validate();

		// �ڶ�����ע���ȼ�
		// JIntellitype.getInstance().registerHotKey(FUNC_KEY_MARK,
		// JIntellitype.MOD_ALT, (int)'S');
		// ��һ��������ʾ���ȼ��ı�ʶ���ڶ���������ʾ��ϼ������û����Ϊ0������������Ϊ�������Ҫ�ȼ�
		JIntellitype.getInstance().registerHotKey(0, 0, (int) 'R');// ��������Ϊ0��ֵ�����ȼ�ΪR������û����ϼ���
		JIntellitype.getInstance().registerHotKey(1, 0, (int) 'T');// ��������Ϊ1��ֵ�����ȼ�ΪT������û����ϼ���

		// ������������ȼ�����
		JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
			public void onHotKey(int markCode) {
				switch (markCode) {
				case 0:// ����ʶ��Ϊ0���ȼ����ü���
					text.setText("���㿪ʼ,����T������");// ��ʼ����
					start.setEnabled(false);
					stop.setEnabled(true);
					LeftRight = 1;
					System.out.println(LeftRight);
					break;
				case 1:// ����ʶ��Ϊ1���ȼ����ü���
					text.setText("������ֹͣ,����R�����¿�ʼ");// ֹͣ����
					start.setEnabled(true);
					stop.setEnabled(false);
					LeftRight = 0;
					System.out.println(LeftRight);
					break;
				}
			}
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���Ĳ���ɾ���ȼ�
				// JIntellitype.getInstance().unregisterHotKey(<��ʶ��������>);//�����Ƴ��ȼ�ע��ķ���
				JIntellitype.getInstance().unregisterHotKey(1);// �����Ƴ��ȼ�ע��ķ���,�ѱ�����Ϊ1�ı���ɾ����
				JIntellitype.getInstance().unregisterHotKey(0);// �����Ƴ��ȼ�ע��ķ���,�ѱ�����Ϊ0�ı���ɾ����
				delete.setEnabled(false);
			}
		});
		Robot robot = null;
		try {
			robot = new Robot();
			while (true) {
				//System.out.println("4");
				if (LeftRight == 1) {
					System.out.println("��ʼ����");
					int s=InputEvent.BUTTON3_MASK;
					robot.delay(500); // �������ƶ��Ͱ��£�����ͬʱ�ˣ����ܳ��ֻ�û�Ƶ��ط��Ѿ������˹�
					robot.mousePress(s);
					robot.mouseRelease(s);
					
				}
			}
		} catch (AWTException e) {
			text.setText("���������ִ���,����ʧ��");
			e.printStackTrace();
		}

	}


}
