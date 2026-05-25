# MyOrdersDemo

A native Android application built in Kotlin replicating a logistics/delivery app's **My Orders** screen. Developed as part of an internship assignment for OceanX Agency.

---

## 📱 Screenshots

> Add your screen recording or screenshots here after running the app.

---

## ✨ Features

- **My Orders screen** with yellow branded header
- **Search bar** with Filter and Sort controls
- **Tab navigation** — All Orders, Completed, Cancelled, Booked Again
- **Dismissible info banner** in Hindi
- **RecyclerView** with dynamic order cards
- **Dynamic status badges** — color coded per order status
- **Bottom navigation** with 4 tabs — Home, Orders, Payments, Account
- **Invoice and Book Again** button interactions per card

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI | XML Layouts |
| Architecture | Fragment-based |
| Lists | RecyclerView + custom Adapter |
| View access | ViewBinding |
| UI Components | Material Components, CardView, ConstraintLayout |
| Min SDK | API 24 (Android 7.0) |
| Target SDK | API 34 (Android 14) |

---

## 📁 Project Structure

```
app/src/main/
├── java/com/ojas/myordersdemo/
│   ├── MainActivity.kt          # Entry point, hosts bottom nav + fragment container
│   ├── OrdersFragment.kt        # Main screen logic, tab filtering, banner dismiss
│   ├── OrdersAdapter.kt         # RecyclerView adapter with ViewHolder pattern
│   └── Order.kt                 # Data class representing a single order
│
└── res/
    ├── layout/
    │   ├── activity_main.xml        # Root layout with FragmentContainerView + BottomNav
    │   ├── fragment_orders.xml      # Full orders screen layout
    │   └── item_order.xml           # Single order card layout
    ├── drawable/
    │   ├── bg_yellow_pill.xml       # Active tab background
    │   ├── bg_tab_inactive.xml      # Inactive tab background
    │   ├── bg_cancelled_badge.xml   # Red outlined status badge
    │   ├── bg_invoice_button.xml    # Outlined invoice button
    │   ├── bg_book_again_button.xml # Yellow filled book again button
    │   ├── bg_search_bar.xml        # Rounded search bar background
    │   ├── bg_filter_button.xml     # Outlined filter/sort button
    │   ├── ic_pickup_dot.xml        # Green circle pickup pin
    │   └── ic_drop_dot.xml          # Red circle drop pin
    ├── menu/
    │   └── bottom_nav_menu.xml      # Bottom navigation menu items
    ├── color/
    │   └── bottom_nav_selector.xml  # Active/inactive color selector for bottom nav
    └── values/
        ├── colors.xml               # App color palette
        └── themes.xml               # App theme — MaterialComponents NoActionBar
```

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- JDK 17
- Android device or emulator running API 24+

### Run Locally

1. Clone the repository
```bash
git clone https://github.com/TheNobady/MyOrdersDemo.git
```

2. Open in Android Studio

3. Let Gradle sync complete

4. Connect your device or start an emulator

5. Click **Run** or press `Shift + F10`

---

## 🔑 Key Implementation Details

### RecyclerView + Adapter
Uses the ViewHolder pattern for efficient view recycling. Each card binds an `Order` data class and dynamically styles the status badge based on order status.

### Tab Filtering
All four tabs filter the same `allOrders` list using Kotlin's `filter {}` higher order function and pass the result to `adapter.updateOrders()`. No data is mutated.

### ViewBinding
All view access uses ViewBinding — no `findViewById` anywhere in the project. Fragment binding is properly nulled out in `onDestroyView` to prevent memory leaks.

### Shape Drawables
All UI elements (badges, buttons, pills, dots) use XML shape drawables — no image assets required. Fully scalable across all screen densities.

---

## 📦 Dependencies

```gradle
implementation "androidx.recyclerview:recyclerview:1.3.2"
implementation "com.google.android.material:material:1.12.0"
implementation "androidx.cardview:cardview:1.0.0"
```

---

## 👨‍💻 Author

**Ojas**
- GitHub: [@TheNobady](https://github.com/TheNobady)
- Email: sojas4459@gmail.com
- Institution: SRM Institute of Science and Technology, Delhi NCR Campus

---

## 📄 License

This project was built as part of an internship assignment for OceanX Agency.
