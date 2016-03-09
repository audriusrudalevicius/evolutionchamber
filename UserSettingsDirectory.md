# User Settings directory #

When Evolution Chamber is run for the first time, it creates a user settings directory inside of the user's home directory named ".evolutionchamber".  The location of this directory varies depending on the operating system:

| Windows 2000, XP | `C:\Documents and Settings\username\.evolutionchamber` |
|:-----------------|:-------------------------------------------------------|
| Windows Vista, 7 | `C:\Users\username\.evolutionchamber`                  |
| Max OS X         | `/Users/username/.evolutionchamber`                    |
| Linux            | `/home/username/.evolutionchamber`                     |

This diagram shows the layout of this directory.  Each of the files and folders in the diagram are explained below.

```
.evolutionchamber
 |settings.properties
 |<version>
   |seeds.evo
   |seeds2.evo
```

# settings.properties #

The "settings.properties" file contains settings that are used to save the state of the application when the user exits Evolution Chamber.  The next time they run Evolution Chamber, their settings can be read from this file and restored.  Here is a sample, along with an explanation of each line.

```
#EvolutionChamber user settings file
#Sat Jan 15 18:10:42 EST 2011
locale=en
version=0023
gui.windowWidth=1497
gui.windowHeight=847
gui.windowExtendedState=0
```

| `#EvolutionChamber user settings file` | A description of the file. |
|:---------------------------------------|:---------------------------|
| `#Sat Jan 15 18:10:42 EST 2011`        | The date that the file was last modified. |
| `locale`                               | The language that the user has selected. |
| `version`                              | The version of Evolution Chamber that this settings file corresponds to (this is here incase we change the format of this settings file in a later version). |
| `gui.windowWidth`                      | The width (in pixels) of the window. |
| `gui.windowHeight`                     | The height (in pixels) of the window. |
| `gui.windowExtendedState`              | Whether or not the window is maximized or minimized. |

# History (seed) files #

Evolution Chamber also keeps a record of all the build orders that the user generated, called the History.  These are stored in a directory (which is inside of the user settings directory) named after the version of Evolution Chamber.  For example, if the user is running v0023, this directory will be named "0023".  It contains two files, "seeds.evo" and "seeds2.evo", which contain all previously-run build orders.  "seeds2.evo" is a copy of "seeds.evo" and is used for backup purposes.  Each file is a serialized `java.util.ArrayList` object that contains `com.fray.evo.EcBuildOrder` objects.  When the user deletes a History entry from the application, the corresponding build order is deleted from these two files.