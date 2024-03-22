import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame {

    private JPanel InputPanel, outputPanel,resultPanel, exitPanel;
    private JLabel label1, weightLabel, heightLabel, bmiResultLabel, bmiCategoryLabel, bmiIcon;
    private JTextField weightField, heightField;
    private JButton clear, calculate, exit;

    private Icon icon;

    public LabelFrame() {
        super("BMI Calculator");
        setLayout(new BorderLayout(10, 10));

        InputPanel = new JPanel();
        InputPanel.setLayout(new GridLayout(4, 2));

        label1 = new JLabel("Enter your details: ");
        InputPanel.add(label1);
        InputPanel.add(new JLabel());

        weightLabel = new JLabel("Weight (kg): ");
        InputPanel.add(weightLabel);

        weightField = new JTextField(10);
        InputPanel.add(weightField);

        heightLabel = new JLabel("Height (cm): ");
        InputPanel.add(heightLabel);

        heightField = new JTextField(10);
        InputPanel.add(heightField);

        clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weightField.setText("");
                heightField.setText("");
                bmiResultLabel.setText("");
                bmiCategoryLabel.setText("");
            }
        });

        calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                double bmi = weight / Math.pow(height / 100, 2);
                bmiResultLabel.setText("Your BMI is: " + String.format("%.2f", bmi));
                if (bmi < 18.5) {
                    bmiCategoryLabel.setText("Category: Underweight");
                    bmiIcon.setIcon(new ImageIcon(getClass().getResource("underweight.png")));
                } else if (bmi < 25) {
                    bmiCategoryLabel.setText("Category: Normal weight");
                    bmiIcon.setIcon(new ImageIcon(getClass().getResource("normal.png")));
                } else if (bmi < 30) {
                    bmiCategoryLabel.setText("Category: Overweight");
                    bmiIcon.setIcon(new ImageIcon(getClass().getResource("overweight.png")));
                } else {
                    bmiCategoryLabel.setText("Category: Obese");
                    bmiIcon.setIcon(new ImageIcon(getClass().getResource("obese.png")));

                }
            }
        });

        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        InputPanel.add(clear);
        InputPanel.add(calculate);

        add(InputPanel, BorderLayout.WEST);

        resultPanel = new JPanel();
        resultPanel.setLayout(null);
        resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));
        resultPanel.setBounds(10 ,80 ,380 ,80 );
        bmiResultLabel = new JLabel();
        bmiResultLabel.setBounds(10, 20, 200, 20);
        bmiCategoryLabel = new JLabel();
        bmiCategoryLabel.setBounds(10, 40, 200, 20);
        bmiIcon = new JLabel();
        bmiIcon.setBounds(200, 10, 100, 100);
        resultPanel.add(bmiResultLabel);
        resultPanel.add(bmiCategoryLabel);
        resultPanel.add(bmiIcon);

        add(resultPanel);

        exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.add(exit);
        add(exitPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        LabelFrame labelFrame = new LabelFrame();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(550, 300);
        labelFrame.setVisible(true);
    }
}

