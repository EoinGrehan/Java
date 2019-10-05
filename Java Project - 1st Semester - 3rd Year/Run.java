


public class Run {


	public static void main(String[] args) 
	{
		
		ScreenA myScreenA = new ScreenA();
		ScreenB myScreenB = new ScreenB();
		
		myScreenA.passScreenB(myScreenB);
		myScreenB.passScreenA(myScreenA);
		

	}

	
	
	
}
