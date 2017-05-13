package test;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;  
public class Cal extends JFrame implements ActionListener {  
	static int year,month;      //设置静态变量便于计算方法的实现 
	private String [] ast = {"       日","     一", "     二", "     三", "     四", "     五", "      六"};  
	private JLabel [] ai = new JLabel[49];   
	private JLabel label0,label1,label2,label3;   //标签  
	private JTextField text1,text2,text3;      //输入框  
	private JButton button1;      //按钮   
	private JPanel p3,p1,p2;    //面板       
	public Cal()  {     
		super("2012210637郑晨宇——Java作业•日历软件"); //框架命名  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口关闭函数
		this.setBounds(400,150,550,340);//设置窗口的位置和大小
		Container c=getContentPane();           
		p1 = new JPanel();//面板对象，         
		p3 = new JPanel(new GridLayout(8,1,3,3));//在面板对象p3里使用网格布局管理器         
		p2 = new JPanel(new GridLayout(7,7,10,1));//网格布局管理器           
		label0=new JLabel("年份:");//标签组件         
		label1=new JLabel("月份:");    
		label2=new JLabel("备忘录:");          
		label3=new JLabel("");            
		text1=new JTextField("2014",1);//文本框         
		text2=new JTextField("12",1);    
		text3=new JTextField(1);           
		button1=new JButton("查看");//按钮   
		int i;//中心面板中各个标签初始化（用显示日历7行7列）
		for(i=0;i<7;i++)   
			p2.add(ai[i]=new JLabel(ast[i]));//第一行显示是周几（星期日到星期六） 
		for (i= 7; i< 49; i++)
			p2.add(ai[i]=new JLabel(""));//暂时空，在showcal中具体定义各月不同的显示  
		p3.add(label0);  
		p3.add(text1); 
		p3.add(label1);    
		p3.add(text2); 
		p3.add(button1);      
		p3.add(label2);   
		p3.add(text3); 
		p1.add(label3);     
		setVisible(true);   
		c.add(p1,BorderLayout.NORTH); 
		c.add(p3,BorderLayout.EAST); 
		c.add(p2,BorderLayout.CENTER);           
		button1.addActionListener(this);//注册年份、月份输入和ok按钮监听器
		//  text1.addActionListener(this); 
		//  text2.addActionListener(this);  
		this.setVisible(true);//窗口可见  
	}     //main主函数   
	public static void main(String[] args)  {   
		Cal a=new Cal();    
		a.showcal(2014,12);//初始化显示2013年6月日历  
	}   
	//事件处理方法   
	public void actionPerformed (ActionEvent e)  {   
		//e.getSource() == text1 || e.getSource() == text2 || 
		if(e.getSource() == button1)    
		{     
			try//控制输入的年份正确，异常控制              
			{     
				if (text1.getText().length() != 4)  
					throw new NumberFormatException(); 
			}   
			catch (NumberFormatException ex)              
			{  
				return;               
			}
			String s1=text1.getText();//得到输入的年份      
			year=Integer.parseInt(s1);//将年份转换为int型，year为静态变量    
			String s2=text2.getText();//月份，同年份处理    
			month=Integer.parseInt(s2);         
			showcal(year,month);//调用显示日历的函数    
		}   
	}     
	//showcal：在中间面板中显示网格布局之后的日历主界面  

	public void showcal(int year,int month)  
	{   
		int monthDay=getMonthDay(year,month);//得到一个月有多少天   
		int startDay=getStartDay(year,month);//得到每个月开始是周几       
		//显示当前窗口中显示日历的年月    
		String rr=""+Integer.toString(year)+"年"+Integer.toString(month)+"月";   
		label3.setText(rr);       //控制各月日历的正确显示   
		int i;    
		for (i= 7; i< startDay+7; i++)    
			ai[i].setText("");   
		for (i =startDay+7;i<startDay + monthDay + 7;i++)   
		{       
			String bb;//存在意义：便于实现setText函数的带格式输入     
			if(i-startDay-6<10)      
				bb="         "+Integer.toString(i-startDay-6);//int型转换为String型      
			else       
				bb="        "+Integer.toString(i-startDay-6);     
			ai[i].setText(bb);    
		}    
		for(i=startDay + monthDay + 7;i<49;i++)      
			ai[i].setText("");   
	}        
	//leapYear：判断是否为闰年   
	public static boolean leapYear(int year) 
	{    
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))       
			return true; 
		else
			return false;   
	}     
	//getMonthDay：每月总天数  
	public static int getMonthDay(int year, int month)   
	{    
		if (month == 1 || month==3 || month == 5 || month == 7 ||  month == 8 || month == 10 || month == 12) 
			return 31;   
		if (month == 4 || month == 6 || month == 9 || month == 11)  
			return 30;  
		if(month == 2)   
			if (leapYear(year))//闰年二月29天  
				return 29;  
			else  	
				return 28;   
		return 0; //if month is incorrect.
		//如果月份输入错误返回0.    
	}    
	//getStartDay:返回每月第一天是周几   
	public static int getStartDay(int year,int month) 
	{  //从1800年1月1日开始    
		int startDay1800 = 3;    
		long totalDays = getTotalDays(year, month);    
		return (int)((totalDays + startDay1800) % 7);  
	}     
	//getTotalDays:从1800年1月1日到所查月份前总的天数  
	public static long getTotalDays(int year, int month) 
	{    
		long total = 0;     
		for (int i = 1800; i< year; i++)    
			if (leapYear(i))     
				total = total + 366;     
			else       
				total = total + 365;    
		for (int i = 1; i< month; i++)      
			total = total + getMonthDay(year, i);

		return total;  
	}  
} 
