package pojo;

public class Movie {
        public static final int CHILDRENS = 2 ;     //儿童片
        public static final int REGULAR = 0 ;       //普通片
        public static final int NEW_RELEASE = 1 ;   //新片

        private String _title;
        private  int _priceCode;
        private Price _price;

        public Movie(String title, int priceCode) {
            this._title = title;
            setPriceCode(priceCode);
        }

        public String getTitle() {
            return _title;
        }

        public void setTitle(String _title) {
            this._title = _title;
        }

        public int getPriceCode() {
            return _price.getPriceCode();
        }

        public void setPriceCode(int _priceCode) {
            switch (_priceCode){
                case REGULAR:
                    _price = new RegularPrice();
                    break;
                case NEW_RELEASE:
                    _price = new NewReleasePrice();
                    break;
                case CHILDRENS:
                    _price = new ChildrensPrice();
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect Price code!");
            }
        }

    double getCharge(int daysRented){
       return _price.getCharge(daysRented);
    }
    int getFrequentRenterPoints(int daysRented) {

        return _price.getFrequentRenterPoints(daysRented);
    }
}
