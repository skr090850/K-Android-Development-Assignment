package com.example.authappusingkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class SignInActivity : AppCompatActivity() {
    private lateinit var emailId:EditText
    private lateinit var pass:EditText
    private lateinit var signinbtn:Button
    private lateinit var db:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        val signUpTextbtn = findViewById<TextView>(R.id.signUpTextBtn);
        db=MyApp.database
        emailId = findViewById(R.id.signInEmail)
        pass=findViewById(R.id.signInPass)
        signinbtn=findViewById(R.id.signInBtn)

        signinbtn.setOnClickListener{
            val email=emailId.text.toString()
            val password=pass.text.toString()
            if (email.isNotEmpty()&&password.isNotEmpty()) {
                lifecycleScope.launch {
                    val user = db.userDao().findUser(email, password)
                    if (user != null) {
                        Toast.makeText(this@SignInActivity, "Login Successful!", Toast.LENGTH_SHORT)
                            .show()
                        val intent = Intent(this@SignInActivity, DashboardActivity::class.java)
                        intent.putExtra("EMAIL_ID",user.emaiId)
                        intent.putExtra("FULL_NAME",user.fullName)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@SignInActivity,
                            "Invalid Credential!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            }else{
                Toast.makeText(this@SignInActivity, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        signUpTextbtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}