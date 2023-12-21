## LDTS_<06><04> - Tower-Defense Game

Welcome to the thrilling world of our text-based Tower Defense game! Prepare for an epic battle as you take on waves of relentless monsters, strategically placing powerful towers along their path to defend your base. The fate of your realm lies in your hands, and it's time to showcase your tactical prowess! Choose wisely between three distinctive tower types: the precise Archer, the explosive Canon, or the mystical Mage. Craft a winning strategy that suits your playstyle and adapt to the evolving challenges with each incoming wave. As you successfully repel the monstrous hordes, earn valuable coins that unlock the potential for even mightier towers. Will you focus on fortifying your defenses or unleashing devastating attacks? Seize control of the battlefield by upgrading your towers and experimenting with different combinations. You're not just a player; you're the strategist determining the outcome of this epic showdown. However, tread carefully – if a relentless monster breaches your defenses and reaches your precious Chest, the danger intensifies. The survival of your Chest is paramount, as each defeated enemy contributes to an escalating score. Challenge yourself to surpass the highest scores and become the ultimate tower defense champion. It's not just about survival; it's about achieving greatness in the face of adversity. Good luck, strategist! The monsters are approaching, and the destiny of your realm awaits your skillful command. Have a blast defending and conquering!

This project was developed by David Carvalho (up202208654@fe.up.pt), Diogo Vieira (up202208723@fe.up.pt) and Tiago Pinto (up202206280@fe.up.pt) for LPOO 2023/24.


### IMPLEMENTED FEATURES

- **Tower Placement** - Place different types of towers, including Mage Tower, Archer Tower, and Canon Tower, at strategic positions on the game grid.
- **Different Enemys** - Creation of various enemy classes such as Orc, Skeleton, and Golem, each with unique attributes and behaviors.
- **Upgrades and Resources** - Allow players to upgrade towers and manage resources to enhance their defense capabilities.
- **Wave System** - Waves of enemies that increase in difficulty as the game progresses and the level player is.
- **Money System** - Players earn in-game currency by successfully defeating enemies. Each enemy defeated adds a certain amount of currency to the player's resources, creating a dynamic and rewarding system tied directly to player skill in battle.
- **Interactive Tower Selection Menu** - An interactive tower selection menu to empower players with more control over their strategic decisions.
- **Initial Control Menu** - An initial control menu that serves as the gateway for players to choose and engage with different levels within the game.
- **Different Levels** - The creation of diverse levels with varying degrees of difficulty.
- **Leaderboard Menu** - Includes a Leaderboard that keeps record of the best scores achieved by players.

### DESIGN

#### CODE DUPLICATION

**Problem in Context**

In the initial implementation of our tower-defense game, we encountered several challenges that impeded code maintainability and scalability. One issue was the lack of a structured approach to create diverse types of towers and enemies. This resulted in code duplication.

**The Pattern**

To solve this, we adopted the Factory Abstract pattern. By introducing abstract classes for towers and enemies, we created a framework that allowed the instantiation of various concrete objects without specifying their classes directly. This reduced redundancy and allowed a flexible foundation for extending the game with new tower and enemy types.

Furthermore, the Factory pattern proved fundamental in simplifying the process of tower and enemy creation. By encapsulating the object instantiation logic, the code became more modular and easier to comprehend. This modularization also facilitated future modifications without affecting the existing codebase. Additionally, to enhance overall code organization, we integrated the Model-View-Controller (MVC) pattern. This architectural design pattern segregated the game logic (Model), user interface (View), and user input (Controller) into distinct components. This separation improved code readability and enabled easier maintenance and scalability. Modifications to one component could be made without significantly impacting the others, what made the code more adaptable.

The implementation of the State pattern became inevitable as our game evolved. This design pattern proved invaluable in managing entity behavior by enabling dynamic changes in an object's behavior as its internal state evolved. Beyond its role in behavior management, the State pattern significantly contributed to extending the functionality of our game, providing a modular and scalable solution for handling different states.

To streamline hierarchical structures within the game world, we opted for the Composite pattern. This design pattern played a central role in organizing and managing complex relationships between entities. Notably, it facilitated the instantiation of both Enemies and Towers, providing a unified approach to handling individual entities and composite structures. The Composite pattern enhanced the maintainability and extensibility of our game architecture. Furthermore, the Builder pattern emerged as a powerful tool for constructing complex objects in a step-by-step manner. This pattern proved essential in the instantiation and configuration of various game elements. By using the Builder pattern, we achieved a clear and flexible construction process, allowing us to create intricate game objects with ease while maintaining code readability.

Finnaly, the Command pattern was instrumental in managing command queues, implementing undo/redo functionality, and handling user input seamlessly. By employing the Command pattern, we established a robust and modular system for executing and managing user commands, contributing to a more interactive and user-friendly gaming experience.

**Implementation**

The following UML class diagram illustrates how these patterns were applied.

![img](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/docs/UML.drawio.png)

These classes can be found in the following files:

- [Tower](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/src/main/java/org/example/model/game/elements/towers/Tower.java)
- [Enemy](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/src/main/java/org/example/model/game/elements/enemys/Enemy.java)
- [Element](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/src/main/java/org/example/model/game/elements/Element.java)
- [Position](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/src/main/java/org/example/model/game/Position.java)
- [Viewer](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/src/main/java/org/example/viewer/Viewer.java)
- [Arena](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/src/main/java/org/example/model/game/arena/Arena.java)

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

Code Coverage image:

![img](https://github.com/FEUP-LDTS-2023/project-l06gr04/blob/main/docs/Code%20Coverage.png)

### SELF-EVALUATION

In our collaborative effort to develop our tower-defense game, we organized the workload among the team members to ensure efficiency and specialization in different aspects of the project. Each student took responsibility for a specific group of implementations, contributing expertise to their respective areas: (Enemy and Projectiles, Arena and Window, Towers and Position).

- David Carvalho: 33,3%
- Diogo Vieira: 33,3%
- Tiago Pinto: 33,3%
