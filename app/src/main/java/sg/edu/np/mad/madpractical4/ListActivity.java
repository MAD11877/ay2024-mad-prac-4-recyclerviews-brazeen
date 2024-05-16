    package sg.edu.np.mad.madpractical4;

    import android.content.DialogInterface;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageView;
    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.LinearLayoutCompat;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;
    import androidx.recyclerview.widget.DefaultItemAnimator;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.Random;
    import java.util.ArrayList;

    public class ListActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_list);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            ArrayList<User> userlist = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                int name = new Random().nextInt(9999999);
                int description = new Random().nextInt(9999999);
                boolean followed = new Random().nextBoolean();
                User user = new User("John Tan", "MAD Developer", 1,false);
                user.setName("Name"+String.valueOf(name));
                user.setDescription("Description "+String.valueOf(description));
                user.setFollowed(followed);
                userlist.add(user);
            }
            Intent getFollowed = new Intent("senduserdata");
            getFollowed.putExtra("userlist", userlist);
            sendBroadcast(getFollowed);
            //recycler view
            UserAdapter userAdapter = new UserAdapter(userlist, this);
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(userAdapter);

        }
    }