package schronic.xfoodfinder;

/**
 * Created by Gredy on 03-Jan-16.
 */
public class RestoList {
    String name,address,jenis,price,distance;
    int rate;

    public RestoList(String name,String address,String jenis,String price,String distance,int rate){
        this.name = name;
        this.address = address;
        this.jenis = jenis;
        this.price = price;
        this.distance = distance;
        this.rate = rate;
    }
}
