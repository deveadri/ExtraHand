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


class SignUpActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        val signUpName : EditText = findViewById(R.id.signUpName)
        val signUpEmail : EditText = findViewById(R.id.signUpEmail)
        val signUpPhone : EditText = findViewById(R.id.signUpPhone)
        val signUpPassword : EditText = findViewById(R.id.signUpPassword)
        val signUpCPassword : EditText = findViewById(R.id.signUpCPassword)
        val signUpPasswordLayout : TextInputLayout = findViewById(R.id.signUpPasswordLayout)
        val signUpCPasswordLayout : TextInputLayout = findViewById(R.id.signUpCPasswordLayout)
        val signUpBtn : Button = findViewById(R.id.signUpBtn)
        val signUpProgressbar : ProgressBar = findViewById(R.id.signUpProgressbar)


        val signInText : TextView = findViewById(R.id.signInText)

        signInText.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        signUpBtn.setOnClickListener {
            val name = signUpName.text.toString()
            val email = signUpEmail.text.toString()
            val phone = signUpPhone.text.toString()
            val password = signUpPassword.text.toString()
            val cPassword = signUpCPassword.text.toString()

            signUpProgressbar.visibility = View.VISIBLE
            signUpPasswordLayout.isPasswordVisibilityToggleEnabled = true
            signUpCPasswordLayout.isPasswordVisibilityToggleEnabled = true


            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || cPassword.isEmpty()){
                if (name.isEmpty()){
                    signUpName.error = "Introduce tu nombre"
                }
                if (email.isEmpty()){
                    signUpEmail.error = "Introduce tu email"
                }
                if (phone.isEmpty()){
                    signUpPhone.error = "Introduce tu número de teléfono"
                }
                if (password.isEmpty()){
                    signUpPasswordLayout.isPasswordVisibilityToggleEnabled = false
                    signUpPassword.error = "Introduce tu contraseña"
                }
                if (cPassword.isEmpty()){
                    signUpCPasswordLayout.isPasswordVisibilityToggleEnabled = false
                    signUpCPassword.error = "Las contraseñas no coinciden"
                }
                Toast.makeText(this, "Introduce términos válidos", Toast.LENGTH_SHORT).show()
                signUpProgressbar.visibility = View.GONE
            }else if (!email.matches(emailPattern.toRegex())){
                signUpProgressbar.visibility = View.GONE
                signUpEmail.error = "Introduce una dirección válida de correo elctrónico"
                Toast.makeText(this, "Introduce una dirección válida de correo elctrónico", Toast.LENGTH_SHORT).show()
            }else if (phone.length !=9){
                signUpProgressbar.visibility = View.GONE
                signUpPhone.error = "Introduce un número de teléfono válido"
                Toast.makeText(this, "Introduce un número de teléfono válido", Toast.LENGTH_SHORT).show()
            }else if (password.length <6){
                signUpPasswordLayout.isPasswordVisibilityToggleEnabled = false
                signUpProgressbar.visibility = View.GONE
                signUpPassword.error = "Introduce una contraseña válido de más de 6 dígitos"
                Toast.makeText(this, "Introduce una contraseña válido de más de 6 dígitos", Toast.LENGTH_SHORT).show()
            }else if (password != cPassword){
                signUpCPasswordLayout.isPasswordVisibilityToggleEnabled = false
                signUpProgressbar.visibility = View.GONE
                signUpCPassword.error = "La contraseña no coincide"
                Toast.makeText(this, "La contraseña no coincide", Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        val databaseRef = database.reference.child("users").child(auth.currentUser!!.uid)
                        val users : Users = Users(name, email, phone, auth.currentUser!!.uid)

                        databaseRef.setValue(users).addOnCompleteListener {
                            if (it.isSuccessful){
                                val intent = Intent(this, SignInActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(this, "Ha ocurrido un error, inténtalo de nuevo", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        Toast.makeText(this, "Ha ocurrido un error, inténtalo de nuevo", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }

    }
}