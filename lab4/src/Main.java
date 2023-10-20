import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Базовый класс "Вещественное число".
 */
class RealNumber {
    private double value;
    /**
     * Конструктор по умолчанию. Создает объект с нулевым значением.
     */
    public RealNumber() {
        this(0.0);
    }
    /**
     * Конструктор с параметрами. Создает объект с заданным значением.
     *
     * @param value Значение вещественного числа.
     */
    public RealNumber(double value) {
        this.value = value;
    }
    /**
     * Возвращает значение вещественного числа.
     *
     * @return Значение вещественного числа.
     */
    public double getValue() {
        return value;
    }
    /**
     * Вычисляет модуль вещественного числа.
     *
     * @return Модуль вещественного числа.
     */
    public double getModulus() {
        return Math.abs(value);
    }
    /**
     * Выводит информацию о вещественном числе в консоль.
     */
    public void printInfo() {
        System.out.println("Значение: " + value);
        System.out.println("Модуль: " + getModulus());
        // Код вывода информации в консоль
    }
}

/**
 * Производный класс "Комплексное число".
 */
class ComplexNumber extends RealNumber {
    private double imaginaryPart;
    /**
     * Конструктор по умолчанию. Создает комплексное число с нулевой вещественной и мнимой частями.
     */
    public ComplexNumber() {
        this(0.0, 0.0);
    }
    /**
     * Конструктор с параметрами. Создает комплексное число с заданными вещественной и мнимой частями.
     *
     * @param realPart      Вещественная часть комплексного числа.
     * @param imaginaryPart Мнимая часть комплексного числа.
     */
    public ComplexNumber(double realPart, double imaginaryPart) {
        super(realPart);
        this.imaginaryPart = imaginaryPart;
    }
    /**
     * Переопределенный метод для вычисления модуля комплексного числа.
     *
     * @return Модуль комплексного числа.
     */
    @Override
    public double getModulus() {
        return Math.sqrt(super.getValue() * super.getValue() + imaginaryPart * imaginaryPart);
    }
    /**
     * Переопределенный метод для вывода информации о комплексном числе в консоль.
     */
    @Override
    public void printInfo() {
        System.out.println("Вещественная часть: " + super.getValue());
        System.out.println("Мнимая часть: " + imaginaryPart);
        System.out.println("Модуль: " + getModulus());
        // Код вывода информации в консоль
    }
}

/**
 * Главный класс программы.
 */
public class Main {
    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    /**
     * Создает и отображает графический интерфейс программы.
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu mainMenu = new JMenu("Меню");

        JMenuItem aboutAuthorItem = new JMenuItem("Об авторе");
        JMenuItem exitItem = new JMenuItem("Выход");

        mainMenu.add(aboutAuthorItem);
        mainMenu.add(exitItem);
        menuBar.add(mainMenu);

        frame.setJMenuBar(menuBar);

        aboutAuthorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Автор: Галочкин Артур\nEmail: gal121303@gmail.com");
                // Код создания и отображения GUI
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);

        RealNumber realNumber1 = new RealNumber(5.0);
        RealNumber realNumber2 = new RealNumber(-3.0);
        ComplexNumber complexNumber1 = new ComplexNumber(2.0, 4.0);
        ComplexNumber complexNumber2 = new ComplexNumber(-1.0, -2.0);

        realNumber1.printInfo();
        realNumber2.printInfo();
        complexNumber1.printInfo();
        complexNumber2.printInfo();
    }
}
