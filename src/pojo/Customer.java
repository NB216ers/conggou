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
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //determine amounts for each line
            thisAmount = amountFor(each);

            //add frequent renter points
            frequentRenterPoints ++ ;
            //add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) {
                frequentRenterPoints ++;
            }

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "you earned " + String.valueOf(frequentRenterPoints) +
                "frequent renter points";
        return result;
    }

    private double amountFor (Rental aRental){
        double result = 0 ;

        switch (aRental.getMovie().getPriceCode()){
            case Movie.REGULAR:
                result += 2;
                if (aRental.getDaysRented() > 2) {
                    result += (aRental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (aRental.getDaysRented() > 3) {
                    result += (aRental.getDaysRented() - 3 ) * 1.5;
                }
                break;
        }
        return result ;
    }
}

