import javax.swing.JOptionPane;

public class UsefulMethods {

	static String yay = "yay";
	static char regex [] = {'a', 'e', 'i', 'o', 'u'};
	
	public static void main(String [] args) 
	{
		String input = "";
		String newWord = "";
		
		input = JOptionPane.showInputDialog(null, "Please enter a word for me to transform:");
		
		newWord = pigifylt(input);

		System.exit(0);
	}
	
	//Pig latin method.
	public static String pigifylt(String word) 
	{
		//Fields.
		String newWord = word;
		int catcher = 0;
		
			//Catch first character.
			for(int index2 = 0; index2 < 4; index2++) 
			{
				//Catch and release.
				if(catcher == 0) {
					//Catch and add word to end.
					if (newWord.charAt(0) == regex[index2]) 
					{
						newWord = newWord + yay;
						JOptionPane.showMessageDialog(null, newWord);
						catcher++;
					}//Regex if.	
				}//Outer for.
			}//Inner for.

			//Count each character.
			for(int index = 0, n = newWord.length(); index < n; index++)
			{
		}//Outer for.
		
		return newWord;
	}//Detect Vowel.
}//Main.
