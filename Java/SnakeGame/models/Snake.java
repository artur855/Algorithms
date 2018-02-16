package SnakeGame.models;

import java.util.ArrayList;
import java.util.List;

import SnakeGame.Direction;

public class Snake {

	private final int MIN_SIZE = 3;
	private List<Point> points;
	private Direction direction;
	private boolean grow;

	public Snake(int x, int y, Direction direction) {
		Point head = new Point(x, y);
		points = new ArrayList<>();
		this.direction = direction;
		this.points.add(head);
	}

	public void move() {
		if (this.points.size() < MIN_SIZE) {
			this.grow();
		}
		Point head = this.points.get(this.points.size() - 1);
		Point newPoint = null;
		switch (this.direction) {
		case UP:
			newPoint = new Point(head.getX(), head.getY() - 1);
			break;
		case DOWN:
			newPoint = new Point(head.getX(), head.getY() + 1);
			break;
		case RIGHT:
			newPoint = new Point(head.getX() + 1, head.getY());
			break;
		case LEFT:
			newPoint = new Point(head.getX() - 1, head.getY());
			break;
		}
		this.points.add(newPoint);
		if (!this.grow) {
			this.points.remove(0);
		}
		this.grow = false;
	}

	public void grow() {
		grow = true;
	}

	public boolean colides(Point point) {
		for (Point p : this.points) {
			if (point.colides(p)) {
				return true;
			}
		}
		return false;
	}

	public boolean colidesSelf() {
		Point head = this.points.get(0);
		for (Point point : this.points.subList(1, this.points.size() - 1)) {
			if (head.colides(point)) {
				return true;
			}
		}
		return false;

	}

	public int getLength() {
		return points.size();
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
