package com.pucese.appturistica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.pucese.appturistica.view.ContainerActivity;
import com.pucese.appturistica.view.vista1;

public class LoginActivity extends AppCompatActivity {

    //Variables globales
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditTextEmail= (EditText) findViewById(R.id.username);
        mEditTextPassword = (EditText) findViewById(R.id.password);
        mButtonLogin = (Button) findViewById(R.id.login);


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "";
                String password = "";
                mAuth = FirebaseAuth.getInstance();

                email = mEditTextEmail.getText().toString();
                password = mEditTextPassword.getText().toString();
                if(!email.isEmpty() && !password.isEmpty()){
                    loginUser(mAuth, email, password);
                }else{
                    Toast.makeText(LoginActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //-----------------------------------------------
    }

    private void loginUser(FirebaseAuth btnAuth, String email, String password){
        btnAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "No es posible iniciar sesión, compruebe sus datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Iniciar( View view){
        Intent i = new Intent(this,InicioSesionActivity.class);
        startActivity(i);
    }

    public void Registrarse( View view){
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
    }

}
