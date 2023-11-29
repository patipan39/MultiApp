import SwiftUI
import shared

struct HomeContentView: View {
    @State var goToAlbums: Bool = false
    @State var goToProfiles: Bool = false

    var body: some View {
        NavigationView {
            VStack {
                HomeComposeView(onClickAlbum: {
                    goToAlbums = true
                }, onClickProfile: {
                    goToProfiles = true
                })
                NavigationLink("", destination: MainView(), isActive: $goToAlbums)
                NavigationLink("", destination: ProfileView(), isActive: $goToProfiles)
            }
        }
    }
}

struct HomeComposeView: UIViewControllerRepresentable {
    let onClickAlbum: () -> Void
    let onClickProfile: () -> Void

    func makeUIViewController(context: Context) -> UIViewController {
        Home_iosKt.homeViewController(onClickAlbum: onClickAlbum, onClickProfile: onClickProfile)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {

    }
}
