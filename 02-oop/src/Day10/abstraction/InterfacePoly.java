package Day10.abstraction;

public class InterfacePoly {
	public static void main(String[] args) {
//		Flying flyObj;
//		flyObj = new Bird();
//		flyObj.fly();
//		
//		flyObj = new AirPlane();
//		flyObj.fly();
//		
//		flyObj = new Human();
//		flyObj.fly();
		
		Flying[] flyarr = new Flying[3];
		
		flyarr[0] = new Bird();
		flyarr[1] = new AirPlane();
		flyarr[2] = new Human();
		
		for(Flying obj : flyarr)
			obj.fly();
	}
}
