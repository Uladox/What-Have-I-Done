package Engine;

import java.io.IOException;





public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	//public static boolean front = false;

	public void move(int xa, int ya) {
		if(xa != 0 && ya != 0){
			move(xa, 0);
			move(0, ya);
			return;
		}
    if(xa > 0) dir = 1;
	if(xa < 0) dir = 3;
	if(ya > 0) dir = 2;
	if(ya < 0) dir = 0;

		if(!collision(xa, ya)) {
			x += xa;
			y += ya;
			//Sound.Test.play();
		}
		
		
		if(up(xa, ya)){
			
			System.out.println("up");
			
			y -= 89*16;
					
		}
		if(down(xa, ya)){
			
			System.out.println("down");
			
				y += 89*16;	
		}
	}

	public void update() {
	}

	public void render() {
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		
		for(int c =0; c<4; c++){
			int xt=((x+xa) +c % 2 *10 - 6)/16;
			int yt =((y+ya)+c/2 *10 + 5)/16;
		
			
			//int xt = (x + xa)/16;
			//int yt = (y + ya)/16;
			if(level.getTile(xt, yt).solid()) solid = true;
			
			//if(level.getTile(xt, yt).front()) front = true;
			//if(!level.getTile(xt, yt).front()) front = false;
		}
	
		return solid;
	}
	private boolean ending(int xa, int ya) {
		boolean ending = false;
		
		for(int c =0; c<4; c++){
			int xt=((x+xa) +c % 2 *10 - 6)/16;
			int yt =((y+ya)+c/2 *10 + 5)/16;
		
			
			//int xt = (x + xa)/16;
			//int yt = (y + ya)/16;
			if(level.getTile(xt, yt).ending()) ending = true;
			
			//if(level.getTile(xt, yt).front()) front = true;
			//if(!level.getTile(xt, yt).front()) front = false;
		}
	
		return ending;
	}
	
	private boolean up(int xa, int ya) {
		boolean up = false;
		
		for(int c =0; c<4; c++){
			int xt=((x+xa) +c % 2 *10 - 6)/16;
			int yt =((y+ya)+c/2 *10 + 5)/16;
		
			
			//int xt = (x + xa)/16;
			//int yt = (y + ya)/16;
			if(level.getTile(xt, yt).up()) up = true;
			
			//if(level.getTile(xt, yt).front()) front = true;
			//if(!level.getTile(xt, yt).front()) front = false;
		}
	
		return up;
	}
	
	private boolean down(int xa, int ya) {
		boolean down = false;
		
		for(int c =0; c<4; c++){
			int xt=((x+xa) +c % 2 *10 - 6)/16;
			int yt =((y+ya)+c/2 *10 + 5)/16;
		
			
			//int xt = (x + xa)/16;
			//int yt = (y + ya)/16;
			if(level.getTile(xt, yt).down()) down = true;
			
			//if(level.getTile(xt, yt).front()) front = true;
			//if(!level.getTile(xt, yt).front()) front = false;
		}
	
		return down;
	}
	//public boolean getfront(int xa, int ya) {
		
		
		//for(int c =0; c<4; c++){
		//	int xt=((x+xa) +c % 2 *10 - 6)/16;
		//	int yt =((y+ya)+c/2 *10 + 5)/16;
		
			
			//int xt = (x + xa)/16;
			//int yt = (y + ya)/16;
			
			
		//	if(level.getTile(xt, yt).front()||
		//		level.getTile(-xt, yt).front()|| 
		//		level.getTile(xt, -yt).front()|| 
		//		level.getTile(-xt, -yt).front()|| 
		//		level.getTile(xt, yt).front()) front = true;
		//	if(!level.getTile(xt, yt).front())   front = false;
		//}
	
	//	return front;
	//}

//	public static boolean front() {
	//	
	//	return front;
	//}

	
		
	
	}
