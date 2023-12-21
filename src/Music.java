import java.util.Arrays;

public class Music {
    private final String name;
    private final String[] answer;
    private final String artist;
    public Music(String[] name,String artist){
        this.name=name[0];
        this.answer=name;
        this.artist=artist;
    }
    public String getArtist() { return artist; }
    public String getName(){
        return name;
    }
    public boolean isAnswer(String str){
        return Arrays.asList(answer).contains(str);
    }

}
