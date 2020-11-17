# Bonus

## Automatic Save/Load Feature

### Team 13

#### Participants

- Eric Latham

### Description

I implemented a bonus feature that does the following things:

- automatically saves the root `ItemContainer` of the `Dashboard` every time a component is added, updated, or deleted
- automatically loads the previous saved root `ItemContainer` when the `Dashboard` is re-opened

This feature allows the `Dashboard` to "remember" its previous state so that the user does not have to recreate all of the desired farm items each time they run the application.

### Implementation

To implement this feature, I added static methods in the `ItemContainer` class for saving and loading `ItemContainer` objects via JSON serialization and deserialization.

```java
public static void saveJSON(ItemContainer itemContainer, String filePath);
```

I used the `saveJSON` method in the `DashboardController` class to save the root `ItemContainer` as a JSON string in a file named `rootItemContainer.json` whenever changes were made by the user.

```java
public static ItemContainer loadJSON(String filePath);
```

I used the `loadJSON` method in the `DashboardController` class to load the previous root `ItemContainer` (saved as a JSON string in `rootItemContainer.json` by `saveJSON`) whenever the `Dashboard` and `DashboardController` objects are initialized (which is whenever the application starts).

In both `saveJSON` and `loadJSON`, I leveraged the power of [the Gson library](https://github.com/google/gson) to serialize and deserialize `ItemComponent` objects to/from JSON. `Gson` is a popular tool used for Java object-JSON serialization and deserialization, and I found it easy to use, especially with the help of its excellent documentation.

Also, I added the required `Gson` jars as dependencies in the project so that there would be no need to import `Gson` manually when building and running the project.

### Repository Link

#### https://gitlab.cs.uab.edu/420/project2

### How To Run

(assuming you have **Eclipse IDE** and **Java JDK 8** installed)

- go to [https://gitlab.cs.uab.edu/420/project2](https://gitlab.cs.uab.edu/420/project2)
- clone this repository into `project2`
- open **Eclipse**
- select **File** -> **Import** -> **Existing Projects into Workspace** -> **Next** -> **Browse**
- locate the cloned `project2` directory in the filesystem dialogue and select to open it
- select **Finish**
- click the green play button labeled "Run" on the upper icon bar
- add some items and containers to the `Dashboard`
- close the `Dashboard` window
- click the green play button labeled "Run" on the upper icon bar again
- notice that all of the changes you made in the previous `Dashboard` session are still there!
