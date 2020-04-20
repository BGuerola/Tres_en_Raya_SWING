import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class Principal {
	
	public JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	boolean ganador=false;  //determinará si se puede continuar marcando los botones
	boolean modohvm=true; //modo de juego humano contra máquina en true, humano contra humano en false
	String play="X"; // para rellenar el boton con X o con O. Empieza con X.
	int turno =1; //Para modo humano contra humano, turnos de juego
		
	public JLabel label1, label2, label3;
	public JPanel panel1, panel2;

	//listener para los botones
	public class ActionListenerTest implements ActionListener {

	    public void actionPerformed(ActionEvent e) {
	    	if (modohvm==false){
	    		if (turno==1) {//se entra en turnos si se juega mhumano contra humano
	    			play="X";
	    			turno=2;
	    		} else {
	    			play="O";
	    			turno=1;
	    		}
	    	} else {play="X";}
	    	if (ganador==false) {//solo mueve si no hay ganador
		    	Object source = e.getSource();//pinta si está en blanco, si se intenta pintar uno pintado se mantiene turno
		        if (source==b1) {if (b1.getText()=="") {b1.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        if (source==b2) {if (b2.getText()=="") {b2.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        if (source==b3) {if (b3.getText()=="") {b3.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        if (source==b4) {if (b4.getText()=="") {b4.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        if (source==b5) {if (b5.getText()=="") {b5.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        if (source==b6) {if (b6.getText()=="") {b6.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        if (source==b7) {if (b7.getText()=="") {b7.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        if (source==b8) {if (b8.getText()=="") {b8.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        if (source==b9) {if (b9.getText()=="") {b9.setText(play);}else{if (turno==1) {turno=2;}else{turno=1;}}}
		        ganador=compruebaganador(ganador, play);        
		        }
	    	if (modohvm==true) {
		        if (ganador == false) {
		        	play="O";
		        	movmaq();
		        	ganador=compruebaganador(ganador, play);
		        }
	    	}
		    }
		        
	    	} 
	
	public void movmaq() {//mueve automaticamente
		int numero = (int) (Math.random() * 9)+1; //genera número al azar del 1 al 9
		switch(numero) {//si un boton no está en blanco salta al siguiente
		case 1: if (b1.getText()=="") {b1.setText("O");break;} else {numero = 2;};
		case 2:	if (b2.getText()=="") {b2.setText("O");break;} else {numero = 3;};
		case 3: if (b3.getText()=="") {b3.setText("O");break;} else {numero = 4;};
		case 4: if (b4.getText()=="") {b4.setText("O");break;} else {numero = 5;};
		case 5: if (b5.getText()=="") {b5.setText("O");break;} else {numero = 6;};
		case 6: if (b6.getText()=="") {b6.setText("O");break;} else {numero = 7;};
		case 7: if (b7.getText()=="") {b7.setText("O");break;} else {numero = 8;};
		case 8: if (b8.getText()=="") {b8.setText("O");break;} else {numero = 9;};
		case 9: if (b9.getText()=="") {b9.setText("O");break;} else {numero = 1;};
		default: break;
		}
	}
	public boolean compruebaganador(boolean g, String s) {//comprueba ganador
	    if (((b1.getText()==s) & (b2.getText()==s)&(b3.getText()==s))||
		    ((b4.getText()==s) & (b5.getText()==s)&(b6.getText()==s))||
		    ((b7.getText()==s) & (b8.getText()==s)&(b9.getText()==s))||
		    ((b1.getText()==s) & (b4.getText()==s)&(b7.getText()==s))||
		    ((b2.getText()==s) & (b5.getText()==s)&(b8.getText()==s))||
		    ((b3.getText()==s) & (b6.getText()==s)&(b9.getText()==s))||
		    ((b1.getText()==s) & (b5.getText()==s)&(b9.getText()==s))||
		    ((b7.getText()==s) & (b5.getText()==s)&(b3.getText()==s))){  
	    	g = true; 
	    	if (play=="X") {
	    	label1.setText("¡GANA JUGADOR 1!");
	    	} else {label1.setText("¡GANA JUGADOR 2!");}
	    }	else {
	    	g=false;
	    }
	   
		return g; //devuelve un valor true o false que dirà si ya hay ganador impidiendo que se pinten más botones
	}


	//diseño de la interfaz
	public void diseño() {
		JFrame frame =new JFrame();
		frame.setTitle("TRES EN RAYA");
		frame.setSize(440,250);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		panel1=new JPanel(new GridLayout(3,3));
		b1=new JButton("");
		b1.addActionListener(new ActionListenerTest());
		panel1.add(b1);
		
		b2=new JButton("");
		b2.addActionListener(new ActionListenerTest());
		panel1.add(b2);
		
		b3=new JButton("");
		b3.addActionListener(new ActionListenerTest());
		panel1.add(b3);
		
		b4=new JButton("");
		b4.addActionListener(new ActionListenerTest());
		panel1.add(b4);
		
		b5=new JButton("");
		b5.addActionListener(new ActionListenerTest());
		panel1.add(b5);
		
		b6=new JButton("");
		b6.addActionListener(new ActionListenerTest());
		panel1.add(b6);
		
		b7=new JButton("");
		b7.addActionListener(new ActionListenerTest());
		panel1.add(b7);
		
		b8=new JButton("");
		b8.addActionListener(new ActionListenerTest());
		panel1.add(b8);
		
		b9=new JButton("");
		b9.addActionListener(new ActionListenerTest());
		panel1.add(b9);
		
		panel2=new JPanel();
		panel2.setLayout((LayoutManager)new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		ButtonGroup cbg = new ButtonGroup();
		JRadioButton c1 = new JRadioButton("Humano vs. Computadora", true);
		c1.addItemListener(new ItemListener(){//listener integrado para escoger modo de juego
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				modohvm=true; //con esta variable se notifica el modo de juego				
			}
		});
		cbg.add(c1);
		
		JRadioButton c2 = new JRadioButton("Humano vs. Humano", false);
		c2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				modohvm=false;	
			}
		});
		
		cbg.add(c2);
		
		panel2.add(c1);
		panel2.add(c2);
		
		label1=new JLabel();
		label2=new JLabel(" "); label3=new JLabel(" ");
		label1.setText("Prueba");
		label1.setFont(new Font("Calibri", Font.BOLD,16));
		label1.setForeground(Color.red);
		//label1.setPreferredSize(new Dimension(100,150));
		label1.setVisible(true);
		panel2.add(label2);
		panel2.add(label1);
		panel2.add(label3);
		
		JButton boton = new JButton("Reiniciar");
		boton.setBackground(Color.LIGHT_GRAY);
		boton.addActionListener(new ActionListener() {//listener integrado de borrado texto de los botones

			@Override
			public void actionPerformed(ActionEvent arg0) {
				b1.setText("");
				b2.setText("");
				b3.setText("");
				b4.setText("");
				b5.setText("");
				b6.setText("");
				b7.setText("");
				b8.setText("");
				b9.setText("");
				ganador=false;
				label1.setText("");			
			}
		});
				
		panel2.add(boton);
		frame.getContentPane().add(panel1,BorderLayout.CENTER);
		frame.getContentPane().add(panel2,BorderLayout.EAST);
		frame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		
		Principal prueba=new Principal();
		prueba.diseño();
	}

}
