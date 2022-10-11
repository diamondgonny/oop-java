package academy.pocu.comp2500.assignment2.app;

import academy.pocu.comp2500.assignment2.App;
import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {

    public static void main(String[] args) {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
    }
}
