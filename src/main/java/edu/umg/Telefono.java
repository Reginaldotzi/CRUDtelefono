package edu.umg;

public class Telefono {
    private String marca;
    private String modelo;
    private String sistemaOperativo;
    private double tamanoPantalla;
    private int memoriaRAM;
    private int almacenamientoInterno;
    private boolean tieneCamara;
    private double resolucionCamara;
    private boolean esSmartphone;
    private String imei;

    // Constructor sin argumentos
    public Telefono() {
        // Valores predeterminados o nulos
        this.marca = "";
        this.modelo = "";
        this.sistemaOperativo = "";
        this.tamanoPantalla = 0.0;
        this.memoriaRAM = 0;
        this.almacenamientoInterno = 0;
        this.tieneCamara = false;
        this.resolucionCamara = 0.0;
        this.esSmartphone = false;
        this.imei = "";
    }

    // Constructor con todos los argumentos
    public Telefono(String marca, String modelo, String sistemaOperativo, double tamanoPantalla, int memoriaRAM,
                    int almacenamientoInterno, boolean tieneCamara, double resolucionCamara, boolean esSmartphone, String imei) {
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
        this.tamanoPantalla = tamanoPantalla;
        this.memoriaRAM = memoriaRAM;
        this.almacenamientoInterno = almacenamientoInterno;
        this.tieneCamara = tieneCamara;
        this.resolucionCamara = resolucionCamara;
        this.esSmartphone = esSmartphone;
        this.imei = imei;
    }
    // Getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public double getTamanoPantalla() {
        return tamanoPantalla;
    }

    public void setTamanoPantalla(double tamanoPantalla) {
        this.tamanoPantalla = tamanoPantalla;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public int getAlmacenamientoInterno() {
        return almacenamientoInterno;
    }

    public void setAlmacenamientoInterno(int almacenamientoInterno) {
        this.almacenamientoInterno = almacenamientoInterno;
    }

    public boolean isTieneCamara() {
        return tieneCamara;
    }

    public void setTieneCamara(boolean tieneCamara) {
        this.tieneCamara = tieneCamara;
    }

    public double getResolucionCamara() {
        return resolucionCamara;
    }

    public void setResolucionCamara(double resolucionCamara) {
        this.resolucionCamara = resolucionCamara;
    }

    public boolean isEsSmartphone() {
        return esSmartphone;
    }

    public void setEsSmartphone(boolean esSmartphone) {
        this.esSmartphone = esSmartphone;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
