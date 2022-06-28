import java.util.*;


public class Stack 
{
	int[] arr = new int[20];
	int top;
	
	public Stack()
	{
		this.top = -1;
	}
	
	public void init()
	{
		top = -1;
	}
	
	public int size()
	{
		return (top + 1);
	}
	
	public boolean isFull()
	{
		if(this.size() == 20)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isEmpty()
	{
		if(top == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void push(int a)
	{
		if(this.isFull() == false)
		{
			arr[++top] = a;
		}
		return;
	}
	
	public int pop()
	{
		if(this.isEmpty() == true)
		{
			return 1000;
		}
		else
		{
			return arr[top--];
		}
	}
}
