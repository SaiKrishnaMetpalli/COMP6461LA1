public class httpc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=0) {
			HttpLibrary http_Lib=new HttpLibrary(args);
			http_Lib.handleCommand();
		} else {
			System.out.println("Invalid Command");
		}
	}

}
