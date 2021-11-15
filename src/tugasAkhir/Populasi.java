/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasAkhir;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ahsin Fauzi
 */
public class Populasi {
    // untuk menampilkan isi fitness setiap iterasi
    
    private int optimalGerbong=0;
    private LinkedList<Kromosom> populasi = new LinkedList<>();
    Kromosom kro;
    
    // tabel
    public static LinkedList<Ka15> ka15;
    public static LinkedList<Ka16> ka16;
    public static LinkedList<Ka17> ka17;
    public static LinkedList<Ka62> ka62;
    public static LinkedList<Ka63> ka63;
    public static LinkedList<Ka64> ka64;
    public static LinkedList<Ka65> ka65;
    public static LinkedList<Ka102> ka102;
    public static LinkedList<Ka19> ka19;
    public static LinkedList<Ka20> ka20;
    public static LinkedList<Ka21> ka21;
    public static LinkedList<Ka23> ka23;
    public static LinkedList<Ka25> ka25;
    public static LinkedList<Ka15> ka26;
    public static LinkedList<Ka15> ka27;
    public static LinkedList<Ka29> ka29;
    public static LinkedList<Ka33> ka33;
    public static LinkedList<Ka120> ka120;
    
    public Populasi(int optimalGerbong){
        ka15 = getKa15();
        ka16 = getKa16();
        ka17 = getKa17();
        ka62 = getKa62();
        ka63 = getKa63();
        ka64 = getKa64();
        ka65 = getKa65();
        ka102 = getKa102();
        ka19 = getKa19();
        ka20 = getKa20();
        ka21 = getKa21();
        ka23 = getKa23();
        ka25 = getKa25();
        ka26 = getKa26();
        ka27 = getKa27();
        ka29 = getKa29();
        ka33 = getKa33();
        ka120 = getKa120();
        
        this.optimaGerbong=optimalGerbong;
        
        for(int i=0;i<8;i++){
            Kromosom k = new Kromosom(optimalGerbong);
            populasi.add(k);
            
        }
    }    
    
    public String toString(){
        String s="";
        for (int i=0;i<populasi.size();i++){
            s+= populasi.get(i).toString()+"\n";
        }
        
        return s;
    }
    
    public void setOptimalGerbong(int optimalGerbong){
        this.optimalGerbong = optimalGerbong;
    }
    
    public int getOptimalGerbong(){
        return optimalGerbong;
    }
    
    // Persilangan
    public void persilangan (){
        Random rnd = new Random();
        int angkaRandom = rnd.nextInt(3);
        // persilangan kromosom 1 (akhir) dan kromosom 2 (random{0-2})
        //System.out.println("kromosom ="+angkaRandom);
        Kromosom k1 = new Kromosom(populasi.get(3));
        Kromosom k2 = new Kromosom(populasi.get(angkaRandom)) ;
              
        for(int i=0;i<9;i++){
            int angka = rnd.nextInt(18);
            Gen g1 =k1.getGen(angka);
            Gen g2 =k2.getGen(angka);

            //System.out.println("gen ="+angka);
            //System.out.println("isi gen 1 ="+g1.cetakGen());
            //System.out.println("isi gen 2 ="+g2.cetakGen());
            k1.setGen(angka, g2);
            k2.setGen(angka, g1);
        }
        populasi.add(k1);
        populasi.add(k2);
        
        // persilangan kromosom 3 (akhir-1) dan kromosom 2 (random{0-1})
        angkaRandom = rnd.nextInt(2);
        Kromosom k3 = new Kromosom(populasi.get(2));
        Kromosom k4 = new Kromosom(populasi.get(angkaRandom));
   
        for(int i=0;i<9;i++){
            int angka = rnd.nextInt(18);
            Gen g1 =k1.getGen(angka);
            Gen g2 =k2.getGen(angka);

            //System.out.println("gen ="+angka);
            //System.out.println("isi gen 1 ="+g1.cetakGen());
            //System.out.println("isi gen 2 ="+g2.cetakGen());
            k3.setGen(angka, g2);
            k4.setGen(angka, g1);
        }
        populasi.add(k3);
        populasi.add(k4);
        
    }
    
    // Mutasi
    public void mutasi(){
        // untuk membandingkan apakah hasil mutasi lebih baik dari kromosom sebelumnya atau tidak
        // maka yang lebih baik yang dipilih
        // semua kromosom dimutasikan
        //System.out.println(populasi.size());
        
        for(int j=0;j<populasi.size();j++){
            //  hanya 2 gen yang dimutasikan
            Kromosom k = new Kromosom (populasi.get(j));
            int fitnessAwal = populasi.get(j).getFitness();
//            System.out.println("Fitness Awal = "+fitnessAwal);
//            System.out.println("Harga Tujuan = "+hargaTujuan);
            while(k.getFitness()<0){
            
                for (int i=0;i<2;i++){
                    Random rnd = new Random();
                    int angka = rnd.nextInt(18);               
                     switch (angka){
                        case 0:
                            k.setGen(0, new Gen(ka15.get(rnd.nextInt(ka15.size()))));
                            break;
                        case 1:
                            k.setGen(1, new Gen(ka16.get(rnd.nextInt(ka16.size()))));
                            break;
                        case 2:
                            k.setGen(2, new Gen(ka17.get(rnd.nextInt(ka17.size()))));
                            break;
                        case 3:
                            k.setGen(3, new Gen(ka62.get(rnd.nextInt(ka62.size()))));
                            break;
                        case 4:
                            k.setGen(4, new Gen(ka63.get(rnd.nextInt(ka63.size()))));
                            break;
                        case 5:
                            k.setGen(5, new Gen(ka64.get(rnd.nextInt(ka64.size()))));
                            break;
                        case 6:
                            k.setGen(6, new Gen(ka65.get(rnd.nextInt(ka65.size()))));
                            break;
                        case 7:
                            k.setGen(7, new Gen(ka102.get(rnd.nextInt(ka102.size()))));
                            break;
                        case 8:
                            k.setGen(8, new Gen(ka19.get(rnd.nextInt(ka19.size()))));
                            break;
                        case 9:
                            k.setGen(9, new Gen(ka20.get(rnd.nextInt(ka20.size()))));
                            break;
                        case 10:
                            k.setGen(10, new Gen(ka21.get(rnd.nextInt(ka21.size()))));
                            break;
                        case 11:
                            k.setGen(11, new Gen(ka23.get(rnd.nextInt(ka23.size()))));
                            break;
                        case 12:
                            k.setGen(12, new Gen(ka25.get(rnd.nextInt(ka25.size()))));
                            break;
                        case 13:
                            k.setGen(13, new Gen(ka26.get(rnd.nextInt(ka26.size()))));
                            break;
                        case 14:
                            k.setGen(14, new Gen(ka27.get(rnd.nextInt(ka27.size()))));
                            break;
                        case 15:
                            k.setGen(15, new Gen(ka29.get(rnd.nextInt(ka29.size()))));
                            break;
                        case 16:
                            k.setGen(16, new Gen(ka33.get(rnd.nextInt(ka33.size()))));
                            break;
                        case 17:
                            k.setGen(17, new Gen(ka120.get(rnd.nextInt(ka120.size()))));
                            break;
                    }
                }
                
                
                if(populasi.get(j).getFitness()<0){
//                    System.out.println("Minus = "+ populasi.get(j).getFitness());
                    populasi.remove(j);
                    populasi.add(j, k);
                }
            }
            //tutup sub code
//            populasi.remove(j);
//            populasi.add(k);
            
            //optimal gerbong didapat dari fungsi getFitness class Kromosom, 
            //dan total dari perhitungan tiap gen yang dikurang dengan target
            
            //hilangkan komen
            if ((k.getFitness()<0)  &&  (populasi.get(j).getFitness()<0)  ){
                if (k.getFitness()>populasi.get(j).getFitness()){
                    populasi.remove(j);
                    populasi.add(k);
                }
                //hasil[h][j]=populasi.get(j).getFitness(hargaTujuan);
            }else if ((k.getFitness()<0)  &&  (populasi.get(j).getFitness()>=0)  ){
                if (k.getFitness()>populasi.get(j).getFitness()){
                    populasi.remove(j);
                    populasi.add(k);   
                }
                //e = k;
            }else if ((k.getFitness()>=0)  &&  (populasi.get(j).getFitness()>=0)  ){
                if (k.getFitness()<populasi.get(j).getFitness()){
                    populasi.remove(j);
                    populasi.add(k);
                    
                }
                    //System.out.println(hasil[h][j]);
                   // e = k;
            }
        }
        Collections.sort(populasi, new Comparator<Kromosom>(){
            @Override
            public int compare(Kromosom o1, Kromosom o2) {
                return o1.getFitness()-o2.getFitness();
            }

        });
    }
    
    public boolean isKonvergen(){
        if(Math.abs(populasi.get(0).getFitness()-populasi.get(7).getFitness())<10000 && !isMinus()){
            return true;
        }
        return false;
    }
    
    public boolean isMinus(){
        for (int i = 0; i < populasi.size(); i++) {
            if(populasi.get(i).getFitness()<0){
                return true;
            }
        }
        return false;
    }
    
    public Kromosom getKromosom(int index){
        return populasi.get(index);
    }
    
    public int getFitness(int index){
        return populasi.get(index).getFitness();
    }
    
    // Seleksi
    public void seleksi(){
        Collections.sort(populasi, new Comparator<Kromosom>
        (){
            @Override
            public int compare(Kromosom o1, Kromosom o2) {
                return o1.getFitness()-o2.getFitness();
            }
            
        });
        int remove = 0;
        while(remove<4){
            int minus = getIndexMinusFitness();
            if(minus >=0){
                populasi.remove(minus);
                remove++;
            }else{
                populasi.remove(populasi.size()-1);
                remove++;
            }
        }
//        for (int i=0;i<4;i++){
//            populasi.remove(0);
//        }
    }
    
    public int getIndexMinusFitness(){
        for(int i = 0;i<populasi.size();i++){
            if(populasi.get(i).getFitness()<0){
                return i;
            }
        }
        return -1;
    }
    
    void solusi(){
        for(int a=0;a<populasi.size();a++){
            
        }
    }
    
    public static LinkedList<Ka15> getKa15(){
        //instansiasi variable linked list ka15
        LinkedList<Ka15> db = new LinkedList<>();
        
        //buat koneksi untuk mendapatkan seluruh database ka 15
        TA koneksi = new TA();
        try{
            Statement stat;
            ResultSet hasil;

            //eksekusi statement SQL
            koneksi.login();
            stat = koneksi.stm;
            hasil = stat.executeQuery("SELECT * FROM ka_15");
            
            //ambil data per baris lalu masukan kedalam linked list
            while (hasil.next()){
                Ka15 ka15 = new Ka15();
                ka15.setKode(hasil.getString("Kode"));
                ka15.setNoKa(hasil.getString("No_Ka"));
                ka15.setNamaKereta(hasil.getString("Nama_Ka"));
                ka15.setAsal(hasil.getString("Asal"));
                ka15.setTujuan(hasil.getString("Tujuan"));
                ka15.setKelas(hasil.getString("Kelas"));
                ka15.setJumlahPenumpang(hasil.getString("Jumlah_Penumpang"));
                
                db.add(ra);
            }
        }catch(Exception e){
            System.err.println(e);
        }
        
        return db;
    }
    
    public static LinkedList<Ka16> getKa16(){
        //instantiasi variable linked list lantai ruang
        LinkedList<Ka16> db = new LinkedList<>();
        
        //buat koneksi untuk mendapatkan seluruh database lantai ruang
        TA koneksi = new TA();
        try{
            Statement stat;
            ResultSet hasil;

            //eksekusi statement SQL
            koneksi.login();
            stat = koneksi.stm;
            hasil = stat.executeQuery("SELECT * FROM ka_16");
            
            //ambil data per baris lalu masukan kedalam linked list
            while (hasil.next()){
                Ka16 ka16 = new Ka15();
                ka16.setKode(hasil.getString("Kode"));
                ka16.setNoKa(hasil.getString("No_Ka"));
                ka16.setNamaKereta(hasil.getString("Nama_Ka"));
                ka16.setAsal(hasil.getString("Asal"));
                ka16.setTujuan(hasil.getString("Tujuan"));
                ka16.setKelas(hasil.getString("Kelas"));
                ka16.setJumlahPenumpang(hasil.getString("Jumlah_Penumpang"));
               
                db.add(lr);
            }
        }catch(Exception e){
            System.err.println(e);
        }
        
        return db;
    }
     
    
}
