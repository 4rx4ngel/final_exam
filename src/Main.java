import service.RegistryService;
import view.View;



public class Main {
    public static void main(String[] args) {
        RegistryService registry = new RegistryService();
        View consoleInterface = new View(registry);
        consoleInterface.start();
    }
}