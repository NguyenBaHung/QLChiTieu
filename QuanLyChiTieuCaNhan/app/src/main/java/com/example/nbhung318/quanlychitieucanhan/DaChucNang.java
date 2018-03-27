package com.example.nbhung318.quanlychitieucanhan;

/**
 * Created by Hung on 3/19/2018.
 */

public class DaChucNang {
    private String ten;
    private int hinh;

    public  DaChucNang(){};

    public DaChucNang(String ten, int hinh) {
        this.ten = ten;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}

