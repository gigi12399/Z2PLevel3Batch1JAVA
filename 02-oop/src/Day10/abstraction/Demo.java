package Day10.abstraction;

public class Demo {
	public static void main(String[] args) {
		ProductService pService = new ProductService();
		pService.connectDatabase();
		pService.insert();
		pService.update();
		pService.delete(10);
		pService.getAll();
		pService.findById(9);
		
		DatabaseUtil service = pService;
		service.insert();
		service = new CategoryService();
		service.insert();
	}
}
