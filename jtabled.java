import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Table1
{
public static void main(String... ar)
{
SwingUtilities.invokeLater(new Runnable() {
public void run()
{
new A();
}
});

}//Closing the main method
}//Closing the class Combo


class A //implements ActionListener
{
String [] index;
JFrame jf;
JTable table1, table2; 
JLabel label1, label2;

A()
{
index= new String[]{"Rank", "Country", "GDP(millions of US$)"};


 
jf= new JFrame("JTable");
label1 = new JLabel("Top 10 economies in the world");


Object[][] rawData = new Object[] [] {
		{"1", "USA", "$19.42 Trillion"},
		{"2", "China","$11.8 Trillion"},
		{"3", "Japan", "$4.84 Trillion"},
		{"4", "Germany", "$3.42 Trillion"},
		{"5", "United Kingdom", "$2.91 Trillion"},
		{"6", "India", "$2.45 Trillion"},
		{"7", "France", "$2.42 Trillion"},
		{"8", "Brazil", "$2.14 Trillion"},
		{"9", "Italy", "$1.81 Trillion"},
		{"10", "Canada", "$1.6 Trillion"}
		};
	
table1 = new JTable(rawData, index);

JScrollPane scrollP = new JScrollPane(table1);

DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
tableRenderer.setHorizontalAlignment(JLabel.CENTER); //Aligning the table data centrally.
table1.setDefaultRenderer(Object.class, tableRenderer);


scrollP.setBorder(BorderFactory.createEmptyBorder()); //How to remove the border of JScrollPane.
scrollP.setPreferredSize(new Dimension(400, 180));		//Setting the size of JScrollPane

//Setting the label2 with message to show total number of rows and columns in JTable.
label2 = new JLabel("Rows : " + table1.getRowCount() + ", Columns : "+ table1.getColumnCount() );

jf.add(label1);
jf.add(scrollP);
jf.add(label2);

jf.setLayout(new FlowLayout());
jf.setSize(500,280);
jf.setVisible(true);
}

}
}