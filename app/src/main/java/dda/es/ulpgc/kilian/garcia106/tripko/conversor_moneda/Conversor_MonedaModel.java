package dda.es.ulpgc.kilian.garcia106.tripko.conversor_moneda;

import java.text.DecimalFormat;

import dda.es.ulpgc.kilian.garcia106.tripko.data.RepositoryContract;

public class Conversor_MonedaModel implements Conversor_MonedaContract.Model {

    public static String TAG = Conversor_MonedaModel.class.getSimpleName();

    private RepositoryContract repository;

    private double resultado;

    private double divisaIgual = 1.0;

    private double euroKRW = 1373.79;
    private double euroDolar = 1.22;
    private double euroLibra = 0.86;


    private double krwDolar = 0.00089;
    private double krwLibra = 0.00063;
    private double krwEuro = 0.00073;

    private double dolarKRW = 1127.79;
    private double dolarLibra = 0.71;
    private double dolarEuro = 0.82;

    private double libraKRW = 1595.88;
    private double libraDolar = 1.42;
    private double libraEuro = 1.16;


    public Conversor_MonedaModel(RepositoryContract repository) {
        this.repository = repository;
    }


    @Override
    public void convertirDivisa(double cantidad, String divisa, String pasarA) {
        switch (divisa) {
            case "Euro":
                switch (pasarA) {
                    case "KRW":
                        resultado = cantidad * euroKRW;
                        break;
                    case "Dolar":
                        resultado = cantidad * euroDolar;
                        break;
                    case "Libra":
                        resultado = cantidad * euroLibra;
                        break;
                    case "Euro":
                        resultado = cantidad * divisaIgual;
                        break;
                }
                break;
            case "KRW":
                switch (pasarA) {
                    case "KRW":
                        resultado = cantidad * divisaIgual;
                        break;
                    case "Dolar":
                        resultado = cantidad * krwDolar;
                        break;
                    case "Libra":
                        resultado = cantidad * krwLibra;
                        break;
                    case "Euro":
                        resultado = cantidad * krwEuro;
                        break;
                }
                break;
            case "Dolar":
                switch (pasarA) {
                    case "KRW":
                        resultado = cantidad * dolarKRW ;
                        break;
                    case "Dolar":
                        resultado = cantidad * divisaIgual;
                        break;
                    case "Libra":
                        resultado = cantidad * dolarLibra ;
                        break;
                    case "Euro":
                        resultado = cantidad  * dolarEuro;
                        break;
                }
            case "Libra":
                switch (pasarA) {
                    case "KRW":
                        resultado = cantidad * libraKRW ;
                        break;
                    case "Dolar":
                        resultado = cantidad * libraDolar ;
                        break;
                    case "Libra":
                        resultado = cantidad * divisaIgual;
                        break;
                    case "Euro":
                        resultado = cantidad * libraEuro;
                        break;
                }
                break;
            default:
                resultado = 0.0;
        }
        setResultado(resultado);
    }

    @Override
    public double getResultado() {
     return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }


}