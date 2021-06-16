import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class PaintTestFrame extends MyFrame implements MyActionListener {

	public MyMenuBar menuBar;

	private MyMenu fileMenu;
	private MyMenu editMenu;
	private MyMenu helpMenu;

	private MyMenuItem loadItem;
	private MyMenuItem saveItem;
	private MyMenuItem exitItem;

	private MyMenuItem redItem;
	private MyMenuItem greenItem;
	private MyMenuItem blueItem;

	private ArrayList<Figure> figArr = new ArrayList<>();

	MyButton rectBtn;
	MyButton ovalBtn;
	MyButton lineBtn;

	public PaintTestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);
		addMouseListener(new MyMouseListener());

		menuBar = new MyMenuBar();
		setMyMenuBar(menuBar);

		fileMenu = new MyMenu("File");
		editMenu = new MyMenu("Edit");
		helpMenu = new MyMenu("Help");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		loadItem = new MyMenuItem("Load");
		saveItem = new MyMenuItem("Save");
		exitItem = new MyMenuItem("Exit");

		redItem = new MyMenuItem("Red");
		greenItem = new MyMenuItem("Green");
		blueItem = new MyMenuItem("Blue");

		loadItem.addListener(this);
		saveItem.addListener(this);
		exitItem.addListener(this);

		redItem.addListener(this);
		greenItem.addListener(this);
		blueItem.addListener(this);

		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);

		editMenu.add(redItem);
		editMenu.add(greenItem);
		editMenu.add(blueItem);

		MyToolBar toolBar = new MyToolBar();
		toolBar.setBounds(10, 200, 130, 500);
		add(toolBar);

		rectBtn = new MyButton("사각형");
		rectBtn.setBounds(100, 100, 50, 50);
		rectBtn.addListener(this);
		toolBar.add(rectBtn);

		ovalBtn = new MyButton("타원");
		ovalBtn.setBounds(100, 100, 50, 50);
		ovalBtn.addListener(this);
		toolBar.add(ovalBtn);

		lineBtn = new MyButton("선분");
		lineBtn.setBounds(100, 100, 50, 50);
		lineBtn.addListener(this);
		toolBar.add(lineBtn);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 다형성을 활용해서 여러가지 도형이 담긴 배열을 그려주기만 해도 OK
		for (Figure r : figArr) {
			g.setColor(r.color);
			r.draw(g);
		}
	}

	Color color = Color.BLACK;

	@Override
	public void actionPerformed(MyEvent e) {
		if (loadItem == e.getSource()) {
			System.out.println("LOAD FILE");
		} else if (saveItem == e.getSource()) {
			System.out.println("SAVE FILE");
		} else if (exitItem == e.getSource()) {
			System.exit(0);
		} else if (rectBtn == e.getSource()) {
			System.out.println("Click Rect Btn");
			state = 1;
		} else if (ovalBtn == e.getSource()) {
			System.out.println("Click Oval Btn");
			state = 2;
		} else if (lineBtn == e.getSource()) {
			System.out.println("Click Line Btn");
			state = 3;
		} else if (redItem == e.getSource()) {
			color = Color.RED;
		} else if (greenItem == e.getSource()) {
			color = Color.GREEN;
		} else if (blueItem == e.getSource()) {
			color = Color.BLUE;
		}

	}

	int state = 0;
	Point p1;

	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("qweqweqwe");
			p1 = e.getPoint();
		}

		public Point getPosition(Point p1, Point p2) {
			return new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
		}

		public Point getSize(Point p1, Point p2) {
			return new Point(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			Figure f = null;
			Point p2 = e.getPoint();
			if (state == 1) {
				f = new Rect();
				f._position = getPosition(p1, p2);
				f._size = getSize(p1, p2);
			} else if (state == 2) {
				f = new Oval();
				f._position = getPosition(p1, p2);
				f._size = getSize(p1, p2);
			} else if (state == 3) {
				f = new Line();
				f._position = p1;
				f.setSize(new Point((p2.x - p1.x), (p2.y - p1.y)));
			}

			if (f != null) {
				f.color = color;
				figArr.add(f);
				repaint();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
