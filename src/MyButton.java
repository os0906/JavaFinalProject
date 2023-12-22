import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyButton extends JButton {
    MyButton(String str){
        super(str);
        setForeground(new Color(255,255,255));
        setBackground(new Color(43,45,48));
        Border border = BorderFactory.createEmptyBorder(10, 20, 10, 20);
        setBorder(border);
        setFocusPainted(false);
        setBorderPainted(false);
    }
}
//MyButton class
