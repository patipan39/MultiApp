import androidx.compose.ui.window.ComposeUIViewController
import com.dev.ipati.multiapp.MainViewController
import com.dev.ipati.multiapp.compose.home.Home

fun HomeViewController(onClickedItem: (() -> Unit)) = ComposeUIViewController {
    Home(onClickedItem)
}