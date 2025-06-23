public class Main {
    public static void main(String[] args) {
        try {
            // Преподаватели
            Professor prof1 = new Professor("Иван Викторович к.ф.м.н.", 1001, "Компьютерные науки");
            Professor prof2 = new Professor("Алла Ивановна к.ф.н.", 1002, "Филология");

            // Курсы с вместимостью
            Course course1 = new Course("Введение в программирование", prof1, 2);
            Course course2 = new Course("Финский язык", prof2, 1);

            // Студенты
            Student s1 = new Student("Дмитрий", 2001, "ПМИ");
            GraduateStudent s2 = new GraduateStudent("Дарья", 2002, "Экономика", "Влияние налоговой реформы");
            Student s3 = new Student("Диана", 2003, "Менеджмент");
            Student s4 = new Student("Алексей", 2004, "Филология");

            // Университет и регистрация студентов
            University university = new University();
            university.registerStudent(s1);
            university.registerStudent(s2);
            university.registerStudent(s3);
            university.registerStudent(s4);

            // Добавление курсов
            university.addCourse(course1);
            university.addCourse(course2);

            // Группировка курсов по кафедрам
            university.addCourseToDept(prof1.getDepartment(), course1);
            university.addCourseToDept(prof2.getDepartment(), course2);

            // Добавление студентов на курсы
            course1.addStudent(s1);
            course1.addStudent(s2);
            course1.addStudent(s3); // в очередь ожидания
            course1.addStudent(s4); // тоже в очередь ожидания

            course2.addStudent(s3);
            course2.addStudent(s4); // в очередь ожидания

            // Объявления
            course1.publish("Занятие перенесено на пятницу.");
            course1.publish("Дедлайн по проекту — 25 мая.");
            course2.publish("Начало занятий в 9:00.");

            // Планирование событий
            course1.scheduleEvent("Лекция 1", "2025-09-01 10:00");
            course1.scheduleEvent("Лекция 2", "2025-09-08 10:00");
            prof1.scheduleEvent("Совещание кафедры", "2025-09-05 14:00");

            // Вывод информации
            university.showAllCourses();

            // Получение ленты объявлений
            System.out.println("\nЛента курса '" + course1.getName() + "':");
            for (String msg : course1.getFeed()) {
                System.out.println("• " + msg);
            }

            // Проверка расписания
            System.out.println("\nРасписание преподавателя " + prof1.getDetails() + ":");
            for (Event e : prof1.getSchedule()) {
                System.out.println("- " + e.getDescription() + " в " + e.getDateTime());
            }

            // Поиск зарегистрированного студента
            Student found = university.findStudentById(2002);
            System.out.println("\nНайден студент: " + found.getDetails());

            // Работа с кафедрой
            Department csDept = new Department("Компьютерные науки", prof1);
            csDept.addCourse(course1);
            System.out.println("\nКурсы кафедры " + csDept.getName() + ":");
            for (Course c : csDept.listCourses()) {
                System.out.println("- " + c.getName());
            }

        } catch (InvalidCourseException | StudentNotFoundException | CourseFullException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
