package tpgeo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Segment extends Figure {
	private Point start;
	private Point end;
	private boolean horizontal;

	public Segment(Point point, int longueur, boolean horizontal) {

		this.start = point;
		this.horizontal = horizontal;
		if (horizontal) {
			end = new Point(point.getX() + longueur, point.getY());
		} else {
			end = new Point(point.getX(), point.getY() + longueur);
		}
	}

	public Segment(Point point, int longueur, boolean horizontal, Couleur couleur) {
		this(point, longueur, horizontal);
		super.col = couleur;
	}

	@Override
	public String toString() {
		return "Segment [start=" + start + ", end=" + end + ", horizontal=" + horizontal + ", col=" + col + "]";
	}

	@Override
	protected String getType() {
		return "SEGMENT";
	}

	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<Point>();
		points.add(start);
		points.add(end);
		return points;
	}

	public Boolean couvre(Point point) {
		return ((horizontal && (point.getX() >= start.getX() && point.getX() <= end.getX()))
				|| (!horizontal && (point.getY() >= start.getY() && point.getY() <= end.getY())));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + (horizontal ? 1231 : 1237);
		result = prime * result + ((start == null) ? 0 : start.hashCode());
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
		Segment other = (Segment) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (horizontal != other.horizontal)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (col != other.col) {
			return false;
		}
		return true;
	}

	@Override
	public double DistanceOrigine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void LOGGER(String string) {
		// TODO Auto-generated method stub
		
	}

}
