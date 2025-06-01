import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Stammbaum extends JFrame {
    private JPanel main;
    private JPanel panel_parent;
    private JPanel panel_current;
    private JPanel panel_child;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem add;
    private JMenuItem export;
    private List<Person> personList = new ArrayList<>();

    public Stammbaum() {
        super("Stammbaum");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setContentPane(main);

        //JMenu
        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        add = new JMenuItem("Add");
        export = new JMenuItem("Export");
        menu.add(add);
        menu.add(export);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPerson();
                loadPersons();
            }
        });

        setVisible(true);
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void loadPersons() {
        if (!personList.isEmpty()) {
            for (Person person : personList) {
                panel_current.add(person.getMain());
                System.out.println(person.getName);
            }
        }
    }

    public static void main(String[] args) {
        new Stammbaum();
    }
}
