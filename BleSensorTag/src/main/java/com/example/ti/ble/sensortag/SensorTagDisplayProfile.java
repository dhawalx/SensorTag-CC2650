/**************************************************************************************************
 Filename:       SensorTagDisplayProfile.java

 Copyright (c) 2013 - 2015 Texas Instruments Incorporated

 All rights reserved not granted herein.
 Limited License.

 Texas Instruments Incorporated grants a world-wide, royalty-free,
 non-exclusive license under copyrights and patents it now or hereafter
 owns or controls to make, have made, use, import, offer to sell and sell ("Utilize")
 this software subject to the terms herein.  With respect to the foregoing patent
 license, such license is granted  solely to the extent that any such patent is necessary
 to Utilize the software alone.  The patent license shall not apply to any combinations which
 include this software, other than combinations with devices manufactured by or for TI ('TI Devices').
 No hardware patent is licensed hereunder.

 Redistributions must preserve existing copyright notices and reproduce this license (including the
 above copyright notice and the disclaimer and (if applicable) source code license limitations below)
 in the documentation and/or other materials provided with the distribution

 Redistribution and use in binary form, without modification, are permitted provided that the following
 conditions are met:

 * No reverse engineering, decompilation, or disassembly of this software is permitted with respect to any
 software provided in binary form.
 * any redistribution and use are licensed by TI for use only with TI Devices.
 * Nothing shall obligate TI to provide you with source code for the software licensed and provided to you in object code.

 If software source code is provided to you, modification and redistribution of the source code are permitted
 provided that the following conditions are met:

 * any redistribution and use of the source code, including any resulting derivative works, are licensed by
 TI for use only with TI Devices.
 * any redistribution and use of any object code compiled from the source code and any resulting derivative
 works, are licensed by TI for use only with TI Devices.

 Neither the name of Texas Instruments Incorporated nor the names of its suppliers may be used to endorse or
 promote products derived from this software without specific prior written permission.

 DISCLAIMER.

 THIS SOFTWARE IS PROVIDED BY TI AND TI'S LICENSORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL TI AND TI'S LICENSORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 POSSIBILITY OF SUCH DAMAGE.


 **************************************************************************************************/
package com.example.ti.ble.sensortag;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.CompoundButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;

import com.example.ti.ble.btsig.profiles.DeviceInformationServiceTableRow;
import com.example.ti.ble.common.BluetoothLeService;
import com.example.ti.ble.common.GenericBluetoothProfile;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SensorTagDisplayProfile extends GenericBluetoothProfile {
   // public static final String TI_SENSORTAG_TWO_DISPLAY_SERVICE_UUID = "f000ad00-0451-4000-b000-000000000000";
   // public static final String TI_SENSORTAG_TWO_DISPLAY_DATA_UUID = "f000ad01-0451-4000-b000-000000000000";
  //  public static final String TI_SENSORTAG_TWO_DISPLAY_CONTROL_UUID = "f000ad02-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_SERVICE_UUID = "f000aa64-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_DATA_UUID = "f000aa65-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_CONTROL_UUID = "f000aa66-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_SCH3_UUID = "f000aa67-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_SCH4_UUID = "f000aa68-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_SCH5_UUID = "f000aa69-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_SCH6_UUID = "f000aa70-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_SCH7_UUID = "f000aa71-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_SCH8_UUID = "f000aa72-0451-4000-b000-000000000000";
    public static final String TI_SENSORTAG_TWO_DISPLAY_SCH9_UUID = "f000aa73-0451-4000-b000-000000000000";


    SensorTagDisplayTableRow cRow;
    Timer displayClock;
    //Button button;
    public SensorTagDisplayProfile(Context con,BluetoothDevice device,BluetoothGattService service,BluetoothLeService controller) {

        super(con, device, service, controller);
        this.cRow = new SensorTagDisplayTableRow(con);
        this.tRow = this.cRow;


        //super(con,device,service,controller);
        //this.tRow =  new DeviceInformationServiceTableRow(con);

        List<BluetoothGattCharacteristic> characteristics = this.mBTService.getCharacteristics();

        for (BluetoothGattCharacteristic c : characteristics) {
            //65
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_DATA_UUID)) {
                this.dataC = c;
            }
            //66
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_CONTROL_UUID)) {
                this.configC = c;
            }
            //67
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_SCH3_UUID)) {
                this.sch3C = c;
            }
            //68
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_SCH4_UUID)) {
                this.sch4C = c;
            }
            //69
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_SCH5_UUID)) {
                this.sch5C = c;
            }
            //70
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_SCH6_UUID)) {
                this.sch6C = c;
            }
            //71
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_SCH7_UUID)) {
                this.sch7C = c;
            }
            //72
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_SCH8_UUID)) {
                this.sch8C = c;
            }
            //73
            if (c.getUuid().toString().equals(TI_SENSORTAG_TWO_DISPLAY_SCH9_UUID)) {
                this.sch9C = c;
            }

            //tRow.title.setText(c.toString());
            tRow.sl1.setVisibility(View.INVISIBLE);
            this.tRow.setIcon(this.getIconPrefix(), service.getUuid().toString());
        }
        //65
        this.cRow.displayText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (dataC != null) {
                    int error = mBTLeService.writeCharacteristic(dataC, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing data characteristic !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //66
        this.cRow.display66Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (configC != null) {
                    int error = mBTLeService.writeCharacteristic(configC, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing configC !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //67
        this.cRow.display67Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (sch3C != null) {
                    int error = mBTLeService.writeCharacteristic(sch3C, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing sch3C !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //68
        this.cRow.display68Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (sch4C != null) {
                    int error = mBTLeService.writeCharacteristic(sch4C, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing sch3C !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //69
        this.cRow.display69Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (sch5C != null) {
                    int error = mBTLeService.writeCharacteristic(sch5C, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing sch3C !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //70
        this.cRow.display70Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (sch6C != null) {
                    int error = mBTLeService.writeCharacteristic(sch6C, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing sch3C !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //71
        this.cRow.display71Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (sch7C != null) {
                    int error = mBTLeService.writeCharacteristic(sch7C, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing sch3C !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //72
        this.cRow.display72Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (sch8C != null) {
                    int error = mBTLeService.writeCharacteristic(sch8C, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing sch3C !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //73
        this.cRow.display73Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("SensorTagDisplayProfile", "New Display Text:" + s);
                byte[] p = new byte[s.length()];
                for (int ii = 0; ii < s.length(); ii++) {
                    p[ii] = (byte) s.charAt(ii);
                }
                if (sch9C != null) {
                    int error = mBTLeService.writeCharacteristic(sch9C, p);
                    if (error != 0) {
                        Log.d("SensorTagDisplayProfile", "Error writing sch3C !");
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        //65
        this.cRow.displayText.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View arg0) {
              mBTLeService.readCharacteristic(dataC);
              Log.d("Display","OnClick-dataC");

          }
        });
        //66
        this.cRow.display66Text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBTLeService.readCharacteristic(configC);
                Log.d("Display","OnClick-configC");
            }
        });
        //67
        this.cRow.display67Text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBTLeService.readCharacteristic(sch3C);
                Log.d("Display","OnClick-sch3C");
            }
        });
        //68
        this.cRow.display68Text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBTLeService.readCharacteristic(sch4C);
                Log.d("Display","OnClick-sch3C");
            }
        });
        //69
        this.cRow.display69Text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBTLeService.readCharacteristic(sch5C);
                Log.d("Display","OnClick-sch3C");
            }
        });
        //70
        this.cRow.display70Text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBTLeService.readCharacteristic(sch6C);
                Log.d("Display","OnClick-sch3C");
            }
        });
        //71
        this.cRow.display71Text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBTLeService.readCharacteristic(sch7C);
                Log.d("Display","OnClick-sch3C");
            }
        });
        //72
        this.cRow.display72Text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBTLeService.readCharacteristic(sch8C);
                Log.d("Display","OnClick-sch3C");
            }
        });
        //73
        this.cRow.display73Text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mBTLeService.readCharacteristic(sch9C);
                Log.d("Display","OnClick-sch9C");
            }
        });

    }

    public static boolean isCorrectService(BluetoothGattService service) {
        if ((service.getUuid().toString().compareTo(TI_SENSORTAG_TWO_DISPLAY_SERVICE_UUID.toString())) == 0) {
            return true;
        }
        else return false;
    }
    private String getValueSafe(BluetoothGattCharacteristic c) {
        byte b[] = c.getValue();
        if (b == null) {
            b = "N/A".getBytes(Charset.forName("UTF-8"));
        }
        try {
            return new String(b, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
    @Override
    public void enableService () {

        this.mBTLeService.readCharacteristic(this.dataC);
        mBTLeService.waitIdle(GATT_TIMEOUT);
        this.mBTLeService.readCharacteristic(this.configC);
        mBTLeService.waitIdle(GATT_TIMEOUT);
        this.mBTLeService.readCharacteristic(this.sch3C);
        mBTLeService.waitIdle(GATT_TIMEOUT);
        this.mBTLeService.readCharacteristic(this.sch4C);
        mBTLeService.waitIdle(GATT_TIMEOUT);
        this.mBTLeService.readCharacteristic(this.sch5C);
        mBTLeService.waitIdle(GATT_TIMEOUT);
        this.mBTLeService.readCharacteristic(this.sch6C);
        mBTLeService.waitIdle(GATT_TIMEOUT);
        this.mBTLeService.readCharacteristic(this.sch7C);
        mBTLeService.waitIdle(GATT_TIMEOUT);
        this.mBTLeService.readCharacteristic(this.sch8C);
        mBTLeService.waitIdle(GATT_TIMEOUT);
        this.mBTLeService.readCharacteristic(this.sch9C);
        mBTLeService.waitIdle(GATT_TIMEOUT);

        /*if (this.cRow.displayClock.isChecked()) {
            if (displayClock != null) {
                displayClock.cancel();
            }
            displayClock = new Timer();
            displayClock.schedule(new clockTask(),1000,1000);
        }*/
    }
    @Override
    public void disableService () {
        if (displayClock != null) {
            displayClock.cancel();
        }
    }
    @Override
    public void configureService() {

    }
    @Override
    public void deConfigureService() {

    }
    @Override
    public void didUpdateValueForCharacteristic(BluetoothGattCharacteristic c) {
        //65
        if (this.dataC != null) {
            if (c.equals(this.dataC)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.displayText1.setText("" + getValueSafe(c));
            }
        }
        //66
        if (this.configC != null) {
            if (c.equals(this.configC)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display66Text1.setText("" + getValueSafe(c));
            }
        }
        //67
        if (this.sch3C != null) {
            if (c.equals(this.sch3C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display67Text1.setText("" + getValueSafe(c));
            }
        }
        //68
        if (this.sch4C != null) {
            if (c.equals(this.sch4C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display68Text1.setText("" + getValueSafe(c));
            }
        }
        //69
        if (this.sch5C != null) {
            if (c.equals(this.sch5C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display69Text1.setText("" + getValueSafe(c));
            }
        }
        //70
        if (this.sch6C != null) {
            if (c.equals(this.sch6C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display70Text1.setText("" + getValueSafe(c));
            }
        }
        //71
        if (this.sch7C != null) {
            if (c.equals(this.sch7C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display71Text1.setText("" + getValueSafe(c));
            }
        }
        //72
        if (this.sch8C != null) {
            if (c.equals(this.sch8C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display72Text1.setText("" + getValueSafe(c));
            }
        } //73
        if (this.sch9C != null) {
            if (c.equals(this.sch9C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display73Text1.setText("" + getValueSafe(c));
            }
        }
    }


    @Override
    public void didReadValueForCharacteristic(BluetoothGattCharacteristic c) {
        //65
        if (this.dataC != null) {
            if (c.equals(this.dataC)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.displayText1.setText("" + getValueSafe(c));
            }
        }
        //66
        if (this.configC != null) {
            if (c.equals(this.configC)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display66Text1.setText("" + getValueSafe(c));
            }
        }
        //67
        if (this.sch3C != null) {
            if (c.equals(this.sch3C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display67Text1.setText("" + getValueSafe(c));
            }
        }
        //68
        if (this.sch4C != null) {
            if (c.equals(this.sch4C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display68Text1.setText("" + getValueSafe(c));
            }
        }
        //69
        if (this.sch5C != null) {
            if (c.equals(this.sch5C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display69Text1.setText("" + getValueSafe(c));
            }
        }
        //70
        if (this.sch6C != null) {
            if (c.equals(this.sch6C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display70Text1.setText("" + getValueSafe(c));
            }
        }
        //71
        if (this.sch7C != null) {
            if (c.equals(this.sch7C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display71Text1.setText("" + getValueSafe(c));
            }
        }
        //72
        if (this.sch8C != null) {
            if (c.equals(this.sch8C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display72Text1.setText("" + getValueSafe(c));
            }
        }
        //73
        if (this.sch9C != null) {
            if (c.equals(this.sch9C)) {
                //this.tRow.ModelNRLabel.setText("Model NR: " + getValueSafe(c));
                cRow.display73Text1.setText("" + getValueSafe(c));
            }
        }
    }
}
