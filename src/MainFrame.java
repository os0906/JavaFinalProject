import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainFrame extends JFrame {
public static boolean isQuizOpened=false;
public static boolean isHelpOpened=false;
public static Character[] characterArr = new Character[50];
public static Music[] musicArr = new Music[30];
    public MainFrame(){
        super("main");
        InitCharArray();
        InitMusicArray();
        charShuffle();
        musicShuffle();
        setSize(500,250);
        setLayout(new FlowLayout());
        setVisible(true);
        MyButton musicQuizButton = new MyButton("Music Quiz");
        musicQuizButton.addActionListener(e -> {
            if(!isQuizOpened) {
                MusicQuizFrame musicQuizFrame = new MusicQuizFrame();
                musicQuizFrame.setVisible(true);
                isQuizOpened = true;
            }
        });
        MyButton idolQuizButton = new MyButton("Idol Quiz");
        MyButton helpButton = new MyButton("?");
        helpButton.addActionListener(e->{
            if(!isHelpOpened){
                HelpFrame helpFrame = new HelpFrame();
                helpFrame.setVisible(true);
                isHelpOpened = true;
            }
        });

        idolQuizButton.addActionListener(e -> {
            if(!isQuizOpened) {
                IdolQuizFrame idolQuizFrame = new IdolQuizFrame();
                idolQuizFrame.setVisible(true);
                isQuizOpened = true;
            }
        });
        musicQuizButton.setPreferredSize(new Dimension(200, 200));
        idolQuizButton.setPreferredSize(new Dimension(200, 200));
        helpButton.setPreferredSize(new Dimension(50,50));
        add(musicQuizButton);
        add(idolQuizButton);
        add(helpButton);
    }

    public static void charShuffle(){
        List<Character> list = Arrays.asList(characterArr);
        Collections.shuffle(list);
        list.toArray(characterArr);
    }
    public static void musicShuffle(){
        List<Music> list = Arrays.asList(musicArr);
        Collections.shuffle(list);
        list.toArray(musicArr);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
    private void InitCharArray(){
        characterArr[0]=new Character(new String[]{"AnYujin", "anyujin","yujin","dksdbwls","dbwls"},"IVE, (former)IZ*ONE");
        characterArr[1]=new Character(new String[]{"BaekJiheon", "baekjiheon","jiheon","qorwlgjs","wlgjs"},"fromis_9");
        characterArr[2]=new Character(new String[]{"Haerin", "KangHaerin","haerin","rkdgofls","gofls"},"NewJeans");
        characterArr[3]=new Character(new String[]{"HongEunchae", "hongeunchae","eunchae","ghddmsco","dmsco"},"LE SSERAFIM");
        characterArr[4]=new Character(new String[]{"Hyein", "LeeHyein","hyein","dlgPdls","gPdls"},"NewJeans");
        characterArr[5]=new Character(new String[]{"IU", "iu","dkdldb","dlwlrma","dlwldms"},"SOLO");
        characterArr[6]=new Character(new String[]{"JangGyuri", "gyuri","janggyuri","wkdrbfl","rbfl"},"(former)fromis_9");
        characterArr[7]=new Character(new String[]{"JangWonyoung", "wkddnjsdud","dnjsdud","wonyoung"},"IVE, (former)IZ*ONE");
        characterArr[8]=new Character(new String[]{"JoYuri", "joyuri","whdbfl","dbfl","yuri"},"(former)IZ*ONE");
        characterArr[9]=new Character(new String[]{"KangHyewon", "hyewon","rkdgPdnjs","gPdnjs"},"(former)IZ*ONE");
        characterArr[10]=new Character(new String[]{"Karina", "karina","zkflsk","dbwlals"},"aespa");
        characterArr[11]=new Character(new String[]{"Kazuha", "zkwmgk","kazuha"},"LE SSERAFIM");
        characterArr[12]=new Character(new String[]{"KimChaewon", "rlacodnjs","codnjs","chaewon"},"LE SSERAFIM, (former)IZ*ONE");
        characterArr[13]=new Character(new String[]{"KimMinju", "kimminju","alswn","rlaalswn"},"(former)IZ*ONE");
        characterArr[14]=new Character(new String[]{"KwonEunbi", "kwoneunbi","rnjsdmsql","dmsql"},"(former)IZ*ONE");
        characterArr[15]=new Character(new String[]{"LeeChaeyoung", "dlcodud","chaeyoung","codud"},"fromis_9");
        characterArr[16]=new Character(new String[]{"LeeNagyung", "dlskrud","nagyung","skrud"},"fromis_9");
        characterArr[17]=new Character(new String[]{"LeeSaerom", "dltofha","saerom","tofha"},"fromis_9");
        characterArr[18]=new Character(new String[]{"LeeSeoyeon", "dltjdus","seoyeon","tjdus"},"fromis_9");
        characterArr[19]=new Character(new String[]{"Lia", "fldk","chlwltn"},"ITZY");
        characterArr[20]=new Character(new String[]{"Minji", "KimMinji","alswl","rlaalswl"},"NewJeans");
        characterArr[21]=new Character(new String[]{"ParkJiwon", "parkjiwon","jiwon","qkrwldnjs","wldnjs","megan"},"fromis_9");
        characterArr[22]=new Character(new String[]{"RohJisun", "rohjisun","wltjs","shwltjs"},"fromis_9");
        characterArr[23]=new Character(new String[]{"SongHayoung", "songhayoung","thdgkdud","gkdud"},"fromis_9");
        characterArr[24]=new Character(new String[]{"Winter", "winter","dnlsxj","gkdud","rlaalswjd"},"aespa");
        characterArr[25]=new Character(new String[]{"Yeji", "dPwl","ghkddPwl","yeji"},"ITZY");
        characterArr[26]=new Character(new String[]{"Yuna", "dbsk","tlsdbsk","dbsk"},"ITZY");
        characterArr[27]=new Character(new String[]{"Yuqi", "yuqi","dnrl","thddnrl"},"(G)I-DLE");
        characterArr[28]=new Character(new String[]{"KimYooyeon", "dbdus","rladbdus","yooyeon"},"tripleS");
        characterArr[29]=new Character(new String[]{"Seeun", "tpdms","seeun","dbstpdms"},"STAYC");
        characterArr[30]=new Character(new String[]{"HANNI", "gksl","vkagksl"},"NewJeans");
        characterArr[31]=new Character(new String[]{"IRENE", "dkdlfls","irene","qowngus"},"Red Velvet");
        characterArr[32]=new Character(new String[]{"ARIN", "dkfls","chldPdnjs"},"OH MY GIRL");
        characterArr[33]=new Character(new String[]{"HAEWON", "dhgodnjs","godnjs","shdekarha"},"NMIXX");
        characterArr[34]=new Character(new String[]{"DANIEL", "eksldpf","ahwlgP","daniel"},"NewJeans");
        characterArr[35]=new Character(new String[]{"YOONA", "dbsdk","dladbsdk","yoona"},"Girls' Generation");
        characterArr[36]=new Character(new String[]{"YOOA", "dbtldk","yooa","dbdk"},"OH MY GIRL");
        characterArr[37]=new Character(new String[]{"YENA", "chldPsk","dPsk","yena"},"(former)IZ*ONE");
        characterArr[38]=new Character(new String[]{"JOY", "whdl","qkrtndud","joy"},"Red Velvet");
        characterArr[39]=new Character(new String[]{"YERI", "rladPfla","dPfl","yeri"},"Red Velvet");
        characterArr[40]=new Character(new String[]{"SEULGI", "tmfrl","seulgi","rkdtmfrl"},"Red Velvet");
        characterArr[41]=new Character(new String[]{"WENDY", "dnpsel","wendy","thstmddhks"},"Red Velvet");
        characterArr[42]=new Character(new String[]{"EUNHA", "dmsgk","eunha","wjddmsql"},"VIVIZ,GFRIEND");
        characterArr[43]=new Character(new String[]{"TAEYEON", "xodus","rlaxodus","taeyeon"},"Girls' Generation");
        characterArr[44]=new Character(new String[]{"YOON", "dbs","yoon","tlawkdbs"},"STAYC");
        characterArr[45]=new Character(new String[]{"IRENE", "dkdlfls","irene","qowngus"},"STAYC");
        characterArr[46]=new Character(new String[]{"SIEUN", "qkrtldms","tldms","sieun"},"Red Velvet");
        characterArr[47]=new Character(new String[]{"JISOO", "wltn","rlawltn","jisoo"},"BLACKPINK");
        characterArr[48]=new Character(new String[]{"ROSE", "qkrcodud","fhwp","rose"},"BLACKPINK");
        characterArr[49]=new Character(new String[]{"RYUJIN", "fbwls","ryujin","tlsfbwls"},"ITZY");
    }
    private void InitMusicArray() {
        musicArr[0]= new Music(new String[]{"BLUE","blue","qmffn"},"BIGBANG");
        musicArr[1]= new Music(new String[]{"Phonecert","phonecert","vhstjxm"},"10cm");
        musicArr[2]= new Music(new String[]{"As If It's Your Last","akwlakrcjfja"},"BLACKPINK");
        musicArr[3]= new Music(new String[]{"Not Spring, Love, or Cherry Blossoms","qhatkfkdqjwRhcakfrh"},"HIGH4, IU");
        musicArr[4]= new Music(new String[]{"TT","tt","xlxl"},"TWICE");
        musicArr[5]= new Music(new String[]{"No Make Up","shapdlzmdjq","nomakeup"},"Zion.T");
        musicArr[6]= new Music(new String[]{"WINE","dhsmfcnlgkaus","wine"},"SURAN Feat. CHANGMO");
        musicArr[7]= new Music(new String[]{"WuGyeol","dnruf",},"Giriboy");
        musicArr[8]= new Music(new String[]{"Aqua Man","dkzndkaos"},"Beenzino");
        musicArr[9]= new Music(new String[]{"Rain","qlrkdhk"},"SOYU, BAEKHYUN");
        musicArr[10]= new Music(new String[]{"puzzle","vjwmf"},"C JAMM, BewhY");
        musicArr[11]= new Music(new String[]{"200%","dlqorvjtpsxm","200vjtpsxm"},"AKMU");
        musicArr[12]= new Music(new String[]{"Sleepless rainy night","wkaahtemsmsqkaqlsmssoflrh"},"IU");
        musicArr[13]= new Music(new String[]{"Question mark","?","anfdmavy"},"Primary Feat Choiza, Zion.T");
        musicArr[14]= new Music(new String[]{"Spring Rain","qhaql","spring rain"},"JangBeomJune");
        musicArr[15]= new Music(new String[]{"We are","tlck","weare"},"Woo Feat Loco, Gray");
        musicArr[16]= new Music(new String[]{"Twenty-Three","tmanftpt"},"IU");
        musicArr[17]= new Music(new String[]{"Flower Road","Rhcrlf"},"BIGBANG");
        musicArr[18]= new Music(new String[]{"BBoom BBoom","QnaQna"},"MOMOLAND");
        musicArr[19]= new Music(new String[]{"REALLY REALLY","fldjfflfldjffl","fufflfuffl"},"WINNER");
        musicArr[20]= new Music(new String[]{"Palette","vkffpxm","palette"},"IU");
        musicArr[21]= new Music(new String[]{"Love","fjqm","love"},"Primary Feat. Bumkey, Paloalto");
        musicArr[22]= new Music(new String[]{"Summer Love","doxksmsakdma","vktrnrrk"},"Ulala Session, IU");
        musicArr[23]= new Music(new String[]{"All I Wanna Do","dhfdkdnjsjeh","dhfdkdldnjsjen"},"JAY PARK Feat. Hoody, Loco");
        musicArr[24]= new Music(new String[]{"Cherry Blossom Ending","qjwRhcdpseld"},"Busker Busker");
        musicArr[25]= new Music(new String[]{"Some","Tja","some"},"SOYU, JunggiGo");
        musicArr[26]= new Music(new String[]{"Can't Breakup Girl, Can't Breakaway Boy","gpdjwlwlahtgksmsduwkEjskrkwlahtgksmsskawk"},"Leessang Feat. Jung In");
        musicArr[27]= new Music(new String[]{"Seethru","Tltmfn","tltmfn"},"Primary Feat. Zion.T, Gaeko");
        musicArr[28]= new Music(new String[]{"BLUE MOON","qmffnans"},"HYORIN, CHANGMO");
        musicArr[29]= new Music(new String[]{"Wi Ing Wi Ing","dnldlddnldld"},"HYUKOH");
    }
}


