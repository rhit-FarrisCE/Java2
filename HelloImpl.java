import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.lang.SecurityManager;

public class HelloImpl extends UnicastRemoteObject
    implements Hello {

    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello() {
//      return  "Hi! I am in linsv211 server and using port 4321!";
        return  "Hi! I am in lecture room and using port 4333";
//      return  "Hi! I am in lecture room M3, host: lecmdc3 and using default port!";
    }

    public static void main(String args[]) { 

        // Create and install a security manager 
        if (System.getSecurityManager() == null) { 
	    System.setSecurityManager(new SecurityManager()); 
        } 
        try { 
	    HelloImpl obj = new HelloImpl(); 
	    // Bind this object instance to the name "HelloServer" 
            // RMI uses 1099 as a default port
            Naming.rebind("//localhost:4333/HelloServer", obj); 
//          Naming.rebind("//linsv211.u-aizu.ac.jp:4321/HelloServer", obj); 
//          Naming.rebind("HelloServer", obj); 
	    //Naming.rebind("HelloServer", obj); 
	    System.out.println("HelloServer bound in registry"); 
        } catch (Exception e) { 
	    System.out.println("HelloImpl err: " + e.getMessage()); 
	    e.printStackTrace(); 
        } 
    } 
}
