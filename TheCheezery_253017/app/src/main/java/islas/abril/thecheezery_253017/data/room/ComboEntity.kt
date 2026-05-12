package islas.abril.thecheezery_253017.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Combo")

data class ComboEntity(
    @PrimaryKey(autoGenerate = true)
    val  idCombo: Int = 0,

    @ColumnInfo("comboName")
    val comboName: String,

    @ColumnInfo("comboPrice")
    val comboPrice: Int

)