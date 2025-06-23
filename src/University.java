import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class University {
    private ArrayList<Course> courses;
    private HashMap<Integer, Student> studentDirectory;
    private HashMap<String, LinkedList<Course>> coursesByDept;

    public University() {
        courses = new ArrayList<>();
        studentDirectory = new HashMap<>();
        coursesByDept = new HashMap<>();
    }

    // Курсы

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void showAllCourses() {
        System.out.println("Университетские курсы:");
        for (Course course : courses) {
            course.showCourseDetails();
            System.out.println("--------------------------");
        }
    }

    // Справочник студентов

    public void registerStudent(Student s) {
        studentDirectory.put(s.getId(), s);
    }

    public Student findStudentById(int id) throws StudentNotFoundException {
        if (!studentDirectory.containsKey(id)) {
            throw new StudentNotFoundException("Студент с ID " + id + " не найден.");
        }
        return studentDirectory.get(id);
    }

    // Курсы по кафедрам

    public void addCourseToDept(String deptName, Course c) {
        coursesByDept.computeIfAbsent(deptName, k -> new LinkedList<>()).add(c);
    }

    public List<Course> getCoursesForDept(String deptName) {
        return coursesByDept.getOrDefault(deptName, new LinkedList<>());
    }

    // Геттеры

    public HashMap<Integer, Student> getStudentDirectory() {
        return studentDirectory;
    }

    public HashMap<String, LinkedList<Course>> getCoursesByDept() {
        return coursesByDept;
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}
