/*
 * Copyright (C) 2015 The SudaMod project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.android.dialer;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.suda.location.PhoneLocation;

public class LocationLookupActivity extends Activity {

    private Button btlookup;
    private EditText etphone;
    private TextView tvlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonelocation);

        btlookup = (Button) findViewById(R.id.lookup);
        etphone  = (EditText) findViewById( R.id.phone);
        tvlocation = (TextView) findViewById(R.id.location);

        btlookup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String pl = PhoneLocation.getCityFromPhone(etphone.getText().toString());
                String phonelocation_tip = (String) LocationLookupActivity.this.getResources().getText(R.string.phonelocation_tip);
                String location_unknow = (String) LocationLookupActivity.this.getResources().getText(R.string.location_unknow);

                if (TextUtils.isEmpty(pl)) {
                    tvlocation.setText(phonelocation_tip + location_unknow);
                } else{
                    tvlocation.setText(phonelocation_tip + pl );
                }

            }
        });

    }

	@Override
	public void setTitle(int titleId) {
		super.setTitle(R.string.phonelocation);
	}

}