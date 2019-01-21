package tpgeo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rond extends Figure implements Surfacable {
	private Point point;
	private int rayon;

	public Rond(Point point, int rayon) {
		this.point = point;
		this.rayon = rayon;
		super.col = Couleur.getCouleurDefaut();

	}

	public Rond(Point point, int rayon, Couleur couleur) {
		this(point, rayon);
		super.col = couleur;
	}

	public Point getPoint() {
		return point;
	}

	public int getRayon() {
		return rayon;
	}

	@Override
	public String toString() {
		return "Rond [point=" + point + ", rayon=" + rayon + ", col=" + col + "]";
	}

	protected String getType() {
		return "ROND";
	}

	public double surface() {
		return (Math.PI * Math.pow(rayon, 2.0));
	}

	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<Point>();
		points.add(point);
		return points;
	}

	@Override
	public Boolean couvre(Point point) {
		double l = Math.pow((point.getX() - this.point.getX()), 2.0);
		double ll = Math.pow((point.getY() - this.point.getY()), 2.0);
		return Math.sqrt(l + ll) <= this.rayon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + rayon;
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
		Rond other = (Rond) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		if (rayon != other.rayon)
			return false;
		if(col != other.col) {
			return false;
		}
		return true;
	}

	@Override
	public double DistanceOrigine() {
		return point.distance(new Point(point.getINIT_X(), point.getINIT_Y()));
	}

}
