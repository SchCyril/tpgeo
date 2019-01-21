package tpgeo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rectangle extends Figure implements Surfacable {
	protected Point pointBasGauche;
	protected Point pointBasDroit;
	protected Point pointHautGauche;
	protected Point pointHautDroit;

	public Rectangle(Point point, int w, int h) {
		pointBasGauche = point;
		pointBasDroit = new Point(point.getX() + w, point.getY());
		pointHautGauche = new Point(point.getX(), point.getY() + h);
		pointHautDroit = new Point(point.getX() + w, point.getY() + h);
		col = Couleur.getCouleurDefaut();
	}

	public Rectangle(Point point, int w, int h, Couleur couleur) {
		this(point, w, h);
		col = couleur;
	}

	protected String getType() {
		return "RECT";
	}

	@Override
	public String toString() {
		return "Rectangle [pointBasGauche=" + pointBasGauche + ", pointBasDroit=" + pointBasDroit + ", pointHautGauche="
				+ pointHautGauche + ", pointHautDroit=" + pointHautDroit + ", col=" + col + "]";
	}

	public Point getPointBasGauche() {
		return pointBasGauche;
	}

	public Point getPointBasDroit() {
		return pointBasDroit;
	}

	public Point getPointHautGauche() {
		return pointHautGauche;
	}

	public Point getPointHautDroit() {
		return pointHautDroit;
	}

	public double surface() {
		return (Math.abs(pointBasDroit.getX() - pointBasGauche.getX())
				* Math.abs(pointHautGauche.getY() - pointBasGauche.getY()));
	}

	@Override
	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<Point>();
		points.add(pointBasDroit);
		points.add(pointHautDroit);
		points.add(pointBasGauche);
		points.add(pointHautGauche);
		return points;

	}

	public Boolean couvre(Point point) {
		return (point.getX() >= pointBasGauche.getX() && point.getX() <= pointHautDroit.getX()
				&& point.getY() >= pointBasGauche.getY() && point.getY() <= pointHautDroit.getY());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointBasDroit == null) ? 0 : pointBasDroit.hashCode());
		result = prime * result + ((pointBasGauche == null) ? 0 : pointBasGauche.hashCode());
		result = prime * result + ((pointHautDroit == null) ? 0 : pointHautDroit.hashCode());
		result = prime * result + ((pointHautGauche == null) ? 0 : pointHautGauche.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		

		Rectangle other = (Rectangle) obj;
		if (pointBasDroit == null) {
			if (other.pointBasDroit != null)
				return false;
		} else if (!pointBasDroit.equals(other.pointBasDroit))
			return false;
		if (pointBasGauche == null) {
			if (other.pointBasGauche != null)
				return false;
		} else if (!pointBasGauche.equals(other.pointBasGauche))
			return false;
		if (pointHautDroit == null) {
			if (other.pointHautDroit != null)
				return false;
		} else if (!pointHautDroit.equals(other.pointHautDroit))
			return false;
		if (pointHautGauche == null) {
			if (other.pointHautGauche != null)
				return false;
		} else if (!pointHautGauche.equals(other.pointHautGauche))
			return false;
		if(col != other.col) {
			return false;
		}
		return true;
		
	}

	@Override
	protected void LOGGER(String string) {
		// TODO Auto-generated method stub
		
	}

}
