package tpgeo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Figure implements Comparable<Figure> {
	
	protected Couleur col;
	public abstract String toString();

	private static int id = 0;

	protected abstract String getType();

	public void affiche() {
		LOGGER.trace(toString());
	}

	public abstract Collection<Point> getPoints();

	public abstract Boolean couvre(Point point);

	public double DistanceOrigine() {
		List<Double> d = new ArrayList<>();
		for (Point p : this.getPoints()) {
			d.add(p.distanceOrigine());
		}
		return Collections.min(d);
	}

	@Override
	public int compareTo(Figure o) {
		if (this.DistanceOrigine() > o.DistanceOrigine()) {
			return 1;

		} else if (this.DistanceOrigine() < o.DistanceOrigine()) {
			return -1;
		}
		return 0;
	}

	public String getId() {
		id++;
		return this.getType()+ id;
		
	}
	public Couleur getCouleur() {
		return col;
	}

}
