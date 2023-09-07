package com.example.hihiba;

public class Calculate {
    private double diameter, jarijari;
    private String perintah;

    public Calculate(double diameter, double jarijari, String perintah) {
        this.diameter = diameter;
        this.jarijari = jarijari;
        this.perintah = perintah;
        if (jarijari == 0) {
            this.jarijari = diameterToJarijari();
        }
    }

    public double diameterToJarijari() {
        return diameter / 2;
    }

    public double cariLuas() {
        return Math.PI * jarijari * jarijari;
    }

    public double cariKeliling() {
        return 2 * Math.PI * jarijari;
    }

    public double hitung() {
        if (perintah.equals("luas")) {
            return cariLuas();
        } else if (perintah.equals("keliling")) {
            return cariKeliling();
        } else {
            return 0;
        }
    }
}
