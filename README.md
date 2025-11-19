## Welcome to Doodle Jump

Hi there! This is Conner Young and Josh Weeks, and welcome to our rough implementation of Doodle Jump! We chose to implement the game using a Model View Controller pattern.
Other major design choices included using inheritance from an abstract Platform class to create all Platform variations, making both the Doodle and Platform class more or less wrapper classes of the Javafx Rectangle class, and using the IScrollable interface to give only Scrolling Platforms the methods related to movement across the screen. All major functionalities entailed by the assignment are implemented in this program. The only known bug is slightly irregular speed on the Scrolling Platforms when the scene scrolls up. We did not attempt any extra credit.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
