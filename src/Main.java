package themPark;

/**
 * The Main class holds all the demonstrations of the theme park managment system
 * it call in order each demonstration method from within the assignments
 */

public class Main {
    public static void main(String[] args) {
        //create demo driver
        AssignmentTwo demo = new AssignmentTwo();

        //These are the actual demonstrations in order

        System.out.println("=== Part3: Que interface ===");
        demo.partThree(); //remove add print visitor que
        System.out.println();    //spacer - console readability - will do on all parts

        System.out.println("=== Part4A: Ride history collection ===");
        demo.partFourA(); //LinkedList use and iterator traversal
        System.out.println();

        System.out.println("=== Part4B: Sorting ride history ===");
        demo.partFourB(); //Demonstrates ride history
        System.out.println();

        System.out.println("=== Part5: ride cycle ===");
        demo.partFive(); //transefring visitors from que to ride
        System.out.println();

        System.out.println("=== Part6: export history to file ===");
        demo.partSix(); //exasctly what it sound like
        System.out.println();

        System.out.println("=== Part7: import ride history ===");
        demo.partSeven(); //exactly as it sounds
        System.out.println();
    }
}