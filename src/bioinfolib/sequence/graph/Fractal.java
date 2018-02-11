package bioinfolib.sequence.graph;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Rysunek extends JPanel
{
	//Rysowanie punktu jako trywialnego odcinka
	private void rysujPunkt(Graphics g,int x,int y)
	{
		g.drawLine(x,y,x,y);
	}

	//Macierz kolorow
	Color [] kolory = { Color.black,
						Color.blue,
						Color.cyan,
						Color.red,
						Color.green,
						Color.gray,
						Color.lightGray,
						Color.magenta,
						Color.orange,
						Color.pink,
						Color.blue,
						Color.white,
						Color.yellow,
						Color.green,
						Color.red,
						Color.white};


	public void paintComponent(Graphics g)
	{
	  super.paintComponent(g);

	  //Ustawienie koloru tla okienka
	  setBackground(Color.WHITE);

	  //Odczytanie rozmiarow okienka
	  int szerokosc = getWidth();
	  int wysokosc  = getHeight();

	  //Rozne ksztalty fraktala
	  //double cx = 0.4; double cy = 0.3;
	  //double cx = 0.8; double cy = 0.01;
	  //double cx = -0.12; double cy = 0.6;
	  double cx = -0.05; double cy = 0.67;



	  double xp = -1.8;
	  double yp = xp;

	  double dx = 2.0*Math.abs(xp)/szerokosc;
	  double dy = 2.0*Math.abs(yp)/wysokosc;

	  //Ograniczenie na r
	  double maxR = 4;

	  for (int m=0; m<szerokosc; m++)
	  {
		  for (int n=0; n<wysokosc; n++)
		  {
			  double r = 0;
			  double x = xp + m*dx;
			  double y = yp + n*dy;
			  int k=0;
			  while ((r<maxR)&&(k<15))
			  {
				  double xPom = x*x - y*y -cx;
				  y = 2*x*y - cy;
				  x = xPom;
				  r = x*x + y*y;
				  k++;
			  }

			  //Ustawianie koloru o wybranym numerze (zgodnie z liczba iteracji petli while)
			  g.setColor(kolory[k]);

			  //Rysowanie punktu
			  rysujPunkt(g,m,n);
		  }
	  }
	}
}


class Ramka extends JFrame
{
	public Ramka()
	{
		setTitle("Fractal");
		Rysunek rysunek = new Rysunek();
		getContentPane().add(rysunek);
	}
}

public class Fractal
{

  public static void main ( String[] args )
  {
	//Utworzenie okienka
    Ramka ramka = new Ramka() ;

    //Koniec programu przy zamknieciu okienka
    ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ramka.setLocation(200,150);
    ramka.setSize( 400, 300 );
    ramka.setVisible( true );
  }
}

