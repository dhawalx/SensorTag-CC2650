/**************************************************************************************************
 Filename:       SensorTagDisplayTableRow.java

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

import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


import com.example.ti.util.GenericCharacteristicTableRow;

public class SensorTagDisplayTableRow extends GenericCharacteristicTableRow {

    EditText displayText;
    EditText displayText1;

    EditText display66Text;
    EditText display66Text1;

    // CheckBox displayInvert;
    //CheckBox displayClock;
    Button button;
    TextView Senddata;
    TextView Rxdata;
    TextView TX66;
    TextView RX66;


    SensorTagDisplayTableRow(Context con) {
        super(con);
        this.title.setText("Thermostat control");
        this.Senddata = new TextView(con) {
            {
                setText("TX65: -");
                setId(200);
            }
        };
        this.Rxdata = new TextView(con) {
            {
                setText("RX65: -");
                setId(201);
            }
        };
        this.TX66 = new TextView(con) {
            {
                setText("TX66: -");
                setId(202);
            }
        };
        this.RX66 = new TextView(con) {
            {
                setText("RX66: -");
                setId(203);
            }
        };

        this.displayText = new EditText(con);
        this.displayText.setMaxLines(1);
        this.displayText.setInputType(InputType.TYPE_CLASS_TEXT);
        this.displayText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.displayText.setId(600);
        int maxLength = 16;
        this.displayText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.displayText1 = new EditText(con);
        this.displayText1.setMaxLines(1);
        this.displayText1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.displayText1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.displayText1.setId(601);
        //int maxLength = 16;
        this.displayText1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

       //TX66
        this.display66Text = new EditText(con);
        this.display66Text.setMaxLines(1);
        this.display66Text.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display66Text.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display66Text.setId(602);
        //int maxLength = 16;
        this.display66Text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.display66Text1 = new EditText(con);
        this.display66Text1.setMaxLines(1);
        this.display66Text1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display66Text1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display66Text1.setId(603);
        //int maxLength = 16;
        this.display66Text1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        //title TX65
        RelativeLayout.LayoutParams displayTextLayout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayTextLayout0.addRule(RelativeLayout.BELOW,
                this.title.getId());
        displayTextLayout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.Senddata.setLayoutParams(displayTextLayout0);
        //Edit text
        RelativeLayout.LayoutParams displayTextLayout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayTextLayout.addRule(RelativeLayout.BELOW,
                this.Senddata.getId());
        displayTextLayout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.displayText.setLayoutParams(displayTextLayout);
        //Title RX65
        RelativeLayout.LayoutParams displayTextLayout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayTextLayout00.addRule(RelativeLayout.BELOW,
                this.displayText.getId());
        displayTextLayout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.Rxdata.setLayoutParams(displayTextLayout00);
        //Edit Text
        RelativeLayout.LayoutParams displayTextLayout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayTextLayout1.addRule(RelativeLayout.BELOW,
                this.Rxdata.getId());
        displayTextLayout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.displayText1.setLayoutParams(displayTextLayout1);

        //Title TX66
        RelativeLayout.LayoutParams displayText66Layout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText66Layout0.addRule(RelativeLayout.BELOW,
                this.displayText1.getId());
        displayText66Layout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.TX66.setLayoutParams(displayText66Layout0);
        //Edit Text
        RelativeLayout.LayoutParams displayText66Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText66Layout.addRule(RelativeLayout.BELOW,
                this.TX66.getId());
        displayText66Layout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display66Text.setLayoutParams(displayText66Layout);

        //title RX66
        RelativeLayout.LayoutParams displayText66Layout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText66Layout00.addRule(RelativeLayout.BELOW,
                this.display66Text.getId());
        displayText66Layout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.RX66.setLayoutParams(displayText66Layout00);
        //Edit Text
        RelativeLayout.LayoutParams displayText66Layout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText66Layout1.addRule(RelativeLayout.BELOW,
                this.display66Text.getId());
        displayText66Layout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display66Text1.setLayoutParams(displayText66Layout1);


        /* Remove most of the normal controls */

        this.rowLayout.removeAllViews();
        this.rowLayout.addView(this.Senddata);
        this.rowLayout.addView(this.Rxdata);
        this.rowLayout.addView(this.title);
        this.rowLayout.addView(this.icon);
        this.rowLayout.addView(this.displayText);
        this.rowLayout.addView(this.displayText1);
        //66
        this.rowLayout.addView(this.TX66);
        this.rowLayout.addView(this.RX66);
        this.rowLayout.addView(this.display66Text);
        this.rowLayout.addView(this.display66Text1);
    }

}
