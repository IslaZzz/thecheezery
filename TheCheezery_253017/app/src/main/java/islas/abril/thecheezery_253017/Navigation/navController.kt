package islas.abril.thecheezery_253017.Navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator

@Composable
public  fun rememberNavController(
    vararg navigators: Navigator<out NavDestination>
): NavHostController {
    val context = LocalContext.current
    return rememberSaveable(inputs = navigators, saver = NavControllerSaver(context)) {
        createNavController(context)
    }
        .apply {
            for (navigator in navigators) {
                navigatorProvider.addNavigator(navigator)
            }
        }
}

private fun createNavController(context: Context) =
    NavHostController(context).apply {
       // navigatorProvider.addNavigator(ComposeNavGraphNavigator(navigatorProvider))
       // navigatorProvider.addNavigator(ComposeNavigator())
       // navigatorProvider.addNavigator(DialogNavigator())
    }

private fun NavControllerSaver(context: Context): Saver<NavHostController, *> =
    Saver(
        save = { it.saveState() },
        restore = { createNavController(context).apply { restoreState(it) } }
    )
