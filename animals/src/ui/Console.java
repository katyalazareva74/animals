package ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import classes.Dogan;
import exceptions.NoAddAnimalExeption;
import exceptions.NoAddCommandExeption;
import exceptions.NoFindAnimalExeption;
import presenter.Presenter;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean loop;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private int scan() {
        int n = 0;
        while (n <= 0 || n > 5) {
            System.out.println(
                    "\nЗоопарк:\n\n1. Поселить животное в зоопарк;"
                            +
                            "\n2. Найти животное по кличке и научить его новой команде;\n3. Показать весь зоопарк;"
                            +
                            "\n4. Посмотреть список команд животного;\n5. Выход\n");
            n = scanner.nextInt();
        }
        String str = scanner.nextLine();
        return n;
    }

    public void start() {
        loop = true;
        while (loop) {
            int number = scan();
            switch (number) {
                case 1:
                    addbyanimal();
                    break;
                case 2:
                    findanimal();
                    break;
                case 3:
                    showzoo();
                    break;
                case 4:
                    findanimal1();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    break;
            }
        }
    }

    public void addbyanimal() {
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println("Введите кличку животного: ");
            String nickname = scanner.nextLine();
            sb.append(nickname + " ");
            System.out.println("Введите год рождения: ");
            int birthyear = scanner.nextInt();
            sb.append(birthyear + " ");
            String sw = scanner.nextLine();
            System.out.println("Введите вид животного: cat, dog, hamster, horse, donkey, camel ");
            String vidanimal = scanner.nextLine();
            sb.append(vidanimal + " ");
            System.out.println(sb.toString());
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод года рождения животного!");
        }
        try {
            if (presenter.addA(sb.toString()))
                System.out.println("Животное успешно поселилось в зоопарке");
        } catch (NoAddAnimalExeption e) {
            System.out.println(e.getMessage());
        }
        String sw1 = scanner.nextLine();
    }

    public void showzoo() {
        List<Dogan> answer = presenter.showreg();
        for (Dogan animal : answer) {
            System.out.println(animal);
        }
    }

    public void findanimal() {
        System.out.println("Введите кличку животного: ");
        String str = scanner.nextLine();
        try {
            Dogan a = presenter.taskfind(str);
            System.out.println(a);
            System.out.println("Введите новую команду: ");
            String str1 = scanner.nextLine();
            a = presenter.newcommand(a, str1);
            System.out.println(a);
        } catch (NoAddCommandExeption | NoFindAnimalExeption e) {
            System.out.println(e.getMessage());
        }
    }

    public void findanimal1() {
        System.out.println("Введите кличку животного: ");
        String str = scanner.nextLine();
        try {
            Dogan a = presenter.taskfind(str);
            System.out.println(a.getCommands());
        } catch (NoAddCommandExeption | NoFindAnimalExeption e) {
            System.out.println(e.getMessage());
        }
    }

    private void exit() {
        System.out.println("Завершение работы");
        presenter.savezoo();
        scanner.close();
        loop = false;
    }
}
