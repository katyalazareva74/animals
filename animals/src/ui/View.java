package ui;

import presenter.Presenter;

public interface View{
    void start();
    void addbyanimal();
    void showzoo();
    void findanimal();
    void setPresenter(Presenter presenter);
}
