package themPark;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();

        // Run each part in order.
        demo.partOne();
        demo.partTwo();
        demo.partThree();
        demo.partFourA();
        demo.partFourB();
        demo.partFive();
        demo.partSix();
        demo.partSeven();
    }

    // PART 1: Core classes
    public void partOne() {
        System.out.println("\n=== PART 1: Classes & constructors ===");
        Employee op = new Employee(1, "Sam", "Operator", 41, "E001", "Ride Operator");
        Visitor a = new Visitor(101, "Alice", "Smith", 25, "Day Pass", false);
        System.out.println(op);
        System.out.println(a);
        Person p = a;
        System.out.println("As Person: " + p);
    }

    // PART 2: Abstraction & Interface
    public void partTwo() {
        System.out.println("\n=== PART 2: Abstraction & Interface ===");
        Ride ride = new Ride("Roller Coaster", null, 4);
        System.out.println("Created ride: " + ride.getRideName() + " (no operator yet).");
    }

    // PART 3: Queue of Visitors (FIFO)
    public void partThree() {
        System.out.println("\n=== PART 3: Queue demo (add/remove/print) ===");
        Ride ride = new Ride("Ferris Wheel", null, 3);

        Visitor v1 = new Visitor(201, "Bob", "Brown", 22, "Single Ride", false);
        Visitor v2 = new Visitor(202, "Carol", "Jones", 27, "Day Pass", true);
        Visitor v3 = new Visitor(203, "Derek", "King", 19, "Day Pass", false);
        Visitor v4 = new Visitor(204, "Eva", "Li", 30, "Single Ride", true);
        Visitor v5 = new Visitor(205, "Finn", "Ng", 24, "Day Pass", false);

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        ride.removeVisitorFromQueue();
        ride.printQueue();
    }

    // PART 4A: Ride history + Iterator
    public void partFourA() {
        System.out.println("\n=== PART 4A: Ride history + Iterator ===");
        Ride ride = new Ride("Pirate Ship", null, 4);

        Visitor a = new Visitor(301, "Amy", "Zhao", 23, "Day Pass", false);
        Visitor b = new Visitor(302, "Ben", "Young", 21, "Single Ride", false);
        Visitor c = new Visitor(303, "Chloe", "Xavier", 32, "Day Pass", true);
        Visitor d = new Visitor(304, "David", "Wong", 29, "Single Ride", true);
        Visitor e = new Visitor(305, "Ella", "Vega", 20, "Day Pass", false);

        ride.addVisitorToHistory(a);
        ride.addVisitorToHistory(b);
        ride.addVisitorToHistory(c);
        ride.addVisitorToHistory(d);
        ride.addVisitorToHistory(e);

        ride.checkVisitorFromHistory(c);         // expected true
        Visitor ghost = new Visitor(999, "Ghost", "Person", 99, "Day Pass", false);
        ride.checkVisitorFromHistory(ghost);     // expected false

        System.out.println("History count: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }

    // PART 4B: Sorting with Comparator
    public void partFourB() {
        System.out.println("\n=== PART 4B: Sort history by lastName then age ===");
        Ride ride = new Ride("Haunted House", null, 4);

        ride.addVisitorToHistory(new Visitor(401, "Zara",  "Zane",   18, "Single Ride", false));
        ride.addVisitorToHistory(new Visitor(402, "Alex",  "Adams",  25, "Day Pass", true));
        ride.addVisitorToHistory(new Visitor(403, "alex",  "Adams",  20, "Day Pass", false));
        ride.addVisitorToHistory(new Visitor(404, "Mina",  "Brown",  22, "Single Ride", true));
        ride.addVisitorToHistory(new Visitor(405, "Liam",  "Clark",  26, "Day Pass", false));

        System.out.println("Before sort:");
        ride.printRideHistory();

        ride.sortRideHistory(new VisitorComparator());

        System.out.println("After sort:");
        ride.printRideHistory();
    }

    // PART 5: Run One Cycle
    public void partFive() {
        System.out.println("\n=== PART 5: Run one cycle (requires operator & queue) ===");
        Employee op = new Employee(10, "Nia", "Operator", 35, "E010", "Ride Operator");
        Ride ride = new Ride("Roller Coaster", op, 5);

        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor(500 + i, "Visitor" + i, "Last" + i, 18 + i, "Day Pass", i % 2 == 0));
        }

        System.out.println("Queue before cycle:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("Queue after cycle:");
        ride.printQueue();

        System.out.println("History after cycle:");
        ride.printRideHistory();
    }

    // PART 6: Export history to CSV (file I/O)
    public void partSix() {
        System.out.println("\n=== PART 6: Export history to CSV ===");
        Ride ride = new Ride("Drop Tower", null, 4);

        ride.addVisitorToHistory(new Visitor(601, "Ava", "Gray", 24, "Day Pass", true));
        ride.addVisitorToHistory(new Visitor(602, "Noah", "Hill", 21, "Single Ride", false));
        ride.addVisitorToHistory(new Visitor(603, "Ivy", "Ives", 28, "Day Pass", true));
        ride.addVisitorToHistory(new Visitor(604, "Leo", "Jade", 20, "Single Ride", false));
        ride.addVisitorToHistory(new Visitor(605, "Mia", "Kent", 22, "Day Pass", false));

        String filename = "ride_history_export.csv";
        ride.exportRideHistory(filename);
        System.out.println("Check project folder for: " + filename);
    }

    // PART 7: Import history from CSV (file I/O)
    public void partSeven() {
        System.out.println("\n=== PART 7: Import history from CSV ===");
        Ride ride = new Ride("Drop Tower (Imported)", null, 4);
        String filename = "ride_history_export.csv";
        ride.importRideHistory(filename);
        System.out.println("Imported count: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
}
