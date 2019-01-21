package tpgeo;
import java.util.ArrayList;
import java.util.List;

public class Dessin {
	private List<Figure> figures = new ArrayList<Figure>();

	public Dessin() {
		
		figures = new ArrayList<>();
	}
	
	public Figure addFigure(Figure figure) {
		figures.add(figure);
		return figure;
	}

	public List<Figure> getFigures() {
		return figures;
	}

}
