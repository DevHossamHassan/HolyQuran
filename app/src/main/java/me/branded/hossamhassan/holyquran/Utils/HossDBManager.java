package me.branded.hossamhassan.holyquran.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.branded.hossamhassan.holyquran.HolyQuranConstants;

/**
 * Created by HossamHassan on 1/7/2016.
 */
public class HossDBManager  extends SQLiteOpenHelper{
    public static final String TABLE_PAGES="pages";
    public static final String COLUMN_PAGE_NUM="_pageNum";
    public static final String COLUMN_PAGE_FAV="fav";
    public static final String TABLE_FAVORITES="favorites";
    public static final String COLUMN_FAVORITES__PAGE_NUM="_pageNum";
    public static final String COLUMN_FAVORITES_FAV="fav";
    public static final String TABLE_TAGS="tags";
    public static final String COLUMN_TAGS_ID="_id";
    public static final String COLUMN_TAGS_WORD="tagWord";
    public static final String COLUMN_TAGS_PAGE_NUM="pageNum";
    public static final String TABLE_TAG_WORDS="tagWords";
    public static final String COLUMN_TAG_WORDS_ID="_id";
    public static final String COLUMN_TAG_WORDS_WORD="_word";
    public static final String TABLE_NOTES="notes";
    public static final String COLUMN_NOTES_ID="_id";
    public static final String COLUMN_NOTES_PAGE_NUM="pageNum";
    public static final String COLUMN_NOTES_TITLE="title";
    public static final String COLUMN_NOTES_DESCRIPTION="description";
    private static final String TAG= HolyQuranConstants.TAG;
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="HolyQuran.db";


    public HossDBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    private static String createPagesTable()
    {
        String query="CREATE TABLE "+TABLE_PAGES+" ("+
                COLUMN_PAGE_NUM+" INTEGER PRIMARY KEY ,"+
                COLUMN_PAGE_FAV+" BOOLEAN"+
                ");";
        return query;
    }

    private static String createFavoritesTable()
    {
        String query="CREATE TABLE "+TABLE_FAVORITES+" ("+
                COLUMN_FAVORITES__PAGE_NUM+" INTEGER PRIMARY KEY ,"+
                COLUMN_FAVORITES_FAV+" BOOLEAN"+
                ");";
        return query;
    }

    private static String createTagWordsTable()
    {
        String query="CREATE TABLE "+TABLE_TAG_WORDS+" ("+
                COLUMN_TAG_WORDS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                COLUMN_TAG_WORDS_WORD+" TEXT "+
                ");";
        return query;
    }

    private static String createTagsTable()
    {
        String query="CREATE TABLE "+TABLE_TAGS+" ("+
                COLUMN_TAGS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                COLUMN_TAGS_PAGE_NUM+" INTEGER ,"+
                COLUMN_TAGS_WORD+" TEXT "+
                ");";
        return query;
    }

    private static String createNotesTable()
    {
        String query="CREATE TABLE "+TABLE_NOTES+" ("+
                COLUMN_NOTES_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                COLUMN_NOTES_PAGE_NUM+" INTEGER ,"+
                COLUMN_NOTES_TITLE+ " TEXT ,"+
                COLUMN_NOTES_DESCRIPTION+ " TEXT "+
                ");";
        return query;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createFavoritesTable());
        db.execSQL(createTagWordsTable());
        db.execSQL(createTagsTable());
        db.execSQL(createNotesTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PAGES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FAVORITES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NOTES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TAG_WORDS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TAGS);

        onCreate(db);
    }

    public void addFavorite(Favorites fav)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_FAVORITES__PAGE_NUM,fav.get_pageNum());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_FAVORITES,null,values);
        db.close();
    }
    public void deleteFavorite(int pageNum)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="DELETE FROM "+TABLE_FAVORITES+" WHERE "+COLUMN_FAVORITES__PAGE_NUM+" ="+pageNum+";";
        db.execSQL(query);
    }
    public String getFavoritesAsString()
    {
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_FAVORITES+" WHERE 1";//1 MEANS SELECT EVERY SELSECT ALL EVERY COLUMN AND EVERY ROW
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
/*
        Log.d(TAG, "getFavoritesAsString: c.getColumnCount : " + c.getColumnCount());
        Log.d(TAG, "getFavoritesAsString: c.getColumnName(0) : "+c.getColumnName(0));
        Log.d(TAG, "getFavoritesAsString: c.getColumnName(0) : "+c.getColumnName(1));
        Log.d(TAG, "getFavoritesAsString: c.getColumnName(0) : "+c.getString(c.getColumnIndex(COLUMN_FAVORITES__PAGE_NUM)));
*/


        while (!c.isAfterLast())
        {
            if (c.getString(c.getColumnIndex(COLUMN_FAVORITES__PAGE_NUM))!=null)
            {
                dbString+=c.getString(c.getColumnIndex(COLUMN_FAVORITES__PAGE_NUM));
                dbString+="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
    public List<Integer> getFavoritesAsList()
    {
        List favs=new ArrayList<Integer>();
        int temp;
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_FAVORITES+" WHERE 1";//1 MEANS SELECT EVERY SELSECT ALL EVERY COLUMN AND EVERY ROW
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            if (c.getString(c.getColumnIndex(COLUMN_FAVORITES__PAGE_NUM))!=null)
            {
                temp=c.getInt(c.getColumnIndex(COLUMN_FAVORITES__PAGE_NUM));
                favs.add(temp);
            }
            c.moveToNext();
        }
        db.close();
        return favs;
    }
    public void addNote(Notes note)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_NOTES_PAGE_NUM,note.getPageNum());
        values.put(COLUMN_NOTES_TITLE,note.getTitle());
        values.put(COLUMN_NOTES_DESCRIPTION, note.getDescription());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NOTES, null, values);
        db.close();
    }
    public void deleteNote(int id)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="DELETE FROM "+TABLE_NOTES+" WHERE "+COLUMN_NOTES_ID+" ="+id+";";
        db.execSQL(query);
    }
    public List<Notes> getNotesAsList()
    {
        List<Notes> notes=new ArrayList();
        Notes note;
        String tit="",des="";
        int id=-1,pN=-1;
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NOTES+" WHERE 1";//1 MEANS SELECT EVERY SELSECT ALL EVERY COLUMN AND EVERY ROW
        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            note=new Notes();
            if (c.getString(c.getColumnIndex(COLUMN_NOTES_ID))!=null) {
                id=c.getInt(c.getColumnIndex(COLUMN_NOTES_ID));
            }
            if (c.getString(c.getColumnIndex(COLUMN_NOTES_PAGE_NUM))!=null)
            {
                pN=c.getInt(c.getColumnIndex(COLUMN_NOTES_PAGE_NUM));
            }
            if (c.getString(c.getColumnIndex(COLUMN_NOTES_TITLE))!=null)
            {
                tit=c.getString(c.getColumnIndex(COLUMN_NOTES_TITLE));
            }
            if (c.getString(c.getColumnIndex(COLUMN_NOTES_DESCRIPTION))!=null)
            {
                des=c.getString(c.getColumnIndex(COLUMN_NOTES_DESCRIPTION));
            }
            note.set_id(id);
            note.setPageNum(pN);
            note.setTitle(tit);
            note.setDescription(des);
            notes.add(note);
            Log.d(TAG, "getNotesAsList: "+note.toString());
            c.moveToNext();
        }
        Log.d(TAG, "getNotesAsList: "+notes.toString());

        db.close();
        return notes;
    }

    public void addTagWord(TagWords tagWord)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_TAG_WORDS_WORD,tagWord.get_word());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_TAG_WORDS, null, values);
        db.close();
    }
    public void deleteTagWord(String tagWord)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="DELETE FROM "+TABLE_TAG_WORDS+" WHERE "+COLUMN_TAG_WORDS_WORD+" =\""+tagWord+"\";";
        db.execSQL(query);
    }
    public List<String> getTagWordsAsList()
    {

        List tagWords=new ArrayList<String>();
        String word;
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_TAG_WORDS+" WHERE 1";//1 MEANS SELECT EVERY SELSECT ALL EVERY COLUMN AND EVERY ROW
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            if (c.getString(c.getColumnIndex(COLUMN_TAG_WORDS_WORD))!=null)
            {
                word=c.getString(c.getColumnIndex(COLUMN_TAG_WORDS_WORD));
                tagWords.add(word);
            }
            c.moveToNext();
        }
        db.close();
        return tagWords;
    }
    public void addTag(Tags tag)
    {
        ContentValues values=new ContentValues();
        values.put(COLUMN_TAGS_PAGE_NUM,tag.getPageNum());
        values.put(COLUMN_TAGS_WORD,tag.getTag());
        SQLiteDatabase db=getWritableDatabase();
        db.insert(TABLE_NOTES, null, values);
        db.close();
    }
    public void deleteTag(int id)
    {
        SQLiteDatabase db=getWritableDatabase();
        String query="DELETE FROM "+TABLE_TAGS+" WHERE "+COLUMN_TAGS_ID+" ="+id+";";
        db.execSQL(query);
    }

    public List<Tags> getTagsAsList()
    {
        List<Tags> tags=new ArrayList();
        Tags tag=new Tags();
        String tagWord="";
        int id=-1,pN=-1;
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+TABLE_TAGS+" WHERE 1";//1 MEANS SELECT EVERY SELSECT ALL EVERY COLUMN AND EVERY ROW
        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            if (c.getString(c.getColumnIndex(COLUMN_TAGS_ID))!=null) {
                id=c.getInt(c.getColumnIndex(COLUMN_TAGS_ID));
            }
            if (c.getString(c.getColumnIndex(COLUMN_TAGS_PAGE_NUM))!=null)
            {
                pN=c.getInt(c.getColumnIndex(COLUMN_TAGS_PAGE_NUM));
            }
            if (c.getString(c.getColumnIndex(COLUMN_TAGS_WORD))!=null)
            {
                tagWord=c.getString(c.getColumnIndex(COLUMN_TAGS_WORD));
            }

            tag.set_id(id);
            tag.setPageNum(pN);
            tag.setTag(tagWord);
            tags.add(tag);
            c.moveToNext();
        }
        db.close();
        return tags;
    }
}
