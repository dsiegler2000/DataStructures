package lab2;

public class Coord {
	
	private int rPos;
	private int cPos;

	public Coord(int r, int c) {
		
		rPos = r;
		cPos = c;
		
	}

	public boolean isFree() {
		
		return (rPos == 0 && cPos == 0);
		
	}

	public void setPos(int r, int c) {
		
		rPos += r;
		cPos += c;
		
	}
	
	public int getR(){
		
		return rPos;
		
	}
	
	public int getC(){
		
		return cPos;
		
	}

}
