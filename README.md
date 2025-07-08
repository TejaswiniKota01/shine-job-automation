Shine Job Automation 🚀

This project automates the end-to-end process of searching and applying for jobs on Shine.com using Selenium WebDriver and Java.

📌 Project Objective
- Login to Shine.com
- Search for "Software Tester" jobs in Hyderabad with 2 years of experience
- Select the second job from the results
- Click Apply and validate successful submission
- Capture screenshots and generate logs

💻 Tech Stack
- Java
- Selenium WebDriver
- Maven
- WebDriverManager
- JUnit 5 (Optional)
- Git/GitHub

📁 Project Structure
shine-job-automation/
├── src/
│   ├── main/java/com/shine/automation/App.java
│   └── test/java/com/shine/automation/AppTest.java
├── screenshots/              ← Captured screenshots (.png)
├── shine-log.txt             ← Application logs
├── .gitignore                ← Ignore compiled/log/IDE files
├── pom.xml                   ← Maven config
└── README.md                 ← Project overview

🖥️ How to Run the Project
🔧 Prerequisites:
- Java 17+
- Maven
- Chrome browser
- Git (optional, for version control)

▶️ Steps to Execute:
mvn clean compile
mvn exec:java -Dexec.mainClass="com.shine.automation.App"
mvn test

📸 Screenshots Captured
- After Login
- After Job Search
- After Selecting 2nd Job
- After Clicking Apply

📝 Log Output
Logs saved to: shine-log.txt
Includes page titles, URLs, job info, and application status.

🛡️ Security Note
Remove or externalize login credentials before sharing or uploading publicly.

✨ Author
Kota Tejaswini
Automated using Java + Selenium
Made for Frugal Testing | 2025

📬 Contact / Suggestions
Feel free to connect for improvements or collaborations!
