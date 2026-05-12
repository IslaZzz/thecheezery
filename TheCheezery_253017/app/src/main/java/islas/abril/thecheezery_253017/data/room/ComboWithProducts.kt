package islas.abril.thecheezery_253017.data.room

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class ComboWithProducts(

    @Embedded
    val combo: ComboEntity,

    @Relation(
        parentColumn = "idCombo",
        entityColumn = "idProduct",
        associateBy = Junction(
            value = ProductComboEntity::class,
            parentColumn = "idCombo",
            entityColumn = "idProduct"
        )
    )
    val products: List<ProductEntity>
)
