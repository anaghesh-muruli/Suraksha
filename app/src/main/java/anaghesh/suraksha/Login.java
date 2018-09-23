package anaghesh.suraksha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Login extends AppCompatActivity {
    ImageView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.imageView2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Home.class));
                Toasty.success(Login.this, "Login Successful", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}
