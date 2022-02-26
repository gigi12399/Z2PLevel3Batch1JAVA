package Day10.abstraction;

public class ProductService extends DatabaseUtil {

	@Override
	public void insert() {
		System.out.println("insert into product");
		
	}

	@Override
	public void update() {
		System.out.println("update product");
		
	}

	@Override
	public boolean delete(int id) {
		System.out.println("Delete form product where id = " + id);
		return false;
	}

	@Override
	public Object[] getAll() {
		System.out.println("SELECT * FROM product");
		return null;
	}

	@Override
	public Object findById(int id) {
		System.out.println("SELECT * FROM product WHERE id = " + id);
		return null;
	}
	
		
}
