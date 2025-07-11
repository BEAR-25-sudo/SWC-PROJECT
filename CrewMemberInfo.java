import java.util.*;
import javax.swing.*;
public class CrewMemberInfo {
    private String memberId;
    private String memberName;
    private String pirateCrew;
    private List<MissionInfo>missions;
    
    public CrewMemberInfo(String memberId, String memberName, String pirateCrew){
        this.memberId = memberId;
        this.memberName = memberName;
        this.pirateCrew = pirateCrew;
        this.missions = new ArrayList<>();
    }
    public void addMission(MissionInfo mission) {
        missions.add(mission);
    }
    
    public String getMemberId(){
        return memberId;
    }
    public String getMemberName(){
        return memberName;
    }
    public String getPirateCrew(){
        return pirateCrew;
    }
    public List<MissionInfo>getMission(){
        return missions;
    }
    public int getMissionCount(){
        return missions.size();
    }
    public int getTotalBounty() {
        int total = 0;
        for (MissionInfo m : missions){
            total += m.getBountyReward();
        }
        return total;
    }
    public void setMemberId(String memberId){
        this.memberId = memberId;
    }
    public void setMemberName(String memberName){
        this.memberName = memberName;
    }
    public void setPirateCrew(String pirateCrew){
        this.pirateCrew = pirateCrew;
    }
    public String toString(){
        return memberName+ " {" + pirateCrew + ") - Missions: " + missions.size() + ", Total Bounty: " + getTotalBounty();
    }
    
    
}
