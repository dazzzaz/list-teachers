package Model;
import Util.ConnectionChecker;
import Util.Const;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Класс содержит методы для формирования и отправки
 * запросов к базе данных, которая содержит данные
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class DatabaseHandler {
    /**
     * Запрос на обновление данных об учителе в базе данных
     *
     * @param surnameS      - фамилия
     * @param nameS         - имя
     * @param patronymicS   - отчество
     * @param facultyS         - факультет
     * @param departmentS         - кафедра
     * @param senuorityS     - стаж работы
     * @param idS           - id
     * @throws SQLException ошибка
     * @throws ClassNotFoundException ошибка
     */
    public static void updateTeachers(String surnameS, String nameS, String patronymicS, String facultyS, String departmentS, String senuorityS, String idS) throws SQLException, ClassNotFoundException {
        //Строка запроса
        Statement s = ConnectionChecker.mycon().createStatement();

        s.executeUpdate("UPDATE " + Const.TEACHERS_TABLE + " SET " + Const.TEACHERS_SURNAME + " = '"
                + surnameS + "'," + Const.TEACHERS_NAME + " = '" + nameS + "'," + Const.TEACHERS_PATRONYMIC + " = '"
                + patronymicS + "'," + Const.TEACHERS_FACULTY + " = '" + facultyS + "'," + Const.TEACHERS_DEPARTMENT + " = '"
                + departmentS + "'," + Const.TEACHERS_SENUORITY + " = '"
                + senuorityS + "' WHERE " + Const.TEACHERS_ID + " = '" + idS + "'");
    }

    /**
     * Запрос на удаление преподавателя из базы данных
     *
     * @param idS - id
     * @throws SQLException ошибка
     * @throws ClassNotFoundException ошибка
     */
    public static void deleteTeachers(String idS) throws SQLException, ClassNotFoundException {
        //строка запроса
        Statement s = ConnectionChecker.mycon().createStatement();
        s.executeUpdate("DELETE FROM " + Const.TEACHERS_TABLE + " WHERE " + Const.TEACHERS_ID + " = '" + idS + "'");
    }

    /**
     * Запрос для добавления преподавателя в базу данных
     * @param surnameS      - фамилия
     * @param nameS         - имя
     * @param patronymicS   - отчество
     * @param facultyS         - факультет
     * @param departmentS         - кафедра
     * @param senuorityS     - стаж работы
     * @throws SQLException ошибка
     * @throws ClassNotFoundException ошибка
     */
    public static void addTeachers(String surnameS, String nameS, String patronymicS, String facultyS, String departmentS, String senuorityS) throws SQLException, ClassNotFoundException {
        //строка запроса
        Statement s = ConnectionChecker.mycon().createStatement();

        s.executeUpdate("INSERT INTO " + Const.TEACHERS_TABLE + "(" + Const.TEACHERS_SURNAME + ","
                + Const.TEACHERS_NAME + "," + Const.TEACHERS_PATRONYMIC + ","
                + Const.TEACHERS_FACULTY + "," + Const.TEACHERS_DEPARTMENT + ","
                + Const.TEACHERS_SENUORITY + ") VALUES ('" + surnameS + "','" + nameS + "','" + patronymicS + "','"
                + facultyS + "','" + departmentS + "','" + senuorityS + "')");
        s.closeOnCompletion();
    }

    /**
     * Запрос для получения преподавателя из базы данных
     *
     * @param idS - id
     * @return rs - результат запроса из MySQL
     * @throws SQLException error
     * @throws ClassNotFoundException error
     */
    public static ResultSet getTeachers(String idS) throws SQLException, ClassNotFoundException {
        //строка запроса
        Statement s = ConnectionChecker.mycon().createStatement();
        //Использование для поиска
        ResultSet rs = s.executeQuery("SELECT " + Const.TEACHERS_SURNAME + "," + Const.TEACHERS_NAME + " ,"
                + Const.TEACHERS_PATRONYMIC + " ," + Const.TEACHERS_FACULTY + " ," + Const.TEACHERS_DEPARTMENT + " ,"
                + Const.TEACHERS_SENUORITY + " FROM " + Const.TEACHERS_TABLE + " WHERE  "
                + Const.TEACHERS_ID + " = '" + idS + "'");
        return rs;
    }
}
