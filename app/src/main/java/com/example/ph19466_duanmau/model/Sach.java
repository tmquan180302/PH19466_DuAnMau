package com.example.ph19466_duanmau.model;

public class Sach {
    private int masach,giathue,maloai;
    private String tensach;


    public Sach(int masach, String tensach, int giathue, int maloai) {
        this.masach = masach;
        this.giathue = giathue;
        this.maloai = maloai;
        this.tensach = tensach;
    }

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public int getGiathue() {
        return giathue;
    }

    public void setGiathue(int giathue) {
        this.giathue = giathue;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }
}
