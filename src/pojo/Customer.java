package pojo;
/**
 * 这是一个影店出租程序，计算每位顾客的消费金额并打印详单。操作者告诉程序：顾客租了哪些影片，租期多长，程序便根据影片类型和租期
 * 算出费用。影片分为三类：普通片，儿童片和新片。除了计算费用，还要为常客计算积分，积分会根据租片种类是否为新片而有所不同。
 */

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public String get_name() {
        return _name;
    }
    public void addRental (Rental arg) {
        _rentals.addElement(arg);
    }



    public String statement () {
        double totalAmount = 0 ;        //费用
        int frequentRenterPoints = 0 ;  //常客积分
        Enumeration rentals = _rentals.elements();
        String result = " Rental Record for " + get_name() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "you earned " + String.valueOf(frequentRenterPoints) +
                "frequent renter points";
        return result;
    }



}

