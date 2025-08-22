package com.example.authappusingkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {
    lateinit var fullname: EditText
    lateinit var emailId:EditText
    lateinit var pass:EditText
    lateinit var confPass:EditText
    lateinit var signupbtn:Button
    private lateinit var db:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        val signInTextbtn = findViewById<TextView>(R.id.signinTextBtn)
        fullname = findViewById(R.id.signUpFullName)
        emailId = findViewById(R.id.signUpEmail)
        pass= findViewById(R.id.signUpPass)
        confPass=findViewById(R.id.signUpConfPass)
        signupbtn=findViewById(R.id.signUpBtn)
        db=MyApp.database

        signupbtn.setOnClickListener{
            val name= fullname.text.toString()
            val email = emailId.text.toString()
            val pwd = pass.text.toString()
            val confpwd=confPass.text.toString()

            lifecycleScope.launch {
                db.userDao().insertUser(UserData(fullName = name, emaiId = email, pass = pwd, confPass = confpwd))
            }
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        signInTextbtn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}