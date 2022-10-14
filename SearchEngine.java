import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> SearchList = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("");
        } else if (url.getPath().equals("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")){
                SearchList.add(parameters[1]);
                return String.format(parameters[1] + " is Added.");
            }
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/search")) {
                String Searched = "";
                String[] parameters = url.getQuery().split("=");
                for(int i = 0; i < SearchList.size(); i += 1){ 
                    if (SearchList.get(i).contains(parameters[1])){ 
                        Searched = Searched + SearchList.get(i) + " ";
                    }
                }
                return Searched;
            }
        }
    return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}