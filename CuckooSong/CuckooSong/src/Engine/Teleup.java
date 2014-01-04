

package Engine;

public class Teleup extends Tile {

	public Teleup(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	public boolean up() {
		return true;
	}
	
}