class family{
	
	public static void main(String[] args){
		
		String details = "";
		int balance = 0;

		while(true){
			Utility.mainmenu();
			char selection = Utility.readInput();
			switch(selection){
				case '1':
					System.out.println("-------------------当前收支明细--------------------\t");
				    System.out.println("收支\t账户余额\t收支金额\t收支说明\n");
					System.out.println(details);
					System.out.println("---------------------------------------------------\t");
				    break;
				case '2':
				{
					System.out.print("请输入金额：");
				    int money = Utility.readNumber();
					balance += money;
					System.out.print("输入收支说明：");
					String det = Utility.readString();
					details += "收入\t" + balance + "\t" + money + "\t" + det + "\n";
				    break;
				}
				case '3':
					System.out.print("1、请输入金额：");
				    break;
				case '4':
					System.out.print("4、退出：");
				    char info = Utility.readConfirminfo();
					if(info == 'Y')
						break;
			}
		}
	}
}