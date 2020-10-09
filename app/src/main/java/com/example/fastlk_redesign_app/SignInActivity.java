package com.example.fastlk_redesign_app;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class SignInActivity extends AppCompatActivity {
    private Button signInBtn;
    private TextView forgotPw;
    AwesomeValidation awesomeValidation;
    TextView signUp;
    ImageView home;
    TextView feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInBtn = findViewById(R.id.signin_btn);
        forgotPw = findViewById(R.id.textView15);
        signUp = findViewById(R.id.textView16);
        feedback = findViewById(R.id.textViewfeedback);
        home = findViewById(R.id.imageView6);

        awesomeValidation = new AwesomeValidation(ValidationStyle.COLORATION);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        awesomeValidation.addValidation(this, R.id.email_et, RegexTemplate.NOT_EMPTY, R.string.email_req_err);
        awesomeValidation.addValidation(this, R.id.email_et, Patterns.EMAIL_ADDRESS, R.string.email_err);
        awesomeValidation.addValidation(this, R.id.pw_et, regexPassword, R.string.pwd_err);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.fastlk_redesign_app.SignInActivity.this, Feedback.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.fastlk_redesign_app.SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    Toast.makeText(SignInActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPw.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, ForgotPwdActivity.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });
    }
}
