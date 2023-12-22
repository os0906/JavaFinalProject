import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class HelpFrame extends JFrame{
    ImageIcon image = new ImageIcon("images/Help.jpg");
    HelpFrame(){
        super("help");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                MainFrame.isHelpOpened=false;
                dispose();
            }
        });
        Image img = image.getImage();
        add(new JLabel(new ImageIcon(img)), BorderLayout.CENTER);
        setSize(2000,900);
    }
}
//Help frame
