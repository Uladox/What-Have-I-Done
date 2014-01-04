package Engine;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
  public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	//my custom stuff
	public static Tile spawn_tree = new SpawnTreeTile(Sprite.spawn_tree);
	public static final int col_spawn_tree = 0xff491D00;
	public static Tile InvisiTile = new InvisiTile(Sprite.InvisiSprite);
	
	public static Tile spawn_drygrass = new SpawnDryGrassTile(Sprite.spawn_drygrass);
	public static final int col_spawn_drygrass = 0xff72520B;
	
	public static Tile spawn_log = new SpawnLogTile(Sprite.spawn_log);
	public static final int col_spawn_log = 0xff564216;
	
	public static Tile ending = new ending(Sprite.spawn_drygrass);
	public static final int col_ending = 0xff000000;
	
	public static Tile teleup = new Teleup(Sprite.spawn_drygrass);
	public static final int col_teleup = 0xff00FFFF;
	
	public static Tile teledown = new TeleDown(Sprite.spawn_drygrass);
	public static final int col_teledown = 0xffFF0000;

  public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);

  public static final int col_spawn_grass = 0xff00ff00;
	public static final int col_spawn_hedge = 0; // unused
	public static final int col_spawn_water = 0; // unused
	public static final int col_spawn_wall1 = 0xff808080;
	public static final int col_spawn_wall2 = 0xff303030;
	public static final int col_spawn_floor = 0xff724715;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {	
	}

	public boolean solid() {
		return false;
	}
	public boolean ending() {
		return false;
	}
	public boolean up() {
		return false;
	}
	public boolean down() {
		return false;
	}
}