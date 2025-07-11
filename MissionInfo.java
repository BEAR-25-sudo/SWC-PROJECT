public class MissionInfo {
    private String missionId;
    private String missionType;
    private int dangerLevel;
    private String missionDate;
    private String expectedDuration;
    private int bountyReward;

    // Constructor
    public MissionInfo(String missionId, String missionType, int dangerLevel, String missionDate, String expectedDuration, int bountyReward) {
        this.missionId = missionId;
        this.missionType = missionType;
        this.dangerLevel = dangerLevel;
        this.missionDate = missionDate;
        this.expectedDuration = expectedDuration;
        this.bountyReward = bountyReward;
    }

    // Getters
    public String getMissionId() {
        return missionId;
    }

    public String getMissionType() {
        return missionType;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public String getMissionDate() {
        return missionDate;
    }

    public String getExpectedDuration() {
        return expectedDuration;
    }

    public int getBountyReward() {
        return bountyReward;
    }

    // Setters
    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }
    
    public void setMissionType(String missionType) {
    this.missionType = missionType;
    }

    public void setDangerLevel(int dangerLevel) {
    this.dangerLevel = dangerLevel;
    }

    public void setMissionDate(String missionDate) {
    this.missionDate = missionDate;
    }

    public void setExpectedDuration(String expectedDuration) {
    this.expectedDuration = expectedDuration;
    }

    public void setBountyReward(int bountyReward) {
    this.bountyReward = bountyReward;
    }

    @Override
    public String toString() {
    return missionId + " | " + missionType + " | Danger Level: " + dangerLevel +
           " | Date: " + missionDate + " | Duration: " + expectedDuration +
           " | Bounty: " + bountyReward;
    }
    
}