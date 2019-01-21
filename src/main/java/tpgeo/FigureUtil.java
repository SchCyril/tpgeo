package tpgeo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class FigureUtil {

	private final static int RAND = 99;
	private final static int LIMITE_X = 50;
	private final static int LIMITE_Y = 50;

	private static Map<String, Figure> figures = new HashMap<>();
	public static int countFigure = 0;

	public static Point getRandomPoint() {
		return new Point(ThreadLocalRandom.current().nextInt(0, RAND), ThreadLocalRandom.current().nextInt(0, RAND));
	}

	public static Rond getRandomRond(Couleur col) {
		Rond rond = new Rond(getRandomPoint(), ThreadLocalRandom.current().nextInt(0, RAND), col);
		figures.put(rond.getId(), rond);
		return rond;
	}

	public static Rectangle getRandomRectangle(Couleur col) {
		Rectangle r = new Rectangle(getRandomPoint(), ThreadLocalRandom.current().nextInt(0, RAND),
				ThreadLocalRandom.current().nextInt(0, RAND), col);
		figures.put(r.getId(), r);
		return r;
	}

	public static Carre getRandomCarre(Couleur col) {
		Carre c = new Carre(getRandomPoint(), ThreadLocalRandom.current().nextInt(0, RAND), col);
		figures.put(c.getId(), c);
		return c;
	}

	public static Segment getRandomSegment(Couleur col) {
		Segment s = new Segment(getRandomPoint(), ThreadLocalRandom.current().nextInt(0, RAND),
				ThreadLocalRandom.current().nextBoolean(), col);
		figures.put(s.getId(), s);
		return s;
	}

	public static Figure getRandomFigure() {
		Couleur col = Couleur.getRandomCol();
		switch (ThreadLocalRandom.current().nextInt(0, 4)) {
		case 0:
			return getRandomRond(col);
		case 1:
			return getRandomCarre(col);
		case 2:
			return getRandomRectangle(col);
		case 3:
		default:
			return getRandomSegment(col);
		}
	}

	public static Surfacable getRandomSurface() {
		Couleur col = Couleur.getRandomCol();
		switch (ThreadLocalRandom.current().nextInt(0, 3)) {
		case 0:
			return getRandomRond(col);
		case 1:
			return getRandomCarre(col);
		case 2:
		default:
			return getRandomRectangle(col);
		}
	}

	public static Collection<Point> getPoints(Figure... figures) {
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < figures.length; i++) {
			points.addAll(figures[i].getPoints());
		}
		return points;
	}

	public static Collection<Figure> genere(int x) {
		List<Figure> figures = new ArrayList<>();
		for (int i = 0; i < x; i++) {
			figures.add(getRandomFigure());

		}
		return figures;
	}

	public static Figure getFigureEn(Point point, Dessin dessin) {
		List<Figure> liste = new ArrayList<Figure>();
		liste.addAll(dessin.getFigures());
		Iterator<Figure> i = liste.iterator();
		int cpt = 0;
		while (i.hasNext()) {
			if (liste.get(cpt).couvre(point)) {
				return liste.get(cpt);
			}
			cpt++;
			i.next();
		}
		return null;

	}

	public static Collection<Figure> trieProcheOrigine(Dessin dessin) {
//		List<Figure> figures = new ArrayList<>(dessin.getFigures());
//		Collections.sort(figures);
		return dessin.getFigures().stream().sorted().collect(Collectors.toList());
	}

	public static Collection<Figure> trieSurface(Dessin dessin) {
//		List<Figure> figures = new ArrayList<>(dessin.getFigures());
//		List<Figure> figureSurfacable = new ArrayList<>();
//		for (Figure tmp : figures) {
//			if (tmp instanceof Surfacable) {
//				figureSurfacable.add(tmp);
//			}
//		}
		return dessin.getFigures().stream().filter(f -> f instanceof Surfacable).sorted((o1, o2) -> {

			Surfacable s1 = (Surfacable) o1;
			Surfacable s2 = (Surfacable) o2;
			if (s1.surface() > s2.surface()) {
				return 1;
			} else if (s1.surface() < s2.surface()) {
				return -1;
			}
			return 0;
		}).collect(Collectors.toList());
	}

	public static void clearFigures() {
		figures.clear();
	}

	public static void imprime(Dessin dessin) throws ImpressionHorsLimite, IOException {
		List<Figure> figures = new ArrayList<>();
		for (Figure entry : dessin.getFigures()) {
			boolean horsLimite = false;
			for (Point point : entry.getPoints()) {
				if (point.getX() < 0 || point.getX() > LIMITE_X || point.getY() < 0 || point.getY() > LIMITE_Y) {
					horsLimite = true;
				}
			}
			if (!horsLimite) {
				figures.add(entry);
			}
		}
		File f = new File("test.txt");
		PrintWriter pw = new PrintWriter(f);

		for (Figure fig : figures) {
			pw.write(fig.toString());
			pw.write(System.lineSeparator());

		}

		pw.write("==================================================================\r\n");

		char[][] tab = new char[LIMITE_X + 1][LIMITE_Y + 1];
		for (int x = 0; x < LIMITE_X + 1; x++) {
			for (int y = 0; y < LIMITE_Y + 1; y++) {
				tab[x][y] = ' ';
			}
		}

		for (Figure fi : figures) {
			for (Point p : fi.getPoints()) {
				tab[p.getX()][p.getY()] = fi.getCouleur().getValeur();
			}
		}

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < LIMITE_Y; i++) {
			for (int j = 0; j < LIMITE_X; j++) {
				str.append(tab[i][j]);
			}
			str.append("\r\n");
		}
		pw.println(str.toString());
		pw.close();
	}

	public static void readFile(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		boolean separator = false;
		StringBuilder str = new StringBuilder();
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			if (!separator && line.startsWith("=")) {
				separator = true;
				continue;
			}
			if (separator) {
				if (line.length() > 0) {
					for (int i = 0; i < LIMITE_X; i++) {
						str.append(line.charAt(i)).append(", ");
					}
					str.append("\r\n");
				}
			}
		}
		LOGGER.trace(str.toString());
		br.close();
		fr.close();
	}
}
