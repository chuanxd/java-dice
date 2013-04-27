import java.io.*;
import java.util.*;
import java.lang.Math;//Math.random()
class dice_player1{

public static void main(String[] args)
{
  String userName;String betStr;String result = new String("");
	int diceNum1;int diceNum2;int diceNum3;int diceSum;int betNum;
	Scanner scanner =new Scanner(System.in);
	System.out.println("Pleace Input Your Name.");
	userName = new String(scanner.next());
	//write player 1 name. Filename is player1.txt 
	try {
	FileOutputStream fos = new FileOutputStream(".//player1.txt");
	BufferedOutputStream bos = new BufferedOutputStream(fos);
	PrintStream ps = new PrintStream(bos);
	ps.println(userName);
	ps.close();
	bos.close();
	fos.close();
	}catch (Exception e)
	{}
	//Print welcome message
	System.out.println("Welcome "+userName+".\nShaking dice.....\n==========================================");
	//shake dice
	diceNum1 = (int)(Math.random()*6+1);
	System.out.println(diceNum1+"Points");
	diceNum2 = (int)(Math.random()*6+1);
	System.out.println(diceNum2+"Points");
	diceNum3 = (int)(Math.random()*6+1);
	System.out.println(diceNum3+"Points");
	diceSum	=diceNum1+diceNum2+diceNum3;
	//Write dicesum. File name is dicesum.txt
	try {
	FileOutputStream fos = new FileOutputStream(".//player1dicesum.txt");
	BufferedOutputStream bos = new BufferedOutputStream(fos);
	PrintStream ps = new PrintStream(bos);
	ps.println(diceSum);
	ps.close();
	bos.close();
	fos.close();
	}catch (Exception e)
	{}
	System.out.println("Total points = "+diceSum+"\n==========================================");
	//choose dimension
	System.out.println("Choose dimension. Pleace input a number 1 or 2. [1]Large [2]Small");
	betNum = scanner.nextInt();
	if(betNum%2 == 1){
		betStr = new String("Large");
	}else{
		betStr = new String("Small");
	}
	System.out.println("You bet "+betStr+".");
	//Read player 2 dicesum
	File sumPosition = new File("player2dicesum.txt");
	int player2dicesum = 0;
	try{
	BufferedReader input = new BufferedReader(new FileReader(sumPosition) );
	player2dicesum = Integer.parseInt(input.readLine());
	System.out.println("Player 2 total-point is "+player2dicesum+"."+"\n==========================================");
	}
	catch(Exception e)
	{System.out.print("Something wrong!(Read File)");}
	//Open Answer
	result = "You Loss!!!";
	if(player2dicesum <10 && betStr.equals("Small")){
		result = "You Win!!!";
	}
	if(player2dicesum >10 && betStr.equals("Large")){
		result = "You Win!!!";
	}
	System.out.println(result+"\n==========================================");
	
	//Read player 2 name
	File namePosition = new File("player2.txt");
	try{
	BufferedReader input = new BufferedReader(new FileReader(namePosition) );
	String readName = new String(input.readLine());
	System.out.println("Player 2 name is "+readName+"."+"\n==========================================");
	}
	catch(Exception e)
	{System.out.print("Something wrong!(Read File)");}
}
}




