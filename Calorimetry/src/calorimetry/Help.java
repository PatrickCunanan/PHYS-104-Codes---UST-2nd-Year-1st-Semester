package calorimetry;

import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author harji
 */
public class Help {
    boolean logic,logic2,logic3,logic4,logic5,logic6,logic7,logic8,logic9;
    FileReaderCalorimetry read,read2,read3,read4,read5,read6,read7,read8,read9;
    SearchAction helpaction;
    BackAction backaction;
    JFrame helpframe = new JFrame("Help");
    Container Pane = helpframe.getContentPane();
    JButton specificchart, search, latentchart, searchbutton, back, back2, back3;
    JTextField input;
    JPanel searchpanel,specificpanel,latentpanel;
    JTextArea field,material,boiling,melting,specific,material2,latent;
    JScrollPane scrollpane;
    JTextArea materialL,boilingL,meltingL,specificL,materialL2,LatentL;
    
    public Help (){
       helpframe.setSize(400, 530);
       helpframe.setLayout(null);
       helpframe.setResizable(false);
       JPanel mainpanel = new JPanel();
       mainpanel.setSize(400,530);
       mainpanel.setBackground(Color.DARK_GRAY);
       mainpanel.setLayout(null);
       
       search = new JButton("DEFINITION OF TERMS");
       search.setSize(300,70);
       search.setLocation(50,20);
       search.setBackground(Color.CYAN);
       search.setBorderPainted(false);
       
       specificchart = new JButton("CHECK SPECIFIC HEAT CHART");
       specificchart.setSize(300,70);
       specificchart.setLocation(50,100);
       specificchart.setBackground(Color.CYAN);
       specificchart.setBorderPainted(false);
       
       latentchart = new JButton("CHECK LATENT HEAT CHART");
       latentchart.setSize(300,70);
       latentchart.setLocation(50,180);
       latentchart.setBackground(Color.CYAN);
       latentchart.setBorderPainted(false);
       
       SearchPanel();
       SpecificPanel();
       LatentPanel();
       
       mainpanel.add(search);
       mainpanel.add(specificchart);
       mainpanel.add(latentchart);
       Pane.add(mainpanel);
       Pane.add(searchpanel);
       Pane.add(specificpanel);
       Pane.add(latentpanel);
       
       helpaction = new SearchAction(mainpanel,searchpanel,specificpanel,latentpanel,search,specificchart,latentchart);
       search.addActionListener(helpaction);
       specificchart.addActionListener(helpaction);
       latentchart.addActionListener(helpaction);
       
       backaction = new BackAction(back,back2,back3,mainpanel,searchpanel,specificpanel,latentpanel);
       back.addActionListener(backaction);
       back2.addActionListener(backaction);
       back3.addActionListener(backaction);
       
       mainpanel.setVisible(true);
       searchpanel.setVisible(false);
       specificpanel.setVisible(false);
       latentpanel.setVisible(false);
    }
    private void SearchPanel(){
        searchpanel = new JPanel();
        searchpanel.setSize(400, 530);
        searchpanel.setBackground(Color.darkGray);
        searchpanel.setLocation(0, 0);
        searchpanel.setLayout(null);
        
        input = new JTextField("");
        input.setSize(270,25);
        input.setLocation(8, 10);
        input.setBorder(BorderFactory.createLineBorder(Color.white));
        input.setBackground(Color.white);
        
        searchbutton = new JButton("Search");
        searchbutton.setSize(100, 25);
        searchbutton.setLocation(280, 10);
        searchbutton.setBackground(Color.cyan);
        searchbutton.setBorderPainted(false);
        
        field = new JTextArea();
        scrollpane = new JScrollPane(field);
        scrollpane.setSize(372,400);
        scrollpane.setLocation(8,40);
        scrollpane.setBorder(BorderFactory.createLineBorder(Color.white));
        scrollpane.setBackground(Color.white);
        field.setEditable(false);
        
        back = new JButton("Back");
        back.setSize(100,25);
        back.setLocation(280,460);
        back.setBackground(Color.cyan);
        back.setBorderPainted(false);
        
        SearchActionButton searchactionbutton = new SearchActionButton(input,field);
        searchbutton.addActionListener(searchactionbutton);
        
        searchpanel.add(input);
        searchpanel.add(searchbutton);
        searchpanel.add(scrollpane);
        searchpanel.add(back);
    }
    private void SpecificPanel(){
        read = new FileReaderCalorimetry();
        read2 = new FileReaderCalorimetry();
        read3= new FileReaderCalorimetry();
        read4 = new FileReaderCalorimetry();
        read5 = new FileReaderCalorimetry();
        read6 = new FileReaderCalorimetry();
        read7 = new FileReaderCalorimetry();
        read8 = new FileReaderCalorimetry();
        read9 = new FileReaderCalorimetry();
        
        try{
            logic = read.Read("water");
            logic2 = read2.Read("ice");
            logic3 = read3.Read("steam");
            logic4 = read4.Read("aluminum");
            logic5 = read5.Read("copper");
            logic6 = read6.Read("lead");
            logic7 = read7.Read("silver");
            logic8 = read8.Read("ethyl_alcohol");
            logic9 = read9.Read("mercury");
        }
        catch(IOException e){
            
        }
        
        
        specificpanel = new JPanel();
        specificpanel.setSize(400, 530);
        specificpanel.setBackground(Color.darkGray);
        specificpanel.setLocation(0, 0);
        specificpanel.setLayout(null);
        
        material = new JTextArea();
        material.setSize(80,400);
        material.setLocation(8,50);
        material.setBorder(BorderFactory.createLineBorder(Color.white));
        material.setBackground(Color.white);
        material.setEditable(false);
        
        boiling = new JTextArea();
        boiling.setSize(80,400);
        boiling.setLocation(105,50);
        boiling.setBorder(BorderFactory.createLineBorder(Color.white));
        boiling.setBackground(Color.white);
        boiling.setEditable(false);
        
        specific = new JTextArea();
        specific.setSize(80,400);
        specific.setLocation(202,50);
        specific.setBorder(BorderFactory.createLineBorder(Color.white));
        specific.setBackground(Color.white);
        specific.setEditable(false);
        
        melting = new JTextArea();
        melting.setSize(80,400);
        melting.setLocation(299,50);
        melting.setBorder(BorderFactory.createLineBorder(Color.white));
        melting.setBackground(Color.white);
        melting.setEditable(false);
        
        materialL = new JTextArea("Material");
        materialL.setSize(80,37);
        materialL.setLocation(8, 10);
        materialL.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        materialL.setBackground(Color.lightGray);
        materialL.setEditable(false);
        
        boilingL = new JTextArea("Boiling Point"+"\n"+"°C");
        boilingL.setSize(80,37);
        boilingL.setLocation(105, 10);
        boilingL.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        boilingL.setBackground(Color.lightGray);
        boilingL.setEditable(false);
        
        specificL = new JTextArea("Specific Heat"+"\n"+"J/(kg*°C)");
        specificL.setSize(80,37);
        specificL.setLocation(202, 10);
        specificL.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        specificL.setBackground(Color.lightGray);
        specificL.setEditable(false);
        
        meltingL = new JTextArea("Melting Point"+"\n"+"°C");
        meltingL.setSize(80,37);
        meltingL.setLocation(299, 10);
        meltingL.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        meltingL.setBackground(Color.lightGray);
        meltingL.setEditable(false);
        
        back2 = new JButton("Back");
        back2.setSize(100,25);
        back2.setLocation(280,460);
        back2.setBackground(Color.cyan);
        back2.setBorderPainted(false);
        
        material.setText(read.getMaterial()+"\n"+read2.getMaterial()+"\n"+read3.getMaterial()+"\n"+read4.getMaterial()+"\n"+read5.getMaterial()+"\n"+
                         read6.getMaterial()+"\n"+read7.getMaterial()+"\n"+read8.getMaterial()+"\n"+read9.getMaterial()+"\n");
        boiling.setText(read.getBoiling()+"\n"+read2.getBoiling()+"\n"+read3.getBoiling()+"\n"+read4.getBoiling()+"\n"+read5.getBoiling()+"\n"+
                         read6.getBoiling()+"\n"+read7.getBoiling()+"\n"+read8.getBoiling()+"\n"+read9.getBoiling()+"\n");
        specific.setText(read.getSpecificHeat()+"\n"+read2.getSpecificHeat()+"\n"+read3.getSpecificHeat()+"\n"+read4.getSpecificHeat()+"\n"+read5.getSpecificHeat()+"\n"+
                         read6.getSpecificHeat()+"\n"+read7.getSpecificHeat()+"\n"+read8.getSpecificHeat()+"\n"+read9.getSpecificHeat()+"\n");
        melting.setText(read.getMelting()+"\n"+read2.getMelting()+"\n"+read3.getMelting()+"\n"+read4.getMelting()+"\n"+read5.getMelting()+"\n"+
                         read6.getMelting()+"\n"+read7.getMelting()+"\n"+read8.getMelting()+"\n"+read9.getMelting()+"\n");
        
        
        specificpanel.add(material);
        specificpanel.add(boiling);
        specificpanel.add(specific);
        specificpanel.add(melting);
        specificpanel.add(materialL);
        specificpanel.add(boilingL);
        specificpanel.add(specificL);
        specificpanel.add(meltingL);
        specificpanel.add(back2);
    }
    private void LatentPanel(){
        latentpanel = new JPanel();
        latentpanel.setSize(400, 530);
        latentpanel.setBackground(Color.darkGray);
        latentpanel.setLocation(0, 0);
        latentpanel.setLayout(null);
        
        materialL2 = new JTextArea("Material");
        materialL2.setSize(100,37);
        materialL2.setLocation(60, 10);
        materialL2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        materialL2.setBackground(Color.lightGray);
        materialL2.setEditable(false);
        
        LatentL = new JTextArea("Latent heat of "+"\n"+"fusion"+"   ("+"J/kg)");
        LatentL.setSize(100,37);
        LatentL.setLocation(220, 10);
        LatentL.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        LatentL.setBackground(Color.lightGray);
        LatentL.setEditable(false);        
        
        material2 = new JTextArea();
        material2.setSize(100,400);
        material2.setLocation(60,50);
        material2.setBorder(BorderFactory.createLineBorder(Color.white));
        material2.setBackground(Color.white);
        material2.setEditable(false);
        
        latent = new JTextArea();
        latent.setSize(100,400);
        latent.setLocation(220,50);
        latent.setBorder(BorderFactory.createLineBorder(Color.white));
        latent.setBackground(Color.white);
        latent.setEditable(false);
        
        back3 = new JButton("Back");
        back3.setSize(100,25);
        back3.setLocation(280,460);
        back3.setBackground(Color.cyan);
        back3.setBorderPainted(false);
        
        
        material2.setText(read.getMaterial()+"\n"+read4.getMaterial()+"\n"+read5.getMaterial()+"\n"+
                         read6.getMaterial()+"\n"+read7.getMaterial()+"\n"+read8.getMaterial()+"\n"+read9.getMaterial()+"\n");
        latent.setText(read.getLatentHeatF()+"\n"+read4.getLatentHeatF()+"\n"+read5.getLatentHeatF()+"\n"+
                         read6.getLatentHeatF()+"\n"+read7.getLatentHeatF()+"\n"+read8.getLatentHeatF()+"\n"+read9.getLatentHeatF()+"\n");
        
        latentpanel.add(material2);
        latentpanel.add(latent);
        latentpanel.add(materialL2);
        latentpanel.add(LatentL);
        latentpanel.add(back3);
    }
    public void setVisible(boolean condition){
        helpframe.setVisible(condition);
    }
    public void setHelpLocation(int x , int y){
      helpframe.setLocation(x + 675, y );
    }
}
