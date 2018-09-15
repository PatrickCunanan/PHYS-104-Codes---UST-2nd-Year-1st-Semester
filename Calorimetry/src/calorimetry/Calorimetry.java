/* Main program */
package calorimetry;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public final class Calorimetry {
    static HelpButton helpaction;
    ChangeLabel1 change1,change2;
    ChangeLabel2 change3,change4;
    static Calorimetry CaloObject;
    boolean logic,logic2;
    Formulas formula = new Formulas();
    FileReaderCalorimetry filereader = new FileReaderCalorimetry();
    FileReaderCalorimetry filereader2 = new FileReaderCalorimetry();
    ExitButton exitbutton = new ExitButton();
    Solve1 solve_1;
    Solve2 solve_2;
    Solve3 solve_3;
    static JFrame frame = new JFrame("Physics project".toUpperCase());
    static Container pane = frame.getContentPane();
    JPanel problem3;JLabel phrase10_3,phrase1_3,phrase2_3,phrase3_3,phrase4_3,phrase5_3,phrase6_3,phrase7_3;JTextField input_1,input_2,input_3,input_4,output_2,input_$,input_5,output_$;JComboBox Material_1,material_3;JButton Solve3,Exit3;
    JPanel problem2;JLabel phrase10_2,phrase1_2,phrase2_2,phrase3_2,phrase4_2,phrase5_2,phrase6_2,phrase7_2;JTextField input1_2,input2_2,input4_2,input5_2,input3_2$,input6_2,input7_2$,input8_2$,input9_2;JComboBox Material_2,Material1_2;JButton solve2;
    static JButton help;
    JLabel phrase1,phrase2,phrase3,phrase4,phrase5,phrase6,phrase7;JPanel problem1,CurrentProb;JTextField input1,input2,MaterialLabel,MaterialLabel2,MaterialLabel3,input3;JComboBox problems;JComboBox Material;JButton Solve1,Solve2,Exit;JTextArea SolutionPad;JScrollPane horizontal;
    final String  []listofProblems = {"Problem1","Problem2","Problem3"}, ListofMaterial = {"ice","aluminum","copper","lead","silver","ethyl_alcohol","mercury"},ListofMaterial2 = {"water","aluminum","copper","lead","silver","ethyl_alcohol","mercury"},
            ListofMaterial3 = {"aluminum","copper","lead","silver"},ListofMaterial4 = {"water","ice","aluminum","copper","lead","silver","ethyl_alcohol","mercury"};
    static final int x = 100, y = 100;
    
    public Calorimetry(){
       
       frame.setSize(680, 530);
       frame.setLocation(x, y);
       frame.setLayout(null);
       frame.setResizable(false);
       
       problems = new JComboBox(listofProblems);
       problems.setSize(100, 20);
       problems.setLocation(13, 5);
       
       SolutionPad = new JTextArea("");
       SolutionPad.setEditable(false);
       horizontal = new JScrollPane(SolutionPad);
       horizontal.setSize(640,230);
       horizontal.setLocation(13, 250);
       help = new JButton("?");
       help.setSize(50,20);
       help.setLocation(604,5);
       
       Problem1();
       solve_1 = new Solve1(Material,input1,input2,input3,SolutionPad);
       Solve1.addActionListener(solve_1);
       CurrentProb = problem1;
       
       Problem2();
       solve_2 = new Solve2(input1_2,Material_2,input2_2,Material1_2,input4_2,input5_2,input6_2,input9_2,SolutionPad);
       Solve2.addActionListener(solve_2);

       
       Problem3();
       solve_3 = new Solve3(input_1,Material_1,input_2,input_3,input_4,Material_2,input_5,SolutionPad);
       Solve3.addActionListener(solve_3);

       
       pane.add(problem1);
       pane.add(problem2);
       pane.add(problem3);
       problem2.setVisible(false);
       problem3.setVisible(false);
       pane.add(problems);
       pane.add(horizontal);
       pane.add(help);
       
       ChangeProblem Change = new ChangeProblem(problem1,problem2,problem3);
       problems.addActionListener(Change);
       frame.setVisible(true);
    }
    public static void main(String[] args)throws IOException{
            CaloObject = new Calorimetry();
            helpaction = new HelpButton(frame);
            help.addActionListener(helpaction);
            
            
    }
    private void Problem1(){
        problem1 = new JPanel();
        problem1.setSize(640,210);
        problem1.setLocation(13, 30);
        problem1.setLayout(null);
        problem1.setBackground(Color.LIGHT_GRAY);
        
        phrase1 = new JLabel("Problem #1:");
        phrase1.setSize(500, 15);
        phrase1.setLocation(5, 5);
        
        Material = new JComboBox (ListofMaterial);
        Material.setSize(100, 20);
        Material.setLocation(5, 18);
        
        phrase2 = new JLabel(" at                  °C is placed in a Styrofoam cup containing               kg of lemonade at                °C.");
        phrase2.setSize(900, 15);
        phrase2.setLocation(105, 21);
        
        input1 = new JTextField("");
        input1.setSize(40,15);
        input1.setLocation(415,20);
        
        phrase3 = new JLabel("The specific heat capacity of lemonade is virtually the same sa that of a water; that is, C = 4186 J/(kg*°C). After");
        phrase3.setSize(700,15);
        phrase3.setLocation(5, 40);
        
        input2 = new JTextField("");
        input2.setSize(40,15);
        input2.setLocation(563,20);
        
        phrase4 = new JLabel("the                                 and lemonade reach an equilibrium temperature, some                                still remains. The");
        phrase4.setSize(3500,15);
        phrase4.setLocation(5,60);
        
        MaterialLabel = new JTextField((String)Material.getSelectedItem());
        MaterialLabel.setSize(90,15);
        MaterialLabel.setLocation(27,60);
        MaterialLabel.setEditable(false);
        
        MaterialLabel2 = new JTextField((String)Material.getSelectedItem());
        MaterialLabel2.setSize(90,15);
        MaterialLabel2.setLocation(435,60);
        MaterialLabel2.setEditable(false);
        
        phrase5 = new JLabel("Latent heat of fusion for water is Lf = 3.35 x 10^5 J/kg. Assume that the mass of cup is so small that it absorbs");
        phrase5.setSize(700,15);
        phrase5.setLocation(5,80);
        
        phrase6 = new JLabel("a negligible amounf of heat, and ignore any heat lost to the surroundings. Determine the mass of                 ");
        phrase6.setSize(700,15);
        phrase6.setLocation(5,100);
        
        MaterialLabel3 = new JTextField((String)Material.getSelectedItem());
        MaterialLabel3.setSize(80,15);
        MaterialLabel3.setLocation(550,100);
        MaterialLabel3.setEditable(false);
        
        change1 = new ChangeLabel1(MaterialLabel,MaterialLabel2,MaterialLabel3,Material);
        Material.addActionListener(change1);
        
        phrase7 = new JLabel("that has melted.");
        phrase7.setSize(120,15);
        phrase7.setLocation(5,120);
        
        input3 = new JTextField("");
        input3.setSize(50,15);
        input3.setLocation(123,20);
        
        Solve1 = new JButton("Calculate");
        Solve1.setSize(95,25);
        Solve1.setLocation(450,170);
        
        Exit = new JButton("Exit");
        Exit.setSize(70,25);
        Exit.setLocation(550,170);
        Exit.addActionListener(exitbutton);
        
       
        problem1.add(input1); problem1.add(phrase1); problem1.add(phrase2); problem1.add(Material); problem1.add(input2); problem1.add(phrase3);
        problem1.add(phrase4); problem1.add(MaterialLabel); problem1.add(MaterialLabel2); problem1.add(phrase5); problem1.add(phrase6);
        problem1.add(MaterialLabel3); problem1.add(phrase7); problem1.add(Solve1); problem1.add(Exit); problem1.add(input3);
    }
    private void Problem2(){
        problem2 = new JPanel();
        problem2.setSize(640,210);
        problem2.setLocation(13, 30);
        problem2.setLayout(null);
        problem2.setBackground(Color.LIGHT_GRAY);
        
        phrase1_2 = new JLabel("Problem #2:");
        phrase1_2.setSize(500, 15);
        phrase1_2.setLocation(5, 5);
        
        phrase2_2 = new JLabel("The calorimeter cup is made from               kg of                                    and contains                kg of");
        phrase2_2.setSize(900,15);
        phrase2_2.setLocation(5,20);
        
        input1_2 = new JTextField("");
        input1_2.setSize(40,15);
        input1_2.setLocation(200,21);
        
        Material_2 = new JComboBox(ListofMaterial2);
        Material_2.setSize(100, 20);
        Material_2.setLocation(275, 18);
        
        input2_2 = new JTextField("");
        input2_2.setSize(40,15);
        input2_2.setLocation(455,21);
        
        Material1_2 = new JComboBox(ListofMaterial2);
        Material1_2.setSize(100,20);
        Material1_2.setLocation(533, 18);
        
        phrase4_2 = new JLabel("Initially, the                   and the cup have a common temperature of                  °C. A                   kg mass of unknown");
        phrase4_2.setSize(900,15);
        phrase4_2.setLocation(5,40);
        
        input3_2$ = new JTextField((String)Material1_2.getSelectedItem());
        input3_2$.setSize(50,15);
        input3_2$.setLocation(70,41);
        input3_2$.setEditable(false);
        
        input4_2 = new JTextField("");
        input4_2.setSize(50,15);
        input4_2.setLocation(375,41);
        
        input5_2 = new JTextField("");
        input5_2.setSize(50,15);
        input5_2.setLocation(458,41);
        
        phrase5_2 = new JLabel("material is heated to a temperature of                   °C and then added to the                 . The temperature of the");
        phrase5_2.setSize(6900,15);
        phrase5_2.setLocation(5,60);
        
        input6_2 = new JTextField("");
        input6_2.setSize(50,15);
        input6_2.setLocation(223,61);
        
        input7_2$ = new JTextField((String)Material1_2.getSelectedItem());
        input7_2$.setSize(50,15);
        input7_2$.setLocation(416,61);
        input7_2$.setEditable(false);
        input7_2$.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        input8_2$ = new JTextField((String)Material1_2.getSelectedItem());
        input8_2$.setSize(50,15);
        input8_2$.setLocation(30,81);
        input8_2$.setEditable(false);
        
        phrase6_2 = new JLabel("                          , the cup, and the unknown material is                   °C after thermal equilibrium is reestablished. Ig-");
        phrase6_2.setSize(900,15);
        phrase6_2.setLocation(5,80);
        
        input9_2 = new JTextField("");
        input9_2.setSize(50,15);
        input9_2.setLocation(300,81);
        
        phrase7_2 = new JLabel("noring the small amount of heat gained by the thermometer, find the specific heat capacity of the unknown");
        phrase7_2.setSize(900,15);
        phrase7_2.setLocation(5,100);
        
        phrase10_2 = new JLabel("material.");
        phrase10_2.setSize(50,15);
        phrase10_2.setLocation(5,120);
        
        Solve2 = new JButton("Calculate");
        Solve2.setSize(95,25);
        Solve2.setLocation(450,170);
        
        Exit = new JButton("Exit");
        Exit.setSize(70,25);
        Exit.setLocation(550,170);
        Exit.addActionListener(exitbutton);
        
        change2= new ChangeLabel1(input7_2$,input3_2$,input8_2$,Material1_2);
        Material1_2.addActionListener(change2);
        
        problem2.add(input7_2$);problem2.add(input8_2$); problem2.add(phrase6_2); problem2.add(input9_2);
        problem2.add(phrase1_2);problem2.add(Material1_2); problem2.add(input5_2); problem2.add(phrase7_2);
        problem2.add(phrase2_2);problem2.add(phrase4_2);problem2.add(input4_2); problem2.add(phrase10_2);
        problem2.add(input1_2);problem2.add(input3_2$);problem2.add(phrase5_2); problem2.add(Solve2);
        problem2.add(Material_2);problem2.add(input2_2);problem2.add(input6_2); problem2.add(Exit);
    }
    private void Problem3(){
        problem3 = new JPanel();
        problem3.setSize(640,210);
        problem3.setLocation(13, 30);
        problem3.setLayout(null);
        problem3.setBackground(Color.LIGHT_GRAY);
        
        phrase1_3 = new JLabel("Problem #3:");
        phrase1_3.setSize(500, 15);
        phrase1_3.setLocation(5, 5);
       
        phrase2_3 = new JLabel("A                  kg                                   bowl [c =             J/(kg*°C)] contains                 kg of punch at                   °C.");
        phrase2_3.setSize(900,15);
        phrase2_3.setLocation(5, 20);
        
        input_1 = new JTextField("");
        input_1.setSize(50,15);
        input_1.setLocation(16,20);
        
        Material_1 = new JComboBox(ListofMaterial3);
        Material_1.setSize(100,20);
        Material_1.setLocation(85,18);
        
        try{
            logic = filereader.Read((String)Material_1.getSelectedItem());
        }
        catch(IOException e){
            
        }
        
        output_$ = new JTextField(filereader.getSpecificHeat());
        output_$.setSize(35,15);
        output_$.setLocation(240, 21 );
        output_$.setEditable(false);
        
        change3 = new ChangeLabel2(output_$,Material_1);
        Material_1.addActionListener(change3);
        
        input_2 = new JTextField("");
        input_2.setSize(40,15);
        input_2.setLocation(390,20);
        
        input_3 = new JTextField("");
        input_3.setSize(40,15);
        input_3.setLocation(515,20);
        
        input_4 = new JTextField("");
        input_4.setSize(40,15);
        input_4.setLocation(580,20);
        
        phrase3_3 = new JLabel("kilograms of                                   [c =                  J/(kg*°C)] are added to the punch. The                   has an initial temp-");
        phrase3_3.setSize(900,15);
        phrase3_3.setLocation(5, 40);
        
        Material_2 = new JComboBox(ListofMaterial);
        Material_2.setSize(100,20);
        Material_2.setLocation(80,38);

        try{
            logic2 = filereader2.Read((String)Material_2.getSelectedItem());
        }
        catch(IOException e){
            
        }
        
        output_2 = new JTextField((String)Material_2.getSelectedItem());
        output_2.setSize(50,15);
        output_2.setLocation(475, 40);
        output_2.setEditable(false);
        
        
        input_$ = new JTextField(filereader2.getSpecificHeat());
        input_$.setSize(50,15);
        input_$.setLocation(205,40);
        input_$.setEditable(false);
        
        change4 = new ChangeLabel2(input_$,output_2,Material_2);
        Material_2.addActionListener(change4);
        
        phrase4_3 = new JLabel("perature of                   °C, having been kept in a very cold freezer. The punch may be treated as if it were water");
        phrase4_3.setSize(900,15);
        phrase4_3.setLocation(5,60);
        
        input_5 = new JTextField("");
        input_5.setSize(50,15);
        input_5.setLocation(73,60);
        
        phrase5_3 = new JLabel("[c = 4186 J/(kg*°C)], and it may be assumed that there is no heat flow between the punch bowl and the external");
        phrase5_3.setSize(900,15);
        phrase5_3.setLocation(5,80);
        
        phrase6_3 = new JLabel("environment. The latent heat of fusion for water is 335000 J/kg. When thermal equilibrium is reached, all the ice");     
        phrase6_3.setSize(900,15);
        phrase6_3.setLocation(5,100);
        
        phrase7_3 = new JLabel("has melted. Determine this temperature");
        phrase7_3.setSize(900,15);
        phrase7_3.setLocation(5,120);
        
        Solve3 = new JButton("Calculate");
        Solve3.setSize(95,25);
        Solve3.setLocation(450,170);        
        
        Exit3 = new JButton("Exit");
        Exit3.setSize(70,25);
        Exit3.setLocation(550,170);
        Exit3.addActionListener(exitbutton);
        
        
        
        problem3.add(input_5); problem3.add(phrase5_3); problem3.add(phrase6_3); problem3.add(phrase7_3); problem3.add(Solve3);
        problem3.add(Material_2); problem3.add(output_2); problem3.add(input_$); problem3.add(phrase4_3); problem3.add(output_$);
        problem3.add(Exit3); problem3.add(phrase2_3); problem3.add(Material_1); problem3.add(input_2);
        problem3.add(phrase1_3);problem3.add(input_1); problem3.add(input_3); problem3.add(input_4); problem3.add(phrase3_3);
    }
    public void setProblem(JPanel prob){
        CurrentProb.setVisible(false);
        prob.setVisible(true);
        CurrentProb = prob;
        SolutionPad.setText("");
    }
    private class ChangeProblem implements ActionListener{
    JPanel prob1,prob2,prob3;

    public ChangeProblem(JPanel problem_1, JPanel problem_2,JPanel problem_3){
        prob1 = problem_1;
        prob2 = problem_2;
        prob3 = problem_3;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox current = (JComboBox) e.getSource();
        switch((String)current.getSelectedItem()){
            case ("Problem1"):{
                              CaloObject.setProblem(prob1);
                              break;
                              }
            case ("Problem2"):{
                              CaloObject.setProblem(prob2);
                              break;
                              }
            case ("Problem3"):{
                              CaloObject.setProblem(prob3);
                              break;
                              }        
        }
    }
    
    }
}
