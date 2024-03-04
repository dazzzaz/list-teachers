package Model;
/**
 * Класс, описание учителя
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class Teacher {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String faculty;
    private String department;
    private int senuority;

    /**
     * Конструктор по умолчанию для учителя
     */
    public Teacher(){
        this.surname = null;
        this.name = null;
        this.patronymic = null;
    }

    /**
     * Конструктор для создания экземпляра учителя
     *
     * @param id         - id
     * @param surname    - фамилия
     * @param name       - имя
     * @param patronymic - отчество
     * @param faculty    - факультет
     * @param department - кафедра
     * @param senuority  - стаж работы
     */
    public Teacher(int id, String surname, String name, String patronymic, String faculty, String department, int senuority) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.faculty = faculty;
        this.department = department;
        this.senuority = senuority;
    }


    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSenuority() {
        return senuority;
    }

    public void setSenuority(int senuority) {
        this.senuority = senuority;
    }
}
