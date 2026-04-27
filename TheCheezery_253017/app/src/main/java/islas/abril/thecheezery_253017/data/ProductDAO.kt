package islas.abril.thecheezery_253017.data

import android.content.ContentValues
import islas.abril.thecheezery_253017.domain.Product
import islas.abril.thecheezery_253017.data.CheezeryContract.ProductsEntry

class ProductDAO(private val dbHelper: DatabaseHelper) {

    fun insertProduct(product: Product): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(ProductsEntry.COLUMN_NAME, product.name)
            put(ProductsEntry.COLUMN_IMAGE, product.image)
            put(ProductsEntry.COLUMN_PRICE, product.price)
            put(ProductsEntry.COLUMN_DESC, product.description)
        }
        return db.insert(ProductsEntry.TABLE_NAME, null, values)
    }

    fun returnProducts(): List<Product> {
        val db = dbHelper.readableDatabase
        val productList = mutableListOf<Product>()

        val cursor = db.query(
            ProductsEntry.TABLE_NAME,
            arrayOf(
                ProductsEntry.COLUMN_ID,
                ProductsEntry.COLUMN_NAME,
                ProductsEntry.COLUMN_IMAGE,
                ProductsEntry.COLUMN_PRICE,
                ProductsEntry.COLUMN_DESC
            ),
            null,
            null,
            null,
            null,
            null
        )

        cursor.use { // 🔥 cierra automáticamente
            while (it.moveToNext()) {
                val id = it.getInt(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_ID))
                val name = it.getString(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_NAME))
                val price = it.getFloat(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_PRICE))
                val image = it.getString(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_IMAGE))
                val desc = it.getString(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_DESC))

                productList.add(Product(id, name, price, image, desc))
            }
        }

        return productList
    }

    fun getProductById(productId: Int): Product? {
        val db = dbHelper.readableDatabase

        val cursor = db.query(
            ProductsEntry.TABLE_NAME,
            arrayOf(
                ProductsEntry.COLUMN_ID,
                ProductsEntry.COLUMN_NAME,
                ProductsEntry.COLUMN_IMAGE,
                ProductsEntry.COLUMN_PRICE,
                ProductsEntry.COLUMN_DESC
            ),
            "${ProductsEntry.COLUMN_ID} = ?",
            arrayOf(productId.toString()),
            null,
            null,
            null
        )

        cursor.use {
            return if (it.moveToFirst()) {
                val id = it.getInt(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_ID))
                val name = it.getString(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_NAME))
                val price = it.getFloat(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_PRICE))
                val image = it.getString(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_IMAGE))
                val desc = it.getString(it.getColumnIndexOrThrow(ProductsEntry.COLUMN_DESC))

                Product(id, name, price, image, desc)
            } else {
                null
            }
        }
    }
}