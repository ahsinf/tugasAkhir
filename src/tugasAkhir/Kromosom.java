/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasAkhir;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ahsin Fauzi
 */
public class Kromosom {
    //kamus
    public Gen[] gen;
    public LinkedList<RangkaAtap> rangkaAtap = Populasi.rangkaAtap;
    public LinkedList<PenutupAtap> penutupAtap = Populasi.penutupAtap;
    public LinkedList<RangkaPlafond> rangkaPlafond = Populasi.rangkaPlafond; 
    public LinkedList<PenutupPlafond> penutupPlafond = Populasi.penutupPlafond ;
    public LinkedList<Kolom> kolom = Populasi.kolom ;
    public LinkedList<Sloof> sloof = Populasi.sloof ;
    public LinkedList<RingBalk> ringBalk= Populasi.ringBalk ;
    public LinkedList<DindingInterior> dindingInterior= Populasi.dindingInterior ;
    public LinkedList<DindingEksterior> dindingEksterior= Populasi.dindingEksterior;
    public LinkedList<DindingToilet> dindingToilet= Populasi.dindingToilet ;
    public LinkedList<LantaiRuang> lantaiRuang= Populasi.lantaiRuang ;
    public LinkedList<LantaiToilet> lantaiToilet= Populasi.lantaiToilet ;
    public LinkedList<PintuRuang> pintuRuang= Populasi.pintuRuang ;
    public LinkedList<PintuToilet> pintuToilet = Populasi.pintuToilet;
    public LinkedList<JendelaRuang> jendelaRuang = Populasi.jendelaRuang;
    public LinkedList<Roster> roster = Populasi.roster;
    public LinkedList<Closet> closet = Populasi.closet;
    public LinkedList<BakMandi> bakmandi = Populasi.bakmandi;  
    private int hargaTujuan = 0;
        
    public Kromosom(Kromosom k){
        this.hargaTujuan = k.getHargaTujuan();
        gen = new Gen[18];
        for (int i=0;i<gen.length;i++){
           gen[i] = k.getGen(i);
        }
    }
    
    public Kromosom(int hargaTujuan){
        //inisialisasi
        gen = new Gen[18];
        
        //inisialisasi kromosom dengan object dari tiap linked list
        Random rnd = new Random();
        setGen(0, new Gen(rangkaAtap.get(rnd.nextInt(rangkaAtap.size()))));
        setGen(1, new Gen(penutupAtap.get(rnd.nextInt(penutupAtap.size()))));
        setGen(2, new Gen(rangkaPlafond.get(rnd.nextInt(rangkaPlafond.size()))));
        setGen(3, new Gen(penutupPlafond.get(rnd.nextInt(penutupPlafond.size()))));
        setGen(4, new Gen(kolom.get(rnd.nextInt(kolom.size()))));
        setGen(5, new Gen(sloof.get(rnd.nextInt(sloof.size()))));
        setGen(6, new Gen(ringBalk.get(rnd.nextInt(ringBalk.size()))));
        setGen(7, new Gen(dindingInterior.get(rnd.nextInt(dindingInterior.size()))));
        setGen(8, new Gen( dindingEksterior.get(rnd.nextInt(dindingEksterior.size()))));
        setGen(9, new Gen(dindingToilet.get(rnd.nextInt(dindingToilet.size()))));
        setGen(10, new Gen(lantaiRuang.get(rnd.nextInt(lantaiRuang.size()))));
        setGen(11, new Gen(lantaiToilet.get(rnd.nextInt(lantaiToilet.size()))));
        setGen(12, new Gen(pintuRuang.get(rnd.nextInt(pintuRuang.size()))));
        setGen(13, new Gen(pintuToilet.get(rnd.nextInt(pintuToilet.size()))));
        setGen(14, new Gen(jendelaRuang.get(rnd.nextInt(jendelaRuang.size()))));
        setGen(15, new Gen(roster.get(rnd.nextInt(roster.size()))));
        setGen(16, new Gen(closet.get(rnd.nextInt(closet.size()))));
        setGen(17, new Gen(bakmandi.get(rnd.nextInt(bakmandi.size()))));   
        this.hargaTujuan = hargaTujuan;
    }
    
    public int getHargaTujuan(){
        return hargaTujuan;
    }
    
    public String toString(){
        String teks = "";
        for(int i = 0 ; i<18 ; i++){
            teks += getGen(i).cetakGen()+ " ";
        }
        teks += "\nfitness = "+getFitness();
        return teks;
    }
    
    //variable penpug database dari daftar isi gen
   
    public void setGen(int i, Gen g){
        this.gen[i] = g;
    } 
    
    public Gen getGen(int i){
        return gen[i];
    }
    public RangkaAtap getRangkaAtap(){
        return (RangkaAtap)gen[0].getGen();
    }
    public PenutupAtap getPenutupAtap(){
        return (PenutupAtap)gen[1].getGen();
    }
    public RangkaPlafond getRangkaPlafond(){
        return (RangkaPlafond)gen[2].getGen();
    }
    public PenutupPlafond getPenutupPlafond(){
        return (PenutupPlafond)gen[3].getGen();
    }
    public Kolom getKolom(){
        return (Kolom)gen[4].getGen();
    }
    public Sloof getSloof(){
        return (Sloof)gen[5].getGen();
    }
    public RingBalk getRingBalk(){
        return (RingBalk)gen[6].getGen();
    }
    public DindingInterior getDindingInterior(){
        return (DindingInterior)gen[7].getGen();
    }
    public DindingEksterior getDindingEksterior(){
        return (DindingEksterior)gen[8].getGen();
    }
    public DindingToilet getDindingToilet(){
        return (DindingToilet)gen[9].getGen();
    }
    public LantaiRuang getLantaiRuang(){
        return (LantaiRuang)gen[10].getGen();
    }
    public LantaiToilet getLantaiToilet(){
        return (LantaiToilet)gen[11].getGen();
    }
    public PintuRuang getPintuRuang(){
        return (PintuRuang)gen[12].getGen();
    }
    public PintuToilet getPintuToilet(){
        return (PintuToilet)gen[13].getGen();
    }
    public JendelaRuang getJendelaRuang(){
        return (JendelaRuang)gen[14].getGen();
    }
    public Roster getRoster(){
        return (Roster)gen[15].getGen();
    }
    public Closet getCloset(){
        return (Closet)gen[16].getGen();
    }
    public BakMandi getBakMandi(){
        return (BakMandi)gen[17].getGen();
    }
    
    
    //hitung fitness
    public int getFitness(){
        int sum=0;
        
        sum+=92.7 * Integer.parseInt(((RangkaAtap)getGen(0).getGen()).getHarga());
        sum+=225 * Integer.parseInt(((PenutupAtap)getGen(1).getGen()).getHarga());
        sum+=1 * Integer.parseInt(((RangkaPlafond)getGen(2).getGen()).getHarga());
        sum+=1 * Integer.parseInt(((PenutupPlafond)getGen(3).getGen()).getHarga());
        sum+=12 * Integer.parseInt(((Kolom)getGen(4).getGen()).getHarga());
        sum+=17 * Integer.parseInt(((Sloof)getGen(5).getGen()).getHarga());
        sum+=17 * Integer.parseInt(((RingBalk)getGen(6).getGen()).getHarga());
        sum+=1 * Integer.parseInt(((DindingInterior)getGen(7).getGen()).getHarga());
        sum+=1 * Integer.parseInt(((DindingEksterior)getGen(8).getGen()).getHarga());
        sum+=(2.80 * 4)/2/
             (Integer.parseInt(((DindingToilet)getGen(9).getGen()).getPanjang()) * 
             Integer.parseInt(((DindingToilet) getGen(9).getGen()).getLebar())) * 
             Integer.parseInt(((DindingToilet)getGen(9).getGen()).getHarga());
        sum+=56.87/(Integer.parseInt(((LantaiRuang)getGen(10).getGen()).getPanjang()) * 
                Integer.parseInt(((LantaiRuang) getGen(10).getGen()).getLebar())) * 
                Integer.parseInt(((LantaiRuang)getGen(10).getGen()).getHarga());
       
        sum+=2.62/(Double.parseDouble(((LantaiToilet)getGen(11).getGen()).getPanjang()) * 
                Double.parseDouble(((LantaiToilet) getGen(11).getGen()).getLebar())) * 
                Integer.parseInt(((LantaiToilet)getGen(11).getGen()).getHarga());
        sum+=5 * Integer.parseInt(((PintuRuang)getGen(12).getGen()).getHarga());
        sum+=1 * Integer.parseInt(((PintuToilet)getGen(13).getGen()).getHarga());
        sum+=10 * Integer.parseInt(((JendelaRuang)getGen(14).getGen()).getHarga());
        sum+=2 * Integer.parseInt(((Roster)getGen(15).getGen()).getHarga());
        sum+=1 * Integer.parseInt(((Closet)getGen(16).getGen()).getHarga());
        sum+=1 * Integer.parseInt(((BakMandi)getGen(17).getGen()).getHarga());
        
        return hargaTujuan-sum;
    }
    
   
    
   
    
    
    // cetak kromosom
//    public String cetakKromosom(){
//        String isikromosom="";
//        for(int i = 0; i<18; i++){
//            isikromosom = gen[i].cetakGen()+" ";
//        }   
//        return isikromosom;
//    }
}

    
//}
