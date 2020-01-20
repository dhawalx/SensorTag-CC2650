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

    EditText display67Text;
    EditText display67Text1;

    EditText display68Text;
    EditText display68Text1;

    EditText display69Text;
    EditText display69Text1;

    EditText display70Text;
    EditText display70Text1;

    EditText display71Text;
    EditText display71Text1;

    EditText display72Text;
    EditText display72Text1;

    EditText display73Text;
    EditText display73Text1;

    // CheckBox displayInvert;
    //CheckBox displayClock;
    Button button;
    TextView Senddata;
    TextView Rxdata;
    TextView TX66;
    TextView RX66;
    TextView TX67;
    TextView RX67;
    TextView TX68;
    TextView RX68;
    TextView TX69;
    TextView RX69;
    TextView TX70;
    TextView RX70;
    TextView TX71;
    TextView RX71;
    TextView TX72;
    TextView RX72;
    TextView TX73;
    TextView RX73;

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
        this.TX67 = new TextView(con) {
            {
                setText("TX67: -");
                setId(204);
            }
        };
        this.RX67 = new TextView(con) {
            {
                setText("RX67: -");
                setId(205);
            }
        };
        this.TX68 = new TextView(con) {
            {
                setText("TX68: -");
                setId(206);
            }
        };
        this.RX68 = new TextView(con) {
            {
                setText("RX68: -");
                setId(207);
            }
        };
        this.TX69 = new TextView(con) {
            {
                setText("TX69: -");
                setId(208);
            }
        };
        this.RX69 = new TextView(con) {
            {
                setText("RX69: -");
                setId(209);
            }
        };
        this.TX70 = new TextView(con) {
            {
                setText("TX70: -");
                setId(210);
            }
        };
        this.RX70 = new TextView(con) {
            {
                setText("RX70: -");
                setId(211);
            }
        };
        this.TX71 = new TextView(con) {
            {
                setText("TX71: -");
                setId(212);
            }
        };
        this.RX71 = new TextView(con) {
            {
                setText("RX71: -");
                setId(213);
            }
        };
        this.TX72 = new TextView(con) {
            {
                setText("TX72: -");
                setId(214);
            }
        };
        this.RX72 = new TextView(con) {
            {
                setText("RX72: -");
                setId(215);
            }
        };
        this.TX73 = new TextView(con) {
            {
                setText("TX73: -");
                setId(216);
            }
        };
        this.RX73 = new TextView(con) {
            {
                setText("RX73: -");
                setId(217);
            }
        };

        this.displayText = new EditText(con);
        this.displayText.setMaxLines(1);
        this.displayText.setInputType(InputType.TYPE_CLASS_TEXT);
        this.displayText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.displayText.setId(600);
        int maxLength = 20;
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

        //TX67
        this.display67Text = new EditText(con);
        this.display67Text.setMaxLines(1);
        this.display67Text.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display67Text.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display67Text.setId(604);
        //int maxLength = 16;
        this.display67Text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.display67Text1 = new EditText(con);
        this.display67Text1.setMaxLines(1);
        this.display67Text1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display67Text1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display67Text1.setId(605);
        //int maxLength = 16;
        this.display67Text1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        //TX68
        this.display68Text = new EditText(con);
        this.display68Text.setMaxLines(1);
        this.display68Text.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display68Text.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display68Text.setId(606);
        //int maxLength = 16;
        this.display68Text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.display68Text1 = new EditText(con);
        this.display68Text1.setMaxLines(1);
        this.display68Text1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display68Text1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display68Text1.setId(607);
        //int maxLength = 16;
        this.display68Text1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        //TX69
        this.display69Text = new EditText(con);
        this.display69Text.setMaxLines(1);
        this.display69Text.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display69Text.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display69Text.setId(608);
        //int maxLength = 16;
        this.display69Text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.display69Text1 = new EditText(con);
        this.display69Text1.setMaxLines(1);
        this.display69Text1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display69Text1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display69Text1.setId(609);
        //int maxLength = 16;
        this.display69Text1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        //TX70
        this.display70Text = new EditText(con);
        this.display70Text.setMaxLines(1);
        this.display70Text.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display70Text.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display70Text.setId(610);
        //int maxLength = 16;
        this.display70Text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.display70Text1 = new EditText(con);
        this.display70Text1.setMaxLines(1);
        this.display70Text1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display70Text1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display70Text1.setId(611);
        //int maxLength = 16;
        this.display70Text1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});


        //TX71
        this.display71Text = new EditText(con);
        this.display71Text.setMaxLines(1);
        this.display71Text.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display71Text.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display71Text.setId(612);
        //int maxLength = 16;
        this.display71Text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.display71Text1 = new EditText(con);
        this.display71Text1.setMaxLines(1);
        this.display71Text1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display71Text1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display71Text1.setId(613);
        //int maxLength = 16;
        this.display71Text1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        //TX72
        this.display72Text = new EditText(con);
        this.display72Text.setMaxLines(1);
        this.display72Text.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display72Text.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display72Text.setId(614);
        //int maxLength = 16;
        this.display72Text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.display72Text1 = new EditText(con);
        this.display72Text1.setMaxLines(1);
        this.display72Text1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display72Text1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display72Text1.setId(615);
        //int maxLength = 16;
        this.display72Text1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        //TX73
        this.display73Text = new EditText(con);
        this.display73Text.setMaxLines(1);
        this.display73Text.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display73Text.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display73Text.setId(616);
        //int maxLength = 16;
        this.display73Text.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        this.display73Text1 = new EditText(con);
        this.display73Text1.setMaxLines(1);
        this.display73Text1.setInputType(InputType.TYPE_CLASS_TEXT);
        this.display73Text1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        this.display73Text1.setId(617);
        //int maxLength = 16;
        this.display73Text1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

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
                this.displayText.getId());
        displayTextLayout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.displayText1.setLayoutParams(displayTextLayout1);

        //Title TX66=========================================================
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

        //Title TX67--------------------------------------------------
        RelativeLayout.LayoutParams displayText67Layout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText67Layout0.addRule(RelativeLayout.BELOW,
                this.display66Text1.getId());
        displayText67Layout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.TX67.setLayoutParams(displayText67Layout0);
        //Edit Text
        RelativeLayout.LayoutParams displayText67Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText67Layout.addRule(RelativeLayout.BELOW,
                this.TX67.getId());
        displayText67Layout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display67Text.setLayoutParams(displayText67Layout);

        //title RX67
        RelativeLayout.LayoutParams displayText67Layout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText67Layout00.addRule(RelativeLayout.BELOW,
                this.display67Text.getId());
        displayText67Layout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.RX67.setLayoutParams(displayText67Layout00);
        //Edit Text
        RelativeLayout.LayoutParams displayText67Layout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText67Layout1.addRule(RelativeLayout.BELOW,
                this.display67Text.getId());
        displayText67Layout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display67Text1.setLayoutParams(displayText67Layout1);
        //Title TX68--------------------------------------------------
        RelativeLayout.LayoutParams displayText68Layout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText68Layout0.addRule(RelativeLayout.BELOW,
                this.display67Text1.getId());
        displayText68Layout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.TX68.setLayoutParams(displayText68Layout0);
        //Edit Text
        RelativeLayout.LayoutParams displayText68Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText68Layout.addRule(RelativeLayout.BELOW,
                this.TX68.getId());
        displayText68Layout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display68Text.setLayoutParams(displayText68Layout);

        //title RX68
        RelativeLayout.LayoutParams displayText68Layout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText68Layout00.addRule(RelativeLayout.BELOW,
                this.display68Text.getId());
        displayText68Layout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.RX68.setLayoutParams(displayText68Layout00);
        //Edit Text
        RelativeLayout.LayoutParams displayText68Layout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText68Layout1.addRule(RelativeLayout.BELOW,
                this.display68Text.getId());
        displayText68Layout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display68Text1.setLayoutParams(displayText68Layout1);
        //Title TX69--------------------------------------------------
        RelativeLayout.LayoutParams displayText69Layout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText69Layout0.addRule(RelativeLayout.BELOW,
                this.display68Text1.getId());
        displayText69Layout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.TX69.setLayoutParams(displayText69Layout0);
        //Edit Text
        RelativeLayout.LayoutParams displayText69Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText69Layout.addRule(RelativeLayout.BELOW,
                this.TX69.getId());
        displayText69Layout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display69Text.setLayoutParams(displayText69Layout);

        //title RX69
        RelativeLayout.LayoutParams displayText69Layout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText69Layout00.addRule(RelativeLayout.BELOW,
                this.display69Text.getId());
        displayText69Layout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.RX69.setLayoutParams(displayText69Layout00);
        //Edit Text
        RelativeLayout.LayoutParams displayText69Layout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText69Layout1.addRule(RelativeLayout.BELOW,
                this.display69Text.getId());
        displayText69Layout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display69Text1.setLayoutParams(displayText69Layout1);
        //Title TX70--------------------------------------------------
        RelativeLayout.LayoutParams displayText70Layout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText70Layout0.addRule(RelativeLayout.BELOW,
                this.display69Text1.getId());
        displayText70Layout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.TX70.setLayoutParams(displayText70Layout0);
        //Edit Text
        RelativeLayout.LayoutParams displayText70Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText70Layout.addRule(RelativeLayout.BELOW,
                this.TX70.getId());
        displayText70Layout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display70Text.setLayoutParams(displayText70Layout);

        //title RX70
        RelativeLayout.LayoutParams displayText70Layout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText70Layout00.addRule(RelativeLayout.BELOW,
                this.display70Text.getId());
        displayText70Layout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.RX70.setLayoutParams(displayText70Layout00);
        //Edit Text
        RelativeLayout.LayoutParams displayText70Layout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText70Layout1.addRule(RelativeLayout.BELOW,
                this.display70Text.getId());
        displayText70Layout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display70Text1.setLayoutParams(displayText70Layout1);
        //Title TX71--------------------------------------------------
        RelativeLayout.LayoutParams displayText71Layout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText71Layout0.addRule(RelativeLayout.BELOW,
                this.display70Text1.getId());
        displayText71Layout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.TX71.setLayoutParams(displayText71Layout0);
        //Edit Text
        RelativeLayout.LayoutParams displayText71Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText71Layout.addRule(RelativeLayout.BELOW,
                this.TX71.getId());
        displayText71Layout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display71Text.setLayoutParams(displayText71Layout);

        //title RX71
        RelativeLayout.LayoutParams displayText71Layout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText71Layout00.addRule(RelativeLayout.BELOW,
                this.display71Text.getId());
        displayText71Layout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.RX71.setLayoutParams(displayText71Layout00);
        //Edit Text
        RelativeLayout.LayoutParams displayText71Layout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText71Layout1.addRule(RelativeLayout.BELOW,
                this.display71Text.getId());
        displayText71Layout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display71Text1.setLayoutParams(displayText71Layout1);
        //Title TX72--------------------------------------------------
        RelativeLayout.LayoutParams displayText72Layout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText72Layout0.addRule(RelativeLayout.BELOW,
                this.display71Text1.getId());
        displayText72Layout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.TX72.setLayoutParams(displayText72Layout0);
        //Edit Text
        RelativeLayout.LayoutParams displayText72Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText72Layout.addRule(RelativeLayout.BELOW,
                this.TX72.getId());
        displayText72Layout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display72Text.setLayoutParams(displayText72Layout);

        //title RX72
        RelativeLayout.LayoutParams displayText72Layout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText72Layout00.addRule(RelativeLayout.BELOW,
                this.display72Text.getId());
        displayText72Layout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.RX72.setLayoutParams(displayText72Layout00);
        //Edit Text
        RelativeLayout.LayoutParams displayText72Layout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText72Layout1.addRule(RelativeLayout.BELOW,
                this.display72Text.getId());
        displayText72Layout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display72Text1.setLayoutParams(displayText72Layout1);
        //Title TX73--------------------------------------------------
        RelativeLayout.LayoutParams displayText73Layout0 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText73Layout0.addRule(RelativeLayout.BELOW,
                this.display72Text1.getId());
        displayText73Layout0.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.TX73.setLayoutParams(displayText73Layout0);
        //Edit Text
        RelativeLayout.LayoutParams displayText73Layout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText73Layout.addRule(RelativeLayout.BELOW,
                this.TX73.getId());
        displayText73Layout.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display73Text.setLayoutParams(displayText73Layout);

        //title RX73
        RelativeLayout.LayoutParams displayText73Layout00 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText73Layout00.addRule(RelativeLayout.BELOW,
                this.display73Text.getId());
        displayText73Layout00.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.RX73.setLayoutParams(displayText73Layout00);
        //Edit Text
        RelativeLayout.LayoutParams displayText73Layout1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        displayText73Layout1.addRule(RelativeLayout.BELOW,
                this.display73Text.getId());
        displayText73Layout1.addRule(RelativeLayout.RIGHT_OF, icon.getId());
        this.display73Text1.setLayoutParams(displayText73Layout1);

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
        //67
        this.rowLayout.addView(this.TX67);
        this.rowLayout.addView(this.RX67);
        this.rowLayout.addView(this.display67Text);
        this.rowLayout.addView(this.display67Text1);
        //68
        this.rowLayout.addView(this.TX68);
        this.rowLayout.addView(this.RX68);
        this.rowLayout.addView(this.display68Text);
        this.rowLayout.addView(this.display68Text1);
        //69
        this.rowLayout.addView(this.TX69);
        this.rowLayout.addView(this.RX69);
        this.rowLayout.addView(this.display69Text);
        this.rowLayout.addView(this.display69Text1);
        //70
        this.rowLayout.addView(this.TX70);
        this.rowLayout.addView(this.RX70);
        this.rowLayout.addView(this.display70Text);
        this.rowLayout.addView(this.display70Text1);
        //71
        this.rowLayout.addView(this.TX71);
        this.rowLayout.addView(this.RX71);
        this.rowLayout.addView(this.display71Text);
        this.rowLayout.addView(this.display71Text1);
        //72
        this.rowLayout.addView(this.TX72);
        this.rowLayout.addView(this.RX72);
        this.rowLayout.addView(this.display72Text);
        this.rowLayout.addView(this.display72Text1);
        //73
        this.rowLayout.addView(this.TX73);
        this.rowLayout.addView(this.RX73);
        this.rowLayout.addView(this.display73Text);
        this.rowLayout.addView(this.display73Text1);
    }
}
