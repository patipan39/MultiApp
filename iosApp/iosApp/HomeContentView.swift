import SwiftUI
import shared

struct HomeContentView: View {
    @EnvironmentObject var initialHome: InitialHomePage

    var body: some View {
        NavigationView {
            VStack {
                initialHome.page
                NavigationLink("", destination: MainView(), isActive: $initialHome.goToAlbums)
                NavigationLink("", destination: ProfileView(), isActive: $initialHome.goToProfiles)
            }
        }
    }
}

class InitialHomePage: ObservableObject {
    @Published var page: HomeComposeView

    @Published var goToAlbums: Bool = false

    @Published var goToProfiles: Bool = false

    init() {
        self.page = HomeComposeView()
    }
}

struct HomeComposeView: UIViewControllerRepresentable {
    @EnvironmentObject var initialHome: InitialHomePage

    func makeUIViewController(context: Context) -> UIViewController {
        Home_iosKt.homeViewController(onClickAlbum: {
            self.initialHome.goToAlbums = true
        }, onClickProfile: {
            self.initialHome.goToProfiles = true
        })
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {

    }
}
