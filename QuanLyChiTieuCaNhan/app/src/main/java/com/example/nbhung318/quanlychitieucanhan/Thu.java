package com.example.nbhung318.quanlychitieucanhan;

import java.io.Serializable;

/**
 * Created by Hung on 3/27/2018.
 */

public class Thu implements Serializable {
    public int id;
    public Integer soTienThu;
    public String noiDungThu;
    public Integer thoiGian;

    public Thu(int id, Integer soTienThu, String noiDungThu, Integer thoiGian) {
        this.id = id;
        this.soTienThu = soTienThu;
        this.noiDungThu = noiDungThu;
        this.thoiGian = thoiGian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSoTienThu() {
        return soTienThu;
    }

    public void setSoTienThu(Integer soTienThu) {
        this.soTienThu = soTienThu;
    }

    public String getNoiDungThu() {
        return noiDungThu;
    }

    public void setNoiDungThu(String noiDungThu) {
        this.noiDungThu = noiDungThu;
    }

    public Integer getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Integer thoiGian) {
        this.thoiGian = thoiGian;
    }
}
