package Controller;
import Model.DatabaseHandler;
import Model.MyTable;
import Model.NoteBook;
import Util.DirectionChanger;
import Util.FieldDefault;
import Util.Variable;
import View.AboutAuthor;
import View.AboutProgram;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.*;
/**
 * Класс главного окна,
 * содержащий все функциональные возможности программы
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class MainWindow extends JFrame {
    /**
     * Создает новую форму главного окна
     */
    public MainWindow() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LogoBNTUSmall.png"));
        try {
            this.setIconImage(icon);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Инициализация всех компонентов для формы
     */
    private void initComponents() {

        /*
         * Инициализация панелей
         */
        JPanel jpnlTable = new JPanel();
        JPanel jpnlDb = new JPanel();
        JPanel jpnlButton = new JPanel();
        JPanel jpnlParam = new JPanel();
        JPanel jpnlSearch = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teachers FITR");

        /*
         * Панель меню с инициализацией элементов меню
         */
        JMenuBar jmnuParameters = new JMenuBar();
        JMenu jmnuFile = new JMenu();
        JMenuItem jmniRead = new JMenuItem();
        JMenuItem jmniRecord = new JMenuItem();
        JMenuItem jmniReset = new JMenuItem();
        JMenuItem jmniClose = new JMenuItem();
        JMenu jmnuInfo = new JMenu();
        JMenuItem jmniAboutAuth = new JMenuItem();
        JMenuItem jmniAboutProg = new JMenuItem();

        /*
         * Инициализация кнопок
         */
        JButton jbtnCreate = new JButton();
        JButton jbtnUpdate = new JButton();
        JButton jbtnDelete = new JButton();
        JButton jbntUpload = new JButton();
        JButton jbtnClear = new JButton();
        JButton jbtnSearch = new JButton();
        JButton jbtnOBySeniority = new JButton();


        /*
         * Инициализации текстовых полей
         */
        jtxtSurname = new JTextField();
        jtxtName = new JTextField();
        jtxtPatronymic = new JTextField();
        jtxtFaculty = new JTextField();
        jtxtDepartment = new JTextField();
        jtxtSenuority = new JTextField();
        jtxtSearchS = new JTextField();

        /*
         * Инициализация Label
         */
         JLabel jlblSurname = new JLabel();
         JLabel jlblName = new JLabel();
         JLabel jlblPatronymic = new JLabel();
         JLabel jlblFaculty = new JLabel();
         JLabel jlblDepartment = new JLabel();
         JLabel jlblSenuority = new JLabel();
         JLabel jlblSort = new JLabel();

        DBConfigurationBuilder configBuilder = DBConfigurationBuilder.newBuilder();
        configBuilder.setPort(33306);
        // configBuilder.setDeletingTemporaryBaseAndDataDirsOnShutdown(true);
        configBuilder.setBaseDir("database");
        configBuilder.setDataDir("database");
        DB db;
        try {
            db = DB.newEmbeddedDB(configBuilder.build());
            db.start();
            String dbName = "test";
            db.createDB(dbName, "root", "");
            db.source("db.sql", "root", "", dbName);
        } catch (ManagedProcessException e) {
            // INSERT INTO `teachers` VALUES (3,'Воронич','Лидия','Вячеславовна','ФИТР','ПОИСиТ',4),(4,'Полозков','Юрий','Владимирович','ФИТР','ПОИСиТ',23),(5,'Борисова','Ирина','Михайловна','ФИТР','ПОИСиТ',32),(6,'Чепелев','Николай','Иосифович','ФИТР','ВМ',45),(7,'Чепелева','Тереса','Иосифовна','ФИТР','ВМ',40),(8,'Журавлева','Елена','Романовна','ФИТР','РТС',30);
            JOptionPane.showMessageDialog(null,
                    new String[]{"Произошла ошибка при создании базы данных!"},
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }

        /*
         * Инициализация таблицы
         */
        jtblList = new JTable();

        /*
         * Полоса прокрутки для инициализации таблицы
         */
        JScrollPane jscrTable = new JScrollPane();

        /*
         * Инициализация ComboBoxes
         */
        JComboBox<String> cmbSNP = new JComboBox<>();
        JComboBox<String> cmbDirection = new JComboBox<>();

        /*
         * Настройки для фрейма
         */
        setLayout(null);
        setVisible(true);

        /*
         * Настройка отображения текста
         */
         jlblSurname.setText("Surname");
         jlblName.setText("Name");
         jlblPatronymic.setText("Patronymic");
         jlblFaculty.setText("Faculty");
         jlblDepartment.setText("Department");
         jlblSenuority.setText("Senuority");
         jlblSort.setText("Sort by:");

        /*
         * Настройка отображения текста на кнопках
         */
        jbtnCreate.setText("Create");
        jbtnUpdate.setText("Update");
        jbtnClear.setText("Clear");
        jbtnDelete.setText("Delete");
        jbtnSearch.setText("Search");
        jbtnOBySeniority.setText("Senuority");
        jbntUpload.setText("Upload");

        /*
         * Установка модели таблицы по умолчанию
         */
        jtblList.setModel(new MyTable(new NoteBook(0)));

        /*
         * Инициализация прокрутки как компонента таблицы
         */
        jscrTable.setViewportView(jtblList);

        /*
         * Настройки кнопки Create
         */
        jbtnCreate.setBackground(new java.awt.Color(255, 255, 255));
        jbtnCreate.setFont(new java.awt.Font("Arial", 0, 14));
        jbtnCreate.setText("Create");
        jbtnCreate.addActionListener(evt -> {
            jbtnCreateActionPerformed(evt);
            jbtnUploadActionPerformed(evt);
        });

        /*
         * Настройки кнопки Update
         */
        jbtnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        jbtnUpdate.setFont(new java.awt.Font("Arial", 0, 14));
        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(evt -> {
            jbtnUpdateActionPerformed(evt);
            jbtnUploadActionPerformed(evt);
        });

        /*
         * Настройки кнопки Delete
         */
        jbtnDelete.setBackground(new java.awt.Color(255, 255, 255));
        jbtnDelete.setFont(new java.awt.Font("Arial", 0, 14));
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(evt -> {
            jbtnDeleteActionPerformed(evt);
            jbtnUploadActionPerformed(evt);
        });

        /*
         * Настройки кнопки Clear
         */
        jbtnClear.setBackground(new java.awt.Color(255, 255, 255));
        jbtnClear.setFont(new java.awt.Font("Arial", 0, 14));
        jbtnClear.setText("Clear");
        jbtnClear.addActionListener(this::jbtnClearActionPerformed);


        /*
         * Настройки кнопки Upload
         */
        jbntUpload.setBackground(new java.awt.Color(255, 255, 255));
        jbntUpload.setFont(new java.awt.Font("Arial", 0, 14));
        jbntUpload.setText("Upload");
        jbntUpload.addActionListener(this::jbtnUploadActionPerformed);


        /*
         * Настройки кнопки Search
         */
        jbtnSearch.setBackground(new java.awt.Color(255, 255, 255));
        jbtnSearch.setFont(new java.awt.Font("Arial", 0, 14));
        jbtnSearch.setText("Search");
        jbtnSearch.addActionListener(this::jbtnSearchActionPerformed);

        /*
         * Настройка ActionListener для упорядочения по стажу работы
         */
        jbtnOBySeniority.addActionListener(this::jbtnOBySenuorityActionPerformed);

        /*
         * Настройка моделей для ComboBox
         */
        cmbSNP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Surname", "Name", "Patronymic" }));
        cmbSNP.addActionListener(this::cmbSNPActionPerformed);
        cmbDirection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        cmbDirection.addActionListener(this::cmbDirectionActionPerformed);

        /*
         * Настройки для панели меню
         */
        jmnuFile.setText("File");
        jmnuFile.add(jmniReset);
        jmnuFile.add(jmniRecord);
        jmnuFile.add(jmniRead);
        jmnuFile.add(jmniClose);
        jmnuParameters.add(jmnuFile);
        jmnuInfo.setText("Information");
        jmnuInfo.add(jmniAboutAuth);
        jmnuInfo.add(jmniAboutProg);
        jmnuParameters.add(jmnuInfo);
        setJMenuBar(jmnuParameters);


        /*
         * Настройки для элементов меню
         */
        jmniRead.setText("Upload Database");
        jmniRead.addActionListener(this::jbtnUploadActionPerformed);

        jmniRecord.setText("Update file");
        jmniRecord.addActionListener(evt -> {
            jbtnUpdateActionPerformed(evt);
            jbtnUploadActionPerformed(evt);
        });

        jmniReset.setText("Clear");
        jmniReset.addActionListener(this::jbtnClearActionPerformed);

        jmniClose.setText("Close");
        jmniClose.addActionListener(this::jmniCloseActionPerformed);

        jmniAboutAuth.setText("About Author");
        jmniAboutAuth.addActionListener(this::jmniAboutAuthActionPerformed);

        jmniAboutProg.setText("About Program");
        jmniAboutProg.addActionListener(this::jmniAboutProgActionPerformed) ;

        /*
         * Реализация панелей
         */
        javax.swing.GroupLayout paramPanelLayout = new javax.swing.GroupLayout(jpnlParam);
        jpnlParam.setLayout(paramPanelLayout);
        paramPanelLayout.setHorizontalGroup(
                paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paramPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtxtSurname)
                                        .addComponent(jtxtName)
                                        .addComponent(jtxtPatronymic)
                                        .addComponent(jtxtFaculty)
                                        .addComponent(jtxtDepartment)
                                        .addComponent(jtxtSenuority, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                        .addGroup(paramPanelLayout.createSequentialGroup()
                                                .addGroup(paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jlblSurname)
                                                        .addComponent(jlblName)
                                                        .addComponent(jlblPatronymic)
                                                        .addComponent(jlblDepartment)
                                                        .addComponent(jlblSenuority)
                                                        .addComponent(jlblFaculty))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        paramPanelLayout.setVerticalGroup(
                paramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paramPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlblSurname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblPatronymic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtPatronymic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblFaculty)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtFaculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlblDepartment)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlblSenuority)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtSenuority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(jpnlButton);
        jpnlButton.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jbtnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbtnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbtnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbtnCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnDelete)
                                .addContainerGap(18, Short.MAX_VALUE))
        );


        javax.swing.GroupLayout dbPanelLayout = new javax.swing.GroupLayout(jpnlDb);
        jpnlDb.setLayout(dbPanelLayout);
        dbPanelLayout.setHorizontalGroup(
                dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dbPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlblSort)
                                .addGap(18, 18, 18)
                                .addComponent(cmbSNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnOBySeniority)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dbPanelLayout.setVerticalGroup(
                dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dbPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jlblSort)
                                        .addComponent(jbtnOBySeniority)
                                        .addComponent(cmbSNP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbDirection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(jpnlTable);
        jpnlTable.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
                tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jscrTable, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
                tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jscrTable, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 428, Short.MAX_VALUE)
        );


        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(jpnlSearch);
        jpnlSearch.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
                searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(searchPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jtxtSearchS, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnSearch)
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
                searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jbtnSearch)
                                        .addComponent(jtxtSearchS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
        );


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jpnlParam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jpnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jpnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jpnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jpnlDb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jpnlParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jpnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jpnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jpnlDb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jpnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    /**
     * Метод, отправляющий параметры методу addTeachers
     *
     * @param evt объект
     * @throws SQLException
     * @throws ClassNotFoundException
     * @see DatabaseHandler
     */
    private void jbtnCreateActionPerformed(ActionEvent evt){
        try{
            DatabaseHandler.addTeachers(jtxtSurname.getText(), jtxtName.getText(),jtxtPatronymic.getText(),
                    jtxtFaculty.getText(), jtxtDepartment.getText(), jtxtSenuority.getText());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(rootPane, "Successful created");
    }

    /**
     * Метод создает объект типа ResultSet и получает значение от метода getTeachers
     *
     * @param evt объект
     * @throws SQLException ошибка
     * @throws ClassNotFoundException ошибка
     * @see DatabaseHandler
     * @see JOptionPane
     */
    private void jbtnSearchActionPerformed(ActionEvent evt){
        try{
            ResultSet rs = DatabaseHandler.getTeachers(jtxtSearchS.getText());
            if(rs.next()){
                jtxtSurname.setText(rs.getString("Surname"));
                jtxtName.setText(rs.getString("Name"));
                jtxtPatronymic.setText(rs.getString("Patronymic"));
                jtxtFaculty.setText(rs.getString("Faculty"));
                jtxtDepartment.setText(rs.getString("Department"));
                jtxtSenuority.setText(String.valueOf(rs.getInt("Senuority")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(rootPane, "Successful searched");
    }


    /**
     * Метод, отправляющий параметры в метод updateTeachers
     *
     * @param evt объект
     * @throws SQLException ошибка
     * @throws ClassNotFoundException ошибка
     * @see DatabaseHandler
     * @see JOptionPane
     */
    private void jbtnUpdateActionPerformed(ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(rootPane, "Confirm, if you want to update data",
                "MySQL Connector", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                DatabaseHandler.updateTeachers(jtxtSurname.getText(), jtxtName.getText(), jtxtPatronymic.getText(),
                        jtxtFaculty.getText(), jtxtDepartment.getText(), jtxtSenuority.getText(), jtxtSearchS.getText());
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(rootPane, "Successful updated");
        }
    }

    /**
     * Метод, отправляющий параметры методу deleteTeachers
     *
     * @param evt объект
     * @throws SQLException ошибка
     * @throws ClassNotFoundException ошибка
     * @see DatabaseHandler
     * @see JOptionPane
     */
    private void jbtnDeleteActionPerformed(ActionEvent evt){
        if(JOptionPane.showConfirmDialog(rootPane,"Confirm, if you want to delete", "MySQL Connector",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try{
                DatabaseHandler.deleteTeachers(jtxtSearchS.getText());
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(rootPane, "Successful deleted");
        }
    }

    /**
     * Метод отправляет значение из метода clearField
     * и получает в методе setText для текстовых полей
     *
     * @param evt объект
     * @see ActionEvent
     * @see FieldDefault
     * @see JOptionPane
     */
    private void jbtnClearActionPerformed(ActionEvent evt){
        jtxtSurname.setText(FieldDefault.clearField());
        jtxtName.setText(FieldDefault.clearField());
        jtxtPatronymic.setText(FieldDefault.clearField());
        jtxtFaculty.setText(FieldDefault.clearField());
        jtxtDepartment.setText(FieldDefault.clearField());
        jtxtSenuority.setText(FieldDefault.clearField());
        jtxtSearchS.setText(FieldDefault.clearField());
        JOptionPane.showMessageDialog(rootPane,"Cleared");
    }

    /**
     * Метод для обновления таблицы
     *
     * @param evt объект
     * @see ActionEvent
     */
    private void jbtnUploadActionPerformed(ActionEvent evt){
        if (JOptionPane.showConfirmDialog(rootPane,"Confirm, if you want to upload Database by hand",
                "MySQL Connector", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            jtblList.setModel(new MyTable(new NoteBook(0)));
        }
    }

    /**
     * Метод закрытия окна
     *
     * @param evt объект
     * @see ActionEvent
     * @see JOptionPane
     */
    private void jmniCloseActionPerformed(ActionEvent evt){
        if (JOptionPane.showConfirmDialog(rootPane,"Confirm, if you want to exit",
                "MySQL Connector", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }


    /**
     * Метод вызывает метод AboutAuthor и устанавливает метод setVisible
     *
     * @param evt объект
     * @see ActionEvent
     */
    private void jmniAboutAuthActionPerformed(java.awt.event.ActionEvent evt) {
        new AboutAuthor().setVisible(true);
    }

    /**
     * Метод вызывает метод AboutProgram и устанавливает метод setVisible
     *
     * @param evt объект
     * @see ActionEvent
     */
    private void jmniAboutProgActionPerformed(java.awt.event.ActionEvent evt) {
        new AboutProgram().setVisible(true);
    }


    /**
     * Метод настройки табличной модели и вызывает MessageDialog
     *
     * @param evt объект
     * @see ActionEvent
     * @see JOptionPane
     */
    private void cmbSNPActionPerformed(ActionEvent evt) {
        JComboBox combo = (JComboBox) evt.getSource();
        String box = (String) combo.getSelectedItem();
        switch (box) {
            case "Surname": {
                jtblList.setModel(new MyTable(new NoteBook(1)));
                JOptionPane.showMessageDialog(rootPane, "Sorted by: " + box + ", direction: " + Variable.SORT_DIRECTION);
                break;
            }
            case "Name": {
                jtblList.setModel(new MyTable(new NoteBook(2)));
                JOptionPane.showMessageDialog(rootPane, "Sorted by: " + box + ", direction: " + Variable.SORT_DIRECTION);
                break;
            }
            case "Patronymic": {
                jtblList.setModel(new MyTable(new NoteBook(3)));
                JOptionPane.showMessageDialog(rootPane, "Sorted by: " + box + ", direction: " + Variable.SORT_DIRECTION);
                break;
            }
        }
    }

    /**
     * Метод настройки табличной модели и вызывает MessageDialog
     *
     * @param evt объект
     * @see ActionEvent
     * @see JOptionPane
     */
    private void jbtnOBySenuorityActionPerformed(ActionEvent evt){
        jtblList.setModel(new MyTable(new NoteBook(4)));
        JOptionPane.showMessageDialog(rootPane, "Sorted by: Senuority" + ", direction: " + Variable.SORT_DIRECTION);
    }

    /**
     * @param evt объект
     * @see JComboBox
     * @see ActionEvent
     * @see DirectionChanger
     */
    private void cmbDirectionActionPerformed(ActionEvent evt){
        JComboBox combo = (JComboBox) evt.getSource();
        String box = (String) combo.getSelectedItem();
        Variable.SORT_DIRECTION = DirectionChanger.DirectChanger(box);
    }

    /**
     * Основной метод класса
     *
     * @param args аргументы командной строки
     */
    public static void main(String args[]) {
        /* Создание и отображение формы */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    private JTextField jtxtSurname;
    private JTextField jtxtName;
    private JTextField jtxtPatronymic;
    private JTextField jtxtFaculty;
    private JTextField jtxtDepartment;
    private JTextField jtxtSenuority;
    private JTextField jtxtSearchS;
    private JTable jtblList;
}
