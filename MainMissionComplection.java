import java.util.*;
import javax.swing.*; 
import java.io.*;

public class MainMissionComplection
{ 
    private static QueueManager queueuManager = new QueueManager(); 
    private static Stack<CrewMemberInfo> completeStack = new Stack<>();
    private static Map<String, CrewMemberInfo> crewMap = new HashMap<>();
    
    public static void main(String[] args) 
    {
        try 
        {
            
            BufferedReader in = new BufferedReader (new FileReader("onepiece_combine.txt"));
            String indata; 
            Stack<CrewMemberInfo> tempStack = new Stack<>();
            tempStack.addAll(completeStack);
            
            while((indata = in.readLine()) !=null) 
            {
                StringTokenizer st = new StringTokenizer(indata, "|"); 
                String memberId = st.nextToken(); 
                String memberName = st.nextToken(); 
                String pirateCrew = st.nextToken(); 
                String missionId = st.nextToken(); 
                String missionType = st.nextToken(); 
                int dangerLevel = Integer.parseInt(st.nextToken()); 
                String missionDate = st.nextToken(); 
                String expectedDuration = st.nextToken(); 
                int bountyReward = Integer.parseInt(st.nextToken()); 
                
                CrewMemberInfo crew;
                if (!crewMap.containsKey(memberId)) 
                {
                    crew = new CrewMemberInfo(memberId, memberName, pirateCrew);
                    crewMap.put(memberId, crew);
                    queueuManager.assignPirate(crew);
                } 
                else 
                {
                    crew = crewMap.get(memberId);
                }
            } 
            in.close();
            
            int option;
        do 
        {
            String menu = "=== Pirate Mission Manager ===\n" +
                          "1. Add Pirate\n" +
                          "2. Assign Mission to Pirate\n" +
                          "3. Process Missions in Batches\n" +
                          "4. Display Completed Pirates\n" +
                          "5. Exit\n";

            option = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (option) 
            {
                case 1:
                    addPirate();
                    break;
                case 2:
                    assignMission();
                    break;
                case 3:
                    processMissionsInBatches();
                    break;
                case 4:
                    displayCompleteStack();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Exiting system. Goodbye!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice.");
            } 
        } while(option != 5);
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println(" Error!!! "+ ex.getMessage());
        } 
    } 
    private static void addPirate() 
    {
        String id = JOptionPane.showInputDialog("Enter Member ID:");
        String name = JOptionPane.showInputDialog("Enter Member Name:");
        String crew = JOptionPane.showInputDialog("Enter Pirate Crew:");

        CrewMemberInfo pirate = new CrewMemberInfo(id, name, crew);
        queueuManager.assignPirate(pirate); 
        crewMap.put(id, pirate);
    } 
    private static void assignMission() 
    {
       String id = JOptionPane.showInputDialog("Enter Member ID to assign a mission:"); 
       
       CrewMemberInfo found = findPirateInAllQueues(id);
        if (found != null) 
        {
            String missionId = JOptionPane.showInputDialog("Enter Mission ID:");
            String type = JOptionPane.showInputDialog("Enter Mission Type:");
            int danger = Integer.parseInt(JOptionPane.showInputDialog("Enter Danger Level (1-5):"));
            String date = JOptionPane.showInputDialog("Enter Mission Date:");
            String duration = JOptionPane.showInputDialog("Enter Expected Duration:");
            int bounty = Integer.parseInt(JOptionPane.showInputDialog("Enter Bounty Reward:"));

            MissionInfo mission = new MissionInfo(missionId, type, danger, date, duration, bounty);
            found.addMission(mission);
        } 
        else 
        {
           JOptionPane.showMessageDialog(null, "Pirate not found in any queue."); 
        } 
    } 
    private static CrewMemberInfo findPirateInAllQueues(String id) 
    {
       for (Queue<CrewMemberInfo> queue : Arrays.asList(queueuManager.getEastBlueQueue(), queueuManager.getSouthBlueQueue(), queueuManager.getGrandLineQueue())) 
        {
            for (CrewMemberInfo pirate : queue) 
            {
                if (pirate.getMemberId().equalsIgnoreCase(id)) 
                {
                    return pirate;
                }
            }
        }
        return null; 
    } 
    private static void processMissionsInBatches() 
    {
        while ( !queueuManager.getEastBlueQueue().isEmpty() ||!queueuManager.getSouthBlueQueue().isEmpty() ||!queueuManager.getGrandLineQueue().isEmpty())
        {
        processQueue(queueuManager.getEastBlueQueue(), "East Blue");
        processQueue(queueuManager.getSouthBlueQueue(), "South Blue");
        processQueue(queueuManager.getGrandLineQueue(), "Grand Line");
        }
    } 
    private static void processQueue(Queue<CrewMemberInfo> queue, String pirateCrew)
    {
      int count = 0;
        while (!queue.isEmpty() && count < 5) 
        {
            CrewMemberInfo pirate = queue.poll();
            JOptionPane.showMessageDialog(null, "Processing pirate from " + pirateCrew + ":\n" + pirate);
            if (pirate.getMissionCount() > 0)
            {
                completeStack.push(pirate);
            } 
            count ++;
        } 
    } 
    private static void displayCompleteStack() 
    {
       if (completeStack.isEmpty()) 
       {
            JOptionPane.showMessageDialog(null, "No completed pirates in the stack.");
       } 
       else 
       {
            StringBuilder result = new StringBuilder("=== Completed Pirates ===\n");
            while (!completeStack.isEmpty()) 
            {
                CrewMemberInfo pirate = completeStack.pop();
                result.append("Name: ").append(pirate.getMemberName()).append("\n")
                      .append("Crew: ").append(pirate.getPirateCrew()).append("\n")
                      .append("Total Missions: ").append(pirate.getMissionCount()).append("\n")
                      .append("Total Bounty: ").append(pirate.getTotalBounty()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, result.toString());  
        } 
    }
}