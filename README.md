# ProductStore – Android Architecture Patterns

## 📌 Overview
**ProductStore** is an Android learning project built using **Java** that demonstrates fetching products from a remote API using different **Android architectural patterns**.

The main goal of this repository is to **compare architectures**, understand their responsibilities, and see how the same feature can be implemented in multiple ways.

Each architecture is implemented in a **separate Git branch**.

---

## 🎯 Purpose of This Repository
This project was created to practice and understand:
- Android architectural patterns
- Separation of concerns
- Networking in Android
- Clean and maintainable code
- Difference between traditional and reactive approaches

---

## 🏗️ Architectures Implemented

### 🔹 MVC (Model–View–Controller)
**Branch:** `mvc`

#### Structure
- **Model**
  - Product data model
  - Remote data source (API)
  - Local data source (Room)

- **View**
  - XML layouts
  - Displays product list and UI states

- **Controller**
  - Activities act as Controllers
  - Handle user interactions
  - Request data from Model and update View

#### Notes
- Simple and easy to understand
- Suitable for small projects
- Logic tends to be coupled with UI

---

### 🔹 MVP (Model–View–Presenter)
**Branch:** `mvp`

#### Structure
- **Model**
  - Data layer (API + Room)

- **View**
  - Activity / Fragment
  - Displays data only
  - Implements View interface

- **Presenter**
  - Handles business logic
  - Communicates between View and Model

#### Notes
- Better separation of concerns than MVC
- More testable
- Slightly more boilerplate

---

### 🔹 MVP + RxJava
**Branch:** `mvp-rxjava`

#### Structure
- Same MVP structure
- Asynchronous operations handled using **RxJava**
- API calls using `Observable` / `Single`

#### Notes
- Cleaner async code
- Better thread management
- Requires managing disposables

---

## 🌐 Features
- Fetch products from remote API
- Display products in RecyclerView
- Save products as Favourite using Room
- Handle loading and error states
- Same features implemented across all architectures

---

## 🛠️ Technologies Used
- Java
- Android SDK
- RecyclerView
- Retrofit
- Gson
- Room Database
- RxJava (in `mvp-rxjava` branch)

---

## 🚀 How to Run
1. Clone the repository
2. Checkout any architecture branch:
   ```bash
   git checkout mvc
   git checkout mvp
   git checkout mvp-rxjava

---

## ▶️ Demo Video
🎥 Watch the app demo here:  

https://github.com/user-attachments/assets/52d1d4da-872d-4318-b90f-a1f703b442ba
