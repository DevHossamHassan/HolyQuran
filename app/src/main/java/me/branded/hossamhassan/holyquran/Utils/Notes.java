package me.branded.hossamhassan.holyquran.Utils;

/**
 * Created by HossamHassan on 1/7/2016.
 */
public class Notes {
    private int _id;
    private int pageNum;
    private String title;
    private String description;

    public Notes(int pageNum,String title, String description) {
        this.title = title;
        this.description = description;
        this.pageNum = pageNum;
    }

    public Notes() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
