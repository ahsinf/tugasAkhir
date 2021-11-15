/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasAkhir;

/**
 *
 * @author Ahsin Fauzi
 */
public class ka63 {
    //kode
    private String kode;
    
    public void setKode(String kode){
        this.kode = kode;
    }
    
    public String getKode(){
        return kode;
    }
    
    //no KA
    private String noKa;
    
    public void setNoKa(String noKa){
        this.noKa = noKa;
    }
    
    public String getNoKa(){
        return noKa;
    }
    
    //Nama KA
    private String namaKa;
    
    public void setNamaKa(String namaKa){
        this.namaKa = namaKa;
    }
    
    public String getNamaKa(){
        return namaKa;
    }
    
    //Asal
    private String asal;
    
    public void setAsal(String asal){
        this.asal = asal;
    }
    
    public String getAsal(){
        return asal;
    }
    
    //Tujuan
    private String tujuan;
    
    public void setTujuan(String tujuan){
        this.tujuan = tujuan;
    }
    
    public String getTujuan(){
        return tujuan;
    }
    
    //Kelas
    private String kelas;
    
    public void setKelas(String kelas){
        this.kelas = kelas;
    }
    
    public String getKelas(){
        return kelas;
    }
    
    //Jumlah Penumpang
    private String jumlahPenumpang;
    
    public void setJumlahPenumpang(String jumlahPenumpang){
        this.jumlahPenumpang = jumlahPenumpang;
    }
    
    public String getJumlahPenumpang(){
        return jumlahPenumpang;
    }
    
    public Object[] getArrayObject(){
        Object[] object = new Object[7];
        object[0] = getKode();
        object[1] = getNoKa();
        object[2] = getNamaKa();
        object[3] = getAsal();
        object[4] = getTujuan();
        object[5] = getKelas();
        object[6] = getJumlahPenumpang();
        return object;
    }
    
}
