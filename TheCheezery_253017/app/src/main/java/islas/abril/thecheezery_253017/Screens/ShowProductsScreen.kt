package islas.abril.thecheezery_253017.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import islas.abril.thecheezery_253017.R
import islas.abril.thecheezery_253017.domain.Product
import islas.abril.thecheezery_253017.model.ProductsViewModel


@Composable
fun showProducts(products: List<Product>, ){

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(products) { product ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = product.name,
                    modifier = Modifier.size(64.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(text = product.name)
                    Text(text = "$${product.price}")
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewProductsScreen() {
    val sampleProducts = listOf(
        Product(1, "Pizza", 120.0f, "", "Delicious pizza"),
        Product(2, "Burger", 90.0f, "", "Tasty burger")
    )

    showProducts(sampleProducts)

}
