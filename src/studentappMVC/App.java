package studentappMVC;


import studentappMVC.controller.Controller;
import studentappMVC.controller.Message;
import studentappMVC.model.BlueColor;
import studentappMVC.model.GreenColor;
import studentappMVC.model.RedColor;
import studentappMVC.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String [] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        RedColor red = new RedColor();
        GreenColor green = new GreenColor();
        BlueColor blue = new BlueColor();
        View view = new View(queue, red.getColorName(), green.getColorName(), blue.getColorName());
        Controller controller = new Controller(queue, red, green, blue, view);
        controller.mainLoop();
    }
}
