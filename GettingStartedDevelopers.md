

# Introduction #

This page will accelerate your development pace and enhance the quality of your work. In order to become a valuable contributor to the project and help StarCraft 2 gamers everywhere, it is important that you follow good development guidelines.

# Becoming a Committer #

To request commit privileges, you must first have something useful to commit to the code.  This may take the form of functionality, improved efficiency, GUI design, or something else.  Check out the source code if you need an idea of where to look for possible improvements.  After you have an idea of what form your contribution will take, contact Lomilar through one of these channels:

E-mail: fritley@gmail.com

TeamLiquid.net PM: Lomilar

IRC: Lomilar in #EvolutionChamber at irc.quakenet.org

# Helpful Tips for Starting Quick #

The program is run from EcSwingXMain.java.

# Development Guidelines #

Lomilar has laid out the following guidelines:

  1. If you do something different, place it in a different package. Provide, if you can, the option to use it or not. For instance, a redesign of the GUI should be placed in a separate package.
  1. Half-completed work in the trunk is acceptable, as long as it does not affect the way things currently work. There should be a clear and, preferably small, junction point to utilize the divergent code. Again, having separate packages helps to facilitate this.
  1. Learn and love refactoring. Never do the same thing twice, and if you do, think at least three times about it.

# Development Environment Setup Instructions #

The following instructions explain how to setup your development environment on Windows so that you can contribute to Evolution Chamber.

## Install Java ##

Evolution Chamber is written in Java.  Download and install JDK 1.6 from the following website.  Click the 'Download JDK' button in the 'Java Platform, Standard Edition' section.

http://www.oracle.com/technetwork/java/javase/downloads/index.html

## Install and Run Eclipse ##

If you want to contribute code to Evolution Chamber, it helps to have an IDE.  Evolution Chamber requires Eclipse to build the final JAR, but otherwise, you don't have to use Eclipse if you don't want to.

1. Download Eclipse IDE for Java Developers from the following website.

http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/heliossr1

2. Unzip Eclipse and navigate to the unzipped directory.  A good location to unzip Eclipse to is 'C:\Program Files\eclipse'.

3. Run eclipse.exe.

4. Choose a location for your workspace.  This will be where the Evolution Chamber source code resides.

## Set up SVN ##

In order to download the source code, you must install a plugin that allows Eclipse to connect to the SVN source code repository.

5. In Eclipse, go to Help>Install New Software.

6. Under 'Work with', select 'All Available Sites'.

7. Under 'type filter text', type in 'SVN'.

8. Wait for everything to load, then tick all the items that come up (items that have 'Subversive' or 'SVN' in their names).  Click 'Next'.

9. Click 'Next', accept the terms, then click 'Finish'.

10. When the install finishes, click 'Restart now'.

11. You should see 'Install connectors' dialog. Tick the 'SVN Kit' entry with the latest version (currently 1.3.2) and click 'Finish'.

12. Click 'Next' and then 'Next' again, accept the terms and click 'Finish'.

13. If there is a security warning, click 'OK'.

14. When finished, click 'Restart now'.

## Add the Evolution Chamber project ##

15. Go to File>Import...

16. Open the folder 'SVN', select 'Project from SVN' and click 'Next'.

17. Under 'URL', paste in http://evolutionchamber.googlecode.com/svn/trunk

18. Click 'Next' and then 'Yes'.

19. Under 'URL' paste in http://evolutionchamber.googlecode.com/svn/trunk.  Make sure 'Head Revision' is selected, and click 'Finish'.

20. In the 'Check out as' window, select 'Find projects in the children of the selected resource' and click 'Finish'.

21. Select 'Check out as a projects into workspace' and click 'Finish'.

22. If you get a password recovery prompt, click 'No'.

## Run Evolution Chamber ##

23. Go to Window>Show view>Package explorer.

24. You should see the EvolutionChamber project. Open the folder, then open 'src/java'.

25. Open the 'com.fray.evo.ui.swingx' package, click on 'EcSwingXMain.java' and then go to Run>Run (or the green arrow at the top).

# Building the Application #

Run the "create\_run\_jar" task in the "build.xml" Ant file.  This will generate the JAR used to run the application.  You must run this Ant file from Eclipse and it must run within the same JRE that Eclipse is running in:

  1. Right click on "build.xml" and select "Run As > Ant Build...".
  1. In the "JRE" tab, select "Run in the same JRE as the workspace".
  1. Click "Run".

It will create a file called "evolutionchamber.jar" inside the "output" folder.