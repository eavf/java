/**
 * 
 */
package eu.eavf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ecran8 extends JFrame
					
{
	JPanel pano;
	JCheckBox chkGras,chkItalique;
	JLabel lblTaille,lblExemple;
	JComboBox cboTaille;
	JList lstPolices;
	JScrollPane defilPolices;
	
	public Ecran8()
	{
		setTitle("choix d\'une police");
		setBounds(0,0,300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// creation des composants
		
		pano=new JPanel();
		chkGras=new JCheckBox("gras");
		chkItalique=new JCheckBox("italique");
		lblTaille=new JLabel("taille");
		lblExemple=new JLabel("essai de police de caracte-res");
		cboTaille=new JComboBox(new String[]{"10","12","14","16","18","20"});
		lstPolices=new JList(new String[]{"arial","courier","letter","helvetica","times ro-man","symbole","antique"});
		defilPolices=new JScrollPane(lstPolices);
		
		GridBagLayout gbl;
		gbl=new GridBagLayout();
		pano.setLayout(gbl);
		
		GridBagConstraints gbc;
		gbc=new GridBagConstraints();
		// position dans la case 0,0
		gbc.gridx=0;
		gbc.gridy=0;
		// sur une colonne de largeur
		gbc.gridwidth=1;
		// et sur trois lignes en hauteur
		gbc.gridheight=3;
		// ponderation en cas d'agrandisemment du conteneur
		gbc.weightx=100;
		gbc.weighty=100;
		// le composant est redimensionne pour occuper
		// tout l'espace disponible dans son conteneur
		gbc.fill=GridBagConstraints.BOTH;
		pano.add(defilPolices,gbc);
		// position dans la case 1,0
		gbc.gridx=1;
		gbc.gridy=0;
		// sur deux colonnes de largeur
		gbc.gridwidth=2;
		// et sur une ligne en hauteur
		gbc.gridheight=1;
		// ponderation en cas d'agrandisemment du conteneur
		gbc.weightx=100;
		gbc.weighty=100;
		// le composant n'est pas redimensionne pour occuper
		// tout l'espace disponible dans son conteneur
		gbc.fill=GridBagConstraints.NONE;
		pano.add(chkGras,gbc);
		// position dans la case 1,1
		gbc.gridx=1;
		gbc.gridy=1;
		// sur deux colonnes de largeur
		gbc.gridwidth=2;
		// et sur une ligne en hauteur
		gbc.gridheight=1;
		// ponderation en cas d'agrandisemment du conteneur
		gbc.weightx=100;
		gbc.weighty=100;
		pano.add(chkItalique,gbc);
		// position dans la case 1,2
		gbc.gridx=1;
		gbc.gridy=2;
		// sur une colonne de largeur
		gbc.gridwidth=1;
		// et sur une ligne en hauteur
		gbc.gridheight=1;
		// ponderation en cas d'agrandisemment du conteneur
		gbc.weightx=100;
		gbc.weighty=100;
		pano.add(lblTaille,gbc);
		// position dans la case 2,2
		gbc.gridx=2;
		gbc.gridy=2;
		// sur une colonne de largeur
		gbc.gridwidth=1;
		// et sur une ligne en hauteur
		gbc.gridheight=1;
		// ponderation en cas d'agrandisemment du conteneur
		gbc.weightx=100;
		gbc.weighty=100;
		pano.add(cboTaille,gbc);
		// position dans la case 0,3
		gbc.gridx=0;
		gbc.gridy=3;
		// sur trois colonnes de largeur
		gbc.gridwidth=3;
		// et sur une ligne en hauteur
		gbc.gridheight=1;
		// ponderation en cas d'agrandisemment du conteneur
		gbc.weightx=100;
		gbc.weighty=100;
		pano.add(lblExemple,gbc);
		getContentPane().add(pano);
	}
}
