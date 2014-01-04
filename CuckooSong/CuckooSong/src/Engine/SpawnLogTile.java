package Engine;

public class SpawnLogTile extends Tile {
	public SpawnLogTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
		
	}

	public boolean solid() {
		return true;
	}
	public boolean front() {
		return true;
	}
}
