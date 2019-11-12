

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog.Builder;

import java.util.Locale;

public class ViewFeedback extends AppCompatActivity {
    Button feedback;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feedback);
        feedback=(Button)findViewById(R.id.button12);
        db=openOrCreateDatabase("FEEDBACK_DB",MODE_PRIVATE,null);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==feedback)
                {
                    Cursor c=db.rawQuery("SELECT * FROM FEEDBACK_DB",null);
                    if (c.getCount()==0)
                    {
                        showMessage("error","please enter your feedback");
                        return;
                    }
                    StringBuffer buffer=new StringBuffer();
                    while ((c.moveToNext()))
                    {
                        buffer.append(c.getString(0)+"\n");
                    }
                    showMessage("FEEDBACK",buffer.toString());
                }
            }
        });

    }
    public  void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
