package View;
import Controller.MainWindow;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Класс, используемый для фрейма приветствия
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class Greetings extends JFrame {
    private final Timer timer;
    private Image icon;

    /**
     * Создается форма приветствия
     * (будет закрыта через 60 секунд)
     */
    public Greetings(){
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/teacherSmall.png"));
        initComponents();
        final int closeTime = 60000;//миллисекунды для закрытия
        timer = new Timer(closeTime, e -> dispose());
        timer.start();
        Image iconWin = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LogoBNTUSmall.png"));
        try {
            this.setIconImage(iconWin);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    /**
     * Метод инициализации компонентов
     */
    private void initComponents() {

        JPanel jpnlMain = new JPanel();
        JLabel jlblBNTU = new JLabel();
        JLabel jlblFITR = new JLabel();
        JLabel jlblDepartment = new JLabel();
        JLabel jlblCWork = new JLabel();
        JLabel jlblJava = new JLabel();
        JLabel jlblTitle = new JLabel();
        JLabel jlblGroup = new JLabel();
        JLabel jlblFIO = new JLabel();
        JLabel jlblTeacher = new JLabel();
        JLabel jlblTFIO = new JLabel();
        JLabel jlblMinsk = new JLabel();
        JLabel jlblIcon = new JLabel();

        JButton jbtnNext = new JButton();
        JButton jbtnExit = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Формирование списка преподавателей");

        jlblBNTU.setFont(new java.awt.Font("Arial", 0, 18));
        jlblBNTU.setText("Белорусский национальный технический университет");

        jlblFITR.setFont(new java.awt.Font("Arial", 0, 18));
        jlblFITR.setText("Факультет информационных технологий и робототехники");

        jlblDepartment.setFont(new java.awt.Font("Arial", 0, 18));
        jlblDepartment.setText("Кафедра программного обеспечения информационных систем и технологий");
        jlblDepartment.setMaximumSize(new java.awt.Dimension(710, 22));

        jlblCWork.setFont(new java.awt.Font("Arial", 0, 24));
        jlblCWork.setText("Курсовая работа");

        jlblJava.setFont(new java.awt.Font("Arial", 0, 18));
        jlblJava.setText("по дисциплине \"Программирование на языке Java\"");

        jlblTitle.setFont(new java.awt.Font("Arial", 0, 20));
        jlblTitle.setText("ФОРМИРОВАНИЕ СПИСКА ПРЕПОДАВАТЕЛЕЙ");

        jlblGroup.setFont(new java.awt.Font("Arial", 0, 16));
        jlblGroup.setText("Выполнила: студентка группы 10702120");

        jlblFIO.setFont(new java.awt.Font("Arial", 0, 16));
        jlblFIO.setText("Ашейчик Дарья Сергеевна");

        jlblTeacher.setFont(new java.awt.Font("Arial", 0, 16));
        jlblTeacher.setText("Преподаватель: доц.");

        jlblTFIO.setFont(new java.awt.Font("Arial", 0, 16));
        jlblTFIO.setText("Сидорик Валерий Владимирович");

        jlblMinsk.setFont(new java.awt.Font("Arial", 0, 18));
        jlblMinsk.setText("Минск 2022");

        jlblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblIcon.setIcon(new javax.swing.ImageIcon(icon));
        jlblIcon.setText("");

        jbtnNext.setText("Далее");
        jbtnNext.addActionListener(this::jbntNextActionPerformed);

        jbtnExit.setText("Выход");
        jbtnExit.addActionListener(this::jbtnExitActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jpnlMain);
        jpnlMain.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(jlblBNTU))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addComponent(jlblFITR))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(jlblDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(265, 265, 265)
                                                .addComponent(jlblCWork))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(161, 161, 161)
                                                .addComponent(jlblJava))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jlblTitle))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(307, 307, 307)
                                                .addComponent(jlblMinsk)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jbtnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(jlblIcon)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jlblTFIO)
                                                        .addComponent(jlblTeacher)
                                                        .addComponent(jlblFIO)
                                                        .addComponent(jlblGroup))))
                                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblBNTU)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblFITR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlblDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jlblCWork)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblJava)
                                .addGap(18, 18, 18)
                                .addComponent(jlblTitle)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jlblGroup)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlblFIO)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlblTeacher)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlblTFIO))
                                        .addComponent(jlblIcon))
                                .addGap(69, 69, 69)
                                .addComponent(jlblMinsk)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbtnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jpnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jpnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Используется при закрытии текущего фрейма
     * открывает фрейм главного окна
     *
     * @param evt объект
     */
    private void jbntNextActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new MainWindow().setVisible(true);
    }

    /**
     * Используется при закрытии текущего фрейма
     * @param evt объект
     */
    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * Основной метод класса
     * Стартовый метод для всех классов
     *
     * @param args аргумент командной строки
     */
    public static void main(String args[]) {
        /* Создание и отображение формы */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Greetings().setVisible(true);
            }
        });
    }
}
