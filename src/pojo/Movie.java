package pojo;

public class Movie {
        public static final int CHILDRENS = 2 ;     //儿童片
        public static final int REGULAR = 0 ;       //普通片
        public static final int NEW_RELEASE = 1 ;   //新片

        private String _title;
        private  int _priceCode;

        public Movie(String title, int priceCode) {
            this._title = title;
            this._priceCode = priceCode;
        }

        public String getTitle() {
            return _title;
        }

        public void setTitle(String _title) {
            this._title = _title;
        }

        public int getPriceCode() {
            return _priceCode;
        }

        public void setPriceCode(int _priceCode) {
            this._priceCode = _priceCode;
        }
    }
