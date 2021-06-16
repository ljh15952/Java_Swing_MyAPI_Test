  
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Figure {
	protected Point _position, _size;
	public Color color = Color.black;
	public int getHeight() {
		return _size.y;
	}

	public void setHeight(int _height) {
		_size.y = _height;
	}

	public int getWidth() {
		return _size.x;
	}

	public void setWidth(int _width) {
		_size.x = _width;
	}

	public int getY() {
		return _position.y;
	}

	public void setY(int _y) {
		_position.y = _y;
	}

	public int getX() {
		return _position.x;
	}

	public void setX(int _x) {
		_position.x = _x;
	}

	public Point getPosition() {
		return _position;
	}

	public void setPosition(Point p) {
		_position = p;
	}

	public Point getSize() {
		return _size;
	}

	public void setSize(Point p) {
		_size = p;
	}

	// 가상 함수
	public abstract void draw(Graphics g);
}