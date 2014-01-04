package Engine;


public class GameInheritedClass {
	public static String Title = "Loading...";
	public static String Lpath;
	public static String Ppath;
	public static int Psize;
	
	public static String UpdatedTitle(String name){
		Title = name;
		return Title;
	}
	public static String LevelPath(String lpath){
		Lpath = lpath;
		return Lpath;
		
	}
	public static  String PlayerPath(String ppath){
		Ppath = ppath;
		return Ppath;
		
	}
	public static int PlayerSize(int psize){
		Psize = psize;
		return Psize;
	}
}
