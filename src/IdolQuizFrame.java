import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class IdolQuizFrame extends JFrame {
    public int index = 0;
    public static CardLayout idolCl = new CardLayout();
    public static JPanel idolCards = new JPanel(new CardLayout());

    private final JTextField answerField;
    private final JLabel inCorrectMessage=new JLabel();
    private final JPanel inCorrectPanel = new JPanel(new FlowLayout());
    private final JPanel statusPanel = new JPanel(new FlowLayout());

    private final JPanel answerPanel = new JPanel(new FlowLayout());
    private final JLabel timerLabel;
    private final JLabel indexLabel;
    private static Timer timer;
    private final JLabel clearLabel=new JLabel("CLEAR! Thank you for Playing!");

    private int count=0;
    public IdolQuizFrame(){

        super("idolQuiz");
        initializeCards();
        idolCl = (CardLayout) idolCards.getLayout();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                MainFrame.isQuizOpened=false;
                dispose();
                CleanCards();
            }
        });

        inCorrectPanel.add(inCorrectMessage);
        MyButton retry = new MyButton("Retry");
        inCorrectPanel.add(retry);
        indexLabel=new JLabel("index : 1/50");
        clearLabel.setFont(new Font("Serif",Font.BOLD,30));
        answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(150,20));
        answerPanel.add(answerField);
        timerLabel = new JLabel("Time: " + 5 + "s");
        retry.addActionListener(e -> handleRetry());
        statusPanel.add(timerLabel);
        statusPanel.add(indexLabel);
        timerLabel.setHorizontalAlignment(JLabel.LEFT);
        indexLabel.setHorizontalAlignment(JLabel.RIGHT);
        answerField.addActionListener(e -> {
            if (MainFrame.characterArr[index].isAnswer(answerField.getText())) {
                    handleCorrectAnswer();
            } else {
                handleIncorrectAnswer();
            }
            answerField.setText(null);
        });
        setLayout(new BorderLayout());
        add(answerPanel,BorderLayout.SOUTH);
        answerField.setVisible(true);
        add(statusPanel,BorderLayout.NORTH);
        setSize(1000,810);
        add(idolCards,BorderLayout.CENTER);
        idolCards.setVisible(true);
        initializeTimer();
    }
    public static void CleanCards(){
        idolCards.removeAll();
        idolCl.removeLayoutComponent(idolCards);
    }
    private void handleCorrectAnswer() {
        if(index==49){
            handleClear();
        }
        else {
            timer.cancel();
            IdolQuizFrame.idolCl.next(IdolQuizFrame.idolCards);
            index++;
            indexLabel.setText("index : " + (index + 1) +"/50");
            initializeTimer();
        }
    }
    private void handleIncorrectAnswer() {
        timer.cancel();
        timerLabel.setVisible(false);
        answerPanel.setVisible(false);
        inCorrectMessage.setText(MainFrame.characterArr[index].getName()+" - "+MainFrame.characterArr[index].getGroup());
        add(inCorrectPanel, BorderLayout.SOUTH);
        repaint();
        revalidate();
    }
    private void handleRetry() {
        remove(inCorrectPanel);
        answerPanel.setVisible(true);
        timerLabel.setVisible(true);
        IdolQuizFrame.CleanCards();
        initializeCards();
        index=0;
        repaint();
        revalidate();
        initializeTimer();
    }
    private void handleClear(){
        statusPanel.setVisible(false);
        idolCards.setVisible(false);
        answerPanel.setVisible(false);
        repaint();
        revalidate();
        clearLabel.setHorizontalAlignment(JLabel.CENTER);
        add(clearLabel,BorderLayout.CENTER);
        timer.cancel();
    }

    private void initializeTimer(){
        count=0;
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (count == 5) {
                    timer.cancel();
                    handleIncorrectAnswer();
                } else {
                    count++;
                    timerLabel.setText("Time: " + (6 - count) + "s");
                    validate();
                    repaint();
                }
            }
        };
        repaint();
        timer.schedule(task,1000,1000);
    }
    private void initializeCards(){
        MainFrame.charShuffle();
        for(int i=0;i<50;i++){
            IdolQuizCardPanel idolQuizCardPanel=new IdolQuizCardPanel(i);
            idolCards.add(idolQuizCardPanel);
        }
    }
}

