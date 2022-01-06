package com.example.rros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML
    TextArea RRTextArea;

    @FXML
    public void RR8(ActionEvent event){
        int[] service;
        int[] service_time;
        int[] arrival_time;
        RRTextArea.clear();
        RRTextArea.setEditable(false);
        service=new int[8];
        service_time=new int[8];
        arrival_time=new int[8];
        for (int i=0;i<8;i++){
            service[i]=i;
            service_time[i]= (int) (Math.random()*100);
            arrival_time[i]=(int) (Math.random()*20);
        }
        RR r8 = new RR(service,arrival_time,service_time,10);
        RRTextArea.setText(r8.toString());
    }
    @FXML
    public void RR10(ActionEvent event){
        int[] service;
        int[] service_time;
        int[] arrival_time;
        RRTextArea.clear();
        RRTextArea.setEditable(false);
        int n =10;
        service=new int[n];
        service_time=new int[n];
        arrival_time=new int[n];
        for (int i=0;i<n;i++){
            service[i]=i;
            service_time[i]= (int) (Math.random()*100);
            arrival_time[i]=(int) (Math.random()*20);
        }
        RR r10 = new RR(service,arrival_time,service_time,10);
        RRTextArea.setText(r10.toString());
    }
    @FXML
    public void RR1000(ActionEvent event){
        int[] service;
        int[] service_time;
        int[] arrival_time;
        RRTextArea.clear();
        RRTextArea.setEditable(false);
        int n =1000;
        service=new int[n];
        service_time=new int[n];
        arrival_time=new int[n];
        for (int i=0;i<n;i++){
            service[i]=i;
            service_time[i]= (int) (Math.random()*1000);
            arrival_time[i]=(int) (Math.random()*2000);
        }
        RR r1000 = new RR(service,arrival_time,service_time,10);
        RRTextArea.setText(r1000.toString());

    }
    @FXML
    public void RR10000(ActionEvent event){
        int[] service;
        int[] service_time;
        int[] arrival_time;
        RRTextArea.clear();
        RRTextArea.setEditable(false);
        int n =10000;
        service=new int[n];
        service_time=new int[n];
        arrival_time=new int[n];
        for (int i=0;i<n;i++){
            service[i]=i;
            service_time[i]= (int) (Math.random()*10000);
            arrival_time[i]=(int) (Math.random()*20000);
        }
        RR r10000 = new RR(service,arrival_time,service_time,10);
        RRTextArea.setText(r10000.toString());

    }

}