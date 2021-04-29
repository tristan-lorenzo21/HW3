package studentappMVC.controller;

import studentappMVC.model.BlueColor;
import studentappMVC.model.GreenColor;
import studentappMVC.model.RedColor;
import studentappMVC.view.View;

import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    RedColor redColor;
    BlueColor blueColor;
    GreenColor greenColor;
    View view;

    public Controller(BlockingQueue<Message> queue, RedColor redColor, GreenColor greenColor, BlueColor blueColor, View view) {
        this.queue = queue;
        this.view = view;
        this.redColor = redColor;
        this.greenColor = greenColor;
        this.blueColor = blueColor;
    }

    public void mainLoop() {
        while (view.isDisplayable()) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception) {

            }

            if(message.getClass() == UpdateMessage.class) {
                UpdateMessage update = (UpdateMessage) message;
                redColor.setSize(update.getRedSize());
                greenColor.setSize(update.getGreenSize());
                blueColor.setSize(update.getBlueSize());
                view.updateSize(redColor.getSize(), blueColor.getSize(), greenColor.getSize());
            } else if (message.getClass() == ResetMessage.class) {
                view.resetSize();
            }
        }
    }
}

