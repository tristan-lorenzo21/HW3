package studentappMVC;

import org.junit.Test;
import static org.junit.Assert.*;
import studentappMVC.model.BlueColor;
import studentappMVC.model.GreenColor;
import studentappMVC.model.RedColor;

public class ColorUnitTest {

    @Test
    public void testValues() {
        RedColor redColor = new RedColor();
        GreenColor greenColor = new GreenColor();
        BlueColor blueColor = new BlueColor();

        int redCorrectValue = 1;
        int greenCorrectValue = 2;
        int blueCorrectValue = 3;
        
        redColor.setSize(1);
        greenColor.setSize(2);
        blueColor.setSize(3);
        
        int redSize = redColor.getSize();
        int greenSize = greenColor.getSize();
        int blueSize = blueColor.getSize();
        
        assertEquals(redSize, redCorrectValue);
        assertEquals(greenSize, greenCorrectValue);
        assertEquals(blueSize, blueCorrectValue);
    }
}
