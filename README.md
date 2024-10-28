# Square One Insurance Website Testing

This project contains a suite of automated Selenium tests for the Square One Insurance website. The tests cover navigation and basic form validation, verifying that users can interact with essential features such as navigating to the "Home Insurance" page and attempting to get a quote.

## Technologies Used

- **Java**: Programming language for writing the test scripts.
- **JUnit**: Testing framework to define and run tests.
- **Selenium WebDriver**: Browser automation tool used for interacting with the website.
- **Safari WebDriver**: Used for testing on the Safari browser.

## Tests Included

1. **Home Insurance Navigation**: Verifies that clicking on "Home Insurance" correctly navigates to the Home Insurance page and checks the page title.
2. **Quote Form Validation**: Checks the behavior of the "Get a Quote" form when submitted with empty fields, expecting validation messages.
3. **Home Insurance Link Display**: Ensures that the "Home Insurance" link is displayed and functional.

## How to Run the Tests

1. Clone this repository.
2. Open the project in your preferred Java IDE.
3. Ensure Safari WebDriver is installed and set up.
4. Run the tests through the `Main` class or directly through JUnit.

Note: Adjustments might be needed depending on the WebDriver version and browser settings.
