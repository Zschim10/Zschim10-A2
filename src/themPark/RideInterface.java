package themPark;

public interface RideInterface {
    // add to queue
    void addVisitorToQueue(Visitor v);

    // remove from queue
    Visitor removeVisitorFromQueue();

    // print the queue
    void printQueue();

    // add to history
    void addVisitorToHistory(Visitor v);

    // check if visitor in history
    boolean checkVisitorFromHistory(Visitor v);

    // total in history
    int numberOfVisitors();

    // print history using iterator
    void printRideHistory();

    // run one cycle
    void runOneCycle();

    // export history to CSV
    void exportRideHistory(String filename);

    // import from CSV
    void importRideHistory(String filename);
}
