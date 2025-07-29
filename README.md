# Ellie Restaurant Management System (ERMS)

The **Ellie Restaurant Management System (ERMS)** is a web-based application designed to streamline restaurant operations such as order management, menu management, and reporting. Built using HTML, CSS, JavaScript, Spring Boot (Java), and MySQL.

## 📁 Project Structure
```
ERMS/
├── Frontend/         # User interfaces (HTML/CSS/JS)
│   ├── login.html
│   ├── dashboard.html
│   ├── menu_manager.html
│   ├── order_interface.html
│   └── styles.css
├── Backend/          # Backend logic (Spring Boot)
│   ├── src/main/erms.java/... (controllers, models, repos)
│   ├── src/main/resources/application.properties
│   └── pom.xml
├── Database/         # Database schema
│   └── erms_schema.sql
├── README.md
```

## 🚀 Features
- **User Authentication**: Secure login for staff/admin
- **Menu Management**: Add and manage food items
- **Order Interface**: Staff can place and process orders
- **Role Management**: Admins manage menus; staff place orders
- **Activity Logging**: Track user actions (via `activity_logs`)

## 🛠️ Tech Stack
- **Frontend**: HTML, CSS, JavaScript (Vanilla Fetch API)
- **Backend**: Spring Boot (Java)
- **Database**: MySQL

## 🧱 Installation & Setup

1. **Database Setup**
   - Create a database named `erms`
   - Import `Database/erms_schema (2).sql`

2. **Backend Setup**
   ```bash
   cd Backend
   mvn clean install
   mvn spring-boot:run
   ```

3. **Frontend Access**
   - Open `Frontend/login.html` in your browser

## 🔐 Default Admin Login
- **Username**: `admin`
- **Password**: `admin@123`

## Troubleshooting

1. **Database Connection Issues**
   - Verify MySQL is running
   - Check database credentials in `application.properties`

2. **API Connection Issues**
   - Ensure backend is running on port 8080
   - Check browser console for CORS errors

3. **Login Issues**
   - Ensure the database has been populated with user data
   - You can manually add a user with the following SQL:
     ```sql
     INSERT INTO users (username, password, role) VALUES 
     ('admin', '$2a$10$3jXagSd7.vk5o6WiEukYJeS3CjKFR.Y9BqEOiV7MDB5wIkHQH2LOi', 'ADMIN');
     ```
     (This adds a user with username 'admin' and password 'admin@123')
