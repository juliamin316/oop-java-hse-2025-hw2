import java.util.LinkedList;
import java.util.List;

public class Professor extends UniversityMember implements Schedulable {
    private String department;
    private LinkedList<Event> schedule;

    public Professor(String name, int id, String department) {
        super(name, id);
        this.department = department;
        this.schedule = new LinkedList<>();
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getDetails() {
        return "ID преподавателя: " + id + ", Имя: " + name + ", кафедра: " + department;
    }

    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    @Override
    public List<Event> getSchedule() {
        return schedule;
    }
}
