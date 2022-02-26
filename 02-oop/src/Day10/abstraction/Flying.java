package Day10.abstraction;

public interface Flying {
	void fly();
}

class Bird implements Flying{

	@Override
	public void fly() {
		System.out.println("Birds fly with wings");
		
	}
	
}

class AirPlane implements Flying{

	@Override
	public void fly() {
		System.out.println("Airplanes fly with engine");
		
	}
	
}

class Human implements Flying{

	@Override
	public void fly() {
		System.out.println("Human fly with parachute");
		
	}
	
}