package islas.abril.thecheezery_253017.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import islas.abril.thecheezery_253017.R
import islas.abril.thecheezery_253017.components.ProductForm
import islas.abril.thecheezery_253017.domain.Product

@Composable
fun ProductsScreen(
    innerPaddingValues: PaddingValues,
    products: List<Product>,
    onSaveProduct: (name: String, price: Float, image: String, description: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(10.dp))

        Image(
            painter = painterResource(R.drawable.gtwo),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            contentScale = ContentScale.Crop
        )

        ProductForm(onSaveProduct = onSaveProduct)
    }
}

@Preview(showBackground = true)
@Composable
fun formScreen() {
    val sampleProducts = listOf(
        Product(1, "Pizza", 120.0f, "", "Delicious pizza"),
        Product(2, "Burger", 90.0f, "", "Tasty burger")
    )

    ProductsScreen(
        innerPaddingValues = PaddingValues(0.dp),
        products = sampleProducts,
        onSaveProduct = { _, _, _, _ -> }
    )
}