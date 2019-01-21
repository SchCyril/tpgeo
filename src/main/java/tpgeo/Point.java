package tpgeo;
public class Point {
	private int x;
	private int y;
	private final int INIT_X = 25;
	private  final int INIT_Y = 25;

	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getINIT_X() {
		return INIT_X;
	}

	public int getINIT_Y() {
		return INIT_Y;
	}

	public String toString() {
		String str = "[" + x + "][" + y + "]";
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public double distance (Point point) {
		double l = Math.pow((point.getX() - this.getX()), 2.0);
		double ll = Math.pow((point.getY() - this.getY()), 2.0);
		return Math.sqrt(l + ll);
	}

	public Double distanceOrigine() {
		double l = Math.pow((this.getX() - this.INIT_X), 2.0);
		double ll = Math.pow((this.getY() - this.INIT_Y), 2.0);
		return Math.sqrt(l + ll);
	}

}
