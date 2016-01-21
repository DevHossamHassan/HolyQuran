package me.branded.hossamhassan.holyquran.Utils;

/**
 * Created by HossamHassan on 1/7/2016.
 */
public class Pages {

    private int _pageNum;
    private boolean fav;

    public Pages(int _pageNum, boolean fav) {
        this._pageNum = _pageNum;
        this.fav = fav;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public int get_pageNum() {
        return _pageNum;
    }

    public void set_pageNum(int _pageNum) {
        this._pageNum = _pageNum;
    }

}
