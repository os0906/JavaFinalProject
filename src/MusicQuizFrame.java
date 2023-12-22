import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;
public class MusicQuizFrame extends JFrame {
    private int index = 0;
    private final JTextField answerField;
    private final JLabel infoMessage = new JLabel();
    private final JLabel inCorrectInfoMessage = new JLabel();

    private final JPanel inCorrectPanel = new JPanel(new FlowLayout());
    private final JPanel correctPanel = new JPanel(new FlowLayout());
    private final JPanel hintPanel = new JPanel(new GridLayout(3,1,10,10));
    private final JPanel statusPanel = new JPanel(new FlowLayout());
    private final JPanel answerPanel = new JPanel(new FlowLayout());
    private final MyButton replayButton =new MyButton("REPLAY");
    private final MyButton randomReplayButton = new MyButton("RANDOM REPLAY");
    private final MyButton hintButton = new MyButton("ARTIST HINT");
    private JLabel albumArt;
    private final JLabel indexLabel;
    private JLabel artistLabel= new JLabel();
    private Timer timer;
    private final JLabel clearLabel=new JLabel("CLEAR! Thank you for Playing!");
    private TimerTask task;
    public Clip clip;
    private ImageIcon image;
    public MusicQuizFrame(){
        super("MusicQuiz");
        MainFrame.musicShuffle();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(clip!=null){
                    clip.stop();
                }
               setVisible(false);
               MainFrame.isQuizOpened=false;
               dispose();
            }
        });
        inCorrectPanel.add(inCorrectInfoMessage);
        MyButton retryButton = new MyButton("Retry");
        inCorrectPanel.add(retryButton);
        correctPanel.add(infoMessage);
        MyButton nextButton = new MyButton("Next");
        correctPanel.add(nextButton);
        indexLabel=new JLabel("index : 1/30");
        indexLabel.setHorizontalAlignment(JLabel.CENTER);
        clearLabel.setFont(new Font("Serif",Font.BOLD,30));
        answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(200,20));
        answerPanel.add(answerField);

        answerField.addActionListener(e -> {
            if (MainFrame.musicArr[index].isAnswer(answerField.getText())) {
                handleCorrectAnswer();
            } else {
                handleIncorrectAnswer();
            }
            answerField.setText(null);
        });
        nextButton.addActionListener(e-> handleNext());
        replayButton.addActionListener(e->{
            try {
                clip.stop();
                clip.setFramePosition(0);
                clip.start();
                initializeTimer();
                replayButton.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        randomReplayButton.addActionListener(e->{
            try {
                clip.stop();
                clip.setFramePosition((int)(Math.random()*clip.getFrameLength()*9/10));
                clip.start();
                initializeTimer();
                randomReplayButton.setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        hintButton.addActionListener(e->{
            try {
                hintPanel.remove(2);
                artistLabel = new JLabel(MainFrame.musicArr[index].getArtist());
                hintPanel.add(artistLabel,2);
                artistLabel.setHorizontalAlignment(JLabel.CENTER);
                repaint();
                revalidate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        hintPanel.add(replayButton);
        hintPanel.add(randomReplayButton);
        hintPanel.add(hintButton);

        add(indexLabel,BorderLayout.NORTH);
        add(hintPanel,BorderLayout.CENTER);
        add(answerPanel,BorderLayout.SOUTH);

        retryButton.addActionListener(e -> handleRetry());
        setSize(640,810);
        playMusic();
    }

    private void handleCorrectAnswer() {
        if(index==29){
            handleClear();
        }
        else {
            hintPanel.setVisible(false);
            image = new ImageIcon("audio/" + MainFrame.musicArr[index].getName() + ".jpg");
            Image img = image.getImage();
            albumArt = new JLabel(new ImageIcon(img));
            add(albumArt, BorderLayout.CENTER);
            timer.cancel();
            clip.stop();
            answerPanel.setVisible(false);
            add(correctPanel,BorderLayout.SOUTH);
            infoMessage.setText("CORRECT! " + MainFrame.musicArr[index].getName()+" - "+MainFrame.musicArr[index].getArtist());
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    clip.setFramePosition(clip.getFrameLength()/4);
                    clip.start();
                }
            };
            timer.schedule(task,500);

        }
    }
    private void handleNext() {
        if(index==29){
            handleClear();
        }
        else{
            clip.stop();
            index++;
            artistLabel.setText(MainFrame.musicArr[index].getArtist());
            remove(albumArt);
            remove(correctPanel);
            answerPanel.setVisible(true);
            hintPanel.setVisible(true);
            indexLabel.setText("index : "+ (index + 1) +"/30");
            initializeHint();
            repaint();
            revalidate();
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    playMusic();
                }
            };
            timer.schedule(task,500);
        }
    }

    private void handleIncorrectAnswer() {
        hintPanel.setVisible(false);
        answerPanel.setVisible(false);

        image = new ImageIcon("audio/" + MainFrame.musicArr[index].getName() + ".jpg");
        Image img = image.getImage();
        albumArt = new JLabel(new ImageIcon(img));
        add(albumArt, BorderLayout.CENTER);

        timer.cancel();
        clip.stop();

        inCorrectInfoMessage.setText("INCORRECT.. "+MainFrame.musicArr[index].getName()+" - "+MainFrame.musicArr[index].getArtist());
        add(inCorrectPanel,BorderLayout.SOUTH);

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                clip.setFramePosition(clip.getFrameLength()/4);
                clip.start();
            }
        };
        timer.schedule(task,500);
    }
    private void handleRetry() {
        clip.stop();

        remove(albumArt);
        remove(inCorrectPanel);

        answerPanel.setVisible(true);
        hintPanel.setVisible(true);

        MainFrame.musicShuffle();

        index=0;
        initializeHint();

        repaint();
        revalidate();

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                playMusic();
            }
        };
        timer.schedule(task,500);
    }

    private void handleClear(){
        statusPanel.setVisible(false);
        answerPanel.setVisible(false);
        hintPanel.setVisible(false);
        indexLabel.setVisible(false);
        clip.stop();
        repaint();
        revalidate();
        clearLabel.setHorizontalAlignment(JLabel.CENTER);
        add(clearLabel,BorderLayout.CENTER);
        timer.cancel();
    }
    private void playMusic(){
        try {
            FileInputStream fileInputStream = new FileInputStream("audio/" + MainFrame.musicArr[index].getName() + ".wav");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(bufferedInputStream));
            clip.start();
            initializeTimer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void initializeTimer(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                clip.stop();
            }
        };
        timer.schedule(task,3000);
    }
    //3seconds music timer
    private void initializeHint(){
        replayButton.setVisible(true);
        randomReplayButton.setVisible(true);
        hintPanel.remove(2);
        hintPanel.add(hintButton,2);
    }
    //initialize(setVisible) Hint Buttons after using Hints.
}