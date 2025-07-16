# Amsterdam 🌆

An Android app showcasing a list of places to visit in Amsterdam, categorized into five unique groups. Built with **Jetpack Compose**, **Material Design**, and **modern Android architecture**, the app provides an adaptive and beautiful user experience. The main idea of a city app is from [one of the Jetpack Compose pathway projects](https://developer.android.com/codelabs/basic-android-kotlin-compose-my-city?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-3%3F_gl%3D1*sigghc*_up*MQ..*_ga*NDE2MDg0OTYwLjE3MzQxMDc0NTY.*_ga_6HH9YJMN9M*MTczNDExNTczOC4yLjAuMTczNDExNTczOC4wLjAuMTkyODE1MzA3Mw..%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-my-city&_gl=1*bu0u6x*_up*MQ..*_ga*Mzk1NjA4ODQwLjE3MzQ1NDQyOTU.*_ga_6HH9YJMN9M*MTczNDU0NDI5NS4xLjAuMTczNDU0NDI5NS4wLjAuNzQyNzI3NjY1#0).


## 📱 Features

- 🗂️ Displays five categories of places (e.g., Museums, Parks, Cafés, etc.)
- 📋 Each category contains a list of 6 places with:
  - Name
  - Definition/Description
  - Example/Details
- 🧭 Seamless multi-screen navigation using Jetpack Navigation
- 🎨 Modern UI using Material 3 and theme support (Tangerine color theme)
- 📐 Responsive layout with `LazyVerticalGrid` and adaptive design for various screen sizes
- ✅ State management using `ViewModel` and `UDF (Unidirectional Data Flow)` pattern
- 🔄 Clean separation between UI and data layers

## 🧱 Architecture

- **UI Layer**: Jetpack Compose with Navigation, Theming, and Lazy Grids
- **State Management**: `ViewModel` + `StateFlow`
- **Design Patterns**: MVVM, Repository Pattern

## 🛠️ Built With

- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation)
- [Material 3 Design](https://m3.material.io/)
- Kotlin + Android SDK

## 🎥 Demo
![Amsterdam Demo](demo.gif)
