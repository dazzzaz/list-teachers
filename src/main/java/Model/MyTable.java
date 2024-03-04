package Model;
import javax.swing.event.EventListenerList;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
/**
 * Класс, используемый для табличной модели
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class MyTable extends AbstractTableModel {
    private NoteBook data;

    /**
     * Устанавливает табличные данные
     *
     * @param noteBook - массив список преподавателей
     * @see NoteBook
     */
    public MyTable(NoteBook noteBook){
        this.data = noteBook;
    }

    /**
     * Возвращает количество строк в модели.
     *
     * @return количество строк в модели
     * @see #getColumnCount
     */
    @Override
    public int getRowCount() {
        return data.getCount();
    }

    /**
     * Возвращает количество столбцов в модели.
     *
     * @return 8 - количество столбцов в модели
     * @see #getRowCount
     */
    @Override
    public int getColumnCount() {
        return 7;
    }

    /**
     * Возвращает имя столбца
     * Если столбец не может быть найден, возвращается пустая строка.
     *
     * @param column запрашиваемый столбец
     * @return строка, содержащая имя столбца по умолчанию
     */
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:return "Surname";
            case 1:return "Name";
            case 2:return "Patronymic";
            case 3:return "Faculty";
            case 4:return "Department";
            case 5:return "Senuority";
            case 6:return "Personal Code";
        }
        return "";
    }

    /**
     * Возвращает значение для ячейки в ColumnIndex и RowIndex.
     *
     * @param rowIndex строка, значение которой должно быть запрошено
     * @param columnIndex столбец, значение которого должно быть запрошено
     * @return объект значения в указанной ячейке
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return data.getTeacher(rowIndex).getSurname();
            case 1: return data.getTeacher(rowIndex).getName();
            case 2: return data.getTeacher(rowIndex).getPatronymic();
            case 3: return data.getTeacher(rowIndex).getFaculty();
            case 4: return data.getTeacher(rowIndex).getDepartment();
            case 5: return data.getTeacher(rowIndex).getSenuority();
            case 6: return data.getTeacher(rowIndex).getID();
        }
        return "-";
    }


    /**
     *  Возвращает значение false. Это реализация по умолчанию для всех ячеек.
     *
     *  @param  rowIndex  запрашиваемая строка
     *  @param  columnIndex запрашиваемый столбец
     *  @return false
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Уведомляет всех слушателей о том, что
     * строки в диапазоне [firstRow, lastRow] включительно были обновлены.
     *
     * @param firstRow  первая строка
     * @param lastRow   последняя строка
     *
     * @see TableModelEvent
     * @see EventListenerList
     */
    @Override
    public void fireTableRowsUpdated(int firstRow, int lastRow) {
        fireTableChanged(new TableModelEvent(this, firstRow, lastRow,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.UPDATE));
    }
}
