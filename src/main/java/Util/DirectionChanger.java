package Util;
/**
 * Класс, реализующий сортировку
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class DirectionChanger {
    /**
     * Метод, используемый для изменения порядка сортировки
     *
     * @param curDirect - Значение направления ComboBox
     * @return Direct
     */
    public static String DirectChanger(String curDirect){
        String Direct = "Ascending";
        switch(curDirect){
            case "Ascending":{ Direct = "ASC";break;}
            case "Descending":{ Direct = "DESC";break;}
        }
        return Direct;
    }
}
