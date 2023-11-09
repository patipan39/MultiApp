import SwiftUI
import shared

struct HomeContentView: View {
    @State var goToMainPage : Bool = false
    
	var body: some View {
        if(goToMainPage){
            MainView()
        }else{
            HomeComposeView {
                goToMainPage = true
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
    let onClickedItem : () -> Void
    
    func makeUIViewController(context: Context) -> UIViewController {
        Home_iosKt.HomeViewController {
            onClickedItem()
        }
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        
    }
}
