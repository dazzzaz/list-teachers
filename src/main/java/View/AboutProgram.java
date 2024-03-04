package View;
import javax.swing.*;
import java.awt.*;
/**
 * Класс, используемый для фрейма О программе
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class AboutProgram extends JFrame {
    /**
     * Создает новую форму о программе
     */
    public AboutProgram() {
        initComponents();
        Image iconWin = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LogoBNTUSmall.png"));
       // Image iconWin = Toolkit.getDefaultToolkit().getImage("src/main/java/images/LogoBNTUSmall.png");
        try {
            this.setIconImage(iconWin);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Метод инициализации компонентов фрейма
     */
    private void initComponents() {

        JScrollPane jscrText = new JScrollPane();
        JTextArea jtxaAboutprog = new JTextArea();
        JButton jbtnExit = new JButton();
        JTextField jtxtVersion = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Program");

        jtxaAboutprog.setBackground(new java.awt.Color(242, 242, 242));
        jtxaAboutprog.setFont(new java.awt.Font("Arial", 0, 14));
        jtxaAboutprog.setText("Сreating a list of teachers\n\nThe program allows you to:\n1. Add, delete, change the list" +
                "\n2. Sort the list in ascending and descending order by " +
                "\nwork seniority, as well as by surname, first name and" +
                "\npatronymic\n");
        jscrText.setViewportView(jtxaAboutprog);
        jtxaAboutprog.setEditable(false);

        jbtnExit.setText("Close");
        jbtnExit.addActionListener(this::jbtnExitActionPerformed);

        jtxtVersion.setText("Version ver. 1.2");
        jtxtVersion.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jscrText, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jtxtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jbtnExit)))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jscrText, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbtnExit)
                                        .addComponent(jtxtVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
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
     *
     * @param args аргументы командной строки
     */
    public static void main(String args[]) {
        /* Создание и отображение формы */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutProgram().setVisible(true);
            }
        });
    }
}

