import java.util.ArrayList;

import javax.swing.JFrame;

public class LayoutTestFrame extends MyFrame implements MyActionListener {

	private MyButton flowBtn;
	private MyButton gridBtn;

	private MyPanel panel;

	public LayoutTestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);

		panel = new MyPanel();
		panel.setLayout(null);
		setContentPane(panel);

		flowBtn = new MyButton("flow");
		flowBtn.setBounds(0, 0, 50, 50);
		flowBtn.addListener(this);
		panel.add(flowBtn);

		gridBtn = new MyButton("grid");
		gridBtn.setBounds(50, 50, 50, 50);
		gridBtn.addListener(this);
		panel.add(gridBtn);

		for (int i = 2; i < 12; i++) {
			MyButton b = new MyButton(Integer.toString(i - 1));
			b.setBounds(50 * i, 50 * i, 50, 50);
			b.addListener(this);
			panel.add(b);
		}
	}

	@Override
	public void actionPerformed(MyEvent e) {
		if (flowBtn == e.getSource()) {
			panel.setLayout(new MyFlowLayout());
		} else if (gridBtn == e.getSource()) {
			panel.setLayout(new MyGridLayout(3, 4));
		}
	}
}
