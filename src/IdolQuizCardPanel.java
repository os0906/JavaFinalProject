import java.awt.*;
import javax.swing.*;

public class IdolQuizCardPanel extends JPanel {
    IdolQuizCardPanel(int index) {
        ImageIcon image = new ImageIcon("images/" + MainFrame.characterArr[index].getName() + ".jpg");
        Image img = image.getImage();
        add(new JLabel(new ImageIcon(img)), BorderLayout.CENTER);
    }
}
//IdolImage Card Panel