import Combine
import SwiftUI
import shared

struct ProfileView: View {
    var body: some View {
        NavigationView {
            Group {
                ProfilePage()
            }
        }
                .navigationTitle("ข้อมูลส่วนตัว")
                .navigationBarTitleDisplayMode(.inline)
                .environmentObject(ProfileViewModel())
    }
}

struct ProfilePage: View {
    @StateObject var profile: ProfileViewModel = ProfileViewModel()

    let imageUrl = "https://cdn-icons-png.flaticon.com/512/3135/3135715.png"
    var body: some View {
        ZStack {
            ScrollView(.vertical) {
                LazyVStack(spacing: 16) {
                    Spacer()
                    HStack {
                        Spacer()
                        KarmelImage(imageUrl: imageUrl).frame(width: 128, height: 128).clipShape(RoundedRectangle(cornerRadius: 100, style: .circular))
                        Spacer()
                    }
                    Text("รอ Api นะ").foregroundColor(.white).frame(minWidth: 0, maxWidth: .infinity, alignment: .center)
                    Text("บัญชีที่ใช้เข้าสู่ระบบ").foregroundColor(.white).frame(maxWidth: .infinity, alignment: .leading)
                    ForEach(profile.currentProfile ?? [], id: \.self) { data in
                        CardChannelItem(imageUrl: data.imageUrl, channelName: data.channelName, name: data.name)
                    }
                    Text("เชื่อมต่อด้วยบัญชีอื่น").foregroundColor(.white).frame(maxWidth: .infinity, alignment: .leading)
                    ForEach(profile.otherProfile ?? [], id: \.self) { data in
                        CardChannelItem(imageUrl: data.imageUrl, channelName: data.channelName, name: data.name)
                    }
                }
                        .padding(EdgeInsets(top: 0, leading: 16, bottom: 0, trailing: 16))
            }
        }
                .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .topLeading) //fill width , height
                .background(LinearGradient(gradient: Gradient(colors: [.black, .purple]), startPoint: .topLeading, endPoint: .bottomTrailing))
                .clipped()
    }
}

struct CardChannelItem: View {
    @State var imageUrl: String
    @State var channelName: String
    @State var name: String

    var body: some View {
        HStack(spacing: 8) {
            KarmelImage(imageUrl: imageUrl).frame(width: 48, height: 48)
                    .clipShape(RoundedRectangle(cornerRadius: 100, style: .circular))
                    .padding(EdgeInsets.init(top: 0, leading: 8, bottom: 0, trailing: 0))
            VStack {
                Text(channelName).foregroundColor(.white).frame(maxWidth: .infinity, alignment: .leading)
                Text(name).foregroundColor(.white).frame(maxWidth: .infinity, alignment: .leading)
            }
                    .padding(EdgeInsets.init(top: 8, leading: 8, bottom: 8, trailing: 8))
        }
                .frame(minWidth: 0, maxWidth: .infinity, alignment: .leading)
                .background(Color.gray.opacity(0.5))
                .clipShape(RoundedRectangle(cornerRadius: 16, style: .circular))
    }
}


struct KarmelImage: UIViewControllerRepresentable {
    @State var imageUrl: String

    func makeUIViewController(context: Context) -> some UIViewController {
        let image = KarmelImage_iosKt.karmelImage(url: imageUrl)
        image.view.backgroundColor = .clear
        return image
    }

    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {

    }
}


struct ProfileView_Previews: PreviewProvider {
    static var previews: some View {
        ProfileView()
    }
}

class ProfileViewModel: ObservableObject {

    private let koinProfile = KoinHelper().getProfileUseCase()
    @Published var currentProfile: [ProfileData.Info]? = []
    @Published var otherProfile: [ProfileData.Info]? = []

    init() {
        Task {
            try await getProfileData()
        }
    }

    func getProfileData() async throws {
        let result = try await koinProfile.execute()
        await MainActor.run {
            if let success = result as? ResultSuccess {
                self.currentProfile = success.data?.currentProfile
                self.otherProfile = success.data?.otherProfile
            } else {

            }
        }
    }
}

