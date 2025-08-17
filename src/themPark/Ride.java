package themPark;

import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private Employee operator;
    private int maxRiders;
    private int numOfCycles;

    private final Queue<Visitor> waitingQueue;
    private final LinkedList<Visitor> rideHistory;

    public Ride() {
        this("Unnamed Ride", null, 4);
    }

    public Ride(String rideName, Employee operator, int maxRiders) {
        this.rideName = rideName != null ? rideName : "Unnamed Ride";
        this.operator = operator;
        this.maxRiders = Math.max(1, maxRiders);
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName != null ? rideName : this.rideName;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = Math.max(1, maxRiders);
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    @Override
    public void addVisitorToQueue(Visitor v) {
        if (v != null) {
            waitingQueue.offer(v);
            System.out.println("[Queue] " + v.getFullName() + " joined the line for " + rideName);
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor v = waitingQueue.poll();
        if (v != null) {
            System.out.println("[Queue] " + v.getFullName() + " removed from line");
        } else {
            System.out.println("[Queue] no one to remove");
        }
        return v;
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("[Queue] empty");
        } else {
            System.out.println("[Queue] people waiting for " + rideName + ":");
            for (Visitor v : waitingQueue) {
                System.out.println("  - " + v);
            }
        }
    }

    @Override
    public void addVisitorToHistory(Visitor v) {
        if (v != null) {
            rideHistory.add(v);
            System.out.println("[History] added " + v.getFullName());
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        boolean found = rideHistory.contains(v);
        System.out.println("[History] " + v.getFullName() + (found ? " is" : " is not") + " in the list");
        return found;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("[History] no one has ridden yet");
        } else {
            System.out.println("[History] riders of " + rideName + ":");
            Iterator<Visitor> it = rideHistory.iterator();
            while (it.hasNext()) {
                System.out.println("  - " + it.next());
            }
        }
    }

    public void sortRideHistory(Comparator<Visitor> comp) {
        if (comp != null && !rideHistory.isEmpty()) {
            Collections.sort(rideHistory, comp);
            System.out.println("[Sort] sorted ride history");
        } else {
            System.out.println("[Sort] nothing to sort");
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("[Run] no operator set");
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println("[Run] no one in line");
            return;
        }

        numOfCycles++;
        System.out.println("[Run] starting ride " + rideName + " (cycle #" + numOfCycles + ")");

        int riders = 0;
        while (!waitingQueue.isEmpty() && riders < maxRiders) {
            Visitor v = waitingQueue.poll();
            if (v != null) {
                rideHistory.add(v);
                riders++;
                System.out.println("[Run] " + v.getFullName() + " is on the ride");
            }
        }

        System.out.println("[Run] cycle done, riders: " + riders);
    }

    @Override
    public void exportRideHistory(String filename) {
        if (filename == null || filename.isEmpty()) filename = "ride_history.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("id,firstName,lastName,age,ticketType,hasMembership");
            bw.newLine();
            for (Visitor v : rideHistory) {
                bw.write(v.getId() + "," + safe(v.getFirstName()) + "," + safe(v.getLastName()) + ","
                        + v.getAge() + "," + safe(v.getTicketType()) + "," + v.hasMembership());
                bw.newLine();
            }
            System.out.println("[Save] saved to " + filename);
        } catch (IOException e) {
            System.out.println("[Save] error: " + e.getMessage());
        }
    }

    @Override
    public void importRideHistory(String filename) {
        if (filename == null || filename.isEmpty()) filename = "ride_history.csv";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",", -1);
                if (p.length != 6) continue;

                int id = Integer.parseInt(p[0].trim());
                String first = p[1].trim();
                String last = p[2].trim();
                int age = Integer.parseInt(p[3].trim());
                String ticket = p[4].trim();
                boolean member = Boolean.parseBoolean(p[5].trim());

                Visitor v = new Visitor(id, first, last, age, ticket, member);
                rideHistory.add(v);
                count++;
            }
            System.out.println("[Load] loaded " + count + " from " + filename);
        } catch (Exception e) {
            System.out.println("[Load] error: " + e.getMessage());
        }
    }

    private String safe(String s) {
        return (s == null ? "" : s);
    }
}
