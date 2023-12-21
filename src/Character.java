import java.util.Arrays;

public class Character {
    private final String name;
    private final String[] answer;
    private final String group;
    public Character(String[] name,String group){
        this.name=name[0];
        this.answer=name;
        this.group=group;
    }
    public String getGroup() { return group; }
    public String getName(){
        return name;
    }
    public boolean isAnswer(String str){
        return Arrays.asList(answer).contains(str);
    }
}
