package Day10.abstraction;

public class CategoryService extends DatabaseUtil {

	@Override
	public void insert() {
		System.out.println("INSERT INTO category");
		
	}

	@Override
	public void update() {
		System.out.println("UPDATE category");
		
	}

	@Override
	public boolean delete(int id) {
		System.out.println("DELETE FORM category WHERE id = " + id);
		return false;
	}

	@Override
	public Object[] getAll() {
		System.out.println("SELECT * FROM category");
		return null;
	}

	@Override
	public Object findById(int id) {
		System.out.println("SELECT * FROM category WHERE id = " + id);
		return null;
	}

}
