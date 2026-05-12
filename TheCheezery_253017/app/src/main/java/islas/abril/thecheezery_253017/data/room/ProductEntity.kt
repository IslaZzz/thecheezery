package islas.abril.thecheezery_253017.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class ProductEntity(

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name="idProduct")
    val idProduct: Int = 0,

    @ColumnInfo("nameProduct")
    val name: String,

    @ColumnInfo("priceProduct")
    val price: Float,

    @ColumnInfo("imageProduct")
    val image: String? = null,

    @ColumnInfo("descriptionProduct")
    val desc: String,

    @ColumnInfo("typeProduct")
    val type: String? = null,

)