import java.util.*;

public class QueueManager {
    private LinkedList eastBlueQueue;
    private LinkedList southBlueQueue;
    private LinkedList grandLineQueue;
    
    private int toggle = 0;
    
    public QueueManager() {
        Queue<CrewMemberInfo> eastBlueQueue = new LinkedList<>();
        Queue<CrewMemberInfo> southBlueQueue = new LinkedList<>();
        Queue<CrewMemberInfo> grandLineQueue = new LinkedList<>();
    }
    
    public void assignPirate(CrewMemberInfo pirate) {
        int missionCount = pirate.getMission().size();
        if (missionCount <= 3) {
            if (toggle == 0) {
                eastBlueQueue.add(pirate);
                toggle = 1;
            } else {
                southBlueQueue.add(pirate);
                toggle = 0;
            }
        } else {
            grandLineQueue.add(pirate);
        }
    }

    public Queue<CrewMemberInfo> getEastBlueQueue() {
        return eastBlueQueue;
    }

    public Queue<CrewMemberInfo> getSouthBlueQueue() {
        return southBlueQueue;
    }

    public Queue<CrewMemberInfo> getGrandLineQueue() {
        return grandLineQueue;
    }
}