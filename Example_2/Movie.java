package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_3;

public class Movie
{
    private long id;
    private String name;
    private int year;
    private int lenght;
    private int grade;
    private  String description;

    public Movie(){}

    public Movie(long id, String name, int year, int lenght, int grade, String description) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.lenght = lenght;
        this.grade = grade;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
