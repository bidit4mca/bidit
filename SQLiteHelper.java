package com.example.ksb.bid_it;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

    public class SQLiteHelper extends SQLiteOpenHelper {


        static String DATABASE_NAME="UserDataBase";

        public static final String TABLE_NAME="registration_tab";
        public static final String Table_Column_ID="ID";
        public static final String Table_Column_Name="name";

        public static final String Table_Column_1_Age="age";

        public static final String Table_Column_2_Gender="gender";
        public static final String Table_Column_3_Phoneno="phoneno";

        public static final String Table_Column_4_Email="email";
        public static final String Table_Column_5_Username="username";
        public static final String Table_Column_6_Password="password";

        public SQLiteHelper(Context context) {

            super(context, DATABASE_NAME, null, 1);

        }


        public void onCreate(SQLiteDatabase database) {

            String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_Name+" VARCHAR, "+Table_Column_1_Age+" INTEGER, "+Table_Column_2_Gender+" VARCHAR, "+Table_Column_3_Phoneno+" INTEGER,"+Table_Column_4_Email+" VARCHAR, "+Table_Column_5_Username+"VARCHAR,"+Table_Column_6_Password+ "INTEGER)";
            database.execSQL(CREATE_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);

        }
        public Cursor viewData()
        {
            SQLiteDatabase db=this.getReadableDatabase();
            String query="Select * from "+TABLE_NAME;
            Cursor cursor=db.rawQuery(query,null);
            return cursor;
        }
        public Cursor viewDetails(String Name)
        {

            SQLiteDatabase db = this.getReadableDatabase();
            String query = "SELECT * FROM " + TABLE_NAME +
                    " WHERE " + Table_Column_Name + " = '" + Name + "'";
            Cursor c = db.rawQuery(query, null);
            return c;
        }
    }



