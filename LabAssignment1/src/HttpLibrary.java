
public class HttpLibrary {

	private String[] cmd_Arguments;
	public HttpLibrary(String[] arguments) {
		cmd_Arguments=arguments;
	}
	
	public void sendRequests() {
		switch (cmd_Arguments[0]) {
	        case "help":
	        	if(cmd_Arguments.length==1) {
	        		String help_Text = "\n";
	        		help_Text += "httpc is a curl-like application but supports HTTP protocol only.\n";
	        		help_Text += "Usage: \n    httpc command [arguments]\nThe commands are:\n";
	        		help_Text += "    get     executes a HTTP GET request and prints the response.\n";
	        		help_Text += "    post    executes a HTTP POST request and prints the response.\n";
	        		help_Text += "    help    prints this screen.\n\n";
	        		help_Text += "Use \"httpc help [command]\" for more information about a command.\n";
	                System.out.println(help_Text);
	        	} else {
	        		switch (cmd_Arguments[1]) {
		                case "get":
		                    String get_Help_Text = "\n";
		                    get_Help_Text += "usage: httpc get [-v] [-h key:value] URL\n\n";
		                    get_Help_Text += "Get executes a HTTP GET request for a given URL.\n\n";
		                    get_Help_Text += "    -v           Prints the detail of the response such as protocol, status, and headers.\n";
		                    get_Help_Text += "    -h key:value Associates headers to HTTP Request with the format 'key:value'.\n";
		                    System.out.println(get_Help_Text);
		                    break;
		                case "post":
		                    String post_Help_Txt = "\n";
		                    post_Help_Txt += "usage: httpc post [-v] [-h key:value] [-d inline-data] [-f file] URL\n\n";
		                    post_Help_Txt += "Post executes a HTTP POST request for a given URL with inline data or from file.\n\n";
		                    post_Help_Txt += "    -v             Prints the detail of the response such as protocol, status, and headers.\n";
		                    post_Help_Txt += "    -h key:value   Associates headers to HTTP Request with the format 'key:value'.\n";
		                    post_Help_Txt += "    -d string      Associates an inline data to the body HTTP POST request.\n";
		                    post_Help_Txt += "    -f file        Associates the content of a file to the body HTTP POST request.\n\n";
		                    post_Help_Txt += "Either [-d] or [-f] can be used but not both.\n";
		                    System.out.println(post_Help_Txt);
		                    break;
		                default:
		                    System.out.println(cmd_Arguments[1] + " command not found");
		                    break;
		            }
	        	}	            
	            break;
	        case "get":
	        	break;
	        case "post":
	        	break;
	        default:
	            System.out.println(cmd_Arguments[0] + " command not found");
	            break;
	    }
	}
}
