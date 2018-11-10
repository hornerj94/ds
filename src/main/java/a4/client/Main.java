package a4.client;

public class Main {
    // ---------------------------------------------------------------------------------------------

    /** The port of the server to send the incoming messages. */
    private final static int PORT = 7825;

    /** The port of the server to send the incoming messages. */
    private final static String SERVER = "DESKTOP-Q99AK62.fh-reutlingen.de";

    // ---------------------------------------------------------------------------------------------

    public static void main(String[] args) {        
        ClientCommunicator clientCommunicator = new ClientCommunicator();
        clientCommunicator.setCommunicationParameters(SERVER, PORT);
        Client client = new Client(clientCommunicator);
        
        client.addTopic("Bananen");
        client.checkVotes("Bananen");
        
        clientCommunicator.closeConnection();
    }
    
    // ---------------------------------------------------------------------------------------------
}