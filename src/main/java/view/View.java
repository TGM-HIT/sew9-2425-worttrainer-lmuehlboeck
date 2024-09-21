package view;

import controller.Controller;

public class View {
    private Controller controller;

    public View(Controller controller) {
        if(controller == null) throw new IllegalArgumentException();
        this.controller = controller;
    }

    public void setNum(int asked, int right) {

    }

    public void setImg(String url) {

    }
}
