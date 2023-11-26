## LDTS_<06><04> - Tower-Defense Game

Welcome to our text-based Tower-Defense game! Defend your base against waves of monsters by strategically placing towers along their path. Earn coins by defeating monsters and use them to build even more powerful towers. Be careful, if a monster reaches your base, you will be in terrible danger. Reach the end with surviving health to win, or embrace the defeat if your health reaches zero.

This project was developed by David Carvalho (up202208654@fe.up.pt), Diogo Vieira (up202208723@fe.up.pt) and Tiago Pinto (up202206280@fe.up.pt) for LPOO 2023/24.


### IMPLEMENTED FEATURES

- **Tower Placement** - Place different types of towers, including Mage Tower, Archer Tower, and Canon Tower, at strategic positions on the game grid.
- **Different Enemys** - Creation of various enemy classes such as Orc, Skeleton, and Golem, each with unique attributes and behaviors.
- **Upgrades and Resources** - Allow players to upgrade towers and manage resources to enhance their defense capabilities.


### PLANNED FEATURES

- **Money System** - Players earn in-game currency by successfully defeating enemies. Each enemy defeated adds a certain amount of currency to the player's resources, creating a dynamic and rewarding system tied directly to player skill in battle.
- **Interactive Tower Selection Menu** - An interactive tower selection menu to empower players with more control over their strategic decisions.
- **Initial Control Menu** - An initial control menu that serves as the gateway for players to choose and engage with different levels within the game.
- **Different Levels** - The creation of diverse levels with varying degrees of difficulty.


### DESIGN

#### CODE DUPLICATION

**Problem in Context**

In the initial implementation of our tower-defense game, we encountered several challenges that impeded code maintainability and scalability. One issue was the lack of a structured approach to create diverse types of towers and enemies. This resulted in code duplication.

**The Pattern**

To solve this, we adopted the Factory Abstract pattern. By introducing abstract classes for towers and enemies, we created a framework that allowed the instantiation of various concrete objects without specifying their classes directly. This reduced redundancy and allowed a flexible foundation for extending the game with new tower and enemy types.

Furthermore, the Factory pattern proved fundamental in simplifying the process of tower and enemy creation. By encapsulating the object instantiation logic, the code became more modular and easier to comprehend. This modularization also facilitated future modifications without affecting the existing codebase. Additionally, to enhance overall code organization, we integrated the Model-View-Controller (MVC) pattern. This architectural design pattern segregated the game logic (Model), user interface (View), and user input (Controller) into distinct components. This separation improved code readability and enabled easier maintenance and scalability. Modifications to one component could be made without significantly impacting the others, what made the code more adaptable.

**Implementation**

The following UML class diagram illustrates how these patterns were applied.

![img](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/docs/yesss.drawio.png)

These classes can be found in the following files:

- [Tower](link-to-tower-class)
- [Enemy](link-to-enemy-class)
- [MageTowerStrategy](link-to-magetowerstrategy-class)
- [ArcherTowerStrategy](link-to-archertowerstrategy-class)
- [CanonTowerStrategy](link-to-canontowerstrategy-class)

**Consequences**

The use of the Factory Abstract pattern, Factory pattern, and Model-View-Controller pattern played a central role in overcoming initial implementation challenges, resulting in a more modular, scalable, and maintainable tower-defense game.


#### KNOWN CODE SMELLS

In the process of developing our tower-defense game, several code smells have emerged, indicating potential areas for improvement in the codebase. Addressing these code smells is crucial for maintaining a clean, efficient, and scalable game. Below, we outline three significant code smells that we have identified:

1. Monolithic Game Loop Function:
   The presence of a monolithic game loop function responsible for handling various game mechanics, such as spawning enemies, updating player resources, and managing towers.

2. Inconsistent Naming Conventions:
   The inconsistent naming of variables, functions, and classes throughout the codebase. In some instances, abbreviations and variations in naming conventions have been used, leading to confusion and decreased code readability.

3. Code Duplication in Enemy Behavior Handling:
   The duplication of code related to enemy behavior across different sections of the codebase. Similar logic for enemy movement, attack, and health management is repeated, leading to redundancy and increased chances of introducing bugs during updates or enhancements.


### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

In our collaborative effort to develop our tower-defense game, we organized the workload among the team members to ensure efficiency and specialization in different aspects of the project. Each student took responsibility for a specific group of implementations, contributing expertise to their respective areas: (Enemy and Projectiles, Arena and Window, Towers and Position).

- David Carvalho: 33%
- Diogo Vieira: 33%
- Tiago Pinto: 33%