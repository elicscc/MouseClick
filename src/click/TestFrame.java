package click;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JDialog dialog;
	public TestFrame() {
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new FlowLayout());
		JButton button = new JButton("Click");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDialog();
			}
		});
		getContentPane().add(button);
		dialog = new JDialog();
		dialog.setSize(100, 200);
		dialog.setLocationRelativeTo(null);
	}
	/**
	 * œ‘ æ∂‘ª∞øÚ
	 */
	public void showDialog() {
		dialog.setVisible(true);
	}
	public static void main(String[] args) {
		new TestFrame();
	}
}
