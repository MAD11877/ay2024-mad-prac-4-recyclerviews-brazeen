package sg.edu.np.mad.madpractical4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //ArrayList<User> userlist;
    //boolean userfollowed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*
        BroadcastReceiver listener = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                userlist = intent.getParcelableArrayListExtra("userlist");
            }
        };
        */


        //use data from user1
        TextView nameview = findViewById(R.id.TextView2);
        TextView descview = findViewById(R.id.TextView3);
        Button followbtn = findViewById(R.id.Button1);

        Intent receivingEnd = getIntent();
        String username = receivingEnd.getStringExtra("name");
        String userdescription = receivingEnd.getStringExtra("description");
        /*
        for(int i = 0; i < userlist.size(); i++){
            if (userlist.get(i).getName().equals(username)){
                userfollowed = userlist.get(i).getFollowed();
            }
        }

         */
        nameview.setText(username);
        descview.setText(userdescription);
        followbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (0==0){
                    followbtn.setText("UNFOLLOW");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else{
                    followbtn.setText("FOLLOW");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });









    }
}