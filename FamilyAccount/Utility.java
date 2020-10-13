import java.util.Scanner;



public class Utility{
	private static Scanner in = new Scanner(System.in);

	private static String readKeyBoard(int limit) {
        while(true){
            String str = in.next();
            if (str.length() > limit){
                System.out.println("������������������룺");
            }else {
                return str;
            }
        }
    }

	public static char readInput(){
		char input = '0';
		while(true){
			String str = readKeyBoard(1);
			input = str.charAt(0);
			if(input != '1' && input != '2' && input != '3' && input != '4')
				System.out.print("����������������룻");
			else
				break;
		}
		return input;
	}

    public static int readNumber(){
		int n=0;
		while(true){
			String str = readKeyBoard(4);
			try{
				n = Integer.parseInt(str);
				break;
			}catch(NumberFormatException e){
				System.out.print("������������������룺");
			}
		}
		return n;
    }

	public static String readString(){
		String str = readKeyBoard(8);
		return str;
	}

	public static char readConfirminfo(){
		char c;
		while(true){
			String str = readKeyBoard(1).toUpperCase();
			c = str.charAt(0);
			if(c != 'Y' || c != 'N')
				System.out.print("����������������룺");
			else
				break;
		}
		return c;
	}

	public static void mainmenu(){
		System.out.println("------------��ͥ�˵�-----------\t");
		System.out.println();
		System.out.println("1����֧��ϸ\t");
		System.out.println("2���Ǽ�����\t");
		System.out.println("3���Ǽ�֧��\t");
		System.out.println("4���˳�\t");
		System.out.print("������ѡ�\t");
	}

}