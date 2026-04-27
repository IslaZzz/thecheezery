package islas.abril.thecheezery_253017.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import islas.abril.thecheezery_253017.Navigation.rememberNavController
import islas.abril.thecheezery_253017.R
import islas.abril.thecheezery_253017.ui.theme.Brighter_Pink
import islas.abril.thecheezery_253017.ui.theme.Dusty_white
import islas.abril.thecheezery_253017.ui.theme.Less_Purple
import islas.abril.thecheezery_253017.ui.theme.Pinky
import islas.abril.thecheezery_253017.ui.theme.Very_purple

@Composable
fun MenuScreen(navController: NavController){
    val firstGradient = Brush.verticalGradient(listOf(Brighter_Pink, Pinky))
    val secondGradient = Brush.verticalGradient(listOf(Pinky, Less_Purple))
    val thirdGradient = Brush.verticalGradient(listOf(Less_Purple, Very_purple))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ){
        Spacer(modifier = Modifier.padding(10.dp))

        Image(
           painter = painterResource(R.drawable.gtwo),
           contentDescription = "",
           modifier = Modifier.fillMaxWidth(),
           contentScale = ContentScale.Crop
       )
        Spacer(modifier = Modifier.padding(20.dp))

        Column() {
            Row(){
                MenuButton(
                    text = "Hot drinks",
                    gradient = firstGradient,
                    onClick = { navController.navigate("hot") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom=0.7.dp, end = 5.dp)
                )
                MenuButton(
                    text = "Cold drinks",
                    gradient = firstGradient,
                    onClick = { navController.navigate("cold") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom=0.7.dp, start = 5.dp)
                )
            }
            Row(){
                MenuButton(
                    text = "Salties",
                    gradient = secondGradient,
                    onClick = { navController.navigate("salties") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom=0.7.dp, end = 5.dp)
                )
                MenuButton(
                    text = "Sweets",
                    gradient = secondGradient,
                    onClick = { navController.navigate("sweets") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom=0.7.dp, start = 5.dp)

                )
            }
            Row(){
                MenuButton(
                    text = "Combo",
                    gradient = thirdGradient,
                    onClick = { navController.navigate("combo") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom=0.7.dp, end = 5.dp)
                )
                MenuButton(
                    text = "Add new product",
                    gradient = thirdGradient,
                    onClick = { navController.navigate("addProduct") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom=0.7.dp, start = 5.dp)
                )
            }
        }

//.clickable{ navController.navigate("explore") }
    }
}

@Composable
fun MenuButton(
    text: String,
    gradient: Brush,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(gradient)
            .clickable { onClick() }
            .padding(vertical = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Dusty_white,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewMenuScreen(){
    val navController = rememberNavController()
    MenuScreen(navController = navController)
}