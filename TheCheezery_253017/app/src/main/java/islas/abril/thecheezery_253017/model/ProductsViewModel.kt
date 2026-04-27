package islas.abril.thecheezery_253017.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import islas.abril.thecheezery_253017.data.DatabaseHelper
import islas.abril.thecheezery_253017.domain.Product

class ProductsViewModel (databaseHelper: DatabaseHelper, context: Context): ViewModel(){
    val dao = ProductDAO(databaseHelper)
    val contextLocal = context

    fun onSaveProduct(
        name:String,
        price:Float,
        image: String,
        description:String
    ){
        val product = Product(name=name,image=image,price=price, description = description)
        val idNewProduct= dao.insertProduct(product)
        if(idNewProduct ==-1){

            Toast.makeText(contextLocal,"Ocurrio un error al guardar", Toast.LENGTH_SHORT).show()
        }
            Toast.makeText(contextLocal,"Producto guardado", Toast.LENGTH_SHORT).show()

    }
}