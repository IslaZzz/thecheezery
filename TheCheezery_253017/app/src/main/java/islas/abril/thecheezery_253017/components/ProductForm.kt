package islas.abril.thecheezery_253017.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import islas.abril.thecheezery_253017.R
import islas.abril.thecheezery_253017.ui.theme.Brighter_Pink
import islas.abril.thecheezery_253017.ui.theme.Dusty_white
import islas.abril.thecheezery_253017.ui.theme.Pinky

@Composable
fun ProductForm(onSaveProduct: (
    name:String, price: Float,
    image: String, description: String
        )-> Unit){

    var name by remember {mutableStateOf("")}
    var price by remember {mutableStateOf("")}
    var image by remember {mutableStateOf("")}
    var description by remember {mutableStateOf("")}

    Column(
        modifier= Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Add a product",
            color = Pinky,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
        )
        Spacer(Modifier.height(30.dp))
        OutlinedTextField(
            value=name,
            onValueChange={name=it},
            label={Text("Name")}
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value=price,
            onValueChange={price=it},
            label={Text("Price")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            trailingIcon = {Image(painter=painterResource(id=R.drawable.money), contentDescription = "")}
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value=image,
            onValueChange={image=it},
            label={Text("Image")},
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value=description,
            onValueChange={description=it},
            label={Text("Description")},
        )
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {onSaveProduct(
            name,price.toFloat(),image,description
            )},
            colors = ButtonDefaults.buttonColors(
                containerColor = Pinky,
                contentColor = Dusty_white
            )
        ){
            Text("Save button")
        }
    }

}

@Preview (showBackground = true)
@Composable
fun PreviewProductForm(){
    ProductForm({
        name,price,image,description ->
    })
}