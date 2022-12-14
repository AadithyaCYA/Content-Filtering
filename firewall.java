package Packet_Filter;
class ClientThread1 extends Thread
{
public void run()
{
ClientWindow client = new ClientWindow();
}
}
class ClientThread2 extends Thread
{
public void run()
{
ClientWindow client = new ClientWindow();
}
}
class ClientThread3 extends Thread
{
public void run()
{
ClientWindow client = new ClientWindow();
}
}
class ClientThread4 extends Thread
{
public void run()
{
ClientWindow client = new ClientWindow();
}
}
class ClientThread5 extends Thread
{
public void run()
{
ClientWindow client = new ClientWindow();
}
}
class ServerThread extends Thread
{
public void run()
{
Server server = new Server();
}
}
public class Firewall {
public static void main(String[] args) {
new ServerThread().start();
new ClientThread1().start();
new ClientThread2().start();
new ClientThread3().start();
new ClientThread4().start();
new ClientThread5().start();
}
}