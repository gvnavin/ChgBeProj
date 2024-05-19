# Credits Calculator App

This app helps you figure out how many credits you have left to use. You just need to provide some information about what you bought and how you used it.

## What You Need

- Java 8 or newer
- Gradle (to run the app)

## How to Use

1. **Prepare Your Data**: Make sure you have three files saved in a folder called `resources`:
   - `pricing_info.json`: Tells us how much each thing costs.
   - `purchase_info.json`: Lists what you bought and when.
   - `usage_info.json`: Shows what services you used.

2. **Run the App**: Goto Main.kt and give the input files names, output file name and then run the app. 
The output file name should ends with .json, since only json writer is implemented.
Note: For simplicity, skipped the code for reading the files names from cli as a parameters and parse it to get the required fields. 

3. **Check the Results**: The app will tell you how many credits you bought, how many you used, and how many you have left.
It will generate the available credits json report with the given file name in the working directory. 

## Example

Imagine you bought a package with 200 credits and another with 300 credits. You also used services that cost you 50 and 100 credits, respectively.

Running the app will tell you:

- You bought 500 credits.
- You used 150 credits.
- You have 350 credits left.


## Thought Process

1. **Understanding Requirements**: Understand the problem and get clarity on the application's goal of calculating remaining credits after purchases and usage.

2. **Task Breakdown**: Split the project into smaller tasks: reading data, separating input into config and data, storing it for further processing, performing calculations, displaying results and output report generation.

3. **Choosing Tools**: Selected Kotlin, the most productive & statically typed language with all functional elegance with easy to read and write, and Gradle for building the application.

4. **Planning Components**: Divided the application into distinct parts: data reading, input separation into config and data, storage, mathematical calculations and report generation.

5. **Input File Reader**: Wrote input file reader code with the flexibility to handling multiple input formats.

6. **Creating Data Models**: Developed simple data models, like prices and usage info, for easier data handling.

7. **Calculation Logic**: Defined the steps for calculating purchased, used, and remaining credits.

8. **Configuration Setup**: Ensured the application could handle different pricing by setting up a configuration management system.

9. **Data Handling**: Established methods for reading and storing purchase and usage information.

10. **Output Report Generation**: Wrote report generators with the flexibility to handle multiple output formats. 

11. **Testing**: Verified each part of the application using unit tests to ensure correct functionality.

12. **Integration**: Created a main function that ties all components together, reads data, performs calculations, and displays results.


## Design patterns

**Factory Pattern**:
Create objects without specifying the exact class. Implemented in `DaoFactory` and `ConfigFactory` to provide appropriate DAOs and configuration objects based on the underlying configuration.

**Strategy Pattern**:
Used different strategies for credit calculations to allow easy swapping of methods.

**Abstraction**:
Hide complex details, show only essential features, and separate the "what" from the "how." Defined interfaces like `PurchaseDao` and `UsageDao` to decouple the implementation details from the usage.

**Input and Output Flexibility**:
Utilized abstraction to handle various input and output file formats seamlessly. Implemented generic interfaces and abstract classes for input file readers and output file writers, allowing easy adaptation to different formats without tightly coupling the system to specific implementations.
