package com.example.act4_uinput

import android.R.attr.fontWeight
import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormDataDiri(modifier: Modifier)
{
    //variabel mengingat nilai input dari keyboard
    var textNama by remember  { mutableStateOf("") }
    var textJK by remember  { mutableStateOf("") }
    var textAlamat by remember  { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    //variabel untuk menyimpan data dari komponen UI
    var nama by remember  { mutableStateOf("") }
    var jenis by remember  { mutableStateOf("") }
    var alamat by remember  { mutableStateOf("") }


    val gender:List<String> = listOf("Laki-laki","Perempuan")
    val status:List<String> = listOf("Belum Menikah","Menikah")


Column (modifier = Modifier
    .padding(top = 20.dp)
    .background(color = Color.Magenta),
    ){
    Text(stringResource(R.string.form),
        modifier = Modifier.align(Alignment.Start),
        fontSize = 20.sp,
        color = Color.White)

    Card (modifier = Modifier
        .padding(top = 50.dp)
        .background(color = Color.White)){
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = {Text("Nama Lengkap")},
            onValueChange = {textNama = it}
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("JENIS KELAMIN")
        Spacer(modifier = Modifier.height(10.dp))
        Column {
            gender.forEach { item ->
                Row (modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = {textJK = item}),
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = textJK == item,
                        onClick = {textJK = item}
                    )
                    Text(item)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("STATUS PERKAWINAN")
        Spacer(modifier = Modifier.height(10.dp))
        Column {
            status.forEach { item ->
                Row (modifier = Modifier.selectable(
                    selected = textStatus == item,
                    onClick = {textStatus = item}),
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = textStatus == item,
                        onClick = {textStatus = item}
                    )
                    Text(item)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("ALAMAT")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = {Text("Alamat")},
            onValueChange = {textAlamat = it}
        )

        Divider(
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium)),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray)
        Button(
            modifier = Modifier
                .padding(20.dp),
            enabled = textAlamat.isNotEmpty(),
            onClick = {nama = textNama; jenis = textJK; alamat = textAlamat}
        ) { Text(stringResource(R.string.submit)) }
        Divider(
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium)),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray)
    }
}}