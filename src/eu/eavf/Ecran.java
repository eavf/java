/**
 * 
 */
package eu.eavf;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author vovo
 *
 */
public class Ecran extends JFrame {

	private static final long serialVersionUID = 1L;

	//Deklarácie
	JPanel pano;
	JButton btnRouge, btnVert, btnBleu;
	JMenuItem mnuRouge, mnuVert, mnuBleu;
	ConsoleLog lg;
	
	public Ecran ()
	{
		//Definícia vlastností okna

		setBounds(0, 0, 300, 400);
		setTitle("Prve okno v java");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//Inicializovanie tlačítok
		btnRouge = new JButton ("Rouge");
		//Nastavenie action command - toto buzde k dispozícii aj mimo konštruktora
		btnRouge.setActionCommand("Red");
		btnVert = new JButton("Vert");
		btnVert.setActionCommand("Green");
		btnBleu = new JButton("Bleu");
		btnBleu.setActionCommand("Blue");
		
		//Pridanie naslúchača
		EcouteurCouleur ec;
		
		ec = new EcouteurCouleur();
		
		//Priradenie k tlačítkam
		btnRouge.addActionListener(ec);
		btnVert.addActionListener(ec);
		btnBleu.addActionListener(ec);
		
		//Doplnenie zaškrt polička
		JCheckBox chkLog;
		chkLog = new JCheckBox("Log sur console....");
		//Pridanie naslúchača
		chkLog.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent arg0)
			{
				JCheckBox chk;
				chk = (JCheckBox)arg0.getSource();
				if (chk.isSelected())
				{
					//doplnime doplnujuci nasluchač 
					//na tlačitka a menu
					lg = new ConsoleLog();
					btnBleu.addActionListener(lg);
					btnRouge.addActionListener(lg);
					btnVert.addActionListener(lg);
					mnuRouge.addActionListener(lg);
					mnuVert.addActionListener(lg);
					mnuBleu.addActionListener(lg);
				}
				else
				{
					btnBleu.removeActionListener(lg);
					btnRouge.removeActionListener(lg);
					btnVert.removeActionListener(lg);
					mnuRouge.removeActionListener(lg);
					mnuVert.removeActionListener(lg);
					mnuBleu.removeActionListener(lg);
				}
			}
		}
				);	//Koniec deklarácie noveho actionlistenera

		JMenuBar barreMenu;
		barreMenu = new JMenuBar();
		
		JMenu mnuCouleurs;
		mnuCouleurs = new JMenu("Couleurs");
		barreMenu.add(mnuCouleurs);

		mnuRouge = new JMenuItem("Rouge");
		mnuRouge.setActionCommand("Red");
		mnuVert = new JMenuItem("Vert");
		mnuVert.setActionCommand("Green");
		mnuBleu = new JMenuItem("Bleu");
		mnuBleu.setActionCommand("Blue");
		
		mnuCouleurs.add(mnuRouge);
		mnuCouleurs.add(mnuVert);
		mnuCouleurs.add(mnuBleu);
		
		mnuRouge.addActionListener(ec);
		mnuVert.addActionListener(ec);
		mnuBleu.addActionListener(ec);
		
		setJMenuBar (barreMenu);
		
		pano = new JPanel();
		pano.add(btnRouge);
		pano.add(btnVert);
		pano.add(btnBleu);
		pano.add(chkLog);
		
		getContentPane().add(pano);
		
		//Vytvorenie objektu anonymnej triedy na manažmenmt udalostí v okne 
		
		addWindowListener (new WindowAdapter()
		{
			public void windowClosing (WindowEvent arg0)
			{
				System.exit(0);
			}
		}
		);
	}
	
	public class EcouteurCouleur implements ActionListener
	{
		public void actionPerformed (ActionEvent arg0)
		{
			String command;
			command = arg0.getActionCommand();
			
			if (command.equals("Red"))
			{
				pano.setBackground(Color.RED);
			}
			if (command.equals("Green"))
			{
				pano.setBackground(Color.GREEN);
			}
			if (command.equals("Blue"))
			{
				pano.setBackground(Color.BLUE);
			}
		}
	}
}
