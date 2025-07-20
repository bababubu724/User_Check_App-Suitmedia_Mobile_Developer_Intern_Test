Features:
1. Palindrome Check: Enter any sentence to check if it's a palindrome (a word or phrase that reads the same forwards and backwards).
2. User Selection: Browse through a list of users fetched from an API and select a user to display their details.
3. Smooth Navigation: Navigate seamlessly between three screens:
   - FirstScreen: For palindrome check.
   - SecondScreen: Displays a welcome message with the user’s name.
   - ThirdScreen: Displays a list of users and allows you to select one.
4. API Integration: Fetches user data from a third-party API (Reqres) and displays their name, email, and avatar.
5. User-Friendly Interface: Clean and simple UI with intuitive controls.

Tech Stack:
- Programming Language: Kotlin
- Architecture: Model-View-Controller (MVC)
- API Integration: Retrofit
- UI Components: RecyclerView, EditText, Button, TextView

Third-party Libraries:
- Picasso for loading images from URLs
- Retrofit for handling API requests
- SwipeRefreshLayout for implementing pull-to-refresh functionality

Installation:
1. Clone the repository:
  git clone https://github.com/your-username/User-Check-App.git
2. Open the project in Android Studio.
3. Build and Run:
   - Make sure to select the correct device or emulator.
   - Click on "Run" or press Shift + F10 to build and run the application.
4. Start using the app:
   - On the first screen, enter a sentence to check if it is a palindrome.
   - Navigate through the app by selecting "Next" to go to the next screen.

Screenshots:

<img width="2606" height="1472" alt="image" src="https://github.com/user-attachments/assets/5c739530-a585-4188-8eee-cbb519fa7e96" />
<img width="1920" height="1080" alt="app" src="https://github.com/user-attachments/assets/52fb4bbc-89bb-4234-9864-9416251a3616" />


Usage
1. Palindrome Check: Type any sentence in the provided field, and the app will tell you whether it’s a palindrome or not.
2. Select a User: On the third screen, choose a user from the list of users fetched via an API. The name of the selected user will appear on the second screen.
