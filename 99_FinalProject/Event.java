/**
 * The abstract Event class provides some concrete
 * methods and specifies some abstract methods to be implemented
 * by all inheriting child classes. Primarily, each Event
 * will contain a timeStamp that indicates
 * the time at which said event occurs, a Customer associated
 * with the event, and a server associated with the event.
 *
 * <p>Events that do not require a server are assigned a
 * dummy server to facilitate substitutability and polymorphic
 * behaviour.
 */
// The original file was lost; restored in Nov 2026 from this class's Javadoc
// and the Lab 5 version it grew from.
public abstract class Event {

    private final double timeStamp;
    private final Customer customer;
    private final Server server;

    /**
     * Constructs an Event with a timestamp, a customer, and a
     * server.
     *
     * @param timeStamp the time associated with the Event.
     * @param customer the {@code Customer} associated with the Event.
     * @param server the {@code Server} associated with the Event.
     */
    Event(double timeStamp, Customer customer, Server server) {
        this.timeStamp = timeStamp;
        this.customer = customer;
        this.server = server;
    }

    /**
     * Constructs an Event with a timestamp and a customer. A
     * dummy server is created for events that do not require
     * an associated Server.
     *
     * @param timeStamp the time associated with the Event.
     * @param customer the {@code Customer} associated with the Event.
     */
    Event(double timeStamp, Customer customer) {
        this(timeStamp, customer, new Server(-1, 0, () -> 0.0));
    }

    /**
     * Returns the timeStamp of the Event.
     *
     * @return Double value of the timeStamp.
     */
    public double getTimeStamp() {
        return this.timeStamp;
    }

    /**
     * Returns the associated Customer.
     *
     * @return Customer assigned to the event.
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Returns the associated Server.
     *
     * @return Server assigned to the event.
     */
    public Server getServer() {
        return this.server;
    }

    /**
     * Abstract method specification for generating the
     * next event. All classes that inherit from {@code Event}
     * are required to implement this method. Returns a
     * {@code Pair<Event, ImList<Server>>} containing
     * the next event as its first item and the updated list of
     * servers returned after processing the next event as its
     * second item.
     *
     * @param inputList An {@code ImList<Server>} of servers for processing next Event
     * @return A {@code Pair<Event, ImList<Server>>} pair
     */
    protected abstract Pair<Event, ImList<Server>>
        nextEvent(ImList<Server> inputList);

    /**
     * Method for adding served customers. Inheriting
     * child classes that involve adding to number of
     * customers served override this method.
     *
     * @return 0
     */
    protected int add() {
        return 0;
    }

    /**
     * Method for adding left customers. Inheriting
     * child classes that involve adding to number of
     * customers left override this method.
     *
     * @return 0
     */
    protected int left() {
        return 0;
    }

    /**
     * Method for adding waiting time. Inheriting
     * child classes that involve adding to total customer
     * waiting duration override this method.
     *
     * @return 0.0
     */
    protected double waitAdd() {
        return 0.0;
    }

    /**
     * Returns a String representation of the Event.
     * A partial event representation is given by the timeStamp
     * and the customerId, both of which are common to all events.
     * Inherting child classes invoke this with {@code super} in
     * their {@code toString} methods and continue with the rest.
     *
     * @return {@code toString()} representation of the Event.
     */
    @Override
    public String toString() {
        return String.format("%.3f %s ", this.getTimeStamp(),
                this.getCustomer().toString());
    }
}
