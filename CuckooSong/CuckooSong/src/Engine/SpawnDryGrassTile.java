package Engine;

public class SpawnDryGrassTile extends Tile {
	public SpawnDryGrassTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
