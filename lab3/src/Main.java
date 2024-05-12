class Ticket {
    private int id;
    private String name;
    private int estimate;
    private boolean completed;
    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        this.completed = false;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getEstimate() {
        return estimate;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void complete() {
        completed = true;
    }
}
class UserStory extends Ticket {
    private UserStory[] dependencies;
    public UserStory(int id, String name, int estimate, UserStory[] dependencies) {
        super(id, name, estimate);
        this.dependencies = dependencies;
    }
    public UserStory[] getDependencies() {
        UserStory[] copy = new UserStory[dependencies.length];
        System.arraycopy(dependencies, 0, copy, 0, dependencies.length);
        return copy;
    }
    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
class Bug extends Ticket {
    private UserStory userStory;
    public Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }
    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || userStory.isCompleted()) {
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }
    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + userStory.getName() + ": " + getName();
    }
}
class Sprint {
    private int capacity;
    private int ticketLimit;
    private Ticket[] tickets;
    private int size;
    public Sprint(int capacity, int ticketLimit) {
        this.capacity = capacity;
        this.ticketLimit = ticketLimit;
        this.tickets = new Ticket[ticketLimit];
        this.size = 0;
    }
    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted() || getTotalEstimate() + userStory.getEstimate() > capacity || size >= ticketLimit) {
            return false;
        }
        tickets[size++] = userStory;
        return true;
    }
    public boolean addBug(Bug bug) {
        if (bug == null || bug.isCompleted() || getTotalEstimate() + bug.getEstimate() > capacity || size >= ticketLimit) {
            return false;
        }
        tickets[size++] = bug;
        return true;
    }
    public Ticket[] getTickets() {
        Ticket[] copy = new Ticket[size];
        System.arraycopy(tickets, 0, copy, 0, size);
        return copy;
    }
    public int getTotalEstimate() {
        int totalEstimate = 0;
        for (int i = 0; i < size; i++) {
            totalEstimate += tickets[i].getEstimate();
        }
        return totalEstimate;
    }
}
public class Main {
    public static void main(String[] args) {
        Sprint sprint = new Sprint(20, 5);
        UserStory userStory1 = new UserStory(1, "Реєстрація користувача", 8, new UserStory[0]);
        UserStory userStory2 = new UserStory(2, "Авторизація користувача", 8, new UserStory[0]);
        sprint.addUserStory(userStory1);
        sprint.addUserStory(userStory2);
        Bug bug1 = Bug.createBug(1, "Помилка при введенні паролю", 3, userStory1);
        Bug bug2 = Bug.createBug(2, "Непрацююча кнопка відправки", 2, userStory2);
        sprint.addBug(bug1);
        sprint.addBug(bug2);
        Ticket[] sprintTickets = sprint.getTickets();
        for (Ticket ticket : sprintTickets) {
            System.out.println(ticket);
        }
        System.out.println("Загальна оцінка часу виконання: " + sprint.getTotalEstimate());
    }
}