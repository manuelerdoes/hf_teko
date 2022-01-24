import java.util.ArrayList;

public class State {

    private String trigger;
    private ArrayList<State> children = new ArrayList<State>();
    private String stateContent;
    private Boolean exitState;

    public State(String trigger) {
        this.trigger = trigger;
        exitState = false;
    }

    public void setTrigger(String t) {
        trigger = t;
    }

    public String getTrigger() {
        return trigger;
    }

    public void addChild(State newChild) {
        children.add(newChild);
    }
    
    public void removeChild(State child) {
        children.remove(child);
    }

    public ArrayList<State> getChildren() {
        return children;
    }

    public void setStateContent(String s) {
        stateContent = s;
    }

    public String getStateContent() {
        return stateContent;
    }

    public void setExitState(Boolean b) {
        exitState = b;
    }

    public Boolean getExitState() {
        return exitState;
    }
}
