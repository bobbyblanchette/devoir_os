import java.awt.*;
import javax.swing.*;

public class DessinBaigneurs {

	public static void main(String[] args){
		JFrame fenetre = new JFrame("La piscine");
		fenetre.setLayout(new GridBagLayout());
		fenetre.setBounds(100,100,800,400);
		fenetre.setVisible(true);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		//First row:
		c.gridy = 0;
		JPanel panelBaigneurs = new JPanel();
		panelBaigneurs.add(new JLabel("BAIGNEURS"));
		panelBaigneurs.setBackground(Color.gray);
		fenetre.add(panelBaigneurs, c);
		for (char a = 'A'; a < 'A' + 8; a++){
			c.gridx = a - 'A' + 1;
			JPanel panel = new JPanel();
			panel.add(new JLabel("" + a));
			fenetre.add(panel, c);
		}
		
		//First column:
		c.gridx = 0;
		for (char a = 'A'; a < 'A' + 6; a++){
			c.gridy = a - 'A' + 1;
			JPanel panel = new JPanel();
			panel.add(new JLabel("" + a));
			fenetre.add(panel, c);
		}
		
		for (int i = 1; i < 9; i++){
			c.gridx = i;
			for (int j = 1; j < 7; j++){
				c.gridy = j;
				JPanel panel = new JPanel();
				panel.add(new JLabel("*"));
				panel.setBackground(Color.darkGray);
				fenetre.add(panel, c);
			}
		}
		
	}
}
