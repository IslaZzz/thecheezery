package islas.abril.thecheezery_253017.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import islas.abril.thecheezery_253017.Navigation.rememberNavController
import islas.abril.thecheezery_253017.R
import islas.abril.thecheezery_253017.ui.theme.Brighter_Pink
import islas.abril.thecheezery_253017.ui.theme.Dusty_white
import islas.abril.thecheezery_253017.ui.theme.Purple_grey

@Composable
fun WelcomeScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple_grey)
    ){
        Image(
            painter = painterResource(R.drawable.thecheezery),
            contentDescription = "background",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.padding(25.dp))

        Row(
            modifier = Modifier
                .padding(20.dp)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to The Cheezery",
                    color = Dusty_white,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text="Home of the most wonderful desserts ever seen (and tasted) by the human being",
                    color = Dusty_white,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Italic,
                    fontSize = 16.sp,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(20.dp))

                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Brighter_Pink,
                        contentColor = Dusty_white
                    )) {
                    Text(
                        text = "Get Started",
                        color = Dusty_white,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        modifier = Modifier
                    )

                }
            }
        }

    }
}

@Preview (showBackground = true)
@Composable
fun PreviewWelcomeScreen(){
    val navController = rememberNavController()
    WelcomeScreen(navController = navController)
}