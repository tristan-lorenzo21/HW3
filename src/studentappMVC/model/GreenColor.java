package studentappMVC.model;

public class GreenColor {
    private int size;
    private String color = "Green";

    public String getColorName() {
        return color;
    }
    public void setSize(int size) {
        if (size >= 0) {
            this.size = size;
        } else {
            size = 0;
        }
    }
    public int getSize() {
        return size;
    }
}