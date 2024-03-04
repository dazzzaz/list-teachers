package View;
import javax.swing.*;
import java.awt.*;
/**
 * Класс, используемый для фрейма Об авторе
 *
 * @author Asheychik D.S.
 * @version 1.2
 */
public class AboutAuthor extends JFrame {
    private Image icon;
    /**
     * Создает новую форму об авторе
     */
    public AboutAuthor() {
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/AuthorSmall.jpg"));
        initComponents();
        Image iconWin = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LogoBNTUSmall.png"));
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
        setTitle("About Author");

        JLabel jlblAbout = new JLabel();
        JLabel jlblAuthor = new JLabel();
        JLabel jlblGroup = new JLabel();
        JLabel jlblGmail = new JLabel();
        JButton jbtnExit = new JButton();
        JLabel jlblIcon = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jlblAbout.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jlblAbout.setText("About Author");

        jlblAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jlblAuthor.setText("Asheychik Darya Sergeevna");
        jlblAuthor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlblAuthor.setMaximumSize(new java.awt.Dimension(150, 20));

        jlblGroup.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jlblGroup.setText("Student of group 10702120");

        jlblGmail.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jlblGmail.setText("Gmail: ashejchik2003@gmail.com");

        jlblIcon.setIcon(new javax.swing.ImageIcon(icon));

        jbtnExit.setText("Close");
        jbtnExit.addActionListener(this::jbtnExitActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jlblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(jlblAbout))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jlblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jlblGmail)
                                                        .addComponent(jlblGroup)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addComponent(jbtnExit)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jlblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jlblAbout)
                                                .addGap(18, 18, 18)
                                                .addComponent(jlblGroup)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jlblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jlblGmail)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jbtnExit)))
                                .addContainerGap(30, Short.MAX_VALUE))
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
     * @param args аргументы командной строки
     */
    public static void main(String args[]) {
        /* Создание и отображение формы */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutAuthor().setVisible(true);
            }
        });
    }
}
