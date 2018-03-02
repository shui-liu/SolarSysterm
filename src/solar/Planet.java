package solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import myutil.GameUtil;

public class Planet extends Star {
	Star center;
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	boolean stal;

	public void draw(Graphics g) {
		super.draw(g);
		if (!stal) {
			drawTrace(g);
		}
		move();
	}

	public void drawTrace(Graphics g) {
		double ovalX, ovalY, ovalWidth, ovalHeight;
		ovalX = center.x + center.width / 2 - longAxis;
		ovalY = center.y + center.height / 2 - shortAxis;
		ovalWidth = longAxis * 2;
		ovalHeight = shortAxis * 2;
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.drawOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);
		g.setColor(c);
	}

	public void move() {
		x = center.x + center.width / 2 + longAxis * Math.cos(degree) - this.width / 2;
		y = center.y + center.width / 2 + shortAxis * Math.sin(degree) - this.height / 2;
		degree += speed;
	}

	public Planet(String imgpath, Star center, double longAxis, double shortAxis, double speed) {
		super(GameUtil.getImage(imgpath));
		this.center = center;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.x = center.x + center.width / 2 + longAxis - this.width / 2;
		this.y = center.y + center.width / 2 - this.height / 2;
		this.speed = speed;
	}

	public Planet(String imgpath, Star center, double longAxis, double shortAxis, double speed, boolean stal) {
		this(imgpath, center, longAxis, shortAxis, speed);
		this.stal = stal;
	}

	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}

	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
}