import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<Type> str = new ArrayList<Type>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return 0;
        } 
        
        else if (url.getpath().contains("/search")){
        String[] parameters = url.getQuery().split("=")        
            } 

        else {            
            System.out.println("Path: " + url.getPath());
            
            if (url.getPath().contains("/add")) {                            
            String[] parameters = url.getQuery().split("=");

                if (parameters [0] = equals("s")){
                    return ;
                }
            }   
                    
        }
        
        return "404 Not Found!";
    }
}


class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
