import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FMRadio extends JFrame{

	//Object variables.
	private JButton back = new JButton("Back");
	private JButton forward = new JButton("Next");
	private JButton station1 = new JButton("WHTZ-FM");
	private JButton station2 = new JButton("KIIS-FM");
	private JButton station3 = new JButton("WKQI-FM");
	private JButton station4 = new JButton("WWPW-FM");
	private JButton station5 = new JButton("KMVQ-FM");
	private JButton station6 = new JButton("WWWQ-FM");
	private JButton station7 = new JButton("WIOQ-FM");
	private JPanel panel1 = new JPanel(new GridBagLayout());
	private JPanel panel2 = new JPanel(new GridBagLayout());
	private JPanel panel3 = new JPanel();
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	
	//Primitive Fields
	int CurrentStation = 0;
	String[] SStationArray = {"WHTZ-FM", "KIIS-FM", "WKQI-FM", "WWPW-FM", "KMVQ-FM", "WWWQ-FM", "WIOQ-FM"};
	private double Frequency[] = {88.6, 98.9, 102.9, 104.5, 106.9, 107.3, 108.5};
	
	//Triple Tunes Radio constructor.
	public FMRadio() {
		
		//Set frame to center of screen.
		setLocationRelativeTo(null);
		
		//Define panel positions.
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);

		//Build the panel.
		buildPanel();
		
		//Define frame size, visibility and default close parameters.
		setTitle("Triple Tunes Radio");
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//FMRadio constructor.
	
	
	//Construct Panel.
	public void buildPanel() {
		
		//Store Song information into strings.
		String stations = "Current Station: " + SStationArray[CurrentStation];
		String thisStation = "Current Frequency: " + Frequency[CurrentStation];
		
		//Store station of strings into labels.
		label1.setText(stations);
		label2.setText(thisStation);
		
		//Create panel constraints.
		GridBagConstraints cons = new GridBagConstraints();
		
		//Define margins.
		cons.insets = new Insets(6,0,0,0);
		
		//Define grid position and store in panel 1.
		cons.gridx = 0;
		cons.gridy = 1;
		panel1.add(station1, cons);
		cons.gridx = 1;
		cons.gridy = 1;
		panel1.add(station2, cons);
		cons.gridx = 2;
		cons.gridy = 1;
		panel1.add(station3, cons);
		cons.gridx = 3;
		cons.gridy = 1;
		panel1.add(station4, cons);
		cons.gridx = 0;
		cons.gridy = 2;
		panel1.add(station5, cons);
		cons.gridx = 1;
		cons.gridy = 2;
		panel1.add(station6, cons);
		cons.gridx = 2;
		cons.gridy = 2;
		panel1.add(station7, cons);
		cons.gridx = 3;
		cons.gridy = 2;
		
		//Define margins.
		cons.insets = new Insets(6,0,0,0);
		
		//Define grid position and store in panel 2.
		cons.gridx = 0;
		cons.gridy = 0;
		panel2.add(label1, cons);
		cons.gridx = 0;
		cons.gridy = 1;
		panel2.add(label2, cons);

		//Store next and previous button in panel 3.	
		panel3.add(back);
		panel3.add(forward);
		
		
		//Create event handling objects.
		back.addActionListener(new Switch(0, CurrentStation));
		forward.addActionListener(new Switch(1, CurrentStation));
		station1.addActionListener(new SetStation1(0));
		station2.addActionListener(new SetStation1(1));
		station3.addActionListener(new SetStation1(2));
		station4.addActionListener(new SetStation1(3));
		station5.addActionListener(new SetStation1(4));
		station6.addActionListener(new SetStation1(5));
		station7.addActionListener(new SetStation1(6));

	}
	
	public void SetCurrStation(int Switching)
	{
		CurrentStation = Switching;
	}
	
	public int GetCurrStation()
	{
		return CurrentStation;
	}
	
	public class Switch implements ActionListener 
	{
		
		int StationSwitcher = 0;
		int LeftRight = 2;
		public Switch(int a, int CurrentStation) 
		{			
			LeftRight = a;
			StationSwitcher = CurrentStation;		
		}//Switch constructor.
		
		public int GetSwitch()
		{
			return StationSwitcher;
		}//Get Switch.
		
		public void actionPerformed(ActionEvent e) 
		{		
			//Set Left or right.
			int LeftOrRight = GetCurrStation();
			
			if (StationSwitcher == 0 && LeftOrRight == 0) 
			{
				SetCurrStation(6);
			}//If.
			/*
			 * 
			 * Forward button needs re-logic.
			 * 
			 * 
			 */
			if (LeftRight == 1) 
			{
				SetCurrStation(GetCurrStation() + 1);
				if (GetCurrStation() == 7)
				{
					SetCurrStation(0);
				}
			}//Else if.
			else 
			{
				SetCurrStation(GetCurrStation() - 1);
			}//Else.
			
			//Store Song information into strings.
			String stations = "Current Station: " + SStationArray[GetCurrStation()];
			String thisStation = "Current Frequency: " + Frequency[GetCurrStation()];
			
			//Store song strings into labels.
			label1.setText(stations);
			label2.setText(thisStation);
			
		}//Actions Performed.
	}//Switch Listener.

	//Change Station and Frequency Name.
	public class SetStation1 implements ActionListener{
		
		//Local Variable.
		int a = 0;
		
		//Set number by button pressed.
		public SetStation1(int i) {		
			a = i;			
		}//Set Station.
		
		//Return the number of the button.
		public int GetStation() 
		{
			return a;
		}//Get Station.
		
		//Display the station and frequency
		public void actionPerformed(ActionEvent e) {
			
			//Store Song information into strings.
			String stations = "Current Station: " + SStationArray[GetStation()];
			String thisStation = "Current Frequency: " + Frequency[a];
			
			//Store song strings into labels.
			label1.setText(stations);
			label2.setText(thisStation);
		}//Actions Performed.
	}//Station 1 Listener.


	public static void main(String [] args) 
	{
		new FMRadio();
	}//Main.	
}//Class.
