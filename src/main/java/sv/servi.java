/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author DELL
 */
@WebService(serviceName = "servi")
public class servi {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "suma")
    public Double suma(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 + num2;
    }

    public static ArrayList<TarjetaC> listaTar = new ArrayList<>();

    @WebMethod(operationName = "createT")
    public Boolean TarjetCredito(@WebParam(name = "ci") String ci, @WebParam(name = "monto") double monto, @WebParam(name = "fecha_corte") String fecha_corte, @WebParam(name = "fecha_vencimiento") String fecha_vencimiento) {
        boolean encuentro = false;
        for (int i = 0; i < listaTar.size(); i++) {
            if (ci.equalsIgnoreCase(listaTar.get(i).getCi())) {
                encuentro = true;
            }
        }
        if (encuentro) {
            //return "mal";
            return false;
        } else {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha_cortef = formato.parse(fecha_corte);
                Date fecha_vencimientof = formato.parse(fecha_vencimiento);
                listaTar.add(new TarjetaC(ci, monto, fecha_cortef, fecha_vencimientof));
                return true;
                //return "bien" + listaTar.toString();
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
                return false;
                //return "mal";
            }
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCard")
    public TarjetaC getCard(@WebParam(name = "ci") String ci) {
        TarjetaC tc = new TarjetaC();
        for (TarjetaC tarjetaC : listaTar) {
            if (tarjetaC.getCi().equals(ci)) {
                tc = tarjetaC;
                break;
            }
        }
        return tc;
    }

    @WebMethod(operationName = "updateCard")
    public Boolean updateCard(@WebParam(name = "ci") String ci, @WebParam(name = "monto") double monto, @WebParam(name = "fecha_corte") String fecha_corte, @WebParam(name = "fecha_vencimiento") String fecha_vencimiento) {
        boolean findOk = false;
        for (TarjetaC tarjetaC : listaTar) {
            if (tarjetaC.getCi().equals(ci)) {
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha_cortef = formato.parse(fecha_corte);
                    Date fecha_vencimientof = formato.parse(fecha_vencimiento);
                    tarjetaC.setMonto(monto);
                    tarjetaC.setFecha_corte(fecha_cortef);
                    tarjetaC.setFecha_vencimiento(fecha_vencimientof);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                findOk = true;
                break;
            }
        }
        if (findOk) {
            return true;
        }
        return false;
    }

    @WebMethod(operationName = "deleteCard")
    public Boolean deleteCard(@WebParam(name = "ci") String ci){
        boolean deleteOk = false;
        for (TarjetaC tarjetaC : listaTar) {
            if(tarjetaC.getCi().equals(ci)){
                listaTar.remove(tarjetaC);
                deleteOk = true;
                break;
            }
        }
        if(deleteOk){
            return true;
        }
        return false;
    }
    /*@WebMethod(operationName = "updateCard")
    public Boolean updateCard(@WebParam(name = "card") TarjetaC card, @WebParam(name = "ci") String ci) {
        boolean findOk= false;
        for (TarjetaC tarjetaC : listaTar) {
            if (tarjetaC.getCi().equals(ci)) {
                tarjetaC.setMonto(card.getMonto());
                tarjetaC.setFecha_corte(card.getFecha_corte());
                tarjetaC.setFecha_vencimiento(card.getFecha_vencimiento());
                findOk= true;
                break;
            }
        }
        if(findOk){
            return true;
        }
        return false;
    }*/
}
