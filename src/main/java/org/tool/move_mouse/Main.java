package org.tool.move_mouse;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) throws AWTException {
        // Extract screen dimensions to obtain the mid width
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int screenMidWidth = screenDimension.width / 2;

        // Create a robot and start the infinite loop
        Robot robot = new Robot();
        while (Boolean.TRUE) {
            try {
                // Sleep for 4 mins
                Thread.sleep(4 * (60 * 1000));
            } catch(InterruptedException e) { }
            
            // Extract current mouse position
            PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            Point point = pointerInfo.getLocation();
            int x = (int) point.getX();
            int y = (int) point.getY();

            // Modify mouse X axis depending on current mouse position and screenWidth
            if (x < screenMidWidth) {
                x++;
            } else {
                x--;
            }

            // Actually move the mouse
            robot.mouseMove(x, y);
        }
    }
}
