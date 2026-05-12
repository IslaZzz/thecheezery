package islas.abril.thecheezery_253017.model

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import islas.abril.thecheezery_253017.data.DatabaseHelper
import islas.abril.thecheezery_253017.data.dao.ProductDAO
import islas.abril.thecheezery_253017.domain.Product

class ProductsViewModel (databaseHelper: DatabaseHelper, context: Context): ViewModel(){
    val dao = ProductDAO(databaseHelper)
    val contextLocal = context
    var productsListState by mutableStateOf(listOf<Product>())

    fun onSaveProduct(
        name:String,
        price:Float,
        image: String,
        description:String
    ){
        val product = Product(name=name,image=image,price=price, description = description)
        val idNewProduct= dao.insertProduct(product)
        if(idNewProduct.toInt() ==-1){

            Toast.makeText(contextLocal,"Ocurrio un error al guardar", Toast.LENGTH_SHORT).show()
        }
            Toast.makeText(contextLocal,"Producto guardado", Toast.LENGTH_SHORT).show()

    }
    fun getAllProducts(){
        productsListState = dao.returnProducts()
    }
}