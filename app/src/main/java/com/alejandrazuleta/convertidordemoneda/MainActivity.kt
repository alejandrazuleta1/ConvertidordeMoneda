package com.alejandrazuleta.convertidordemoneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing a String Array
        val monedas = arrayOf("Peso colombiano","Dolar USA","Euro")

        // Initializing an ArrayAdapter
        val adapter = ArrayAdapter(
            this, // Context
            android.R.layout.simple_spinner_item, // Layout
            monedas // Array
        )

        // Set the drop down view resource
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        // Finally, data bind the spinner object with dapter
        sp_moneda1.adapter = adapter;
        sp_moneda2.adapter = adapter;

        var aux=1
        var cant1="";

        // Set an on item selected listener for spinner object
        sp_moneda1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                //tv_ayuda.text=parent.getItemAtPosition(position).toString()
                //tv_ayuda.text= position.toString()

                cant1=et_cantidad1.text.toString()

                aux= sp_moneda2.selectedItemPosition

                when (position) {
                    0 -> {
                        when(aux){
                            0 ->{
                                et_cantidad2.text=cant1.toDouble().toString().toEditable()
                            }
                            1 -> {
                                et_cantidad2.text=cant1.toDouble().times(0.0003).toString().toEditable()
                            }
                            else -> {
                                et_cantidad2.text=cant1.toDouble().times(0.00027).toString().toEditable()
                            }
                        }
                    }
                    1 -> {
                        when(aux){
                            0 ->{
                                et_cantidad2.text=cant1.toDouble().times(3302.10).toString().toEditable()
                            }
                            1 -> {
                                et_cantidad2.text=cant1.toDouble().toString().toEditable()
                            }
                            else -> {
                                et_cantidad2.text=cant1.toDouble().times(0.90).toString().toEditable()
                            }
                        }
                    }
                    else -> {
                        when(aux){
                            0 ->{
                                et_cantidad2.text=cant1.toDouble().times(3683.78).toString().toEditable()
                            }
                            1 -> {
                                et_cantidad2.text=cant1.toDouble().times(1.12).toString().toEditable()
                            }
                            else -> {
                                et_cantidad2.text=cant1.toDouble().toString().toEditable()
                            }
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>){

            }
        }

        sp_moneda2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                //tv_ayuda.text=parent.getItemAtPosition(position).toString()
                //tv_ayuda.text= position.toString()

                cant1=et_cantidad1.text.toString()
                aux= sp_moneda1.selectedItemPosition

                when (aux) {
                    0 -> {
                        when(position){
                            0 ->{
                                et_cantidad2.text=cant1.toDouble().toString().toEditable()
                            }
                            1 -> {
                                et_cantidad2.text=cant1.toDouble().times(0.0003).toString().toEditable()
                            }
                            else -> {
                                et_cantidad2.text=cant1.toDouble().times(0.00027).toString().toEditable()
                            }
                        }
                    }
                    1 -> {
                        when(position){
                            0 ->{
                                et_cantidad2.text=cant1.toDouble().times(3302.10).toString().toEditable()
                            }
                            1 -> {
                                et_cantidad2.text=cant1.toDouble().toString().toEditable()
                            }
                            else -> {
                                et_cantidad2.text=cant1.toDouble().times(0.90).toString().toEditable()
                            }
                        }
                    }
                    else -> {
                        when(position){
                            0 ->{
                                et_cantidad2.text=cant1.toDouble().times(3683.78).toString().toEditable()
                            }
                            1 -> {
                                et_cantidad2.text=cant1.toDouble().times(1.12).toString().toEditable()
                            }
                            else -> {
                                et_cantidad2.text=cant1.toDouble().toString().toEditable()
                            }
                        }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>){

            }
        }



    }
    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

}
