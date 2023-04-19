/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv;

import java.util.Date;
import javax.ejb.Stateful;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

/**
 *
 * @author DELL
 */
@Stateful
@WebService
@Addressing
public class TarjetaC {

    private String ci;
    private double monto;
    private Date fecha_corte;
    private Date fecha_vencimiento;

    public TarjetaC() {
    }

    public TarjetaC(String ci, double monto, Date fecha_corte, Date fecha_vencimiento) {
        this.ci = ci;
        this.monto = monto;
        this.fecha_corte = fecha_corte;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha_corte() {
        return fecha_corte;
    }

    public void setFecha_corte(Date fecha_corte) {
        this.fecha_corte = fecha_corte;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    @Override
    public String toString() {
        return "TarjetaC{" + "ci=" + ci + ", monto=" + monto + ", fecha_corte=" + fecha_corte + ", fecha_vencimiento=" + fecha_vencimiento + '}';
    }

}
