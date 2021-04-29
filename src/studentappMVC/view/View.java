package studentappMVC.view;

import java.awt.FlowLayout;
import java.util.concurrent.BlockingQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import studentappMVC.controller.Message;
import studentappMVC.controller.ResetMessage;
import studentappMVC.controller.UpdateMessage;


public class View extends JFrame{
    BlockingQueue<Message> queue;

    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;

    JTextField redTextField;
    JTextField blueTextField;
    JTextField greenTextField;

    JLabel redResult;
    JLabel greenResult;
    JLabel blueResult;

    JButton updateButton;
    JButton resetButton;

    public View(BlockingQueue<Message> queue, String redColor, String blueColor, String greenColor) {
        this.queue = queue;

        this.redLabel = new JLabel(redColor);
        this.blueLabel = new JLabel(blueColor);
        this.greenLabel = new JLabel(greenColor);

        this.redTextField = new JTextField(10);
        this.blueTextField = new JTextField(10);
        this.greenTextField = new JTextField(10);

        this.redResult = new JLabel();
        this.greenResult = new JLabel();
        this.blueResult = new JLabel();


        this.updateButton = new JButton("update");
        this.resetButton = new JButton("reset");

        updateButton.addActionListener(e -> {
            int redSizeValue = Integer.parseInt(redTextField.getText());
            int greenSizeValue = Integer.parseInt(greenTextField.getText());
            int blueSizeValue = Integer.parseInt(blueTextField.getText());
            try {
                Message msg = new UpdateMessage(redSizeValue, blueSizeValue, greenSizeValue);
                queue.put(msg);
            } catch (InterruptedException exception) {

            }
        });

        resetButton.addActionListener(e -> {
            try {
                queue.put(new ResetMessage());
            } catch (InterruptedException exception) {

            }
        });

        this.setSize(400, 400);
        this.setLayout(new FlowLayout());

        this.add(redLabel);
        this.add(redTextField);

        this.add(greenLabel);
        this.add(greenTextField);

        this.add(blueLabel);
        this.add(blueTextField);

        this.add(updateButton);
        this.add(resetButton);

        this.add(redResult);
        this.add(blueResult);
        this.add(greenResult);


        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateSize(int redSize, int greenSize, int blueSize) {
        this.redResult.setText(("Red size: " + redSize));
        this.greenResult.setText(("Green size: " + greenSize));
        this.blueResult.setText(("Blue size: " + blueSize));
    }

    public void resetSize() {
        String resetValue = "0";
        this.redResult.setText(("Red size: " + resetValue));
        this.greenResult.setText(("Green size: " + resetValue));
        this.blueResult.setText(("Blue size: " + resetValue));
    }

}