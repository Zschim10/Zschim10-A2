package themPark;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();

        // run each part in order
        demo.partOne();     // basic classes and getters
        demo.partTwo();     // abstract class and interface
        demo.partThree();   // add/remove/print queue
        demo.partFourA();   // history add and check
        demo.partFourB();   // sorting the history
        demo.partFive();    // cycle riders from queue
        demo.partSix();     // export ride historys
        demo.partSeven();   // import ride history
    }

    public void partOne() {
        System.out.println("\n=== PART 1 ===");
        Employee emp = new Employee(1, "Sam", "Staff", 35, "EMP001", "Ride Op");
        Visitor vis = new Visitor(101, "Jill", "Visitor", 28, "Day Pass", false);
        System.out.println(emp);
        System.out.println(vis);
        Person p = vis; // using inheritance
        System.out.println("Person version: " + p);
    }

    public void partTwo() {
        System.out.println("\n=== PART 2 ===");
        Ride r = new Ride("Big Drop", null, 5);
        System.out.println("Ride made: " + r.getRideName());
    }

    public void partThree() {
        System.out.println("\n=== PART 3 ===");
        Ride r = new Ride("Loop Coaster", null, 4);

        Visitor a = new Visitor(1, "Ava", "Jones", 30, "Day Pass", false);
        Visitor b = new Visitor(2, "Ben", "Smith", 26, "Single Ride", true);
        Visitor c = new Visitor(3, "Cara", "Lee", 24, "Day Pass", false);
        Visitor d = new Visitor(4, "Dan", "Ray", 29, "Single Ride", false);
        Visitor e = new Visitor(5, "Ella", "Ng", 27, "Day Pass", true);

        r.addVisitorToQueue(a);
        r.addVisitorToQueue(b);
        r.addVisitorToQueue(c);
        r.addVisitorToQueue(d);
        r.addVisitorToQueue(e);

        r.removeVisitorFromQueue(); // remove first one
        r.printQueue(); // show current line
    }

    public void partFourA() {
        System.out.println("\n=== PART 4A ===");
        Ride r = new Ride("River Rapids", null, 3);

        Visitor a = new Visitor(11, "Ash", "Liu", 31, "Day Pass", false);
        Visitor b = new Visitor(12, "Bea", "Chen", 25, "Single Ride", true);
        Visitor c = new Visitor(13, "Cal", "Tran", 22, "Day Pass", false);
        Visitor d = new Visitor(14, "Dee", "Patel", 34, "Day Pass", true);
        Visitor e = new Visitor(15, "Ezra", "Mills", 27, "Single Ride", false);

        r.addVisitorToHistory(a);
        r.addVisitorToHistory(b);
        r.addVisitorToHistory(c);
        r.addVisitorToHistory(d);
        r.addVisitorToHistory(e);

        r.checkVisitorFromHistory(c); // should be found
        Visitor ghost = new Visitor(99, "Ghost", "User", 45, "None", false);
        r.checkVisitorFromHistory(ghost); // not found

        System.out.println("Total history: " + r.numberOfVisitors());
        r.printRideHistory(); // show everyone in history
    }

    public void partFourB() {
        System.out.println("\n=== PART 4B ===");
        Ride r = new Ride("Haunted House", null, 4);

        r.addVisitorToHistory(new Visitor(21, "Zane", "White", 19, "Day Pass", false));
        r.addVisitorToHistory(new Visitor(22, "Amy", "Adams", 33, "Single Ride", true));
        r.addVisitorToHistory(new Visitor(23, "Alex", "Adams", 20, "Day Pass", false));
        r.addVisitorToHistory(new Visitor(24, "Maya", "Bell", 28, "Day Pass", true));
        r.addVisitorToHistory(new Visitor(25, "Luke", "Chen", 26, "Single Ride", false));

        System.out.println("Before sort:");
        r.printRideHistory();

        r.sortRideHistory(new VisitorComparator());

        System.out.println("After sort:");
        r.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n=== PART 5 ===");
        Employee op = new Employee(10, "Nina", "Workman", 38, "EMP010", "Ride Op");
        Ride r = new Ride("Loop Coaster", op, 5);

        for (int i = 1; i <= 10; i++) {
            r.addVisitorToQueue(new Visitor(100 + i, "V" + i, "Test", 20 + i, "Day Pass", i % 2 == 0));
        }

        System.out.println("Queue before:");
        r.printQueue();

        r.runOneCycle(); // run once

        System.out.println("Queue after:");
        r.printQueue();

        System.out.println("History after:");
        r.printRideHistory();
    }

    public void partSix() {
        System.out.println("\n=== PART 6 ===");
        Ride r = new Ride("Spinning Cups", null, 3);

        r.addVisitorToHistory(new Visitor(51, "Andy", "Lo", 22, "Day Pass", true));
        r.addVisitorToHistory(new Visitor(52, "Beck", "Yan", 26, "Single Ride", false));
        r.addVisitorToHistory(new Visitor(53, "Cara", "Jin", 28, "Day Pass", true));

        String filename = "ride_history_export.csv";
        r.exportRideHistory(filename);
        System.out.println("Saved to: " + filename);
    }

    public void partSeven() {
        System.out.println("\n=== PART 7 ===");
        Ride r = new Ride("Imported Ride", null, 3);
        String filename = "ride_history_export.csv";
        r.importRideHistory(filename);
        System.out.println("Loaded from: " + filename);
        r.printRideHistory();
    }
}
