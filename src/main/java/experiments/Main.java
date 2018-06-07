package experiments;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Person x = Person.builder().name("Dmitry").surName("Demyanov").birthday(new GregorianCalendar(1989, 8, 18)).profession(Person.Profession.PROGRAMMER).sex(Person.Sex.MAN).build();

        x.setName("XZY");

        Thread r = new Thread(() -> System.out.println("new string"));

        ActionListener al = (System.out::println);




        ArrayList <String> list = new ArrayList <>();
        list.forEach(System.out::println);

        JButton button = new JButton("Fuck");
        button.setActionCommand("comma");
        button.addActionListener(e -> System.out.println("Button pressed"));
    }
}
