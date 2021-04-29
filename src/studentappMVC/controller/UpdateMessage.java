package studentappMVC.controller;

public class UpdateMessage implements Message {

    int redValue;
    int greenValue;
    int blueValue;

    public UpdateMessage(int redValue, int blueValue, int greenValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public int getRedSize() {
        return redValue;
    }

    public int getGreenSize() {
        return greenValue;
    }

    public int getBlueSize() {
        return blueValue;
    }
}