import SwiftUI
import shared

struct MainView: View {
    @Environment(\.presentationMode) var presentationMode : Binding<PresentationMode>
    var body: some View {
        NavigationView {
            VStack {
                MainComposeView {
                    presentationMode.wrappedValue.dismiss()
                }
            }
        }.navigationBarHidden(true)
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainComposeView {

        }
    }
}

struct MainComposeView: UIViewControllerRepresentable {
    let onBack: () -> Void

    func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.MainViewController {
            onBack()
        }
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {

    }
}
