package Model;

import Util.ConnectionChecker;
import Util.Const;
import Util.Variable;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Класс формирует массивный список учителей
 * и использование при формировании
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class NoteBook {
    ArrayList<Teacher> teacher = new ArrayList<>();
    private int form = 0;

    /**
     * Метод содержит обращения, которые включают запросы MySQL.
     * Использование для формирования списка NoteBook в необходимом порядке.
     *
     * @param form - влияние на методы сортировки таблицы
     */
    public NoteBook(int form) {
        switch (form) {
            case 0: {
                try {
                    Statement s = Objects.requireNonNull(ConnectionChecker.mycon()).createStatement();
                    ResultSet rs = s.executeQuery("SELECT " + Const.TEACHERS_ID + ", " + Const.TEACHERS_SURNAME
                            + "," + Const.TEACHERS_NAME + "," + Const.TEACHERS_PATRONYMIC
                            + "," + Const.TEACHERS_FACULTY + "," + Const.TEACHERS_DEPARTMENT
                            + "," + Const.TEACHERS_SENUORITY + " FROM " + Const.TEACHERS_TABLE
                            + " ORDER BY " + Const.TEACHERS_ID + " " + Variable.SORT_DIRECTION + "");
                    while (rs.next()) {
                        teacher.add(new Teacher(rs.getInt(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), rs.getInt(7)));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }

            case 1: {
                try {
                    Statement s = Objects.requireNonNull(ConnectionChecker.mycon()).createStatement();
                    ResultSet rs = s.executeQuery("SELECT " + Const.TEACHERS_ID + ", " + Const.TEACHERS_SURNAME
                            + "," + Const.TEACHERS_NAME + "," + Const.TEACHERS_PATRONYMIC
                            + "," + Const.TEACHERS_FACULTY + "," + Const.TEACHERS_DEPARTMENT
                            + "," + Const.TEACHERS_SENUORITY + " FROM " + Const.TEACHERS_TABLE
                            + " ORDER BY " + Const.TEACHERS_SURNAME + " " + Variable.SORT_DIRECTION + "");
                    while (rs.next()) {
                        teacher.add(new Teacher(rs.getInt(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), rs.getInt(7)));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }

            case 2: {
                try {
                    Statement s = Objects.requireNonNull(ConnectionChecker.mycon()).createStatement();
                    ResultSet rs = s.executeQuery("SELECT " + Const.TEACHERS_ID + ", " + Const.TEACHERS_SURNAME
                            + "," + Const.TEACHERS_NAME + "," + Const.TEACHERS_PATRONYMIC
                            + "," + Const.TEACHERS_FACULTY + "," + Const.TEACHERS_DEPARTMENT
                            + "," + Const.TEACHERS_SENUORITY + " FROM " + Const.TEACHERS_TABLE
                            + " ORDER BY " + Const.TEACHERS_NAME + " " + Variable.SORT_DIRECTION + "");
                    while (rs.next()) {
                        teacher.add(new Teacher(rs.getInt(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), rs.getInt(7)));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }

            case 3: {
                try {
                    Statement s = Objects.requireNonNull(ConnectionChecker.mycon()).createStatement();
                    ResultSet rs = s.executeQuery("SELECT " + Const.TEACHERS_ID + ", " + Const.TEACHERS_SURNAME
                            + "," + Const.TEACHERS_NAME + "," + Const.TEACHERS_PATRONYMIC
                            + "," + Const.TEACHERS_FACULTY + "," + Const.TEACHERS_DEPARTMENT
                            + "," + Const.TEACHERS_SENUORITY + " FROM " + Const.TEACHERS_TABLE
                            + " ORDER BY " + Const.TEACHERS_PATRONYMIC + " " + Variable.SORT_DIRECTION + "");
                    while (rs.next()) {
                        teacher.add(new Teacher(rs.getInt(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), rs.getInt(7)));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }
            case 4:{
                try {
                    Statement s = Objects.requireNonNull(ConnectionChecker.mycon()).createStatement();
                    ResultSet rs = s.executeQuery("SELECT " + Const.TEACHERS_ID + ", " + Const.TEACHERS_SURNAME
                            + "," + Const.TEACHERS_NAME + "," + Const.TEACHERS_PATRONYMIC
                            + "," + Const.TEACHERS_FACULTY + "," + Const.TEACHERS_DEPARTMENT
                            + "," + Const.TEACHERS_SENUORITY + " FROM " + Const.TEACHERS_TABLE
                            + " GROUP BY " + Const.TEACHERS_ID +" ORDER BY " + Const.TEACHERS_SENUORITY + " "
                            + Variable.SORT_DIRECTION + "");
                    while (rs.next()) {
                        teacher.add(new Teacher(rs.getInt(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6), rs.getInt(7)));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }
        }
    }

    /*
     * Возвращает размер массива teacher ArrayList
     *
     * @return teacher.size()
     */
    public int getCount() {
        return this.teacher.size();
    }

    /**
     * @param index - номер в списке
     * @return teacher.get(index)
     */
    public Teacher getTeacher(int index) {
        return teacher.get(index);
    }
}
