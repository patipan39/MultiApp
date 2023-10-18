import SwiftUI
import shared

struct MainView: View {
    @State var goToHomePage : Bool = false
    var body: some View {
        if(goToHomePage){
            HomeContentView()
        }else{
            MainComposeView {
                goToHomePage = true
            }
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainComposeView{
            
        }
    }
}

struct MainComposeView: UIViewControllerRepresentable {
    let onBack : () -> Void
    
    func makeUIViewController(context: Context) -> UIViewController {
        return Main_iosKt.MainViewController {
            onBack()
        }
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }
}
