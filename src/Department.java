import java.util.LinkedList;
import java.util.List;

public class Department implements Departmental {
    private String name;
    private Professor head;
    private LinkedList<Course> courses;

    public Department(String name, Professor head) {
        this.name = name;
        this.head = head;
        this.courses = new LinkedList<>();
    }

    @Override
    public void addCourse(Course c) {
        courses.add(c);
        System.out.println("Курс \"" + c.getName() + "\" добавлен в кафедру " + name);
    }

    @Override
    public void removeCourse(Course c) {
        courses.remove(c);
        System.out.println("Курс \"" + c.getName() + "\" удалён из кафедры " + name);
    }

    @Override
    public List<Course> listCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public Professor getHead() {
        return head;
    }

    public void showDepartmentInfo() {
        System.out.println("Кафедра: " + name);
        System.out.println("Заведующий кафедрой: " + head.getDetails());
        System.out.println("Курсы:");
        for (Course c : courses) {
            System.out.println(" - " + c.getName());
        }
    }
}
