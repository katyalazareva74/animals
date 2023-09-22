package presenter;

import java.util.List;

import classes.Dogan;
import service.Service;
import ui.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public boolean addA(String str) {
        return service.addAnimal(str);
    }

    public List<Dogan> showreg() {
        return service.showreganimal();
    }

    public Dogan newcommand(Dogan a, String str) {
        return service.addnewco(a, str);
    }

    public Dogan taskfind(String str) {
        return service.fanimal(str);
    }

    public void savezoo() {
        service.saveanimals();
    }
}
