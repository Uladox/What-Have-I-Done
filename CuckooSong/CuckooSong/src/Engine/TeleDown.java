package Engine;

public class TeleDown extends Tile {

	public TeleDown(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean down() {
		return true;
	}
}