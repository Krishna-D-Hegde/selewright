# Selewright: A Unified Browser Automation Tool for Test Automation

## 🚀 What is Selewright?

Selewright is a lightweight abstraction layer built on top of **Selenium** and **Playwright**, designed for Browser Test Automation.

---

## 🔍 Why Choose Selewright?

### 🔁 Seamless Tool Switching

With Selewright, switching between **Selenium** and **Playwright** becomes seamless — *no code changes required* in your test suite.

> Why not stick with any one browser automation tool? [[Read here](https://medium.com/@krishna.d.hegde/selenium-vs-playwright-only-you-can-decide-068a01bb7081)]

### 🧠 Future-Proof Design

If a new browser automation tool takes over, Selewright can support it, allowing you to adopt it **without reworking your existing codebase**.

### ✂️ Reduced Boilerplate Code

Selewright includes built-in helper methods for Test Automation to:

- Simplify browser automation tasks
- Fetch/Mock browser APIs using POJOs
- Minimize repetitive code for developers

### ⏳ Auto-Wait Mechanism

Selewright brings **Playwright-like auto-waiting to Selenium**, ensuring more stable and reliable test executions.

---

## 🧱 Project Structure

- **Selewright**: The core interface for browser automation tools
- **PlaywrightImplementation**: Implements Selewright methods using Playwright
- **SeleniumImplementation**: Implements Selewright methods using Selenium
- **RequestConditionsToMock**: A POJO to define request conditions for mocking browser API calls
- **MockResponseToSend**: A POJO to define responses sent when mocking browser API calls
- **OtherHelpers**: Utility functions for common test automation tasks

---

## ⚙️ How to Use Selewright in Your Project

Selewright is written in **Java** and integrates easily with any test automation framework.
- JAR file: [[Download here](http://git.redbus.com/krishna.hegde/selewright/-/blob/05b7649e7619fb592b18c74eaa7070b21c17285c/selewright-1.0-SNAPSHOT.jar)]

### 📚 Setup Guide in a Maven Project
- Add Selenium and Playwright dependencies
- Selewright JAR Setup: [Guide Link](https://chatgpt.com/share/68d3ee72-6f90-8001-a11d-210d361dcece)

#### Work in Progress:
- JAR hosted on Maven Central
- Support for other programming languages (Python, JavaScript, C#)
- A Test automation project demonstrating in depth Selewright usage

## 💡 Tool Switch Sample Setup

```java
String automationTool = "selenium"; // or "playwright"
Selewright selewright = null;
if (automationTool.equalsIgnoreCase("selenium")) {
    WebDriver driver = new ChromeDriver();
    selewright = new SeleniumImplementation(driver);
} else if (automationTool.equalsIgnoreCase("playwright")){
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    BrowserContext context = browser.newContext();
    Page page = context.newPage();
    selewright = new PlaywrightImplementation(page);
}
selewright.openUrl("https://www.redbus.in");
```

## 🖋️ Acknowledgements

### Author: 
- [Krishna Hegde](https://www.linkedin.com/in/krishna-d-hegde/), Senior SDET, redBus

### Guided by:
- [Chandrashekar Patil](https://www.linkedin.com/in/patilchandrashekhar/), Senior Director - QA, redBus
- [Eesha Karanwal](https://www.linkedin.com/in/eesha-karanwal-1263461ab/), SDET Engineering Manager, redBus

### Contributors [Browser Test Automation Team, redBus]:
- [Smruti Sourav Sahoo](https://www.linkedin.com/in/smruti-sourav-2000/), SDET
- [Shon Noronha](https://www.linkedin.com/in/shon-noronha-07278820b/), SDET
- [Anuj Gaur](https://www.linkedin.com/in/anujgaur06/), SDET
- [Ayan Ray](https://www.linkedin.com/in/ayan-ray-69ba77141/), Senior SDET
- [Varun Singhai](https://www.linkedin.com/in/varun-singhai-64791814a/), Senior SDET
- [Shravya Acharya](https://www.linkedin.com/in/shravya-a-acharya-98b228183/), SDET
- [Pooja Benni](https://www.linkedin.com/in/pooja-benni-b1886571/), Senior QA
- [Sowmya Acharya](https://in.linkedin.com/in/sowmya-acharya-105a4025b), SDET
