
/**
 * Write a description of class ClientGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//import javax.swing.*;
//import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
//import javax.swing.Box;
import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;

import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;

import java.net.SocketException;

 

public class ClientGUI extends JFrame
{
    public static void main(String[] args) throws Exception {
            ClientGUI client = new ClientGUI();
            client.UserInterface();
            
    }
    
    public void UserInterface() {
        /*
        Client myClient = new Client();
        */
        //Create and set up the window.
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Client Side");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JTextArea recArea = new JTextArea();
        recArea.setPreferredSize(new Dimension(300,100));
        final JTextArea sendArea = new JTextArea();
        sendArea.setPreferredSize(new Dimension(300,100));
        JScrollPane recPane = new JScrollPane(recArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane sendPane = new JScrollPane(sendArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sendArea.setLineWrap(true);
        sendArea.setWrapStyleWord(true);
        recArea.setLineWrap(true);
        recArea.setEditable(false);
        recArea.setWrapStyleWord(true);
        frame.add(recPane);
        frame.add(sendPane);
        
        
        
        //enter and clear buttons
        JButton sendButton = new JButton("Send");
        JButton recButton = new JButton("Clear");
        sendButton.setPreferredSize(new Dimension(150,30));
        recButton.setPreferredSize(new Dimension(150,30));
        frame.add(sendButton);
        frame.add(recButton);
        JButton connectButton = new JButton("Connect");
        JButton fileButton = new JButton("File Transfer");
        connectButton.setPreferredSize(new Dimension(150,30));
        fileButton.setPreferredSize(new Dimension(150,30));
        frame.add(connectButton);
        frame.add(fileButton);
 
        //Display the window.
        
        frame.setSize(350,360);
        frame.setVisible(true);
        
        
        
        
        ActionListener actionListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                sendArea.setText("Sending text");
                //Need to declare a method here for sending a message to a new pc
                Client myClient = new Client();
                myClient.UDPClient();
            }          
        };
        sendButton.addActionListener(actionListener);
        
        
        ActionListener actionListener2 = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                sendArea.setText("");
            };
       
        };
         recButton.addActionListener(actionListener2);  
         
          ActionListener actionListener3 = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                sendArea.setText("");
            };
       
        };
         connectButton.addActionListener(actionListener3);  
         fileButton.addActionListener(actionListener2);  
         
          ActionListener actionListener4 = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                Client myClient = new Client();
                myClient.TCPClient();
            };
       
        };
         fileButton.addActionListener(actionListener4);  
    }
}
