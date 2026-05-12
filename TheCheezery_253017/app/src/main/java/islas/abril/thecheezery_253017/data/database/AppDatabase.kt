package islas.abril.thecheezery_253017.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import islas.abril.thecheezery_253017.data.dao.ComboDAO
import islas.abril.thecheezery_253017.data.dao.ProductComboDAO
import islas.abril.thecheezery_253017.data.dao.ProductDAO
import islas.abril.thecheezery_253017.data.room.ComboEntity
import islas.abril.thecheezery_253017.data.room.ProductEntity


@Database(
    entities = [
        ProductEntity::class,
        ComboEntity::class,
        ProductEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDAO
    abstract fun comboDao(): ComboDAO
    abstract fun productComboDAO(): ProductComboDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cheezery.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}