import java.awt.*;
import java.util.*;
import java.applet.*;

public class Clock extends Applet implements Runnable
	{
	Thread t;
	Image im;
	public void init()
		{
		im=getImage(getCodeBase(),"images.jpg");
		setBackground(new Color(50,50,50));
		t=new Thread(this);
		t.start();
		}
	public void run()
		{
		while(true)
			{
			repaint();
			try{
			Thread.sleep(1000);
			}catch(InterruptedException ie)
				{ie.printStackTrace();}
			}	
		}
	public void paint(Graphics g)
		{
		g.drawImage(im,0,0,625,500,this);
		Calendar time=Calendar.getInstance();
		int hour=time.get(Calendar.HOUR_OF_DAY);
		int minute=time.get(Calendar.MINUTE);
		int second=time.get(Calendar.SECOND);
		if(hour>12)
		hour-=12;
		g.setColor(Color.pink);
		g.fillOval(190,90,220,220);
		g.setColor(Color.white);
		g.fillOval(200,100,200,200);
		
		

		g.setColor(Color.black);
		g.drawString("12",292,120);
		g.drawString("1",342,128);
		g.drawString("2",370,162);
		g.drawString("9",210,205);
		g.drawString("10",220,162);
		g.drawString("11",252,130);
		g.drawString("6",297,290);
		g.drawString("7",255,280);
		g.drawString("8",222,248);
		g.drawString("3",380,205);
		g.drawString("4",373,248);
		g.drawString("5",340,282);
		
		double angle;
		int x,y;
		angle=Math.toRadians((15-second)*6);
		x=(int)(Math.cos(angle)*100);
		y=(int)(Math.sin(angle)*100);

		g.setColor(Color.red);
		g.drawLine(300,200,300+x,200-y);

		angle=Math.toRadians((15-minute)*6);

		x=(int)(Math.cos(angle)*80);
		y=(int)(Math.sin(angle)*80);
		//mnute
		g.setColor(Color.blue);
		g.drawLine(300,200,300+x,200-y);

		angle=Math.toRadians((15-(hour*5))*6);
		x=(int)(Math.cos(angle)*50);
		y=(int)(Math.sin(angle)*50);

		g.setColor(Color.black);
		g.drawLine(300,200,300+x,200-y);
		Font f=new Font("Old English Text MT",Font.BOLD,20);
		g.setFont(f);
		g.setColor(Color.orange);
		g.drawString("My Clock",260,60);
		}
	}
/*
<applet code="Clock" width=625 height=500></applet>
*/