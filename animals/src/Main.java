
import createzoo.RegDog;
import file.OutInput;
import file.SaveLoad;
import presenter.Presenter;
import service.RegistryService;
import service.Service;
import ui.Console;
import ui.View;


public class Main {
    public static void main(String[] args) {

        OutInput outIn = new SaveLoad();
        RegDog registry = new RegDog();
        View view = new Console();
        registry = (RegDog)outIn.load();
        Service service = new RegistryService(registry);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
