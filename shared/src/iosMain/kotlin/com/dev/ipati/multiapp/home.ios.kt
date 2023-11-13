import androidx.compose.ui.window.ComposeUIViewController
import com.dev.ipati.multiapp.compose.BaseTheme
import com.dev.ipati.multiapp.compose.home.Home

fun HomeViewController(onClickAlbum: (() -> Unit),
                       onClickProfile: (() -> Unit)) = ComposeUIViewController {
    BaseTheme {
        Home(onClickAlbum, onClickProfile)
    }
}