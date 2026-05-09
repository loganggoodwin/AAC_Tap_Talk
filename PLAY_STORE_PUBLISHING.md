# AAC Tap Talk — Google Play Publishing Notes

## Final package name

Use this package name for Google Play:

```text
com.logangoodwin.aactaptalk
```

Important: do not upload a build with `com.example.aactaptalk`. The package name is permanent once the first app bundle is uploaded to Google Play.

## Current technical settings

- App name: AAC Tap Talk
- Package / application ID: `com.logangoodwin.aactaptalk`
- minSdk: 23
- compileSdk: 36
- targetSdk: 36
- versionCode: 1
- versionName: 1.0
- Permissions requested: none
- Internet access: not requested
- Data collection: none by this app

## Build the Android App Bundle

In Android Studio:

1. Open the unzipped project folder.
2. Let Gradle sync finish.
3. Go to **Build > Generate Signed App Bundle / APK**.
4. Choose **Android App Bundle**.
5. Create or choose a keystore.
6. Use the **release** build variant.
7. Finish the wizard.
8. Upload the generated `.aab` file to Play Console.

Keep your keystore safe. You need it for future updates.

## Suggested store listing

### Short description

A simple picture-based AAC app that lets children tap Yes, No, or Bathroom and hear the choice spoken aloud.

### Full description

AAC Tap Talk is a simple communication helper for children who benefit from large picture buttons and spoken choices. The app provides three clear options: Yes, No, and Bathroom. When a child taps a button, the app displays the selected word in large text and speaks it aloud using Android's built-in text-to-speech system.

The app is intentionally simple. It does not require an account, does not connect to the internet, does not show ads, and does not collect personal information. It is designed for quick, practical communication support at home, school, or during daily routines.

Features:

- Large tap-friendly buttons
- Clear Yes, No, and Bathroom choices
- Picture-based visual support
- Spoken output using Android Text-to-Speech
- No account required
- No ads
- No internet permission
- No data collection by the app

This app is not a medical device and is not a replacement for professional speech-language therapy. It is a basic communication support tool.

## Data Safety answers

For this project as currently written:

- Does the app collect or share user data? **No**
- Is all user data collected encrypted in transit? **Not applicable** because the app does not collect or transmit data.
- Can users request data deletion? **Not applicable** because the app does not collect or store user data.
- Does the app use advertising ID? **No**
- Does the app use analytics? **No**
- Does the app require login? **No**

## Privacy policy summary

Use the included `PRIVACY_POLICY.md` as the source text for a public privacy policy page. Google Play needs a URL, so publish the privacy policy on a public webpage, such as your portfolio site or a GitHub Pages page, and paste that URL into Play Console.

## Content rating notes

Suggested answers based on the current app:

- Violence: none
- Sexual content: none
- Profanity: none
- Controlled substances: none
- User-generated content: none
- Online interaction: none
- Data sharing: none
- Ads: none

## Testing notes

Before production, test on at least one real Android phone:

- App opens in portrait mode.
- Yes button displays YES and says “Yes.”
- No button displays NO and says “No.”
- Bathroom button displays BATHROOM and says “I need the bathroom.”
- Buttons are easy to tap.
- Speech volume is clear.
- App still works after closing and reopening.

## Future update ideas

- Add more buttons such as Food, Drink, Help, Pain, Mom, Dad, Stop, and More.
- Add a settings screen for custom button labels and pictures.
- Add a tablet layout.
- Add optional voice speed control.
