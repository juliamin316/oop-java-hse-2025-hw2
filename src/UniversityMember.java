public class UniversityMember implements Person {
    protected String name;
    protected int id;

    public UniversityMember(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDetails() {
        return "Человек из университета";
    }
}
