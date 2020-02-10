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
		setLocationRelativeTo(null); // 设置窗体居中
		setSize(180, 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		JTextField text = new JTextField("连点还没开始,按下R键开始");
		JButton start = new JButton("开始连点");
		JButton stop = new JButton("停止连点");
		JButton delete = new JButton("删除热键");
		text.setEditable(false);
		stop.setEnabled(false);

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("连点开始,按下T键结束");
				start.setEnabled(false);
				stop.setEnabled(true);
				LeftRight = 1;
			}
		});
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("连点已停止,按下R键重新开始");
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

		// 第二步：注册热键
		// JIntellitype.getInstance().registerHotKey(FUNC_KEY_MARK,
		// JIntellitype.MOD_ALT, (int)'S');
		// 第一个参数表示该热键的标识，第二个参数表示组合键，如果没有则为0，第三个参数为定义的主要热键
		JIntellitype.getInstance().registerHotKey(0, 0, (int) 'R');// 给变量名为0的值设置热键为R，其中没有组合键。
		JIntellitype.getInstance().registerHotKey(1, 0, (int) 'T');// 给变量名为1的值设置热键为T，其中没有组合键。

		// 第三步：添加热键监听
		JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
			public void onHotKey(int markCode) {
				switch (markCode) {
				case 0:// 给标识符为0的热键设置监听
					text.setText("连点开始,按下T键结束");// 开始连点
					start.setEnabled(false);
					stop.setEnabled(true);
					LeftRight = 1;
					System.out.println(LeftRight);
					break;
				case 1:// 给标识符为1的热键设置监听
					text.setText("连点已停止,按下R键重新开始");// 停止连点
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
				// 第四步：删除热键
				// JIntellitype.getInstance().unregisterHotKey(<标识符或数字>);//用于移除热键注册的方法
				JIntellitype.getInstance().unregisterHotKey(1);// 用于移除热键注册的方法,把变量名为1的变量删除。
				JIntellitype.getInstance().unregisterHotKey(0);// 用于移除热键注册的方法,把变量名为0的变量删除。
				delete.setEnabled(false);
			}
		});
		Robot robot = null;
		try {
			robot = new Robot();
			while (true) {
				//System.out.println("4");
				if (LeftRight == 1) {
					System.out.println("开始连点");
					int s=InputEvent.BUTTON3_MASK;
					robot.delay(500); // 你的鼠标移动和按下，几乎同时了，可能出现还没移到地方已经点下了哈
					robot.mousePress(s);
					robot.mouseRelease(s);
					
				}
			}
		} catch (AWTException e) {
			text.setText("连点器出现错误,运行失败");
			e.printStackTrace();
		}

	}


}
