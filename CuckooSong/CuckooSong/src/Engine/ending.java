package Engine;

public class ending extends Tile {
	public ending(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	public boolean ending() {
		return true;
	}
}
