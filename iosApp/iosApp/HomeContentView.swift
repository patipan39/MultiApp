import SwiftUI
import shared

struct HomeContentView: View {

    @State var goToMainPage: Bool = false

    var body: some View {
        NavigationView {
            VStack {
                HomeComposeView(
                    onClickedAlbum: {
                        goToMainPage = true
                    }, onClickedProfile: {

                })
                NavigationLink("", destination: MainView(), isActive: $goToMainPage)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        HomeComposeView(onClickedAlbum: {

        }, onClickedProfile: {

        })
    }
}

struct HomeComposeView: UIViewControllerRepresentable {
    let onClickedAlbum: () -> Void;
    let onClickedProfile: () -> Void

    func makeUIViewController(context: Context) -> UIViewController {
        Home_iosKt.HomeViewController(onClickAlbum: onClickedAlbum, onClickProfile: onClickedProfile)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {

    }
}
