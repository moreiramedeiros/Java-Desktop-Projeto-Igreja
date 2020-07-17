/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.utilitarios;

import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Isaac
 */
public class Utilitarios {

    //Convert Data Br para USA
    public String converteDataBrParaUSA(String dataBr) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataUsa_ = LocalDate.parse(dataBr, formato);
        return dataUsa_.toString();

    }

    //Convert Data Br para USA
    public String converteDataUsaParaBr(String dataUsa) {
        String dataBr = null;
        try {

            //Primeiro converte de String para Date
            DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");
            Date date;
            date = formatUS.parse(dataUsa);
            //Depois formata data
            DateFormat formatBR = new SimpleDateFormat("dd/mm/yyyy");
            dataBr = formatBR.format(date);

        } catch (ParseException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataBr;
    }

    //Convert Data Atual para Br 
    public String converteDataAtualParaBr() {
        Date agora = new Date();
        SimpleDateFormat dataBr = new SimpleDateFormat("dd/MM/yyyy");
        String dataformatada = dataBr.format(agora);
        return dataformatada;
    }

    //Convert Data Atual para USA
    public String converteDataAtualParaUsa() {
        Date agora = new Date();
        SimpleDateFormat dataEUA = new SimpleDateFormat("yyyy-MM-dd");
        String datamysql = dataEUA.format(agora);
        return datamysql;
    }

    //Limpar campos
    public void limpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }

    public String getAnoAtual() {
        Date agora = new Date();
        SimpleDateFormat dataEUA = new SimpleDateFormat("yyyy");
        String datamysql = dataEUA.format(agora);
        return datamysql;
    }

    public String getMesAtual() {
        Date agora = new Date();
        SimpleDateFormat dataEUA = new SimpleDateFormat("MM");
        String datamysql = dataEUA.format(agora);
        return datamysql;
    }

    public String getHoraAtual() {
        Calendar data = Calendar.getInstance();
        int hora = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);
        int seg = data.get(Calendar.SECOND);
        return hora + ":" + min + ":" + seg;

    }
    
    
        public String convertMesParaNome(int numeroMes) {
        switch(numeroMes){
            case 1: return "Janeiro";
            case 2: return "Fevereiro";                
            case 3: return "Março"; 
            case 4: return "Abril";
            case 5: return "Maio";                
            case 6: return "Junho";  
            case 7: return "Julho";
            case 8: return "Agosto";                
            case 9: return "Setembro";            
            case 10: return "Outubro";
            case 11: return "Novembro";                
            case 12: return "Dezembro"; 
            default: return null;
        }
    } 
    

    public int convertMesParaNumero(String nomeMes) {
        switch(nomeMes){
            case "Janeiro" : return 1; 
            case "Fevereiro" : return 2;                 
            case "Março" : return 3;  
            case "Abril" : return 4; 
            case "Maio" : return 5;                 
            case "Junho" : return 6;   
            case "Julho" : return 7; 
            case "Agosto" : return 8;                
            case "Setembro" : return 9;             
            case "Outubro" : return 10; 
            case "Novembro" : return 11;                
            case "Dezembro" : return 12;  
            default: return -1;
        }
    } 
        
}
