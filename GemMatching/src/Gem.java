import java.awt.Font;
import java.util.Random;

enum GemType {
    GREEN, BLUE, ORANGE;
}


public class Gem {
	private int pointVal;
	private GemType type;

	public Gem() {
		Random rng = new Random();
		int random = rng.nextInt(3);

		if (random == 0) {
			type = GemType.ORANGE;
		}
		else if (random == 1) {
			type = GemType.GREEN;
		}
		else if (random == 2) {
			type = GemType.BLUE;
		}
		pointVal = rng.nextInt(10) * 5;
	}

	public Gem(GemType type, int points) {
		this.type = type;
		this.pointVal = points;
	}

	public String toString() {
		return type + " " + pointVal;
	}

	public GemType getType() {
		return type;
	}

	public int getPoints() {
		return pointVal;
	}

	public void draw(double x, double y) {
		if (type.equals(GemType.BLUE)) {
			StdDraw.picture(x, y, "gem_blue.png");
		}
		if (type.equals(GemType.GREEN)) {
			StdDraw.picture(x, y, "gem_green.png");
		}
		if (type.equals(GemType.ORANGE)) {
			StdDraw.picture(x, y, "gem_orange.png");
		}

		StdDraw.text(x, y, String.valueOf(pointVal));
	}

	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;

		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);

		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
