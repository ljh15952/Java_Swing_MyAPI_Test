import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Figure {
	@Override
	public void draw(Graphics g) {
		g.drawOval(getX(), getY(), getWidth(), getHeight());
	}
}