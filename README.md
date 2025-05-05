🧪 AutomationFinalProject - Almosafertest
This project is a TestNG + Selenium WebDriver automation suite for testing the Almosafer travel booking website. It automates key user flows and verifies UI behaviors and language settings.

📌 Test Scenario Overview
✅ Steps Automated:
Navigate to:
https://www.almosafer.com/en

Homepage Assertions:

Language is set to EN or AR depending on URL.

Currency displayed is SAR.

Contact number is +966554400000.

"Qitaf" logo is visible in the footer.

"Hotels" search tab is NOT selected by default.

Departure date is today + 1 day.

Return date is today + 2 days.

Change Website Language (Randomized):

Randomly choose to stay in the same language or switch between EN and AR.

Assert that the language updated correctly.

Search for Hotels:

Click on the Hotels tab.

Type a city name:

If EN: randomly pick from Dubai, Jeddah, Riyadh.

If AR: randomly pick from دبي, جدة.

Select the first suggestion from autocomplete.

Room Selection:

Randomly select one of:

"1 room, 2 adults, 0 children"

"1 room, 1 adult, 0 children"

Click on Search Button.

Results Page Assertions:

Wait for search results to load.

Assert that the results are displayed correctly:

In EN: page contains "found".

In AR: page contains "إقامة".

🧰 Technologies Used
Java

Selenium WebDriver

TestNG

ChromeDriver

📂 Project Structure
AutomationFinalProject/
│
├── src/
│   └── AppTest.java        # Main test suite with TestNG annotations
│   └── TestData.java       # Test data used in the suite (arrays, URLs, etc.)
│
├── pom.xml                 # Maven dependencies (if used)
└── README.md               # This file
🚀 How to Run the Tests
Install dependencies (e.g., via Maven if used).

Make sure ChromeDriver is installed and its path is set correctly.

Run tests using TestNG (from your IDE or command line).

⚠️ Notes
Some test methods are currently disabled via enabled = false — enable them as needed.

Make sure your internet connection is active as the test depends on a live website.


✍️ Author Anas Jarrar
