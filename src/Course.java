import java.util.*;

public class Course implements Publishable, Schedulable {
    private String name;
    private Professor professor;
    private List<Student> students;
    private Queue<Student> waitingList;
    private int maxStudents;
    private LinkedList<String> feed;
    private LinkedList<Event> schedule;

    public Course(String name, Professor professor, int maxStudents) throws InvalidCourseException {
        if (name == null || name.isEmpty()) {
            throw new InvalidCourseException("Название курса не может быть пустым");
        }
        this.name = name;
        this.professor = professor;
        this.maxStudents = maxStudents;
        this.students = new ArrayList<>();
        this.waitingList = new LinkedList<>();
        this.feed = new LinkedList<>();
        this.schedule = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void addStudent(Student s) throws CourseFullException {
        if (students.size() < maxStudents) {
            students.add(s);
        } else if (waitingList.size() < 5) {
            waitingList.offer(s);
            System.out.println("Курс заполнен. Студент добавлен в список ожидания: " + s.getDetails());
        } else {
            throw new CourseFullException("Course [" + name + "] is completely full");
        }
    }

    public void processWaitingList() {
        while (students.size() < maxStudents && !waitingList.isEmpty()) {
            Student s = waitingList.poll();
            students.add(s);
            System.out.println("Студент из списка ожидания добавлен: " + s.getDetails());
        }
    }

    public int getWaitingListSize() {
        return waitingList.size();
    }

    public void showCourseDetails() {
        System.out.println("Курс: " + name);
        System.out.println("Преподаватель: " + professor.getDetails());
        System.out.println("Студенты:");
        for (Student s : students) {
            System.out.println(" - " + s.getDetails());
        }

        if (!waitingList.isEmpty()) {
            System.out.println("Список ожидания:");
            for (Student s : waitingList) {
                System.out.println(" - " + s.getDetails());
            }
        }

        System.out.println("Объявления:");
        for (String msg : feed) {
            System.out.println(" * " + msg);
        }

        System.out.println("Расписание:");
        for (Event e : schedule) {
            System.out.println(" - " + e.getDescription() + " в " + e.getDateTime());
        }
    }

    // Publishable
    @Override
    public void publish(String message) {
        feed.add(message);
    }

    @Override
    public List<String> getFeed() {
        return feed;
    }

    // Schedulable
    @Override
    public void scheduleEvent(String description, String dateTime) {
        schedule.add(new Event(description, dateTime));
    }

    @Override
    public List<Event> getSchedule() {
        return schedule;
    }
}
