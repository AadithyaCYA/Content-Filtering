package Packet_Filter;
import java.io.*;

public class LogWindow extends javax.swing.JFrame {
public LogWindow() throws Exception{
initComponents();
this.setVisible(true);
File file = new File("log.txt");
FileInputStream fis = new FileInputStream(file);
byte[] data = new byte[(int)file.length()];
fis.read(data);
fis.close();
String s = new String(data, "UTF-8");
jTextArea1.setText(s);
}
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">
private void initComponents() {
jScrollPane1 = new javax.swing.JScrollPane();
jTextArea1 = new javax.swing.JTextArea();
setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
setTitle("Log Window");
jTextArea1.setColumns(20);
jTextArea1.setRows(5);
jScrollPane1.setViewportView(jTextArea1);
javax.swing.GroupLayout layout = new
javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jScrollPane1,
javax.swing.GroupLayout.PREFERRED_SIZE, 371,
javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(19, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jScrollPane1,
javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
.addContainerGap())
);
pack();
}// </editor-fold>

// Variables declaration - do not modify
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextArea jTextArea1;
// End of variables declaration
}