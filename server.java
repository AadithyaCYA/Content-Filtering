package Packet_Filter;
import static Packet_Filter.ClientSession.info;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class ServerWindowThread extends Thread
{
public void run()
{
ServerWindow serverwindow = new ServerWindow();
}
}
public class Server {
Server()
{
String info[] = new String[2];
ServerSocket x = null;
Socket client;
InetAddress addr;
try{
addr=InetAddress.getLocalHost();
x = new ServerSocket(2525);
info[0]=addr.toString();
}
catch(IOException ie){
System.out.println("Cannot Open the Socket");
System.exit(1);
}
new ServerWindowThread().start();
System.out.println("Execution started!\nLocal Port Number of the server: " + x.getLocalPort() + "\nWaiting for the connection\n......\n");
info[1]=Integer.toString(x.getLocalPort());
ServerWindow.getWelcomeMessage(info);

while(true) {
try {
System.out.println("Successful Completion");
client = x.accept();
new Thread(new ClientSession(client)).start();
} catch (IOException ie) {}}
}
}
class ClientSession implements Runnable {
private final Socket clientsocket;
static String info[] = new String[2];
static String temp;
List<String> list=new ArrayList<>();
Scanner scanner=new Scanner("block.txt");
ClientSession(Socket sock) {
this.clientsocket = sock;
temp = clientsocket.getRemoteSocketAddress().toString();
}
@Override
public void run() {
FileInputStream fstream;
try
{
fstream = new FileInputStream("block.txt");
DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new
InputStreamReader(in));
String strLine;
while ((strLine = br.readLine()) != null)
{
list.add(strLine.trim());
}
}
catch(Exception e){}
try{
OutputStream clientOut = clientsocket.getOutputStream();
PrintWriter pw = new PrintWriter(clientOut, true);
InputStream clientIn = clientsocket.getInputStream();
BufferedReader br = new BufferedReader(new
InputStreamReader(clientIn));
if(list.contains(clientsocket.getRemoteSocketAddress().toString().substring(1,
clientsocket.getRemoteSocketAddress().toString().indexOf(":"))))
{
info[0]=clientsocket.getRemoteSocketAddress().toString() +
"Blocked";
ServerWindow.getConfirmation(info);
pw.println("Blocked");
clientsocket.close();
}
else
{
info[0]=clientsocket.getRemoteSocketAddress().toString();
ServerWindow.getConfirmation(info);
}
Thread tq = new Thread();
while(true)
{
info[0]=br.readLine();
info[1]=clientsocket.getRemoteSocketAddress().toString();
FileInputStream fstreamMes;
java.util.List<String> list = new ArrayList<>();
try
{
fstreamMes = new FileInputStream("stringblock.txt");
DataInputStream in = new DataInputStream(fstreamMes);
BufferedReader brMes = new BufferedReader(new
InputStreamReader(in));
String strLine;
while ((strLine = brMes.readLine()) != null)
{
list.add(strLine.trim());
}
}catch(Exception e){}
String packet[] = info[0].trim().split("\\s+");
String messagelist="";
int l = packet.length;
int j;
tq.resume();
for(j=0;j<l;j++)
{
if(list.contains(packet[j]))
{
info[0]=packet[j];
messagelist = messagelist + packet[j] + " Rejected#";
}
else
{
info[0]=packet[j];
ServerWindow.getClientMessage(info);
messagelist = messagelist + packet[j] + " Accepted#";
}
try
{
tq.sleep(150);
}
catch(Exception e){}
}
tq.suspend();
pw.println(messagelist);
}
}
catch(IOException ie)
{}
}
}