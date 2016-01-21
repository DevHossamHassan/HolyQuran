package me.branded.hossamhassan.holyquran.Utils;

/**
 * Created by HossamHassan on 1/7/2016.
 */
public class Favorites {
    private int _pageNum;
    private boolean _fav;

    public Favorites(int _pageNum) {
        this._pageNum = _pageNum;
        this._fav =true;
    }

    public boolean is_fav() {
        return _fav;
    }

    public void set_fav(boolean _fav) {
        this._fav = _fav;
    }

    public int get_pageNum() {
        return _pageNum;
    }

    public void set_pageNum(int _pageNum) {
        this._pageNum = _pageNum;
    }
}

