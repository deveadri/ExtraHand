package com.example.extrahand5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        auth = FirebaseAuth.getInstance()

        val signInEmail : EditText = findViewById(R.id.signInEmail)
        val signInPassword : EditText = findViewById(R.id.signInPassword)
        val signInPasswordLayout : TextInputLayout = findViewById(R.id.signInPasswordLayout)
        val signInBtn : Button = findViewById(R.id.signInBtn)
        val signInProgressbar : ProgressBar = findViewById(R.id.signInProgressbar)

        val signUpText : TextView = findViewById(R.id.signUpText)

        signUpText.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        signInBtn.setOnClickListener {
            signInProgressbar.visibility = View.GONE
            signInPasswordLayout.isPasswordVisibilityToggleEnabled = true

            val email = signInEmail.text.toString()
            val password = signInPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                if (email.isEmpty()){
                    signInEmail.error = "Introduce tu dirección de correo electrónico"
                }
                if (password.isEmpty()){
                    signInPassword.error = "Introduce tu contraseña"
                    signInPasswordLayout.isPasswordVisibilityToggleEnabled = false
                }
                signInProgressbar.visibility = View.GONE
                Toast.makeText(this, "Introduce datos válidos", Toast.LENGTH_SHORT).show()
            }else if (!email.matches(emailPattern.toRegex())){
                signInProgressbar.visibility = View.GONE
                signInEmail.error = "Introduce una dirección válida de correo elctrónico"
                Toast.makeText(this, "Introduce una dirección válida de correo elctrónico", Toast.LENGTH_SHORT).show()
            }else if (password.length <6){
                signInPasswordLayout.isPasswordVisibilityToggleEnabled = false
                signInProgressbar.visibility = View.GONE
                signInPassword.error = "Introduce una contraseña válido de más de 6 dígitos"
                Toast.makeText(this, "Introduce una contraseña válido de más de 6 dígitos", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        val intent = Intent(this, FrontPage::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Ha ocurrido un error, inténtalo de nuevo", Toast.LENGTH_SHORT).show()
                        signInProgressbar.visibility = View.GONE
                    }
                }
            }
        }
    }
}