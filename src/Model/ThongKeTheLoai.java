/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vu.vuong
 */
public class ThongKeTheLoai {
    private String theLoai;
    private int soPhim;

    public ThongKeTheLoai(String theLoai, int soPhim) {
        this.theLoai = theLoai;
        this.soPhim = soPhim;
    }

    public ThongKeTheLoai() {
    }

    public String getTheLoai() {
        return theLoai;
    }

    public int getSoPhim() {
        return soPhim;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public void setSoPhim(int soPhim) {
        this.soPhim = soPhim;
    }
    
}
