import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.*;

public class Object extends ImageIcon
{
	int x, y, width, height;
	boolean fronttouched = false;
	boolean backtouched = false;
	boolean lefttouched = false;
	boolean righttouched = false;
	
	boolean ismessage = false;
	boolean isget = false;
	
	public Object(String img, int x, int y, int width, int height)//처음에 이미지 주소와 좌표, 크기를 받아옴
	{
		super(img);//이미지 적용

		this.x=x; //좌표, 크기설정
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public void drawObject(Graphics2D g2d) //장애물 배치
	{
		g2d.drawImage(this.getImage(), x, y, width, height, null);
	}
	
	public void isTouched(int char_x, int char_y)
	{
		if(isget == false)
		{
			if(char_x < x + width - 10 && char_x > x - 50)
			{
				if((y - char_y) > 60 - height && (y - char_y) < 90)
				{
					backtouched = true;
				}
				else
				{
					backtouched = false;
				}
				if((y - char_y) > 60 - height + 10 && (y - char_y) < 95)
				{
					fronttouched = true;
				}
				else
				{
					fronttouched = false;
				}
				
			}
			else
			{
				backtouched = false;
				fronttouched = false;
			}
			
			if((y - char_y) < 90 && (y - char_y) > 70 - height)
			{
				if((char_x - x) < width && (char_x - x) > -10)
				{
					righttouched = true;
				}
				else
				{
					righttouched = false;
				}
				if((x - char_x) < 63 && (char_x - x) < width - 10)
				{
					lefttouched = true;
				}
				else
				{
					lefttouched = false;
				}
			}
			else
			{
				righttouched = false;
				lefttouched = false;
			}
		}
		else
		{
			backtouched = false;
			fronttouched = false;
			righttouched = false;
			lefttouched = false;
		}
	}
	
	
}
