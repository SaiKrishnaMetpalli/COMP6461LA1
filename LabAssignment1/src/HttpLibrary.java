import java.util.HashMap;

public class HttpLibrary {

	private String[] cmd_Arguments;
	
	public HttpLibrary(String[] arguments) {
		cmd_Arguments=arguments;
	}
	
	public void handleCommand() {
		if(cmd_Arguments.length==1 && cmd_Arguments[0].equals("help")) {
			String help_Text = "\n";
    		help_Text += "httpc is a curl-like application but supports HTTP protocol only.\n";
    		help_Text += "Usage: \n    httpc command [arguments]\nThe commands are:\n";
    		help_Text += "    get     executes a HTTP GET request and prints the response.\n";
    		help_Text += "    post    executes a HTTP POST request and prints the response.\n";
    		help_Text += "    help    prints this screen.\n\n";
    		help_Text += "Use \"httpc help [command]\" for more information about a command.\n";
            System.out.println(help_Text);
		} else if(cmd_Arguments.length==1) {
			System.out.println("Invalid command");
		} else {
			switch (cmd_Arguments[0]) {
		        case "help":		        	
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
			        	}		        		            
		            break;
		        case "get":
		        	handleGetRequest();
		        	break; 
		        case "post":
		        	break;
		        default:
		            System.out.println(cmd_Arguments[0] + " command not found");		            
		    }
		}		
	}	
	
	public void handleGetRequest() {
		boolean is_Verbose=false;
		boolean is_Headers=false;
		boolean is_Proceed=true;
		String message="";
		String host="";
		String path="/";
		HashMap<String,String> header_List=new HashMap<String,String>();
		
		for(int i=1;i<=cmd_Arguments.length;i++) {
			if(cmd_Arguments[i].equals("-v")) {
				is_Verbose=true;
			} else if(cmd_Arguments[i].equals("-h")) {
				is_Headers=true;
				i++;
				if(cmd_Arguments[i].contains(":")) {
					String[] headers=cmd_Arguments[i].split(":");
					header_List.put(headers[0], headers[1]);
				} else {
					is_Proceed=false;
					message="The headers are not in Key:Value pair";
					break;
				}
			} else if(cmd_Arguments[i].contains("http")) {
				 if(validateURL(cmd_Arguments[i])) {
					 int index_path=cmd_Arguments[i].indexOf("/",7);
					 if(index_path!=-1) {
						 host = cmd_Arguments[i].substring(7, index_path);
	                     path = cmd_Arguments[i].substring(index_path);
					 } else {
						 host = cmd_Arguments[i].substring(7, cmd_Arguments[i].length());
					 }
				 } else {
					 is_Proceed=false;
					 message="The URL is not correct";
				 }
			} else {
				is_Proceed=false;
				message="The get command format is not correct";
			}			
		}
		if(is_Proceed) {
			
		} else {
			System.out.println(message);
		}
	}

	private boolean validateURL(String url) {		
		return url.substring(0, 7).equals("http://");
	}
}
