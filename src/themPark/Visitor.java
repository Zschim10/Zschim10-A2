package themPark;

public class Visitor extends Person {
    private String ticketType;
    private boolean hasMembership;

    public Visitor() {
        super();
        this.ticketType = "";
        this.hasMembership = false;
    }

    public Visitor(int id, String firstName, String lastName, int age, String ticketType, boolean hasMembership) {
        super(id, firstName, lastName, age);
        this.ticketType = ticketType;
        this.hasMembership = hasMembership;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean hasMembership() {
        return hasMembership;
    }

    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }

    @Override
    public String toString() {
        // visitor info
        return "[VIS] " + super.toString() + " | Ticket:" + ticketType + " | Member:" + (hasMembership ? "Yes" : "No");
    }
}
