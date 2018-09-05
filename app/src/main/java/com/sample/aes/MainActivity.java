package com.sample.aes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            AesCbcWithIntegrity.SecretKeys keys = AesCbcWithIntegrity.generateKey();
            String keyInString = AesCbcWithIntegrity.keyString(keys);
            AesCbcWithIntegrity.CipherTextIvMac cipherTextIvMac =
                    AesCbcWithIntegrity.encrypt("some test", keys);
            //store or send to server
            String ciphertextString = cipherTextIvMac.toString();
            Log.d("EncSaleh", ciphertextString);
            Log.d("EncSaleh key:", keyInString);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
