package com.pucese.appturistica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    //Variables para los componentes
    private EditText correo;
    private EditText contrasena;
    private EditText nombre;
    private EditText usuario;
    private EditText Confircontrasena;
    private Button mButtonRegister;

    //Variables para las validaciones
    private String name ="";
    private String email ="";
    private String username ="";
    private String password ="";
    private String confpassword ="";

    //----- Variables para firebase
    private DatabaseReference mDatabase;
    private FirebaseFirestore myDB ;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolbar(getResources().getString(R.string.toolbar_createaccount),true);

        mAuth = FirebaseAuth.getInstance();
        try {
            mDatabase = FirebaseDatabase.getInstance().getReference();
            myDB = FirebaseFirestore.getInstance();
        }
        catch ( Exception ex)
        {
            Toast.makeText(getApplicationContext(),"Inicializado: " + ex.getMessage(),Toast.LENGTH_LONG).show();
        }
        correo= findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasena);
        usuario= findViewById(R.id.user);
        nombre = findViewById(R.id.name);
        Confircontrasena = findViewById(R.id.contrasenaConfirm);
        mButtonRegister = (Button) findViewById(R.id.Registrarse);

        //Validaciones
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            name = nombre.getText().toString();
            email = correo.getText().toString();
            username = usuario.getText().toString();
            password = contrasena.getText().toString();
            confpassword = Confircontrasena.getText().toString();

            if (!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !confpassword.isEmpty()){
                if (password.length() >=8){
                    if (password.matches("(.*[0-9].*)")){
                        if (password.matches("(.*[A-Z].*)")){
                            if (password.matches("^(?=.*[_.*()*#!/$&@]).*$")){
                                if (password.equals(confpassword)) {
                                    RegisterUsuario();
                                }else{
                                    Toast.makeText(RegisterActivity.this, "Las contraseñas deben ser iguales", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(RegisterActivity.this, "La contraseña requiere al menos un caracter especial", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this, "La contraseña requiere mayusculas", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "La contraseña requiere al menos un numero", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(RegisterActivity.this, "Debe completar todos los campos correctamente", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }


    public void RegisterUsuario(){
        mAuth.createUserWithEmailAndPassword(correo.getText().toString(),contrasena.getText().toString())
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    try {
                        if (task.isSuccessful()) {
                            String id= mAuth.getCurrentUser().getUid();
                            HashMap<String, Object> result = new HashMap<>();
                            result.put("correo", correo.getText().toString());
                            result.put("usuario", usuario.getText().toString());
                            result.put("nombre", nombre.getText().toString());
                            result.put("contrasena", contrasena.getText().toString());
                            result.put("contrasenaAdicional", Confircontrasena.getText().toString());

                            mDatabase.child("Users").child(id).setValue(result).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task2) {
                                    if(task2.isSuccessful())
                                    {
                                        CollectionReference Users = myDB.collection("Users");
                                        Map<String, Object> data1 = new HashMap<>();
                                        data1.put("correo", correo.getText().toString());
                                        data1.put("usuario", usuario.getText().toString());
                                        data1.put("nombre", nombre.getText().toString());
                                        data1.put("contrasena",contrasena.getText().toString());
                                        data1.put("contrasenaAdicional", Confircontrasena.getText().toString());
                                        Users.document("SF" + mAuth.getCurrentUser().getUid()).set(data1);

                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(getApplicationContext(), "Ingresando usuario creado.",Toast.LENGTH_SHORT).show();
                                        FirebaseUser user = mAuth.getCurrentUser();

                                        Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                                        startActivity(i);
                                        //  updateUI(user);
                                    }
                                    else
                                    {

                                        Toast.makeText(getApplicationContext(), task2.getException().getMessage() , Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                    catch (Exception ex)
                    {
                        Toast.makeText(getApplicationContext(),"Error insert:   " + ex.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
    }

}
