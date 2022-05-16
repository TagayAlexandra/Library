package by.itac.mylibrary.main;

import by.itac.mylibrary.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
    String s = controller.executeTask("FInd_BoOK_bY_AUTHOR b");

    System.out.println(s);

    }
}
