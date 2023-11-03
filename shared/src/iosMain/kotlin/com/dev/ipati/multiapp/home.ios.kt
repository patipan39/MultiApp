import androidx.compose.ui.window.ComposeUIViewController
import com.dev.ipati.multiapp.compose.home.BaseHome

fun HomeViewController(onClickedItem: (() -> Unit)) = ComposeUIViewController {
    BaseHome(onClickedItem)
}