import SwiftUI
import shared

struct HomeContentView: View {

    @State var goToMainPage: Bool = false

    var body: some View {
        NavigationView {
            VStack {
                HomeComposeView {
                    goToMainPage = true
                }
                NavigationLink("", destination: MainView(), isActive: $goToMainPage)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        HomeComposeView {
            //nothing
        }
    }
}

struct HomeComposeView: UIViewControllerRepresentable {
    let onClickedItem: () -> Void

    func makeUIViewController(context: Context) -> UIViewController {
        Home_iosKt.HomeViewController {
            onClickedItem()
        }
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {

    }
}
